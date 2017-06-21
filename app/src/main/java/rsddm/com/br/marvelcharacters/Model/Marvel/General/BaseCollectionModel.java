package rsddm.com.br.marvelcharacters.Model.Marvel.General;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class BaseCollectionModel {

    /***
     * id (int, optional): The unique ID of the story resource.,
     * title (string, optional): The story title.,
     * description (string, optional): A short description of the story.,
     * resourceURI (string, optional): The canonical URL identifier for this resource.,
     * modified (Date, optional): The date the resource was most recently modified.,
     * thumbnail (Image, optional): The representative image for this story.,
     */

    //region Properties
    private int id;
    private String title;
    private String description;
    private String resourceURI;
    private String modified;
    private ImageModel thumbnail;
    //endregion Properties

    //region Getters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public String getModified() {
        return modified;
    }

    public ImageModel getThumbnail() {
        return thumbnail;
    }

    //endregion Getters

    //region Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setThumbnail(ImageModel thumbnail) {
        this.thumbnail = thumbnail;
    }


    //endregion Setters


}
