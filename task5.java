import java.util.Scanner;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Iterator;
public class task5 {
    public static void main(String[] args) {
        task5 obj = new task5();
        Scanner in = new Scanner(System.in);

        System.out.println("\n-------Exercise #1 -----------");
        int[] arr1 = obj.encrypt("Hello");
        for (int num : arr1) System.out.print(num + " ");
        System.out.println("");

        int[] arr2 = obj.encrypt("Sunshine");
        for (int num : arr2) System.out.print(num + " ");
        System.out.println("");

        System.out.println(obj.decrypt(arr1));
        System.out.println(obj.decrypt(arr2));

        System.out.println("\n-------Exercise #2 -----------");
        System.out.println(obj.canMove(figures.PAWN, "A5", "A6"));
        System.out.println(obj.canMove(figures.PAWN, "A5", "B5"));
        System.out.println(obj.canMove(figures.PAWN , "A5", "A4") + "\n");

        System.out.println(obj.canMove(figures.ROOK, "A8", "H8"));
        System.out.println(obj.canMove(figures.BISHOP, "A7", "G1"));
        System.out.println(obj.canMove(figures.QUEEN, "C4", "D6"));

        System.out.println("\n-------Exercise #3 -----------");
        System.out.println(obj.canComplete("butl", "beautiful"));
        System.out.println(obj.canComplete("butlz", "beautiful"));
        System.out.println(obj.canComplete("tulb", "beautiful"));
        System.out.println(obj.canComplete("bbutl", "beautiful"));

        System.out.println("\n" + obj.canComplete("bbutl", "bebautiful"));

        System.out.println("\n-------Exercise #4 -----------");
        System.out.println(obj.sumDigProd(16, 28));
        System.out.println(obj.sumDigProd(0));
        System.out.println(obj.sumDigProd(1, 2, 3, 4, 5, 6));


        System.out.println("\n-------Exercise #5 -----------");
        String[] array1 = { "toe", "ocelot", "maniac"};
        String[] array2 = { "many", "carriage", "emit", "apricot", "animal" };
        String[] array3 = { "hoops", "chuff", "bot", "bottom" };
        String[] rez1 = obj.sameVowelGroup(array1);
        String[] rez2 = obj.sameVowelGroup(array2);
        String[] rez3 = obj.sameVowelGroup(array3);

        for (String str : rez1) {
            System.out.print(str + " ");
        }
        System.out.println("");

        for (String str : rez2) {
            System.out.print(str + " ");
        }
        System.out.println("");

        for (String str : rez3) {
            System.out.print(str + " ");
        }
        System.out.println("");

        System.out.println("\n-------Exercise #6 -----------");
        System.out.println(obj.validateCard(1234567890123456L));
        System.out.println(obj.validateCard(1234567890123452L));


        System.out.println("\n-------Exercise #7 -----------");
        System.out.println(obj.numToEng(0));
        System.out.println(obj.numToEng(18));
        System.out.println(obj.numToEng(126));
        System.out.println(obj.numToEng(69));
        System.out.println(obj.numToEng(606));
        System.out.println(obj.numToEng(909));
        System.out.println(obj.numToEng(212));
        System.out.println(obj.numToEng(366));
        System.out.println("");
        System.out.println(obj.numToRu(0));
        System.out.println(obj.numToRu(18));
        System.out.println(obj.numToRu(126));
        System.out.println(obj.numToRu(69));
        System.out.println(obj.numToRu(606));
        System.out.println(obj.numToRu(909));
        System.out.println(obj.numToRu(212));
        System.out.println(obj.numToRu(366));


        System.out.println("\n-------Exercise #8 -----------");
        System.out.println(obj.getSha256Hash("password1234"));

        System.out.println("\n-------Exercise #9 -----------");
        System.out.println(obj.correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(obj.correctTitle("sansa stark, lady of winterfell."));
        System.out.println(obj.correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println(obj.correctTitle("the king of the night"));

        System.out.println("\n-------Exercise #10 -----------");
        System.out.println(obj.hexLattice(1));
        System.out.println("");
        System.out.println(obj.hexLattice(7));
        System.out.println("");
        System.out.println(obj.hexLattice(19));
        System.out.println("");
        System.out.println(obj.hexLattice(21));
        System.out.println("");
        System.out.println(obj.hexLattice(36));
        System.out.println("");
        System.out.println(obj.hexLattice(37));


    }

    /*
     * Задание #1
     * Создайте две функции, которые принимают строку и массив и возвращают закодированное или
     * декодированное сообщение. Первая буква строки или первый элемент массива представляет
     * собой символьный код этой буквы. Следующие элементы-это различия между символами:
     * например, A + 3 --> C или z - 1 --> y
     */
    public int[] encrypt(String toCode) {
        if (toCode.length() < 1) return null;
        int[] arr = new int[toCode.length()];
        arr[0] = toCode.charAt(0);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = toCode.charAt(i) - toCode.charAt(i - 1);
        }
        return arr;
    }

    public String decrypt(int[] codes) {
        StringBuilder build = new StringBuilder();
        build.append((char)codes[0]);
        for (int i = 1; i < codes.length; i++) {
            build.append((char)(build.charAt(i - 1) + codes[i]));
        }
        return build.toString();
    }

    /*
     * Задание #2
     * Создайте функцию, которая принимает имя шахматной фигуры, ее положение и целевую позицию.
     * Функция должна возвращать true, если фигура может двигаться к цели, и false, если она не может этого сделать.
     * Возможные входные данные - "пешка", "конь", "слон", "Ладья", "Ферзь" и " король".
     */
    public boolean canMove(figures figure, String from, String to) {
        int[] s = new int[2];
        s[0] = from.charAt(0) - 'A' + 1;
        s[1] = Integer.parseInt(from.substring(1));

        int[] e = new int[2];
        e[0] = to.charAt(0) - 'A' + 1;
        e[1] = Integer.parseInt(to.substring(1));

        if (figure == figures.PAWN) {
            if ((e[0] - s[0] == 0) & (e[1] - s[1] == 1)) return true;
            return false;
        }
        if (figure == figures.HORSE) {
            if (Math.abs(e[0] - s[0]) == 1 & Math.abs(e[1] - s[1]) == 2) return true;
            if (Math.abs(e[0] - s[0]) == 2 & Math.abs(e[1] - s[1]) == 1) return true;
            return false;
        }
        if (figure == figures.BISHOP) {
            if (Math.abs(e[0] - s[0]) == Math.abs(e[1] - s[1])) return true;
            return false;
        }
        if (figure == figures.ROOK) {
            if (Math.abs(e[0] - s[0]) == 0 & Math.abs(e[1] - s[1]) != 0) return true;
            if (Math.abs(e[0] - s[0]) != 0 & Math.abs(e[1] - s[1]) == 0) return true;
            return false;
        }
        if (figure == figures.QUEEN) {
            if (canMove(figures.ROOK, from, to)) return true;
            if (canMove(figures.BISHOP, from, to)) return true;
            return false;
        }
        if (figure == figures.KING) {
            if (Math.abs(e[0] - s[0]) < 2 & Math.abs(e[1] - s[1]) < 2) return true;
            return false;
        }
        return false;
    }

    public enum figures {
        PAWN,
        HORSE,
        BISHOP,
        ROOK,
        QUEEN,
        KING
    }

    /*
     * Задание #3
     * Входная строка может быть завершена, если можно добавить дополнительные буквы,
     * и никакие буквы не должны быть удалены, чтобы соответствовать слову.
     * Кроме того, порядок букв во входной строке должен быть таким же, как и порядок букв в последнем слове.
     */
    public boolean canComplete(String s1, String s2) {
        if (s1.charAt(0) != s2.charAt(0)) return false;
        if (s1.charAt(s1.length() - 1) != s2.charAt(s2.length() - 1)) return false;

        int lastLetter = 0;
        for (int i = 0; i < s1.length(); i++) {
            int nowLetter = s2.indexOf(s1.charAt(i), lastLetter);
            if (nowLetter == -1) return false;
            //if (nowLetter < lastLetter) return false;
            lastLetter = nowLetter + 1;
        }
        return true;
    }

    /*
     * Задание #4
     * Создайте функцию, которая принимает числа в качестве аргументов,
     * складывает их вместе и возвращает произведение цифр до тех пор, пока ответ не станет длиной всего в 1 цифру.
     */
    public int sumDigProd(int...array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];


        int numSum = 0;
        for (int i : array) numSum += i;
        if (String.valueOf(numSum).length() == 1) return numSum;


        int num = numSum;
        while (String.valueOf(num).length() != 1) {
            int numMult = 1;
            while (num / 10 > 0) {
                numMult *= num % 10;
                num /= 10;
            }
            numMult *= num;

            num = numMult;
        }

        return num;
    }

