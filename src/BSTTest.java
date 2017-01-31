import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Jordan Myers
 */

@RunWith(JUnit4.class)
public class BSTTest
{
	@Test
	public void testContains() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertFalse("Testing contains on an empty list", bst.contains(1));
		bst.put(1, 1);
		assertTrue("Testing contains on a list with 1 element", bst.contains(1));
		bst.put(2, 2);
		assertTrue("Testing contains on a list with 2 elements", bst.contains(2));
	}
	
	@Test
	public void testGet() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertNull("Testing get on an empty tree", bst.get(1));
		bst.put(1, 1);
		assertEquals("Testing get on a tree with one element", 1, (int)bst.get(1));
		
		bst = new BST<Integer, Integer>();
		  bst.put(7, 7);   //        _7_
	      bst.put(8, 8);   //      /     \
	      bst.put(3, 3);   //    _3_      8
	      bst.put(1, 1);   //  /     \
	      bst.put(2, 2);   // 1       6
	      bst.put(6, 6);   //  \     /
	      bst.put(4, 4);   //   2   4
	      bst.put(5, 5);   //        \
	                       //         5
	      assertEquals("Testing get on a tree with multiple elements (root's left subtree)", 1, (int)bst.get(1));
	      assertEquals("Testing get on a tree with multiple elemnets (root's right subtree)", 8, (int)bst.get(8));
	      assertEquals("Testing get on a tree with multiple elements (root itself)", 7, (int)bst.get(7));
	}
	
	@Test 
	public void testPut () {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(1, 1);
		bst.put(1, 1);
		assertEquals("Testing put when same key and value is input twice", "(()1())", bst.printKeysInOrder());
		bst.put(1, 2);
		assertEquals("Testing put when same key is input with different value", "(()1())", bst.printKeysInOrder());
		bst.put(1, null);
		assertEquals("Testing put when val is null. Key should be deleted", "()",bst.printKeysInOrder());
		
		bst = new BST<Integer, Integer>();
		assertNull("Test that the root is null when the tree is empty", bst.getRoot());
		bst.put(7, 7);
		assertEquals("Testing put for an empty tree (root==null)", "(()7())", bst.printKeysInOrder());
	}
  
  @Test 
  public void testHeight() {
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  assertEquals("Testing height of empty tree", -1, bst.height());
	  bst.put(1, 1);
	  assertEquals("Testing height of tree with one node", 0, bst.height());
	  
	  bst = new BST<Integer, Integer>();
	  bst.put(7, 7);   //        _7_
      bst.put(8, 8);   //      /     \
      bst.put(3, 3);   //    _3_      8
      bst.put(1, 1);   //  /     \
      bst.put(2, 2);   // 1       6
      bst.put(6, 6);   //  \     /
      bst.put(4, 4);   //   2   4
      bst.put(5, 5);   //        \
                       //         5
      assertEquals("Testing height of tree with 5 levels; 4 links", 4, bst.height());
  }
  
  @Test 
  public void testMedian() {
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  assertNull("Testing getting the median for an empty tree", bst.median());
	  bst.put(1, 1);
	  assertEquals("Testing getting the median for a tree with one node", 1, (int)bst.median());
	  
	  bst = new BST<Integer, Integer>();
	  bst.put(7, 7);   //        _7_
      bst.put(8, 8);   //      /     \
      bst.put(3, 3);   //    _3_      8
      bst.put(1, 1);   //  /     \
      bst.put(2, 2);   // 1       6
      bst.put(6, 6);   //  \     /
      bst.put(4, 4);   //   2   4
      bst.put(5, 5);   //        \
                       //         5
      assertEquals("Testing getting the median for a tree with 8 nodes", 4, (int)bst.median());
      bst.put(9, 9);
      assertEquals("Testing getting the median for a tree with 9 nodes", 5, (int)bst.median());
      bst.put(10, 10);
      assertEquals("Testing getting the median for a tree with 10 nodes", 5, (int)bst.median());
  }
  
  @Test
  public void testSelect () {
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  assertNull("Testing select when node is null", bst.select(1));
  }
  
  @Test
  public void testPrintKeysInOrder () {
	  BST<Integer, Integer> bst = new BST<Integer, Integer>();
	  assertEquals("Testing printing keys in order in an empty tree", "()", bst.printKeysInOrder());
	  bst.put(1, 1);
	  assertEquals("Testing printing keys in order in a tree with 1 element", "(()1())", bst.printKeysInOrder());
	  
	  bst = new BST<Integer, Integer>();
	  bst.put(7, 7);   //        _7_
      bst.put(8, 8);   //      /     \
      bst.put(3, 3);   //    _3_      8
      bst.put(1, 1);   //  /     \
      bst.put(2, 2);   // 1       6
      bst.put(6, 6);   //  \     /
      bst.put(4, 4);   //   2   4
      bst.put(5, 5);   //        \
                       //         5
      assertEquals("Testing printing keys in order for a tree with 8 nodes", "(((()1(()2()))3((()4(()5()))6()))7(()8()))",  bst.printKeysInOrder());
      
      BST<String, String> bstAlpha = new BST<String, String>();
      assertEquals("Testing printing keys in order in an empty tree", "()", bstAlpha.printKeysInOrder());
	  bstAlpha.put("B", "B");
	  assertEquals("Testing printing keys in order in a tree with 1 element", "(()B())", bstAlpha.printKeysInOrder());
	  bstAlpha.put("A", "A");
	  bstAlpha.put("C", "C");
	  bstAlpha.put("D", "D");
	  assertEquals("Testing printing keys in order in a tree with 4 elements,", "((()A())B(()C(()D())))", bstAlpha.printKeysInOrder());
  }

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
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

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
//         System.out.println(bst.printKeysInOrder());
         bst.put(1, 1);
//         System.out.println(bst.printKeysInOrder());
         bst.delete(1);
//         System.out.println(bst.printKeysInOrder());
         assertEquals("Deleting from tree with 1 node", "()", bst.printKeysInOrder());
         
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
     }
     
     @Test
     public void testFloor() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertNull("Testing floor when tree is empty", bst.getNodeValue(bst.floor(1)));
    	 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("Testing floor when value is in tree",7,(int)bst.getNodeValue(bst.floor(7)));
         assertEquals("Testing floor when value is not in tree", 8, (int)bst.getNodeValue(bst.floor(9)));
         bst.delete(3);
         assertEquals("Testing floor when value is less than key", 2, (int)bst.getNodeValue(bst.floor(3)));
     }
     
     
}
