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
import rsddm.com.br.marvelcharacters.Model.Marvel.General.BaseCollectionModel;
import rsddm.com.br.marvelcharacters.R;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public class CollectionListAdapter extends RecyclerView.Adapter<CollectionListAdapter.ViewHolder> {

    private Context context;
    private List<BaseCollectionModel> collectionModels;

    public CollectionListAdapter(List<BaseCollectionModel> collectionModels){
        this.collectionModels = collectionModels;
    }

    @Override
    public CollectionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_collection, parent, false);

        CollectionListAdapter.ViewHolder vh = new CollectionListAdapter.ViewHolder(v);
        context = v.getContext();

        return vh;
    }

    @Override
    public void onBindViewHolder(CollectionListAdapter.ViewHolder holder, int position) {
        holder.setModel(collectionModels.get(position));
    }

    @Override
    public int getItemCount() {
        return collectionModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtDescription;
        private ImageView image;

        public ViewHolder(View view) {
            super(view);

            txtTitle = (TextView) view.findViewById(R.id.txt_title);
            txtDescription = (TextView) view.findViewById(R.id.txt_description);
            image = (ImageView) view.findViewById(R.id.image);

        }

        public void setModel(BaseCollectionModel collectionModel){
            txtTitle.setText(collectionModel.getTitle());
            txtDescription.setText(collectionModel.getDescription());
            Picasso.with(context).load(collectionModel.getThumbnail().getUrlImagePortrait()).into(image);
        }
    }
}
