@ECHO off

:main
	ECHO ---Folder-Viewer---
	ECHO.
	IF NOT EXIST bin/folderviewer/FolderViewer.class GOTO fail
	
	SET dr=""
	SET toignore=""
	
	SET /p dr="Enter directory: "
	SET /p toignore="Enter files to ignore: "

	java -cp bin folderviewer.FolderViewer %dr% fancy true %toignore%

	SET /p dummy="Press ENTER to continue ..."
	CLS
	GOTO main
	
:fail
	ECHO Error: Could not find or load main class folderviewer.FolderViewer
	ECHO Hint: Try compiling the source files using `compile.bat`
	ECHO.
	PAUSE
	EXIT