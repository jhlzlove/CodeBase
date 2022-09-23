function MyEvent() {
    this._events = Object.create(null)
}

MyEvent.prototype.on = function (type, callback) {
    // 判断当前次的事件是否已经存在，然后决定是否做缓存
    if (this._events[type]) {
        this._events[type].push(callback)
    } else {
        this._events[type] = [callback]
    }
}

MyEvent.prototype.emit = function (type, ...args) {
    if (this._events && this._events[type].length) {
        this._events[type].forEach(callback => {
            callback.call(this, ...args)
        });
    }
}

MyEvent.prototype.off = function (type, callback) {
    // 判断当前 type 事件是否存在，如果存在则取消指定的监听
    if (this._events && this._events[type]) {
        this._events[type] = this._events[type].filter((item) => {
            return item !== callback
        })
    }
}

MyEvent.prototype.once = function (type, callback) {
    let foo = function (...args) {
        callback.call(this, ...args)
        this.off(type, foo)
    }
    this.on(type, foo)
}

let ev = new MyEvent()
let fn = function (...data) {
    console.log("事件1执行了", data);
}

/* ev.on("事件1", fn)
ev.emit("事件1", "诗酒趁年华")
ev.off("事件1", fn)
ev.emit("事件1", "烟雨暗千家") */
/* ev.on("事件1", fn)
ev.on("事件1", () => {
    console.log("事件1-----2");
})

ev.emit("事件1", 1, 2)
ev.emit("事件1", 1, 2) */

ev.once("事件1", fn)
ev.emit("事件1", "诗酒趁年华")
ev.emit("事件1", "烟雨暗千家")
