package Tu_dien;
import java.util.*;
public class Dictionary {
    public ArrayList<Word> list = new ArrayList<>();

    // Constructor
    /** Tao dictionary voi n phan tu trong arraylist.*/
    public Dictionary (int n) {
        for(int i = 0; i < n; i++) list.add(new Word());
    }
    public Dictionary() {

    }
    // Constructor

    /**  nhap tu.*/
    public void add(){
        list.add(new Word());
    }
}

