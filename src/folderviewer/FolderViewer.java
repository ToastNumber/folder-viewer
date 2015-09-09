package folderviewer;

import java.io.IOException;
import java.util.Arrays;

public class FolderViewer {

	public static void main(String[] args) {
		String help = "Expected arguments: <root> (minimal|fancy) [<ignored>...]";

		try {
			PrintStyle style = PrintStyle.get(args[1]);
			DirectoryPrinter.printTree(args[0], Arrays.copyOfRange(args, 2, args.length), style);
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
