package cyou.zhaojin.service.impl;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.bean.ClientRequest;
import cyou.zhaojin.constants.Result;
import cyou.zhaojin.dao.ClientDao;
import cyou.zhaojin.service.InformationExtraction;
import cyou.zhaojin.utility.IEUtils;
import cyou.zhaojin.utility.Pair;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zhao JIN
 */
@Service
@Log4j2
public class InformationExtractionImpl implements InformationExtraction {
    private ClientDao clientDao;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Result doExtract(String data) {
        String newData = IEUtils.pretreat(data);
        Pair<Result, Client> result = IEUtils.extract(newData);
        if (result.first().getCode() != Result.SUCCESS_CODE) {
            return result.first();
        }
        Client client = result.second();
        clientDao.saveClient(client);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Client> request = new HttpEntity<>(client, headers);
            boolean svResult = Boolean.TRUE.equals(restTemplate.postForObject("http://localhost:8002/doVerify", request, Boolean.class));

            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            request = new HttpEntity<>(client, headers);
            boolean peResult = Boolean.TRUE.equals(restTemplate.postForObject("http://localhost:8003/doEvaluate", request, Boolean.class));

            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ClientRequest> cliRequest = new HttpEntity<>(new ClientRequest(client, svResult, peResult), headers);
            return restTemplate.postForObject("http://localhost:8004/doDecision", cliRequest, Result.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.SERVICE_NOT_AVAILABLE;
        }
    }
}
