package BrainLuck;

/*
http://www.codewars.com/kata/526156943dfe7ce06200063e/train/java

Inspired from real-world Brainf**k, we want to create an interpreter of that language which will support the following
instructions (the machine memory or 'data' should behave like a potentially infinite array of bytes, initialized to 0):

> increment the data pointer (to point to the next cell to the right).
< decrement the data pointer (to point to the next cell to the left).
+ increment (increase by one, truncate overflow: 255 + 1 = 0) the byte at the data pointer.
- decrement (decrease by one, treat as unsigned byte: 0 - 1 = 255 ) the byte at the data pointer.
. output the byte at the data pointer.
, accept one byte of input, storing its value in the byte at the data pointer.
[ if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next
command, jump it forward to the command after the matching ] command.
] if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next
command, jump it back to the command after the matching [ command.
The function will take in input...

the program code, a string with the sequence of machine instructions,
the program input, a string, eventually empty, that will be interpreted as an array of bytes using each
character's ASCII code and will be consumed by the , instruction
... and will return ...

the output of the interpreted code (always as a string), produced by the . instruction.
 */

public class BrainLuck
{
    private byte[] cpu;     // память
    private int cpuPos;     // индекс тек. ячейки в памяти
    private String code;    // код
    private int codePos;    // индекс в строке кода
    private String inp;     // Входные данные
    private int inputPos;   // индекс в строке входных данных

    public BrainLuck(String code)
    {
        cpu = new byte[30000];
        for(byte b : cpu)
            b = 0;
        cpuPos = 0;
        this.code = code;
        codePos = 0;
        inp = "";
        inputPos = 0;
    }

    public String process(String input)
    {

        StringBuilder sb = new StringBuilder();     // Результат
        inp = input;

        while(codePos < code.length())
        {
            switch(code.getBytes()[codePos])
            {
                case('>'):
                {
                    cpuPos++;
                    codePos++;
                    break;
                }
                case('<'):
                {
                    cpuPos--;
                    codePos++;
                    break;
                }
                case('+'):
                {
                    cpu[cpuPos]++;
                    codePos++;
                    break;
                }
                case('-'):
                {
                    cpu[cpuPos]--;
                    codePos++;
                    break;
                }
                case('.'):
                {
                    sb.append((char)cpu[cpuPos]);
                    //System.out.println("Record: " + "codePos = " + codePos + " inputPos = " + inputPos);
                    //System.out.println(sb.toString());
                    codePos++;
                    break;
                }
                case(','):
                {
                    cpu[cpuPos] = (byte)inp.charAt(inputPos++);
                    //System.out.println("Read: " + "codePos = " + codePos + " inputPos = " + (inputPos-1));
                    codePos++;
                    break;
                }
                case('['):
                {
                    int cycleCount = 0;
                    if(cpu[cpuPos] == 0)
                    {
                        do
                        {
                            codePos++;
                            if((byte)code.charAt(codePos) == '[') cycleCount++;
                            if((byte)code.charAt(codePos) == ']')
                                if(cycleCount == 0) break;
                                else cycleCount--;
                        }
                        while(true);
                    }
                    codePos++;
                    break;
                }
                case(']'):
                {
                    int cycleCount = 0;
                    if(cpu[cpuPos] != 0)
                    {
                        do
                        {
                            codePos--;
                            if((byte)code.charAt(codePos) == ']') cycleCount++;
                            if((byte)code.charAt(codePos) == '[')
                                if(cycleCount == 0) break;
                                else cycleCount--;
                        }
                        while(true);
                    }
                    codePos++;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
