package com.gwh.routes.sample

import com.gwh.routes.sample.Greeting.Goodbye
import com.gwh.routes.sample.Greeting.Hello


class GreetingPresenter(val view: GreetingView) {

    fun sayHello(name: String) {
        val route = createGreetingRoute(Hello, name)

        view.navigateTo(route)
    }

    fun sayGoodbye(name: String) {
        val route = createGreetingRoute(Goodbye, name)

        view.navigateTo(route)
    }
}