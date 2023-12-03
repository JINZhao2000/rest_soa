package cyou.zhaojin.controller;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.service.PropertyEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Zhao JIN
 */
@Controller
public class PEController {
    private PropertyEvaluation propertyEvaluation;

    @Autowired
    public void setPropertyEvaluation(PropertyEvaluation propertyEvaluation) {
        this.propertyEvaluation = propertyEvaluation;
    }

    @PostMapping("/doEvaluate")
    public ResponseEntity<Boolean> doEvaluate(@RequestBody Client client) {
        return ResponseEntity.ok(propertyEvaluation.doEvaluate(client));
    }
}
