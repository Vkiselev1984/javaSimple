import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;



public class OnlineStore {
        private Map<Integer, BiPredicate<String, Integer>> criteriaMap = new HashMap<>();
    private Map<Integer, String[]> additionalCharacteristics = new HashMap<>();
    private Map<String, String[]> laptops = new HashMap<>();
    private ShoppingCart cart = new ShoppingCart();
    private Scanner scanner = new Scanner(System.in);
    private Map<Integer, String> itemNumberToName = new HashMap<>();
    public String itemNumberToName(int itemNumber) {
        return itemNumberToName.get(itemNumber);
    }

    public OnlineStore() {
        // Заполнение критериев и характеристик
        criteriaMap.put(1, LaptopFilter::checkRam);
        criteriaMap.put(2, LaptopFilter::checkStorage);
        criteriaMap.put(3, LaptopFilter::checkOS);
        criteriaMap.put(4, LaptopFilter::checkColor);

        additionalCharacteristics.put(1, new String[] { "2GB", "4GB", "8GB", "16GB" });
        additionalCharacteristics.put(2, new String[] { "512GB", "1TB", "2TB" });
        additionalCharacteristics.put(3, new String[] { "Windows 10", "Windows 11", "Linux" });
        additionalCharacteristics.put(4, new String[] { "Silver", "White", "Black", "Metallic" });

        laptops.put("Shony2GB512GB", new String[] { "2GB", "512GB", "Windows 10", "Silver", "1000" });
        laptops.put("Lapbook4GB1TB", new String[] { "4GB", "1TB", "Windows 11", "White", "1500" });
        laptops.put("Shony4GB2TB", new String[] { "4GB", "2TB", "Windows 10", "Silver", "1000" });
        laptops.put("Lapbook2GB512GB", new String[] { "2GB", "512GB", "Linux", "White", "1500" });
        laptops.put("Shony2GB512GB", new String[] { "2GB", "512GB", "Windows 10", "Silver", "1000" });
        laptops.put("Lapbook8GB1TB", new String[] { "8GB", "1TB", "Windows 11", "White", "1500" });
        laptops.put("Shony8GB512GB", new String[] { "8GB", "512GB", "Windows 10", "Silver", "2000" });
        laptops.put("Lapbook8GB1TB", new String[] { "8GB", "1TB", "Linux", "White", "1500" });
        laptops.put("Shoyny8GB512GB", new String[] { "8GB", "512GB", "Windows 10", "Silver", "2000" });
        laptops.put("Lapbook8GB1TB", new String[] { "8GB", "1TB", "Windows 11", "White", "2500" });
        laptops.put("Shony16GB512GB", new String[] { "16GB", "512GB", "Linux", "Silver", "2000" });
        laptops.put("Lapbook16GB1TB", new String[] { "16GB", "1TB", "Windows 11", "White", "2500" });

    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void addToCart(String laptopModel) {
        cart.addProduct(laptopModel, laptops);
    }

    
    public void displayMenu() {
        clearConsole();
        System.out.println("=============================================");
        System.out.println("=============== МЕНЮ МАГАЗИНА ===============");
        System.out.println("=============================================");
        System.out.println("1. Просмотреть список доступных моделей");
        System.out.println("2. Просмотреть корзину");
        System.out.println("3. Выйти из магазина");
        System.out.println("=============================================");
    }

   public void displayAvailableModels() {
    clearConsole();
    System.out.println("===================================================");
    System.out.println("=============== ВЫБОР ПО КАТЕГОРИЯМ ===============");
    System.out.println("===================================================");
    System.out.println("1. RAM");
    System.out.println("2. Storage");
    System.out.println("3. OS");
    System.out.println("4. Color");
    System.out.println("5. Цена");
    System.out.println("===================================================");
    int selectedCriteria = scanner.nextInt();
    scanner.nextLine();

    if (selectedCriteria < 1 || selectedCriteria > 5) {
        System.out.println("Некорректный критерий");
        return;
    }

    if (selectedCriteria == 5) {
        clearConsole();
        System.out.println("Введите максимальную цену:");
        int maxPrice = scanner.nextInt();
        scanner.nextLine();

        List<String> filteredModels = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : laptops.entrySet()) {
            String[] characteristics = entry.getValue();
            int price = Integer.parseInt(characteristics[4]);

            if (price <= maxPrice) {
                filteredModels.add(entry.getKey());
            }
        }

        System.out.println("Результаты фильтрации по цене до " + maxPrice + ":");
        for (int i = 0; i < filteredModels.size(); i++) {
            System.out.println((i + 1) + ". " + filteredModels.get(i));
        }

        System.out.println("Если товар по такой цене есть в нашем магазине то введите его номер и добавьте в корзину или введите 0 для возврата в главное меню:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= filteredModels.size()) {
            String selectedModel = filteredModels.get(choice - 1);
            clearConsole();
            System.out.println("Вы выбрали товар: " + selectedModel);
            System.out.println("1. Добавить в корзину");
            System.out.println("2. Вернуться в главное меню");
            int actionChoice = scanner.nextInt();
            scanner.nextLine();

            if (actionChoice == 1) {
                addToCart(selectedModel);
            }
        }
    } else {
        clearConsole();
        System.out.println("============================================");
        System.out.println("================= КРИТЕРИИ =================");
System.out.println("============================================");
        String[] availableOptions = additionalCharacteristics.get(selectedCriteria);
        for (int i = 0; i < availableOptions.length; i++) {
            System.out.println((i + 1) + ". " + availableOptions[i]);
        }

        int selectedValueIndex = scanner.nextInt();
        scanner.nextLine();

        String selectedValue = availableOptions[selectedValueIndex - 1];

        List<String> filteredModels = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : laptops.entrySet()) {
            String[] characteristics = entry.getValue();
            boolean isValid = false;

            switch (selectedCriteria) {
                case 1:
                    isValid = LaptopFilter.checkRam(characteristics[0], selectedValueIndex);
                    break;
                case 2:
                    isValid = LaptopFilter.checkStorage(characteristics[1], selectedValueIndex);
                    break;
                case 3:
                    isValid = LaptopFilter.checkOS(characteristics[2], selectedValueIndex);
                    break;
                case 4:
                    isValid = LaptopFilter.checkColor(characteristics[3], selectedValueIndex);
                    break;
                default:
                    System.out.println("Некорректный критерий");
            }

            if (isValid) {
                filteredModels.add(entry.getKey());
            }
        }
        clearConsole();
        System.out.println("Список моделей " + selectedValue + ":");
        for (int i = 0; i < filteredModels.size(); i++) {
            System.out.println((i + 1) + ". " + filteredModels.get(i));
        }

        System.out.println("Выберите номер товара из списка для добавления в корзину или введите 0 для возврата в главное меню:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= filteredModels.size()) {
            String selectedModel = filteredModels.get(choice - 1);
            clearConsole();
            System.out.println("Вы выбрали товар: " + selectedModel);
            System.out.println("1. Добавить в корзину");
            System.out.println("2. Вернуться в главное меню");
            int actionChoice = scanner.nextInt();
            scanner.nextLine();

            if (actionChoice == 1) {
                addToCart(selectedModel);
            }
        }
    }
}
    public void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                displayAvailableModels();
                break;
            case 2:
                cart.displayCart();
                displayCartMenu();
                break;
            case 3:
            System.out.println("Спасибо за покупки! До свидания!");
            System.exit(0);
            break;
        default:
            System.out.println("Некорректный выбор");
    }
}

