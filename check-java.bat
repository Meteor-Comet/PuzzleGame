@echo off
echo ========================================
echo Java版本检查工具
echo ========================================

echo.
echo 检查Java版本...

java -version 2>&1
if %errorlevel% neq 0 (
    echo.
    echo 错误：未找到Java运行时环境！
    echo 请安装Java 8或更高版本。
    echo 下载地址：https://adoptium.net/
    pause
    exit /b 1
)

echo.
echo 检查Java编译器版本...

javac -version 2>&1
if %errorlevel% neq 0 (
    echo.
    echo 错误：未找到Java编译器！
    echo 请安装Java开发工具包(JDK)。
    echo 下载地址：https://adoptium.net/
    pause
    exit /b 1
)

echo.
echo ========================================
echo 版本兼容性说明
echo ========================================
echo.
echo 如果出现版本不兼容错误，可能的原因：
echo 1. 编译器版本过高（如Java 20）
echo 2. 运行时版本过低（如Java 8）
echo.
echo 解决方案：
echo 1. 使用 -source 1.8 -target 1.8 参数编译
echo 2. 升级Java运行时到Java 8+
echo 3. 或使用兼容的编译器版本
echo.
echo 当前打包脚本已使用兼容性编译参数。
echo.
pause 