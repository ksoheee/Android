package com.example.movie_0725

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie_0725.ui.theme.Movie0725Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Movie 하나만 상태로 관리
            //val movie = remember { mutableStateOf(Movie("밥먹는짱구",R.drawable.poster)) }
            //var movies = listOf("siasia","ga","harrypotter")
            //리스트 스테이트로 만들어서 넘길때
            var movies =remember{
                mutableStateListOf(
                        Movie("밥먹는 짱구",R.drawable.poster),
                        Movie("가오갤",R.drawable.ga),
                        Movie("해리포터",R.drawable.harrypotter)

                )
            }
//            var movies =listOf(
//                        Movie("밥먹는 짱구",R.drawable.poster),
//                        Movie("가오갤",R.drawable.ga),
//                        Movie("해리포터",R.drawable.harrypotter)
//            )
            Movie0725Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)

                        ) {
                            items(movies) { movie->
                                MovieView(
                                    movie=movie,
                                    onTabFavorite={
                                        //movie.isFavorite = !movie.isFavorite
                                        val index = movies.indexOf(movie)
                                        movies[index]=movie.copy(isFavorite = !movie.isFavorite)
                                    }
                                )
                            }
                        }

                    }
                }
            }
        }
    }

//val:변하지 않는 상수
//var:변하는 변수
data class Movie(
    val title:String,
    val imageRes: Int,
    var isFavorite: Boolean=false,
)

@Composable
fun MovieView(
    movie:Movie,
    onTabFavorite:()->Unit
){
    Column {
        Text(
            movie.title,
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            elevation = CardDefaults.cardElevation(5.dp),
            shape = RoundedCornerShape(8.dp)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ){
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id=movie.imageRes),
                    contentDescription = "밥먹는짱구",
                    contentScale = ContentScale.Crop
                )

                IconButton(
                    onClick = onTabFavorite,
                ){
                    Icon(
                        imageVector =if(movie.isFavorite)Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "재생",
                        tint = Color.Red
                    )


                }

            }

        }
    }

}