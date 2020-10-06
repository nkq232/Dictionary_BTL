package Tu_dien;

import java.util.ArrayList;

public class Word {
    private String word_target;
    private ArrayList<String> word_explain;
    //Constructors
    public Word(String word_target, String word_explain) {
        this.word_explain.add(word_explain);
        this.word_target = word_target;
    }
    public Word(){
    }

    //Constructors

    //Getter and Setter
    public String getWord_target() {
        
        return word_target;
    }
    public ArrayList<String> getWord_explain() {
        
        return word_explain;
    }
    public void setWord_target(String word_target) {
        
        this.word_target = word_target;
    }
    public void setWord_explain(ArrayList<String> a) {
        
        word_explain.addAll(a);
    }
    //Getter and Setter

    //More functions
    public void addWord_explain(String a) {
        if(word_explain == null) word_explain = new ArrayList<String>();
        word_explain.add(a);
    }
    public void copy(Word a) {
        this.setWord_explain(a.getWord_explain());
        this.setWord_target(a.getWord_target());
    }

}
