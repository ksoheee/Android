package com.example.self_0724


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.self_0724.ui.theme.Self0724목Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Self0724목Theme {
                //기본 머티리얼 레이아웃 기본 틀(툴바, 바텀바). immerPadding은 툴바/바텀바 영역을 피하기 위한 패딩
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //자식을 겹쳐서 배치할 때 쓰는 컨테이너, 화면 전체를 채우고 innerpadding을 적용
                    //Box, Column, Row등을 두고 거기서 실제 화면을 구성
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()


                    ){
                        //mutableStateOf:상태가 바뀌었으니 화면 일부를 다시 그리게 자동 리컴포지션
                        //rememberSaveable 컴포저블 재구성(remember) 뿐아니라, 화면 회전같은 구성 변경시(Saveable)에도 저장해줌
                        // var isFavorite by ...라고 쓰면, isFavorite을 읽을 때는 내부적으로 favoriteState.value를 꺼내고 쓸때는 favorite.value = newValue처럼 동작
                        var isFavorite by rememberSaveable { mutableStateOf(false) }
                        //클릭 콜백으로 상태 갱신
                        imageCard(isFavorite){ favorite->
                            isFavorite = favorite

                        }
                    }

                }
            }
        }
    }
}
//ui를 그리는 함수. isFavorite 상태와, 변경을 알리는 onTabFavorite람다를 파라미터로 받음
//onTabFavorite: 입력으로 boolean 값하나 받고, 출력은 Unit인 함수 타입, onTabFavorite(true)를 넘기면 그 함수 내부에 정의된 로직이 실행
@Composable
fun imageCard(
    isFavorite:Boolean,
    onTabFavorite:(Boolean)->Unit
){
    Column( //세로 배치
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally //중앙 정렬
    ) {
        Card(
            modifier = Modifier
                .padding(top=16.dp)
                .fillMaxWidth(0.9f)
                .height(400.dp),
            shape = RoundedCornerShape(20.dp),

            elevation=CardDefaults.cardElevation(5.dp), // 기본 그림자(어두운 외곽선)를 만들어 주는 helper
        ){
            Box(){ //Card안에 Image, IconButton을 동시에 배치하기 위해 Box사용
                Image(
                    modifier=Modifier
                        .fillMaxSize(),
                    painter = painterResource(id=R.drawable.poster),
                    contentDescription="Poster",
                    contentScale = ContentScale.Crop
                )
                Box( //아이콘 버튼을 배치하기 위한 컨테이너
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top=16.dp, end=16.dp),
                    contentAlignment = Alignment.TopEnd
                ){
                    IconButton(
                        onClick = {
                            onTabFavorite(!isFavorite)
                        },
                        modifier = Modifier
                            .size(40.dp)  //iconbutton역역

                    ){
                        Icon(
                            //imageVector: ImageVector타입의 객체 전달, 실제로 실제로 화면에 그려직 벡터 이미지를 나타냄
                            //else일대: 테두리만 있는 FavoriteBorder아이콘
                            imageVector = if(isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint=Color.Red,
                            modifier = Modifier
                                .size(32.dp)  //iconsize

                        )
                    }



                }

            }
        }
    }

}