public void displayCartMenu() {
    System.out.println("====== Меню корзины ======");
    System.out.println("1. Удалить товар из корзины");
    System.out.println("2. Показать характеристики товара");
    System.out.println("3. Печать чека");
    
    int cartChoice = scanner.nextInt();
    scanner.nextLine();
    
    switch (cartChoice) {
        case 1:
            System.out.println("Введите номер товара для удаления:");
            int itemNumber = scanner.nextInt();
            scanner.nextLine();
            cart.removeItemByNumber(itemNumber);
            break;
    
        case 2:
            System.out.println("Введите название товара для просмотра характеристик:");
            String itemName = scanner.nextLine().trim();
            
            List<String> cartItems = cart.getCartItems();
            boolean found = false;
            
            for (String laptop : cartItems) {
                if (laptop.replaceAll("\\d+\\.", "").trim().equalsIgnoreCase(itemName)) {
                    Map<String, String[]> characteristicsArrayMap = laptops;
                    Map<String, String> characteristics = new HashMap<>();
                    String[] characteristicsArray = characteristicsArrayMap.get(laptop);
                    characteristics.put("RAM", characteristicsArray[0]);
                    characteristics.put("Storage", characteristicsArray[1]);
                    characteristics.put("OS", characteristicsArray[2]);
                    characteristics.put("Color", characteristicsArray[3]);
                    
                    Map<String, Map<String, String>> itemCharacteristicsMap = new HashMap<>();
                    itemCharacteristicsMap.put(laptop, characteristics);
                    
                    cart.printItemCharacteristics(laptop, itemCharacteristicsMap);
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("Товар с таким названием не найден в корзине.");
            }
            break;

            case 3:
    cart.generateReceipt();
    break;
    }
}
            
 
    


public void startMenu() {
    while (true) {
        displayMenu();
        System.out.println("Выберите действие:");
        int choice = scanner.nextInt();
        scanner.nextLine();
        processUserChoice(choice);
    }
}

public static void main(String[] args) {
    OnlineStore onlineStore = new OnlineStore();
    onlineStore.startMenu();
}
}

