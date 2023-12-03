package cyou.zhaojin.service.impl;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.service.PropertyEvaluation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author Zhao JIN
 */

@Service
@Log4j2
public class PropertyEvaluationImpl implements PropertyEvaluation {
    @Override
    public boolean doEvaluate(Client client) {
        return dataAnalysis(client) && inspection(client) && legal(client);
    }

    private boolean dataAnalysis(Client client) {
        log.info("This part will be replaced by a real data analysis system");
        return true;
    }

    private boolean inspection(Client client) {
        log.info("This part will be replaced by a real inspection system");
        return true;
    }

    private boolean legal(Client client) {
        log.info("This part will be replaced by a real legal system");
        return true;
    }
}
