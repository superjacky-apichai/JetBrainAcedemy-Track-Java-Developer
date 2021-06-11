package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        String s = "we found a treasure!";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch= s.charAt(i);
            for (Letter j : Letter.values()){
                if (Character.isLetter(ch)&&s.charAt(i)== j.getChar) {
                     ch = (char)j.charNumber;
                }
            }
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder);

    }
}
