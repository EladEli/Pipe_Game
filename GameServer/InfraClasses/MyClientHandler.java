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
        String solution = _fileCacheManager.load();
        if(solution == null)
        {
            _pipeGameSolver.solve(GetString(inputStream));
        }
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
