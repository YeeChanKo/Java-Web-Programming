package calculator;

public class StringCalculator {

	public char[] splitter;

	// 구분자 초기화
	public StringCalculator() {
		splitter = new char[3];
		splitter[0] = ',';
		splitter[1] = ':';
	}

	// 다 합친 계산 기능
	public int calculate(String input) {
		if (input == null)
			return 0;
		if (input.isEmpty())
			return 0;

		splitter[2] = readSplitter(input);
		input = removeSplitterPart(input);
		String[] resultStrings = splitInput(input, this.splitter);
		Number[] resultNums = checkConditionAndParse(resultStrings);

		return add(resultNums);
	}

	// 구분자 읽기
	public static char readSplitter(String input) {
		String output = input.replaceAll("//|\n.*", "");
		return output.charAt(0);
	}

	// 입력값에서 구분자 부분 제거
	public static String removeSplitterPart(String input) {
		return input.replaceAll("//.*\n", "");
	}

	// 설정된 구분자로 입력값 구분
	public static String[] splitInput(String input, char[] splitter) {
		return input.split(splitter[0] + "|" + splitter[1] + "|" + splitter[2]);
	}

	// 커스텀한 Number 클래스 생성자로 입력된 값이 조건에 맞는지 확인하고 Number 배열 리턴
	public static Number[] checkConditionAndParse(String[] s) {
		Number[] n = new Number[s.length];
		for (int i = 0; i < n.length; i++)
			n[i] = new Number(s[i]);

		return n;
	}

	// 넘겨받은 Number 배열 안의 수의 합 리턴
	public static int add(Number[] n) {
		int sum = 0;
		for (int i = 0; i < n.length; i++)
			sum += n[i].get();

		return sum;
	}
}
