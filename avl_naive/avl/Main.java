package avl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private Avl a;
	private void userInput()
	{
		Scanner s = new Scanner(System.in);
		String input;
		int inputVal;
		a = new Avl();
		input = s.nextLine();
		while(input.trim().equals("q") == false)
		{
			if(input.isEmpty() == false)
			{
				inputVal = Integer.parseInt(input.trim());
				a.insertNode(inputVal);
			}
			input = s.nextLine();
			System.out.println();
		}
	}
	private void userInputDelayed()
	{
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> inputBuffer;
		String input;
		int inputVal, i;
		a = new Avl();
		inputBuffer = new ArrayList<Integer>();
		input = s.nextLine();
		while(input.trim().equals("q") == false)
		{
			if(input.isEmpty() == false)
			{
				inputVal = Integer.parseInt(input.trim());
				inputBuffer.add(inputVal);
			}
			input = s.nextLine();
		}
		for(i = 0; i < inputBuffer.size(); i++)
		{
			a.insertNode(inputBuffer.get(i));
		}
	}
	public static void main(String[] args) 
	{
//		new Main().userInput();
		new Main().userInputDelayed();
	}

}
