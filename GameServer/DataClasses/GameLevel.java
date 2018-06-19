package GameServer.DataClasses;

public class GameLevel {
    private String _problem;
    private String _solution;

    public Boolean IsSolved(){ return _solution != null; }

    public GameLevel(String problem)  {
        _problem = problem;
    }

    public String getProblem() {
        return _problem;
    }

    public String getSolution(){ return _solution; }

    public void SetSolution(String solution) { _solution = solution; }
}
