package LeetCodes.String;

import java.util.Set;

public class Solution {
	public Solution(){}
	
	/**
	 * String Multiplication
	 */	
    private int intValue(char c){
        return c - '0';
    }
    private String add(String n1, String n2){
        String ans = "";
        int carryin = 0;
        StringBuilder sb = new StringBuilder(n1);
        String num1 = sb.reverse().toString();
        sb = new StringBuilder(n2);
        String num2 = sb.reverse().toString();
        
        int i = 0;
        while(true){
            int sum = 0;
            if(i < num1.length() && i < num2.length()){
                sum = intValue(num1.charAt(i)) + intValue(num2.charAt(i)) + carryin;
                carryin = sum / 10;
                ans = Integer.toString(sum % 10) + ans;
            }
            else if ( i < num1.length() ){
                sum = intValue(num1.charAt(i)) +  carryin;
                carryin = sum / 10;
                ans = Integer.toString(sum % 10) + ans;
            }
            else if ( i < num2.length() ){
                sum = intValue(num2.charAt(i)) +  carryin;
                carryin = sum / 10;
                ans = Integer.toString(sum % 10) + ans;
            }
            else{
            	if(carryin > 0)
            		ans = Integer.toString(carryin) + ans;
                break;
            }
            i++;
        }
        
        while(true){
        	if(ans.isEmpty()) return "0";
        	if(ans.charAt(0) == '0')
        		ans = ans.substring(1);
        	else
        		break;
        }
        
        return ans;
    }
    public String multiply(String num1, String num2) {
        String[] multis = new String[num1.length()];
        for(int i =0; i < num1.length(); i++){
            char multiplier = num1.charAt(num1.length() - i - 1);
            String temp = "";
            int carryin = 0;
            for(int j = num2.length()-1; j >= 0; j--){
                char c = num2.charAt(j);
                int m = intValue(c) * intValue(multiplier) + carryin;
                temp = Integer.toString(m % 10) + temp;
                carryin = m / 10;
            }
            if(carryin > 0)
            	temp = Integer.toString(carryin) + temp;
            for(int k = 0; k < i; k++)
                temp = temp + "0";
            multis[i] = temp;
        }
        String result = "0";
        for(String str : multis)
            result = add(str, result);
        return result;
    }
    
    /**
     * String Interleaving
     */
    
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
    
    /**
     * Word Break
     */
    
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }
}
