@file:JvmName("SampleRoutes")

package com.gwh.routes.sample

import com.gwh.routes.Route
import com.gwh.routes.sample.Greeting.Goodbye
import com.gwh.routes.sample.Greeting.Hello
import com.gwh.routes.sample.ui.GoodbyeActivity
import com.gwh.routes.sample.ui.HelloActivity

const val KEY_NAME = "key_name"

/**
 * Creates a Route to a greeting page.
 */
fun createGreetingRoute(greeting: Greeting, name: String): Route {
    val builder = when (greeting) {
        Hello -> Route.to(HelloActivity::class.java)
        Goodbye -> Route.to(GoodbyeActivity::class.java)
    }

    return builder
        .param(KEY_NAME, name)
        .create()
}