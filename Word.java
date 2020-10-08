package Tu_dien;

public class Word {
    private String word_target;
    private String word_explained;
    // Constructor
    public Word(String word_target, String word_explained) {
        this.word_target = word_target;
        this.word_explained = word_explained;
    }
    public Word() {

    }
    public void copy_value(Word a) {
        this.word_explained = a.word_explained;
        this.word_target = a.word_target;
    }
    /** Getter va setter cho word_target.*/
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_target(){
        return word_target;
    }
    /** Getter va setter cho word_explained.*/
    public void setWord_explained(String word_explained) {
        this.word_explained = word_explained;
    }
    public String getWord_explained() {
        return word_explained;
    }

}


