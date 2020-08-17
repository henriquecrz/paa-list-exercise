import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CustomList {
    private List<Integer> _numbers;

    public CustomList() {
        this._numbers = new ArrayList<Integer>();
    }

    public void fillListFromFile(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line.replace(" ", "");

                if (line.toLowerCase() != Constant.END) {
                    try {
                        add(Integer.parseInt(line));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getNumbers() {
        return this._numbers;
    }

    public void add(int number) {
        this._numbers.add(number);
    }

    public void remove(int number) {
        if (this._numbers.contains(number)) {
            this._numbers.remove(number);
        }
    }

    public Map<Integer, Integer> getOccurrences() {
        sort();
        Map<Integer, Integer> occurrencesHashMap = new LinkedHashMap<>();
        List<Integer> numbersWithoutDuplicates = new ArrayList<>(new HashSet<>(this._numbers));

        for (Integer number : numbersWithoutDuplicates) {
            int occurrences = (int) this._numbers.stream().filter(num -> num == number).count();

            if (!occurrencesHashMap.containsKey(number)) {
                occurrencesHashMap.put(number, occurrences);
            }
        }

        return occurrencesHashMap;
    }

    public void sort() {
        Collections.sort(this._numbers);
    }

    public int getOccurrences(int number) {
        return (int) this._numbers.stream().filter(num -> num == number).count();
    }

    public String getOccurencesFormatted() {
        String occurrencesFormatted = "";

        for (Map.Entry<Integer, Integer> pair : getOccurrences().entrySet()) {
            occurrencesFormatted += pair.getKey() + " : " + pair.getValue() + "\n";
        }

        return occurrencesFormatted;
    }

    public void saveOccurencesToFile(String pathFile) {
        Util.writeFile(pathFile, getOccurencesFormatted());
    }
}
