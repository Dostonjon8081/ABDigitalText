package com.example.abdigitaltest.util.extension

import android.content.Context
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import timber.log.Timber

fun Context.toast(text:String, context: Context){
    Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
}

fun View.show() {
    this.visibility = (View.VISIBLE)
}

fun View.hide(): View {
    this.visibility = (View.GONE)
    return this
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.showKeyBoard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun View.invisible(): View {
    this.visibility = (View.INVISIBLE)
    return this
}

fun View.gone(): View {
    this.visibility = (View.GONE)
    return this
}

fun View.isVisible(): Boolean {
    return this.visibility == (View.VISIBLE)
}

fun View.isNotVisible(): Boolean {
    return this.visibility != (View.VISIBLE)
}

fun Any.logd(text: String) {
    Timber.d(text)
}