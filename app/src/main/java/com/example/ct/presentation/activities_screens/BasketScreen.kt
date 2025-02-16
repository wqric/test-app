package com.example.ct.presentation.activities_screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme


@Composable
fun Basket() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                        .background(Color.White)
                        .align(alignment = Alignment.CenterStart),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(painter = painterResource(R.drawable.arrow), contentDescription = null)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Корзина",
                        fontSize = 20.sp,
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(text = "10 Товаров")
            Spacer(Modifier.height(20.dp))
            LazyColumn {
                items(10) {
                    ProductRow()
                    if (it < 9) {
                        Spacer(Modifier.height(15.dp))
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .background(color = Color.White)
                .align(alignment = Alignment.BottomEnd),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.9f)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Сумма", color = Color(0xFF707B81))
                    Spacer(Modifier.weight(1f))
                    Text(text = "Цена", color = Color(0xFF707B81))
                }
                Spacer(Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Доставка", color = Color(0xFF707B81))
                    Spacer(Modifier.weight(1f))
                    Text(text = "Цена", color = Color(0xFF707B81))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(R.drawable.line),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Доставка", color = Color.Black)
                    Spacer(Modifier.weight(1f))
                    Text(text = "Цена", color = Color(0xFF48B2E7))
                }

                Spacer(Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(
                            color = Color(0xFF48B2E7)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Оформить Заказ",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun ProductRow() {
//    val offsetState = remember { mutableStateOf(0f) }
//    Log.d("offset", offsetState.value.toString())
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.White)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    if (dragAmount.x >= 50f) {
                        Log.d("offset", "right")
                    } else if (dragAmount.x <= -50f) {
                        Log.d("offset", "left")
                    }
                    change.consume()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth(0.9f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(88.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(color = Color(0xFFF7F7F9)), contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(R.drawable.blue_sneaker), contentDescription = null)

            }

            Spacer(Modifier.width(20.dp))
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(Modifier.height(10.dp))
                Text(text = "Nike Club Max")
                Spacer(Modifier.height(5.dp))
                Text(text = "₽584.95")
            }
        }
    }
}

@Composable
@Preview
fun BasketPreview() {
    CTTheme {
        Basket()
    }
}
