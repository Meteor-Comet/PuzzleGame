@echo off
echo ========================================
echo 资源文件检查脚本
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
echo 3. 列出JAR文件中的所有资源文件...
echo.
echo === 图片资源文件 ===
jar tf "target\jar\PuzzleGame.jar" | findstr "\.png"
jar tf "target\jar\PuzzleGame.jar" | findstr "\.jpg"
jar tf "target\jar\PuzzleGame.jar" | findstr "\.jpeg"

echo.
echo === 登录界面资源 ===
jar tf "target\jar\PuzzleGame.jar" | findstr "login"

echo.
echo === 注册界面资源 ===
jar tf "target\jar\PuzzleGame.jar" | findstr "register"

echo.
echo === 游戏主题资源 ===
jar tf "target\jar\PuzzleGame.jar" | findstr "animal"
jar tf "target\jar\PuzzleGame.jar" | findstr "girl"
jar tf "target\jar\PuzzleGame.jar" | findstr "sport"

echo.
echo 4. 检查关键资源文件...
echo.
echo 检查登录背景图片:
jar tf "target\jar\PuzzleGame.jar" | findstr "login/background.png"
if %errorlevel% equ 0 (
    echo ✓ 登录背景图片存在
) else (
    echo ✗ 登录背景图片缺失
)

echo.
echo 检查注册背景图片:
jar tf "target\jar\PuzzleGame.jar" | findstr "register/background.png"
if %errorlevel% equ 0 (
    echo ✓ 注册背景图片存在
) else (
    echo ✗ 注册背景图片缺失
)

echo.
echo 检查游戏背景图片:
jar tf "target\jar\PuzzleGame.jar" | findstr "background.png"
if %errorlevel% equ 0 (
    echo ✓ 游戏背景图片存在
) else (
    echo ✗ 游戏背景图片缺失
)

echo.
echo 检查胜利图片:
jar tf "target\jar\PuzzleGame.jar" | findstr "win.png"
if %errorlevel% equ 0 (
    echo ✓ 胜利图片存在
) else (
    echo ✗ 胜利图片缺失
)

echo.
echo ========================================
echo 检查完成
echo ========================================
echo.
echo 如果看到 ✗ 标记，说明对应的资源文件缺失
echo 请检查 src\main\resources\image\ 目录下的文件
echo.
pause 