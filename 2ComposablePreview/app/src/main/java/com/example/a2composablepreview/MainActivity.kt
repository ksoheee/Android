package com.example.a2composablepreview

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a2composablepreview.ui.theme._2ComposablePreviewTheme
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_NIGHT_NO

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _2ComposablePreviewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                }
            }
        }
    }
}

@Composable
fun MyTextView() {
    Text(text = "Hello 여러분!!!")
}


//@Composable
//fun MyTextViewPreview() {
//    MyTextView()
//}

@Preview(showBackground = true, name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, name = "Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyTextViewPreview() {
    MyTextView()
}
//@Preview(showBackground = true)
//@Composable
//fun MyTextViewPreview2() {
//    MyTextView()
//}