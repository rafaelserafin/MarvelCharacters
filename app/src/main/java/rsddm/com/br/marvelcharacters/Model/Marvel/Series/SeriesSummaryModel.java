package rsddm.com.br.marvelcharacters.Model.Marvel.Series;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class SeriesSummaryModel {

    /***
     * resourceURI (string, optional): The path to the individual series resource.,
     * name (string, optional): The canonical name of the series.
     */

    //region Properties
    private String resourceURI;
    private String name;
    //endregion Properties

    //region Getters

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    //endregion Getters

    //region Setters

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion Setters
}
