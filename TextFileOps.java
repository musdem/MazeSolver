import java.io.*;

class TextFileOps
{
	public static String Read(String fileName)
	{
		String line = null;
		String output = "";
		try
		{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null)
			{
				output = output + line + "\n";
			}
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException ex)
		{
			System.out.println("Error reading file '" + fileName + "'");
		}
		return output;
	}
	public static void Write(String fileInput, String fileName)
	{
		try
		{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(fileInput);
			bufferedWriter.close();
		}
		catch(IOException ex)
		{
			System.out.println("Error writing to file '" + fileName + "'");
		}
	}
}
