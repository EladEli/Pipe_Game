package GameServer.InfraClasses;

import GameServer.DataClasses.GameLevel;
import GameServer.Interfaces.CacheManager;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileCacheManager implements CacheManager {
    final private String _filePath = "C:\\";
    final private String _fileName = "GameLevel";

    private Integer _numberLevel;
    private Map<String,String> _problemToSolutionMapping;

    public FileCacheManager() {
        _problemToSolutionMapping = getAllFiles();
        _numberLevel = _problemToSolutionMapping.size();
    }

    @Override
    public void save(GameLevel gameLevel) throws IOException {
        _problemToSolutionMapping.put(gameLevel.getProblem(),gameLevel.getSolution());

        createFile(gameLevel.getProblem());
        createFile(gameLevel.getSolution());
    }

    @Override
    public String load(String problem) throws IOException {
        return _problemToSolutionMapping.get(problem);
    }

    private void createFile(String gameLevel) throws IOException {
        File file = new File(_fileName +"_"+_numberLevel + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gameLevel);
        fileWriter.flush();
        fileWriter.close();
    }

    private HashMap<String,String> getAllFiles(){
        //Get file names and filter to two lists: problems and solutions.
        // foreach item in those lists call private loadFile.
        HashMap<String,String> tempHashMap = new HashMap<>();
        try {
            File file = new File("dd");
            File[] death = file.listFiles();
            HashMap<File,File> filesToLoad = new HashMap<>();
            for (File file1 : death) {
                //filter to level and problem lists and make sure same length and numbers
                filesToLoad.put(file1,file1);
            }


            String x = loadFile("dd");
        }
        catch (IOException exception)
        {

        }
        return new HashMap<>();
    }

    private String loadFile(String filePath)throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
    }


    private String search(){
        return null;
    }

}
