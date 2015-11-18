package LeetCode.MultiplyStrings;

public class Solution {
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
}