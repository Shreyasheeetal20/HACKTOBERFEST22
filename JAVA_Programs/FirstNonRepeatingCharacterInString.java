public class FirstNonRepeatingCharacterInString {

    public static void main(String[] args) {

        String str ="Otorhinolaryngologist";

        boolean b = true;

        for(char c : str.toCharArray())

        {

            if (str.indexOf(c) == str.lastIndexOf(c)) {

                System.out.println("First NonRepeated Character Is: "+c);

                b = false;

                break;

            }

        }

        if(b) {

            System.out.println("There is no NonRepeating Character.");

        }

    }

}





