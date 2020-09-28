package Dictionary;

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