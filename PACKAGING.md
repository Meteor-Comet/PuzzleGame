# 拼图游戏打包说明

本文档说明如何将拼图游戏打包成可执行文件。

## 方法一：生成JAR文件（推荐）

### 步骤1：检查Java版本
```bash
# 运行版本检查脚本
check-java.bat
```

### 步骤2：运行简化打包脚本
```bash
# 在项目根目录下运行
build-simple.bat
```

### 如果遇到版本兼容性问题，使用手动编译：
```bash
# 使用手动编译脚本
manual-build.bat
```

### 测试资源加载：
```bash
# 检查JAR包中的资源文件
check-resources.bat

# 直接运行游戏测试
test-game.bat
```

### 步骤2：运行JAR文件
```bash
# 方法1：双击JAR文件
target\jar\PuzzleGame.jar

# 方法2：命令行运行
java -jar target\jar\PuzzleGame.jar
```

### 优点
- 简单快速
- 不需要额外工具
- 跨平台兼容
- 文件大小小

### 缺点
- 需要用户安装Java运行环境
- 不是真正的exe文件

## 方法二：生成EXE文件（高级）

### 步骤1：下载Launch4j
1. 访问 https://launch4j.sourceforge.net/
2. 下载最新版本的Launch4j
3. 解压到项目根目录下的 `launch4j` 文件夹

### 步骤2：运行完整打包脚本
```bash
# 在项目根目录下运行
build.bat
```

### 步骤3：运行EXE文件
```bash
# 直接双击运行
target\exe\PuzzleGame.exe
```

### 优点
- 真正的exe文件
- 用户不需要安装Java
- 更专业的发布方式

### 缺点
- 需要额外工具
- 文件大小较大
- 只支持Windows

## 文件结构说明

### 打包前
```
PuzzleGame/
├── src/main/java/          # Java源代码
├── src/main/resources/     # 资源文件
├── build.bat              # 完整打包脚本
├── build-simple.bat       # 简化打包脚本
├── manifest.txt           # JAR清单文件
├── launch4j-config.xml    # Launch4j配置文件
└── README.md              # 项目说明
```

### 打包后
```
PuzzleGame/
├── target/
│   ├── classes/           # 编译后的类文件
│   ├── jar/
│   │   └── PuzzleGame.jar # 生成的JAR文件
│   └── exe/
│       └── PuzzleGame.exe # 生成的EXE文件（如果使用Launch4j）
└── ...
```

## 技术细节

### 资源加载
- 使用 `ResourceLoader` 类统一管理资源文件路径
- 支持从JAR包和文件系统加载资源
- 自动处理路径分隔符问题

### 依赖管理
- 所有依赖都包含在JAR文件中
- 不需要外部依赖库
- 使用Java标准库

### 兼容性
- 最低Java版本：1.8
- 支持Windows、macOS、Linux
- 32位和64位系统都支持
- 编译目标版本：Java 8（确保最大兼容性）

## 常见问题

### Q: 打包后图片无法显示
A: 确保资源文件正确复制到 `target/classes/resources` 目录

### Q: JAR文件无法运行
A: 检查Java版本是否满足要求（Java 8+）

### Q: 出现UnsupportedClassVersionError错误
A: 这是版本兼容性问题，解决方案：
1. 使用 `manual-build.bat` 手动编译
2. 确保使用 `-source 1.8 -target 1.8` 参数
3. 升级Java运行时到Java 8+

### Q: JAR包运行后没有图片资源
A: 这是资源加载问题，解决方案：
1. 运行 `test-resources.bat` 检查资源文件
2. 确保资源文件正确复制到JAR包中
3. 使用 `ResourceLoader.createImageIcon()` 方法加载图片
4. 检查资源文件路径是否正确

### Q: EXE文件创建失败
A: 确保Launch4j正确安装并配置

### Q: 文件太大
A: 可以压缩图片资源或使用更高效的图片格式

## 发布建议

### 开发阶段
- 使用JAR文件进行测试
- 便于调试和修改

### 正式发布
- 使用EXE文件发布给Windows用户
- 提供JAR文件作为备选方案
- 包含详细的安装说明

## 自动化脚本

项目提供了多个自动化脚本：

1. **check-java.bat**: 检查Java版本
2. **build-simple.bat**: 生成JAR文件（推荐）
3. **manual-build.bat**: 手动编译（解决版本问题）
4. **build.bat**: 生成EXE文件（需要Launch4j）
5. **check-resources.bat**: 检查JAR包资源文件
6. **test-game.bat**: 直接运行游戏测试

运行脚本后会自动完成：
- 编译Java代码
- 复制资源文件
- 创建JAR文件
- 生成EXE文件（如果使用完整脚本）

## 联系方式

如有打包相关问题，请联系开发者。 