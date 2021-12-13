package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return List.copyOf(humans);
    }

    public void readHumansFromFile(Path path) {
        try {
            List<String> contents = Files.readAllLines(path);
            stringToHumans(contents);
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file!", e);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> contents = humansToStringList(getMaleHumans());
        try {
            Files.write(path, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stringToHumans(List<String> contents) {
        for (String line : contents) {
            String[] parts = line.split(";");
            humans.add(new Human(parts[0], parts[1]));
        }
    }

    private List<Human> getMaleHumans() {
        List<Human> result = new ArrayList<>();
        for (Human human : humans) {
            if (human.isMale()) {
                result.add(human);
            }
        }
        return result;
    }

    private List<String> humansToStringList(List<Human> humans) {
        List<String> result = new ArrayList<>();
        for (Human human : humans) {
            result.add(human.toString());
        }
        return result;
    }
}
