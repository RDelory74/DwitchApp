package com.example.dwitchapp.debug

fun timber(){
    timber.log.Timber.d("Debug message")
    timber.log.Timber.e("Error message")
    timber.log.Timber.w("Warning message")
    timber.log.Timber.i("Info message")
    timber.log.Timber.v("Verbose message")
}