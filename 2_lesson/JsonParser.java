// Программа обрабатывает JSON строку и, используя StringBuilder, создаст строки вида:
// [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
// Строка: [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"
// Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]


public class JsonParser {

    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        String[] entries = jsonString.split("[{},]");

        StringBuilder result = new StringBuilder();
        String surname = "";
        String mark = "";
        String subject = "";

        for (String entry : entries) {
            if (entry.contains("фамилия")) {
                surname = entry.split(":")[1].replace("\"", "").trim();
            } else if (entry.contains("оценка")) {
                mark = entry.split(":")[1].replace("\"", "").trim();
            } else if (entry.contains("предмет")) {
                subject = entry.split(":")[1].replace("\"", "").trim();
            }

            if (!surname.isEmpty() && !mark.isEmpty() && !subject.isEmpty()) {
                result.append("Студент ").append(surname)
                        .append(" получил ").append(mark)
                        .append(" по предмету ").append(subject)
                        .append(".\n");

                surname = "";
                mark = "";
                subject = "";
            }
        }

        System.out.println(result.toString());
    }
}