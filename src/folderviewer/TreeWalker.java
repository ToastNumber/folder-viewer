package folderviewer;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class TreeWalker extends SimpleFileVisitor<Path> {
	private int level = 0;
	private final List<String> toIgnore;
	private PrintStyle style;

	public TreeWalker(List<String> toIgnore, PrintStyle style) {
		this.toIgnore = toIgnore;
		this.style = style;
	}
	
	private static String getTab() {
		return "    "; //4 spaces
	}

	private String getLevelled(String s) {
		String svaret = "";

		if (style == PrintStyle.Minimal) {
			for (int i = 0; i < level; ++i) {
				svaret += getTab();
			}
		} else if (style == PrintStyle.Fancy) {
			for (int i = 0; i < level - 1; ++i) {
				svaret += getTab();
			}
			
			if (level == 1) svaret += "+---";
			else if (level >= 2) svaret += "¦---";
		} 

		svaret += s;
		return svaret;
	}

	private static String nameOf(Path dir) {
		return dir.getFileName().toString();
	}

	private boolean isIgnored(Path dir) {
		String name = nameOf(dir).toLowerCase();

		return toIgnore.contains(name);
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		if (isIgnored(dir)) {
			return FileVisitResult.SKIP_SUBTREE;
		} else {
			System.out.println(getLevelled(nameOf(dir)) + "/");
			++level;

			return FileVisitResult.CONTINUE;
		}
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		if (!isIgnored(file)) {
			System.out.println(getLevelled(nameOf(file)));
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		System.err.println(exc);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path file, IOException exc) {
		--level;
		return FileVisitResult.CONTINUE;
	}
}