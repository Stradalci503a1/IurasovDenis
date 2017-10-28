public class Formatter {
    public static void main(String[] args) {
        String s = build("Hello {0}, I am {1} years old", "hell", 15);
        System.out.println(s);
    }
    public static String build(String formatString, Object... arguments){

        String output = formatString.toString();
        for (int i = 0; i < arguments.length; i++) {

            output = output.replace("{" + i + "}", String.valueOf(arguments[i]));
        }

        return output;
    }
}
