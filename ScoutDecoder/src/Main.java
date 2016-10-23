import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	private static String rawData;
	private static ArrayList<Team> getData()
	{
		Scanner fScan;
		ArrayList<Team> Data = new ArrayList<Team>();
		ArrayList<String> decoded = new ArrayList<String>();
		try
		{
			fScan = new Scanner(new File("/res/data.txt"));
			rawData = fScan.nextLine();
		} 
		catch (FileNotFoundException e) {}
		String[] d = rawData.split("○");
		int index = Integer.parseInt(d[0]);
		for(int i = 1; i < d.length; i++)
		{
			Match nMatch = new Match();
			decoded = decode(d[i]);
			nMatch.setData(decoded);
			if (Data.get(index) == null)
			{
				Team nTeam = new Team();
				nTeam.addMatch(nMatch);
				Data.set(index, nTeam);
			}
			else
			{
				Team tTeam = Data.get(index);
				tTeam.addMatch(nMatch);
				Data.set(index, tTeam);
			}
		}
		return Data;
	}
	private static ArrayList<String> decode(String in)
	{
		String[] decode = new String[25];
		ArrayList<String> temp = new ArrayList<String>();
		decode = in.split("•");
		for (int i = 1; i <= 25; i++)
		{
			temp.add(decode[i]);
		}
		return temp;
	}
	private static void outData()
	{
		
	}
	public static void main(String[] args)
	{
		
		Scanner reader;
		ArrayList<Team> Data = new ArrayList<Team>();
		ArrayList<String> decoded = new ArrayList<String>();
		String input;
		String[] decode = new String[25];
		int index;
		Data = getData();
		System.out.println("Type anything invalid to exit");
		reader = new Scanner(System.in);
		boolean run = true;
		while(run)
		{
			Match nMatch = new Match();
			System.out.println("Input: ");
			input = reader.next();
			rawData += rawData + "○" + input;
			index = Integer.parseInt(decode[0]);
			try
			{
				decoded = decode(input);
				nMatch.setData(decoded);
				if (Data.get(index) == null)
				{
					Team nTeam = new Team();
					nTeam.addMatch(nMatch);
					Data.set(index, nTeam);
				}
				else
				{
					Team tTeam = Data.get(index);
					tTeam.addMatch(nMatch);
					Data.set(index, tTeam);
				}
			}
			catch(Exception e)
			{
				run = false;
			}
		}
		reader.close();
		System.out.println("Exiting");
		outData();
	}	
	
}
