package Tu_dien;
import java.util.*;
import java.util.ArrayList;

import static Tu_dien.Dictionary.*;

public class DictionaryCommandline {
    void showAllWords() {
        int n = list.size();
        System.out.printf("%-8s|%-40s|%s%n%n", "No", "English", "Vietnamese");
        for(int i = 0; i < n; i++) {
            System.out.printf("%-8s|%-40s|%s%n%n", i+1,
                    list.get(i).getWord_target(),
                    list.get(i).getWord_explained());
        }
    }

    public void dictionaryBasic(){
        DictionaryManagement.insertFromCommandline();
        showAllWords();

    }

    public void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();

    }
    public void dictionarySearcher() {
        int n = list.size();
        Scanner in = new Scanner(System.in);
        boolean check = false;
        System.out.println("What is the word you want to search ? 3 letters is MAX pls");
        ArrayList<Word> children = new ArrayList<>();
        String input = in.nextLine();

        for (int i = 0; i < n; i++) {
            String child = list.get(i).getWord_target()
                    .substring(0, input.length());
            if (child.equalsIgnoreCase(input)) {
                check = true;
                Word new_child = new Word(list.get(i).getWord_target(), list
                        .get(i).getWord_explained());

                children.add(new_child);
            }
        }
        if (check) {
            System.out.println("We found " + children.size() + " word(s) :");
            System.out.printf("%-8s|%-40s|%s%n%n", "No", "English", "Vietnamese");
            for (int i = 0; i < children.size(); i++) {
                System.out.printf("%-8s|%-40s|%s%n%n", i+1,
                        children.get(i).getWord_target(),
                        children.get(i).getWord_explained());
            }
        }
        else {
            System.out.println("Sorry we cant find that word");
        }
    }

}

