class Solution {
     int st=0;
        int maxlen=0;
    public String longestPalindrome(String s) {
        int n=s.length();
       
        for(int i=0;i<n;i++){
            expand(s,i,i);
            expand(s,i,i+1);
            
        }
        return s.substring(st,st+maxlen);
    }
    public void expand(String s,int left,int right){
        while(left>=0 &&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            int len=right-left-1;
            if(len>maxlen){
                maxlen=len;
                st=left+1;
            }
        }
    }
}