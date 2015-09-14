#Folder Viewer
A command line interface which allows a directory's contents to be formatted and printed.

##Usage
1. Compile the source files into a `bin` folder.
2. Navigate into the `bin` folder.
3. Run your program using the command `java folderviewer/FolderViewer <root> (minimal|fancy) (true|false) [<ignored>...]`
	- `<root>` indicates the path of the directory to be printed.
	- `(minimal|fancy)` indicates the style of the output.
	- `(true|false)` indicates whether or not the output should be copied to the clipboard.
	- `[<ignored>...]` is an optional list of space-separated arguments, indicating files and/or directories to be ignored.

##Example
Using `java folderviewer/FolderViewer ../ minimal .git .classpath .settings .project`, will output the contents of this repository:
```
folder-viewer/
    .gitignore
    README.md
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
+---README.md
+---src/
    ¦---folderviewer/
        ¦---DirectoryPrinter.java
        ¦---FolderViewer.java
        ¦---PrintStyle.java
        ¦---TreeWalker.java
```

##Tip
The windows command line and BASH have a 'Mark' feature, which allows you to copy the output to the clipboard. To do this, right-click on the top of the command-line window, then `Edit -> Mark`. Now highlight the text you wish to copy using your mouse, then press the `ENTER` key to copy the text to the clipboard.