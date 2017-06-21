package rsddm.com.br.marvelcharacters.Model.WS;

import org.json.JSONObject;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */
public class ResponseModel {

    //region Properties
    private boolean success;
    private JSONObject jsonObject;
    private String message;
    //endregion Properties

    //region Getters
    public boolean isSuccess() {
        return success;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public String getMessage() {
        return message;
    }

    //endregion Getters

    //region Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //endregion Setters
}
