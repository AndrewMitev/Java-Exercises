package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThirdTask {

	private static ArrayList<Integer> numbers  = new ArrayList<Integer>();
	private static Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
	private static int mapKeys = 0;
	
	public static void main(String[] args) {
		
		loadData();
		Integer[][] array = new Integer[mapKeys][];
		for (int row =0; row < mapKeys; row++){
			
			Integer[] temporary = map.get(row);
			array[row] = temporary;
		}
		findUniqueRows(array);
	}
	private static void loadData(){
			
			BufferedReader reader = null;
			String data = null;
			try{
				reader = new BufferedReader(new FileReader("Different_values_row_Cep64FMtGhAeTdiQpeBlsva5aXdzyBGDi9TUAELpxog=_data.csv"));
				while ((data = reader.readLine()) != null){
					
					loadMap(data);
				}
			}
			catch (IOException e){
				System.out.println("Could not open the file requested. Check if it is program's directory.");
			}
			finally{
				try {
					reader.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	private static void loadMap(String line){
		
		line = line.replace(","," ");
		Scanner textScanner = new Scanner(line);
		while(textScanner.hasNext()){
			
			numbers.add(Integer.parseInt(textScanner.next()));
		}
		map.put(mapKeys,(Integer[])numbers.toArray(new Integer[numbers.size()]));
		numbers.clear();
		mapKeys++;
		textScanner.close();
	}
	private static void findUniqueRows(Integer[][] array){
		
		ArrayList<Integer> temporaryList = new ArrayList<Integer>();
		boolean flag = false;
		
		for (int row = 0; row < array.length; row++){
			innerFor:
			for (int column = 0; column < array[0].length; column++){
				
				if (column == 0){
					
					temporaryList.add(array[row][column]);
					continue;
				}
				if (temporaryList.contains(array[row][column])){
					
					break innerFor;
				}
				temporaryList.add(array[row][column]);
				if (column == array[0].length - 1){
					
					System.out.println("Row " + (row + 1) +  " contains different values.");
					flag = true;
				}
			}
			temporaryList.clear();
		}
		if (flag == false){
			System.out.println("Not a single row with different values was found.");
		}
	}

}
