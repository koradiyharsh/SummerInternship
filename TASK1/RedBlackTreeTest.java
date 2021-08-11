package task1;

import static org.junit.Assert.*;

import org.junit.Test;

import task1.Redblackgeneric.Node;

public class RedBlackTreeTest {

	@Test
	public void test() {
		
		
		Redblackgeneric<Integer> redblack = new Redblackgeneric<Integer>();
		
		// TestCase success
		redblack.insert(2);
		Node node = redblack.getRoot(); 
		assertEquals(node.data , 2);
		
		
		redblack.insert(45);
		redblack.insert(23);
		
		
		// Testcase success
		node =  redblack.minimum(node);
		assertEquals(node.data, 2);
		
		//Testcase success
		node = redblack.searchTree(72);
		assertEquals(node.data, null);
		
		
		
	}

}
