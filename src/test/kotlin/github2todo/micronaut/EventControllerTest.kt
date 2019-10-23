package github2todo.micronaut

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.mockk.mockkClass
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class EventControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `return http okay on post of issue event`() {
        val exampleEventJson = """
        {
          "action": "opened",
          "issue": {
            "number": 34,
            "title": "Test"
          }
        }""".trimIndent()

        val request = HttpRequest.POST("/", exampleEventJson)
        val retrieve: HttpResponse<Any> = client.toBlocking().exchange(request)

        assertEquals(HttpStatus.CREATED, retrieve.status)
    }

    @MockBean(TodoAppClient::class)
    fun todoAppClient(): TodoAppClient = mockkClass(TodoAppClient::class, relaxed = true)
}
