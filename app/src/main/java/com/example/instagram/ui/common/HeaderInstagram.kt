package com.example.instagram.ui.common

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Send
import androidx.compose.ui.graphics.Color
import com.example.instagram.R
import com.example.instagram.ui.theme.BlackBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderInstagram(
    onSendClick: () -> Unit = {},
    onLikeClick: () -> Unit = {}
){
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontSize = 33.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily(Font(R.font.billabong))
            )
        },
        actions = {
            IconButton(onClick = {}){
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Notification",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Message",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground,
        )
    )
}
