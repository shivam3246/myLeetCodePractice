//https://leetcode.com/problems/parse-lisp-expression/
import java.util.*;
public class parseLispExpression {
    
    public static int evaluate(String expression) {
        return eval(expression,new HashMap<>());
    }
    private static int eval(String exp,HashMap<String,Integer> parent){
//if character at first place is not a ()
if(exp.charAt(0)!='('){
    if(Character.isDigit(exp.charAt(0))||exp.charAt(0)=='-')
     return Integer.parseInt(exp);
     return parent.get(exp);
}
//Create a new scope to add all the previous values to it
HashMap<String,Integer> map = new HashMap<>();
map.putAll(parent);
List<String> tokens = parse(exp.substring(exp.charAt(1)=='m'?6:5,exp.length()-1));
if(exp.startsWith("(a"))
return eval(tokens.get(0),map)+eval(tokens.get(1),map);
else if(exp.startsWith("(m"))
return eval(tokens.get(0),map)*eval(tokens.get(1),map);
else{
    for(int i = 0;i<tokens.size()-2;i+=2)
        map.put(tokens.get(i),eval(tokens.get(i+1),map));
        return eval(tokens.get(tokens.size()-1),map);
    }
}

    private static List<String> parse(String str){
       //Seperate the values between two parenthesis
       List<String> result = new ArrayList<>();
       int par = 0;
       StringBuilder sb = new StringBuilder();
       for(char c:str.toCharArray()){
        if(c=='(')
        par++;
        if(c==')')
        par--;
        if(par==0 && c==' '){
            result.add(new String(sb));
            sb = new StringBuilder();
        }
        else{
            sb.append(c);
        }
       }
       if(sb.length()>0)
       result.add(new String(sb));
    return result;
    }
       public static void main(String[] args) {
        String expression = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        //output=>14
        int ans = evaluate(expression);
        System.out.print(ans);
       }    
}
