package github2todo.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("http://todo-app-web.todo-app.knative-meetup-poc.still.network")
interface TodoAppClient {
    @Post("/insert/todo/{todo}")
    fun createNewTask(todo: String): Single<HttpResponse<String>>
}
