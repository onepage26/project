package com.muhtarkhan.hw.Auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhtarkhan.hw.R


@Composable
fun SignUpScreen(navigateToSneaker: ()-> Unit, onIcon: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxHeight()
            .padding(horizontal = 16.dp).padding(top = 11.dp, bottom = 58.dp)
            .safeDrawingPadding()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    onIcon()
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = null,
                    modifier = Modifier.size(23.dp),

                    )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "New User",
                fontSize = 17.sp,
                fontWeight = FontWeight(600),
                lineHeight = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = 25.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.weight(0.11f))

        // TextField для username
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )

        )


        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )
        )


        Spacer(modifier = Modifier.height(16.dp))


        TextField(
            value = repeatPassword,
            onValueChange = { repeatPassword = it },
            label = { Text("Repeat password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )
        )



        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navigateToSneaker() },
            modifier = Modifier.fillMaxWidth()
                .height(54.dp)
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFF08080A),
                contentColor = Color(0xFFFFFFFF)
            )
        ) {
            Text("Sign Up", fontSize = 17.sp, fontWeight = FontWeight(600), lineHeight = 22.sp)
        }
    }
}

