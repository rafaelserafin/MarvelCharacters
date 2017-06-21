package rsddm.com.br.marvelcharacters.CoreUtils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class JsonUtil {
    public static <T> T jsonToModel(JSONObject jsonObject, Class<T> model) throws JSONException {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject.toString(), model);
    }
}
