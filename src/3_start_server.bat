@echo off
chcp 65001 > nul
echo Starting ComputeEngine Server...
java -Dfile.encoding=UTF-8 -cp ./compute.jar;. -Djava.rmi.server.codebase="file:./" -Djava.rmi.server.hostname=localhost -Djava.security.policy=program.policy engine.ComputeEngine
pause