package synthesizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
	/**
	 * Calls tests for ArrayRingBuffer.
	 */
	public static void main(String[] args) {
		jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
	}

	@Test
	public void someTest() {
		ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(10);
		arb.enqueue(10);
		arb.enqueue(5);
		assertEquals(arb.dequeue(), (Integer) 10);
		assertEquals(arb.dequeue(), (Integer) 5);
	}
} 
