package Dictionary;
import java.util.Scanner;
import java.util.Vector;
/**sdasad.*/
public class Tu_dien {
    public class Word{
         String word_target, word_explain;

    }
    public class Dictionary{
        String[] Words;
    }
    public class DictionaryManagement{
        String[] insertfromCommandline(String[] args){
            Scanner in = new Scanner(System.in);
            String en,vi;
            /**Nhap dong tieng anh */
            en=in.nextLine();
            /**Nhap dong tieng viet*/
            vi=in.nextLine();
            Vector<String> a = new Vector<>();
            Vector<String> b = new Vector<>();
            String c="";
                /**Doc cac tu tieng anh tu dong vua nhap*/
                for(int j=0;j<en.length();j++) {
                    if(!Character.isSpace(en.charAt(j))){
                        c+=en.charAt(j);
                    }
                    else {
                        a.add(c);
                        c="";
                        continue;
                    }

                }
                /**Doc cac tu tieng viet tu dong vua nhap*/
            for(int j=0;j<en.length();j++) {
                if(!Character.isSpace(en.charAt(j))){
                    c+=en.charAt(j);
                }
                else {
                    a.add(c);
                    c="";
                    continue;
                }

            }
            return args;
        }
    }
    public class DictionaryCommandline{
        void showAllWords(){

        }
        void dictionaryBasic(){

        }
    }
}
