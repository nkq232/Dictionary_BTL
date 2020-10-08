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
       int size = dictionary.list.size();   
        for(int i = 0; i < n; i++) {
            dictionary.list.add(new Word());
            System.out.println("Nhap tu thu " + (i + 1) + ":");
            dictionary.list.get(i+size).setWord_target(in.nextLine());
            dictionary.list.get(i+size).setWord_explained(in.nextLine());
        }
    }
    public static void insertFromFile() {
        dictionary = new Dictionary();
        try {

            File f = new File("dictionaries.txt");
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            String s;
            for(int i = 0;(s = br.readLine()) != null ; ++i){
                String[] word = s.split("\\t");
                dictionary.add();
                dictionary.list.get(i).setWord_target(word[0]);
                dictionary.list.get(i).setWord_explained(word[1]);

            }
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void dictionaryLookup() {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        int n = dictionary.list.size();
        System.out.println("Input the word you want to find: ");
        boolean check = false;
        for (int i = 0; i < n; i++) {
            if (a.equalsIgnoreCase(dictionary.list.get(i).getWord_target())) {
                System.out.println(dictionary.list.get(i).getWord_explained());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Sorry i cant find that word");
        }
    }
    public static void Edit() {
        Scanner in = new Scanner(System.in);
        int n = dictionary.list.size();
        boolean check = false;
        System.out.println("What is the target word u want to edit: ");
        String En_before = in.nextLine();
        for (int i = 0; i < n ; i++) {
            if (En_before.equalsIgnoreCase(dictionary.list.get(i).getWord_target())) {
                System.out.println("Input the new target word and explained word: ");
                dictionary.list.get(i).setWord_target(in.nextLine());
                dictionary.list.get(i).setWord_explained(in.nextLine());
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
        int n = dictionary.list.size();
        System.out.println("What is the target word u want to delete: ");
        String En_before = in.nextLine();
        for (int i = 0; i < n; i++) {
            if (En_before.equalsIgnoreCase(dictionary.list.get(i).getWord_target())) {
                dictionary.list.remove(i);
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
        int n = dictionary.list.size();
        for (int i = 0; i < n; i++) {
                String word_target = dictionary.list.get(i).getWord_target();
                String word_explain = dictionary.list.get(i).getWord_explained();
                writer.write(word_target + "\t" + word_explain);
                writer.newLine();

        }
        writer.close();
    }
}

