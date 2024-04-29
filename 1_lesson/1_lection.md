# Знакомство с языком программирования Java

<aside>
💡 Шаг 1:

</aside>

Java JDK [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

<aside>
💡 Шаг 2:

</aside>

Extension Pack VS Code

[https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-javapack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-javapack)

<aside>
💡 При желании:

</aside>

[https://www.jetbrains.com/ru-ru/idea/](https://www.jetbrains.com/ru-ru/idea/)

## Структура простой программы

```jsx
/**Program*/
public class Program {
public static void main(String[] args) {
System.out.println("Goodbye world");
}
}
```

Не забываем пользоваться сниппетами, которые на основе сокращенного ввода предлагают написание кода. В качестве имени класса выбираем название файла и редактор предложит создать соответствующий класс.

Далее определяем точку входа. Начинаем писать Main и редактор предлагает создать этот метод.

Далее создадим вывод текста в консоль. Для этого вводим sys и нажимаем Enter. Вписываем произвольный текст.

Для запуска можем воспользоваться средствами редактора (кнопка в правом верхнем углу) или пишем в консоли: 

```jsx
% java название файла
```

Обращаем внимание как определяются комментарии: /**комментарий*/ или //комментарий

Ссылочные это все, что относится к классам или интерфейсам., массивы К примитивам стандартные типы данных:

## Основы: типы данных

Основные типы данных в Java условно делятся на ссылочные и примитивные

![Untitled](%D0%97%D0%BD%D0%B0%D0%BA%D0%BE%D0%BC%D1%81%D1%82%D0%B2%D0%BE%20%D1%81%20%D1%8F%D0%B7%D1%8B%D0%BA%D0%BE%D0%BC%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%20Java%20a7f6b2da3d6a444191ea1e2fb89c15c4/Untitled.png)

К ссылочным, например, относятся классы или интерфейсы, массивы.

![Untitled](%D0%97%D0%BD%D0%B0%D0%BA%D0%BE%D0%BC%D1%81%D1%82%D0%B2%D0%BE%20%D1%81%20%D1%8F%D0%B7%D1%8B%D0%BA%D0%BE%D0%BC%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%20Java%20a7f6b2da3d6a444191ea1e2fb89c15c4/Untitled%201.png)

К примитивным - логические типы данных, целочисленные, вещественные, символьные типы данных.

### Создание переменной

Переменная определяется по такому принципу: <тип> <идентификатор>;

Инициализация этой переменной: <идентификатор> = <значение>;

На практике принято присваивать значение идентификатору в момент объявления. 

Если не присвоить значение переменной, то программа не сработает. В качестве значения можно указать пустую ссылку -  null.

Таким образом для хранения значений в качестве переменных используются примитивные типы данных:. Для целочисленных, в большинстве случаев, это int и short.

```java
class Program
{
public static void main(String[] args) {
short age = 10;
int salary = 123456;
System.out.println(age); //10
System.out.println(salary); //123456
}
}
```

А для вещественных это float и double. При этом, при использовании float необходимо использовать суффикс f. Но, для double этого можно не делать.

```java
class Program
{
public static void main(String[] args) {
float e = 2.7f;
double pi = 3.1415;
System.out.println(e); // 2.7
System.out.println(pi); // 3.1415
}
}
```

Для символьных данных используется тип char. В нижеприведенном примере Character.isDigit() возвращает значение true, если переданный символ цифра и false если значение не цифра.

```jsx
class Program
{
public static void main(String[] args) {
char ch = '1';
System.out.println(Character.isDigit(ch)); // true
ch = 'a';
System.out.println(Character.isDigit(ch)); // false
}
}
```

При этом, мы можем присвоить вещественному типу целочисленное, но не наоборот. Это происходит исходя из размерности типов. Это важное замечание.

В типах данных boolean важно учитывать то как работают [логические и побитовые операторы](https://www.notion.so/14aec4fe810a4f5fb27ed928574642ea?pvs=21) ([таблица описания](https://www.notion.so/061bc024b2d8403bb776ae106ffb9a2b?pvs=21)).

```jsx
public class Program {
public static void main(String[] args) {
boolean flag1 = 123 <= 234;
System.out.println(flag1); // true
boolean flag2 = 123 >= 234 || flag1;
System.out.println(flag2); // true
boolean flag3 = flag1 ^ flag2;
System.out.println(flag3); // false
}
}
```

Когда вы определяете строковый тип данных вам неизвестен размер. Поэтому строки не совсем примитивный тип данных. В базовом же представлении все просто:

```jsx
public class Program {
public static void main(String[] args) {
String msg ="Hello world";
System.out.println(msg); // Hello world
}
}
```

### Неявная типизация

В вышеописанных примерах мы явно указывали тип данных, но, в тоже время, мы можем использовать неявную типизацию.

В примере компилятор автоматически заменит var на наиболее приближенный тип.+

```jsx
public class Program {
public static void main(String[] args) {
var a = 123;
System.out.println(a); // 123
var d = 123.456;
System.out.println(d); // 123.456
}
}
```

Более детально получить информацию о типе можно с помощью такого метода. Обратите внимание, что любой метод должен быть частью класса.

```jsx
public class Program {
public static void main(String[] args) {
var a = 123;
System.out.println(a); // 123
var d = 123.456;
System.out.println(d); // 123.456
System.out.println(getType(a)); // Integer
System.out.println(getType(d)); // Double
d = 1022;
System.out.println(d); // 1022
//d = "mistake";
//error: incompatible types:
//String cannot be converted to double
}
static String getType(Object o){
return o.getClass().getSimpleName();
}
}
```

Также в Java существуют классы обертки, с помощью которых можно производить какие-то действия, например, конвертацию данных.

Т.е. классы обертки дают более глубокий функционал для работы с типами данных. Каждому типу соответствует свой класс.

### Классы-обертки

[Классы обертки](https://www.notion.so/10c759f6290e4b29a96d5a2e8a58a6b2?pvs=21) позволяют получить доступ к соответствующим примитивам методам

[https://youtu.be/P7b_dzMFG7s](https://youtu.be/P7b_dzMFG7s)

Типы классов оберток:

| Примитивный тип данных | Класс-оболочка |
| --- | --- |
| символ | Символ |
| байт | Байт |
| краткое описание | Краткое описание |
| int | Целое число |
| длинные | Длинные |
| float | Float |
| двойной | Двойной |
| логическое значение | Логическое значение |

```jsx
class Program
{
public static void main(String[] args) {
System.out.println(Integer.MAX_VALUE); // 2147483647
System.out.println(Integer.MIN_VALUE); // -2147483648
}
}
```

![Untitled](%D0%97%D0%BD%D0%B0%D0%BA%D0%BE%D0%BC%D1%81%D1%82%D0%B2%D0%BE%20%D1%81%20%D1%8F%D0%B7%D1%8B%D0%BA%D0%BE%D0%BC%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%20Java%20a7f6b2da3d6a444191ea1e2fb89c15c4/Untitled%202.png)

Попробуем проверить является ли какой-то определенный символ строки числом или нет:

```java
public class Main {
  public static void main(String[] args) {
      String str = "dfy"; // Трехсимвольная строка

      char secondChar = str.charAt(1); // Получаем второй символ из строки
      String secondStr = String.valueOf(secondChar); // Преобразуем символ в строку

      try {
          Integer.parseInt(secondStr); // Пытаемся разобрать второй символ как целое число
          System.out.println("Второй символ строки является числовым значением");
      } catch (NumberFormatException e) {
          System.out.println("Второй символ строки не является числовым значением");
      }
  }
}

Вывод: Второй символ строки не является числовым значением
```

Инкапсуляция с помощью классов-оберток:

```java
public class IntWrapper {
    private int value;

    public IntWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public void display() {
        System.out.println("Значение: " + value);
    }

    public static void main(String[] args) {
        IntWrapper wrapper = new IntWrapper(10);
        wrapper.display();
        wrapper.increment();
        wrapper.display();
        System.out.println("Четное число? " + wrapper.isEven());
        System.out.println("Нечетное число? " + wrapper.isOdd());
    }
}

Вывод: 
Значение: 10
Значение: 11
Четное число? false
Нечетное число? true
```

## Операции Java

● Присваивание: =
● Арифметические: *, /, +, -, %, ++, --
● Операции сравнения: <, >, ==, !=, >=, <=
● Логические операции: ||, &&, ^, !
● Побитовые операции <<, >>, &, |, ^

Есть свои особенности. Например, в случае с инкрементом, определяемом в контексте вывода данных в консоль он не сработает. Число a так и останется 123:

```java
class Program
{
public static void main(String[] args) {
int a = 123;
System.err.println(a++);
//123
}
}

```

А вот так сработает: 

```java
class Program
{
public static void main(String[] args) {
int a = 123;
System.err.println(a++);
System.err.println(a);
//123
//124
}
}
```

### Постфиксный и префиксный инкремент

Это произойдет в связи с разными приоритетами операций.

Его также можно написать таким образом:

```java
class Program
{
public static void main(String[] args) {
int a = 123;
System.err.println(++a);
System.err.println(a);
//124
//124
}
}

```

И в этом случае он сработает. В этом случае приоритет операции инкремента будет выше операции вывода данных в консоль. 

Небольшая задачка. Вычислите в уме:

```java
class Program
{
public static void main(String[] args) {
int a = 123;
a = a-- - --a;
System.err.println(a);
//Ответ: 2
}
}

```

Или вот такая:

```java
class Program
{
public static void main(String[] args) {
int a = 123;
a = --a - a--;
System.err.println(a);
//Ответ: 0
}
}

```

### Побитовые операции

Побитовые сдвиги

Возьмем число 8. Нам предстоит что-то двигать в контексте битов. Например мы хотим сдвинуть все биты влево.

```java
class Program
{
public static void main(String[] args) {
int a = 18;
//В двоичной системе это 1000
System.err.println(a << 1);
//Вывод будет 10000 что равно 16
}
}

```

Для более понятного примера возьмем число 18 и сдвинем на 1 бит вправо:

```java
class Program
{
public static void main(String[] args) {
int a = 18;
//В двоичной системе это 10010
System.err.println(a >> 1);
//Вывод будет 1001 что равно 9
}
}

```

Такие операции могут потребоваться в момент оптимизации, например, при работе с корнями, когда сторонние библиотеки и функции будут очень медленными и придется написать собственную реализацию.

Пример с оператором ИЛИ:

```java
class Program
{
public static void main(String[] args) {
int a = 5;
int b = 2;
System.err.println(a | b);
//  101 - это число 5
//  010 - это число 2
//  111 - побитово сравниваем
//  Ответ - 7
}
}
```

Пример с операцией И:

```java
class Program
{
public static void main(String[] args) {
int a = 5;
int b = 2;
System.err.println(a & b);
//  101 - это число 5
//  010 - это число 2
//  000 - ответ 0
}
}

```

Разделительная операция ^ (истинно тогда, когда ОДНО ИЗ истинно):

```java
class Program
{
public static void main(String[] args) {
boolean a = true;
boolean b = true;
System.err.println(a ^ b);
//  101 - это число 5
//  010 - это число 2
//  111 - ответ 7
}
}

```

Еще один пример - оператор &&. Если левое условие будет неверным, то программа прекратит дальнейшую проверку второго условия.

```java
class Program
{
public static void main(String[] args) {
String a = "qwerty";//индексы "0.1.2.3.4.5"
boolean b = a.length() >= 7 && a.charAt(0)!= '1';
// a.length - длинна строки >= 7
// 0 символ не равен 1
System.err.println(b);
}
}

Вывод: false
```

Однако & проверяет оба условия. И если одно будет не верным, то программа все равно продолжит проверку правого условия.

Аналогичным способом работает операция | и ||

## Массивы

### Одномерные

```jsx
public class Program {
public static void main(String[] args) {
int[] arr = new int[10];
System.out.println(arr.length); // 10
arr = new int[] { 1, 2, 3, 4, 5 };
System.out.println(arr.length); // 5
}
}
```

Кстати int arr{] тоже возможная запись объявления массива.

### Многомерные

```jsx
public class Program {
public static void main(String[] args) {
int[] arr[] = new int[3][5];
for (int[] line : arr) {
for (int item : line) {
System.out.printf("%d ", item);
}
System.out.println();
}
}
}
```

Также двумерные массивы можно объявлять таким образом:

```jsx
public class Program {
public static void main(String[] args) {
int[][] arr = new int[3][5];
for (int i = 0; i < arr.length; i++) {
for (int j = 0; j < arr[i].length; j++) {
System.out.printf("%d ", arr[i][j]);
}
System.out.println();
}
}
}
```

Зададим значения:

```java
public class Program {
  public static void main(String[] args) {
  int[][] arr = {{1, 2}, {3, 4}};
  
  for (int i = 0; i < arr.length; i++) {
  for (int j = 0; j < arr[i].length; j++) {
  System.out.printf("%d ", arr[i][j]);
  }
  System.out.println();
  }
  }
  }
```

## Преобразования

![Untitled](%D0%97%D0%BD%D0%B0%D0%BA%D0%BE%D0%BC%D1%81%D1%82%D0%B2%D0%BE%20%D1%81%20%D1%8F%D0%B7%D1%8B%D0%BA%D0%BE%D0%BC%20%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%20Java%20a7f6b2da3d6a444191ea1e2fb89c15c4/Untitled%203.png)

### Можно

```jsx
public class Program {
public static void main(String[] args) {
int i = 123; double d = i;
System.out.println(i); // 123
System.out.println(d); // 123.0
d = 3.1415; i = (int)d;
System.out.println(d); // 3.1415
System.out.println(i); // 3
d = 3.9415; i = (int)d;
System.out.println(d); // 3.9415
System.out.println(i); // 3
byte b = Byte.parseByte("123");
System.out.println(b); // 123
b = Byte.parseByte("1234");
System.out.println(b); // NumberFormatException: Value out of range
}
}
```

### НО

```jsx
class Program
{
public static void main(String[] args) {
int[] a = new int[10];
double[] d = a; // ИЗУЧАЕМ ковариантность и контравариантность
}
}
```

## Получение данных из терминала

### Строки

```jsx
import java.util.Scanner;
public class Program {
public static void main(String[] args) {
Scanner iScanner = new Scanner([System.in](http://system.in/));
System.out.printf("name: ");
String name = iScanner.nextLine();
System.out.printf("Привет, %s!", name);
iScanner.close();
}
}
```

### Некоторые примитивы

```jsx
import java.util.Scanner;
public class Program {
public static void main(String[] args) {
Scanner iScanner = new Scanner([System.in](http://system.in/));
System.out.printf("int a: ");
int x = iScanner.nextInt();
System.out.printf("double a: ");
double y = iScanner.nextDouble();
System.out.printf("%d + %f = %f", x, y, x + y);
iScanner.close();
}}
```

### Проверка на соответствие получаемого типа

```jsx
import java.util.Scanner;
public class Program {
public static void main(String[] args) {
Scanner iScanner = new Scanner([System.in](http://system.in/));
System.out.printf("int a: ");
boolean flag = iScanner.hasNextInt();
System.out.println(flag);
int i = iScanner.nextInt();
System.out.println(i);
iScanner.close();
} }
```

## Форматированный вывод

```jsx
public class Program {
public static void main(String[] args) {
int a = 1, b = 2;
int c = a + b;
String res = a + " + " + b + " = " + c;
System.out.println(res);
}
}
```

Обратите внимание, что конкотенация может сильно снизить производительность программы. Если она присутствует в цикле то со 100% вероятностью такой код необходимо переписать.

Например, в следующем примере к данные будут приведены к строке 4! раза:

```java
public class Program {
  public static void main(String[] args) {
      String s = "ewef";
      int i = 0;
      String res = s + i;
      System.out.println(res);
  }
}
```

Такой код будет намного производительнее:

```java
public class Program {
  public static void main(String[] args) {
      String s = "ewef";
      int i = 0;
      
      StringBuilder sb = new StringBuilder();
      sb.append(s).append(i);
      
      String res = sb.toString();
      System.out.println(res);
  }
}
```

Вернемся к форматированному выводу. Форматы вывода:

```jsx
public class Program {
public static void main(String[] args) {
int a = 1, b = 2;
int c = a + b;
String res = String.format("%d + %d = %d \n", a, b, c);
System.out.printf("%d + %d = %d \n", a, b, c);
System.out.println(res);
}
}
```

### Виды спецификаторов

- %d: целочисленных значений
- %x: для вывода шестнадцатеричных чисел
- %f: для вывода чисел с плавающей точкой
- %e: для вывода чисел в экспоненциальной форме,
- например, 3.1415e+01
- %c: для вывода одиночного символа
- %s: для вывода строковых значений

```jsx
public class Program {
public static void main(String[] args) {float pi = 3.1415f;
System.out.printf("%f\n", pi); // 3,141500
System.out.printf("%.2f\n", pi); // 3,14
System.out.printf("%.3f\n", pi); // 3,141
System.out.printf("%e\n", pi); // 3,141500e+00
System.out.printf("%.2e\n", pi); // 3,14e+00
System.out.printf("%.3e\n", pi); // 3,141e+00
}
}
```

## Область видимости переменных

У переменных существует понятие «область видимости».
Если переменную объявили внутри некоторого блока фигурных скобок { },
то снаружи этого блока переменная будет недоступна.

```jsx
public class Program {
public static void main(String[] args) {
{
int i = 123;
System.out.println(i);
}
System.out.println(i); // error: cannot find symbol
}
}
```

## Функции и методы

Функции и методы — это технически одно и то же. Функции могут не принадлежать классам, а методы принадлежат. В java все функции являются методами.

- Описание
- Вызов
- Возвращаемое значение
- Рекурсия

```jsx
public class Program {
static void sayHi() {
System.out.println("hi!");
}
static int sum(int a, int b) {
return a+b;
}
static double factor(int n) {
if(n==1)return 1;
return n * factor(n-1);
}
public static void main(String[] args) {
sayHi(); // hi!
System.out.println(sum(1, 3)); // 4
System.out.println(factor(5)); // 120.0
}}
```

## Управляющие конструкции

В java, как и других языках есть такие управляющие конструкции, как, например, [операторы ветвления](https://www.notion.so/1-e3122a505b9f4b438a381c9f1005b24f?pvs=21):

```jsx
public class Program {
public static void main(String[] args) {
int a = 1;
int b = 2;
int c;
	if (a > b) {
		c = a;
		} else {
		c = b;
		}
System.out.println(c);
}
}
```

Сокращенная форма:

```jsx
public class Program {
public static void main(String[] args) {
int a = 1;
int b = 2;
int c = 0;
if (a > b) c = a;
if (b > a) c = b;
System.out.println(c);
}
}
```

```jsx
public class Program {
public static void main(String[] args) {
int a = 1;
int b = 2;
int min = a < b ? a : b;
System.out.println(min);
}
}
```

## Оператор выбора

```jsx
import java.util.Scanner;
public class Program {
public static void main(String[] args) {
int mounth = value;
String text = "";
switch (mounth) {
case 1:
text = "Autumn";
break;
...
default:
text = "mistake";
break;
}
System.out.println(text);
iScanner.close();
}
}
```

## Циклы

Цикл — это многократное выполнение одинаковой
последовательности действий.
В java доступны следующие циклы:
● цикл while;
● цикл do while;
● цикл for; и его модификация for in

### Цикл while

```jsx
public class Program {
public static void main(String[] args) {
int value = 321;
int count = 0;
while (value != 0) {
value /= 10;
count++;
}
System.out.println(count);
}
}
```

### Цикл do while

```jsx
public class Program {
public static void main(String[] args) {
int value = 321;
int count = 0;
do {
value /= 10;
count++;
} while (value != 0);
System.out.println(count);
}
}
```

### continue, break

Операторы для управления циклами — continue и break.
Выполнение следующей итерации цикла — continue.
Прерывание текущей итерации цикла — break. ближайшего к оператору.

Эти операторы считаются плохой практикой, их лучше не использовать.

### Оператор цикла for

```jsx
public class Program {
public static void main(String[] args) {
int s = 0;
for (int i = 1; i <= 10; i++) {
s += i;
}
System.out.println(s);
}
}
```

### Вложенные циклы

```jsx
public class Program {
public static void main(String[] args) {
for (int i = 0; i < 5; i++) {
for (int j = 0; j < 5; j++) {
System.out.print("* ");
}
System.out.println();
}
// * * * * *
// * * * * *
// * * * * *
// * * * * *
// * * * * *
}
}
```

### for :

```jsx
public class Program {
public static void main(String[] args) {
int arr[] = new int[10];
for (int item : arr) {
System.out.printf("%d ", item);
}
System.out.println();
}
}
```

## Работа с файлами

### Создание и запись\ дозапись

```jsx
import java.io.FileWriter;
import java.io.IOException;

public static void main(String[] args) {
 try (FileWriter fw = new FileWriter("file.txt", false)) {
 fw.write("line 1");
 fw.append('\n');
 fw.append('2');
 fw.append('\n');
 fw.write("line 3");
 fw.flush();
 } catch (IOException ex) {
 System.out.println(ex.getMessage());
 }
}
  

```

### Чтение, Вариант посимвольно

```jsx
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("file.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Вариант построчно

```jsx
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

[**Как пользоваться базовым API**](https://www.notion.so/API-c68e048a8b9a4abfae63d38b381c71a7?pvs=21)

[Коллекции](https://www.notion.so/136db09042c54ad79e5db3067fae8e2b?pvs=21)