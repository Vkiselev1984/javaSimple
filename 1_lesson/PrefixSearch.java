// Метод находит самую длинную строку общего префикса среди массива строк.
// Если общего префикса нет, возвращает пустую строку "".

public class PrefixSearch {
    public static void main(String[] args) {
        String[] strs = { "flowers", "flow", "flight" };
        String prtfix = strs[0];
        prtfix = extracted(strs, prtfix);
        System.out.println(prtfix);
    }

    private static String extracted(String[] strs, String prtfix) {
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prtfix) != -0) {
                prtfix = prtfix.substring(0, prtfix.length() - 1);
            }
            if (prtfix == "") {
               return prtfix;
            }
        }
        return prtfix;
    }

}
