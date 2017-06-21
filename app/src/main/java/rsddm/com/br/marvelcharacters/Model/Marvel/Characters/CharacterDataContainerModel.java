package rsddm.com.br.marvelcharacters.Model.Marvel.Characters;

import java.util.List;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */

public class CharacterDataContainerModel {

    /***
     * offset (int, optional): The requested offset (number of skipped results) of the call.
     * limit (int, optional): The requested result limit.
     * total (int, optional): The total number of resources available given the current filter set.
     * count (int, optional): The total number of results returned by this call.
     * results (Array[Character], optional): The list of characters returned by the call.
     */

    //region Properties
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<CharacterModel> results;
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

    public List<CharacterModel> getResults() {
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

    public void setResults(List<CharacterModel> results) {
        this.results = results;
    }

    //endregion Setters
}
