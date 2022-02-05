package RedboxInventory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

//Iman Tanzeem IXT190001

//Unit Testing
public class AppTest 
{
    @Test
    public void AddTitle( )
	{
		BST<CD> BST = new BST<CD>(); 
		Transaction.AddTitle(BST, "Batman", 10);
		CD batman = BST.find(new CD("Batman"));
		assertTrue(batman != null);
		assertEquals(10, batman.getAvailable());
		assertEquals(0, batman.getRented());

		Transaction.AddTitle(BST, "Batman", 10);
		batman = BST.find(new CD("Batman"));
		assertTrue(batman != null);
		assertEquals(20, batman.getAvailable());
		assertEquals(0, batman.getRented());
	}
	
    @Test 
	public void RemoveTitle( )
	{
		BST<CD> BST = new BST<CD>(); 
		Transaction.AddTitle(BST, "Batman", 10);
		Transaction.RemoveTitle(BST, "Batman", 5);
		CD batman = BST.find(new CD("Batman"));
		assertTrue(batman != null);
		assertEquals(5, batman.getAvailable());
		assertEquals(0, batman.getRented());

		Transaction.RemoveTitle(BST, "Batman", 10);
		batman = BST.find(new CD("Batman"));
		assertTrue(batman != null);
		assertEquals(0, batman.getAvailable());
		assertEquals(0, batman.getRented());

		Transaction.RemoveTitle(BST, "Batman", 10);
		batman = BST.find(new CD("Batman"));
		assertTrue(batman == null);
	}
	
    @Test
	public void RentTitle( )
	{
		BST<CD> BST = new BST<CD>(); 
		Transaction.AddTitle(BST, "Batman", 10);
		Transaction.RentTitle(BST, "Batman");
		CD batman = BST.find(new CD("Batman", 10, 10));
		assertEquals(9, batman.getAvailable());
		assertEquals(1, batman.getRented());

	}
	
    @Test 
	public void ReturnTitle( )
	{
		BST<CD> BST = new BST<CD>(); 
		Transaction.AddTitle(BST, "Batman", 10);
		Transaction.RentTitle(BST, "Batman");
		Transaction.RentTitle(BST, "Batman");
		Transaction.RentTitle(BST, "Batman");
		Transaction.ReturnTitle(BST, "Batman");
		CD batman = BST.find(new CD("Batman"));
		assertEquals(8, batman.getAvailable());
		assertEquals(2, batman.getRented());
	}

}
