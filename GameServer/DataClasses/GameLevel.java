package GameServer.DataClasses;

public class GameLevel {
    private String _problem;


    public GameLevel(String problem)  {
        this._problem = problem;
    }

    public String getProblem() {
        return _problem;
    }
}
