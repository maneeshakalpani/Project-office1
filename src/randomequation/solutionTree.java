/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomequation;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 *
 * @author User
 */
public class solutionTree {
     public static String solveEquation(String equation, char a,String[] arrayme) throws UnknownHostException {

         
         
         
       //  System.out.println("nnnnnnnnnnnnnnn"+arrayme[5]);
         MongoClient mongoClient=new MongoClient("localhost",27017);     
       
   System.out.println("connection successful");  
   DB dbs=mongoClient.getDB("shop");
   System.out.println(dbs.getName());
        
    DBCollection customers10 = dbs.getCollection("customers26");
			System.out.println("Collection has selected successfully"); 
         
         
           //documentMapDetail1.put("parent","Databases");
     //   DBCollection customers10= dbs.createCollection("customers20", null);
          // DBCollection customers9= dbs.createCollection("customers9", null);
          BasicDBObject basicobject=new BasicDBObject();
            BasicDBObject basicobject1=new BasicDBObject();
             BasicDBObject basicobject2=new BasicDBObject();
              BasicDBObject basicobject3=new BasicDBObject();
               BasicDBObject basicobject4=new BasicDBObject();
                BasicDBObject basicobject5=new BasicDBObject();
                 BasicDBObject basicobject6=new BasicDBObject();
                  BasicDBObject basicobject7=new BasicDBObject();
                   BasicDBObject basicobject8=new BasicDBObject();
                    BasicDBObject basicobject9=new BasicDBObject();
                     BasicDBObject basicobject10=new BasicDBObject();
                      BasicDBObject basicobject11=new BasicDBObject();
                    BasicDBObject basicobject12=new BasicDBObject();
                     BasicDBObject basicobject13=new BasicDBObject();
                 
                
              
     
          
	//documentMap.put("detail", documentMapDetail);
        
         
         
         
         
         
         
         
         int a1 = 0;
        int b1 = 0;
        int c1 = 0;

        int n = equation.length(),
                sign = 1, coeff = 0;
        int total = 0, i = 0;
        int no1 = 0, no2 = 0;
        int equ = 0, equ3 = 0;
        int io = 0;
        int total2 = 0;
        // Traverse the equation 
        for (int j = 0; j < n; j++) {
            if (equation.charAt(j) == '+'
                    || equation.charAt(j) == '-') {
                if (j > i) {
                    total += sign
                            * Integer.parseInt(
                                    equation.substring(i, j));
                }
                i = j;
            } // For cases such  
            // as: x, -x, +x 
            else if (equation.charAt(j) == 'x') {
                if ((i == j)
                        || equation.charAt(j - 1) == '+') {
                    coeff += sign;
                } else if (equation.charAt(j - 1) == '-') {
                    coeff -= sign;
                } else {
                    coeff += sign
                            * Integer.parseInt(
                                    equation.substring(i, j));
                }
                i = j + 1;

                System.out.println("coeff is" + coeff);
            } // Flip sign once  
            // '=' is seen 
            else if (equation.charAt(j) == '=') {
                if (j > i) {
                    total += sign
                            * Integer.parseInt(
                                    equation.substring(i, j));
                }
                sign = -1;
                i = j + 1;
                no1 = total;
                System.out.println("number1" + (total));
                no1 = -no1;
            }
        }

        // There may be a  
        // number left in the end 
        if (i < n) {

            no2 = sign
                    * Integer.parseInt(
                            equation.substring(i));
            no2 = -no2;
            total2 = total2
                    + sign
                    * Integer.parseInt(
                            equation.substring(i));
            System.out.println("my total is" + -total2);
        }

        // For infinite 
        // solutions 
        if (coeff == 0
                && total == 0) {
            return "Infinite solutions";
        }

        // For no solution 
        if (coeff == 0
                && total != 0) {
            return "No solution";
        }
        System.out.println("coeff is" + coeff);
        System.out.println("number1" + (total));
        System.out.println("my total is" + -total2);
        int solution1 = 0;
        int solution2 = 0;

      
        
        String step1, step2_1, step2_2, step2_3, step2_4, step3, step4, step5, step6, step7;

        System.out.println("first step");
        if (total > 0) {
            System.out.println(coeff + "x" + "+" + total + "=" + -total2);
            step1 = coeff + "x" + "+" + total + "=" + -total2;
        } else {
            System.out.println(coeff + "x" + total + "=" + -total2);
            step1 = coeff + "x" + total + "=" + -total2;
        }
        System.out.println("second step");
        System.out.println("second step-1");
        if (-total < 0) {
            System.out.println(coeff + "x" + "=" + -total2 + -total);
            step2_1 = coeff + "x" + "=" + -total2 + -total;
        } else {
            System.out.println(coeff + "x" + "=" + -total2 + "+" + -total);
            step2_1 = coeff + "x" + "=" + -total2 + "+" + -total;
        }
        System.out.println("second step-2");
        if (-total < 0 && -total2 < 0) {
            System.out.println(coeff + "x" + "=" + -total + -total2);
            step2_2 = coeff + "x" + "=" + -total + -total2;
        }
        else if (-total > 0 && -total2 <0) {
            System.out.println(coeff + "x" + "=" + -total + -total2);
            step2_2 = coeff + "x" + "=" + -total + "" + -total2;}
        
        
        
        else {
            System.out.println(coeff + "x" + "=" + -total + "+" + -total2);
            step2_2 = coeff + "x" + "=" + -total + "+" + -total2;
        }
        System.out.println("second step-3");
        if (total2 < 0 && total > 0) {
            System.out.println(coeff + "x" + "+" + total + total2 + "=" + 0);
            step2_3 = coeff + "x" + "+" + total + total2 + "=" + 0;
        } else if (total2 < 0 && total < 0) {
            System.out.println(coeff + "x" + total + total2 + "=" + 0);
            step2_3 = coeff + "x" + total + total2 + "=" + 0;
        } else if (total2 > 0 && total < 0) {
            System.out.println(coeff + "x" + total + "+" + total2 + "=" + 0);
            step2_3 = coeff + "x" + total + "+" + total2 + "=" + 0;
        } else {
            System.out.println(coeff + "x" + "+" + total + "+" + total2 + "=" + 0);
            step2_3 = coeff + "x" + "+" + total + "+" + total2 + "=" + 0;
        }
        System.out.println("second step-4");

        if (total2 < 0 && total > 0) {
            System.out.println(coeff + "x" + total2 + "+" + total + "=" + 0);
            step2_4 = coeff + "x" + total2 + "+" + total + "=" + 0;
        } else if (total2 < 0 && total < 0) {
            System.out.println(coeff + "x" + total2 + total + "=" + 0);
            step2_4 = coeff + "x" + total2 + total + "=" + 0;
        } else if (total2 > 0 && total < 0) {
            System.out.println(coeff + "x" + "+" + total2 + total + "=" + 0);
            step2_4 = coeff + "x" + "+" + total2 + total + "=" + 0;
        } else {
            System.out.println(coeff + "x" + "+" + total2 + "+" + total + "=" + 0);
            step2_4 = coeff + "x" + "+" + total2 + "+" + total + "=" + 0;
        }
        System.out.println("third step");
        System.out.println("third step-1");
        solution1 = total + total2;
        if (solution1 < 0) {
            System.out.println(coeff + "x" + solution1 + "=" + 0);
            step3 = coeff + "x" + solution1 + "=" + 0;
        } else {
            System.out.println(coeff + "x" + "+" + solution1 + "=" + 0);
            step3 = coeff + "x" + "+" + solution1 + "=" + 0;
        }
        System.out.println("forth step");
        solution1 = -total2 - total;
        System.out.println(coeff + "x" + "=" + solution1);
        step4 = coeff + "x" + "=" + solution1;
        System.out.println("fifth step");
        System.out.println("x" + "=" + solution1 + "/" + coeff);
        step5 = "x" + "=" + solution1 + "/" + coeff;
       double ans = (double)(solution1) /(double) coeff; 
        ans=ans*100;
   int finalans=(int) ans;
   double finalans2=Double.valueOf(finalans)/100.00;
   
    ans=finalans2;
    
       // solution_2=solution_2*100;
        //int solution3=(int) solution_2;
        //double solution4=solution3/100.00;
        System.out.println("sixth step");
        System.out.println("x" + "=" + ans);
        step6 = "x" + "=" + ans;
        System.out.println("");

        System.out.println("step1  " + step1);
        System.out.println("step2-1  " + step2_1);
        System.out.println("step2-2  " + step2_2);
        System.out.println("step2-3  " + step2_3);
        System.out.println("step2-4  " + step2_4);
        System.out.println("step3    " + step3);
        System.out.println("step4    " + step4);
        System.out.println("step5    " + step5);
        System.out.println("step6    " + step6);
        System.out.println("                                                                   ");
        String step2 = null;

        String step4_1,step4_2;
        
        
         basicobject.put("_id1",step1);
         basicobject.put("parent",null);
         
          basicobject1.put("_id1",step2_1);
         basicobject1.put("parent",step1);
        
          basicobject2.put("_id1",step2_2);
         basicobject2.put("parent",step1);
        
        
           basicobject3.put("_id1",step2_3);
         basicobject3.put("parent",step1);
         
           basicobject4.put("_id1",step2_4);
         basicobject4.put("parent",step1);
        
        
          basicobject5.put("_id1",step4);
         basicobject5.put("parent",step2_1);
         
         
          basicobject6.put("_id1",step4);
         basicobject6.put("parent",step2_2);
         
         basicobject7.put("_id1",step5);
         basicobject7.put("parent",step4);
        
         basicobject8.put("_id1",step6);
         basicobject8.put("parent",step5);
         
         
         basicobject9.put("_id1",step2_3);
         basicobject9.put("parent",step3);
         
         
        basicobject10.put("_id1",step2_4);
         basicobject10.put("parent",step3);
         
         basicobject11.put("_id1",step3);
         basicobject11.put("parent",step4);
         
         
          basicobject12.put("_id1",step4);
         basicobject12.put("parent",step5);
         
          basicobject13.put("_id1",step5);
         basicobject13.put("parent",step6);
        
         
         
         
         
         
         
         customers10.insert(basicobject); 
         customers10.insert(basicobject1); 
          customers10.insert(basicobject2); 
         customers10.insert(basicobject3); 
          customers10.insert(basicobject4); 
            customers10.insert(basicobject5); 
          customers10.insert(basicobject6); 
         customers10.insert(basicobject7); 
          customers10.insert(basicobject8); 
        customers10.insert(basicobject9); 
          customers10.insert(basicobject10); 
            customers10.insert(basicobject11); 
             customers10.insert(basicobject12); 
           customers10.insert(basicobject13); 
            
            
            
            
         
         
        
        
        if (arrayme[0].equals(step1)) {

            System.out.println("step1" + step1);

            if (arrayme[1].equals(step2_1)) {
                System.out.println("step2" + step2_1);

                if (arrayme[2].equals(step4)) {
                    System.out.println("step3" + step4);

                    if (arrayme[3].equals(step5)) {
                        System.out.println("step4" + step5);

                        if (arrayme[4].equals(step6)) {
                            System.out.println("step5" + step6);
                            
                            return step1+" "+step2_1+" "+step4+" "+step5+" "+step6;

                        }
                        
                        else
                        {
                        
                         return step1+" "+step2_1+" "+step4+" "+step5+" "+"wrong";
                        }

                    }

                    else{
                     return step1+" "+step2_1+" "+step4+" "+"wrong"+" "+"wrong";
                    }
                    
                }
                else
                {
                
                 return step1+" "+step2_1+" "+"wrong"+" "+"wrong"+" "+"wrong";
                }

            } else if (arrayme[1].equals(step2_2)) {
                System.out.println("steping" + step2_2);
                if (arrayme[2].equals(step4)) {
                    System.out.println("step3" + step4);

                    if (arrayme[3].equals(step5)) {
                        System.out.println("step4" + step5);

                       if (arrayme[4].equals(step6)) {
                            System.out.println("step5" + step6);
                               return step1+" "+step2_2+" "+step4+" "+step5+" "+step6;
                        }
                       
                       else
                       {
                        return step1+" "+step2_2+" "+step4+" "+step5+" "+"wrong";
                       }

                    }
                    else
                    {
                      return step1+" "+step2_2+" "+step4+" "+"wrong"+" "+"wrong";
                    
                    }

                }
                
                else
                {
                
                 return step1+" "+step2_2+" "+"wrong"+" "+"wrong"+" "+"wrong";
                
                }

            } else if (arrayme[1].equals(step2_3)) {
                System.out.println(step2_3);
                //  return step1+" "+step2_3+" "+step3+" "+step4+" "+step5+" "+step6;
                if (arrayme[2].equals(step3)) {
                    System.out.println("step3" + step3);

                    if (arrayme[3].equals(step4)) {
                        System.out.println("step4" + step4);

                        if (arrayme[4].equals(step5)) {
                            System.out.println("step5" + step5);
                            if (arrayme[5].equals(step6)) {
                                System.out.println("step5" + step6);
                                
                                 return step1+" "+step2_3+" "+step3+" "+step4+" "+step5+" "+step6;
                            }
                            else
                            {
                                return step1+" "+step2_3+" "+step3+" "+step4+" "+step5+" "+"wrong";
                            
                            }

                        }
                        else
                        {
                          return step1+" "+step2_3+" "+step3+" "+step4+" "+"wrong"+" "+"wrong";
                        
                        }

                    }
                    
                    else
                    {
                    
                      return step1+" "+step2_3+" "+step3+" "+"wrong"+" "+"wrong"+" "+"wrong";
                    
                    }

                }
                else
                {
                 return step1+" "+step2_3+" "+"wrong"+" "+"wrong"+" "+"wrong"+" "+"wrong";
                
                }
                

            } else if (arrayme[1].equals(step2_4)) {
                System.out.println(step2_3);
                if (arrayme[2].equals(step3)) {
                    System.out.println("step3" + step3);

                    if (arrayme[3].equals(step4)) {
                        System.out.println("step4" + step4);

                        if (arrayme[4].equals(step5)) {
                            System.out.println("step5" + step5);

                            if (arrayme[5].equals(step6)) {
                                System.out.println("step6" + step6);
                                
                                     return step1+" "+step2_4+" "+step3+" "+step4+" "+step5+" "+step6;

                            }
                            else
                            {
                                   return step1+" "+step2_4+" "+step3+" "+step4+" "+step5+" "+"wrong";
                            
                            }

                        }
                        else
                        {
                        
                         return step1+" "+step2_4+" "+step3+" "+step4+" "+"wrong"+" "+"wrong";
                        }

                    }
                    else
                    {
                    
                        return step1+" "+step2_4+" "+step3+" "+"wrong"+" "+"wrong"+" "+"wrong";
                    
                    }

                }
                else{
                  return step1+" "+step2_4+" "+"wrong"+" "+"wrong"+" "+"wrong"+" "+"wrong";
                }
            }

        } else {

            System.out.println("exit");
        }
        return null;

    }
}
