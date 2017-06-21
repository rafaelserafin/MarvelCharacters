package rsddm.com.br.marvelcharacters.Model.Marvel.Stories;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class StorySummaryModel {
    /***
     * resourceURI (string, optional): The path to the individual story resource.,
     * name (string, optional): The canonical name of the story.,
     * type (string, optional): The type of the story (interior or cover).
     */

    //region Properties
    private String resourceURI;
    private String name;
    private String type;
    //endregion Properties

    //region Getters

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    //endregion Getters

    //region Setters

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    //endregion Setters
}
