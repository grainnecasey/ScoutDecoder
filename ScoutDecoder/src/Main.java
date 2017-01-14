import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
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
			for (int i = 0; i < 10000; i++)
				Data.add(null);
			for (int i = 1; i < d.length; i++)
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
				} else
				{
					Team tTeam = Data.get(index);
					tTeam.addMatch(nMatch);
					Data.set(index, tTeam);
				}
			}
			fScan.close();
		} catch (Exception e) {}
		return Data;
	}
	private static ArrayList<String> decode(String in)
	{
		String[] decode = in.split("•");
		ArrayList<String> decoded = new ArrayList<String>();
		for (int i = 0; i < decode.length; i++)
		{
			decoded.add(decode[i]);
		}
		return decoded;
	}
	private static void outData()
	{
		PrintWriter writer;
		try
		{
			writer = new PrintWriter("data.txt");
			writer.println(rawData);
			for (int i = 0; i < Data.size(); i++)
			{
				if (Data.get(i) != null)
				{
					writer.println("Team: " + i);
					for (int j = 0; j < Data.get(i).MatchSize(); j++)
					{
						Match curr = Data.get(i).getMatch(j);
						writer.println("\tMatch: " + (j + 1));
						/*writer.println("\t\tAuto High Goals: " + curr.getAutoHighGoals());
						writer.println("\t\tAuto Low Goals: " + curr.getAutoLowGoals());
						if (curr.getAutoPort() != -1)
							writer.println("\t\tAuto Port: " + curr.getAutoPort());
						if (curr.getAutoCDF() != -1)
							writer.println("\t\tAuto CDF: " + curr.getAutoCDF());
						if (curr.getAutoRamp() != -1)
							writer.println("\t\tAuto Ramp: " + curr.getAutoRamp());
						if (curr.getAutoMoat() != -1)
							writer.println("\t\tAuto Moat: " + curr.getAutoMoat());
						if (curr.getAutoDraw() != -1)
							writer.println("\t\tAuto Draw: " + curr.getAutoDraw());
						if (curr.getAutoSally() != -1)
							writer.println("\t\tAuto Sally: " + curr.getAutoSally());
						if (curr.getAutoRock() != -1)
							writer.println("\t\tAuto Rock: " + curr.getAutoRock());
						if (curr.getAutoRough() != -1)
							writer.println("\t\tAuto Rough: " + curr.getAutoRough());
						if (curr.getAutoLowBar() != -1)
							writer.println("\t\tAuto Low Bar: " + curr.getAutoLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						if (curr.getPort() != -1)
							writer.println("\t\tPort: " + curr.getPort());
						if (curr.getCDF() != -1)
							writer.println("\t\tCDF: " + curr.getCDF());
						if (curr.getRamp() != -1)
							writer.println("\t\tRamp: " + curr.getRamp());
						if (curr.getMoat() != -1)
							writer.println("\t\tMoat: " + curr.getMoat());
						if (curr.getDraw() != -1)
							writer.println("\t\tDraw: " + curr.getDraw());
						if (curr.getSally() != -1)
							writer.println("\t\tSally: " + curr.getSally());
						if (curr.getRock() != -1)
							writer.println("\t\tRock: " + curr.getRock());
						if (curr.getRough() != -1)
							writer.println("\t\tRough: " + curr.getRough());
						if (curr.getLowBar() != -1)
							writer.println("\t\tLow Bar: " + curr.getLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						writer.println("\t\tScale: " + curr.getScaled());
						writer.println("\t\tSurround: " + curr.getSurround());
						writer.println("\t\tComment: " + curr.getComment());
						writer.println("\t\tScouter: " + curr.getScouter());
						double SP = ((curr.getHighGoals() + 0.4 * curr.getLowGoals()) / (curr.getHighGoals() + curr.getLowGoals() + curr.getMisses()));
						writer.println("\t\tShot %: " + SP * 100 + "%");*/
					}
					for (int j = 0; j < Data.get(i).PitSize(); j++)
					{
						Pit curr = Data.get(i).getPit(j);
						writer.println("\tPit: " + (j + 1));
						/*writer.println("\t\tAuto High Goals: " + curr.getAutoHighGoals());
						writer.println("\t\tAuto Low Goals: " + curr.getAutoLowGoals());
						writer.println("\t\tAuto Port: " + curr.getAutoPort());
						writer.println("\t\tAuto CDF: " + curr.getAutoCDF());
						writer.println("\t\tAuto Ramp: " + curr.getAutoRamp());
						writer.println("\t\tAuto Moat: " + curr.getAutoMoat());
						writer.println("\t\tAuto Draw: " + curr.getAutoDraw());
						writer.println("\t\tAuto Sally: " + curr.getAutoSally());
						writer.println("\t\tAuto Rock: " + curr.getAutoRock());
						writer.println("\t\tAuto Rough: " + curr.getAutoRough());
						writer.println("\t\tAuto Low Bar: " + curr.getAutoLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						writer.println("\t\tPort: " + curr.getPort());
						writer.println("\t\tCDF: " + curr.getCDF());
						writer.println("\t\tRamp: " + curr.getRamp());
						writer.println("\t\tMoat: " + curr.getMoat());
						writer.println("\t\tDraw: " + curr.getDraw());
						writer.println("\t\tSally: " + curr.getSally());
						writer.println("\t\tRock: " + curr.getRock());
						writer.println("\t\tRough: " + curr.getRough());
						writer.println("\t\tLow Bar: " + curr.getLowBar());
						writer.println("\t\tHigh Goals: " + curr.getHighGoals());
						writer.println("\t\tLow Goals: " + curr.getLowGoals());
						writer.println("\t\tScale: " + curr.getScaled());
						writer.println("\t\tSurround: " + curr.getSurround());
						writer.println("\t\tComment: " + curr.getComment());
						writer.println("\t\tScouter: " + curr.getScouter());*/
					}
				}
			}
			writer.close();
			System.out.println("Saved");
		} catch (FileNotFoundException e)
		{
			System.out.println("Error writting to file");
		}
	}
	public static void main(String[] args)
	{
		rawData = "";
		Scanner reader;

		ArrayList<String> decoded = new ArrayList<String>();
		String input;
		int index;

		Data = getData();
		System.out.println("Keywords: save, exit");
		System.out.println("Input: ");
		reader = new Scanner(System.in);
		boolean run = true;
		for (int i = 0; i < 10000; i++)
			Data.add(null);
		while (run)
		{
			try
			{
				input = reader.nextLine();
				if (input.equals("exit"))
				{
					run = false;
				} else if (input.equals("save"))
				{
					outData();
				} else
				{
					Match nMatch = new Match();
					Pit nPit = new Pit();
					decoded = decode(input);
					index = Integer.parseInt(decoded.get(0));
					if (decoded.get(1).equals("true") || decoded.get(1).equals("false")) // Tell apart if it is pit or match
					{
						nPit.setData(decoded);
						rawData += "○" + input;
						if (Data.size() == 0 || Data.get(index) == null)
						{
							Team nTeam = new Team();
							nTeam.addPit(nPit);
							Data.set(index, nTeam);
						} else
						{
							Team tTeam = Data.get(index);
							tTeam.addPit(nPit);
							Data.set(index, tTeam);
						}
						System.out.println("Added Pit Data");
					} else
					{
						nMatch.setData(decoded);
						rawData += "○" + input;
						if (Data.size() == 0 || Data.get(index) == null)
						{
							Team nTeam = new Team();
							nTeam.addMatch(nMatch);
							Data.set(index, nTeam);
						} else
						{
							Team tTeam = Data.get(index);
							tTeam.addMatch(nMatch);
							Data.set(index, tTeam);
						}
						System.out.println("Added Match Data");
					}
				}
			} catch (Exception e)
			{
				Random r = new Random();
				switch (r.nextInt(5))
				{
				case 0:
					System.out.println("Invalid Beep Boop ur fucking dumb.");
					break;
				case 1:
					System.out.println("ITS NOT A PHASE DADDY PLEASE HARDER.");
					break;
				case 2:
					System.out.println("FEELSFUCKINGHORRIBLEMAN WITH A FUCKING GUN.");
					break;
				case 3:
					System.out.println("Error.jpeg");
					break;
				case 4:
					System.out.println("Jimmy loves big fat black potatoes.");
				}
			}
			System.out.println("Input: ");
		}
		reader.close();
		System.out.println("Exiting");
		outData();
	}

}
