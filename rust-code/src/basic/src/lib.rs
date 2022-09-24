/**
 * 定义一个简单结构体。只有 pub 才能被外面使用
 * #[derive(Debug)] 表示实现了 Debug 这个 trait，可以使用 {：#？} 格式化打印 
 */ 
#[derive(Debug)]
pub struct User {
    // 如果属性不使用 pub 标识，那么就无法使用 user.name 访问
    // name 可以被访问
    // age 不可以
    pub name: String,
    age: i32,
}

/** 方法 */
impl User {
    /** 第一个参数不为 self 的为内联函数，一般用来初始化对象 */
    pub fn new(name: String, age: i32) -> User {
        User {
            name,
            age,
        }
    }

    pub fn introduce_me(self) {
        println!("在下名叫：{}，年方：{}，请多多执教了哦~", self.name, self.age);
    }
}
