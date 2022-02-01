import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {


    // simple try with finally to close buffer reader.
    public static String readFirstLineFromFileWithFinallyBlock(String path)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    // try with resource and  br has extended AutoCloseable
    public static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // try with resources has two autoclosable used resources
    public static String readFirstLineFromFile2(String path)
            throws IOException {
        try (FileReader f = new FileReader("a.txt");
             BufferedReader br = new BufferedReader(f)) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readFirstLineFromFile2(""));
    }
}
