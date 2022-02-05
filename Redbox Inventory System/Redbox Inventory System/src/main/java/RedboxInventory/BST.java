package RedboxInventory;
import java.util.*;
//Iman Tanzeem IXT190001
public class BST <T extends Comparable<T>> 
{
   //CONSTRUCTORS
   private Node<T> root;
   private Comparable<T> comparator;
   
   public BST()
   {
      root = null;
      comparator = null;
   }

   public BST(Comparable<T> comp)
   {
      root = null;
      comparator = comp;
   }

   private int compare(T x, T y)
   {
      if(comparator == null) return x.compareTo(y);
      else
      return x.compareTo(y);
   }

   //INSERT FUNCTION
   public void insert(T data)
   {
      //sets the root to the the inserted node 
      root = insert(root, data);
   }
   private Node<T> insert(Node<T> p, T toInsert)
   {
      //if node is null then a new node with the element T is created 
      if (p == null)
         return new Node<T>(toInsert);
      //compares the element to the data of the node that was inserted 
      //if the comparison is sero return the node 
      if (compare(toInsert, p.data) == 0)
      	return p;
      //if the comparison is less than zero then send the node to the left 
      if (compare(toInsert, p.data) < 0)
         p.left = insert(p.left, toInsert);
      //if the comparison is greater than zero then send the node to the right  
      else
         p.right = insert(p.right, toInsert);

      return p;
   }

   //SEARCH FUNCTION
   public boolean search(T toSearch)
   {
      //return the search method 
      return search(root, toSearch);
   }
   private boolean search(Node<T> p, T toSearch)
   {
      //if node does not exist in tree then return false 
      if (p == null)
         return false;
      //if the compare is zero then return tree because the node was found in tree 
      else
      if (compare(toSearch, p.data) == 0)
         return true;
      //if the compare is less than zero then return the search method with the left node 
      else
      if (compare(toSearch, p.data) < 0)
         return search(p.left, toSearch);
      //if the compare is greater than zero then return the search method with the right node 
      else
         return search(p.right, toSearch);
   }

   //FIND FUNCTION
   public T find(T toSearch)
   {
      return find(root, toSearch);
   }
   private T find(Node<T> p, T toSearch)
   {
      if (p == null)
         return null;
      else
      if (compare(toSearch, p.data) == 0)
      	return p.data;
      else
      if (compare(toSearch, p.data) < 0)
         return find(p.left, toSearch);
      else
         return find(p.right, toSearch);
   }

   //DELETE FUNCTION
   public void delete(T toDelete)
   {
      //sets the root to the node of the delete method 
      root = delete(root, toDelete);
   }
   private Node<T> delete(Node<T> p, T toDelete)
   {
      //if not able to delete throw exception 
      if (p == null)  throw new RuntimeException("cannot delete.");
      //if the compare is less than zero then zero then set the delete node to the left 
      else
      if (compare(toDelete, p.data) < 0)
      p.left = delete (p.left, toDelete);
      else
      //is compare is greater than zero then set the delete node to the right 
      if (compare(toDelete, p.data)  > 0)
      p.right = delete (p.right, toDelete);
      else
      {
         //left is null then return the right 
         if (p.left == null) return p.right;
         //if right is null return left 
         else
         if (p.right == null) return p.left;
         else
         {
         // get data from the rightmost node in the left subtree
            p.data = retrieveData(p.left);
         // delete the rightmost node in the left subtree
            p.left =  delete(p.left, p.data) ;
         }
      }
      return p;
   }
   //retreive the data in node 
   private T retrieveData(Node<T> p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }

   //TOSTRING
   public String toString()
   {
      StringBuffer sb = new StringBuffer();

      return sb.toString();
   }
   
   //PREODER AND INORDER TRAVERSALS
   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   //to traverse through the tree before it is put into order 
   private void preOrderHelper(Node r)
   {
      if (r != null)
      {
         System.out.print(r+" ");
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }
   //to traverse through the after it is put into order 
   public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   private void inOrderHelper(Node r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r+" ");
         inOrderHelper(r.right);
      }
   }

  //This method restores a BST given preorder and inorder traversals
   public void restore(T[] pre, T[] in)
   {
      root = restore(pre, 0, pre.length-1, in, 0, in.length-1);
   }
   private Node<T> restore(T[] pre, int preL, int preR, T[] in, int inL, int inR)
   {
      if(preL <= preR)
      {
         int count = 0;
         //find the root in the inorder array
         while(pre[preL] != in[inL + count]) count++;

         Node<T> tmp = new Node<T>(pre[preL]);
         tmp.left = restore(pre, preL+1, preL + count, in, inL, inL +count-1);
         tmp.right = restore(pre, preL+count+1, preR, in, inL+count+1, inR);
         return tmp;
      }
      else
         return null;
   }


   //NODE CLASS
   private class Node<T>
   {
      private T data;
      private Node<T> left, right;
      private String title;
      //constructors 
      public Node(T data, Node<T> l, Node<T> r)
      {
         left = l; right = r;
         this.data = data;
      }

      public Node(T data)
      {
         this(data, null, null);
      }

      public String toString()
      {
         return data.toString();
      }
      //set left node 
      public void setLeft(Node<T> l)
      {
         this.left = l;
      }
      //set right node 
      public void setRight(Node<T> r)
      {
         this.right = r;
      }
      //get right node 
      public Node<T> getLeft()
      {
         return left;
      }
      //get letf node
      public Node<T> getRight()
      {
         return right;
      }
   } 
}
