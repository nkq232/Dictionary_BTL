package Tu_dien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dictionary tu_dien = new Dictionary();
        DictionaryManagement nhap = new DictionaryManagement(tu_dien);
        nhap.insertFromCommandline(tu_dien.getList());
        DictionaryCommandline test = new DictionaryCommandline(tu_dien,nhap);
        test.dictionaryBasic();
    }

}
