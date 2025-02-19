package com.example.ct.presentation.activities_screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme


@Composable
fun Main(
    modifier: Modifier = Modifier,
    navController: NavController,
    categoryState: MutableState<Int>,
    mapsState: MutableState<Boolean>
) {
    val searchState = remember { mutableStateOf( "") }
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .align(alignment = Alignment.TopCenter)
                .verticalScroll(state = rememberScrollState())
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(R.drawable.hamburger), contentDescription = null)
                Spacer(Modifier.weight(1f))
                Image(painter = painterResource(R.drawable.main), contentDescription = null)
                Spacer(Modifier.weight(1f))
                Image(painter = painterResource(R.drawable.basket), contentDescription = null)
            }
            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    Modifier
                        .height(intrinsicSize = IntrinsicSize.Max)
                        .width(intrinsicSize = IntrinsicSize.Max)
                ) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 4.dp)
                            .background(
                                color = Color.Black.copy(alpha = 0.04f),
                                shape = RoundedCornerShape(14.dp)
                            )
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(14.dp),
                                ambientColor = Color.Black.copy(alpha = 0.04f)
                            )


                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(14.dp),
                                ambientColor = Color.Black.copy(alpha = 0.04f)
                            ),
                        colors = OutlinedTextFieldDefaults.colors(
                            disabledContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedBorderColor = Color.White,
                            disabledBorderColor = Color.White,
                        ),
                        shape = RoundedCornerShape(14.dp),
                        value = searchState.value,
                        onValueChange = {
                            searchState.value = it
                        },
                        placeholder = {
                            Text(
                                text = "Поиск",
                                color = Color.Gray
                            )
                        },
                        leadingIcon = {
                            Image(
                                painter = painterResource(R.drawable.search),
                                contentDescription = null
                            )
                        },
                        trailingIcon = {
                            Image(
                                painter = painterResource(R.drawable.micro),
                                contentDescription = null
                            )
                        }

                    )
                }
                Spacer(Modifier.weight(1f))
                Box(
                    Modifier
                        .height(intrinsicSize = IntrinsicSize.Max)
                        .width(intrinsicSize = IntrinsicSize.Max)
                ) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 4.dp)
                            .background(
                                color = Color.Black.copy(alpha = 0.04f),
                                shape = CircleShape
                            )
                            .shadow(
                                elevation = 4.dp,
                                shape = CircleShape,
                                ambientColor = Color.Black.copy(alpha = 0.04f)
                            )


                    )
                    Box(
                        modifier = Modifier
                            .shadow(
                                elevation = 4.dp,
                                shape = CircleShape,
                                ambientColor = Color.Black.copy(alpha = 0.04f)
                            )
                            .size(60.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0xFF48B2E7)),

                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.sliders),
                            contentDescription = null
                        )
                    }
                }
            }
            Spacer(Modifier.height(30.dp))
            Text(text = "Категории")
            Spacer(Modifier.height(20.dp))
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(10) {
                    Box(
                        modifier = Modifier
                            .width(115.dp)
                            .height(40.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .clickable(onClick = {
                                categoryState.value = it
                                navController.navigate("CategoriesScreen")
                            }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("${it + 1}")
                    }
                    if (it < 9) {
                        Spacer(Modifier.width(20.dp))
                    }
                }
            }
            Spacer(Modifier.height(30.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Популярное")
                Spacer(Modifier.weight(1f))
                Text(
                    text = "Все",
                    color = Color(0xFF48B2E7),
                    modifier = Modifier.clickable(
                        remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        navController.navigate("PopularScreen")
                    }
                )
            }
            Spacer(Modifier.height(30.dp))
            Row(Modifier.fillMaxWidth()) {
                ProductBox()
                Spacer(Modifier.weight(1f))
                ProductBox()
            }
            Spacer(Modifier.height(30.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Акции")
                Spacer(Modifier.weight(1f))
                Text(text = "Все", color = Color(0xFF48B2E7), modifier = Modifier.clickable {
                    mapsState.value = true
                })
            }
            Spacer(Modifier.height(30.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(R.drawable.stock),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
            }
            Spacer(Modifier.weight(1f))
        }
    }
}

@Composable
fun ProductBox() {
    val isFavorite = remember { mutableStateOf(false) }
    val inBasket = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(182.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(if (isFavorite.value) R.drawable.infav else R.drawable.favorite),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .clickable(
                    remember { MutableInteractionSource() },
                    indication = null
                ) {
                    isFavorite.value = !isFavorite.value
                }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(Modifier.fillMaxWidth(0.8f)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.frame_1000000826),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(Modifier.height(5.dp))
                Text(text = "Best Seller", color = Color(0xFF48B2E7))
                Spacer(Modifier.height(5.dp))
                Text(text = "Nike Air Max", color = Color.Gray)


            }
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .padding(start = 18.dp)
                    .fillMaxWidth()
            ) {
                Text("₽752.00")
                Spacer(Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp))
                        .background(color = Color(0xFF48B2E7))
                        .clickable(
                            remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            inBasket.value = !inBasket.value
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(if (inBasket.value) R.drawable.append_basket else R.drawable.plus),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}



