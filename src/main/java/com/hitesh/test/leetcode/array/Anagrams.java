package com.hitesh.test.leetcode.array;

import java.util.*;

public class Anagrams {

    public static Map<Character, Integer> getSet(String s) {
        Map<Character, Integer> set = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            set.put(s.charAt(i), set.getOrDefault(s.charAt(i), 0) + 1);
        }
        return set;
    }

    public static boolean isAnagram(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if(m1.size() != m2.size()) return false;
        for(Character k : m1.keySet()) {
            Integer c = m1.get(k);
            if(!m2.containsKey(k) || !c.equals(m2.get(k))) {
                return false;
            }
        }
        return true;
    }

    public static int hash(String s) {
        int h = 0;
        for(int i = 0; i < s.length(); ++i) {
            h += s.charAt(i) - 'a';
        }
        return h;
    }

    public static List<String> funWithAnagrams(List<String> text) {
        List<String> o = new ArrayList<>();
        Map<Integer, String> c = new HashMap<>();
        for(String i : text) {
            int h = hash(i);
            if(!c.containsKey(h)) {
                c.put(h, i);
                o.add(i);
            }
        }
        o.sort(String::compareTo);
        return o;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
//        a.add("code");
//        a.add("edoc");
//        a.add("edco");
//        a.add("framer");
//        a.add("frame");
        a.add("fqwltvzkqt");
                a.add("volphckcyufdqmlglimklfzktgygdttnhcvpfdfbrp");
        a.add("lkvshwywshtdgmbqbkkxcvgumo");
                a.add("mwvytbytnuqhmfjaqtgngcwkuzyamnerphfmwevh");
        a.add("lezohyeehbrcewjxvceziftiqtntfsrptugtiznorvonzjfea");
                a.add("gamayapwlmbzitzszhzkosvnknber");
        a.add("ltlkggdgpljfisyltmmfvhybljvk");
                a.add("pcflsaqevcijcyrgmqirzniax");
        a.add("kholawoydvchveigttxwpukzjfh");
                a.add("brtspfttotafsngqvoijxuvq");
        a.add("ztvaalsehzxbshnrvbykjqlrzzfm");
                a.add("vyoshiktodnsjjpqplciklzqrxloqxrudygjty");
        a.add("leizmeainxslwhhjwslqendjvx");
                a.add("yghrveuvphknqtsdtwxcktmwwwsdthzmlmbh");
        a.add("kmouhpbqur");
                a.add("fxgqlojmwsomowsjvpvhznbsilhhdkbdxqgrgedpzch");
        a.add("gefeukmcowoeznwhpiiduxdnnlbnmyjyssbsococdzcu");
                a.add("nkrfduvouaghhcyvmlkza");
        a.add("jpfpyljtyjjpyntsefxiswjuten");
                a.add("ycpbcnmhfuqmmidmvknyxmywegmtunodvuzygvguxtrdsdf");
        a.add("fssmeluodjgdgzfmrazvndtaur");
                a.add("kugs");
        a.add("dpawxitivdubbqeonycaegxfjkkl");
                a.add("fkraoheucsvpiteqrs");
        a.add("gkaaaohxxzhqjtkqaqhkwbe");
                a.add("bpmglbjipnujywogwc");
        a.add("lkyrdejaqufowbigrsnjniegvd");
                a.add("otugocedktcbbufnxorixibbdfrzuqsyrfqghoyqevcuanuu");
        a.add("szitaoaowsxyglafbwzddoznrvjqeyqignpi");
                a.add("ruijvyllsibobjltusrypanvybsfrxtlfmpdidtyozoolz");
        a.add("lgdgowijatklvjzscizrkupmsoxftumyxifyunxucubvk");
                a.add("ctkqlr");
        a.add("qgzjvjwzizppvso");
                a.add("flvioemycnphf");
        a.add("tbnwedtubynsbirepgcxfgsfomhvpmymkdoh");
                a.add("ttyyc");
        a.add("ibbeaxniwjkfvabnrll");
                a.add("maglythkgla");
        a.add("zgkeulyrpaeurdvexqlwgakdtbihmfrjijanxkhrqdllecy");
                a.add("pcflsaqevcijcyrgmqixnzira");
        a.add("klqrct");
                a.add("ibbeaxniwjkfvanrbll");
        a.add("vyoshiktodnsjjpqplciklzqrxloqxrudyyjtg");
                a.add("ycpbcnmhfuqmmidmvknyxmywegmtunodvuzygvgxddftsru");
        a.add("yyctt");
                a.add("yghrveuvphknqtsdtwxcktmwwwsdtlhbhmmz");
        a.add("vyoshiktodnsjjpqplciklzqrxloqxrugyytjd");
                a.add("cttyy");
        a.add("brtspfttotafsngqvoiqxuvj");
                a.add("lkyrdejaqufowbigrsnjvedgin");
        a.add("volphckcyufdqmlglimklfzktgygdttnhcvpfdrbpf");
                a.add("qgzjvjwzizpsovp");
        System.out.println(funWithAnagrams(a));
    }

}
