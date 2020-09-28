package Dictionary;

import java.util.Scanner;

/** class có hàm Insert có chức năng nhập liệu */
public class DictionaryManagement {
    void insertfromCommandline() {
        Scanner in = new Scanner(System.in);
        String en, vi;
        /**Nhap dong tieng anh */
        en = in.nextLine();
        /**Nhap dong tieng viet*/
        vi = in.nextLine();

        String c = "";
        /**Doc cac tu tieng anh tu dong vua nhap*/
        for(int j = 0; j < en.length(); j++) {
            if(!Character.isSpace(en.charAt(j))) {
                c += en.charAt(j);
            }
            else {
                    .add(c);
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