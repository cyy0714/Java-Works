package StringInterleaving;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
        if(s1.length() == 0 && s2.length() == 0)
            if(s3.length() == 0)
                return true;
            else
                return false;
        
        if(s3.length() != s1.length() + s2.length())
            return false;
        for(int i = 0, j = 0, k = 0; k < s3.length(); k++){
            if(i < s1.length())
                if(s3.charAt(k) == s1.charAt(i)){
                        i ++;
                        continue;
                }
            if (j < s2.length())
                if(s3.charAt(k) == s2.charAt(j)){
                    j ++;
                    continue;
                }
            return false;
        }
        return true;
    }
}