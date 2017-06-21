package rsddm.com.br.marvelcharacters.Model.Marvel.Events;

import java.util.List;

import rsddm.com.br.marvelcharacters.Model.Marvel.Comics.ComicModel;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class EventDataContainerModel {
    /***
     * offset (int, optional): The requested offset (number of skipped results) of the call.,
     * limit (int, optional): The requested result limit.,
     * total (int, optional): The total number of resources available given the current filter set.,
     * count (int, optional): The total number of results returned by this call.,
     * results (Array[Event], optional): The list of events returned by the call
     */

    //region Properties
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<EventModel> results;
    //endregion Properties

    //region Getters

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<EventModel> getResults() {
        return results;
    }

    //endregion Getters

    //region Setters

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResults(List<EventModel> results) {
        this.results = results;
    }

    //endregion Setters
}
