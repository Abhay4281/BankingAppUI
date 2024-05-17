package com.example.bankingappui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.ui.theme.BlueStart
import com.example.bankingappui.ui.theme.GreenStart
import com.example.bankingappui.ui.theme.OrangeStart
import com.example.bankingappui.ui.theme.PurpleStart


val financeList = listOf(
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    Finance(
        icon = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    Finance(
        icon = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),
    Finance(
        icon = Icons.Rounded.MonetizationOn,
        name = "My\nTransaction",
        background = GreenStart
    ),
)



@Preview
@Composable
fun FinanceSection()
{
  Column {
      Text(text = "Finance",
      fontSize = 24.sp,
      color = MaterialTheme.colors.onBackground,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(16.dp)
      )
      LazyRow{
          items(financeList.size)
          {
              FinanceItem(it)
          } //finance item takes index so we used "it" for it
      }
  }
}

@Composable
fun FinanceItem(index:Int)
{
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if(index == financeList.size-1)
    {
        lastPaddingEnd=16.dp
    }

Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd))
{
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colors.secondary)
            .size(120.dp)
            .clickable { }
            .padding(13.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .padding(6.dp)
                .background(finance.background)
        )
        {

            Icon(
                imageVector = finance.icon,
                contentDescription = finance.name,
                tint = Color.White
            )
        }

        Text(
            text = finance.name,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )


    }
}
}