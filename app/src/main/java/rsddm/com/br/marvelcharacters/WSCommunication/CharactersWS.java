package rsddm.com.br.marvelcharacters.WSCommunication;

import android.content.Context;

import org.json.JSONException;

import java.util.Calendar;

import rsddm.com.br.marvelcharacters.CoreUtils.HashUtil;
import rsddm.com.br.marvelcharacters.CoreUtils.JsonUtil;
import rsddm.com.br.marvelcharacters.Interface.OnGetCharacterCollectionsListener;
import rsddm.com.br.marvelcharacters.Interface.OnGetCharactersListener;
import rsddm.com.br.marvelcharacters.Model.Marvel.Characters.CharacterDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Comics.ComicDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Events.EventDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Series.SeriesDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Stories.StoryDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.WS.ResponseModel;
import rsddm.com.br.marvelcharacters.R;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */

public class CharactersWS extends BaseRequest {

    public CharactersWS(Context context){
        super(context);
    }

    public void GetCharacters(final int limit, final int offset, final OnGetCharactersListener onGetCharactersListener){

        new Thread(new Runnable() {
            @Override
            public void run() {
                long ts = Calendar.getInstance().getTimeInMillis();
                String hash = HashUtil.md5(ts+context.getString(R.string.marvel_private_key)+context.getString(R.string.marvel_public_key));

                ResponseModel responseModel = CreateRequest("/characters?")
                        .setRequestMethod(RequestMethod.GET)
                        .addParameterRequest("ts", ts)
                        .addParameterRequest("apikey", context.getString(R.string.marvel_public_key))
                        .addParameterRequest("hash", hash)
                        .addParameterRequest("limit", limit)
                        .addParameterRequest("offset", offset)
                        .makeRequest();

                CharacterDataWrapperModel characterDataWrapperModel = null;
                if(responseModel.isSuccess()){

                    try {
                        characterDataWrapperModel = JsonUtil.jsonToModel(responseModel.getJsonObject(), CharacterDataWrapperModel.class);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        responseModel.setSuccess(false);
                        responseModel.setMessage(e.getMessage());
                    }
                }

                if(onGetCharactersListener != null){
                    onGetCharactersListener.onGetCharactes(responseModel.isSuccess(), characterDataWrapperModel);
                }


            }
        }).start();

    }

    public void GetCharacterComics(final int characterId, final OnGetCharacterCollectionsListener onGetCharacterCollectionsListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long ts = Calendar.getInstance().getTimeInMillis();
                String hash = HashUtil.md5(ts+context.getString(R.string.marvel_private_key)+context.getString(R.string.marvel_public_key));

                ResponseModel responseModel = CreateRequest(String.format("/characters/%s/comics?", characterId))
                        .setRequestMethod(RequestMethod.GET)
                        .addParameterRequest("ts", ts)
                        .addParameterRequest("apikey", context.getString(R.string.marvel_public_key))
                        .addParameterRequest("hash", hash)
                        .makeRequest();

                ComicDataWrapperModel comicDataWrapperModel = null;
                if(responseModel.isSuccess()){

                    try {
                        comicDataWrapperModel = JsonUtil.jsonToModel(responseModel.getJsonObject(), ComicDataWrapperModel.class);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        responseModel.setSuccess(false);
                        responseModel.setMessage(e.getMessage());
                    }
                }

                if(onGetCharacterCollectionsListener != null){
                    onGetCharacterCollectionsListener.onGetComics(comicDataWrapperModel);
                }


            }
        }).start();
    }

    public void GetCharacterEvents(final int characterId, final OnGetCharacterCollectionsListener onGetCharacterCollectionsListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long ts = Calendar.getInstance().getTimeInMillis();
                String hash = HashUtil.md5(ts+context.getString(R.string.marvel_private_key)+context.getString(R.string.marvel_public_key));

                ResponseModel responseModel = CreateRequest(String.format("/characters/%s/events?", characterId))
                        .setRequestMethod(RequestMethod.GET)
                        .addParameterRequest("ts", ts)
                        .addParameterRequest("apikey", context.getString(R.string.marvel_public_key))
                        .addParameterRequest("hash", hash)
                        .makeRequest();

                EventDataWrapperModel eventDataWrapperModel = null;
                if(responseModel.isSuccess()){

                    try {
                        eventDataWrapperModel = JsonUtil.jsonToModel(responseModel.getJsonObject(), EventDataWrapperModel.class);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        responseModel.setSuccess(false);
                        responseModel.setMessage(e.getMessage());
                    }
                }

                if(onGetCharacterCollectionsListener != null){
                    onGetCharacterCollectionsListener.onGetEvents(eventDataWrapperModel);
                }


            }
        }).start();

    }

    public void GetCharacterSeries(final int characterId, final OnGetCharacterCollectionsListener onGetCharacterCollectionsListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                long ts = Calendar.getInstance().getTimeInMillis();
                String hash = HashUtil.md5(ts+context.getString(R.string.marvel_private_key)+context.getString(R.string.marvel_public_key));

                ResponseModel responseModel = CreateRequest(String.format("/characters/%s/series?", characterId))
                        .setRequestMethod(RequestMethod.GET)
                        .addParameterRequest("ts", ts)
                        .addParameterRequest("apikey", context.getString(R.string.marvel_public_key))
                        .addParameterRequest("hash", hash)
                        .makeRequest();

                SeriesDataWrapperModel seriesDataWrapperModel = null;
                if(responseModel.isSuccess()){

                    try {
                        seriesDataWrapperModel = JsonUtil.jsonToModel(responseModel.getJsonObject(), SeriesDataWrapperModel.class);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        responseModel.setSuccess(false);
                        responseModel.setMessage(e.getMessage());
                    }
                }

                if(onGetCharacterCollectionsListener != null){
                    onGetCharacterCollectionsListener.onGetSeries(seriesDataWrapperModel);
                }


            }
        }).start();
    }

    public void GetCharacterStories(final int characterId, final OnGetCharacterCollectionsListener onGetCharacterCollectionsListener){

        new Thread(new Runnable() {
            @Override
            public void run() {
                long ts = Calendar.getInstance().getTimeInMillis();
                String hash = HashUtil.md5(ts+context.getString(R.string.marvel_private_key)+context.getString(R.string.marvel_public_key));

                ResponseModel responseModel = CreateRequest(String.format("/characters/%s/series?", characterId))
                        .setRequestMethod(RequestMethod.GET)
                        .addParameterRequest("ts", ts)
                        .addParameterRequest("apikey", context.getString(R.string.marvel_public_key))
                        .addParameterRequest("hash", hash)
                        .makeRequest();

                StoryDataWrapperModel storyDataWrapperModel= null;
                if(responseModel.isSuccess()){

                    try {
                        storyDataWrapperModel = JsonUtil.jsonToModel(responseModel.getJsonObject(), StoryDataWrapperModel.class);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        responseModel.setSuccess(false);
                        responseModel.setMessage(e.getMessage());
                    }
                }

                if(onGetCharacterCollectionsListener != null){
                    onGetCharacterCollectionsListener.onGetStories(storyDataWrapperModel);
                }


            }
        }).start();

    }
}
