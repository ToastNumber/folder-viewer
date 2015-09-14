package folderviewer;

import java.io.IOException;
import java.util.Arrays;

public class FolderViewer {

	public static boolean stringToBool(String s) {
		if (s.toLowerCase().equals("true")) return true;
		else if (s.toLowerCase().equals("false")) return false;
		else throw new IllegalArgumentException("Error: Expected (true|false).");
	}

	public static void main(String[] args) {
		String help = "Expected arguments: <root> (minimal|fancy) (true|false) [<ignored>...]";

		try {
			PrintStyle style = PrintStyle.get(args[1]);
			boolean toClipboard = stringToBool(args[2]);
			DirectoryPrinter.printTree(args[0], Arrays.copyOfRange(args, 3, args.length), style, toClipboard);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.err.println(help);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Wrong number of arguments.");
			System.err.println(help);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			System.err.println(help);
		}
	}
}
