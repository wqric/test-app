package com.example.ct.presentation.activities_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme

@Composable
fun Popular(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.fillMaxWidth(0.9f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                Spacer(Modifier.weight(1f))
                Text(
                    text = "Популярное",
                    fontSize = 20.sp
                )
                Spacer(Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                        .background(Color.White),         
                    contentAlignment = Alignment.Center
                ) {
                    Image(painter = painterResource(R.drawable.fave), contentDescription = null)
                }
            }
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

