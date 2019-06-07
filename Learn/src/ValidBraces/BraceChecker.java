package ValidBraces;

public class BraceChecker {
    public static boolean isValid(String braces) {
        // Add code here
        System.out.println("Braces set = " + braces);
        String[] braceTempl = {"{}", "()", "[]"};
        boolean flag = false;

        if (braces.length() % 2 != 0) return false;

        while (true) {
            flag = false; // ни один шаблон не найден

            for (int i = 0; i < 3; i++) {
                if (braces.indexOf(braceTempl[i]) != -1) {
                    braces = braces.substring(0, braces.indexOf(braceTempl[i])) +
                            braces.substring(braces.indexOf(braceTempl[i]) + 2, braces.length());
                    System.out.println(braces);
                    flag = true;
                    break;
                }
            }

            if (!flag && !braces.isEmpty()) return false;

            if (braces.isEmpty()) return true;
        }
    }
}
