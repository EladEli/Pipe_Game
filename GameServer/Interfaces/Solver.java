package GameServer.Interfaces;

import GameServer.DataClasses.GameLevel;

public interface Solver {
    void solve(GameLevel problem);
    void createProblem();
}
