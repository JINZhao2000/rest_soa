package cyou.zhaojin.controller;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.service.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Zhao JIN
 */
@Controller
public class SVController {
    private Verification verification;

    @Autowired
    public void setVerification(Verification verification) {
        this.verification = verification;
    }

    @PostMapping("/doVerify")
    public ResponseEntity<Boolean> doVerify(@RequestBody Client client) {
        return ResponseEntity.ok(verification.doVerify(client));
    }
}
