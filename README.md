#Folder Viewer
A command line interface which allows a directory's contents to be formatted and printed.

##Usage
Run your program using the command `java folderviewer/FolderViewer <root> (minimal|fancy) (true|false) [<ignored>...]`
	- `<root>` indicates the path of the directory to be printed.
	- `(minimal|fancy)` indicates the style of the output.
	- `(true|false)` indicates whether or not the output should be copied to the clipboard.
	- `[<ignored>...]` is an optional list of space-separated arguments, indicating files and/or directories to be ignored.

##Automated Usage
- `compile.bat` automatically compiles the source files into a bin folder.
- `run.bat` automatically runs the program, and asks for the directory and the files to ignore. The style is set to `fancy` and the output is copied to the clipboard.

##Example
Using `java folderviewer/FolderViewer ../ minimal .git .classpath .settings .project`, will output the contents of this repository:
```
folder-viewer/
	.gitignore
	compile.bat
	README.md
	run.bat
	src/
		folderviewer/
			DirectoryPrinter.java
			FolderViewer.java
			PrintStyle.java
			TreeWalker.java

```

And using `java folderviewer/FolderViewer ../ fancy .git .classpath .settings .project`, will output it like this:
```
folder-viewer/
+---.gitignore
+---compile.bat
+---README.md
+---run.bat
+---src/
    ¦---folderviewer/
        ¦---DirectoryPrinter.java
        ¦---FolderViewer.java
        ¦---PrintStyle.java
        ¦---TreeWalker.java
```