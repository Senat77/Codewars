package NextBiggerNumber;

/*
http://www.codewars.com/kata/55983863da40caa2c900004e/train/java

You have to create a function that takes a positive integer number and returns the next bigger number formed by the
same digits:

Kata.nextBiggerNumber(12)==21
Kata.nextBiggerNumber(513)==531
Kata.nextBiggerNumber(2017)==2071
If no bigger number can be composed using those digits, return -1:

Kata.nextBiggerNumber(9)==-1
Kata.nextBiggerNumber(111)==-1
Kata.nextBiggerNumber(531)==-1
 */

import java.util.Arrays;

public class Kata {
    public static void main(String[] args) {
        //System.out.println(nextBiggerNumber(12));
        //System.out.println(nextBiggerNumber(513));
        System.out.println(nextBiggerNumber(2017));
        //System.out.println(nextBiggerNumber(9));
        //System.out.println(nextBiggerNumber(111));
        //System.out.println(nextBiggerNumber(531));
    }

    public static long nextBiggerNumber(long n) {
        String s = Long.toString(n);
        char x = 0;
        int pos = -1;
        // Ищем последовательность символов , где s[i] > s[i-1], от конца строки
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                pos = i - 1;
                break;
            }
        }
        if (pos == -1) return -1L;
        String const_str = s.substring(0, pos);
        String mutable_str = s.substring(pos, s.length());
        //System.out.println("Const = " + const_str);
        //System.out.println("Mutable = " + mutable_str);
        // По mutable ищем ближайший больший сивол к mutable[0]
        x = 254;
        pos = -1;
        for (int i = 1; i < mutable_str.length(); i++) {
            if (mutable_str.charAt(i) > mutable_str.charAt(0)) {
                if (mutable_str.charAt(i) < x) {
                    x = mutable_str.charAt(i);
                    pos = i;
                }
            }
        }
        const_str += x;
        mutable_str = mutable_str.substring(0, pos) + mutable_str.substring(pos + 1, mutable_str.length());
        //System.out.println("Const = " + const_str);
        //System.out.println("Mutable = " + mutable_str);
        // Сортируем mutable по возрастанию и добавляем к const
        char[] arr = mutable_str.toCharArray();
        Arrays.sort(arr);

        return (Long.parseLong(const_str + String.valueOf(arr)));
    }
}
