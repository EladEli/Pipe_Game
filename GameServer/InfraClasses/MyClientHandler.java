package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.ClientHandler;

import java.io.*;

public class MyClientHandler implements ClientHandler {
    private FileCacheManager _fileCacheManager;
    private PipeGameSolver _pipeGameSolver;

    public MyClientHandler(FileCacheManager fileCacheManager, PipeGameSolver pipeGameSolver) {
        _fileCacheManager = fileCacheManager;
        _pipeGameSolver = pipeGameSolver;
    }

    @Override
    public void handle(InputStream inputStream, OutputStream outputStream) throws IOException {
        GameLevel currentLevel = new GameLevel(GetString(inputStream));
        _fileCacheManager.load(currentLevel);
        if(!currentLevel.IsSolved())
        {
            _pipeGameSolver.solve(currentLevel);
            _fileCacheManager.save(currentLevel);
        }

        //Send back the solution
    }

    private String GetString(InputStream inputStream)
    {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }catch (IOException exception)
        {
            System.out.println(exception.getMessage());
        }

        return stringBuilder.toString();
    }
}
