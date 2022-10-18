use futures::executor::block_on;

// #![allow(unused)]
fn main() {
    let future = song();
    block_on(future);
}

async fn song() {
    println!("{}", "我走过浮桥三百梦");
}

async fn dance() {
    println!("{}", "she is a good dancer")
}

async fn learn_and_sing() {
    let song = dance().await;
}