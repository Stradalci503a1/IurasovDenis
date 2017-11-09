public class Formatter {

    public static String build(String formatString, Object... arguments){
        if (formatString == null){
            return null;
        }

        StringBuilder formatedString = new StringBuilder().append(formatString);
        for(int i = 0;; i++){

            int openingBracketPosition = formatedString.indexOf("{", i);
            int closingBracketPosition = formatedString.indexOf("}", i);
            if (openingBracketPosition < 0 || closingBracketPosition < 0){
                break;
            }

            try{
                int number = Integer.parseInt(formatedString.substring(openingBracketPosition + 1, closingBracketPosition));
                formatedString.replace(openingBracketPosition, closingBracketPosition + 1, String.valueOf(arguments[number]));
            }
            catch (NumberFormatException e){
                i = Math.max(openingBracketPosition, closingBracketPosition);
            }
            catch (ArrayIndexOutOfBoundsException e){
                return null;
            }
        }
        /*for (int i = 0; i < arguments.length ; i++) {
            //output = output.replace("{" + i + "}", String.valueOf(arguments[i]));
        }*/

        return formatedString.toString();
    }
}
