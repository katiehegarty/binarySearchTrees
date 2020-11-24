import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Katie Hegarty
 */

@RunWith(JUnit4.class)
public class BSTTest
{
	@Test
	public void testContains() {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertFalse("checking contains for empty bst", bst.contains(3));
		 bst.put(9, 9);
		 bst.put(6, 6);
		 assertTrue("Checking contains for bst with key", bst.contains(6));
		 assertFalse("Checking contains for bst without key", bst.contains(0));
		 
	}
	@Test 
	public void testGet() {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertNull("Checking get for empty bst", bst.get(3));
		 bst.put(6, 6);
		 bst.put(3, 3);
		 assertEquals("Checking get for left of bst", Integer.valueOf(3), bst.get(3));
		 bst.put(89, 89);
		 assertEquals("Checking get for right of bst", Integer.valueOf(89), bst.get(89));
		 bst.put(4, null);
		 assertNull("Checking get for node of null val", bst.get(4)); 
		 assertEquals("Checking get for root", Integer.valueOf(6), bst.get(6));
	}
	
	@Test
	public void testPut() {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 bst.put(7, 7);
		 assertEquals("Checking put method for bst ", Integer.valueOf(7), bst.get(7));
		 bst.put(4,  4);
		 assertEquals("Checking put for left of bst", Integer.valueOf(4), bst.get(4));
		 bst.put(13, 13);
		 assertEquals("Checking put for right of bst", Integer.valueOf(13), bst.get(13));
		 bst.put(12, null);
		 assertNull("Checking put for null val", bst.get(12));
		 BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		 bst2.put(7, 7);   //        _7_
		 bst2.put(8, 8);   //      /     \
		 bst2.put(3, 3);   //    _3_      8
		 bst2.put(1, 1);   //  /     \
		 bst2.put(2, 2);   // 1       6
		 bst2.put(6, 6);   //  \     /
		 bst2.put(4, 4);   //   2   4
		 bst2.put(7, 7);
		 assertEquals("Checking put for double keys", Integer.valueOf(7), bst2.get(7));
		 assertEquals("Checking put for bst", Integer.valueOf(8), bst2.get(8));
		 
	}
  
 	@Test
	public void testHeight() {
	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
	 assertEquals("Checking height of empty bst", -1, bst.height());
	 bst.put(7, 7);
	 assertEquals("Checking height of bst with one node", 0, bst.height());
	 				  //        _7_
	 bst.put(8, 8);   //      /     \
	 bst.put(3, 3);   //    _3_      8
	 bst.put(1, 1);   //  /     \
	 bst.put(2, 2);   // 1       6
	 bst.put(6, 6);   //  \     /
	 bst.put(4, 4);   //   2   4
	 assertEquals("Checking height of bst", 3, bst.height());
	
	}
  
	@Test
	public void testMedian() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertNull("Checking median of empty tree", bst.median());
		bst.put(7, 7);
		assertEquals("Checking median of bst with one node", Integer.valueOf(7), bst.median());
						  //       _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4

		assertEquals("Checking median of bst", Integer.valueOf(4), bst.median());
		BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
		 bst2.put(7, 7);       
	     bst2.put(8, 8);       
	     bst2.put(3, 3);       
	     bst2.put(1, 1);       // 7,8,3,1,2,6,4,5
	     bst2.put(2, 2);       // in order
	     bst2.put(6, 6);       // 1,2,3,4,5,6,7,8
	     bst2.put(4, 4);       
	     bst2.put(5, 5);   
	     assertEquals("Checking median for bst with 8 elements", Integer.valueOf(4), bst2.median());
	      
	}
     @Test 
     public void testPrintOrder( ) {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         assertEquals("Checking print keys in order for empty bst", "()", bst.printKeysInOrder());
         bst.put(2,2);
         bst.put(1, 1);
         assertEquals("Checking printKeysInOrder for 2 nodes", "((()1())2())", bst.printKeysInOrder());
         bst.put(3, 3);
         bst.put(4, 4);
         assertEquals("Checking print keys", "((()1())2(()3(()4())))", bst.printKeysInOrder());
         BST<Integer, Integer> bst2 =new BST<Integer, Integer>();
         bst2.put(7, 7);   //        _7_
    	 bst2.put(8, 8);   //      /     \
    	 bst2.put(3, 3);   //    _3_      8
    	 bst2.put(1, 1);   //  /     \
    	 bst2.put(2, 2);   // 1       6
    	 bst2.put(6, 6);   //  \     /
    	 bst2.put(4, 4);   //   2   4
    	 assertEquals("Checking print keys in order", "(((()1(()2()))3((()4())6()))7(()8()))", bst2.printKeysInOrder());
     }
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
// /** <p>Test {@link BST#delete(Comparable)}.</p> */
 @Test
 public void testDelete() {
	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
	 bst.delete(1);
	 assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

	 bst.put(7, 7);   //        _7_
	 bst.put(8, 8);   //      /     \
	 bst.put(3, 3);   //    _3_      8
	 bst.put(1, 1);   //  /     \
	 bst.put(2, 2);   // 1       6
	 bst.put(6, 6);   //  \     /
	 bst.put(4, 4);   //   2   4
	 bst.put(5, 5);   //        \
	 				  //         5

	 assertEquals("Checking order of constructed tree",
			 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

	 bst.delete(9);
	 assertEquals("Deleting non-existent key",
			 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

	 bst.delete(8);
	 assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

	 bst.delete(6);
	 assertEquals("Deleting node with single child",
			 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

	 bst.delete(3);
	 assertEquals("Deleting node with two children",
			 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	 
	 bst.delete(1);
	 assertEquals("Deleting node with no left child",
	 		"((()2(()4(()5())))7())", bst.printKeysInOrder());
 }
     
}


