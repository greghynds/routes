package com.gwh.routes.sample

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import com.gwh.routes.sample.ui.GoodbyeActivity
import com.gwh.routes.sample.ui.HelloActivity
import com.gwh.routes.sample.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val intentsRule = IntentsTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun navigatesToHelloActivityWhenButtonClicked() {
        onView(withId(R.id.helloButton)).perform(click())

        intended(hasComponent(HelloActivity::class.java.name))
        intended(hasExtra("key_name", "Joe"))
    }

    @Test
    fun navigatesToGoodbyeActivityWhenButtonClicked() {
        onView(withId(R.id.goodbyeButton)).perform(click())

        intended(hasComponent(GoodbyeActivity::class.java.name))
        intended(hasExtra("key_name", "Joe"))
    }
}