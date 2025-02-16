package com.example.ct.presentation.activities_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme

@Composable
fun Categories(
    modifier: Modifier = Modifier,
    categoryState: MutableState<Int>,
    navController: NavController
) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            Box(Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                        .background(Color.White)
                        .clickable { navController.navigate("MainScreen") },
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(R.drawable.arrow), contentDescription = null)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Категория",
                        fontSize = 20.sp,
                    )

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Категории",
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(20.dp))
            ScrollableTabRow(modifier = Modifier.fillMaxWidth(),
                selectedTabIndex = categoryState.value,
                containerColor = Color.Transparent,
                indicator = {},
                edgePadding = 0.dp,
                divider = {}) {
                repeat(10) {
                    Row {
                        Box(
                            modifier = Modifier
                                .width(115.dp)
                                .height(40.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                                .background(if (categoryState.value == it) Color(0xFF48B2E7) else Color.White)
                                .clickable(onClick = {
                                    categoryState.value = it
                                }),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("${it + 1}")
                        }
                        if (it < 9) {
                            Spacer(Modifier.width(20.dp))
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                items(10) {
                    Column {
                        Row(Modifier.fillMaxWidth()) {
                            ProductBox()
                            Spacer(Modifier.weight(1f))
                            ProductBox()
                        }
                        if (it < 9) {
                            Spacer(Modifier.height(15.dp))
                        }
                    }
                }
            }
        }
    }
}

