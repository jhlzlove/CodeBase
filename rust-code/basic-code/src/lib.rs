
/* 开启 Debug 模式，打印结构体 */
#[derive(Debug)]
pub struct User {
    pub username: String,
    pub age: i32,
    pub address: String,
    pub birthday: String
}

impl User {
    pub fn new(username: String, age: i32, address: String, birthday: String) -> User {
        User { username, age, address, birthday }
    }
}