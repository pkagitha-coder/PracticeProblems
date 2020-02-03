package org.abc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SherlockValidString {

    public static void main(String[] args) {
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggab" +
                "cfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfe" +
                "eibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhh" +
                "ifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagid" +
                "ebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhch" +
                "gcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfeda" +
                "gahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbc" +
                "bhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaade" +
                "dfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhge" +
                "ghdfhbfbifgidcafbfcd"));

        System.out.println(isValid("aaaabbcc"));
    }

    static String isValid(String s) {
        int[] cache = new int[26];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(char ch:s.toCharArray()) {
            cache[ch - 'a']++;
            int freq = cache[ch - 'a'];

            freqMap.put(freq,freqMap.getOrDefault(freq,0)+1);
            if(freqMap.containsKey(freq - 1)) {
                int count = freqMap.get(freq-1)-1;
                if(count <= 0) {
                    freqMap.remove(freq-1);
                }else {
                    freqMap.put(freq-1,count);
                }
            }
        }

        if(freqMap.size()==1) {
            //System.out.println("YES");
            return "YES";
        }
        if(freqMap.size()== 2) {
            if(freqMap.containsValue(1)) {
                int sum = 0;
                int x = 0;
                for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()) {
                    if(entry.getValue() == 1) {
                        if(entry.getKey() == 1) {
                            return "YES";
                        }
                        x=2*entry.getKey();
                    }
                    sum+=entry.getKey();
                }

                int diff = Math.abs(sum - x);
                if(diff == 1)
                    System.out.println("YES");
            }
        }

        //System.out.println("NO");
        return "NO";

    }
}
