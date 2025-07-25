package com.example.myapplication

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//// 1. Column, Row, Text
//            Scaffold { innerPadding ->
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(innerPadding)
//                        .background(Color.Green)
//                        .padding(16.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
////                    verticalArrangement = Arrangement.spacedBy(16.dp)
////                    verticalArrangement = Arrangement.SpaceBetween
////                    verticalArrangement = Arrangement.SpaceAround
//                    verticalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Text(
//                        "World",
//                        style = TextStyle(
//                            fontSize = 40.sp,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.Red
//                        )
//                    )
//                    Text("Hello")
//                    Text("Hello2")
//                }
//
//            }
            // 3. Box
            Scaffold { innerPadding ->

                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.Green)
                ) {
                    Text(text = "Hello")

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Text(text = "World")
                    }
                }

            }
        }
    }
}
// 2. Composable, Preview
@Composable
fun MyTextView() {
    Text(text = "Hello 여러분!!!")
}

@Preview(showBackground = true, name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, name = "Dark", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyTextViewPreview() {
    MyTextView()
}

/*
@Preview(showBackground = true)
@Composable
fun MyTextViewPreview2() {
    MyTextView()
}*/
