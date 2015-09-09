package folderviewer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DirectoryPrinter {
	public static void printDirectory(String path) throws IOException {
		Path dir = Paths.get(path);
		List<String> toIgnore = new ArrayList<String>();
		toIgnore.add(".git");
		toIgnore.add(".classpath");
		
		TreeWalker walker = new TreeWalker(toIgnore, PrintStyle.Fancy);
		
		Files.walkFileTree(dir, walker);
	}
}
