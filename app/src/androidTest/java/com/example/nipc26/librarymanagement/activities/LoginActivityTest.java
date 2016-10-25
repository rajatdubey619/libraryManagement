package com.example.nipc26.librarymanagement.activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.nipc26.librarymanagement.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnCreateAccount), withText("Create Account")));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction appCompatEditText = onView(
                withId(R.id.etFullName));
        appCompatEditText.perform(scrollTo(), click());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.etFullName));
        appCompatEditText2.perform(scrollTo(), replaceText("vianay"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                withId(R.id.etMobileNo));
        appCompatEditText3.perform(scrollTo(), replaceText("7508574720"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                withId(R.id.etEmailId));
        appCompatEditText4.perform(scrollTo(), replaceText("bhaskartomar"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                withId(R.id.etUnivId));
        appCompatEditText5.perform(scrollTo(), click());

        ViewInteraction appCompatEditText6 = onView(
                withId(R.id.etUnivId));
        appCompatEditText6.perform(scrollTo(), click());

        ViewInteraction appCompatEditText7 = onView(
                withId(R.id.etUnivId));
        appCompatEditText7.perform(scrollTo(), replaceText("xbxbxbhdb"), closeSoftKeyboard());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.tvBatchYear), withText("yyyy(batch year)")));
        appCompatTextView.perform(scrollTo(), click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.etUnivId), withText("xbxbxbhdb")));
        appCompatEditText8.perform(scrollTo(), replaceText("xbxbxbhdbf"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("Set"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.tvBatchYear), withText("2016")));
        appCompatTextView2.perform(scrollTo(), click());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.tvDOBYear), withText("mm/dd/yyyy(dob)")));
        appCompatTextView3.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(android.R.id.button1), withText("Set"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(android.R.id.button1), withText("Set"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                withId(R.id.etLoginUsername));
        appCompatEditText9.perform(scrollTo(), replaceText("vnnhhh"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                withId(R.id.etLoginPassword));
        appCompatEditText10.perform(scrollTo(), replaceText("h"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.etLoginPassword), withText("h")));
        appCompatEditText11.perform(scrollTo(), click());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.etLoginPassword), withText("h")));
        appCompatEditText12.perform(scrollTo(), click());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.etLoginPassword), withText("h")));
        appCompatEditText13.perform(scrollTo(), replaceText("hhh"), closeSoftKeyboard());

        ViewInteraction appCompatSpinner = onView(
                withId(R.id.spinner));
        appCompatSpinner.perform(scrollTo(), click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.etLoginPassword), withText("hhh")));
        appCompatEditText14.perform(scrollTo(), replaceText("hhhhhhh"), closeSoftKeyboard());

        ViewInteraction appCompatCheckedTextView = onView(
                allOf(withId(android.R.id.text1), withText("Admin"), isDisplayed()));
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnCreateAccount), withText("Create Account")));
        appCompatButton5.perform(scrollTo(), click());

        pressBack();

    }

}
