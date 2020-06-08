import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class task6 {
    public static void main(String[] args) {
        task6 obj = new task6();
        Scanner in = new Scanner(System.in);


        System.out.println("\n-------Exercise #1 -----------");
        System.out.println(obj.bell(0));
        System.out.println(obj.bell(1));
        System.out.println(obj.bell(2));
        System.out.println(obj.bell(3));
        System.out.println(obj.bell(4));
        System.out.println(obj.bell(5));
        System.out.println(obj.bell(6));
        System.out.println(obj.bell(7));
        System.out.println(obj.bell(8));
        System.out.println(obj.bell(9));
        System.out.println(obj.bell(10));


        System.out.println("\n-------Exercise #2 -----------");
        System.out.println(obj.translateWord("flag"));
        System.out.println(obj.translateWord("Apple"));
        System.out.println(obj.translateWord("Apple"));
        System.out.println(obj.translateWord(""));
        System.out.println(obj.translateSentence("I like to eat honey waffles."));
        System.out.println(obj.translateSentence("Do you think it is going to rain today?"));


        System.out.println("\n-------Exercise #3 -----------");
        System.out.println(obj.validColor("rgb(0,0,0)"));
        System.out.println(obj.validColor("rgb(0,,0)"));
        System.out.println(obj.validColor("rgba(0,0,0,0.123456789)"));
        System.out.println(obj.validColor("rgb(2.8,2.0003,1)"));


        System.out.println("\n-------Exercise #4 -----------");
        System.out.println(obj.stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(obj.stripUrlParams("https://edabit.com?a=1&b=2&a=2", "b"));
        System.out.println(obj.stripUrlParams("https://edabit.com", "b"));


        System.out.println("\n-------Exercise #5 -----------");
        System.out.println(Arrays.toString(obj.getHashTags(
                "How the Avocado Became the Fruit of the Global Trade")));
        System.out.println();

        System.out.println(Arrays.toString(obj.getHashTags(
                "Why You Will Probably Pay More for Your Christmas Tree This Year")));
        System.out.println();

        System.out.println(Arrays.toString(obj.getHashTags(
                "Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
        System.out.println();

        System.out.println(Arrays.toString(obj.getHashTags(
                "Visualizing Science")));


        System.out.println("\n-------Exercise #6 -----------");
        System.out.println(obj.ulam(0));
        System.out.println(obj.ulam(1));
        System.out.println(obj.ulam(2));
        System.out.println(obj.ulam(3));
        System.out.println(obj.ulam(4));
        System.out.println(obj.ulam(5));
        System.out.println(obj.ulam(6));
        System.out.println(obj.ulam(7));
        System.out.println(obj.ulam(8));
        System.out.println(obj.ulam(9));
        System.out.println(obj.ulam(10));
        System.out.println(obj.ulam(100));


        System.out.println("\n-------Exercise #7 -----------");
        System.out.println(obj.longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(obj.longestNonrepeatingSubstring("aaaaaa"));
        System.out.println(obj.longestNonrepeatingSubstring("abcde"));
        System.out.println(obj.longestNonrepeatingSubstring("abcda"));


        System.out.println("\n-------Exercise #8 -----------");
        System.out.println(obj.convertToRoman(2));
        System.out.println(obj.convertToRoman(12));
        System.out.println(obj.convertToRoman(16));
        System.out.println(obj.convertToRoman(999));
        System.out.println(obj.convertToRoman(201));
        System.out.println(obj.convertToRoman(4573));


        System.out.println("\n-------Exercise #9 -----------");
        System.out.println(obj.formula("6 * 4 = 24"));
        System.out.println(obj.formula("18 / 17 = 2"));
        System.out.println(obj.formula("16 * 10 = 160 = 14 + 120"));
        System.out.println(obj.formula("18 /  = 2"));


        System.out.println("\n-------Exercise #10 -----------");
        System.out.println(obj.palindromeDescendant(123312));
        System.out.println(obj.palindromeDescendant(123413));
        System.out.println(obj.palindromeDescendant(13001120));
        System.out.println(obj.palindromeDescendant(23336014));
        System.out.println(obj.palindromeDescendant(11));


    }

    /*
     * Задание #1
     * Число Белла - это количество способов, которыми массив из n элементов может быть разбит на непустые подмножества.
     * Создайте функцию, которая принимает число n и возвращает соответствующее число Белла.
     */
    public int bell(int n) {

        if (n == 0 | n == 1) return 1;
        if (n == 2) return 2;

        int[][] bell_triangle = new int[n][];

        int[] firstArray = { 1 };
        bell_triangle[0] = firstArray;

        int steps = n - 1;
        int nowArray = 1;
        while (steps-- > 0) {

            int lenOfLastArray = bell_triangle[nowArray - 1].length;
            int[] array = new int[lenOfLastArray + 1];
            int lastValue_in_lastArray = bell_triangle[nowArray - 1][lenOfLastArray - 1];
            array[0] = lastValue_in_lastArray;

            for (int i = 1; i < array.length; i++) {
                array[i] = array[i - 1] + bell_triangle[nowArray - 1][i - 1];
            }

            bell_triangle[nowArray] = array;

            nowArray++;
        }

        int lenOfLastArray = bell_triangle[nowArray - 1].length;
        return bell_triangle[nowArray - 1][lenOfLastArray - 1];
    }

    /*
     * Задание #2
     * Напишите две функции, чтобы сделать переводчик с английского на свинский латинский.
     * Первая функция translateWord (word) получает слово на английском и возвращает это слово,
     * 		переведенное на латинский язык.
     * Вторая функция translateSentence (предложение) берет английское предложение и возвращает это предложение,
     * 		переведенное на латинский язык.
     *
     * В «поросячей латыни» (свинский латинский) есть два очень простых правила:
     * – Если слово начинается с согласного,
     * 		переместите первую букву (буквы) слова до гласного до конца слова и добавьте «ay» в конец.
     * - Если слово начинается с гласной, добавьте "yay" в конце слова.
     *
     */
    public String translateWord(String word) {
        if (word == null | word.length() == 0) return "";

        StringBuilder work_word = new StringBuilder(word);
        StringBuilder partToMove = new StringBuilder();
        char[] letters = {'a', 'e', 'i', 'o', 'u', 'y'};

        for (int i = 0; i < word.length(); i++) {
            boolean isConsonant = true;
            for (int j = 0; j < letters.length; j++)
                if (work_word.substring(i, i + 1).toLowerCase().charAt(0) == letters[j]) isConsonant = false;

            if (isConsonant) {
                partToMove.append(work_word.charAt(i));
                continue;
            }
            else {
                break;
            }
        }

        if (partToMove.length() != 0) {
            work_word.append(partToMove);
            work_word.delete(0, partToMove.length());
            work_word.append("ay");

        } else {
            work_word.append("yay");
        }

        return work_word.toString();
    }

    public String translateSentence(String line) {
        if (line == null | line.length() == 0) return "";

        String[] words = line.split(" ");
        StringBuilder build = new StringBuilder();
        int count = -1;
        for (String word : words) {
            count++;
            if (word.endsWith(".") | word.endsWith("?") | word.endsWith(",") | word.endsWith("!")) {
                build.append(translateWord(word.substring(0, word.length() - 1)));
                build.append(word.charAt(word.length() - 1));
                build.append(" ");
                continue;
            }
            if (word.equals(".") | word.equals("?") | word.equals(",") | word.equals("!")) {
                build.append(word);
                build.append(" ");
                continue;
            }

            String startChar = word.substring(0, 1);
            if (startChar.toUpperCase().charAt(0) == words[count].charAt(0)) {
                String encode_word = translateWord(word).toLowerCase();
                encode_word = encode_word.substring(0, 1).toUpperCase() + encode_word.substring(1);

                build.append(encode_word);
                build.append(" ");
            }
            else {
                build.append(translateWord(word));
                build.append(" ");
            }
        }
        return build.substring(0, build.length() - 1);
    }

    /*
     * Задание #3
     * Учитывая параметры RGB (A) CSS, определите, является ли формат принимаемых значений допустимым или нет.
     * Создайте функцию, которая принимает строку (например, " rgb(0, 0, 0)") и возвращает true, если ее формат
     * правильный, в противном случае возвращает false.
     */
    public boolean validColor(String color) {

        StringBuilder build = new StringBuilder(color);

        try {
            build.delete(0, build.indexOf("(") + 1);
            build.delete(build.indexOf(")"), build.length());
        } catch (Exception e) { return false; }

        while (build.indexOf(" ") != -1) {
            build.delete(build.indexOf(" "), build.indexOf(" ") + 1);
        }

        String[] nums = build.toString().split(",");

        double[] array = new double[nums.length];
        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = Double.parseDouble(nums[i]);
            }
        } catch (Exception e) { return false; }

        String format = color.substring(0, color.indexOf("("));
        switch (format) {
            case "rgb":
                if (array.length != 3) return false;
                for (double a : array) {
                    if (BigDecimal.valueOf(a).intValue() != a) return false;
                    if (a > 255 | a < 0) return false;
                }
                break;
            case "rgba":
                if (array.length != 4) return false;
                if (array[3] < 0 | array[3] > 1) return false;
                if (array[0] > 255 | array[0] < 0) return false;
                if (array[1] > 255 | array[1] < 0) return false;
                if (array[2] > 255 | array[2] < 0) return false;
                break;
            default:
                return false;
        }

        return true;

    }

    /*
     * Задание #4
     * Создайте функцию, которая принимает URL (строку), удаляет дублирующиеся параметры запроса и параметры,
     * указанные во втором аргументе (который будет необязательным массивом).
     */
    public String stripUrlParams(String url, String...toDelete) {
        if (url.indexOf("?") == -1) return url;
        boolean needToDel = (toDelete.length > 0) ? true : false;

        String[] list = url.substring(url.indexOf("?") + 1).split("&");

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                String p1 = list[i].substring(0, list[i].indexOf("="));
                String p2 = list[j].substring(0, list[j].indexOf("="));
                if (p1.equals(p2) | (needToDel && p1.equals(toDelete[0]))) {
                    list[i] = "";
                }
            }
        }

        StringBuilder build = new StringBuilder();
        for (String str : list) {
            if (str != "") {
                build.append(str);
                build.append("&");
            }
        }
        build.delete(build.length() - 1, build.length());

        return url.substring(0, url.indexOf("?") + 1) + build.toString();
    }

    /*
     * Задание #5
     * Напишите функцию, которая извлекает три самых длинных слова из заголовка газеты и преобразует их в хэштеги.
     * Если несколько слов одинаковой длины, найдите слово, которое встречается первым.
     */
    public String[] getHashTags(String line) {
        StringBuilder clearFromSymbols = new StringBuilder(line.toLowerCase());

        while (true) {
            if (clearFromSymbols.indexOf(",") != -1) {
                clearFromSymbols.delete(clearFromSymbols.indexOf(","), clearFromSymbols.indexOf(",") + 1);
                continue;
            }
            if (clearFromSymbols.indexOf("!") != -1) {
                clearFromSymbols.delete(clearFromSymbols.indexOf("!"), clearFromSymbols.indexOf("!") + 1);
                continue;
            }
            if (clearFromSymbols.indexOf("?") != -1) {
                clearFromSymbols.delete(clearFromSymbols.indexOf("?"), clearFromSymbols.indexOf("?") + 1);
                continue;
            }
            if (clearFromSymbols.indexOf(".") != -1) {
                clearFromSymbols.delete(clearFromSymbols.indexOf("."), clearFromSymbols.indexOf(".") + 1);
                continue;
            }
            break;
        }

        String[] words = clearFromSymbols.toString().split(" ");


        String[] results = new String[(words.length < 3) ? words.length : 3];
        Comparator<String> sortStringsByLen = (String s1, String s2) -> s2.length() - s1.length();
        Arrays.sort(words, sortStringsByLen);

        for (int i = 0; i < results.length; i++) {
            results[i] = "#" + words[i];
        }

        return results;
    }

    /*
     * Задание #6
     * Создайте функцию, которая принимает число n и возвращает n-е число в последовательности Улама.
     *
     * Последовательность Улама начинается с чисел 1, 2
     * Следующее число в последовательности - это наименьшее положительное число,
     * равное сумме двух разных чисел (которые уже есть в последовательности) ровно одним способом
     *
     * Здесь 2 важных момента:
     * 1. Следующее число это сумма разных чисел сидящих уже в последовательности
     * 2. Если число можно собрать из нескольких пар чисел - оно пропускается.
     * Число улама должно собираться только из одной пары чисел
     */
    public int ulam(int n) {
        if (n <= 0) return 0;
        if (n == 1 | n == 2 | n == 3 | n == 4) return n;

        int[] seq = new int[n];
        seq[0] = 1;
        seq[1] = 2;

        int nowLen = 2;
        n -= nowLen;

        while (n-- > 0) {
            int[] rezs = new int[(nowLen * (nowLen - 1)) / 2];
            int idx = 0;
            for (int i = 0; i < nowLen - 1; i++) {
                for (int j = i + 1; j < nowLen; j++) {
                    rezs[idx++] = seq[i] + seq[j];
                }
            }

            Arrays.sort(rezs);


            for (int i = 0; i < rezs.length - 1; i++) {
                if (rezs[i] == rezs[i + 1]) {
                    int j = i + 1;
                    while (j < rezs.length && rezs[j] == rezs[i]) {
                        rezs[j++] = 0;
                    }
                    rezs[i] = 0;
                    i = j - 1;
                }
            }


            nowLen++;
            for (int num : rezs) {
                if (num != 0 & num > seq[nowLen - 2])  {
                    seq[nowLen - 1] = num;
                    break;
                }
            }
        }

        return seq[nowLen - 1];
    }

    /*
     * Задание #7
     * Напишите функцию, которая возвращает самую длинную неповторяющуюся подстроку для строкового ввода.
     */
    public String longestNonrepeatingSubstring(String line) {
        String nowLongest = "";
        StringBuilder newSubString = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (newSubString.indexOf(line.substring(i, i + 1)) != -1) {
                nowLongest = (newSubString.length() < nowLongest.length()) ? nowLongest : newSubString.toString();
                newSubString = new StringBuilder();
            } else {
                newSubString.append(line.subSequence(i, i + 1));
            }
        }
        nowLongest = (newSubString.length() < nowLongest.length()) ? nowLongest : newSubString.toString();
        return nowLongest;
    }

    /*
     * Задание #8
     * Создайте функцию, которая принимает арабское число и преобразует его в римское число.
     */
    public String convertToRoman(int num) {
        if (num >= 5000) return "";
        if (num / 1000 > 0) {
            final String[] nums = { "", "M", "MM", "MMM", "MMMM" };
            return nums[num / 1000] + convertToRoman(num % 1000);
        }

        if (num / 100 > 0) {
            final String[] nums = {
                    "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M" };
            return nums[num / 100] + convertToRoman(num % 100);
        }

        if (num / 10 > 0) {
            final String[] nums = {
                    "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"	};
            return nums[num / 10] + convertToRoman(num % 10);

        }

        final String[] nums = {
                "", "I", "II", "III", "IV" , "V", "VI", "VII", "VIII", "IX", "X" };
        return nums[num];
    }

    /*
     * Задание #9
     * Создайте функцию, которая принимает строку и возвращает true или false в зависимости от того,
     * является ли формула правильной или нет.
     */
    public boolean formula(String line) {
        if (line.indexOf("=") == -1) return false;
        StringBuilder build = new StringBuilder(line);

        while (build.indexOf(" ") != -1) build.delete(build.indexOf(" "), build.indexOf(" ") + 1);

        String[] parts = build.toString().split("=");

        double[] values = new double[parts.length];
        int idx = 0;

        try {
            for (String part : parts) {

                if (part.indexOf("+") != -1) {
                    BigDecimal num1 = new BigDecimal(Double.parseDouble(part.substring(0, part.indexOf("+"))));
                    BigDecimal num2 = new BigDecimal(Double.parseDouble(part.substring(part.indexOf("+") + 1)));
                    values[idx++] = num1.add(num2).doubleValue();
                    continue;
                }

                if (part.indexOf("-") != -1) {
                    BigDecimal num1 = new BigDecimal(Double.parseDouble(part.substring(0, part.indexOf("-"))));
                    BigDecimal num2 = new BigDecimal(Double.parseDouble(part.substring(part.indexOf("-") + 1)));
                    values[idx++] = num1.subtract(num2).doubleValue();
                    continue;
                }

                if (part.indexOf("*") != -1) {
                    BigDecimal num1 = new BigDecimal(Double.parseDouble(part.substring(0, part.indexOf("*"))));
                    BigDecimal num2 = new BigDecimal(Double.parseDouble(part.substring(part.indexOf("*") + 1)));
                    values[idx++] = num1.multiply(num2).doubleValue();
                    continue;
                }

                if (part.indexOf("/") != -1) {
                    BigDecimal num1 = new BigDecimal(Double.parseDouble(part.substring(0, part.indexOf("/"))));
                    BigDecimal num2 = new BigDecimal(Double.parseDouble(part.substring(part.indexOf("/") + 1)));
                    values[idx++] = num1.divide(num2, 3, RoundingMode.HALF_UP).doubleValue();
                    continue;
                }

                values[idx++] = Double.parseDouble(part);
            }
        } catch (java.lang.NumberFormatException e) {
            return false;
        }

        for (int i = 0; i < idx - 1; i++) {
            if (values[i] != values[i + 1]) return false;
        }

        return true;
    }


    /*
     * Задание #10
     * Создайте функцию, которая возвращает значение true, если само число является палиндромом или
     * любой из его потомков вплоть до 2 цифр (однозначное число - тривиально палиндром).
     */
    public boolean palindromeDescendant(long number) {
        if (getCountsOfDigits(number) == 1) return true;

        boolean isPalindrom = false;
        long iterator;

        while (getCountsOfDigits(number) >= 2) {
            isPalindrom = true;
            iterator = number;
            int nowNumberLen = getCountsOfDigits(number);

            for (int i = 0; i < nowNumberLen / 2; i++) {
                int tempLen = getCountsOfDigits(iterator);
                int firstNum = (int)iterator / (int)Math.pow(10, tempLen - 1);
                int lastNum = (int)iterator % 10;

                if (firstNum != lastNum) {
                    isPalindrom = false;
                    break;
                }
                iterator /= 10;
            }

            if (!isPalindrom & getCountsOfDigits(number) % 2 != 0) return false;

            long newNumber = 0;
            int numberDigit = 0;

            if (!isPalindrom) {
                int tempLen = getCountsOfDigits(number);
                int upperLimit = tempLen;
                for (int i = 0; i < upperLimit; i+=2) {
                    long firstToSum = number % 10;
                    long secondToSum = (number % 100) / 10;
                    newNumber += Math.pow(10, numberDigit++) * (firstToSum + secondToSum);
                    number = number / 100;
                }
                number = newNumber;
                continue;
            } else return true;
        }

        return false;
    }
    public static int getCountsOfDigits(long number) {
        return(number == 0) ? 1 : (int)Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }
}
