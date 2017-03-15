package calculator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	StringCalculator sc;

	@Before()
	public void setup() {
		sc = new StringCalculator();
		sc.splitter[2] = 'p';
	}

	@Test
	public void readSplitter() {
		assertEquals('p', StringCalculator.readSplitter("//p\n1p2p3"));
	}

	@Test
	public void removeSplitterPart() {
		assertEquals("1p2p3", StringCalculator.removeSplitterPart("//p\n1p2p3"));
	}

	@Test
	public void splitInput() {
		assertArrayEquals(new String[] { "1", "2", "3" }, StringCalculator.splitInput("1p2p3", sc.splitter));
	}

	@Test
	public void checkCondition1() {
		// 깊은 비교 아닌 얕은 비교하기 때문에 Number 객체 배열로 비교하는 assertArrayEquals 못씀
		int[] testInt = { 1, 2, 3 };
		Number[] testNum = StringCalculator.checkConditionAndParse(new String[] { "1", "2", "3" });
		for (int i = 0; i < testNum.length; i++)
			assertEquals(testInt[i], testNum[i].get());
	}

	@Test(expected = RuntimeException.class)
	public void checkCondition2() {
		StringCalculator.checkConditionAndParse(new String[] { "1", "2", "pp" });
	}

	@Test(expected = RuntimeException.class)
	public void checkCondition3() {
		StringCalculator.checkConditionAndParse(new String[] { "1", "-5", "3" });
	}

	@Test
	public void add() {
		assertEquals(9, StringCalculator.add(new Number[] { new Number("1"), new Number("5"), new Number("3") }));
	}

	@Test
	public void calculate() {
		assertEquals(18, sc.calculate("//g\n3g6:1,2:3g3"));
	}

}
