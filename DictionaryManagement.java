package Tu_dien;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
public class DictionaryManagement {
    public Scanner in = new Scanner(System.in);
    private  Dictionary dictionary;
    //Constructor
    public DictionaryManagement() {
        dictionary = new Dictionary();
    }
    public DictionaryManagement(Dictionary d) {
        dictionary = d;
    }
    //Constructor
    public void insertFromCommandline(ArrayList<Word> listWord) {
        String English;
        String Vietnamese;
        Scanner in = new Scanner(System.in);
        English = in.nextLine();
        Vietnamese = in.nextLine();
        Word newWord = new Word();
        newWord.setWord_target(English);
        newWord.setWord_explain(Vietnamese);
        dictionary.getList().add(newWord);
    }
    public void insertFromFile() throws Exception {
        FileReader file = new FileReader("dictionaries.txt");
        BufferedReader read = new BufferedReader(file);
        String new_line = read.readLine();
        StringBuilder c = new StringBuilder();
        Word newWord = new Word();
        for(int j = 0; j < new_line.length(); j++) {
            if(!Character.isSpace(new_line.charAt(j))) {
                c.append(new_line.charAt(j));
            }
            else {
                    newWord.setWord_target(c.toString());
                c = new StringBuilder();
            }
        }
        newWord.setWord_explain(c.toString());
        read.close();
        file.close();
    }
    public void dictionaryLookup(ArrayList<Word> list) {
        String c = in.nextLine();
        int j = 0, a = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getWord_target() == c) {
                j++;
                if(a == 0) System.out.println("We found : ");
                a++;
                System.out.println(list.get(i));
            }
        }
        System.out.println("Sorry we cant find that word");
    }
}
