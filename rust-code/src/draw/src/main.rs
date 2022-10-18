fn main() {
    // 动态数组 elems
    let elems : Vec<Box<dyn Draw>> = vec![Box::new(Button{id: 1}) , Box::new(Select {id: 2})];

    for e in elems {
        e.draw();
    }
}

pub trait Draw {
    fn draw(&self);
}

struct Select {
    id: u32,
}

impl Draw for Select {
    fn draw(&self) {
        println!("this is a Select, id is: {}", self.id)
    }
}
struct Button {
    id: u32,
}

impl Draw for Button {
    fn draw(&self) {
        println!("this is a Button, id is: {}", self.id)
    }
}