package tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FirstTask {
	
	public static void main(String[] args) {
		
		String [] values = loadValues();
		String arrayData1 = values[0];
		String arrayData2 = values[1];
		Integer[] arr1 = loadArray(arrayData1);
		Integer[] arr2 = loadArray(arrayData2);
		Integer[] finalArray = subtractArrays(arr1,arr2);
		int sum = findSum(finalArray);	
		System.out.println("The requested array is: " + Arrays.toString(finalArray));
		System.out.println("Sum of its elements is: " + sum);
		System.out.println(sum + " mod 123456789: " + (sum % 123456789));
		
	}
	private static Integer[] subtractArrays(Integer[] arr1, Integer[] arr2 ){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> remaining = new ArrayList<Integer>();
		for(int counter = 0; counter < arr1.length; counter++)
		{
			list.add(arr1[counter]);
		}
		for(int counter = 0; counter < arr2.length; counter++)
		{
			list1.add(arr2[counter]);
		}
		remaining.addAll(list);
		remaining.removeAll(list1);
		Integer[] arr = (Integer[])remaining.toArray(new Integer[remaining.size()]);
		return arr;
	}
	private static int findSum(Integer[] array){
		
		int sum = 0;
		for (int counter = 0; counter < array.length; counter++){
			sum = sum + array[counter];
		}
		return sum;
	}
	private static Integer[] loadArray(String text){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		String removed = text.replace("[","").replace("]","").replace(" ","");
		String[] numbers = removed.split(",");
		for (int counter = 0; counter < numbers.length; counter++)
		{
			list.add(Integer.parseInt(numbers[counter]));
		}
		Integer[] ints = (Integer[])list.toArray(new Integer[list.size()]);
		return ints;
	}
	private static String[] loadValues(){
		
		String[] lines = new String[2];
		int index = 0;
		String line;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("Missing_array_values_vmxMx4lolCJr5hSgvTjhnh2+zA8+AIN8A4C3ONEJiNM=_data.csv"));
			while( (line = reader.readLine()) != null){
				lines[index++] = line;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File was not found on program's directory");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
			reader.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		return lines;
	}
}
