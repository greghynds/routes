package com.gwh.routes.sample

import com.gwh.routes.Route
import com.gwh.routes.sample.Greeting.Goodbye
import com.gwh.routes.sample.Greeting.Hello
import com.gwh.routes.sample.ui.GoodbyeActivity
import com.gwh.routes.sample.ui.HelloActivity
import org.junit.Test

class SampleRoutesTest {

    @Test
    fun `creates route for hello page when greeting is hello`() {
        val params = Route.params()
            .put("key_name", "world")
            .create()

        val result = createGreetingRoute(Hello, "world")

        assert(result.destination == HelloActivity::class.java)
        assert(result.params == params)
    }

    @Test
    fun `creates route for goodbye page when greeting is goodbye`() {
        val params = Route.params()
            .put("key_name", "world")
            .create()

        val result = createGreetingRoute(Goodbye, "world")

        assert(result.destination == GoodbyeActivity::class.java)
        assert(result.params == params)
    }
}