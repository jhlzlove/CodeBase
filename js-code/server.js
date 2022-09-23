import http from "http"

const hostname = '127.0.0.1';
const port = 3000;

const server = http.createServer((req, res) => {
    // 设置响应
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('Hello World');
});

// 监听服务地址和端口
server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});