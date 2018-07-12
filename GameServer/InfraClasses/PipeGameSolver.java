package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.Solver;

public class PipeGameSolver implements Solver {
    private String _message;

    public PipeGameSolver() {

        _message = "";
    }

    @Override
    public void solve(GameLevel gameLevel) {
        _message = "Death2";
        gameLevel.SetSolution(_message);
    }

    @Override
    public void createProblem() {
        //Will be called by MyClientHandler, will return a full GameLevel that needs to be Saved to cache.
    }
}
