package com.fredrikbogg.android_chat_app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*

open class BaseTestRobot {
    fun clickButton(resId: Int): ViewInteraction = onView(withId(resId))
        .perform(ViewActions.click())

    fun enterText(resId: Int, text: String): ViewInteraction =
        onView(withId(resId)).perform(typeText(text), closeSoftKeyboard())

    fun buttonIsEnabled(resId: Int): ViewInteraction =
        onView(withId(resId)).check(matches(isEnabled()))

    fun fieldIsDisplayedOnPopup(text: String): ViewInteraction =
        onView(withText(text)).inRoot(RootMatchers.isDialog()).check(matches(isDisplayed()))

    fun matchText(resId: Int, text: String): ViewInteraction =
        onView(withId(resId)).check(matches(withText(text)))

    fun wait(timeInMilliSec: Int) = Thread.sleep(timeInMilliSec.toLong())

}