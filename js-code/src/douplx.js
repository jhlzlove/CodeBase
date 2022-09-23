const fs = require("fs")

// 创建文件读取流
const rs = fs.createReadStream("./test.txt", {
    flags: 'r',
    encoding: "utf8",
    fd: null,
    // 10进制
    mode: 438,
    // 自动关闭
    autoClose: true,
    start: 0,
    // end: 3,
    // 每次读取多少字节数据
    highWaterMark: 2
})

/* rs.on('data', (chunk) => {
    console.log(chunk.toString());
    rs.pause()
    setTimeout(() => {
        rs.resume()
    }, 1000)
}) */

// rs.on('readable', () => {
//     /* let data = rs.read()
//     console.log(data); */
//     let data
//     while ((data = rs.read(1)) !== null) {
//         console.log(data.toString());
//         // 打印获取的长度
//         console.log('-----------', rs._readableState.length);
//     }
// })

rs.on('open', (fd) => {
    console.log(fd, '文件打开了');
})

rs.on('close', () => {
    console.log('文件关闭了');
})

rs.on('data', (chunk) => {
    console.log(chunk);
})

rs.on('end', () => {
    console.log('数据已经被消费完成');
})
rs.on('error', (err) => {
    console.log('出错了');
})