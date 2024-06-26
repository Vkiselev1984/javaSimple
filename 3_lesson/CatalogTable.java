// Каталог товаров книжного магазина сохранен в виде двумерного
// списка List<ArrayList<String>> так, что на 0й позиции каждого
// внутреннего списка содержится название жанра, а на остальных
// позициях - названия книг. Напишите метод для заполнения данной
// структуры.

public class CatalogTable {
    
    public static void main(String[] args) {
        // Создание двумерного массива для каталога товаров
        String[][] catalog = new String[3][]; // Пример: 3 строки (1 строка для жанра, 2 строки для книг)
        
        // Заполнение таблицы каталога
        catalog[0] = new String[]{"проза", "поэзия", "док"}; // Названия жанров
        catalog[1] = new String[]{"Война и мир", "Бородино", ""};
        catalog[2] = new String[]{"12 стульев", "", ""};
        
        // Вывод таблицы каталога
        System.out.println("Каталог товаров книжного магазина:");
        for (String[] row : catalog) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}