    /*
     * Задание #5
     * Напишите функцию, которая выбирает все слова,
     * имеющие все те же гласные (в любом порядке и / или количестве), что и первое слово, включая первое слово.
     */
    public String[] sameVowelGroup(String[] args) {
        if (args.length == 1) return args;

        int trueSize = 0;
        String[] rez = new String[args.length];

        char[] template = {'a', 'e', 'i', 'o', 'u', 'y'};
        StringBuilder mod = new StringBuilder(args[0]);

        // Удаление согласных
        for (int i = 0; i < mod.length(); i++) {
            boolean isVowel = false;
            for (int j = 0; j < template.length; j++) {
                if (template[j] == mod.charAt(i)) {
                    isVowel = true;
                    break;
                }
            }
            if (!isVowel) {
                mod.delete(i, i + 1);
                i -= 1;
            }
        }

        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < mod.length(); i++) {
            set.add(String.valueOf(mod.charAt(i)));
        }

        for (String str : args) {
            Iterator value = set.iterator();
            boolean isSame = true;
            while (value.hasNext()) {
                if (str.indexOf((String)value.next()) == -1) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                rez[trueSize++] = str;
            }
        }

        String[] rez2 = new String[trueSize];
        for (int i = 0; i < rez2.length; i++) {
            rez2[i] = rez[i];
        }

