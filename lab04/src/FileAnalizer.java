import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.Map;

public class FileAnalizer {

    private Path path;
    private int wordsCount;
    private int lettersCount;
    private int linesCount;
    private Map<Character, Integer> symbolsCount;
    private Map<String, FileTime> lastUpdateTime;

    public FileAnalizer(String path){
        this.path = Paths.get(path);
        symbolsCount = new HashMap<>();
        lastUpdateTime = new HashMap<>();
        wordsCount = 0;
        lettersCount = 0;
        linesCount = 0;
    }

    public int countLetters(){
        if (fileWasModified("letters")) {
            try {
                BufferedReader content = Files.newBufferedReader(path);
                lettersCount = 0;
                while (content.ready()) {
                    lettersCount += content.readLine().replaceAll("[^a-zA-Zа-яА-я]", "").length();
                }
                content.close();
            } catch (IOException e) {
                return -1;
            }
        }

        return lettersCount;
    }

    public int countWords(){
        if (fileWasModified("words")){
            try {
                BufferedReader content = Files.newBufferedReader(path);
                wordsCount = 0;
                while (content.ready()) {
                    wordsCount += content.readLine().replaceAll("[^a-zA-Zа-яА-я ]", "").split("[ ]+").length;
                }
                content.close();
            } catch (IOException e) {
                return -1;
            }
        }

        return wordsCount;
    }

    public int countLines(){
        if (fileWasModified("lines")){
            try {
                BufferedReader content = Files.newBufferedReader(path);
                linesCount = 0;
                while (content.ready()) {
                    content.readLine();
                    linesCount++;
                }
                content.close();
            } catch (IOException e) {
                return -1;
            }
        }

        return linesCount;
    }

    public Map<Character,Integer> countFrequencyCharacteristic(){
        if (fileWasModified("symbols")) {
            try {
                BufferedReader content = Files.newBufferedReader(path);
                Map<Character, Integer> symbolsCount = new HashMap<>();

                while (content.ready()) {
                    for (char symbol : content.readLine().toCharArray()) {
                        if (symbolsCount.containsKey(symbol)) {
                            symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
                        } else {
                            symbolsCount.put(symbol, 1);
                        }
                    }
                }
                this.symbolsCount.putAll(symbolsCount);
            } catch (IOException e) {
                return null;
            }
        }

        return symbolsCount;
    }

    private boolean fileWasModified(String key){
        try {
            if (!Files.getLastModifiedTime(path).equals(lastUpdateTime.get(key))){
                lastUpdateTime.put(key, Files.getLastModifiedTime(path));
                return true;
            }
        }
        catch (IOException e){
            return true;
        }
        return false;
    }
}
