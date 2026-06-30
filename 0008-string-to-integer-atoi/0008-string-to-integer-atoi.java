class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int i=0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        int sign=1;
        if(i<n && s.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(i<n&&s.charAt(i)=='+'){
            
            i++;
        }
        int ans=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            if(ans>Integer.MAX_VALUE/10 ||ans==Integer.MAX_VALUE/10 && digit>7){
                if(sign==-1){
                    return Integer.MIN_VALUE;
                }
                else{
                    return Integer.MAX_VALUE;
                }
                
            }
            ans=ans*10+digit;
            i++;
        }
        return ans*sign;
    }
}