package com.example.instagram.ui.reels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.R
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun ReelsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Background Video/Image
        ReelContent()

        // Top Bar
        ReelsTopBar(modifier = Modifier.align(Alignment.TopCenter))

        // Right Side Actions
        ReelsSideActions(modifier = Modifier.align(Alignment.CenterEnd))

        // Bottom Info
        ReelsBottomInfo(modifier = Modifier.align(Alignment.BottomStart))
    }
}

@Composable
fun ReelContent() {
    // Placeholder for video content
    Image(
        painter = painterResource(id = R.drawable.my_profile),
        contentDescription = "Reel Video",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    // Gradient overlay for better text visibility
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = 0.3f),
                        Color.Transparent,
                        Color.Transparent,
                        Color.Black.copy(alpha = 0.7f)
                    )
                )
            )
    )
}

@Composable
fun ReelsTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Reels",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Icon(
            imageVector = Icons.Default.CameraAlt,
            contentDescription = "Camera",
            tint = Color.White,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun ReelsSideActions(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(end = 12.dp, bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Like
        ReelActionButton(
            icon = Icons.Default.FavoriteBorder,
            label = "245K",
            onClick = {}
        )

        // Comment
        ReelActionButton(
            icon = Icons.Default.ModeComment,
            label = "1,234",
            onClick = {}
        )

        // Share
        ReelActionButton(
            icon = Icons.Default.Send,
            label = "Share",
            onClick = {}
        )

        // More options
        ReelActionButton(
            icon = Icons.Default.MoreVert,
            label = "",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Audio/Music thumbnail
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.my_profile),
                contentDescription = "Audio",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun ReelActionButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }

        if (label.isNotEmpty()) {
            Text(
                text = label,
                color = Color.White,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun ReelsBottomInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // User info
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.my_profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )

            Text(
                text = "stiven_j_stg",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .height(28.dp)
                    .padding(0.dp)
            ) {
                Text(
                    text = "Ikuti",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Caption
        Text(
            text = "Calisthenics training at home 💪🔥\nCheck out my full workout routine!",
            color = Color.White,
            fontSize = 13.sp,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Audio info
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.MusicNote,
                contentDescription = "Audio",
                tint = Color.White,
                modifier = Modifier.size(12.dp)
            )

            Text(
                text = "Original Audio - stiven_j_stg",
                color = Color.White,
                fontSize = 11.sp
            )
        }
    }
}

