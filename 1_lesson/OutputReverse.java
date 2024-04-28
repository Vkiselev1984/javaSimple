
// Программа переставляет слова в обратном порядке во фразе "Добро пожаловать на курс по Java"
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputReverse {
    public static void main(String[] args) {
        String originalString = "Добро пожаловать на курс по Java";
        String[] splitStrings = originalString.split(" ");
        getStringList(splitStrings);
    }

    private static void getStringList(String[] splitStrings) {
        List<String> stringList = Arrays.asList(splitStrings);
        Collections.reverse(stringList);
        for (String str : stringList) {
            System.out.print(str + " ");
        }
    }
}
