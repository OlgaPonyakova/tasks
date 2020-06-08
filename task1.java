import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        task1 obj = new task1();
        Scanner in = new Scanner(System.in);



        System.out.print("Enter a: ");
        int a = in.nextInt();
        System.out.print("Enter b: ");
        int b = in.nextInt();
        System.out.println(obj.remainder(a, b));

		System.out.print("Enter height of triangle: ");
		double h = in.nextDouble();
		System.out.print("Enter width of triangle base: ");
		double c = in.nextDouble();
		System.out.println(obj.triArea(h, c));




		System.out.print("Enter amount of chickens on farm: ");
		int chickens = in.nextInt();
		System.out.print("Enter amount of cows on farm: ");
		int cows = in.nextInt();
		System.out.print("Enter amount of pigs on farm: ");
		int pigs = in.nextInt();
		System.out.println(obj.animals(chickens, cows, pigs));



		System.out.print("Enter prob: ");
		double prob = in.nextDouble();
		System.out.print("Enter price: ");
		double price = in.nextDouble();
		System.out.print("Enter pay: ");
		double pay = in.nextDouble();
		System.out.println(obj.profitableGamble(prob, price, pay));


		System.out.print("Enter number 1: ");
		double oper1 = in.nextDouble();
		System.out.print("Enter number 2: ");
		double oper2 = in.nextDouble();
		System.out.print("Enter fin number: ");
		double oper3 = in.nextDouble();
		System.out.println(obj.profitableGamble(oper3, oper1, oper2));



		System.out.print("Enter ASCII char to get it number code: ");
		String ch = in.next();
		System.out.println(obj.ctoa(ch.charAt(0)));



		System.out.print("Enter number for sum sequence: ");
		int lineNumber = in.nextInt();
		System.out.println(obj.addUpTo(lineNumber));



		System.out.print("Enter first edge: ");
		int edge1 = in.nextInt();
		System.out.print("Enter second edge: ");
		int edge2 = in.nextInt();
		System.out.println(obj.nextEdge(edge1, edge2));



		System.out.print("Enter number array (write numbers across the space):\n");
		String[] lines = in.nextLine().split(" ");
		int[] mas = new int[lines.length];

		for (int i = 0; i < mas.length; i++) {
			mas[i] = Integer.parseInt(lines[i]);
		}

		System.out.println(obj.sumOfCubes(mas));


    }

    /*
     * Задание #1
     * Функция выводит остаток от деления первого аргумента на второй
     */
    public int remainder(int a, int b) {
        return a % b;
    }

    /*
     * Задание #2
     * Функция расчитывает площадь треугольника.
     * Принимает высоту и ширину основания
     */
    public double triArea(double h, double a) {
        return 0.5 * a * h;
    }

    /*
     * Задание #3
     * Функция расчитывает количество ног животных по их количеству на ферме.
     * Принимает количество курей, коров, и свиней.
     */
    public int animals(int ch, int co, int pi) {
        return ch * 2 + co * 4 + pi * 4;
    }

    /*
     * Задание #4
     * Функция возвращает true, если prob * prize > pay; в противном случае возвращает false.
     * Принимает принимает три аргумента (prob, prize, pay).
     */
    public boolean profitableGamble(double prob, double prize, double pay) {
        return prob * prize > pay;
    }

    /*
     * Задание #5
     * Функция возвращает действие, которое нужно совершить над a и b
     * Принимает три аргумента (n, a, b).
     */
    public String operation(double n, double a, double b) {

        if (Math.abs(a + b - n) < 0.000001) return "added";
        if (Math.abs(Math.abs(a - b) - n) < 0.000001) return "subtracted";

        // Здесь 2 варианта, так как при изменении порядка - меняется результат
        if (Math.abs(a / b - n) < 0.000001) return "divided";
        if (Math.abs(b / a - n) < 0.000001) return "divided";
        if (Math.abs(a * b - n) < 0.000001) return "multiplied";
        return "none";
    }

    /*
     * Задание #6
     * Функция возвращает значение ASCII переданного символ
     * ASCII символа
     */
    public int ctoa(char ch) {

        return ch;
    }

    /*
     * Задание #7
     * Функция возвращает сумму всех чисел до введённого числа и включая его.
     * Одно целочисленное значение
     */
    public int addUpTo(int a) {
        if (a == 0) return 0;
        return a + this.addUpTo(a - 1);
    }

    /*
     * Задание #8
     * Функция находит максимальное значение третьего ребра треугольника.
     * Вводятся два ребра треугольника
     */
    public int nextEdge(int a, int b) {
        double a1 = a;
        double b1 = b;
        double sum = Math.sqrt(a1 * a1 + b1 * b1 - 2 * a1 * b1 * Math.cos(0));
        int maxI = 0;

        for (int i = 0; i < 180; i++) {
            double rez = Math.sqrt(a1 * a1 + b1 * b1 - 2 * a1 * b1 * Math.cos(i));
            if (rez > sum ) {
                sum = rez;
                maxI = i;
            }
        }

        return (int)sum;
    }

    /*
     * Задание #9
     * Функция принимает массив чисел и возвращает сумму кубов его элементов.
     */
    public int sumOfCubes(int[] a) {
        int rez = 0;
        for (int num : a) {
            rez += Math.pow(num, 3);
        }
        return rez;
    }

    /*
     * Задание #10
     * Функция производит следующее вычисление: прибавляет число А  В раз,
     * 	после чего проверяет, делится ли полученное число на С.
     * Входные параметры: А, В, С - целые числа
     * Выходной параметр - boolean.
     */
    public boolean abcMath(int a, int b, int c) {
        int rez = a;
        for (int i = 0; i < b; i++) {
            rez += rez;

        }
        return rez % c == 0;
    }
}
