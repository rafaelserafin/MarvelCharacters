package rsddm.com.br.marvelcharacters.Model.Marvel.Events;

import java.util.List;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class EventListModel {

    /***
     * available (int, optional): The number of total available events in this list. Will always be greater than or equal to the "returned" value.,
     * returned (int, optional): The number of events returned in this collection (up to 20).,
     * collectionURI (string, optional): The path to the full list of events in this collection.,
     * items (Array[EventSummary], optional): The list of returned events in this collection.
     */

    //region Properties
    private int available;
    private int returned;
    private String collectionURI;
    private List<EventSummaryModel> items;
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

    public List<EventSummaryModel> getItems() {
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

    public void setItems(List<EventSummaryModel> items) {
        this.items = items;
    }

    //endregion Setters
}
