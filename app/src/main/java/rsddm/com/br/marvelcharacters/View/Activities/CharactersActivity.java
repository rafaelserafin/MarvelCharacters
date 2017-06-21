package rsddm.com.br.marvelcharacters.View.Activities;

import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import rsddm.com.br.marvelcharacters.Controller.CharacterController;
import rsddm.com.br.marvelcharacters.Interface.OnCharacterClickListener;
import rsddm.com.br.marvelcharacters.Interface.OnGetCharactersListener;
import rsddm.com.br.marvelcharacters.Interface.OnLastItemBindListener;
import rsddm.com.br.marvelcharacters.Model.Marvel.Characters.CharacterDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Characters.CharacterModel;
import rsddm.com.br.marvelcharacters.R;
import rsddm.com.br.marvelcharacters.View.Adapters.CharacterListAdapter;
import rsddm.com.br.marvelcharacters.WSCommunication.CharactersWS;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 19/06/2017.
 */

public class CharactersActivity extends AppCompatActivity implements OnLastItemBindListener, OnCharacterClickListener {

    private ProgressBar progressBar;
    private ImageView imgLogoMarvel;

    private FloatingActionButton flaotingSearchButton;
    private RecyclerView rcvCharacters;
    private RecyclerView.Adapter rcvCharactersAdapter;
    private RecyclerView.LayoutManager rcvCharactersLayoutManager;

    private CharacterController characterController;
    private List<CharacterModel> characterModelList = new ArrayList<>();

    private int totalCharacters = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);

        characterController = new CharacterController(this);

        bindView();
        startListeners();

        getCharacters();
    }

    private void bindView(){
        imgLogoMarvel = (ImageView) findViewById(R.id.logo_marvel);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        flaotingSearchButton = (FloatingActionButton) findViewById(R.id.fab_filter);

        rcvCharacters = (RecyclerView) findViewById(R.id.rcv_characters);
        rcvCharactersAdapter = new CharacterListAdapter(characterModelList, this, this);
        rcvCharacters.setAdapter(rcvCharactersAdapter);

        rcvCharactersLayoutManager = new LinearLayoutManager(this);
        rcvCharacters.setLayoutManager(rcvCharactersLayoutManager);
    }

    private void startListeners(){
        flaotingSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Filter the characters", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void getCharacters(){
        if(rcvCharactersAdapter.getItemCount() >= totalCharacters)
            return;

        ShowProgressBar(true);

        characterController.GetCharacters(100, rcvCharactersAdapter.getItemCount(), new OnGetCharactersListener() {
            @Override
            public void onGetCharactes(boolean success, CharacterDataWrapperModel characterDataWrapperModel) {
                if(success) {
                    characterModelList.addAll(characterDataWrapperModel.getData().getResults());
                    totalCharacters = characterDataWrapperModel.getData().getTotal();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            rcvCharactersAdapter.notifyDataSetChanged();
                            imgLogoMarvel.setVisibility(View.GONE);
                        }
                    });
                }

                ShowProgressBar(false);
            }
        });
    }

    @Override
    public void onLastItemBind() {
        getCharacters();
    }

    @Override
    public void onCharacterClick(CharacterModel characterModel, ImageView imageView) {
        DetailCharacterActivity.NewInstance(CharactersActivity.this, characterModel, imageView);
    }

    private void ShowProgressBar(final boolean show){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }
}
