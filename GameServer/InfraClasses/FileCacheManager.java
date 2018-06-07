package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.CacheManager;
import sun.nio.cs.StandardCharsets;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileCacheManager implements CacheManager {
    final private String _filePath = "C:\\";
    final private String _fileName = "GameLevel";
    private Integer _numberLevel = 1;

    private ArrayList<GameLevel> solutionList;

    public FileCacheManager() {
        solutionList = new ArrayList<>();
    }

    private void createFile(String gameLevel) throws IOException {
        File file = new File(_fileName +"_"+this._numberLevel + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gameLevel);
        fileWriter.flush();
        fileWriter.close();
       // this._numberLevel++;
    }
    @Override
    public void save(GameLevel gameLevel) throws IOException {
        solutionList.add(gameLevel);
        createFile(gameLevel.getProblem());


    }

    @Override
    public String load() throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader(_fileName +"_"+this._numberLevel + ".txt"))) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        }
    }
}
