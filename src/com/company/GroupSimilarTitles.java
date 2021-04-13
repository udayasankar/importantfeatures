package com.company;

import java.util.*;

public class GroupSimilarTitles {

    public static List<List<String>> groupTitles(String[] str)
    {
        if(str.length==0)
            return new ArrayList<List<String>>();
        Map<String,List<String>> res=new HashMap<>();
        int[] count=new int[26];
        for(String s:str)
        {
            Arrays.fill(count,0);
            for(char c:s.toCharArray())
            {
                int index = c -'a';
                count[index]++;
            }
            StringBuilder delimStr = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                delimStr.append('#');
                delimStr.append(count[i]);
            }
            System.out.println(s+" "+delimStr.toString());
            String key=delimStr.toString();
            if(!res.containsKey(key))
                res.put(key,new ArrayList<>());
            res.get(key).add(s);
        }
       return new ArrayList<List<String>>(res.values());
    }

    public static void main(String[] args)
    {
        String titles[] = {"duel","dule","speed","spede","deul","cars"};
        List<List<String>> gt = groupTitles(titles);
        System.out.println(gt);
        String query = "spede";
        for (List<String> g : gt){
            if (g.contains(query))
                System.out.println(g);
        }
    }
}
