package Tu_dien;
import java.util.*;
import java.io.*;
public class DictionaryManagement {
    private  Dictionary dictionary;

    //Constructor
    public DictionaryManagement() {

        dictionary = new Dictionary();
    }
    public DictionaryManagement(Dictionary d) {

        dictionary = d;
    }
    //Constructor
    public boolean checkWord(String s) {
        for(int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public void insertFromCommandline(){
        Scanner in = new Scanner(System.in);
        System.out.println("How many word u want to insert ?");
        int dem = -2;
        while (dem <= 0) {
            dem = Integer.parseInt(in.nextLine());
            if(dem <= 0) {
                System.out.println("Sorry input again pls");
            }
        }
        for(int i = 0; i < dem; i++) {
            System.out.println("Enter word: ");
            String En = in.nextLine();
            while (!checkWord(En)) {
                En = in.nextLine();
            }
            String Vi = in.nextLine();
            dictionary.InsertWord(En, Vi);
        }

    }
    public void insertFromFile() throws Exception{
        try {
            File file = new File("C:\\Users\\Admin\\IdeaProjects\\BTL\\src\\Tu_dien\\dictionaries.txt");
            Scanner in = new Scanner(file);
            String c = "";
            while (in.hasNextLine()) {
            String new_line = in.nextLine();
            String[] chia_ra = new_line.split("\\t");
            if(chia_ra.length == 2) {
                if (!checkWord(chia_ra[0])) {
                    System.out.println("Error to insert this word");
                }
                else {
                    dictionary.InsertWord(chia_ra[0], chia_ra[1]);
                }
            }
            }
            in.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the word u want to find: ");
        String En = in.nextLine();
        ArrayList<String> check = dictionary.searchWord(En);
        if (check == null) {
            System.out.println("Sorry, I cant find that word");
        }
        else {
            String ki_tu = "";
            if (check.size() > 1) {
                ki_tu = "s";
            }
            System.out.println("There are " + check.size() + "word" + ki_tu);
            for(int i = 0; i < check.size(); i++) {
                System.out.println(check.get(i));
            }
        }

    }

    public void deleteWord() {
        System.out.println("Enter the word you want to delete (Enter English pls) : ");
        Scanner in = new Scanner(System.in);
        dictionaryLookup();
        String En = in.nextLine();
        ArrayList<String> check = dictionary.searchWord(En);
        if (check == null) {
            System.out.println("Sorry, I cant find that word");
        }
        else {
            String ki_tu = "";
            if (check.size() > 1) {
                ki_tu = "s";
            }
            System.out.println("There are " + check.size() + "word" + ki_tu);
            for(int i = 0; i < check.size(); i++) {
                System.out.println(check.get(i));
            }
            System.out.println("Choose the word u want to delete by entering Vietnamese ver: ");
            String Vi = in.nextLine();
            boolean check_delete = dictionary.removeWord(En, Vi);
            if (check_delete) {
                System.out.println("Remove done!");
            }
            else {
                System.out.println("Sorry an error happens");
            }
        }

    }
    public void editWord() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the word need to edit (Enter English pls): ");
        String En_before = in.nextLine();
        ArrayList<String> check = dictionary.searchWord(En_before);
        if (check == null) {
            System.out.println("Sorry we cant find that word");
        }
        else {
            System.out.println("We found " + check.size() + "result :");
            for (int i = 0; i < check.size(); i++) {
                System.out.println(check.get(i));
            }
        }
        System.out.println("Select a word pls: ");
        String Vi_before = in.nextLine();
        System.out.println("Enter new word both English and Vietnamese pls");
        String En_after = in.nextLine();
        String Vi_after = in.nextLine();
        boolean check_edit = dictionary.EditWord(En_before, Vi_before, En_after, Vi_after);
        if (check_edit) {
            System.out.println("Edit success");
        }
        else {
            System.out.println("Sorry an error happens");
        }
    }
    public void dictionaryExportToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("dictionariesUpdated.txt"));
        ArrayList<Word> refToDict = dictionary.getList();
        for (int i = 0; i < refToDict.size(); i++) {
            ArrayList<String> refToWordExplain = refToDict.get(i).getWord_explain();
            for (int j = 0; j < refToWordExplain.size(); j++) {
                String word_target = refToDict.get(i).getWord_target();
                String word_explain = refToDict.get(i).getWord_explain().get(j);
                writer.write(word_target + "\t" + word_explain);
                writer.newLine();
            }
        }
        writer.close();
    }
}

