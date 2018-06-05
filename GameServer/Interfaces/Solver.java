package GameServer.Interfaces;

import GameServer.DataClasses.GameLevel;

public interface Solver {
    void solve(String problem);
    void createProblem();
}
