package cyou.zhaojin.controller;

import cyou.zhaojin.constants.Result;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zhao JIN
 */
@Controller
public class BaseController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/analyze")
    public String analyze(String demand, Model model){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(demand, headers);
            Result result = restTemplate.postForObject("http://localhost:8001/doExtract", request, Result.class);
            System.out.println(result);
            model.addAttribute("code", result.getCode());
            model.addAttribute("message", result.getMessage().replace('_', ' '));
            return "result";
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(Result.SERVICE_NOT_AVAILABLE.getMessage().replace('_', ' '));
            model.addAttribute("message", Result.SERVICE_NOT_AVAILABLE.getMessage().replace('_', ' '));
            return "result";
        }
    }
}
