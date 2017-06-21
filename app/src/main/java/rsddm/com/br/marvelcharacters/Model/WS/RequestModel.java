package rsddm.com.br.marvelcharacters.Model.WS;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */
public class RequestModel {

    //region Preperties
    private String urlRequest;
    private String content;
    //endregion Preperties

    //region Getters
    public String getUrlRequest() {
        return urlRequest;
    }

    public String getContent() {
        return content;
    }
    //endregion Getters

    //region Setters
    public void setUrlRequest(String urlRequest) {
        this.urlRequest = urlRequest;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //endregion Setters

}
