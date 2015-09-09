package folderviewer;

import java.io.IOException;



public class FolderViewer {
	
	public static void main(String[] args) throws IOException {
		String cDir = System.getProperty("user.dir");
		DirectoryPrinter.printDirectory(cDir);
	}
}
