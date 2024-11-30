package com.muhtarkhan.hw.Sneaker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhtarkhan.hw.R


data class Sneaker(
    val name: String,
    val description: String,
    val price: String,
    val imageRes: Int
)

@Composable
fun SneakerGrid() {
    val sneakers = listOf(
        Sneaker("Dolce & Gabbana", "Кроссовки с принтом", "$1261", R.drawable.img_1),
        Sneaker("Off-White", "Кроссовки Off-Court 3.0", "$551", R.drawable.img_1),
        Sneaker("Jordan", "Кроссовки с принтом", "$1251", R.drawable.img_1),
        Sneaker("Jordan", "Кроссовки с принтом", "$1251", R.drawable.img_1),
        Sneaker("Jordan", "Кроссовки с принтом", "$1251", R.drawable.img_1),
        Sneaker("Jordan", "Кроссовки с принтом", "$1251", R.drawable.img_1),
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth().safeDrawingPadding()
                .padding(top = 5.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello SneakerHead",
                fontSize = 22.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
            .safeDrawingPadding()
    ) {

        items(sneakers) { sneaker ->
            SneakerCard(sneaker)
        }
    }
    }
}

@Composable
fun SneakerCard(sneaker: Sneaker) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(350.dp)
            .width(174.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = sneaker.imageRes),
            contentDescription = sneaker.name,
            modifier = Modifier
                .size(166.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        Text(text = sneaker.name, fontWeight = FontWeight.Bold, modifier = Modifier.padding(4.dp))
        Text(text = sneaker.description, fontSize = 12.sp, modifier = Modifier.padding(4.dp))
        Text(text = sneaker.price, fontWeight = FontWeight.Bold, modifier = Modifier.padding(4.dp))

        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color(0xFF08080A),
                contentColor = Color(0xFFFFFFFF)
            )
        ) {
            Text("Add to cart")
        }
    }
}
