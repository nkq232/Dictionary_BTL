package Tu_dien;
import java.util.ArrayList;
public class Dictionary {
    private ArrayList<Word> list;
    public Dictionary() {
        list = new ArrayList<Word>();

    }
    public ArrayList<Word> getList() {
        return list;
    }
    public Dictionary(ArrayList<Word> a) {
        this.list = a;
    }
}
