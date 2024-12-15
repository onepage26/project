package com.muhtarkhan.hw.BottomNavBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.muhtarkhan.hw.R
import androidx.compose.ui.Modifier


@Composable
fun BottomNavBar(onCatalog: () -> Unit, onCart: () -> Unit, onProfile: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ваши элементы навигации
        NavBarItem(iconRes = R.drawable.baseline_home_24, label = "Home", onClick = onCatalog)
        NavBarItem(iconRes = R.drawable.baseline_shopping_cart_24, label = "Cart", onClick = onCart)
        NavBarItem(iconRes = R.drawable.baseline_account_circle_24, label = "Profile", onClick = onProfile)
    }
}

@Composable
fun NavBarItem(iconRes: Int, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Text(text = label, style = MaterialTheme.typography.bodySmall)
    }
}