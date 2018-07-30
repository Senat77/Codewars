package BrainLuck;

public class Solution
{
    public static void main(String[] args)
    {
        BrainLuck bl = new BrainLuck(",+[-.,+]");
        System.out.println(bl.process("Codewars" + ((char) 255)));
    }
}
