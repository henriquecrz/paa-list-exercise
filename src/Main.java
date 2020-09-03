public class Main {
    public static void main(String[] args) {
        CustomList customList = new CustomList();
        customList.fillListFromFile(Path.INPUT_FILE);
        customList.saveOccurencesToFile(Path.OUTPUT_FILE);
    }
}
