package jhlz.code

import jhlz.code.design.SimpleMesssage
import java.time.LocalDateTime

/**
 * @author jhlz
 * @since 1.0
 */

data class User(val name: String, val gender: String, val age: Int, val bir: LocalDateTime)

fun main() {
    val me = SimpleMesssage()
    me.send("this is a e=demo!")
    
    val userList = listOf(
        User("風逍遥", "男", 16, LocalDateTime.now()),
        User("飞凕", "男", 15, LocalDateTime.now().minusYears(1)),
        User("昊辰", "男", 16, LocalDateTime.now()),
        User("盈曦", "女", 14, LocalDateTime.now().minusYears(2)),
    )
    val result = userList.filter { it.gender == "女" }
    println(result)


}