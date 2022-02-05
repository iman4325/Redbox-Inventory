package RedboxInventory;
//Iman Tanzeem IXT190001
public class Transaction 
{
    //add title function 
    public static void AddTitle(BST<CD> test, String title, int copies)
    {
        CD redbox = test.find(new CD(title));
        //if the CD object does not exist in the tree then create a new node and add to tree 
        if(redbox == null)
        {
            test.insert(new CD(title, copies, 0));
        }
        //if CD object exists then update the available copies 
        else
        {
            redbox.setAvailable(copies + redbox.getAvailable());
            System.out.print(redbox.getAvailable());
        }
    }
    //remove title function 
    public static void RemoveTitle(BST <CD> test, String title, int copies)
    {
        CD redbox = test.find(new CD(title));
        //if the CD object exists in the tree 
        if(redbox != null)
        {
            //then check to see if the available does not equal zero 
            //and decrese the amaount of avaailable copies
            if(redbox.getAvailable() != 0)
            {
                int value = redbox.getAvailable() - copies;
                //if less than zero set available to 0 to ensure there are not negative values
                if(value < 0)
                {
                    value = 0;
                }
                redbox.setAvailable(value);
            }
            //if the available is zero then remove the title 
            else
            {
                test.delete(redbox);
            }
        }
    }
    //return title function 
    public static void ReturnTitle(BST <CD> test, String title)
    {
        CD redbox = test.find(new CD(title));
        //increase and set the available copies 
        int redAvailable = redbox.getAvailable() + 1;
        redbox.setAvailable(redAvailable);
        //decrease and set the rented copies 
        int incRented = redbox.getRented() - 1;
        //to ensure no negative numbers occur set rented to zero 
        if(incRented < 0)
        {
            incRented =0;
        }
        redbox.setRented(incRented);
    }
    //rent title function 
    public static void RentTitle(BST <CD> test, String title)
    {
        CD redbox = test.find(new CD(title));
        //decrease and set the available copies 
        int incAvailable = redbox.getAvailable() - 1;
        redbox.setAvailable(incAvailable);
        //increase and set the rented copies 
        int redRented = redbox.getRented() + 1;
        redbox.setRented(redRented);
    }
}
