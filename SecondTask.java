package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class SecondTask {
	
	public static void main(String[] args) {
		
		Map<String, Integer> list = findNamesMatch(loadData());
		System.out.println("Sum of all duplications: " + findDuplicationsSum(list));
	}
	private static Map<String, Integer> findNamesMatch(String list){
		
		Map<String, Integer> countedList = new TreeMap<String, Integer>();
		ArrayList<String> oddNames = new ArrayList<String>();
		list = list.replace(","," ");
		Scanner reader = new Scanner(list);
		while(reader.hasNext()){
			String name = reader.next();
			Integer count = countedList.get(name);
			if (count == null){
				count = 0;
			}
			countedList.put(name,count+1);
		}
		for(Map.Entry<String, Integer> namesEntry:countedList.entrySet()){
			
			if (namesEntry.getValue() < 2){
				oddNames.add(namesEntry.getKey());
			}
		}
		for (String name:oddNames){
			countedList.remove(name);
		}
		reader.close();
		return countedList;
	}
	private static int findDuplicationsSum(Map<String, Integer> map){
		
		int sum = 0;
		
		for(Map.Entry<String, Integer> namesEntry:map.entrySet()){
			
			System.out.println(namesEntry.getKey() +  ": " + namesEntry.getValue());
			sum += namesEntry.getValue();
		}
		return sum;
	}
	private static String loadData(){
		
		BufferedReader reader = null;
		String data = null;
		try{
			reader = new BufferedReader(new FileReader("Duplicated_names_list_m9nrnhSTKJmkBOro5ovkS1AsLWyxo+gHCXgOj6tdVn4=_data.csv"));
			data = reader.readLine();
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
		return data;
	}
		
}
