package GameServer.InfraClasses;

import GameServer.Interfaces.Solver;

public class PipeGameSolver implements Solver {
    private String _message;
    private Boolean isSuccess;

    public PipeGameSolver() {
        _message = "";
        isSuccess = true;
    }

    @Override
    public void solve(String problem) {
        _message = "Death";
    }

    @Override
    public void createProblem() {
        isSuccess = false;
    }
}
