@echo off
echo ========================================
echo 资源文件测试脚本
echo ========================================

echo.
echo 1. 检查JAR文件是否存在...
if not exist "target\jar\PuzzleGame.jar" (
    echo JAR文件不存在，请先运行 build-simple.bat
    pause
    exit /b 1
)

echo.
echo 2. 检查JAR文件内容...
echo 列出JAR文件中的资源文件：
jar tf "target\jar\PuzzleGame.jar" | findstr "image"

echo.
echo 3. 检查特定资源文件...
echo 检查登录背景图片：
jar tf "target\jar\PuzzleGame.jar" | findstr "login/background.png"

echo.
echo 4. 运行资源测试程序...
echo 编译资源测试程序（使用Java 8兼容性）...
javac -source 1.8 -target 1.8 -cp "target\jar\PuzzleGame.jar" -d "target\test" "src\main\java\test\ResourceTest.java"

if %errorlevel% neq 0 (
    echo 编译测试程序失败
    pause
    exit /b 1
)

echo.
echo 运行资源测试...
java -cp "target\test;target\jar\PuzzleGame.jar" test.ResourceTest

echo.
echo ========================================
echo 测试完成
echo ========================================
pause 