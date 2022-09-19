/// 同一作用域内，不能同时存在可变引用和不可变引用
/// 同一作用域内，只能同时存在一个可变引用
/// 总的来说，借用规则如下：
///     1. 同一时刻，你只能拥有要么一个可变引用, 要么任意多个不可变引用
///     2. 引用必须总是有效的
fn main() {
    let mut a = String::from("hello world");

    let b = &a;
    let c = &a;
    println!("{}, {}", b, c);
    

    let mut d = &mut a;
    // let mut e = &mut a;   // 如果加上这行将报错
    d.push_str("string");
    println!("{}", d);

    take_string(&a);
    println!("a: {}", a);


}

fn take_string(some_string: &String) {
    println!("some_string: {}", some_string);
}


fn dangle() -> String {
    let s = String::from("任凭世人笑我癫，狂叹红尘游世间。");
    s
}

