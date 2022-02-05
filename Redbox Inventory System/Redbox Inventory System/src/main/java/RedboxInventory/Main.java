package RedboxInventory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Main
 */
//Iman Tanzeem IXT190001
public class Main {

    public static void main(String[] args) {
        //create a new BST and arraylist
        BST<CD> tree = new <CD>BST();
        ArrayList <String> allTitles = new ArrayList <String>();
        try {
            String line, title, tempAvail, tempRent, templine, testline;
            Scanner inven = ScannerFactory.GetScannerInstance("/Users/imantanzeem/Downloads/Redbox Inventory System/Redbox Inventory System/src/main/java/RedboxInventory/inven.dat").useDelimiter("<").useDelimiter(">").useDelimiter("\"");
            //readers the inven.dat information 
            while (inven.hasNext()) {
                //takes in the title, avaiable, and rented 
                templine = inven.nextLine();
                String [] temp = templine.split(",");
                title = temp[0];
                title = title.replace("\"", "").trim();
                allTitles.add(title);
                tempAvail = temp[1].trim();
                tempAvail = tempAvail.replace("\"", "");
                tempRent = temp[2].trim();
                tempRent = tempRent.replace("\"", "");
                int available = Integer.parseInt(tempAvail);
                int rented = Integer.parseInt(tempRent);
                //inserts the CD information into a CD object and inserts that oobject into the BST
                tree.insert(new CD(title, available, rented));     
                
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       try
        {
            String temptrans, transline, command, line, title, method;
            //creates a printwriter for the redbox_kiosk.txt 
            PrintWriter kiosk = new PrintWriter(new File("/Users/imantanzeem/Downloads/Redbox Inventory System/Redbox Inventory System/src/main/java/RedboxInventory/redbox_kiosk.txt"));
            kiosk.write(String.format("%-33s%-20s%-6s", "Title","Available","Rented") + "\n");
            kiosk.write("------------------------------------------------------------" + "\n");
            Scanner trans = new Scanner(new File("/Users/imantanzeem/Downloads/Redbox Inventory System/Redbox Inventory System/src/main/java/RedboxInventory/transaction.log"));
            //creates a printwriter for the error.log file 
            File errorfile = new File("/Users/imantanzeem/Downloads/Redbox Inventory System/Redbox Inventory System/src/main/java/RedboxInventory/error.log");
            PrintWriter error = new PrintWriter(errorfile);
            //reads the transaction.log file 
            while(trans.hasNext())
            {
                command = trans.nextLine();
                String [] temp = command.split(" ", 2);
                method = temp[0].trim().toUpperCase();
                System.out.println("METHOD: " + method);
                String [] titlearray= temp[1].split(",");
                title = titlearray[0].replace("\"", "");
                //checks to see if title does not exits in the file if not it is added into the arraylist
                if(!(allTitles.contains(title)))
                {
                    allTitles.add(title);
                }
                System.out.println("Title:" + title);
                //checks to see if the commands exists and if they are then function is executed 
                if(method.equals("ADD"))
                {
                   String numberstring = titlearray[1].trim();
                   int number = Integer.parseInt(numberstring);
                   System.out.println(number);
                   Transaction.AddTitle(tree, title, number); 
                }

                else if(method.contains("REMOVE"))
                {
                    String numberstring = titlearray[1].trim();
                    int number = Integer.parseInt(numberstring);
                    System.out.println(number);
                    Transaction.RemoveTitle(tree, title, number); 
                }  

                else if(method.contains("RETURN"))
                {
                    Transaction.ReturnTitle(tree, title);
                }

                else if(method.contains("RENT"))
                {
                    Transaction.RentTitle(tree, title);
                }
                //if an error occurs the command line is displayed in the error file 
                else
                {
                    error.write(command + "\n");
                }
                
                
           } 
           //write the output into the redbox_kiosk.txt file
           for(String name : allTitles)
           {
               CD movie = tree.find(new CD(name));
               if(movie != null)
               {
                   kiosk.write(movie.toString() + "\n"); 
               }
           }
                kiosk.close();
                error.close();

        } 
        catch(Exception e)
        {
            e.printStackTrace();
        } 
      

    }
}