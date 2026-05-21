@echo off
chcp 65001 > nul
echo Compiling interfaces...
javac -encoding UTF-8 compute/*.java

echo Creating compute.jar...
jar cvf compute.jar compute/*.class

echo Compiling Server and Client...
javac -encoding UTF-8 -cp ./compute.jar engine/*.java
javac -encoding UTF-8 -cp ./compute.jar client/*.java

echo Build complete!
pause