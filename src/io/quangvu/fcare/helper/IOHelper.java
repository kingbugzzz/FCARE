package io.quangvu.fcare.helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

public class IOHelper {

	private IOHelper() {
	}
	
	public static String read(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			String content = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				content += line;
			}
			br.close();
			return content;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static ArrayList<String> readLines(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(path)));
			ArrayList<String> lines = new ArrayList<String>();
			String line = null;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			return lines;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String readFirstLines(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		int count = 0;
		while ((line = br.readLine()) != null) {
			if (count >= 1) {
				break;
			} else {
				lines.add(line);
				count++;
			}
		}
		br.close();
		return lines.get(0);
	}

	public static void deleteFirstLine(String path) {
		ArrayList<String> source = readLines(path);
		source.remove(0);
		writeLines(source, path);
	}

	public static void writeToFile(String content, String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void writeLines(ArrayList<String> lines, String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
			for (int i = 0; i < lines.size(); i++) {
				writer.write(lines.get(i));
				if (i < lines.size() - 1) {
					writer.newLine();
				}
			}
			writer.flush();
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static ArrayList<String> ls(String path) {
		try {
			File f = new File(path);
			if (f.isDirectory()) {
				ArrayList<String> names = new ArrayList<String>();
				File[] files = f.listFiles();
				for (int i = 0; i < files.length; i++) {
					names.add(files[i].getName());
				}
				return names;
			} else {
				System.out.println("[" + path + "] is not a directory.");
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static ArrayList<String> ls(String path, String option) {
		return null;
	}

	public static void createSimpleTextFile(String path, String content) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void delete(String path) {
		try {
			File f = new File(path);
			f.delete();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getRandomImagePath(String folder) {
		try {
			String imgPath = null;
			File file = new File(folder);
			if(file.isDirectory()) {
				File[] imgPaths = file.listFiles();
				Random random = new Random();
				int randomNumber = random.nextInt((imgPaths.length-1) - 0) + 0;
				imgPath = imgPaths[randomNumber].getAbsolutePath();
			}
			return imgPath.replace("\\", "/");
		}catch(Exception ex) {
			return null;
		}
	}
}
