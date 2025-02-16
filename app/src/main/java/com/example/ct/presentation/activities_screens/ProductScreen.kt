package com.example.ct.presentation.activities_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme

@Composable
fun ProductCard(modifier: Modifier = Modifier) {
    val inBasketState = remember { mutableStateOf(false)}
    val inFavoriteState = remember { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(70.dp))
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(R.drawable.back), contentDescription = null)

                Spacer(Modifier.weight(1f))
                Text(
                    text = "Sneaker Shop",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
                Image(painter = painterResource(R.drawable.basket), contentDescription = null)
            }
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Name",
                fontSize = 20.sp
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Category",
                fontSize = 16.sp,
                color = Color(0xFF6A6A6A)
            )
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Price",
                fontSize = 16.sp
            )
            Spacer(Modifier.height(60.dp))
        }
        Box(
            Modifier
                .fillMaxWidth()
                .height(250.dp), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.podium),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxSize(0.95f)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.blue_sneaker),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(0.65f)
                )
                Spacer(Modifier.height(100.dp))

            }
            Spacer(Modifier.height(60.dp))
        }
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(6) {
                    Box(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color.White)
                            .size(70.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.blue_sneaker),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    if (it < 6) {
                        Spacer(Modifier.width(20.dp))
                    }
                }
            }
            Spacer(Modifier.height(30.dp))
            Text(
                text = "Description",
                fontSize = 16.sp,
                color = Color(0xFF6A6A6A)
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Text(text = "Подробнее", color = Color(0xFF48B2E7))
            }
            Spacer(Modifier.weight(1f))
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(60.dp)
                        .background(
                            color = Color(
                                0x65D9D9D9
                            )
                        )
                        .clickable {
                            inFavoriteState.value = !inFavoriteState.value
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (inFavoriteState.value) {
                        Image(
                            painter = painterResource(R.drawable.heart),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(0.5f)
                        )
                    } else {
                        Image(
                            painter = painterResource(R.drawable.fave),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(0.5f)
                        )
                    }
                }
                Spacer(Modifier.width(30.dp))
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(
                            color = Color(0xFF48B2E7)
                        )
                        .clickable {
                            inBasketState.value = !inBasketState.value
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(Modifier.width(15.dp))
                        Image(
                            painter = painterResource(R.drawable.bag),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Text(
                        text = if (inBasketState.value) "Добавлено" else "В Корзину",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
            Spacer(Modifier.height(40.dp))
        }
    }
}


@Preview
@Composable
fun ProductCardPreview() {
    CTTheme {
        ProductCard()
    }
}