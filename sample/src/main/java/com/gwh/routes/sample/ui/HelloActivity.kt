package com.gwh.routes.sample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gwh.routes.sample.KEY_NAME
import com.gwh.routes.sample.R
import com.gwh.routes.withParams
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        withParams {
            val name = getString(KEY_NAME)
            val message = "Hello, $name!"

            helloText.text = message
        }
    }
}