package com.fredrikbogg.android_chat_app;

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.fredrikbogg.android_chat_app.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssignedTest: BaseTestRobot(){
    @JvmField
    @Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test fun sampleTest() {
        loginViaValidCredentials("karolina.sitnik@hl.co.uk","testtest")
        navigateToSettings()
        verifySettingsPage()
        updateUserStatus()
        verifyStatusText()
    }

    private fun loginViaValidCredentials(email: String, password: String){
        clickButton(R.id.loginButton)
        enterText(R.id.editTextEmail,email)
        enterText(R.id.editTextPassword,password)
        clickButton(R.id.loginButton)
        wait(1000)
    }

    fun verifyTimeOfLastSentMsg(){
        // Create a regex and match a pattern
    }

    private fun navigateToSettings(){
        //navigate to settings
        clickButton(R.id.navigation_settings)
    }

    private fun verifySettingsPage(){
        //verify change image button, change status button and logout button are enabled
        buttonIsEnabled(R.id.changeImageButton)
        buttonIsEnabled(R.id.changeStatusButton)
        buttonIsEnabled(R.id.logoutButton)
    }

    private fun updateUserStatus(){
        //click change image
        clickButton(R.id.changeStatusButton)
        // Verify change popup is displayed
        fieldIsDisplayedOnPopup("Status:")
        onView(withText("Status:"))

        // Unable to enter the text in the text field present on alert popup
        /****************** CODE PENDING *********************/

        // Select Ok on the alert popup
        fieldIsDisplayedOnPopup("OK")
    }

    private fun verifyStatusText(){
        matchText(R.id.statusText,"test2")
    }
}
