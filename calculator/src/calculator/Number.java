package calculator;

public class Number {
	private int num;

	public Number(String num) {
		// 숫자가 맞는지
		// 오류 나면 알아서 RuntimeException인 NumberFormatException 날린다
		this.num = Integer.parseInt(num);
		// 음수가 아닌지
		if (this.num < 0)
			throw new RuntimeException();
	}

	public int get() {
		return num;
	}
}
