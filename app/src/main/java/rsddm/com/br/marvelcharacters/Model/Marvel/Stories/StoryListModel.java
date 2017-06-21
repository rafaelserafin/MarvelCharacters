package rsddm.com.br.marvelcharacters.Model.Marvel.Stories;

import java.util.List;


/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class StoryListModel {

    /***
     * available (int, optional): The number of total available stories in this list. Will always be greater than or equal to the "returned" value.,
     * returned (int, optional): The number of stories returned in this collection (up to 20).,
     * collectionURI (string, optional): The path to the full list of stories in this collection.,
     * items (Array[StorySummary], optional): The list of returned stories in this collection.
     */

    //region Properties
    private int available;
    private int returned;
    private String collectionURI;
    private List<StorySummaryModel> items;
    //endregion Properties

    //region Getters

    public int getAvailable() {
        return available;
    }

    public int getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<StorySummaryModel> getItems() {
        return items;
    }

    //endregion Getters

    //region Setters

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public void setItems(List<StorySummaryModel> items) {
        this.items = items;
    }

    //endregion Setters
}
