use basic::User;
use log::{debug, error, info, log_enabled, Level};
use env_logger::Env;
fn main() {
    // 注意，env_logger 必须尽可能早的初始化 默认只有 error 级别的输出
    //  env_logger::init();

    // 使用 debug 以上的日志输出
    // env_logger 可以从环境变量中读取配置。如果这些变量不存在，则可以使用 Env 类型调整要使用的默认值
    env_logger::Builder::from_env(Env::default().default_filter_or("debug")).init();

    debug!("this is a debug {}", "message");
    error!("this is printed by default");

    if log_enabled!(Level::Info) {
        let x = 3 * 4; // expensive computation
        info!("the answer was: {}", x);
    }
}

fn fun_name() {
    let user = User::new(String::from("jhlz"), 18);
    println!("{:#?}", user);
    // 可以访问 name
    println!("{}", user.name);
    // 简单介绍一下自己吧！
    user.introduce_me();
}
