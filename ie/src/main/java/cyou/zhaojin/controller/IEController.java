package cyou.zhaojin.controller;

import cyou.zhaojin.constants.Result;
import cyou.zhaojin.service.InformationExtraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhao JIN
 */
@Controller
public class IEController {
    private InformationExtraction informationExtraction;

    @Autowired
    public void setIe(InformationExtraction informationExtraction) {
        this.informationExtraction = informationExtraction;
    }

    @PostMapping("/doExtract")
    @ResponseBody
    public ResponseEntity<Result> doExtract(@RequestBody String data) {
        return ResponseEntity.ok(informationExtraction.doExtract(data));
    }
}
