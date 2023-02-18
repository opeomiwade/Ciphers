import java.lang.*;
/**class containing concrete implemetation of the abstract encrypt and decrypt char methods to suit
 * the MonoAlphaSubstitution cipher.
 * subclass of the abstract substitution class
 * inherits methods from substitution class.
 * @author Omiwade Opeoluwa
 * @version 1.0
 */
public class MonoAlphaSubstitution extends Substitution{
    private String mapping;

/**main method to call the methods from teh superclass to encrypt the string
 * also sets the command line arguments.
 * contains if else statements to ensure user enters the command line arguments in the corect format.
 * @param args command line arguments.
 */
    public static void main(String[] args){
        if(args.length<3){
            System.out.println("Too few parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

        else if(args.length>3){
             System.out.println("Too many parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

        else{
            String method=args[0];
            String key=args[1];
            String message=args[2];
            //instantiates class so string method of encrypt and decrypt can be accessed,sets instance variable mapping to cmd line args key.
            MonoAlphaSubstitution myMethod=new MonoAlphaSubstitution(key);//instantiation of MonoAlphaSubstitution class so the encrypt string method can be used.
            if(args[0].equals("encrypt")){
                System.out.println(myMethod.encrypt(message));
            }
            else if(args[0].equals("decrypt")){
                System.out.println(myMethod.decrypt(message));
            }
            else{
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            }
        }
    }

/**default constructor resulting in identity as before.
 */
    public MonoAlphaSubstitution(){
        mapping="aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz";
    }

/**constructor which sets users input in the command line argument to the private string variable mapping.
 * @param key;keyPhrase.
 */
    public MonoAlphaSubstitution(String key){
        mapping=key;
    }

/**concrete implementation of the encrypt char method in the substitution superclass to suit the monoalphasubstitution cipher.
 * takes in the char as a parameter
 * compares it to every character in the keyphrase.
 * if char c is the same as the character in the keyphrase and char c has an even index then it is changed to the character after it
 * in the keyphrase.
 * if only one of the conditions are met then the character does not change.
 * if none of the conditions are met then the character does not change.
 * @param c character being encrypted.
 * @return c.
 */
    public char encrypt(char c){
        int i=0;
        String keyPhrase=mapping;
        int keyPhraseLength=keyPhrase.length();
        for(i=0;i<=keyPhraseLength-1;i++){
            char keyPhraseChar=keyPhrase.charAt(i);
            if((c==keyPhraseChar||c==keyPhraseChar+32) && i%2==0){//+32 to account for upper case alphabets.
                c=keyPhrase.charAt(i+1);
                break;
            }
            else if(c==keyPhraseChar && i%2!=0){
                continue;
            }
            else{
                continue;
            }
        }
        return c;
    }

/**concrete implementation of the decrypt char method in the susbstitution superclass to suit monoalphasubstitution cipher
 * takes in the char as a parameter
 * compares it to every character in the keyphrase.
 * if char c is the same as the character in the keyphrase and char c has an even index then it is changed to the character after it
 * in the keyphrase.
 * if only one of the conditions are met then the character does not change.
 * if none of the conditions are met then the character does not change.
 * @param c characeter being decrypted.
 * @return c.
 */
    public char decrypt(char c){
        int i=0;
        String keyPhrase=mapping;
        int keyPhraseLength=keyPhrase.length();
        for(i=0;i<=keyPhraseLength-1;i++){
            char keyPhraseChar=keyPhrase.charAt(i);
            if((c==keyPhraseChar||c==keyPhraseChar+32) && i%2==0){
                c=keyPhrase.charAt(i+1);
                break;
            }
            else if(c==keyPhraseChar && i%2!=0){
                continue;
            }
            else{
                continue;
            }
        }
        return c;
    }
}