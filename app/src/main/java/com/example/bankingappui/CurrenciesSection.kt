package com.example.bankingappui

import android.graphics.drawable.Icon
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankingappui.data.Currency
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        name = "USD",
        buy = 23.35f,
        sell= 23.25f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "EURO",
        buy = 13.35f,
        sell= 13.25f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 13.65f,
        sell= 13.25f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "IND",
        buy = 63.35f,
        sell= 53.25f,
        icon = Icons.Rounded.CurrencyRupee
    ),
    Currency(
        name = "EURO",
        buy = 43.35f,
        sell= 33.25f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN",
        buy = 93.35f,
        sell= 63.25f,
        icon = Icons.Rounded.CurrencyYen
    ),
)


@Preview
@Composable
fun CurrenciesSection()
{
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp),
    contentAlignment = Alignment.BottomCenter
    ) {

        Column(modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colors.primaryVariant)
            .animateContentSize())//will animate any change in the size of column
        {
          Row(
              modifier = Modifier
                  .padding(16.dp)
                  .animateContentSize()
                  .fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically
          ) {
              Box(modifier = Modifier
                  .clip(CircleShape)
                  .background(MaterialTheme.colors.secondary)
                  .clickable {  //expand and collapse the currenccy section
                      isVisible = !isVisible
                      iconState = if (isVisible) {
                          Icons.Rounded.KeyboardArrowUp
                      } else {
                          Icons.Rounded.KeyboardArrowDown
                      }
                  }
              )
              {
                  Icon(
                      modifier = Modifier.size(25.dp),
                      imageVector = iconState,
                      contentDescription = "Currencies",
                      tint = MaterialTheme.colors.onSecondary
                  )

              }
              
              Spacer(modifier = Modifier.width(25.dp))

              Text(text = "Currencies", 
                  fontSize = 25.sp,
                  color = MaterialTheme.colors.onSecondary,
                  fontWeight = FontWeight.Bold)

          }
            Spacer(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary) )

            if(isVisible)
            {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(
                            RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                        )
                        .background(MaterialTheme.colors.secondary)
                ) {
                    val boxWidthConstraints = this
                    val width = boxWidthConstraints.maxWidth/3
                    
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)) {

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(modifier= Modifier.fillMaxWidth()) {

                            Text(modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                            color=MaterialTheme.colors.onBackground)

                            Text(modifier = Modifier.width(width),
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color=MaterialTheme.colors.onBackground,
                            textAlign = TextAlign.End)

                            Text(modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color=MaterialTheme.colors.onBackground,
                            textAlign = TextAlign.End)

                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        LazyColumn{
                            items(currencies.size)
                            {
                                index ->
                                CurrencyItem(
                                    index = index,
                                    width =width
                                )
                            }
                        }
                    }
                }
            }

        }

    }

}
@Composable
fun CurrencyItem(index:Int,width: Dp)
{
       val currency = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(4.dp)
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = currency.icon,
                contentDescription = currency.name,
                tint = Color.White
            )
        }
        Text(modifier = Modifier.padding(start = 10.dp),
            text = currency.name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color=MaterialTheme.colors.onBackground
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$ ${currency.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.End
        )
    }

}