package com.gwh.routes.sample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gwh.routes.Route
import com.gwh.routes.sample.GreetingPresenter
import com.gwh.routes.sample.GreetingView
import com.gwh.routes.sample.R
import com.gwh.routes.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GreetingView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = "Joe"
        val presenter = GreetingPresenter(this)

        helloButton.setOnClickListener { presenter.sayHello(name) }
        goodbyeButton.setOnClickListener { presenter.sayGoodbye(name) }
    }

    override fun navigateTo(route: Route) {
        startActivity(route)
    }
}