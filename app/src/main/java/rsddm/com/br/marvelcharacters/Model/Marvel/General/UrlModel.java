package rsddm.com.br.marvelcharacters.Model.Marvel.General;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class UrlModel {

    /***
     * type (string, optional): A text identifier for the URL.,
     * url (string, optional): A full URL (including scheme, domain, and path).
     */

    //region Properties
    private String type;
    private String url;
    //endregion Properties

    //region Getters

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    //endregion Getters

    //region Setters

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //endregion Setters
}
