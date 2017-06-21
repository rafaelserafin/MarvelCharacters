package rsddm.com.br.marvelcharacters.Interface;

import android.widget.ImageView;

import rsddm.com.br.marvelcharacters.Model.Marvel.Characters.CharacterModel;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public interface OnCharacterClickListener {
    void onCharacterClick(CharacterModel characterModel, ImageView imageView);
}
