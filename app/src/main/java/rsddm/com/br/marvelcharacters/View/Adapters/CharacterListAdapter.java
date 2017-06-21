package rsddm.com.br.marvelcharacters.View.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import rsddm.com.br.marvelcharacters.Interface.OnCharacterClickListener;
import rsddm.com.br.marvelcharacters.Interface.OnLastItemBindListener;
import rsddm.com.br.marvelcharacters.Model.Marvel.Characters.CharacterModel;
import rsddm.com.br.marvelcharacters.R;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ViewHolder> {

    private Context context;
    private List<CharacterModel> characterModelList;
    private OnLastItemBindListener onLastItemBindListener;
    private OnCharacterClickListener onCharacterClickListener;

    public CharacterListAdapter(List<CharacterModel> characterModelList,
                                OnLastItemBindListener onLastItemBindListener,
                                OnCharacterClickListener onCharacterClickListener){
        this.characterModelList = characterModelList;
        this.onLastItemBindListener = onLastItemBindListener;
        this.onCharacterClickListener = onCharacterClickListener;
    }

    @Override
    public CharacterListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_character, parent, false);

        CharacterListAdapter.ViewHolder vh = new CharacterListAdapter.ViewHolder(v);
        context = v.getContext();

        return vh;
    }

    @Override
    public void onBindViewHolder(CharacterListAdapter.ViewHolder holder, int position) {
        holder.setModel(characterModelList.get(position));

        if(position >= getItemCount() - 1)
        {
            onLastItemBindListener.onLastItemBind();
        }
    }

    @Override
    public int getItemCount() {
        return characterModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCharacterName;
        private ImageView imgCharacter;
        private CharacterModel characterModel;

        public ViewHolder(View view) {
            super(view);

            txtCharacterName = (TextView) view.findViewById(R.id.txt_character_name);
            imgCharacter = (ImageView) view.findViewById(R.id.img_character);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCharacterClickListener.onCharacterClick(characterModel, imgCharacter);
                }
            });
        }

        public void setModel(CharacterModel characterModel){
            this.characterModel = characterModel;
            txtCharacterName.setText(characterModel.getName());
            Picasso.with(context).load(characterModel.getThumbnail().getUrlImageLandscape()).into(imgCharacter);
        }
    }
}