        return rez2;
    }

    /*
     * Задание #6
     * Создайте функцию, которая принимает число в качестве аргумента и возвращает true,
     * если это число является действительным номером кредитной карты, а в противном случае-false.
     * Номера кредитных карт должны быть длиной от 14 до 19 цифр и проходить тест Луна, описанный ниже:
     * 	– Удалите последнюю цифру (это"контрольная цифра").
     * 	– Переверните число.
     * 	– Удвойте значение каждой цифры в нечетных позициях.
     * Если удвоенное значение имеет более 1 цифры, сложите цифры вместе (например, 8 x 2 = 16 --> 1 + 6 = 7).
     * 	– Добавьте все цифры. – Вычтите последнюю цифру суммы (из шага 4) из 10.
     * Результат должен быть равен контрольной цифре из Шага 1.
     */
    public boolean validateCard(long card) {
        int len = String.valueOf(card).length();
        if (len < 14 | len > 19) return false;

        int[] mcard = new int[len - 1];
        long pseudoCard = card / 10;

        for (int i = 0; i < mcard.length; i++) {
            mcard[i] = (int)(pseudoCard % 10);
            pseudoCard /= 10;
        }

        for (int i = 0; i < mcard.length; i += 2) {
            mcard[i] *= 2;

            String value = String.valueOf(mcard[i]);
            if (value.length() == 1) continue;

            while (value.length() > 1) {
                int sum = 0;
                int intValue = mcard[i];
                while(intValue > 0) {
                    sum += intValue % 10;
                    intValue /= 10;
                }
                value = String.valueOf(sum);
            }

            mcard[i] = Integer.parseInt(value);
        }

        long bigSum = 0;
        for (int i = 0; i < mcard.length; i++) bigSum += mcard[i];

        return ((10 - bigSum % 10) == (card % 10));
    }

    /*
     * Задание #7
     * Напишите функцию, которая принимает положительное целое число от 0 до 999 включительно
     * и возвращает строковое представление этого целого числа, написанное на английском языке.
     */
    public String numToEng(int num) {

        String[] units = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        String[] tens = {
                "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred"	};
        String[] fromTenToTwenty = {
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };
        String[] bigNums = { "hundred" };

        String num_str = String.valueOf(num);

        if (num_str.length() == 1) return units[num];

        if (num_str.length() == 2) {
            if (num / 10 == 1) return fromTenToTwenty[num % 10];
            if (num % 10 == 0) return tens[num / 10];
            return tens[num / 10] + " " + units[num % 10];
        }
        if (num_str.length() == 3) {
            // Окончание "s" у 300, 600, 900
            String additional = ((num / 100) == 6 | (num / 100) == 9) ? "s" : "";
            return units[num / 100] + " " + bigNums[0]  + additional + " " +numToEng(num % 100);
        }
        return null;
    }

    public String numToRu(int num) {
        String[] units = {
                "ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять" };
        String[] fromTenToTwenty = {
                "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемнадцать", "девятнадцать" };
        String[] tens = {
                "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "весемьдесят",
                "девяносто"	};
        String[] bigNums = {
                "",  "сто",  "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот",
                "девятьсот"
        };

        String num_str = String.valueOf(num);

        if (num_str.length() == 1) return units[num];

        if (num_str.length() == 2) {
            if (num / 10 == 1) return fromTenToTwenty[num % 10];
            if (num % 10 == 0) return tens[num / 10];
            return tens[num / 10] + " " + units[num % 10];
        }
        if (num_str.length() == 3) {
            return bigNums[num / 100] + " " + numToRu(num % 100);
        }

        return null;
    }

    /*
     * Задание #8
     * Создайте функцию, которая возвращает безопасный хеш SHA-256
     * для данной строки. Хеш должен быть отформатирован в виде шестнадцатеричной цифры.
     */
    public String getSha256Hash(String toCode) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(toCode.getBytes(StandardCharsets.UTF_8));

            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32)
            {
                hexString.insert(0, '0');
            }

            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /*
     * Задание #9
     * Напишите функцию, которая принимает строку и возвращает строку
     * с правильным регистром для заголовков символов в серии "Игра престолов".
     * Слова and, the, of и in должны быть строчными. Все остальные слова должны иметь первый символ в
     * верхнем регистре, а остальные-в Нижнем
     */
    public String correctTitle(String line) {

        String[] mline = line.toLowerCase().split(" ");
        StringBuilder build = new StringBuilder();
        for (String word : mline) {
            switch (word) {
                case "and":
                case "or":
                case "of":
                case "in":
                case "above":
                case "under":
                case "the":
                    if (word == mline[0]) {
                        build.append(word.substring(0, 1).toUpperCase() + word.substring(1));
                        build.append(" ");
                        break;
                    }
                    build.append(word);
                    build.append(" ");
                    break;
                default:
                    build.append(word.substring(0, 1).toUpperCase() + word.substring(1));
                    build.append(" ");
                    break;
            }
        }
        return build.toString();
    }

    /*
     * Задание #10
     * Гексагональная решетка - это привычная двумерная решетка, в которой каждая точка имеет 6 соседей.
     * Центрированное шестиугольное число - это центрированное фигурное число, представляющее шестиугольник
     * с точкой в центре и всеми другими точками, окружающими центральную точку в шестиугольной решетке.
     *
     * Напишите функцию, которая принимает целое число n и возвращает "недопустимое",
     * если n не является центрированным шестиугольным числом или его иллюстрацией
     * в виде многострочной прямоугольной строки в противном случае.
     */
    public String hexLattice(int amount) {
        final int step = 6;
        final int start = 1;

        if (amount == 1) return "o";

        int count = 1;
        int move = start;
        while ((move += step * count++) < amount);
        if (move != amount) return "Invalid";

        int lenX, lenY;
        lenX = lenY = count + count - 1;

        StringBuilder build = new StringBuilder();

        final int maxLinePointAmount = lenX;
        int linePointAmount = count;

        int operation = 1;
        for (int i = 0; i < lenY; i++) {

            int numOfSpaces = maxLinePointAmount - linePointAmount;
            while (numOfSpaces-- > 0) build.append(" ");

            for (int j = 0; j < linePointAmount; j++) {
                build.append("o ");
            }

            linePointAmount += operation;
            if (linePointAmount == maxLinePointAmount) operation = -1;

            build.replace(build.length() - 1, build.length(), "\n");
        }

        return build.toString();
    }
}
