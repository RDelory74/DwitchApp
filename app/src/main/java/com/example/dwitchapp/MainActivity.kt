package com.example.dwitchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.dwitchapp.debug.timber
import com.example.dwitchapp.ui.component.GlobalLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        timber()
        setContent {
            GlobalLayout()
        }
    }
}
