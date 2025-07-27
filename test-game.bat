@echo off
echo ========================================
echo 游戏运行测试脚本
echo ========================================

echo.
echo 1. 检查JAR文件是否存在...
if not exist "target\jar\PuzzleGame.jar" (
    echo JAR文件不存在，请先运行 build-simple.bat
    pause
    exit /b 1
)

echo.
echo 2. 检查JAR文件大小...
for %%A in ("target\jar\PuzzleGame.jar") do echo JAR文件大小: %%~zA 字节

echo.
echo 3. 运行游戏测试...
echo 启动拼图游戏...
echo 请观察以下内容：
echo - 登录界面是否显示背景图片
echo - 用户名、密码、验证码标签是否显示
echo - 登录和注册按钮是否显示
echo - 点击注册后，注册界面是否正常显示
echo - 登录后，游戏界面是否显示拼图图片
echo.
echo 如果看到空白界面或缺少图片，说明资源加载有问题
echo.

java -jar "target\jar\PuzzleGame.jar"

echo.
echo ========================================
echo 游戏测试完成
echo ========================================
echo.
echo 如果游戏正常运行并显示所有图片，说明资源加载正常
echo 如果出现问题，请运行 check-resources.bat 检查资源文件
echo.
pause 