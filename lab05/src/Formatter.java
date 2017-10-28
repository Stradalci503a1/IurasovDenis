public class Formatter {

    public static String build(String formatString, Object... arguments){

        String output = formatString.toString();
        for (int i = 0; i < arguments.length; i++) {

            output = output.replace("{" + i + "}", String.valueOf(arguments[i]));
        }

        return output;
    }
}
