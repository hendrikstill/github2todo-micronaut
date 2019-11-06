package github2todo.micronaut

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.slf4j.LoggerFactory

@Introspected
data class GithubIssue(val number: Int, val title: String)

@Introspected
data class GithubWebhookEvent(val issue: GithubIssue)

@Controller("/")
class EventController(private val todoAppClient: TodoAppClient) {
    private val log = LoggerFactory.getLogger(EventController::class.java)

    @Get(produces = ["text/html"])
    fun index() = HttpResponse.ok("Hello from github2todo. Let's deliver some todos")

    @Post
    fun post(@Body event: GithubWebhookEvent): HttpResponse<String> {
        log.info(event.toString())
        todoAppClient.createNewTask("${event.issue.number}:${event.issue.title}").blockingGet()

        return HttpResponse.created("created")
    }
}
