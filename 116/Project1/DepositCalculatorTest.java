/**
 * Tests DepositCalculator program
 * @author Suzanne Balik
 */
public class DepositCalculatorTest {
	public static void main(String[] args) {
		double amount = DepositCalculator.calculateAmountNoCompounding(5000, 4, 10);
		System.out.printf("Expected: 7000.00 Actual: %.2f\n", amount);
		amount = DepositCalculator.calculateAmountMonthlyCompounding(1500, 7, 25);
		System.out.printf("Expected: 8588.13 Actual: %.2f\n", amount);
		amount = DepositCalculator.calculateAmountContinuousCompounding(9500, 13, 12);
		System.out.printf("Expected: 45208.80 Actual: %.2f\n", amount);
	}
}
