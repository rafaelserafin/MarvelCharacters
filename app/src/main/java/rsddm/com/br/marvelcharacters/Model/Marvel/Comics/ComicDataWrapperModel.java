package rsddm.com.br.marvelcharacters.Model.Marvel.Comics;

import rsddm.com.br.marvelcharacters.Model.Marvel.General.BaseCollectionModel;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class ComicDataWrapperModel extends BaseCollectionModel{

    /***
     * code (int, optional): The HTTP status code of the returned result.,
     * status (string, optional): A string description of the call status.,
     * copyright (string, optional): The copyright notice for the returned result.,
     * attributionText (string, optional): The attribution notice for this result. Please display either this notice or the contents of the attributionHTML field on all screens which contain data from the Marvel Comics API.,
     * attributionHTML (string, optional): An HTML representation of the attribution notice for this result. Please display either this notice or the contents of the attributionText field on all screens which contain data from the Marvel Comics API.,
     * data (ComicDataContainer, optional): The results returned by the call.,
     * etag (string, optional): A digest value of the content returned by the call.
     */

    //region Properties
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private ComicDataContainerModel data;
    private String etag;
    //endregion Properties

    //region Getters

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public ComicDataContainerModel getData() {
        return data;
    }

    public String getEtag() {
        return etag;
    }

    //endregion Getters

    //region Setters

    public void setCode(int code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public void setData(ComicDataContainerModel data) {
        this.data = data;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    //endregion Setters
}
