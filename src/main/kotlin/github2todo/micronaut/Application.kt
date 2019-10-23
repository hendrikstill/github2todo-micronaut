package github2todo.micronaut

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.Micronaut
import org.slf4j.LoggerFactory

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("github2todo.micronaut")
            .mainClass(Application.javaClass)
            .start()
    }
}

@Introspected
data class GithubWebhookEvent(val id: String)

@Controller("/")
class WebhookController {
    private val log = LoggerFactory.getLogger(WebhookController::class.java)

    @Post
    fun post(@Body event: GithubWebhookEvent): HttpResponse<String> {
        log.info(event.toString())
        return HttpResponse.created("created")
    }
}
