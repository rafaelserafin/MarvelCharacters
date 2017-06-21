package rsddm.com.br.marvelcharacters.Model.Marvel.General;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class ImageModel {

    /***
     * path (string, optional): The directory path of to the image.,
     * extension (string, optional): The file extension for the image.
     */

    //region Properties
    private String path;
    private String extension;
    //endregion Properties

    //region Getters

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    //endregion Getters

    //region Setters

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    //endregion Setters

    //region Methods
    public String getUrlImageLandscape(){
        return String.format("%s/landscape_xlarge.%s", this.getPath(), this.getExtension());

    }

    public String getUrlImagePortrait(){
        return String.format("%s/portrait_xlarge.%s", this.getPath(), this.getExtension());

    }

    public String getUrlImageStandard(){
        return String.format("%s/standard_large.%s", this.getPath(), this.getExtension());

    }

    public String getUrlFullSize(){
        return String.format("%s.%s", this.getPath(), this.getExtension());
    }
    //endregion Methods
}
