package github2todo.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single

@Client("\${todoapp.url}")
interface TodoAppClient {
    @Post("/todo/{todo}")
    fun createNewTask(todo: String): Single<HttpResponse<String>>
}
