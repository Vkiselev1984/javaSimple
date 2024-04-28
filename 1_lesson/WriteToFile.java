// Записать в файл следующие данные:
// Name Surname Age
// Kate Smith 20
// Paul Green 25
// Mike Black 23
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String data = "Name Surname Age\n" +
                      "Kate Smith 20\n" +
                      "Paul Green 25\n" +
                      "Mike Black 23";

        String fileName = "data.txt";

        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(data);

            bw.close();
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }
}