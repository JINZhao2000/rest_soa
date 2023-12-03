package cyou.zhaojin.controller;

import cyou.zhaojin.bean.ClientRequest;
import cyou.zhaojin.constants.Result;
import cyou.zhaojin.service.ApprovalDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Zhao JIN
 */
@Controller
public class ADController {
    private ApprovalDecision approvalDecision;

    @Autowired
    public void setApprovalDecision(ApprovalDecision approvalDecision) {
        this.approvalDecision = approvalDecision;
    }

    @PostMapping("/doDecision")
    public ResponseEntity<Result> doDecision(@RequestBody ClientRequest request) {
        return ResponseEntity.ok(approvalDecision.decision(request.getClient(), request.isSvResult(), request.isPeResult()));
    }
}
