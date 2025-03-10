package com.example.ct.presentation.activities_screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme

@Composable
fun SearchedProducts() {
    val searchState = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(70.dp))
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
                        text = "Поиск",
                        fontSize = 20.sp,
                    )

                }
            }
            Spacer(Modifier.height(30.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
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
            Spacer(Modifier.height(30.dp))
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

@Composable
@Preview
fun SearchedProductsPreview() {
    CTTheme {
        SearchedProducts()
    }
}
