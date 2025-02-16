package com.example.ct.presentation.activities_screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ct.App.Companion.sharedPrefs
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme

class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding
                    OnBoardingScreen(modifier = Modifier.fillMaxSize(), endOnBoarding = {
                        startActivity(
                            Intent(
                                this@OnBoardingActivity,
                                LoginActivity::class.java
                            )
                        )
                    }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, endOnBoarding: () -> Unit) {
    val pagerState = rememberPagerState { 3 }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = if (pagerState.currentPage != 0) listOf(
                        Color(0xFF48B2E7),
                        Color(0xFF0076B1)
                    ) else listOf(
                        Color(0xFF48B2E7),
                        Color(0xFF0076B1),
                        Color(0xFF2B6B8B)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Меняющийся текст
        HorizontalPager(pagerState, modifier = Modifier) {
            var ill: Painter = painterResource(R.drawable.sneaker_image_1)
            var text1: String = ""
            var text2: String = ""
            when (it) {
                0 -> {
                    ill = painterResource(R.drawable.sneaker_image_1)
                    text1 = "Добро\nпожаловать"
                    text2 = ""
                }

                1 -> {
                    ill = painterResource(R.drawable.sneaker_image_2)
                    text1 = "Начнем путешествие"
                    text2 = "Умная, великолепная и модная коллекция Изучите сейчас"
                }

                2 -> {
                    ill = painterResource(R.drawable.sneaker_image_3)
                    text1 = "У вас есть сила, чтобы"
                    text2 = "В вашей комнате много красивых и привлекательных растений"
                }
            }
            Pages(
                ill = ill,
                text1 = text1,
                text2 = text2,
                page = pagerState.currentPage
            )
        }
        Spacer(Modifier.height(if (pagerState.currentPage == 0) 20.dp else 40.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // позиция страницы
            repeat(3) {
                Box(
                    modifier = Modifier
                        .height(7.dp)
                        .width(if (it == pagerState.currentPage) 50.dp else 30.dp)
                        .clip(shape = RoundedCornerShape(3.dp))
                        .background(
                            color = if (it == pagerState.currentPage) Color.White else Color(
                                0xFF2B6B8B
                            ),
                        )
                        .size(15.dp)
                )
            }

        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = {
                endOnBoarding.invoke()
                sharedPrefs.onBoardingState = true
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text(text = if (pagerState.currentPage == 0) "Начать" else "Далее")
        }
        Spacer(Modifier.height(50.dp))
    }

}

@Composable
fun Pages(
    modifier: Modifier = Modifier,
    ill: Painter,
    text1: String,
    text2: String,
    page: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (page == 0) {
            Spacer(Modifier.height(40.dp))
            Text(
                text = text1,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Color.White,
            )
            Spacer(Modifier.height(40.dp))
            Image(
                painter = ill,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)

            )

        } else {
            Spacer(Modifier.height(30.dp))
            Image(
                painter = ill,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
            )
            Column(Modifier.fillMaxWidth(0.9F), verticalArrangement = Arrangement.Center) {
                Spacer(Modifier.height(30.dp))
                Text(
                    text = text1,
                    textAlign = TextAlign.Center,
                    fontSize = 34.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(40.dp))
                Text(
                    text = text2,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

        }
    }
}


//@Preview
//@Composable
//fun OnBoardingScreenTheme() {
//    CTTheme {
//        OnBoardingScreen()
//    }
//}
