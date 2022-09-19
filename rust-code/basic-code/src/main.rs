use std::{collections::HashMap, env};
use basic_code::User;

fn main() {

    // 获取命令行参数
    // let args: Vec<String> = env::args().collect();
    // println!("{:?}", args);

    let u = User::new(String::from("风中捉刀"), 
        18, String::from("道域"), String::from("2008-10-1"));

    println!("{:?}", u);

    println!("{}", calculate_length(&String::from("江湖浪子楚凛風")));
}

fn hashmap_about() {
    // 用的较少，标准库对其支持较少
    // K 同构
    let mut map = HashMap::new();
    map.insert("k", 10);
    map.insert("blue", 19);
    // 如果不存在相同的键，则插入；存在不处理
    map.entry("k").or_insert(90);
    map.entry("purple").or_insert(99);
    println!("{:?}", map);
}

/// 解引用
fn reference() {

    let a = 5;
    let b = &a;
    assert_eq!(5, a);
    assert_eq!(5, *b);
}

fn calculate_length(str: &String) -> usize {
    str.len()
}