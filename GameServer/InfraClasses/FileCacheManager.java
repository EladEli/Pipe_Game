package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.CacheManager;
import java.util.ArrayList;

public class FileCacheManager implements CacheManager {
    final private String _filePath = "C:\\";
    private ArrayList<GameLevel> solutionList;

    public FileCacheManager() {
        solutionList = new ArrayList<>();
    }

    @Override
    public void save(GameLevel gameLevel) {

    }

    @Override
    public String load() {
        return null;
    }
}
