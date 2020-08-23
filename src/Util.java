import java.io.FileWriter;
import java.io.IOException;

public class Util {
    public static void writeFile(String pathFile, String content) {
        try {
            FileWriter outputFile = new FileWriter(pathFile);

            outputFile.write(content);
            outputFile.close();

            System.out.println(String.format("\"%s\" file created.", pathFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEndOrEmpty(String value) {
        return value.equals(Constant.END) || value.equals(Constant.EMPTY_STRING);
    }
}
