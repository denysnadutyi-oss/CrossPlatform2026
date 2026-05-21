@echo off
chcp 65001 > nul
echo Starting ComputeEuler Client...
java -Dfile.encoding=UTF-8 -cp ./compute.jar;. -Djava.security.policy=program.policy client.ComputeEuler localhost 50
pause