package com.muhtarkhan.hw.Main


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WelcomeScreen (navigateToSignUp: () -> Unit, navigateToLogin: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(horizontal = 16.dp, vertical = 58.dp),
        verticalArrangement = Arrangement.Bottom

    ) {
        Text(
            text = "Welcome to the biggest sneakers store app",
            fontWeight = FontWeight(600),
            fontSize = 28.sp,
            lineHeight = 28.sp,
            maxLines = 2,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            modifier = Modifier.padding(bottom = 8.dp)
                .fillMaxWidth()
                .height(54.dp),
            onClick = { navigateToSignUp() },
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFF08080A),
                contentColor = Color(0xFFFFFFFF)
            )
        ){
            Text(
                text = ("Sign Up"),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(600),
                fontSize = 17.sp,
                lineHeight = 22.sp,
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            onClick = { navigateToLogin()},
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFFFFFF),
                contentColor = Color(0xFF08080A)
            )
        ) {
            Text(
                text = "I already have an account",
                fontWeight = FontWeight(600),
                fontSize = 17.sp,
                lineHeight = 22.sp,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
        }
    }
}