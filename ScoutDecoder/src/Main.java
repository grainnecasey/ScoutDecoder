import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	private static String rawData;
	static ArrayList<Team> Data = new ArrayList<Team>(10000);
	private static ArrayList<Team> getData()
	{
		Scanner fScan;
		ArrayList<Team> Data = new ArrayList<Team>(10000);
		ArrayList<String> decoded = new ArrayList<String>();
		try
		{
			fScan = new Scanner(new File("data.txt"));
			rawData += fScan.nextLine();
			String[] d = rawData.split("○");
			for(int i = 0; i < 10000; i++)
				Data.add(null);
			for(int i = 1; i < d.length; i++)
			{
				Match nMatch = new Match();
				decoded = decode(d[i]);
				int index = Integer.parseInt(decoded.get(0));
				nMatch.setData(decoded);
				if (Data.size() == 0 || Data.get(index) == null)
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
			fScan.close();
		}catch (Exception e) {}
		return Data;
	}
	private static ArrayList<String> decode(String in)
	{
		String[] decode = in.split("•");
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 1; i < decode.length; i++)
		{
			temp.add(decode[i]);
		}
		return temp;
	}
	private static void outData()
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter("data.txt");
			writer.println(rawData);
			for(int i = 0; i < Data.size(); i++)
			{
				if(Data.get(i) != null)
				{
					writer.println("Team: " + i);
					for(int j = 0; j < Data.get(i).size(); j++)
					{
						Match curr = Data.get(i).getMatch(j);
						writer.println("\tMatch: " + (j + 1));
						writer.println("\t\tAuto High Goals: " + curr.getAutoHighGoals());
						writer.println("\t\tAuto Low Goals: " + curr.getAutoLowGoals());
						writer.println("\t\tAuto Port " + curr.getAutoPort());
						writer.println("\t\tAuto CDF " + curr.getAutoCDF());
						writer.println("\t\tAuto Ramp " + curr.getAutoRamp());
						writer.println("\t\tAuto Moat " + curr.getAutoMoat());
						writer.println("\t\tAuto Draw " + curr.getAutoDraw());
						writer.println("\t\tAuto Sally " + curr.getAutoSally());
						writer.println("\t\tAuto Rock " + curr.getAutoRock());
						writer.println("\t\tAuto Rough " + curr.getAutoRough());
						writer.println("\t\tAuto Low Bar " + curr.getAutoLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						writer.println("\t\tPort " + curr.getPort());
						writer.println("\t\tCDF " + curr.getCDF());
						writer.println("\t\tRamp " + curr.getRamp());
						writer.println("\t\tMoat " + curr.getMoat());
						writer.println("\t\tDraw " + curr.getDraw());
						writer.println("\t\tSally " + curr.getSally());
						writer.println("\t\tRock " + curr.getRock());
						writer.println("\t\tRough " + curr.getRough());
						writer.println("\t\tLow Bar " + curr.getLowBar());
						writer.println("\t\tHigh Goals" + curr.getHighGoals());
						writer.println("\t\tLow Goals" + curr.getLowGoals());
						writer.println("\t\tScale: " + curr.getScaled());
						writer.println("\t\tSurround: " + curr.getSurround());
						writer.println("\t\tComment: " + curr.getComment());
						writer.println("\t\tScouter: " + curr.getScouter());
					}
				}
			}
			writer.close();
		} catch (FileNotFoundException e) { System.out.println("error writting to file"); }
		
	}
	public static void main(String[] args)
	{
		rawData = "";
		Scanner reader;
		
		ArrayList<String> decoded = new ArrayList<String>();
		String input;
		int index;
		
		Data = getData();
		System.out.println("Type anything invalid to exit");
		reader = new Scanner(System.in);
		boolean run = true;
		for(int i = 0; i < 10000; i++)
			Data.add(null);
		while(run)
		{
			try
			{
				Match nMatch = new Match();
				System.out.println("Input: ");
				input = reader.next();
				decoded = decode(input);
				index = Integer.parseInt(decoded.get(0));
				nMatch.setData(decoded);
				rawData = rawData + "○" + input;
				if (Data.size() == 0 || Data.get(index) == null)
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
