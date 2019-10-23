package github2todo.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("http://todo-app-web.todo-app.knative-meetup-poc.still.network")
interface TodoAppClient {
    @Get("/insert/todo/{todo}")
    fun createNewTask(todo: String): Single<HttpResponse<String>>
}
