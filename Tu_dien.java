package Dictionary;
import java.util.Scanner;
import java.util.Vector;
/**sdasad.*/
public class Tu_dien {
    Vector<String> a = new Vector<>();
    Vector<String> b = new Vector<>();
    
    /** class Word .*/
    public class Word {
         private String word_target, word_explain;

        public String getWord_explain() {
            return word_explain;
        }

        public String getWord_target() {
            return word_target;
        }

        public void setWord_explain(String word_explain) {
            this.word_explain = word_explain;
        }

        public void setWord_target(String word_target) {
            this.word_target = word_target;
        }
    }
    
    /** class Dictionary lưu trữ mảng Word .*/
    public class Dictionary {
        Vector<Word> danhsach =  new Vector<>();

    }
    
    /** class có hàm Insert có chức năng nhập liệu */
    public class DictionaryManagement {
        void insertfromCommandline() {
            Scanner in = new Scanner(System.in);
            String en, vi;
            /**Nhap dong tieng anh */
            en=in.nextLine();
            /**Nhap dong tieng viet*/
            vi=in.nextLine();

            String c="";
                /**Doc cac tu tieng anh tu dong vua nhap*/
                for(int j = 0; j < en.length(); j++) {
                    if(!Character.isSpace(en.charAt(j))) {
                        c += en.charAt(j);
                    }
                    else {
                        a.add(c);
                        c = "";
                        continue;
                    }

                }
                /**Doc cac tu tieng viet tu dong vua nhap*/
            for(int j = 0; j < en.length(); j++) {
                if(!Character.isSpace(en.charAt(j))){
                    c += en.charAt(j);
                }
                else {
                    a.add(c);
                    c = "";
                    continue;
                }

            }

        }

    }
    
    /** class có hàm ShowAllWords hiển thị các từ đã nhập */
    public class DictionaryCommandline {
        String hienthi(String a, int n) {
            String space = a;
            for(int i = 0; i < n - a.length(); i++) {
                space += " ";
            }
            return a;
        }
        void showAllWords() {
            System.out.println("No            | English                   | Vietnamese                ");
            for(int i = 0;i <a.size(); i++) {
            System.out.println(i + 1 + "            | " + hienthi(a.get(i), 10) + " | " + hienthi(b.get(i), 10)  );
            }
        }
        void dictionaryBasic() {
        DictionaryManagement insert = new DictionaryManagement();
        insert.insertfromCommandline();
        showAllWords();
        
        }
    }

}
