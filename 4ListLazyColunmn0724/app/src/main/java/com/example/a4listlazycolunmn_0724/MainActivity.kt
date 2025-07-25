package com.example.a4listlazycolunmn_0724

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.a4listlazycolunmn_0724.ui.theme._4ListLazyColunmn0724Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4ListLazyColunmn0724Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
//                            .background(Color.Red)
                            .fillMaxSize()
                    ){
                        MainPage()
                    }
                }
            }
        }
    }
}

@Composable
fun MainPage(){
    //레이지 컬럼 사용시 스크롤 스테이트 필요 없음
    //val scrollState = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize(),
//            .verticalScroll(scrollState)
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        //헤더
        item{
            Text("Header")

        }

        items(50){index->
//            Text(text = "Hello MainPage $index")
            MyRow()
        }
        item{
            Text("Footer")
        }
        item{
            Text("Footer2")
        }
    }

}

@Composable
fun MyRow(){
    Row{
        Text("이것은")
        Spacer(modifier = Modifier.width(32.dp))
        Text("로우입니다.")
    }
}

