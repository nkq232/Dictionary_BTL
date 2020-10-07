package Tu_dien;
import java.util.*;
import java.util.ArrayList;

public class DictionaryCommandline {
    private final Dictionary dictionary;
    private final DictionaryManagement dict_manage;
    private ArrayList<Word> list;

    // Constructor
    public DictionaryCommandline(Dictionary dictionary, DictionaryManagement dict_manage) {
        this.dictionary = dictionary;
        this.dict_manage = dict_manage;
    }
    // End Constructor
    public void showAllWords() {
        if(list == null) {
            list = new ArrayList<>(dictionary.getList());
        }
        boolean check_Empty = true;
        int thu_tu = 0;
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) continue;
            for(int j = 0; j < list.get(i).getWord_explain().size(); j++) {
                if (check_Empty) {
                    check_Empty = false;
                    String a = "No";
                    String b = "English";
                    String c = "Vietnamese";
                    System.out.printf("%-8s|%-40s|%s%n%n", a, b, c);
                }
                System.out.printf("%-8d|%-40s|%s%n", ++thu_tu, list.get(i).getWord_target(), list.get(i).getWord_explain().get(j));
            }
        }
        if (check_Empty) {
            System.out.println("There are no words in dictionary");
        }
        list = null;
    }
    public void dictionaryBasic() {
        dict_manage.insertFromCommandline();
        showAllWords();
    }
    public void dictionaryAdvanced() throws Exception {
        dict_manage.insertFromFile();
        showAllWords();
        dict_manage.dictionaryLookup();
    }
    public void DictionarySearcher() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter to find : ");
        String find = in.nextLine();
        ArrayList<String> result;
        result = dictionary.Searcher(find);
        if (result == null) {
            System.out.println("We cant find anything like that");
        }
        else if (result.size() == 0) {
            System.out.println("We cant find anything like that");
        }
        else {
            System.out.println("We found" + result.size() + " results");
            for(int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }
}

