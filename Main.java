package Tu_dien;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Dictionary dict = new Dictionary();
        DictionaryManagement dic_manage = new DictionaryManagement(dict);
        DictionaryCommandline dic_com = new DictionaryCommandline(dict, dic_manage);
        boolean Iscontinue = true;
        do {
        System.out.println("Menu:");
        System.out.println("1: Insert from file, you can choose this function only once");
        System.out.println("2: Show all words in this dictionary.");
        System.out.println("3: Insert from command line");
        System.out.println("4: Search an word by command line.");
        System.out.println("5: Delete an english word in this dictionary.");
        System.out.println("6: Find all english world in this dictionary which have same prefix with s");
        System.out.println("7: Export this dictionay to file");
        System.out.println("8: Exit");
        System.out.println("Please select fuction [1-8]!");

        boolean Ispress = true;
        int select = in.nextInt();
        switch (select) {
            case 1: {
                dic_manage.insertFromFile();
                break;
            }
            case 2: {
                dic_com.showAllWords();
                break;
            }
            case 3: {
                dic_manage.insertFromCommandline();
                break;
            }
            case 4: {
                dic_manage.dictionaryLookup();
                break;
            }
            case 5: {
                dic_manage.deleteWord();
                break;
            }

            case 6: {
                dic_com.DictionarySearcher();
                break;
            }

            case 7: {
                dic_manage.dictionaryExportToFile();
                System.out.println("Export completed");
                break;
            }
            case 8: {
                Iscontinue = false;
                System.out.println("Goodbye");
                break;
            }
            default: {
                Ispress = false;
                System.out.println("Please input again !");
            }
        }
            if (Iscontinue && Ispress)
            {
                System.out.println("Press enter to continue");

            }
            else if (Iscontinue)
            {
                Ispress  = true;
                System.out.println();
            }
        } while (Iscontinue);
    }
}
