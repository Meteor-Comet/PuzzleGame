@echo off
echo ========================================
echo 拼图游戏简化打包脚本
echo ========================================

echo.
echo 1. 清理之前的编译文件...
if exist "target\classes" rmdir /s /q "target\classes"
if exist "target\jar" rmdir /s /q "target\jar"

echo.
echo 2. 创建目录结构...
mkdir "target\classes"
mkdir "target\jar"

echo.
echo 3. 编译Java文件（目标版本：Java 8）...
javac -source 1.8 -target 1.8 -d "target\classes" -cp "src\main\java" src\main\java\APP.java src\main\java\com\puzzle\ui\*.java src\main\java\test\*.java

if %errorlevel% neq 0 (
    echo 编译失败！
    pause
    exit /b 1
)

echo.
echo 4. 复制资源文件...
xcopy "src\main\resources" "target\classes\resources" /E /I /Y

echo.
echo 5. 创建JAR文件...
jar cfm "target\jar\PuzzleGame.jar" "manifest.txt" -C "target\classes" .

if %errorlevel% neq 0 (
    echo JAR文件创建失败！
    pause
    exit /b 1
)

echo.
echo ========================================
echo 打包完成！
echo ========================================
echo.
echo 生成的文件：
echo - JAR文件: target\jar\PuzzleGame.jar
echo.
echo 运行方法：
echo - 双击JAR文件
echo - 或使用命令: java -jar target\jar\PuzzleGame.jar
echo.
pause 