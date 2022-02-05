package RedboxInventory;
//Iman Tanzeem IXT190001
public class CD implements Comparable<CD>
{
    private String title;
    private int available;
    private int rented;
    //constructors 
    public CD()
    {
    }
    public CD(String title)
    {
        this.title = title;
    }
    public CD(String title, int available, int rented)
    {
         this.available = available;
         this.title = title;
         this.rented = rented;
    }
    //set the title 
    public void setTitle(String title)
    {
        this.title = title;
    }
    //sent the available 
    public void setAvailable(int available)
    {
        this.available = available;
    }
    //set the rented
    public void setRented(int rented)
    {
        this.rented = rented;
    }
    //get the title 
    public String getTitle()
    {
        return this.title;
    }
    //get avaiable copies 
    public int getAvailable()
    {
        return this.available;
    }
    //get rented copies 
    public int getRented()
    {
        return this.rented;
    }
    //compare the expected title with actual title
    public int compareTo(CD toCompare)
    {
        return this.getTitle().compareTo(toCompare.getTitle());
    }
    //to string for the ouput for redbox_kiosk.txt
    public String toString()
    {
        StringBuilder inventoryInformation = new StringBuilder();
        inventoryInformation.append(String.format("%-33s%-20s%-6s", this.title, this.available, this.rented));

        return inventoryInformation.toString();
    }

}
