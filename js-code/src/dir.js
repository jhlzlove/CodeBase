import fs from "fs";

fs.access("copy-file.js", (err) => {
    if (err) {
        console.log(err);
    } else {
        console.log("有操作权限");
    }
});

fs.stat("copy-file.js", (err, data) => {
    console.log(data.size);
    console.log(data.isFile());
    console.log(data.isDirectory());
})

// 递归创建目录：recursive 为 true
/* fs.mkdir("a/b", {recursive: true}, (err) => {
    if (!err) {
        console.log("创建成功");
    } else {
        console.log(err);
    }
}) */

// 递归删除目录（包括非空目录）：recursive 为 true
fs.rm("a", {recursive: true}, (err) => {
    if (!err) {
        console.log("删除成功");
    } else {
        console.log(err);
    }
})