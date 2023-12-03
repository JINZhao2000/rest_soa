package cyou.zhaojin.bean;

/**
 * @author Zhao JIN
 */
public class ClientRequest {
    private Client client;
    private boolean svResult;
    private boolean peResult;

    public ClientRequest() {}

    public ClientRequest(Client client, boolean svResult, boolean peResult) {
        this.client = client;
        this.svResult = svResult;
        this.peResult = peResult;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isSvResult() {
        return svResult;
    }

    public void setSvResult(boolean svResult) {
        this.svResult = svResult;
    }

    public boolean isPeResult() {
        return peResult;
    }

    public void setPeResult(boolean peResult) {
        this.peResult = peResult;
    }
}
