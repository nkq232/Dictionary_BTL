package Tu_dien;
import java.util.*;
import java.io.*;
public class Dictionary {
    private ArrayList<Word> list;
    private ArrayList<String> list_target;
    //Constructors
    public ArrayList<String> getList_target() {

        return list_target;
    }
    public Dictionary() {
    }

    public Dictionary(ArrayList<Word> a) {

        this.list = a;
    }
    public ArrayList<Word> getList() {

        return list;
    }
    //Constructors

    // Funtioncs

    /**Tim kiem 1 tu trong array da luu tra ve vi tri .*/
    public int search(ArrayList<String> b, String c) {
        for(int i = 0; i < b.size(); i++) {
            if(b.get(i) == c) return i;
        }
        return -1;
    }
    /** Chen tu vao list.*/
    public void InsertWord(String En, String Vi) {
    if(search(list_target, En) == -1) {
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
    /** Sua En, Vi cua mot tu trong list .*/
    public boolean EditWord(String EnBefore, String ViBefore, String EnAfter, String ViAfter) {
        if(removeWord(EnBefore, ViBefore) == true) {
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
