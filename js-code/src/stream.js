/* Stream */
const fs = require("fs")
const {Readable} = require("stream")

// 模拟底层数据
let source = ['lg', 'zce', 'syy']

class MyReadable extends Readable {
    constructor() {
        super()
        this.source = source
    }
    _read() {
        let data = this.source.shift() || null
        this.push(data)
    }
}

let myReadable = new MyReadable()

/* myReadable.on('readable', () => {
    let data = null
    while ((data = myReadable.read(3)) != null) {
        console.log(data.toString());
    }
}) */

myReadable.on('data', (chunk) => {
    console.log(chunk.toString());
})

/* let rs = fs.createReadStream("../test.txt")
let ws = fs.createWriteStream("./test.txt")

rs.pipe(ws)
rs.pipe(process.stdout) */