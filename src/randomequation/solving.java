/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomequation;

import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author User
 */
public class solving {
    
    
       public static String solveEquation(String equation,char a) 
{ 
    int n = equation.length(),  
        sign = 1, coeff = 0; 
    int total = 0, i = 0; 
     int no1 = 0,no2 = 0;
     int equ=0,equ3=0;
     int io = 0;
  if(equation.contains("/")){
        String equ2 = null;
      for (int jo = 0; jo < n; jo++)  
    { 
       if (equation.charAt(jo) == '/')
       {
        equ2=equation.substring(0, jo);
            io = jo;
       }
       else if(equation.charAt(jo) == '=')
       {
           
       equ+=Integer.parseInt( 
                                 equation.substring(io+1, jo));
      equ3+=Integer.parseInt( 
                                 equation.substring(jo+1, n));
       }
       System.out.println("final"+equ);
        System.out.println("final"+equ2);
          System.out.println("final"+equ3);
          
          
          
       
    }
     int equ4=equ3*equ;
          equation=equ2+"="+equ4;
         // equation="8x=9";
          System.out.println(equation);
    n=equation.length();
     
     }
    // Traverse the equation 
    for (int j = 0; j < n; j++)  
    { 
        if (equation.charAt(j) == '+' ||  
            equation.charAt(j) == '-') 
        { 
            if (j > i) 
                total += sign *  
                         Integer.parseInt( 
                                 equation.substring(i, j)); 
            i = j; 
        } 
  
        // For cases such  
        // as: x, -x, +x 
        else if (equation.charAt(j) == 'x') 
        { 
            if ((i == j) ||  
                 equation.charAt(j - 1) == '+') 
                coeff += sign; 
                  
            else if (equation.charAt(j - 1) == '-') 
                coeff -= sign; 
                  
            else
                coeff += sign *  
                         Integer.parseInt( 
                                 equation.substring(i, j)); 
            i = j + 1; 
        } 
  
        // Flip sign once  
        // '=' is seen 
        else if (equation.charAt(j) == '=')  
        { 
            if (j > i) 
                total += sign *  
                         Integer.parseInt( 
                                 equation.substring(i, j)); 
            sign = -1; 
            i = j + 1; 
             no1=total;
               System.out.println("number1"+(total));
               no1=-no1;
        } 
    } 
  
    // There may be a  
    // number left in the end 
    if (i < n) {
         no2=sign *  
                Integer.parseInt( 
                        equation.substring(i));
        no2=-no2;
        total = total +  
                sign *  
                Integer.parseInt( 
                        equation.substring(i)); 
  
    }      
        
    // For infinite 
    // solutions 
    if (coeff == 0 &&  
        total == 0) 
        return "Infinite solutions"; 
  
    // For no solution 
    if (coeff == 0 &&  
        total != 0) 
        return "No solution"; 

    // x = total sum / coeff  
    // of x '-' sign indicates  
    // moving numeric value to  
    // right hand side 
    double ans = (double)(-total) /(double) coeff; 
     System.out.println("ppppppppppppppppppppppppppppppppppppppppppppp"+ans);
    ans=ans*100;
   int finalans=(int) ans;
     System.out.println("ppppppppppppppppppppppppppppppppppppppppppppp"+finalans);
   double finalans2=Double.valueOf(finalans)/100.00;
   
    ans=finalans2;
    
    
    System.out.println("ppppppppppppppppppppppppppppppppppppppppppppp"+Double.valueOf(finalans)/100.00);
    System.out.println("test1"+total);
     System.out.println("test2"+coeff);
    if(a=='A')
    {
    return (Double.toString(ans));
    }
    else
    {
     
   // ans=Math.round(ans);
    
    System.out.println(equation);
    System.out.println( "tot is"+total+"="+coeff+"x");
    System.out.println( "tot is"+total+"="+coeff+"x");
    System.out.println( "tot is"+total+"/"+coeff+"="+"x");
     System.out.println( "tot is"+ans+"="+"x");
    //return (equation+"    "+-total+"="+coeff+"x"+"    "+-total+"/"+coeff+"="+"x"+"    "+ans+"="+"x"); 
    //return (equation+" "+coeff+"x"+"="+-total+" "+"x"+"="+-total+"/"+coeff+" "+"x"+"="+ans); 
    
    if(no2==0)
    {
    return(equation+" "+coeff+"x"+"="+no1+" "+"x"+"="+-total+"/"+coeff+" "+"x"+"="+ans);
    }
    else
    return(equation+" "+coeff+"x"+"="+no1+"+"+no2+" "+"x"+"="+-total+"/"+coeff+" "+"x"+"="+ans);
    }
          
    
} 
  
    
}
