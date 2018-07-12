package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.CacheManager;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileCacheManager implements CacheManager {
    final private String _fileName = "PipeGame.txt";
    private FileWriter _fileWriter;
    private File _file;

    private HashMap<Integer, String> _problemToSolutionMapping;


    public FileCacheManager() throws IOException {
        _problemToSolutionMapping = new HashMap<>();
        createFile();
    }

    @Override
    public void save(GameLevel gameLevel) throws IOException {
        _problemToSolutionMapping.put(gameLevel.getProblem().hashCode(), gameLevel.getSolution());
        saveProblemToFile(_problemToSolutionMapping.toString());
    }

    @Override
    public void load(GameLevel gameLevel) {
        gameLevel.SetSolution(_problemToSolutionMapping.get(gameLevel.getProblem().hashCode()));
    }

//    private void GetOrCreateFile() throws IOException {
//        createFile();
//        _fileWriter.write(_problemToSolutionMapping.toString());
//        _fileWriter.flush();
//        _fileWriter.close();
//
//         Need to check if the _file exists and if yes so append to _file(need to check if you can write only the addition,
//         if not than create _file
//         need to go over every KeyValuePer and write it to the _fileWriter and only flush at the end
//
//    }

    private void loadFile() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(_fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String parts[] = line.split("\t");
                _problemToSolutionMapping.put(Integer.valueOf(parts[0]), parts[1]);
            }
            //needs to put items into the dictionary
    }

    private boolean FileExists(){
        if(Files.exists(Paths.get(_fileName))) {
            return true;
        }
        return false;
    }

    private void  createFile() throws IOException {
        if(!FileExists()){
            _file = new File(_fileName);
            _fileWriter = new FileWriter(_file,true);

        }

    }

    private void saveProblemToFile(String problem) throws IOException {
        _fileWriter.write(problem);
        _fileWriter.flush();
        _fileWriter.close();
    }

    private boolean problemExists(int hashCodeNumber){
        return false;
    }
}
