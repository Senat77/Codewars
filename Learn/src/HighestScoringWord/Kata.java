package HighestScoringWord;

/*
Given a string of words, you need to find the highest scoring word.

Each letter of a word scores points according to it's position in the alphabet: a = 1, b = 2, c = 3 etc.

You need to return the highest scoring word as a string.

If two words score the same, return the word that appears earliest in the original string.

All letters will be lowercase and all inputs will be valid.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Kata
{
    public static void main(String[] args)
    {
        System.out.println(high("man i need a taxi up to ubud"));
        System.out.println(high("what time are we climbing up to the volcano"));
        System.out.println(high("take me to semynak"));
    }

    public static String high(String s)
    {
        // Формируем список из строки
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(s.split(" ")));
        // System.out.println(list);
        // Формируем хэш-мапу
        TreeMap<Integer,String> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++)
        {
            String str = list.get(i);
            int weight = 0;
            for (int j = 0; j < str.length(); j++)
            {
                weight += str.charAt(j) - 'a' + 1;
            }

            // Если в мапе нет - добавляем
            if(!map.containsKey(weight))
                map.put(weight,str);
        }

        if(map.size() != 0)
            return map.lastEntry().getValue();
        else
            return "";
    }
}
