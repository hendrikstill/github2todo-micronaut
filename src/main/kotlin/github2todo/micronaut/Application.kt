package github2todo.micronaut

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .packages("github2todo.micronaut")
            .mainClass(Application.javaClass)
            .start()
    }
}
