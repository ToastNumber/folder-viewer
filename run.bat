@ECHO off

@IF NOT EXIST "bin" GOTO create

:main
	ECHO Folder Viewer
	ECHO.
	SET dr=""
	SET ignore=""
	
	SET /p dr="Enter directory: "
	SET/p ignore="To ignore: "

	java -cp bin folderviewer.FolderViewer %dr% fancy true %ignore%

	PAUSE
	CLS
	GOTO main



:create
	MKDIR "bin"
	javac -d bin src/folderviewer/*.java
	GOTO main