@echo off
setlocal
set "JAVA_HOME=C:\Program Files\Microsoft\jdk-25.0.3.9-hotspot"
set "JAVAC=%JAVA_HOME%\bin\javac.exe"
set "JARBIN=%JAVA_HOME%\bin\jar.exe"
set "LIB=..\..\..\libraries"
set "CP=%LIB%\io\papermc\paper\paper-api\26.2.build.129-stable\paper-api-26.2.build.129-stable.jar;%LIB%\net\kyori\adventure-api\5.2.0\adventure-api-5.2.0.jar;%LIB%\net\kyori\adventure-key\5.2.0\adventure-key-5.2.0.jar;%LIB%\net\kyori\adventure-text-serializer-plain\5.2.0\adventure-text-serializer-plain-5.2.0.jar;%LIB%\org\jetbrains\annotations\13.0\annotations-13.0.jar;%LIB%\com\google\guava\guava\33.6.0-jre\guava-33.6.0-jre.jar;%LIB%\net\md-5\bungeecord-chat\1.21-R0.2-deprecated+build.21\bungeecord-chat-1.21-R0.2-deprecated+build.21.jar"
if exist build rmdir /s /q build
mkdir build\classes
dir /s /b src\main\java\*.java > build\sources.txt
"%JAVAC%" -encoding UTF-8 -release 25 -cp "%CP%" -d build\classes @build\sources.txt
if errorlevel 1 (
  echo kompilo malsukcesis
  exit /b 1
)
xcopy /y /q src\main\resources\plugin.yml build\classes\
xcopy /y /q src\main\resources\config.yml build\classes\
"%JARBIN%" --create --file build\Nala.jar -C build\classes .
echo Nala preta en build\Nala.jar
