
class PubSub {
    constructor() {
        this._events = {}
    }
    // 订阅
    subscribe(event, callback) {
        if (this._events[event]) {
            this._events[event].push(callback)
        } else {
            this._events[event] = [callback]
        }
    }

    // 发布
    publish(event, ...args) {
        const items = this._events[event]
        if (items && items.length) {
            items.forEach(function (callback) {
                callback.call(this, ...args)
            });
        }
    }

}
// 创建实例
let ps = new PubSub()
// 订阅事件
ps.subscribe("事件一", () => {
    console.log("事件一执行了");
})
// 发布消息
ps.publish("事件一")
