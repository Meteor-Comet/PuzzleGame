@echo off
echo ========================================
echo 拼图游戏打包脚本
echo ========================================

echo.
echo 1. 清理之前的编译文件...
if exist "target\classes" rmdir /s /q "target\classes"
if exist "target\jar" rmdir /s /q "target\jar"
if exist "target\exe" rmdir /s /q "target\exe"

echo.
echo 2. 创建目录结构...
mkdir "target\classes"
mkdir "target\jar"
mkdir "target\exe"

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
echo 6. 检查Launch4j是否存在...
if not exist "launch4j\launch4j.exe" (
    echo Launch4j未找到，请下载并解压到launch4j目录
    echo 下载地址: https://launch4j.sourceforge.net/
    pause
    exit /b 1
)

echo.
echo 7. 使用Launch4j创建EXE文件...
"launch4j\launch4j.exe" "launch4j-config.xml"

if %errorlevel% neq 0 (
    echo EXE文件创建失败！
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
echo - EXE文件: target\exe\PuzzleGame.exe
echo.
echo 您可以直接运行 target\exe\PuzzleGame.exe
echo.
pause 