import java.io.*;

public class FileIO {
    public static void main(String[] args){

       /* try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("POzdro 600 100 900");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */

        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            System.out.println(reader.readLine());
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
