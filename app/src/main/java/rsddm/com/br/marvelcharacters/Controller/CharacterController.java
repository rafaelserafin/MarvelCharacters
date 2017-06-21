package rsddm.com.br.marvelcharacters.Controller;

import android.content.Context;

import rsddm.com.br.marvelcharacters.Interface.OnGetCharacterCollectionsListener;
import rsddm.com.br.marvelcharacters.Interface.OnGetCharactersListener;
import rsddm.com.br.marvelcharacters.WSCommunication.CharactersWS;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class CharacterController {

    private CharactersWS charactersWS;
    private Context context;

    public CharacterController(Context context){
        charactersWS = new CharactersWS(context);
        this.context = context;
    }

    public void GetCharacters(int limit, int offset, OnGetCharactersListener onGetCharactersListener){
        charactersWS.GetCharacters(limit, offset, onGetCharactersListener);
    }

    public void GetCharacterCollections(int characterId, OnGetCharacterCollectionsListener onGetCharacterCollectionsListener){
        CharactersWS wsComics = new CharactersWS(context);
        wsComics.GetCharacterComics(characterId, onGetCharacterCollectionsListener);

        CharactersWS wsEvents = new CharactersWS(context);
        wsEvents.GetCharacterEvents(characterId, onGetCharacterCollectionsListener);

        CharactersWS wsSeries = new CharactersWS(context);
        wsSeries.GetCharacterSeries(characterId, onGetCharacterCollectionsListener);

        charactersWS.GetCharacterStories(characterId, onGetCharacterCollectionsListener);
    }
}
