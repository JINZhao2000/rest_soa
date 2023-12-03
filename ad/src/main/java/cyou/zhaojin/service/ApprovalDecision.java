package cyou.zhaojin.service;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.constants.Result;

/**
 * @author Zhao JIN
 */

public interface ApprovalDecision {
    Result decision(Client client, boolean credit, boolean prop);
}
