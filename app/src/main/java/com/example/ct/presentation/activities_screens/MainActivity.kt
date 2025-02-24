package com.example.ct.presentation.activities_screens


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ct.R
import com.example.ct.presentation.activities_screens.ui.theme.CTTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
//            navigationBarStyle = SystemBarStyle.auto(
//            /* цвет панели навигации */
//            Color.Black.toArgb(),
//            /* цвет значков панели навигации */
//            Color.White.toArgb()
        )
        setContent {
//            this.window.navigationBarColor = Color.WHITE
            CTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val uri: String = "geo:10,10"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                    val navController = rememberNavController()
                    val categoryState = remember { mutableStateOf(-1) }
                    val mapsState = remember { mutableStateOf(false) }
                    if (mapsState.value) {
                        startActivity(intent)
                    }
                    Box(modifier = Modifier
                        .padding(bottom = innerPadding.calculateBottomPadding())
                        .background(color = Color(0xFFF7F7F9))
                        .padding(top = innerPadding.calculateTopPadding())) {
                        NavHost(
                            navController,
                            "MainScreen",
                        ) {
                            composable("MainScreen") {
                                Main(
                                    navController = navController,
                                    categoryState = categoryState,
                                    mapsState = mapsState
                                )
                            }
                            composable("PopularScreen", enterTransition = {
                                slideIn(initialOffset = {
                                    IntOffset(-it.width, 0)
                                })
                            }, exitTransition = { slideOut { IntOffset(-it.width, 0) } }) {
                                Popular(
                                    navController = navController
                                )
                            }
                            composable("CategoriesScreen") {
                                Categories(
                                    navController = navController,
                                    categoryState = categoryState
                                )
                            }
                        }
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.BottomCenter)) {
                            Image(
                                painter = painterResource(R.drawable.vector_1789),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                            Box(
                                modifier = Modifier
                                    .shadow(
                                        elevation = 4.dp,
                                        shape = CircleShape,
                                        ambientColor = Color.Black.copy(alpha = 0.04f)
                                    )
                                    .size((LocalConfiguration.current.screenWidthDp * 0.15f).dp)
                                    .clip(shape = CircleShape)
                                    .background(Color(0xFF48B2E7))
                                    .align(alignment = Alignment.TopCenter),

                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.bag),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth(),

                                    )
                            }
                        }
                    }
                }
            }
        }
    }
}

