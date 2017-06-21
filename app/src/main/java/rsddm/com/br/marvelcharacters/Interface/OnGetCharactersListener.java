package rsddm.com.br.marvelcharacters.Interface;

import rsddm.com.br.marvelcharacters.Model.Marvel.Characters.CharacterDataWrapperModel;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */

public interface OnGetCharactersListener {
    void onGetCharactes(boolean success, CharacterDataWrapperModel characterDataWrapperModel);
}
