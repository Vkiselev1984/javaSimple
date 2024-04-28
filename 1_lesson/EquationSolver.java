// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры
// могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется
// восстановить выражение до верного равенства. Предложить хотя бы
// одно решение или сообщить, что его нет


public class EquationSolver {
    public String restoreEquation() {
        for (int q = 0; q < 10; q++) {
            for (int w = 0; w < 10; w++) {
                if (q + w < 10) {  // Проверяем, что q и w не превышают 9
                    int e = 2 * 10 + 5 - q * 10 - w;
                    if (e >= 0 && e < 10) {  // Проверяем, что e не превышает 9
                        if (q + w == e) {
                            return "2" + q + " + " + w + "5 = 69";
                        }
                    }
                }
            }
        }
        return "Решение не найдено";
    }

    public static void main(String[] args) {
        EquationSolver solver = new EquationSolver();
        String result = solver.restoreEquation();
        System.out.println(result);
    }
}