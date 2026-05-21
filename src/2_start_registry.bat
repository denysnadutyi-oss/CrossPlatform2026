@echo off
chcp 65001 > nul
echo Зупиняємо старий RMI реєстр (якщо він завис у пам'яті)...
taskkill /F /IM rmiregistry.exe >nul 2>&1

echo Запускаємо новий RMI реєстр...
start "rmiregistry" rmiregistry 1099 -J-Djava.rmi.server.useCodebaseOnly=false
echo Реєстр запущено у фоновому вікні!
pause