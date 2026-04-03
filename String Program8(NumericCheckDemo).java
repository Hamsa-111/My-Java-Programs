
/*3c(viii)Write a Java Program for Verifying if a string contains only numeric characters using user defined function isNumeric()*/



package Java;

public class NumericCheckDemo{
public static void main(String[] args){

String str="12345";   // change value to test

if(isNumeric(str)){
System.out.println(str+" contains only numeric characters");
}else{
System.out.println(str+" is not numeric");
}

}

// user-defined function
public static boolean isNumeric(String str){

if(str==null || str.length()==0){
return false;
}

for(int i=0;i<str.length();i++){
if(!Character.isDigit(str.charAt(i))){
return false;
}
}

return true;
}
}