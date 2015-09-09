package folderviewer;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class TreeWalker extends SimpleFileVisitor<Path> {
	private static int level = 0;
	private final List<String> toIgnore;

	public TreeWalker(List<String> toIgnore) {
		this.toIgnore = toIgnore;
	}

	private static String getLevelled(String s) {
		String svaret = "";
		for (int i = 0; i < level; ++i) {
			svaret += "\t";
		}

		svaret += s;
		return svaret;
	}

	private static String nameOf(Path dir) {
		return dir.getFileName().toString();
	}
	
	private boolean isIgnored(Path dir) {
		String name = nameOf(dir).toLowerCase();
		if ()
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		String name = nameOf(dir);

		if (toIgnore.contains(name.toLowerCase())) {
			return FileVisitResult.SKIP_SUBTREE;
		} else {
			System.out.println(getLevelled(dir.getFileName().toString()) + "/");
			++level;

			return FileVisitResult.CONTINUE;
		}
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		System.out.println(getLevelled(file.getFileName().toString()));

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