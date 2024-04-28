// Программа формирует часть WHERE строки sql-запроса "select * from students where ", используя StringBuilder. 
// Данные для фильтрации приведены в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class SQLQueryBuilder {
  public static StringBuilder answer(String QUERY, String PARAMS) {
      String paramsNew = PARAMS.replace('{', ' ').replace('}', ' ');
      String[] params = paramsNew.split(",");
      StringBuilder stringBuilder = new StringBuilder(QUERY);

      for (int i = 0; i < params.length; i++) {
          String[] elements = params[i].replace('"', ' ').split(":");
          if (!"null".equals(elements[1].trim())) {
              stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
              if (i < params.length - 1) {
                  stringBuilder.append(" and ");
              }
          }
      }
      return stringBuilder;
  }

  public static void main(String[] args) {
      String QUERY = "";
      String PARAMS = "";

      if (args.length == 0) {
          QUERY = "select * from students where ";
          PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      } else {
          QUERY = args[0];
          PARAMS = args[1];
      }

      System.out.println(answer(QUERY, PARAMS).toString());
  }
}
