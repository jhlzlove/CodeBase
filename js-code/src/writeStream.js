/* 可写流 */
const Writable = require("stream")

class MyWritable extends Writable {
    constructor() {
        super()
    }
    _write(chunk, en, done) {
        process.stdout.write(chunk.toString() + '---->')
        // 异步回调
        process.nextTick(done)
    }
}

const myWrite = new MyWritable() 

myWrite._write("诗酒趁年华", 'utf8', () => {
    console.log('end');
})