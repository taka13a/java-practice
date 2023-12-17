import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String args[]) {
		System.out.println("自然数を入力してください。入力された値が素数かどうかを判定し、素数でなければ素因数分解した結果を表示します。");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String inputStr = br.readLine();
				if (!isNaturalNumber(inputStr)) {
					System.out.println(Integer.MAX_VALUE + "以下の自然数を入力してください。");
					continue;
				}
				
				int input = Integer.parseInt(inputStr);
				boolean isPrime =isPrime(input);
				
				if (isPrime) {
					System.out.println("OK");
					break;
				} else {
					System.out.println("NG");
					System.out.println("素因数分解結果:" + primeFactorization(input));
					break;
				}
			}catch (NumberFormatException e){
				System.out.println(Integer.MAX_VALUE + "以下の自然数を入力してください。");
				continue;
			} catch (IOException e) {
				System.out.println("システムエラーが発生しました。");
			}
		}
	}
	
	public static boolean isNaturalNumber(String input) {
		try {
			return Long.parseLong(input) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean isPrime(int input) {
		if (input < 2) {
			return false;
		} else if (input == 2) {
			return true;
		} else if (input % 2 == 0) {
			return false;
		}
		
		for (int i = 3; i <= Math.sqrt(input); i += 2) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Integer> primeFactorization(int input) {
		List<Integer> factors = new ArrayList<>();
		for (int i = 2; i <= input; i++) {
			while (input % i == 0) {
				factors.add(i);
				input /= i;
			}
		}
		return factors;
	}
}
