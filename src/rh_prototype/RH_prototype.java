/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh_prototype;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
        String entete, month;
        int year;
        char choice = '0';
        double revenus = 0.0; 
        double depenses = 0.0;
        
        System.out.println("This software allows us to have monthly financial summury\n");

        enterToContinu();

        System.out.print("Enter the budget month : ");
        month = scan.next();
        
        do{
            System.out.print("Enter the budget year : ");
            year = scan.nextInt();
            if( year < 2017 || year > 9999 ){
                System.out.println("\nAnnee invalide. Please enter a value between 2017 and 9999... Please try it again !");
            }
        }while( year < 2017 || year > 9999 );
        
        
        entete = "BUDGET - " + month + " " + year;
        
        do{
            System.out.println("\n-----------------------");
            System.out.println( entete.toUpperCase());
            System.out.println("-----------------------");
            System.out.println("1. Enter revenu");
            System.out.println("2. Enter depenses");
            System.out.println("3. Show bilan");
            System.out.println("4. Exit");
            do{
                System.out.print("\nEnter your choice: ");
                choice = scan.next().charAt(0);
                switch(choice){
                    case '1':
                        //System.out.println("Choice entered is 1 --> Enter revenu");
                        revenus = enterRevenu(revenus);
                        break;
                    case '2':
                        //System.out.println("Choice entered is 2 --> Enter depenses");
                       depenses = enterDepense(depenses);
                        break; 
                    case '3':
                        //System.out.println("Choice entered is 3 --> Show bilan");
                        showBilan( revenus, depenses );
                        break;
                    case '4':
                        //System.out.println("Choice entered is 4 --> Exit");
                        exit();
                        break;
                    default:
                        System.out.print("\nMenu invalide. Please enter a value between 1 and 4... Please try it again !");
                }
            }while(choice < '1' || choice > '4' );
        }while(choice != '4');
        
    }
    
    
    public static double enterRevenu(double revenus){
        String revenuString = "";
        double revenu = 0.0;
        
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Enter the revenu (0 to exit) : ");
            revenuString = scan.next();
            revenu = Double.parseDouble(revenuString);
            
            if(revenu < 0){
                System.out.println("\nAmount not valid. Please enter a value greater or egal to 0... Enter a new value !");
            }else{
                revenus = revenus + revenu;
            }
        }while( revenuString.compareTo("0") != 0);
        
        return revenus;
    }
    
    
    public static double enterDepense( double depenses ){
        String depenseString = "";
        double depense = 0.0;
        
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Enter the depense (0 to exit): ");
            depenseString = scan.next();
            depense = Double.parseDouble(depenseString);
            
            if(depense < 0){
                System.out.println("\nAmount not valid. Please enter a value greater or egal to 0... Enter a new value !");
            }else{
                depenses = depenses + depense;
            }
        }while( depenseString.compareTo("0") != 0);
        
        return depenses;
    }
    
    public static void showBilan(double revenus, double depenses ){
        
        double solde = 0.0;
        double pourcent = 0.0;
        solde = revenus - depenses;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        
        System.out.println("\nBILAN");
        System.out.println("--------------------------------------------------");
        System.out.format("%15s |%15s |%15s", "REVENUS", "DEPENSES", "SOLDE");
        System.out.println("");
        
        System.out.println("--------------------------------------------------");
        System.out.format("%13s $ |%13s $ |%13s $", df.format(revenus), df.format(depenses), df.format(solde));
        
        System.out.println("");
        System.out.println("--------------------------------------------------");
        
        if(solde >= 0){
            if (revenus >0){
                pourcent = depenses * 100.00 / revenus;
            }
            System.out.println("\nYou have use " + df.format(pourcent) + " pourcent of your total revenu.") ;
        }else{
            System.out.println("*** WARNING ***");
            System.out.println("You have a deficit of" + df.format(Math.abs(solde)) + " $");
        }
        
        enterToContinu();
        
    }

    public static void enterToContinu() {
        System.out.println("\nPress <ENTREE> to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void exit(){
        System.out.println("\nGOOD BYE !!!");
    } 
    
}
