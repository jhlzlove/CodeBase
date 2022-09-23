/**
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
console.log(process.pid);
*/
/* setTimeout(() => {
    // 程序启动花费的时间
    console.log(process.uptime());
}, 5000) */

/* process.on("exit", (code) => {
    console.log("exit " + code);
})

process.on("beforeExit", (code) => {
    console.log("beforeExit" + code);
})

console.log("代码执行完毕");
process.exit() */
