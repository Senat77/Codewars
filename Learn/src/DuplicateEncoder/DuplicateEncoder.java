package DuplicateEncoder;

/*
The goal of this exercise is to convert a string to a new string where each character in the new string
is '(' if that character appears only once in the original string, or ')' if that character appears more
than once in the original string. Ignore capitalization when determining if a character is a duplicate.

Examples:

"din" => "((("

"recede" => "()()()"

"Success" => ")())())"

"(( @" => "))(("


Notes:

Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode XXX",
the "XXX" is actually the expected result, not the input! (these languages are locked so that's not
possible to correct it).
 */

import java.util.HashMap;

public class DuplicateEncoder
{
    public static void main(String[] args)
    {
        System.out.println(encode("Prespecialized"));
    }

    public static String encode(String word)
    {
        HashMap<Character,Integer> map = new HashMap<>();

        String t = word.toLowerCase();

        for (int i = 0; i < t.length(); i++)
        {
            if (map.containsKey(t.charAt(i)))
            {
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }
            else
            {
                map.put(t.charAt(i),1);
            }
        }

        String res = "";
        for (int i = 0; i < t.length(); i++)
        {
            if (map.get(t.charAt(i)) > 1)
                res += ")";
            else
                res += "(";
        }

        return res;
    }
}
