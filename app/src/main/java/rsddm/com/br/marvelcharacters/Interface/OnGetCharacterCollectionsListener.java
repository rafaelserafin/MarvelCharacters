package rsddm.com.br.marvelcharacters.Interface;

import rsddm.com.br.marvelcharacters.Model.Marvel.Comics.ComicDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Events.EventDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Series.SeriesDataWrapperModel;
import rsddm.com.br.marvelcharacters.Model.Marvel.Stories.StoryDataWrapperModel;

/**
 * Created by Rafael Serafin
 * rafael.serafin.d@hotmail.com
 * on 20/06/2017.
 */

public interface OnGetCharacterCollectionsListener {
    void onGetComics(ComicDataWrapperModel comicDataWrapperModel);

    void onGetEvents(EventDataWrapperModel eventDataWrapperModel);

    void onGetSeries(SeriesDataWrapperModel seriesDataWrapperModel);

    void onGetStories(StoryDataWrapperModel storyDataWrapperModel);
}
