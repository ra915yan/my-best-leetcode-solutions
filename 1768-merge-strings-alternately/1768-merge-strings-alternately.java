class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int length = Math.min(s1.length, s2.length);
        int i = 0;
        for(; i < length; i++){
            sb.append(s1[i]);
            sb.append(s2[i]);
        }

        while(i < s1.length){sb.append(s1[i]);i++;}
        while(i < s2.length){sb.append(s2[i]);i++;}

        return sb.toString();
    }
}