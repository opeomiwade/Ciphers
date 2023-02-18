/**class containing concrete implementation of the encrypt and decrypt char methods to suit the
 * caesar cipher
 * subclass of the MonoAlphaSubstitution class,inherits methods from the super class.
 * @author Omiwade Opeoluwa
 * @version 1.0
 */
public class Caesar extends MonoAlphaSubstitution{
    private int shift;//declaration of private variable.

/**main method calling the encrypt and decrypt string methods from the superclass
 * sets command line arguments
 * contains if else statements to ensure user enters input in right format.
 * @param args command line arguments.
 */
    public static void main(String[] args){
        if(args.length<3){
            System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
        }
        else if(args.length>3){
             System.out.println("Too many parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
        }
        else{

            String method=args[0];
            int key=Integer.parseInt(args[1]);
            if(key<0){
                key=26+key;//accounts for negative shift values.
            }
            String message=args[2];
            Caesar myMethod=new Caesar(key);//instantiation of Caesar class so the encrypt string method can be used.
            if(args[0].equals("encrypt")){
                System.out.println(myMethod.encrypt(message));
            }
            else if(args[0].equals("decrypt")){
                System.out.println(myMethod.decrypt(message));
            }
            else{
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java Caesar encrypt n \"cipher text\"");
            }
        }
    }

/**default constructor resulting in identity as before.
 */
    public Caesar(){}

/**constuctor which sets the user input to the private int variabe.
 * @param key shift value.
*/
    public Caesar(int key){
        shift=key;
    }

/**concrete implementation of the encrypt char method in the substitution superclass to suit the caesar cipher.
 * takes in the char as a parameter
 * subtracts 'a' or 'A' from the ascii value of the alphabet (depending if its upper or lower case)to get the original position.
 * shift value is then added
 * ascii value of letter 'a' or 'A' is added back to get the position after the shift
 * @param c character being encrypted.
 * @return c.
 */
    public char encrypt(char c){
        int shiftValue=shift;
        char newAlphabet=' ';
        if(c>='a' && c<='z'||c>='A' && c<='Z'){
            if(c>='a'&& c<='z'){
                int originalPosition=c-'a';
                int afterShift=(originalPosition + shiftValue)%26;
                newAlphabet = (char)(afterShift + 'a');
            }
            else{
                int originalPosition=c-'A';
                int afterShift=(originalPosition + shiftValue)%26;
                newAlphabet= (char)(afterShift + 'A');
            }
        }
        else{
           newAlphabet=c;
        }
        return newAlphabet;
    }

/**concrete implementation of the decrypt char method in the substitution superclass to suit the caesar cipher.
 * takes in the char as a parameter
 * subtracts 'a' or 'A' from the ascii value of the alphabet (depending if its upper or lower case)to get the original position.
 * shift value is then added
 * ascii value of letter 'a' or 'A' is added back to get the position after the shift
 * @param c character being encrypted.
 * @return c.
 */
    public char decrypt(char c){
        int shiftValue=(26-(shift%26));//converts encrypt shift value to decrypt shift value.
        char newAlphabet=' ';
        if(c>='a' && c<='z'||c>='A' && c<='Z'){
            if(c>='a'&& c<='z'){
                int originalPosition=c -'a';
                int afterShift=(originalPosition + shiftValue)%26;
                newAlphabet= (char) (afterShift + 'a');
            }
            else{
                int originalPosition=c -'A';
                int afterShift=(originalPosition + shiftValue)%26;
                newAlphabet= (char) (afterShift + 'A');
            }
        }
        else{
             newAlphabet=c;
        }
    return newAlphabet;
    }
}