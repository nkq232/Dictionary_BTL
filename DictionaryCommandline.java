package Tu_dien;

import java.util.ArrayList;

public class DictionaryCommandline {
    private Dictionary dictionary;
    private DictionaryManagement dict_manage;
    private ArrayList<Word> list;

    // Constructor
    public DictionaryCommandline(Dictionary dictionary) {
        this.dictionary = dictionary;
        dict_manage = new DictionaryManagement(dictionary);
    }
    public DictionaryCommandline(Dictionary dictionary, DictionaryManagement dict_manage) {
        this.dictionary = dictionary;
        this.dict_manage = dict_manage;
    }
    public DictionaryCommandline() {

    }
    // End Constructor
    String hienthi(String a, int n) {
        StringBuilder space = new StringBuilder(a);
        for(int i = 0; i < n - a.length(); i++) {
            space.append(" ");
        }
        return a;
    }
    public void showWord(Word a) {
        System.out.println(a.getWord_target() + hienthi(a.getWord_target(),12)
                + "| " + a.getWord_explain());
    }
    public void showAllWords() {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(i + "    |");
            showWord(list.get(i));
        }
    }
    public void dictionaryBasic() {
        dict_manage.insertFromCommandline(dictionary.getList());
        showAllWords();
    }
    public void dictionaryAdvanced() throws Exception {
        dict_manage.insertFromFile();
        showAllWords();
        dict_manage.dictionaryLookup(list);
    }
}
