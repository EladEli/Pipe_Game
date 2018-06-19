package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.CacheManager;
import java.io.*;
import java.util.HashMap;

public class FileCacheManager implements CacheManager {
    final private String _fileName = "PipeGame.txt";

    private HashMap<Integer,String> _problemToSolutionMapping;

    public FileCacheManager() throws IOException {
        _problemToSolutionMapping = new HashMap<>();
        loadFile();
    }

    @Override
    public void save(GameLevel gameLevel) throws IOException {
        _problemToSolutionMapping.put(gameLevel.getProblem().hashCode(),gameLevel.getSolution());
        GetOrCreateFile();
    }

    @Override
    public void load(GameLevel gameLevel) {
        gameLevel.SetSolution(_problemToSolutionMapping.get(gameLevel.getProblem().hashCode()));
    }

    private void GetOrCreateFile() throws IOException {
        // Need to check if the file exists and if yes so append to file(need to check if you can write only the addition,
        // if not than create file
        File file = new File(_fileName);
        FileWriter fileWriter = new FileWriter(file);
        // need to go over every KeyValuePer and write it to the fileWriter and only flush at the end
        fileWriter.write(_problemToSolutionMapping.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    private void loadFile()throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(_fileName))) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            //needs to put items into the dictionary
        }
    }
}
