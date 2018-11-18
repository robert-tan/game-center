package fall2018.csc2017.game_center.slidingtiles;

import android.os.Bundle;
import android.support.annotation.Nullable;

import fall2018.csc2017.game_center.SaveManager;
import fall2018.csc2017.game_center.SavedGameState;

/**
 * Abstract class used to provide save and load functionality activities within the scope of
 * sliding tiles.
 */
public abstract class TileSaveManager extends SaveManager<TileBoardManager> {

    /**
     * Constant suffix for the sliding tile save file (unique per user)
     */
    public static final String TILE_SAVE_FILE = "_tile_saves.ser";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFilePath(username + TILE_SAVE_FILE);

        readFile();
        if (getSaveFile() == null) {
            setSaveFile(new SavedGameState<TileBoardManager>());
            writeFile();
        }
    }

}
