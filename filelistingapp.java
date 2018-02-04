import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class filelistingapp {
	public static ArrayList<String> files = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the file name in this project: ");
		String url = "C:\\Users\\WELCOME\\eclipse-workspace\\projext1\\";
		url += in.next();

		BufferedReader br = new BufferedReader(new FileReader(url));
		String line;

		try {

			line = br.readLine();
			System.out.print("\nReading file names and folder contenets\n");
			System.out.println(line);
			getList(line);

			// System.out.println(arrayData);

			line = br.readLine();
			System.out.print("\nWriting the contents to the CSV\n");
			System.out.println(line);
			writeCSV(line);

			System.out.print("\nWriting Complete\n");

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
			if (file.isFile()) {
				files.add(file + "");
			} else {
				getList(file.getAbsolutePath());
			}
	}

	public static void writeCSV(String dir) throws Exception {
		Iterator<String> itr = files.iterator();
		FileWriter csv = new FileWriter(dir);
		BufferedWriter bw = new BufferedWriter(csv);

		while (itr.hasNext()) {
			try {
				bw.write(itr.next());
				bw.newLine();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		csv.close();
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
