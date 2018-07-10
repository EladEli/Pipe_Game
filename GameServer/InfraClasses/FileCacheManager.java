package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.CacheManager;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileCacheManager implements CacheManager {
    final private String _fileName = "PipeGame.txt";
    private boolean _fileExists; // flag
    private FileWriter _fileWriter;
    private File _file;

    private HashMap<Integer, String> _problemToSolutionMapping;


    public FileCacheManager() throws IOException {
        _problemToSolutionMapping = new HashMap<>();
        loadFile();
    }

    @Override
    public void save(GameLevel gameLevel) throws IOException {
        _problemToSolutionMapping.put(gameLevel.getProblem().hashCode(), gameLevel.getSolution());
        GetOrCreateFile();
    }

    @Override
    public void load(GameLevel gameLevel) {
        gameLevel.SetSolution(_problemToSolutionMapping.get(gameLevel.getProblem().hashCode()));
    }

    private void GetOrCreateFile() throws IOException {
        createFile();
        _fileWriter.write(_problemToSolutionMapping.toString());
        _fileWriter.flush();
        _fileWriter.close();

        // Need to check if the _file exists and if yes so append to _file(need to check if you can write only the addition,
        // if not than create _file
        // need to go over every KeyValuePer and write it to the _fileWriter and only flush at the end

    }

    private void loadFile() throws IOException {
        createFile();

        try (BufferedReader br = new BufferedReader(new FileReader(_fileName))) {

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

    private void FileExists(){
        if(Files.exists(Paths.get(_fileName))) {
            _fileExists = true;
        }
        _fileExists =false;

    }

    private void createFile() throws IOException {
        if(!_fileExists){
            _file = new File(_fileName);
            _fileWriter = new FileWriter(_file);
        }

    }
}
