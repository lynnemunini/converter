package com.grayseal.mp3converter

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.grayseal.mp3converter.ui.theme.MP3ConverterTheme
import com.yausername.youtubedl_android.YoutubeDL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            YoutubeDL.getInstance().init(this)
            Toast.makeText(this, "SUCCESS", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("ERROR", "failed to initialize youtubedl-android", e)
        }
        setContent {
            MP3ConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MP3ConverterTheme {
        Greeting("Android")
    }
}