import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSwidNo1 {

    private static String countCharacter(String str){
        str = str.toLowerCase().replace(" ", "");
        int[] frequency = new int[26];
        List<Character> characters = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if (frequency[ch - 'a'] == 0) {
                    characters.add(ch);
                }
                frequency[ch - 'a']++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : characters) {
            stringBuilder.append(ch).append("=").append(frequency[ch - 'a']).append(", ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your statement = ");
        String input = scanner.nextLine();
        String result = countCharacter(input);
        System.out.println(result);
        scanner.close();
    }


}
