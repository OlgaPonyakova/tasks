import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.HashSet;
public class task4 {
    public static void main(String[] args) {
        task4 obj = new task4();
        Scanner in = new Scanner(System.in);


        System.out.println("\n-------Exercise #1 -----------");
        String line = "hello my name is Bessie and this is my essay";
        System.out.println(obj.formate(10, 7, line));


        System.out.println("\n-------Exercise #2 -----------");

        String[] rez = obj.split("()()()");
        for (String s : rez) System.out.print(s + " ");
        System.out.println("");

        rez = obj.split("((()))");
        for (String s : rez) System.out.print(s + " ");
        System.out.println("");

        rez = obj.split("((())())(()(()()))");
        for (String s : rez) System.out.print(s + " ");
        System.out.println("");

        System.out.println("\n-------Exercise #3 -----------");
        System.out.println(obj.toCamelCase("hello_edabit"));
        System.out.println(obj.toCamelCase("is_modal_open"));

        System.out.println(obj.toSnakeCase("helloEdabit"));
        System.out.println(obj.toSnakeCase("getColor"));


        System.out.println("\n-------Exercise #4 -----------");
        double[] mas1 = {9, 17, 30, 1.5};
        double[] mas2 = {16, 18, 30, 1.8};
        double[] mas3 = {13.25, 15, 30, 1.5};
        System.out.println(obj.overTime(mas1));
        System.out.println(obj.overTime(mas2));
        System.out.println(obj.overTime(mas3));

        System.out.println("\n-------Exercise #5 -----------");
        System.out.println(obj.BMI("205 pounds", "73 inches"));
        System.out.println(obj.BMI("55 kilos", "1.65 meters"));
        System.out.println(obj.BMI("154 pounds", "2 meters"));

        System.out.println("\n-------Exercise #6 -----------");
        System.out.println(obj.bugger(39));
        System.out.println(obj.bugger(999));
        System.out.println(obj.bugger(4));

        System.out.println("\n-------Exercise #7 -----------");
        System.out.println(obj.toStarShorthand("abbccc"));
        System.out.println(obj.toStarShorthand("77777geff"));
        System.out.println(obj.toStarShorthand("abc"));
        System.out.println(obj.toStarShorthand(""));

        System.out.println("\n-------Exercise #8 -----------");
        System.out.println(obj.doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(obj.doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(obj.doesRhyme("and frequently do?", "you gotta move."));
        System.out.println(obj.doesRhyme("Sam I am!", "Green eggs and HAM."));


        System.out.println("\n-------Exercise #9 -----------");
        System.out.println(obj.trouble(451999277, 41177722899L));
        System.out.println(obj.trouble(1222345, 12345));
        System.out.println(obj.trouble(666789, 12345667));
        System.out.println(obj.trouble(33789, 12345337L));

        System.out.println("\n-------Exercise #10 -----------");
        System.out.println(obj.countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println(obj.countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println(obj.countUniqueBooks("ZZABCDEF", 'Z'));

    }

    /*
     * Задание #1
     * Входные параметры:
     * - nWords - количество слов в строке
     * - maxLen - максимально допустимая длина одной строки при форматировании (не включая пробелы)
     * - line - строка для форматирования
     */
    public String formate(int nWords, int maxLen, String line) {
        StringBuilder build = new StringBuilder();
        String[] list = line.split(" ");

        int tempLen = 0;
        for (int i = 0; i < list.length; i++) {
            tempLen += list[i].length();
            if (tempLen <= maxLen) {
                build.append(list[i]);
                build.append(" ");
            } else {
                build.replace(build.length() - 1, build.length(), "\n");
                tempLen = 0;
                i -= 1;
            }
        }
        return build.toString();
    }

    /*
     * Задание #2
     * Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер должен быть сбалансирован.
     */
    public String[] split(String line) {
        char[] chars = line.toCharArray();
        StringBuilder build = new StringBuilder();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(': count++; break;
                case ')': count--; break;
            }

            build.append(chars[i]);

            if (count < 0) return null;
            if (count == 0) build.append(" ");
        }
        return build.toString().split(" ");
    }

    /*
     * Задание #3
     * Создайте две функции toCamelCase () и toSnakeCase (),
     * каждая из которых берет одну строку и преобразует ее либо в camelCase, либо в snake_case.
     */
    public String toCamelCase(String line) {
        StringBuilder build = new StringBuilder(line);

        int idx;
        while ((idx = build.indexOf("_")) != -1) {
            build.delete(idx, idx + 1);
            build.replace(idx, idx + 1, String.valueOf(build.charAt(idx)).toUpperCase());
        }

        return build.toString();
    }

    public String toSnakeCase(String line) {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.substring(i, i + 1).toUpperCase().equals(line.substring(i, i + 1))) {
                build.append('_');
                build.append(line.substring(i, i + 1).toLowerCase());
                continue;
            }
            build.append(line.charAt(i));
        }
        return build.toString();
    }

    /*
     * Задание #4
     * Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой.
     * Работа с 9 до 5: обычные часы работы После 5 вечера это сверхурочная работа.
     * Ваша функция получает массив с 4 значениями:
     * – Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
     * – Конец рабочего дня. (Тот же формат)
     * – Почасовая ставка
     * – Множитель сверхурочных работ
     */
    public double overTime(double[] array) {
        double clear = (17 - array[0]) * array[2];
        if (array[1] < 17) clear -= (17 - array[1]) * array[2];

        double over = 0;
        if (array[1] > 17) over = (array[1] - 17) * (array[2] * array[3]);
        return clear + over;
    }

    /*
     * Задание #5
     * Индекс массы тела (ИМТ) определяется путем измерения вашего веса в килограммах и деления на квадрат
     * вашего роста в метрах.
     * Категории ИМТ таковы:
     * 	Недостаточный вес: <18,5
     * 	Нормальный вес: 18.5-24.9
     * 	Избыточный вес: 25 и более
     * Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах, метрах или дюймах)
     * и возвращать ИМТ и связанную с ним категорию.
     */
    public String BMI (String s1, String s2) {
        String[] sm1 = s1.split(" ");
        String[] sm2 = s2.split(" ");

        double weight = 0;
        double height = 0;

        switch (sm1[1]) {
            case "kilos": weight = Double.parseDouble(sm1[0]); break;
            case "pounds" : weight = Double.parseDouble(sm1[0]) / 2.205; break;
            case "meters": height = Double.parseDouble(sm1[0]); break;
            case "inches": height = Double.parseDouble(sm1[0]) / 39.37 ; break;
        }

        switch (sm2[1]) {
            case "kilos": weight = Double.parseDouble(sm2[0]); break;
            case "pounds" : weight = Double.parseDouble(sm2[0]) / 2.205; break;
            case "meters": height = Double.parseDouble(sm2[0]); break;
            case "inches": height = Double.parseDouble(sm2[0]) / 39.37 ; break;
        }

        double bmi = weight / (height * height);
        DecimalFormat df = new DecimalFormat(".#");
        if (bmi < 18.5) return String.valueOf(df.format(bmi)) + " Underweight";
        if (bmi >= 25) return String.valueOf(df.format(bmi)) + " Overweight";
        return String.valueOf(df.format(bmi)) + " Normal weight";
    }

    /*
     * Задание #6
     * Создайте функцию, которая принимает число и возвращает его мультипликативное постоянство,
     * которое представляет собой количество раз, которое вы должны умножать цифры в num,
     * пока не достигнете одной цифры.
     */
    public int bugger(int n) {
        int count = 0;
        String number = String.valueOf(n);
        while (number.length() > 1) {
            int newN = 1;
            for (int i = 0; i < number.length(); i++) {
                newN *= Integer.parseInt(number.substring(i, i + 1));
            }
            number = String.valueOf(newN);
            count++;
        }
        return count;
    }

    /*
     * Задание #7
     * Напишите функцию, которая преобразует строку в звездную стенографию.
     * Если символ повторяется n раз, преобразуйте его в символ*n.
     */
    public String toStarShorthand(String line) {
        if (line.length() == 0) return "";
        if (line.length() == 1) return line;

        StringBuilder build = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            int j = i + 1;
            int count = 1;
            while (j < line.length()) {
                if (line.charAt(i) != line.charAt(j)) break;
                count++;
                j++;
            }
            build.append(line.charAt(i));
            if (count > 1) {
                build.append("*");
                build.append(count);
            }
            i = j - 1;
        }
        return build.toString();
    }

