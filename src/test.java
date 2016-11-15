import java.awt.DisplayMode;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Arrays;

public class test
{
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public int[] rollDice()
	{
		int[] returnRoll = new int[3];
		returnRoll[0] = (1 + randomNumbers.nextInt(6));
		returnRoll[1] = (1 + randomNumbers.nextInt(6));
		returnRoll[2] = returnRoll[0] + returnRoll[1];
		System.out.println(returnRoll[0]);
		System.out.println(returnRoll[1]);
		return returnRoll;
	}
	
	public int[] numbers()
	{
        int[] A = {1,2,3};
        return A;
    }
	
	public void display(int[] input)
	{
		for ( int i = 0; i < input.length; i++)
			System.out.print(input[i]);
	}

	
	public static void main(String[] args)
	{

		
		
		
		test t = new test();
		int[] result = t.rollDice();
		int[] op = t.numbers();
		System.out.println(Arrays.toString(result));
		System.out.println(result[0]);
		System.out.println(result[1]);
//		
//		int[] results;
//		results = t.rollDice();
//		
//		t.display(results);
//		
//		for ( int i = 0; i < results.length; i++)
//			System.out.println(results[i]);

		
//		for ( int i = 0; i < 2; i++)
//		{
//			t.rollDice();
//			System.out.println(t.rollDice(i));
//		}
	}
}