package CompareVersionNumber;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        
        for(int i = 0; i < str1.length && i < str2.length; i++){
            if(Integer.parseInt(str1[i]) == Integer.parseInt(str2[i])) continue;
            if(Integer.parseInt(str1[i]) > Integer.parseInt(str2[i]))
                return 1;
            else
                return -1;
        }
        if(str1.length == str2.length) return 0;
        if(str1.length > str2.length) return 1;
        else return -1;
    }
}