    /*
     * Задание #8
     * Создайте функцию, которая возвращает true, если две строки рифмуются,
     * и false в противном случае. Для целей этого упражнения две строки рифмуются,
     * если последнее слово из каждого предложения содержит одни и те же гласные.
     */
    public boolean doesRhyme(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        String lastW1 = s1.substring(s1.lastIndexOf(' ') + 1);
        String lastW2 = s2.substring(s2.lastIndexOf(' ') + 1);
        String sublett1 = "";
        String sublett2 = "";
        char[] lettersInEng = {'a', 'e', 'i', 'o', 'u', 'y' };

        for (int i = 0; i < lastW1.length(); i++) {
            for (int j = 0; j < lettersInEng.length; j++) {
                if (lastW1.charAt(i) == lettersInEng[j]) sublett1 += lettersInEng[j];
            }
        }

        for (int i = 0; i < lastW2.length(); i++) {
            for (int j = 0; j < lettersInEng.length; j++) {
                if (lastW2.charAt(i) == lettersInEng[j]) sublett2 += lettersInEng[j];
            }
        }

        return sublett1.equals(sublett2);

    }

    /*
     * Задание #9
     * Создайте функцию, которая принимает два целых числа и возвращает true,
     * если число повторяется три раза подряд в любом месте в num1
     * и то же самое число повторяется два раза подряд в num2.
     */
    public boolean trouble(long n1, long n2) {
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);
        if (s1.length() < 3) return false;
        if (s2.length() < 2) return false;

        for (int i = 0; i < s1.length() - 2; i+=3) {
            if (s1.charAt(i) == s1.charAt(i + 1) & s1.charAt(i + 1) == s1.charAt(i + 2)) {
                char[] cont = new char[2];
                cont[0] = s1.charAt(i);
                cont[1] = s1.charAt(i);
                if (s2.contains(String.valueOf(cont))) return true;
            }
        }
        return false;
    }

    /*
     * Задание #10
     * Предположим, что пара одинаковых символов служит концами книги для всех символов между ними.
     * Напишите функцию, которая возвращает общее количество уникальных символов (книг, так сказать)
     * между всеми парами концов книги.
     */
    public int countUniqueBooks(String s1, char subC) {

        String subS = String.valueOf(subC);
        StringBuilder build = new StringBuilder(s1);
        HashSet<String> set = new HashSet<String>();

        int lastPoint = -1;
        while (build.indexOf(subS, lastPoint + 1) != -1) {
            int firstIdx = build.indexOf(subS, lastPoint + 1);
            int secondIdx = build.indexOf(subS, firstIdx + 1);

            for (int j = firstIdx + 1; j < secondIdx; j++) {
                set.add(String.valueOf(build.charAt(j)));
            }

            lastPoint = secondIdx;
        }

        return set.size();
    }

}