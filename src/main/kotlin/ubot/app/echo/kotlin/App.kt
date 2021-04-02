package ubot.app.echo.kotlin

import kotlinx.coroutines.runBlocking
import ubot.common.*
import kotlin.system.exitProcess

class App(private val api: UBotAppApi) : BaseUBotApp() {
    private val matchPattern = Regex("^\\s*(?:复述|复读|重复|echo)\\s*(.*?)\\s*\$")
    override suspend fun onReceiveChatMessage(bot: String, type: Int, source: String, sender: String, message: String, info: ChatMessageInfo): UBotEventResult {
        val match = matchPattern.find(message)
        if (match != null) {
            api.sendChatMessage(bot, type, source, sender, match.groups[1]!!.value)
            return UBotEventResult.Completed
        }
        return super.onReceiveChatMessage(bot, type, source, sender, message, info)
    }
}

fun main(args: Array<String>) {
    runBlocking {
        UBotClientHost.hostApp(args[0], args[1], "Echo.Kotlin") { api ->
            App(api)
        }
    }
    exitProcess(0)
}