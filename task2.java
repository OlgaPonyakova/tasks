import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        task2 obj = new task2();
        Scanner in = new Scanner(System.in);


        System.out.print("Enter string to repeat: ");
        String s1 = in.nextLine();
        System.out.print("Enter repeat amount: ");
        int n1 = in.nextInt();
        System.out.println(obj.repeat(s1, n1));



        System.out.print("Enter line of numbers across space each one: ");
       	String[] lines1 = in.nextLine().split(" ");
		int[] mas1 = new int[lines1.length];

		for (int i = 0; i < mas1.length; i++) {
			mas1[i] = Integer.parseInt(lines1[i]);
		}

		System.out.println(obj.differenceMaxMin(mas1));


        System.out.print("Enter line of numbers across space each one: ");
       	String[] lines2 = in.nextLine().split(" ");
		int[] mas2 = new int[lines2.length];

		for (int i = 0; i < mas2.length; i++) {
			mas2[i] = Integer.parseInt(lines2[i]);
		}

		System.out.println(obj.isAvgWhole(mas2));



        System.out.print("Enter line of numbers across space each one: ");
       	String[] lines3 = in.nextLine().split(" ");
		int[] mas3 = new int[lines3.length];

		for (int i = 0; i < mas3.length; i++) {
			mas3[i] = Integer.parseInt(lines3[i]);
		}

		int[] rez2 = obj.cumulativeSum(mas3);
        for (int i : rez2) System.out.print(i + " ");
        System.out.println("");


        System.out.print("Enter number with decimal part (or not): ");
        String s2 = in.nextLine();
        System.out.println(obj.getDecimalPlaces(s2));



        System.out.print("Enter number for Fibonacci sequence: ");
        int n3 = in.nextInt();
        System.out.println(obj.fibonacci(n3));


        System.out.print("Enter post-mark number to validate it: ");
        String s3 = in.nextLine();
        System.out.println(obj.isValid(s3));


        System.out.print("Enter strange str 1: ");
        String s4 = in.nextLine();
        System.out.print("Enter strange str 2: ");
        String s5 = in.nextLine();
         System.out.println(obj.isStrangePair(s4, s5));


        System.out.print("Enter word: ");
        String s7 = in.nextLine();
        System.out.print("Enter prefix: ");
        String s8 = in.nextLine();
        System.out.println(obj.isPrefix(s7, s8));

        System.out.print("Enter word: ");
        String s9 = in.nextLine();
        System.out.print("Enter suffix: ");
        String s10 = in.nextLine();
        System.out.println(obj.isPrefix(s9, s10));


        System.out.print("Enter step: ");
        int step = in.nextInt();
        System.out.println(obj.boxSeq(step));

    }

    /*
     * Задание #1
     * Создать функцию, которая повторяет каждый символ в строке n раз.
     */
    public String repeat(String str, int n) {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < n; j++) {
                build.append(str.charAt(i));
            }
        }
        return build.toString();
    }

    /*
     * Задание #2
     * Создать функцию, которая принимает массив и возвращает
     * разницу между самыми большими и самыми маленькими числами.
     */
    public int differenceMaxMin(int[] array) {
        if (array.length < 1) return 0;
        int max = array[0];
        int min = array[0];
        for (int idx = 0; idx < array.length; idx++) {
            if (array[idx] > max) max = array[idx];
            if (array[idx] < min) min = array[idx];
        }
        return max - min;
    }

    /*
     * Задание #3
     * Создать функцию, которая принимает массив в качестве аргумента и возвращает true или false
     * в зависимости от того, является ли среднее значение всех элементов массива целым числом или нет.
     */
    public boolean isAvgWhole(int[] array) {
        if (array.length < 1) return false;
        int sum = 0;
        for (int idx = 0; idx < array.length; idx++) {
            sum += array[idx];
        }

        return (sum % array.length == 0);
    }

    /*
     * Задание #4
     * Создать метод, который берет массив целых чисел и возвращает массив,
     * в котором каждое целое число является суммой самого себя + всех предыдущих чисел в массиве.
     */
    public int[] cumulativeSum(int[] array) {
        if (array.length < 1) return null;

        int[] rez = new int[array.length];
        for (int i = 0; i < rez.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum+= array[j];
            }
            rez[i] = sum;
        }

        return rez;
    }

    /*
     * Задание #5
     * Создать функцию, которая возвращает число десятичных знаков, которое имеет число (заданное в виде строки).
     * Любые нули после десятичной точки отсчитываются в сторону количества десятичных знаков.
     */
    public int getDecimalPlaces(String s) {
        if (s.indexOf(".") == -1) return 0;

        int len = s.substring(s.indexOf("."), s.length() - 1).length();
        return len;
    }

    /*
     * Задание #6
     * Создать функцию, которая при заданном числе возвращает соответствующее число Фибоначчи
     */
    public int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
     * Задание #7
     * Почтовые индексы состоят из 5 последовательных цифр.
     * Учитывая строку, написать функцию, чтобы определить, является ли вход действительным почтовым индексом.
     * Действительный почтовый индекс выглядит следующим образом:
     * – Должно содержать только цифры (не допускается использование нецифровых цифр).
     * – Не должно содержать никаких пробелов.
     * – Длина не должна превышать 5 цифр.
     */
    public boolean isValid(String address) {
        if (address.length() > 5) return false;
        if (address.indexOf(" ") != -1) return false;
        try {
            int check = Integer.parseInt(address);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*
     * Задание #8
     * Пара строк образует странную пару, если оба из следующих условий истинны:
     * – Первая буква 1-й строки = последняя буква 2-й строки.
     * – Последняя буква 1-й строки = первая буква 2-й строки.
     */
    public boolean isStrangePair (String arr1, String arr2) {
        if (arr1.length() == 0 || arr2.length() == 0) return false;
        return ((arr1.charAt(0) == arr2.charAt(arr2.length() - 1)) && (arr1.charAt(arr1.length() - 1) == arr2.charAt(0)));
    }

    /*
     * Задание #9
     * Создать две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
     * – isPrefix должен возвращать true, если он начинается с префиксного аргумента.
     * – isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
     * – В противном случае верните false.
     */
    public boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    /*
     * Задание #10
     * Создать функцию, которая принимает число (шаг) в качестве аргумента и
     * возвращает количество полей на этом шаге последовательности.
     */
    public int boxSeq(int step) {
        if (step == 0) return 0;
        if (step % 2 == 0) return step;
        return step + 2;
    }

}
