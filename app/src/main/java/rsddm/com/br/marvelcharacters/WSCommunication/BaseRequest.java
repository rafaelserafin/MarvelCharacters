package rsddm.com.br.marvelcharacters.WSCommunication;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import rsddm.com.br.marvelcharacters.Model.WS.ResponseModel;
import rsddm.com.br.marvelcharacters.R;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */

public abstract class BaseRequest {

    private URL urlRequest;
    private HttpURLConnection urlConnRequest;
    private List<Pair<String, String>> paramsList;
    private List<Pair<String, String>> propertiesList;
    private int requestTimeout = 30000;
    private String url;
    private RequestMethod requestMethod = RequestMethod.GET;
    private String content;
    protected Context context;

    protected String urlBase;

    public BaseRequest(Context context) {
        this.context = context;
        this.urlBase = context.getString(R.string.url_marvel_base);
    }

    /**
     * This method create a request
     *
     * @param url Url for make request
     * @return this class
     */
    public BaseRequest CreateRequest(String url) {
        this.url = url;
        paramsList = new ArrayList<>();
        propertiesList = new ArrayList<>();

        return this;
    }

    /**
     * This method set type request
     *
     * @param requestMethod Type request GET/POST
     * @return this class
     */
    public BaseRequest setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;

        return this;
    }

    /**
     * This method add parameters for make request
     *
     * @param name  Name of parameter
     * @param value Value of parameter
     * @return this class
     */
    public BaseRequest addParameterRequest(String name, Object value) {
        paramsList.add(new Pair<String, String>(name, String.valueOf(value)));
        return this;
    }

    /**
     * This method add properties to request
     *
     * @param key   Key of property
     * @param value Value of property
     * @return this class
     */
    public BaseRequest addPropertieRequest(String key, String value) {
        //urlConnRequest.addRequestProperty(key, value);
        propertiesList.add(new Pair<String, String>(key, value));
        return this;
    }

    /**
     * This set set only one propertie to request
     *
     * @param key   Key of proeperty
     * @param value Value of property
     * @return this class
     */
    public BaseRequest setPropertieRequest(String key, String value) {
        //urlConnRequest.setRequestProperty(key, value);
        propertiesList.add(new Pair<String, String>(key, value));
        return this;
    }

    /**
     * This method set content to request, when request no contains parameters but a json or xml
     *
     * @param content Content to request
     * @return this class
     */
    public BaseRequest setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * Set timeout to request
     *
     * @param timeout time in milliseconds
     * @return this class
     */
    public BaseRequest setTimeout(int timeout) {
        this.requestTimeout = timeout;
        return this;
    }

    /**
     * This method effectively make the request and return an object when content of request.
     *
     * @return ResponseModel
     */
    public ResponseModel makeRequest() {

        ResponseModel responseModel = new ResponseModel();

        try {

            if (!url.startsWith("https://")) {
                url = getUrl(url);
            }

            if (requestMethod == RequestMethod.GET) {
                urlRequest = new URL(String.format("%s%s", url, getQuery(paramsList)));
            } else {
                urlRequest = new URL(url);
            }


            urlConnRequest = (HttpURLConnection) urlRequest.openConnection();

            urlConnRequest.setRequestMethod(requestMethod.toString());

            for (Pair<String, String> prop : propertiesList) {
                urlConnRequest.addRequestProperty(prop.first, prop.second);
            }

            if (requestMethod == RequestMethod.POST) {
                urlConnRequest.setDoInput(true);
                urlConnRequest.setDoOutput(true);
                urlConnRequest.setUseCaches(false);
                //urlConnRequest.setRequestProperty("Content-Type", "text/json");

                OutputStreamWriter out = new OutputStreamWriter(urlConnRequest.getOutputStream());
                if (content != null && !content.isEmpty())
                    out.write(content);
                else
                    out.write(getQuery(paramsList));

                out.flush();
                out.close();
            }

            urlConnRequest.setConnectTimeout(requestTimeout);
            urlConnRequest.setReadTimeout(requestTimeout);

            urlConnRequest.connect();

            StringBuilder sb = new StringBuilder();
            int HttpResult = urlConnRequest.getResponseCode();

            boolean success = false;

            InputStream inputStream;
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                success = true;
                inputStream = urlConnRequest.getInputStream();
            } else
                inputStream = urlConnRequest.getErrorStream();

            if (inputStream != null) {

                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
            } else {
                Log.d("RETORNO", urlConnRequest.getResponseMessage());
            }

            if(content != null)
                Log.d("RETORNO", content);

            Log.d("RETORNO", sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            responseModel.setJsonObject(jsonObject);
            responseModel.setSuccess(success);
        } catch (IOException e) {
            e.printStackTrace();

            responseModel.setSuccess(false);
            responseModel.setMessage(e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();

            responseModel.setSuccess(false);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }

    private String getUrl(String methodName) {
        return urlBase + methodName;
    }

    private String getQuery(List<Pair<String, String>> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Pair<String, String> pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.first, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.second, "UTF-8"));
        }

        return result.toString();
    }

    public enum RequestMethod {
        GET("GET"),
        POST("POST");

        private String stringValue;

        private RequestMethod(String toString) {
            stringValue = toString;
        }

        @Override
        public String toString() {
            return stringValue;
        }


        public static RequestMethod parseEnum(String value) {
            RequestMethod[] ir = RequestMethod.values();

            for (RequestMethod i : ir) {
                if (i.toString().equals(value.toLowerCase()))
                    return i;
            }

            return null;
        }
    }


}
