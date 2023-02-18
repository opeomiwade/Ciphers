/**class containing concrete implementation of the encrypt and decrypt char methods to suit the
 * Vigenere cipher
 * subclass of the Substitution class,inherits methods from the super class.
 * @author Omiwade Opeoluwa
 * @version 1.0
 */
public class Vigenere extends Substitution{
    private String ciphers;//declaration of private variable.
/**main method calling the encrypt and decrypt string methods from the superclass
 * sets command line arguments
 * contains if else statements to ensure user enters input in right format.
 * @param args command line arguments.
 */
    public static void main(String[] args){
        if(args.length>3){
            System.out.println("Too many parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
        }

        else if(args.length<3){
            System.out.println("Too few parameters!\nUsage: java Vigenere encrypt key \"cipher text\"");
        }
        else{
            String method=args[0];
            String key=args[1];
            String message=args[2];
            Vigenere myMethod=new Vigenere(key);//instantiation of Vigenere class so the encrypt string method can be used.
            if(args[0].equals("encrypt")){
                System.out.println(myMethod.encrypt(message));
            }
            else if(args[0].equals("decrypt")){
                System.out.println(myMethod.decrypt(message));
            }
            else{
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java Vigenere encrypt key \"cipher text\"");
            }
        }
    }

/**default constructor resulting in identity as before.
 */
    public Vigenere(){//default constructor
        ciphers="A";
    }
/**constuctor which sets the user input to the private int variable.
 * @param key;keyPhrase
*/
    public Vigenere(String key){
        ciphers=key;
    }

/**helper method use to calculate the various shift values and put the values into an array.
 * @param ciphers string used for encryption
 * @return shift array.
 */
    public int[] cipher(String ciphers){
        int i=0;
        int[] shift=new int[ciphers.length()];
        for(i=0;i<=ciphers.length()-1;i++){
            if(ciphers.charAt(i)>='A'&& ciphers.charAt(i)<='Z'){//accounts for uppercase keys
                shift[i]=ciphers.charAt(i) - 'A';
            }

            else{//accounts for lower case keys.
                shift[i]=ciphers.charAt(i)-'a';
            }
        }
        return shift;
    }
/**concrete implementation of the encrypt char method in the substitution superclass to suit the Vigenere cipher.
 * takes in the char as a parameter
 * checks if the integer position of the char and the integer iteration are the same number.this ensures each character
 * is encrypted by a different shift value.
 * if they are ,the caesar encrypt char method is called
 * @param c character being encrypted.
 * @return c
 */
    public char encrypt(char c){
        int i;
        char shiftedChar=' ';
        int[] shift=cipher(ciphers);
        for(i=0;i<=shift.length-1;i++){
            if(pos>=shift.length){
                pos=pos%ciphers.length();//prevents runtime errors.when the end of the string is reached goes back to the first.
            }
            Caesar myObj=new Caesar(shift[pos]);//instantiation of caesar class so the encrypt char method can be used.sets instance variable to different value each ieteration
            if(i==pos){
                shiftedChar=myObj.encrypt(c);
            }
        }
        return shiftedChar;
    }

/**concrete implementation of the decrypt char method in the substitution superclass to suit the Vigenere cipher.
 * takes in the char as a parameter
 * checks if the integer position of the char and the integer iteration are the same number.this ensures each character
 * is encrypted by a different shift value.
 * if they are, the caesar decrypt char method is called
 * @param c character being encrypted.
 * @return c.
 */
    public char decrypt(char c){
        int i=0;
        char shiftedChar=' ';
        int[] shift=cipher(ciphers);
        for(i=0;i<=shift.length-1;i++){
            if(pos>=shift.length){
                pos=pos%ciphers.length();//prevents runtime errors.when the end of the string is reached goes back to the first.
            }
            Caesar myObj=new Caesar(shift[pos]);
            if(i==pos){
                shiftedChar=myObj.decrypt(c);
            }
        }
        return shiftedChar;
    }
 }