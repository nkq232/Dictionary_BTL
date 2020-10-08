package Tu_dien;
import java.util.*;
import java.io.*;
public class DictionaryManagement {
    public static Dictionary dictionary;


    public static void  insertFromCommandline(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so tu ban muon input: ");
        int n;
        n = Integer.parseInt(in.nextLine());
        int size = Dictionary.list.size();
        for(int i = 0; i < n; i++) {
            Dictionary.list.add(new Word());
            System.out.println("Nhap tu thu " + (i + 1) + ":");
            Dictionary.list.get(i+size).setWord_target(in.nextLine());
            Dictionary.list.get(i+size).setWord_explained(in.nextLine());
        }
    }
    public static void insertFromFile() {
        dictionary = new Dictionary();
        try {

            File f = new File("C:\\Users\\Admin\\IdeaProjects\\BTL\\src\\Tu_dien\\dictionaries.txt");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            String s;
            for(int i = 0;(s = br.readLine()) != null ; ++i){
                String[] word = s.split("\\t");
                dictionary.add();
                Dictionary.list.get(i).setWord_target(word[0]);
                Dictionary.list.get(i).setWord_explained(word[1]);

            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void dictionaryLookup() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the word you want to find: ");
        String a = in.nextLine();
        int n = Dictionary.list.size();

        boolean check = false;
        for (int i = 0; i < n; i++) {
            if (a.equalsIgnoreCase(Dictionary.list.get(i).getWord_target())) {
                System.out.println(Dictionary.list.get(i).getWord_explained());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Sorry i cant find that word");
        }
    }
    public static void Edit() {
        Scanner in = new Scanner(System.in);
        int n = Dictionary.list.size();
        boolean check = false;
        System.out.println("What is the target word u want to edit: ");
        String En_before = in.nextLine();
        for (int i = 0; i < n ; i++) {
            if (En_before.equalsIgnoreCase(Dictionary.list.get(i).getWord_target())) {
                System.out.println("Input the new target word and explained word: ");
                Dictionary.list.get(i).setWord_target(in.nextLine());
                Dictionary.list.get(i).setWord_explained(in.nextLine());
                check = true;
            }
        }
        if (check) {
            System.out.println("Edit success");
        }
        else {
            System.out.println("Sorry i cant edit this");
        }
    }

    public static void delete() {
        Scanner in = new Scanner(System.in);
        boolean check = false;
        int n = Dictionary.list.size();
        System.out.println("What is the target word u want to delete: ");
        String En_before = in.nextLine();

        for (int i = 0; i < n; i++) {
            String checker = Dictionary.list.get(i).getWord_target();
            if (En_before.equalsIgnoreCase(checker)) {
                Word remove = Dictionary.list.get(i);
                Word last = Dictionary.list.get(n-1);
                Word mid_change = new Word();
                mid_change.copy_value(remove);
                remove.copy_value(last);
                last.copy_value(mid_change);
                Dictionary.list.remove(n-1);
                check = true;
            }
        }
        if (check) {
            System.out.println("Delete success");
        }
        else {
            System.out.println("Sorry i cant delete this word");
        }
    }
    public static void dictionaryExportToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Export.txt"));
        int n = Dictionary.list.size();
        for (int i = 0; i < n; i++) {
            String word_target = Dictionary.list.get(i).getWord_target();
            String word_explain = Dictionary.list.get(i).getWord_explained();
            writer.write(word_target + "\t" + word_explain);
            writer.newLine();

        }
        writer.close();
    }
}


