package folderviewer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryPrinter {
	public static void printTree(String path, String[] toIgnoreArr, PrintStyle style, boolean toClipboard)
			throws IOException {
		Path dir = Paths.get(path);

		List<String> toIgnore = new ArrayList<String>();
		for (int i = 0; i < toIgnoreArr.length; ++i) {
			toIgnore.add(toIgnoreArr[i]);
		}

		TreeWalker walker = new TreeWalker(toIgnore, style);
		Files.walkFileTree(dir, walker);

		if (toClipboard) {
			StringSelection stringSelection = new StringSelection(walker.getOutput());
			Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
			clpbrd.setContents(stringSelection, null);
		}
	}
}
