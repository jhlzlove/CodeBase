package jhlz.code.design

/**
 * @author jhlz
 * @since 1.0
 */
class SimpleMesssage : Message {
    override fun send(message: String) {
        for ((index, c) in message.withIndex()) {
            println("第 $index 个字符：$c")
        }
    }

    override fun printMessage() {
        println("===============================================================")
    }
}