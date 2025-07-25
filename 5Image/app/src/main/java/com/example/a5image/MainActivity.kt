package com.example.a5image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a5image.ui.theme._5ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isFavorite by rememberSaveable { mutableStateOf(false) }

            _5ImageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                    )
                    {
                        PosterCard(isFavorite){ favorite ->
                            isFavorite = favorite

                        }
                    }

                }
            }
        }
    }
}


@Composable
fun PosterCard(isFavorite:Boolean,
               onTabFavorite:(Boolean) -> Unit  //unit: 아무것도 리턴하지 않음
){
    Card(  //박스를 상속 받고 있는 거라고 생각
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(200.dp),
        shape = RoundedCornerShape(30.dp),  //둥글기
        elevation = CardDefaults.cardElevation(5.dp)  //튀어나온 것 같은 효과
    ) {
        Box() {
            Image(
                modifier= Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.poster), //이미지 가져옴
                contentDescription = "Poster", //음성으로 나오게 함
                contentScale = ContentScale.Crop //이미지가 가로로 확장이 되도록 그럼 위, 아래가 좀 짤림(기본값은 Fit)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd //아이콘 위치
            ){
                IconButton(
                    onClick = {
                        onTabFavorite(!isFavorite)
                    },
                ){
                    Icon(//버튼을 눌렀을 때 화면을 다시 그려줌, 코틀린에서는 삼항연산자를 안씀!
                        imageVector = if(isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.White //색상은 흰색
                    )
                }
            }
        }
    }
}

