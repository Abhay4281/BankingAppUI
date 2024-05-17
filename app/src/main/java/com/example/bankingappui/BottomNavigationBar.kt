package com.example.bankingappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bankingappui.data.BottomNavigation
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.tooling.preview.Preview

//bottom navigation bar contains list of item on the bottom of screen
//listof contains immutable list of elements

val items = listOf(
  BottomNavigation(
      title = "Home",
      icon = Icons.Rounded.Home
  ),
    BottomNavigation(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),

    BottomNavigation(
        title = "Notifications",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigation(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    )
)

@Preview
@Composable
fun BottomNavigationBar()
{
    NavigationBar {
       Row(modifier = Modifier.background(MaterialTheme.colors.primaryVariant))
       {
             items.forEachIndexed { index, item ->
                 NavigationBarItem(
                     selected = index == 0, //as we are not navigating any where we kept index == 0
                     onClick = {  },// we are not going anywhere se we kept it empty
                     icon= {
                         Icon(
                             imageVector = item.icon,
                             contentDescription = item.title,
                             tint = MaterialTheme.colors.onBackground
                         )

                     },
                     label = {
                         Text(text = item.title,
                         color = MaterialTheme.colors.onBackground)
                     }
                 )
             }
        }
       }
    }
