public class WelcomeMessage {
    public static void main(String[] args) {
        String message = "Selamat datang di TripWise!";
        int messageLength = message.length();
        int totalLength = messageLength + 6; // 6 is for the padding and borders on both sides

        String topAndBottomBorder = repeatChar('=', totalLength);
        String sideBorder = "||" + repeatChar(' ', totalLength - 4) + "||";
        String formattedMessage = "|| " + message + " ||";

        System.out.println(topAndBottomBorder);
        System.out.println(sideBorder);
        System.out.println(formattedMessage);
        System.out.println(sideBorder);
        System.out.println(topAndBottomBorder);
    }

    public static String repeatChar(char ch, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
