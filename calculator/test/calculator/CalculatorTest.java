package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	Calculator c;

	@Before
	public void setup() {
		c = new Calculator();
	}

	@Test
	public void add() {
		assertEquals(7, c.add(3, 4));
	}

	@Test
	public void multiply() {
		assertEquals(8, c.multiply(2, 4));
	}

	@Test
	public void divide() {
		assertEquals(2, c.divide(8, 4));
	}

	@After
	public void teardown() {
		System.out.println("teardown");
	}
}