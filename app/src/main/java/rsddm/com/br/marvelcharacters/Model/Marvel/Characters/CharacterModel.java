package rsddm.com.br.marvelcharacters.Model.Marvel.Characters;

import java.util.List;

import rsddm.com.br.marvelcharacters.Model.Marvel.Comics.ComicListModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Events.EventListModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.General.ImageModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.General.UrlModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Series.SeriesListModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Stories.StoryListModel;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */

public class CharacterModel {

    /***
     * id (int, optional): The unique ID of the character resource.,
     * name (string, optional): The name of the character.,
     * description (string, optional): A short bio or description of the character.,
     * modified (Date, optional): The date the resource was most recently modified.,
     * resourceURI (string, optional): The canonical URL identifier for this resource.,
     * urls (Array[Url], optional): A set of public web site URLs for the resource.,
     * thumbnail (Image, optional): The representative image for this character.,
     * comics (ComicList, optional): A resource list containing comics which feature this character.,
     * stories (StoryList, optional): A resource list of stories in which this character appears.,
     * events (EventList, optional): A resource list of events in which this character appears.,
     * series (SeriesList, optional): A resource list of series in which this character appears.
     */

    //region Properties
    private int id;
    private String name;
    private String description;
    private String modified;
    private String resourceURI;
    private List<UrlModel> urls;
    private ImageModel thumbnail;
    private ComicListModel comics;
    private StoryListModel stories;
    private EventListModel events;
    private SeriesListModel series;
    //endregion Properties

    //region Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public List<UrlModel> getUrls() {
        return urls;
    }

    public ImageModel getThumbnail() {
        return thumbnail;
    }

    public ComicListModel getComics() {
        return comics;
    }

    public StoryListModel getStories() {
        return stories;
    }

    public EventListModel getEvents() {
        return events;
    }

    public SeriesListModel getSeries() {
        return series;
    }

    //endregion Getters

    //region Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public void setUrls(List<UrlModel> urls) {
        this.urls = urls;
    }

    public void setThumbnail(ImageModel thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setComics(ComicListModel comics) {
        this.comics = comics;
    }

    public void setStories(StoryListModel stories) {
        this.stories = stories;
    }

    public void setEvents(EventListModel events) {
        this.events = events;
    }

    public void setSeries(SeriesListModel series) {
        this.series = series;
    }

    //endregion Setters
}
