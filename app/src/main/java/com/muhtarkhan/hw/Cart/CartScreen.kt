package com.muhtarkhan.hw.Cart

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhtarkhan.hw.BottomNavBar.BottomNavBar
import com.muhtarkhan.hw.Cart.Db.Entity.CartItem

@Composable
fun CartScreen(
    onCatalog: () -> Unit,
    onCart: () -> Unit,
    onProfile: () -> Unit,
    state: CartState,
    onEvent: (CartEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .safeDrawingPadding()
                    .padding(top = 5.dp, bottom = 15.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Cart",
                    fontSize = 22.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        },
        content = { paddingValues ->
            if (state.cartItems.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Your cart is empty.",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(1),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .safeDrawingPadding()
                        .background(Color(0xFF6F6F6))
                ) {
                    items(state.cartItems) { cartItem ->
                        CartCart(cartItem, onEvent)
                    }
                }
            }
        },
        bottomBar = {
            BottomNavBar(onCatalog, onCart, onProfile)
        }
    )
}

@Composable
fun CartCart(
    cartItem: CartItem,
    onEvent: (CartEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
            .background(Color.White),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = cartItem.image),
            contentDescription = null,
            modifier = Modifier
                .size(140.dp)
        )
        Spacer(modifier = Modifier.width(14.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = cartItem.name,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Text(
                text = "${cartItem.description}",
                fontSize = 15.sp
            )
            Text(
                text = "${cartItem.price}",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Button(
                    onClick = { onEvent(CartEvent.AddToCart(cartItem.productId)) },
                    modifier = Modifier.height(32.dp).width(83.dp),
                    colors = ButtonDefaults.buttonColors().copy(
                        containerColor = Color(0xFF08080A),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text("+")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${cartItem.quantity}",
                    fontSize = 15.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { onEvent(CartEvent.RemoveFromCart(cartItem.productId)) },
                    modifier = Modifier.height(32.dp).width(83.dp),
                    colors = ButtonDefaults.buttonColors().copy(
                        containerColor = Color(0xFF08080A),
                        contentColor = Color(0xFFFFFFFF)
                    )
                ) {
                    Text("-", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}