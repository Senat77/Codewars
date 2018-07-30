package BrainLuck;

public class Solution
{
    public static void main(String[] args)
    {
        BrainLuck bl1 = new BrainLuck(",+[-.,+]");
        System.out.println(bl1.process("Codewars" + ((char) 255)));
        BrainLuck bl2 = new BrainLuck(",[.[-],]");
        System.out.println(bl2.process("Codewars" + ((char) 0)));
    }
}
