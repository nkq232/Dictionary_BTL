package Tu_dien;
import java.util.*;

public class Dictionary {
    private ArrayList<Word> list;
    private static ArrayList<String> list_target;
    public static void setList_target(ArrayList<String> list_target) {
        Dictionary.list_target = list_target;

    }

    //Constructors
    public ArrayList<String> getList_target() {

        return list_target;
    }
    public Dictionary() {
        list_target = new ArrayList<String>();
        list_target.add("Apple");
    }

    public Dictionary(ArrayList<Word> a) {
        Word b = new Word("Apple", "Tao");
        a.add(b);
        this.list = a;
    }
    public ArrayList<Word> getList() {

        return list;
    }
    //Constructors

    // Funtioncs

    /**Tim kiem 1 tu trong array da luu tra ve vi tri .*/
    public int search(ArrayList<String> b, String c) {
        if (b == null) {
            return -1;
        } else {
            for (String ps : b) {
                if (ps.equals(c)) return b.indexOf(ps);
            }
            return -1;
        }
    }
    /** Chen tu vao list.*/
    public void InsertWord(String En, String Vi) {
        if( list_target == null || search(list_target, En) == -1) {
            Word newWord = new Word(En, Vi);
            list.add(newWord);
            list_target.add(En);
        }
        else {
            ArrayList<String> plus = list.get(search(list_target, En)).getWord_explain();
            for(String s : plus) {
                if(Vi.equals(s)) {
                    return;
                }
                plus.add(Vi);
            }
        }
    }
    /**Tim kiem tu trong array tra ve array explain.*/
    public ArrayList<String> searchWord(String En) {
        if(search(list_target, En) == -1) {
            return null;
        }
        else {
            return list.get(search(list_target, En)).getWord_explain();
        }
    }

    /** Tim phan tu Word dua tren nghia En.*/
    public Word FindWord(String En) {
        if (search(list_target, En) == -1) return null;
        return list.get(search(list_target, En));
    }

    /** Xoa tu trong tu dien :
     * Chuyen tu can xoa ra sau cung list roi remove
     * @param En
     * @param Vi
     * @return
     */
    public boolean removeWord(String En, String Vi) {
        if(search(list_target, En) != -1) {
            ArrayList<String> explain  = list.get(search(list_target, En)).getWord_explain();
            if (explain.contains(Vi)) {
                explain.remove(Vi);
                if(explain.size() == 0) {
                    Word remove = list.get(search(list_target, En));
                    Word cuoi = list.get(list.size() - 1);
                    Word mid_change  = new Word();
                    mid_change.copy(remove);
                    remove.copy(cuoi);
                    cuoi.copy(remove);
                    list.remove(list.size() - 1);
                    return true;
                }
                return false;
            }
            return false;
        }

        return true;
    }
    /** Sua English, Vietnamese cua mot tu trong list .*/
    public boolean EditWord(String EnBefore, String ViBefore, String EnAfter, String ViAfter) {
        if(removeWord(EnBefore, ViBefore)) {
            InsertWord(EnAfter, ViAfter);
            return true;
        }
        return false;
    }
    /** Tim va tra ve nghia tieng viet cua tu tieng anh.*/
    public ArrayList<String> Searcher(String En) {
        ArrayList<String> s = list_target;
        if (search(s, En) == -1) {
            s.add(En);
        }
        return s;
    }

}
