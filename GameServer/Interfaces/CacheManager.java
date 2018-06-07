package GameServer.Interfaces;

import GameServer.DataClasses.GameLevel;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CacheManager {
    void save(GameLevel gameLevel) throws IOException;
    String load() throws IOException;
}
