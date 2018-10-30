import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {


    static private void leave(){
        Scanner exit = new Scanner(System.in);
        String e=exit.next();
        if(e.equalsIgnoreCase("quit")){
            System.exit(0);
        }


    }
    static private void run() {
        String word="eindopdracht"; //te raden woord
        int life=9;
        Scanner start = new Scanner(System.in);
        String inp=start.next();
        if(inp.equalsIgnoreCase("run") ) {
            guess(word,life);

        }else{
            run();

        }

    }
    static private void guess(String word, int life){
        char[] filler = new char[word.length()];

        int i=0;



        //maak een space voor elk character in het te raden woord
        while(i<word.length()){
            filler[i]='_';
            if (word.charAt(i)==' ') {
                filler[i]=' ';
            }

            i++;


        }

        System.out.println(filler);
        System.out.println("Life Remaining=" +life);
        Scanner s=new Scanner(System.in);//read players guess
        ArrayList<Character> l=new ArrayList<Character>();

        //Loop that checks if guessed letter is right and replaces dashes with the right letter
        while (life>0){
            char x=s.next().charAt(0);

            //if letter already used
            if(l.contains(x)){
                System.out.println("Already used that letter");
                System.out.println(filler);
                System.out.println("Life Remaining=" +life);
                continue;

            }l.add(x);
            //if letter is right
            if(word.contains(x+"")){
                for(int y=0;y<word.length();y++){
                    if(word.charAt(y)==x){
                        filler[y]=x;
                        System.out.println("YOU GUESSED RIGHT");
                    }
                }
            }else{
                life--;
                System.out.println("WRONG LETTER");//if wrong
            }
            if(word.equalsIgnoreCase((String.valueOf(filler)))){
                System.out.println(filler);
                System.out.println("YOU WIN!");//if win
                leave();
                break;
            }
            System.out.println(filler);
            System.out.println("Life Remaining=" +life);
            System.out.println("GUESSED LETTERS:"+l);
            if (life==0){
                System.out.println("YOU LOSE!");
               leave();
            break;


            }
             }
    }
    public static void main (String[] args){

            System.out.println("Welcome to hangman, How to play: to start the game type in:");
        System.out.println("'run', then the game starts. you can then one letter at a time guess the word by typing. Typing 'quit' will end the game.");


            run();

            }

    }



