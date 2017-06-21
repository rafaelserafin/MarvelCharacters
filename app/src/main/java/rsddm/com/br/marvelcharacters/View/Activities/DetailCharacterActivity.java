package rsddm.com.br.marvelcharacters.View.Activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;
import rsddm.com.br.marvelcharacters.Controller.CharacterController;
import rsddm.com.br.marvelcharacters.Interface.OnGetCharacterCollectionsListener;
import rsddm.com.br.marvelcharacters.Model.Marvel.Characters.CharacterModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Comics.ComicDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Events.EventDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.General.BaseCollectionModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Series.SeriesDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Stories.StoryDataWrapperModel;
import rsddm.com.br.marvelcharacters.R;
import rsddm.com.br.marvelcharacters.View.Adapters.CollectionListAdapter;

public class DetailCharacterActivity extends AppCompatActivity {

    private View notAvailable;
    private List<BaseCollectionModel> collectionModelList = new ArrayList<>();
    private ComicDataWrapperModel comicDataWrapperModel;
    private EventDataWrapperModel eventDataWrapperModel;
    private SeriesDataWrapperModel seriesDataWrapperModel;
    private StoryDataWrapperModel storyDataWrapperModel;

    private static CharacterModel characterModel;
    private static Drawable drawableCharacter;

    private SegmentedGroup sgCollections;
    private ImageView imgCharacter;
    private TextView txtDescription;
    private RecyclerView rcvCollection;
    private RecyclerView.Adapter rcvCollectionAdapter;
    private RecyclerView.LayoutManager rcvCollectionLayoutManager;

    private CharacterController characterController;

    public static void NewInstance(AppCompatActivity activity, CharacterModel characterModel, ImageView transitionImageView ) {
        DetailCharacterActivity.characterModel = characterModel;
        Intent intent = new Intent(activity, DetailCharacterActivity.class);

        DetailCharacterActivity.drawableCharacter = transitionImageView.getDrawable();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options =
                    ActivityOptions.makeSceneTransitionAnimation(activity, transitionImageView, activity.getString(R.string.activity_image_character));

            activity.startActivity(intent, options.toBundle());
        }else{
            activity.startActivity(intent);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_character);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        characterController = new CharacterController(this);

        bindView();
        setContent();
        startTransation();
    }

    private void bindView(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(characterModel.getName());
        setSupportActionBar(toolbar);

        notAvailable = findViewById(R.id.not_available);
        rcvCollection = (RecyclerView) findViewById(R.id.rcv_collections);

        rcvCollectionAdapter = new CollectionListAdapter(collectionModelList);
        rcvCollection.setAdapter(rcvCollectionAdapter);

        rcvCollectionLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvCollection.setLayoutManager(rcvCollectionLayoutManager);

        sgCollections = (SegmentedGroup) findViewById(R.id.sg_collections);
        sgCollections.setTintColor(ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.white));
        sgCollections.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                boolean notAvailable = false;
                switch (i) {
                    case R.id.rdb_comics:
                        if(comicDataWrapperModel != null && comicDataWrapperModel.getData() != null && comicDataWrapperModel.getData().getCount() > 0) {
                            collectionModelList.clear();
                            collectionModelList.addAll(comicDataWrapperModel.getData().getResults());
                        }else
                        {
                            notAvailable = true;
                        }
                        break;

                    case R.id.rdb_events:
                        if(eventDataWrapperModel != null && eventDataWrapperModel.getData() != null && eventDataWrapperModel.getData().getCount() > 0) {
                            collectionModelList.clear();
                            collectionModelList.addAll(eventDataWrapperModel.getData().getResults());
                        }else
                        {
                            notAvailable = true;
                        }
                        break;

                    case R.id.rdb_series:
                        if(seriesDataWrapperModel != null && seriesDataWrapperModel.getData() != null && seriesDataWrapperModel.getData().getCount() > 0) {
                            collectionModelList.clear();
                            collectionModelList.addAll(seriesDataWrapperModel.getData().getResults());
                        }else
                        {
                            notAvailable = true;
                        }
                        break;

                    case R.id.rdb_stories:
                        if(storyDataWrapperModel != null && storyDataWrapperModel.getData() != null && storyDataWrapperModel.getData().getCount() > 0) {
                            collectionModelList.clear();
                            collectionModelList.addAll(storyDataWrapperModel.getData().getResults());
                        }else
                        {
                            notAvailable = true;
                        }
                        break;
                }

                if(notAvailable){
                    collectionModelList.clear();
                }

                final boolean NOT_AVAILABLE = notAvailable;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rcvCollectionAdapter.notifyDataSetChanged();

                        if(NOT_AVAILABLE){
                            DetailCharacterActivity.this.notAvailable.setVisibility(View.VISIBLE);
                        }else{
                            DetailCharacterActivity.this.notAvailable.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });


        imgCharacter = (ImageView) findViewById(R.id.img_detail_character);
        txtDescription = (TextView) findViewById(R.id.txt_description);

    }

    private void startTransation(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            imgCharacter.setTransitionName(getString(R.string.activity_image_character));
        }
    }

    private void setContent(){
        imgCharacter.setImageDrawable(drawableCharacter);
        if(characterModel.getDescription() == null || characterModel.getDescription().isEmpty()){
            txtDescription.setText(getString(R.string.no_description_available));
        }else {
            txtDescription.setText(characterModel.getDescription());
        }

        getAllCollections();
    }

    private void getAllCollections(){
        characterController.GetCharacterCollections(characterModel.getId(), new OnGetCharacterCollectionsListener() {
            @Override
            public void onGetComics(ComicDataWrapperModel comicDataWrapperModel) {
                DetailCharacterActivity.this.comicDataWrapperModel = comicDataWrapperModel;
                if(comicDataWrapperModel != null && comicDataWrapperModel.getData() != null && comicDataWrapperModel.getData().getResults() != null)
                {
                    collectionModelList.clear();
                    collectionModelList.addAll(comicDataWrapperModel.getData().getResults());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            rcvCollectionAdapter.notifyDataSetChanged();
                            if(collectionModelList.size() > 0)
                                notAvailable.setVisibility(View.GONE);
                        }
                    });
                }
            }

            @Override
            public void onGetEvents(EventDataWrapperModel eventDataWrapperModel) {
                DetailCharacterActivity.this.eventDataWrapperModel = eventDataWrapperModel;
            }

            @Override
            public void onGetSeries(SeriesDataWrapperModel seriesDataWrapperModel) {
                DetailCharacterActivity.this.seriesDataWrapperModel = seriesDataWrapperModel;
            }

            @Override
            public void onGetStories(StoryDataWrapperModel storyDataWrapperModel) {
                DetailCharacterActivity.this.storyDataWrapperModel = storyDataWrapperModel;
            }
        });
    }
}
