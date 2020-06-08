import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        task3 obj = new task3();
        Scanner in = new Scanner(System.in);


        System.out.print("Enter a - parameter: ");
        int n1 = in.nextInt();
        System.out.print("Enter b - parameter: ");
        int n2 = in.nextInt();
        System.out.print("Enter c - parameter: ");
        int n3 = in.nextInt();
        System.out.println(obj.solutions(n1, n2, n3));



		System.out.print("Enter zippy-zip line: ");
		String l1 = in.nextLine();
		System.out.println(obj.findZip(l1));



		System.out.print("Enter number to check it perfection: ");
		int n4 = in.nextInt();
		System.out.println(obj.checkPerfect(n4));


		System.out.print("Enter line: ");
		String l2 = in.nextLine();
		System.out.println(obj.flipEndChars(l2));



		System.out.print("Enter hex-code: ");
		String l3 = in.nextLine();
		System.out.println(obj.isValidHexCode(l3));



		System.out.println("Enter first array (across space every number): ");
		String[] lines1 = in.nextLine().split(" ");
		int[] mas1 = new int[lines1.length];
		for (int i = 0 ; i < mas1.length; i++) mas1[i] = Integer.parseInt(lines1[i]);

		System.out.println("Enter second array (across space every number): ");
		String[] lines2 = in.nextLine().split(" ");
		int[] mas2 = new int[lines2.length];
		for (int i = 0 ; i < mas2.length; i++) mas2[i] = Integer.parseInt(lines2[i]);

		System.out.println(obj.same(mas1, mas2));



		System.out.print("Enter number to check is it Kaprekar: ");
		int n5 = in.nextInt();
		System.out.println(obj.isKaprekar(n5));



		System.out.print("Enter zero-one sequence: ");
		String l4 = in.nextLine();
		System.out.println(obj.longestZero(l4));


		System.out.print("Enter number to find next Prime: ");
		int n6 = in.nextInt();
		System.out.println(obj.nextPrime(n6));



		System.out.print("Enter first edge of triangle: ");
		int n7 = in.nextInt();
		System.out.print("Enter second edge of triangle: ");
		int n8 = in.nextInt();
		System.out.print("Enter third edge of triangle: ");
		int n9 = in.nextInt();
		System.out.println(obj.rightTriangle(n7, n8, n9));

    }

    /*
     * Задание #1
     * Квадратное уравнение ax2 + bx + c = 0 имеет либо 0, либо 1, либо 2 различных решения для действительных значений x.
     * учитывая a, b и c, вы должны вернуть число решений в уравнение.
     */
    public int solutions(int a, int b, int c) {
        int rez = b * b - 4 * a * c;
        if (rez < 0) return 0;
        if (rez > 1) return 2;
        return 1;
    }

    /*
     * Задание #2
     * Напишите функцию, которая возвращает позицию второго вхождения " zip " в строку, или -1,
     * если оно не происходит по крайней мере дважды. Ваш код должен быть достаточно общим,
     * чтобы передать все возможные случаи, когда "zip" может произойти в строке.
     */
    public int findZip(String str) {
        return str.substring(str.indexOf("zip") + "zip".length()).indexOf("zip");
    }

    /*
     * Задание #3
     * Создайте функцию, которая проверяет, является ли целое число совершенным числом или нет.
     * Совершенное число - это число, которое можно записать как сумму его множителей, исключая само число.
     */
    public boolean checkPerfect(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        return num == sum;
    }

    /*
     * Задание #4
     * Создайте функцию, которая принимает строку и возвращает новую строку с заменой ее первого и последнего символов,
     * за исключением трех условий:
     * – Если длина строки меньше двух, верните "несовместимо".".
     * – Если первый и последний символы совпадают, верните "два-это пара.".
     */
    public String flipEndChars(String s) {
        if (s.length() < 2) return "Incompatible";
        if (s.charAt(0) == s.charAt(s.length() - 1)) return "Two is pair";
        return s.replace(s.charAt(0), s.charAt(s.length() - 1));

    }

    /*
     * Задание #5
     * Создайте функцию, которая определяет, является ли строка допустимым шестнадцатеричным кодом.
     * Шестнадцатеричный код должен начинаться с фунтового ключа # и иметь длину ровно 6 символов.
     * Каждый символ должен быть цифрой от 0-9 или буквенным символом от A-F.
     * все буквенные символы могут быть прописными или строчными
     */
    public boolean isValidHexCode(String code) {
        if (code.length() != 7) return false;
        if (!code.startsWith("#")) return false;
        char[] cb = code.substring(1).toCharArray();
        for (int i = 0; i < cb.length; i++) {
            boolean isValid = false;
            if (cb[i] >= '0' & cb[i] <= '9') isValid = true;
            if (cb[i] >= 'A' & cb[i] <= 'F') isValid = true;
            if (cb[i] >= 'a' & cb[i] <= 'f') isValid = true;
            if (!isValid) return false;
        }
        return true;
    }

    /*
     * Задание #6
     * Напишите функцию, которая возвращает true, если два массива имеют одинаковое количество уникальных элементов,
     * и false в противном случае.
     *
     * Вообще тут 3 способа:
     * - посчитать прямо O(n*n)
     * - сначала отсортировать и пробежаться за О(n)
     * - поместить массивы в множества
     */
    public boolean same(int[] arr1, int[] arr2) {
        if (arr1.length < 1 || arr2.length < 1) return false;

        int count1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            int j;
            for (j = 0; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) break;
            }
            if (i == j) count1++;
        }

        int count2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            int j;
            for (j = 0; j < arr2.length; j++) {
                if (arr2[i] == arr2[j]) break;
            }
            if (i == j) count2++;
        }

        return count1 == count2;
    }

    /*
     * Задание #7
     * Число Капрекара-это положительное целое число, которое после возведения в квадрат и разбиения на две
     * лексикографические части равно сумме двух полученных новых чисел:
     * - Если количество цифр квадратного числа четное, то левая и правая части будут иметь одинаковую длину.
     * -  Если количество цифр квадратного числа нечетно, то правая часть будет самой длинной половиной,
     * а левая-самой маленькой или равной нулю, если количество цифр равно 1.
     * -
     */
    public boolean isKaprekar(int n) {
        if (n == 0 || n == 1) return true;

        int n2 = n * n;

        int temp = n2;
        int nlen = 1;

        // Нахождение длины числа
        while ((temp /= 10) > 0) {
            nlen++;
        }

        // Если будет нечётное количество цифр (число несимметрично), то произойдёт округление в меньшую сторону
        int leftPart = nlen / 2;
        int rightPart = nlen - leftPart;

        // Получаем правое и левое числа
        int rightNum = (int)(n2 % Math.pow(10, rightPart));
        int leftNum = (int)(n2 / Math.pow(10, rightPart));

        return n == (leftNum + rightNum);
    }

    /*
     * Задание #8
     * Напишите функцию, которая возвращает самую длинную последовательность последовательных нулей в двоичной строке.
     */
    public String longestZero(String arg) {
        char[] argB = arg.toCharArray();
        int maxLen = 1; // Условно 1, на самом деле здесь 0, и всё решают границы, которые объявлены ниже
        int idxS = 0;
        int idxE = 1;
        for (int i = 0; i < argB.length - 1; i++) {
            if (argB[i] != '0') continue;

            if (argB[i] == argB[i + 1]) {
                int j = i;
                int len = 1;
                while ((argB[i] == argB[j++]) & (j < argB.length)) {
                    len++;
                }
                if (len > maxLen) {
                    maxLen = len;
                    idxS = i;
                    idxE = j;
                }
                i = j - 1;
            }
        }

        if (idxS == 0 & idxE == 0 & arg.endsWith("0")) {
            idxS = arg.length() - 1;
            idxE = arg.length();
        }

        return arg.substring(idxS, idxE - 1);

    }

    /*
     * Задание #9
     * Если задано целое число, создайте функцию,
     * которая возвращает следующее простое число. Если число простое, верните само число
     */
    public int nextPrime(int num) {
        int enters = 0;
        for (int i = 1; i < num; i++) if (num % i == 0) enters++;
        if (enters == 1) return num;

        num += 1;
        while (true) {
            enters = 0;
            for (int i = 1; i < num; i++) if (num % i == 0) enters++;
            if (enters == 1) return num;
            num += 1;
        }
    }

    /*
     * Задание #10
     * Учитывая три числа, x, y и z, определите, являются ли они ребрами прямоугольного треугольника
     */
    public boolean rightTriangle(int x, int y, int z) {
        if (Math.abs(Math.sqrt(x * x + y * y) - z) < (0.0000001)) return true;
        if (Math.abs(Math.sqrt(y * y + z * z) - x) < (0.0000001)) return true;
        if (Math.abs(Math.sqrt(x * x + z * z) - y) < (0.0000001)) return true;
        return false;
    }
}
