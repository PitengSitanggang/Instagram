package com.example.instagram.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.R

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        // Top Bar
        TopBar()

        // Profile Info Section
        ProfileInfoSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Bio Section
        BioSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Dasboard Anda Card
        DashboardCard()

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons
        ActionButtons()

        Spacer(modifier = Modifier.height(24.dp))

        // Temukan Orang Section
        TemukanOrangSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Tab Section (Grid Icon Bar)
        TabSection()

        // Posts Grid
        PostsGrid()

        Spacer(modifier = Modifier.height(80.dp)) // Space for bottom nav
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "stiven_j_stg",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Dropdown",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            // Notification badge
            Box {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification),
                    contentDescription = "Notifications",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .offset(x = 12.dp, y = (-4).dp)
                        .background(Color.Red, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("10", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                }
            }

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun TabSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.GridOn,
                contentDescription = "Grid",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.VideoLibrary,
                contentDescription = "Reels",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Tagged",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun PostsGrid() {
    // Sample posts data
    val posts = listOf(
        PostItem(R.drawable.my_profile, isReel = false),
        PostItem(R.drawable.my_profile, isReel = false),
        PostItem(R.drawable.my_profile, isReel = true),
        PostItem(R.drawable.my_profile, isReel = true),
        PostItem(R.drawable.my_profile, isReel = false),
        PostItem(R.drawable.my_profile, isReel = false)
    )

    Column {
        posts.chunked(3).forEach { rowPosts ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                rowPosts.forEach { post ->
                    PostGridItem(post, modifier = Modifier.weight(1f))
                }
                // Fill remaining space if less than 3 items
                repeat(3 - rowPosts.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

data class PostItem(
    val imageRes: Int,
    val isReel: Boolean = false
)

@Composable
fun PostGridItem(post: PostItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        Image(
            painter = painterResource(id = post.imageRes),
            contentDescription = "Post",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Reel icon overlay
        if (post.isReel) {
            Icon(
                imageVector = Icons.Default.VideoLibrary,
                contentDescription = "Reel",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp)
                    .size(20.dp)
            )
        }
    }
}

@Composable
fun ProfileInfoSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Picture with Story Ring
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.my_profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF262626), CircleShape)
            )
        }

        Spacer(modifier = Modifier.width(24.dp))

        // Stats
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProfileStat("5", "postingan")
            ProfileStat("108", "pengikut")
            ProfileStat("186", "mengikuti")
        }
    }
}

@Composable
fun ProfileStat(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = label,
            color = Color.White,
            fontSize = 13.sp
        )
    }
}

@Composable
fun BioSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Stiven Sitanggang",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Calisthenics",
            color = Color.White,
            fontSize = 14.sp
        )
    }
}

@Composable
fun DashboardCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Dasboard Anda",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "416 tayangan dalam 30 hari terakhir",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = {},
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF262626)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Edit profil", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
        }

        Button(
            onClick = {},
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF262626)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Bagikan profil", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
        }

        Button(
            onClick = {},
            modifier = Modifier.size(42.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF262626)),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PersonAdd,
                contentDescription = "Add Person",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun TemukanOrangSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Temukan orang",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = "Lihat semua",
                color = Color(0xFF3897F0),
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                listOf(
                    SuggestedUser("sevrilll_77", "Dikuti oleh ymusofa + 10 lainnya", R.drawable.sevrilll_77),
                    SuggestedUser("ronald_siahaan_16", "Dikuti oleh sandra_davina", R.drawable.ronald_siahaan_16)
                )
            ) { user ->
                SuggestedUserCard(user)
            }
        }
    }
}

data class SuggestedUser(
    val username: String,
    val mutualInfo: String,
    val imageRes: Int
)

@Composable
fun SuggestedUserCard(user: SuggestedUser) {
    Card(
        modifier = Modifier.width(160.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.White,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.TopEnd)
                )
            }

            Image(
                painter = painterResource(id = user.imageRes),
                contentDescription = "User Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = user.username,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = user.mutualInfo,
                color = Color.Gray,
                fontSize = 11.sp,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0095F6)),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 6.dp)
            ) {
                Text(
                    text = "Ikuti",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}