//Problem 1
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> stack=new Stack<>();
        // populate my stack
            //  k=11 k=1
        for(int i=0;i<num.length();i++)
        {
           
                //
                while(!stack.isEmpty()&&k>0 && num.charAt(i)<stack.peek())
                {
                    stack.pop();
                    k--;
                
                }
                stack.push(num.charAt(i));
            
        }
        //check is my stack len is eual to n
      
  
        while(k>0)
        {
     stack.pop();
     k--;

        }
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty())
        {
            String s=Character.toString(stack.pop());
            sb.insert(0,s);
        }
        String result=sb.toString();
       int zero=0;
        while(zero<result.length()&&result.charAt(zero)=='0')
        {
            zero++;
        }
        
        
        // reverse the stack
        // leading zero
        result=result.substring(zero,result.length());
        if(result=="")
        {
            return "0";
        }
        return result;
    }

    // 
}

//Problem 2
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0) return 0;
        Stack<Integer> stack =new Stack<>();
        int num1,num2;
        for(int i=0;i<tokens.length;i++)
        {
            String s=tokens[i];
            if(s.length()==1)
            {
                if(s.equals("+"))
                {
                num1=stack.pop();
                num2=stack.pop();
                stack.push(num1+num2);
                }
                else if(s.equals("-"))
                {
                num1=stack.pop();
                num2=stack.pop(); 
                stack.push(num2-num1);   
                }
                    else if(s.equals("*"))
                {
                num1=stack.pop();
                num2=stack.pop(); 
                stack.push(num2*num1);   
                }
                    else if(s.equals("/"))
                {
                num1=stack.pop();
                num2=stack.pop(); 
                stack.push(num2/num1);   
                }
                else{
                    stack.push(Integer.parseInt(s));
                }
            }
            else{
stack.push(Integer.parseInt(s));
            }
        }
      return stack.pop();  
    }
}