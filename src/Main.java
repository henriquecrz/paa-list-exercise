public class Main {
    public static void main(String[] args) {
        CustomList customList = new CustomList();
        customList.fillListFromFile(Constant.INPUT_FILE_PATH);
        customList.saveOccurencesToFile(Constant.OUTPUT_FILE_PATH);
    }
}
