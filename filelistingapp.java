import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class filelistingapp {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the file name in this project: ");
		String url = "C:\\Users\\WELCOME\\eclipse-workspace\\projext1\\";
		url += in.next();

		BufferedReader br = new BufferedReader(new FileReader(url));
		try {
			String line = "";
			System.out.print("\n-----Reading File Contents-----\n");
			while ((line = br.readLine()) != null) {
				System.out.println("\n" + line);
				if (line.endsWith(".csv")) {
					System.out.println("**CSV Identified, Reading file**");
					readFile(line);
				} else if (line.endsWith("\\")) {
					System.out.println("**URL Identified, Fetching files and folders**");
					getList(line);
				} else {
					System.out.println("**Invalid Path**");
				}
			}
			br.close();
		} catch (Exception ex) {
			System.out.println(ex + " Exception Caught");
		} finally {
			br.close();
		}
		in.close();
	}

	public static void getList(String dir) {
		File list[] = new File(dir).listFiles();
		for (File file : list)
			System.out.println(file);
	}

	public static void readFile(String dir) {
		try {
			BufferedReader b = new BufferedReader(new FileReader(dir));
			String line = null;
			while ((line = b.readLine()) != null) {
				System.out.println(line);
			}
			b.close();
		} catch (Exception ex) {
			System.out.println(ex + " Exception Caught");
		}
	}

}
