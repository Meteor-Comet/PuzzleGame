@echo off
echo ========================================
echo 手动编译脚本
echo ========================================

echo.
echo 步骤1：检查Java版本
java -version
if %errorlevel% neq 0 (
    echo 错误：Java运行时不可用
    pause
    exit /b 1
)

echo.
echo 步骤2：清理旧文件
if exist "target\classes" rmdir /s /q "target\classes"
if exist "target\jar" rmdir /s /q "target\jar"
mkdir "target\classes"
mkdir "target\jar"

echo.
echo 步骤3：编译主程序
echo 编译 APP.java...
javac -source 1.8 -target 1.8 -d "target\classes" -cp "src\main\java" src\main\java\APP.java
if %errorlevel% neq 0 (
    echo 编译APP.java失败
    pause
    exit /b 1
)

echo.
echo 步骤4：编译UI类
echo 编译 UI类...
javac -source 1.8 -target 1.8 -d "target\classes" -cp "src\main\java;target\classes" src\main\java\com\puzzle\ui\*.java
if %errorlevel% neq 0 (
    echo 编译UI类失败
    pause
    exit /b 1
)

echo.
echo 步骤5：编译测试类
echo 编译 测试类...
javac -source 1.8 -target 1.8 -d "target\classes" -cp "src\main\java;target\classes" src\main\java\test\*.java
if %errorlevel% neq 0 (
    echo 编译测试类失败
    pause
    exit /b 1
)

echo.
echo 步骤6：复制资源文件
echo 复制资源文件...
xcopy "src\main\resources" "target\classes\resources" /E /I /Y

echo.
echo 步骤7：创建JAR文件
echo 创建JAR文件...
jar cfm "target\jar\PuzzleGame.jar" "manifest.txt" -C "target\classes" .
if %errorlevel% neq 0 (
    echo 创建JAR文件失败
    pause
    exit /b 1
)

echo.
echo ========================================
echo 编译完成！
echo ========================================
echo.
echo 测试运行：
echo java -jar target\jar\PuzzleGame.jar
echo.
echo 或者双击运行：
echo target\jar\PuzzleGame.jar
echo.
pause 