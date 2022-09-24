/*
// 内存使用情况
console.log(process.memoryUsage());
// Node 版本
console.log(process.version);
// Node 模块版本
console.log(process.versions);
// 文件所在路径
console.log(process.cwd());
// cpu 使用情况
console.log(process.cpuUsage());

// console.log(process.env.PATH);
// home
console.log(process.env.USERPROFILE);
// 返回参数的值，默认返回
console.log(process.argv);
console.log(process.argv0);
console.log(process.pid);*/
// process.argv 返回一个数组，第一个参数为执行命令的目录
// 第二个参数为执行文件的目录
// 如果后面还有参数的话，也会一并输出
/**
 * 例如：node process.js arg1 arg2 hahah
 * 返回结果如下：
 * [
 *   'D:\\xxxx\\nodejs\\node.exe',
 *   'D:\\xxx\\js-code\\process.js',
 *   'arg1',
 *   'arg2',
 *   'hahah'
 * ]
 */
console.log(process.argv)
console.log(process.pid)

// 打印后面的参数
if (process.argv[2]) {
    console.log(process.argv[2])
}