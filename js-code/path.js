import path from "path"
import { fileURLToPath } from "url";

// ES6 模块使用 __filename
const __filename = fileURLToPath(import.meta.url)

console.log("规范化路径：", path.normalize(__filename));
console.log("文件所在目录：", path.dirname(__filename) == process.cwd());
console.log("文件名：", path.basename(__filename));
console.log("扩展名：", path.extname(__filename));
console.log("是否是绝对路径：", path.isAbsolute(__filename));

// 拼接路径
const textPath = path.join("a/b", "c", "index.html")
console.log(textPath);
console.log(path.isAbsolute(textPath));

// 绝对路径，会自动拼接里面文件的 dirname
console.log(path.resolve("a", "b"));
console.log(path.resolve("a", "/b"));
console.log(path.resolve("/a", "b"));
console.log(path.resolve("/a", "/b"));
