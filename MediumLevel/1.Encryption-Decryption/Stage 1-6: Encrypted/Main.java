package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        String s = "we found a treasure!";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch= s.charAt(i);
                if (Character.isLetter(ch)) {
                     ch = (char) (122 - ch +97);
                }

            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder);

    }
}
