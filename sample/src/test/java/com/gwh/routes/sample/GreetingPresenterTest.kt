package com.gwh.routes.sample

import com.gwh.routes.Route
import com.gwh.routes.sample.ui.GoodbyeActivity
import com.gwh.routes.sample.ui.HelloActivity
import org.junit.Test

class GreetingPresenterTest {

    @Test
    fun `navigates to hello screen when saying hello`() {
        val view = MockView()
        val presenter = GreetingPresenter(view)
        val expected = Route.to(HelloActivity::class.java)
            .param("key_name", "Joe")
            .create()

        presenter.sayHello("Joe")

        assert(view.currentRoute == expected)
    }

    @Test
    fun `navigates to goodbye screen when saying goodbye`() {
        val view = MockView()
        val presenter = GreetingPresenter(view)
        val expected = Route.to(GoodbyeActivity::class.java)
            .param("key_name", "Joe")
            .create()

        presenter.sayGoodbye("Joe")

        assert(view.currentRoute == expected)
    }

    class MockView : GreetingView {
        var currentRoute: Route? = null

        override fun navigateTo(route: Route) {
            currentRoute = route
        }
    }
}