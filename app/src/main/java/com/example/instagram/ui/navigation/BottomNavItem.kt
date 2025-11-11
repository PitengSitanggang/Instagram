package com.example.instagram.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Search : BottomNavItem("search", Icons.Default.Search, "Search")
    object AddPost : BottomNavItem("add_post", Icons.Default.Add, "Add")
    object Reels : BottomNavItem("reels", Icons.Default.PlayArrow, "Reels")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Search,
    BottomNavItem.AddPost,
    BottomNavItem.Reels,
    BottomNavItem.Profile
)