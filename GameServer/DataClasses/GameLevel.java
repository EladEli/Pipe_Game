package GameServer.DataClasses;

public class GameLevel {
    private String _problem;
    private String _solution;


    public GameLevel(String problem)  {
        this._problem = problem;
    }

    public String getProblem() {
        return _problem;
    }

    public String getSolution(){
        return this._solution;

    }
}
