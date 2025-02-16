package com.example.ct.presentation.activities_screens

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ct.R
import com.example.ct.ui.theme.CTTheme

@Composable
fun ForgotPass() {
    val emailState = remember { mutableStateOf("") }
    val check = Patterns.EMAIL_ADDRESS.matcher(emailState.value).matches()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(40.dp))
            Image(
                painter = painterResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier.align(alignment = Alignment.Start)
            )
            Spacer(Modifier.height(40.dp))
            Text(
                text = "Забыл Пароль",
                fontWeight = FontWeight.W400,
                fontSize = 32.sp
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "Введите свою учетную запись\n для сброса",
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                color = Color(0xFF707B81),
                modifier = Modifier.fillMaxWidth(0.9f),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(40.dp))
            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                colors = OutlinedTextFieldDefaults.colors(

                    focusedBorderColor = Color(0xFFF5F5F9),
                    focusedContainerColor = Color(0xFFF5F5F9),
                    unfocusedContainerColor = Color(0xFFF5F5F9),
                    unfocusedBorderColor = Color(0xFFF5F5F9),
                ),
                shape = RoundedCornerShape(10.dp),
                label = { Text(text = "xyz@gmail.com", color = Color(0xFF707B81)) },
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(30.dp))
            Button(
                onClick = {
//                    loginViewModel.signIn(email = emailState.value, password = passState.value)
                },
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(13.dp))
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF48B2E7),
                    disabledContainerColor = Color(0xFF48B2E7),
                    disabledContentColor = Color.White
                ),
                enabled = check
            ) {
                Text(text = "Зарегистрироваться")
            }
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Есть аккаунт?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF6A6A6A)
                )
                Spacer(Modifier.width(3.dp))
                Text(
                    text = "Войти",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF2B2B2B)
                )
            }
            Spacer(Modifier.height(30.dp))
        }
    }
}

@Preview
@Composable
fun ForgotPassPreview() {
    CTTheme {
        ForgotPass()
    }
}