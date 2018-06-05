package GameServer.Interfaces;

import GameServer.DataClasses.GameLevel;

public interface CacheManager {
    void save(GameLevel gameLevel);
    String load();
}
