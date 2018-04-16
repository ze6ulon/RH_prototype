/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh_prototype;

import java.util.Scanner;

/**
 *
 * @author ze6ulon
 */
public class RH_prototype {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String month, year;
        int choice = 0;
        
        System.out.println("This software allows us to have monthly financial summury\n\n");
        

        System.out.println("Press <ENTREE> to continue...");
        
        System.out.print("Enter the budget month : ");
        month = scan.next();
        
        System.out.print("Enter the budget year : ");
        year = scan.next();
        
        System.out.println("-----------------------");
        System.out.println("BUDGET - " + month + " " + year);
        System.out.println("-----------------------");
        System.out.println("1. Enter revenu");
        System.out.println("2. Enter depenses");
        System.out.println("3. Show bilan");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        choice = scan.nextInt();
        switch(choice){
            case 1:
                System.out.println("Choice entered is 1");
                break;
            case 2:
                System.out.println("Choice entered is 1");
               break; 
            case 3:
                System.out.println("Choice entered is 1");
                break;
            case 4:
                System.out.println("Choice entered is 1");
                break;
                    
            default:
                System.out.println("Choice entered is default");
        }
       
    }
    
}