class LaptopFilter {
    public static boolean checkRam(String ram, int selectedValueIndex) {
        String[] ramOptions = { "2GB", "4GB", "8GB", "16GB" };
        
        if (selectedValueIndex >= 1 && selectedValueIndex <= ramOptions.length) {
            String selectedRam = ramOptions[selectedValueIndex - 1];
            return ram.equals(selectedRam);
        } else {
            System.out.println("Некорректный индекс выбранного значения RAM");
            return false;
        }
    }
    public static boolean checkStorage(String storage, int selectedValueIndex) {
        int[] storageOptions = {512, 1, 2};
    
        if (selectedValueIndex >= 1 && selectedValueIndex <= storageOptions.length) {
            int selectedStorage = storageOptions[selectedValueIndex - 1];
            int storageSize = Integer.parseInt(storage.replaceAll("[^0-9]", ""));
    
            return storageSize == selectedStorage;
        } else {
            System.out.println("Некорректный индекс выбранного значения Storage");
            return false;
        }
    }

    public static boolean checkOS(String os, int selectedValueIndex) {
        String[] osOptions = { "Windows 10", "Windows 11", "Linux" };
    
        if (selectedValueIndex >= 1 && selectedValueIndex <= osOptions.length) {
            String selectedOS = osOptions[selectedValueIndex - 1];
            return os.equalsIgnoreCase(selectedOS);
        } else {
            System.out.println("Некорректный индекс выбранного значения OS");
            return false;
        }
    }

    public static boolean checkColor(String color, int selectedValueIndex) {
        String[] colorOptions = { "Black", "Silver", "White", "Blue" };
    
        if (selectedValueIndex >= 1 && selectedValueIndex <= colorOptions.length) {
            String selectedColor = colorOptions[selectedValueIndex - 1];
            return color.equalsIgnoreCase(selectedColor);
        } else {
            System.out.println("Некорректный индекс выбранного значения Color");
            return false;
        }
    }
}

class ShoppingCart {
private List<String> cartItems = new ArrayList<>();

public List<String> getCartItems() {
    return cartItems;
}



public void addProduct(String product, Map<String, String[]> products) {
    if (products.containsKey(product)) {
        cartItems.add(product);
        System.out.println("Товар '" + product + "' добавлен в корзину");
    } else {
        System.out.println("Товар с моделью '" + product + "' не найден");
    }
}


public void displayCart() {
    OnlineStore.clearConsole();
    if (cartItems.isEmpty()) {
        System.out.println("Корзина пуста");
    } else {
        System.out.println("Содержимое корзины:");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println((i + 1) + ". " + cartItems.get(i));
            
        }
    }
}

public void removeItemByNumber(int itemNumber) {
    if (itemNumber >= 1 && itemNumber <= cartItems.size()) {
        cartItems.remove(itemNumber - 1);
        System.out.println("Элемент успешно удален из корзины");
    } else {
        System.out.println("Некорректный номер элемента");
    }
}

public void printItemCharacteristics(String itemName, Map<String, Map<String, String>> itemCharacteristics) {
    String itemNameWithoutNumber = itemName.substring(itemName.indexOf('.') + 1); // Удаление номера и точки
    for (Map.Entry<String, Map<String, String>> entry : itemCharacteristics.entrySet()) {
        String key = entry.getKey();
        if (key.substring(key.indexOf('.') + 1).equals(itemNameWithoutNumber)) {
            Map<String, String> characteristics = entry.getValue();
            System.out.println("Характеристики товара " + key + ":");
            for (Map.Entry<String, String> characteristic : characteristics.entrySet()) {
                System.out.println(characteristic.getKey() + ": " + characteristic.getValue());
            }
            return;
        }
    }
    System.out.println("Характеристики для товара " + itemName + " не найдены.");
}


public void generateReceipt() {
    OnlineStore.clearConsole();
    try {
        // Создание XML-строки с содержимым корзины
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<receipt>");
        for (String item : cartItems) {
            xmlContent.append("<item>").append(item).append("</item>");
        }
        xmlContent.append("</receipt>");

        // Сохранение XML-строки в файле
        FileWriter fileWriter = new FileWriter("receipt.xml");
        fileWriter.write(xmlContent.toString());
        fileWriter.close();
        System.out.println("Ващ чек сохранен receipt.xml");

        // Вывод содержимого корзины в консоль
        System.out.println("=== Чек покупки ===");
        for (String item : cartItems) {
            System.out.println("Товар: " + item);
        }

        // Запрос на продолжение
        System.out.println("Нажмите Enter для возврата в главное меню");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}