package com.example.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.ui.theme.*


val cards = listOf(

    Card(
        cardType = "VISA",
        cardNumber = "3333 4444 5555 6666",
        cardName = "Business",
        balance = 46.457,
        color = getGradient(PurpleStart, PurpleEnd),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "5555 4544 5655 6866",
        cardName = "Savings",
        balance = 64.456,
        color = getGradient(BlueStart, BlueEnd),
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2222 8244 5535 1666",
        cardName = "School",
        balance = 3.467,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "3333 6666 5885 6565",
        cardName = "Trips",
        balance = 26.455,
        color = getGradient(GreenStart, GreenEnd),
    )

)


fun getGradient(
    startColor: Color,
    endColor:Color
):Brush
{
    return Brush.horizontalGradient(colors = listOf(startColor,endColor))
}


@Preview
@Composable
fun CardSection()
{//lazy row is like a recyclerview works horizontally basically helps in horizontall scrolling
    LazyRow{
        items(cards.size)  //items here works as an forloop will do a compossable func till the number of cards
        {
            index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(  index : Int)
{
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size-1)
    {
        lastItemPaddingEnd == 16.dp
    }

    var image = painterResource(id = R.drawable.visa)
    if(card.cardType=="MASTER CARD")
    {
        image =  painterResource(id = R.drawable.mastercard)
    }

    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)
    )
    {
        Column (modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .background(card.color)
            .width(250.dp)
            .height(160.dp)
            .clickable { },
            verticalArrangement = Arrangement.SpaceBetween
        ){
           Image(painter = image,
               contentDescription = card.cardName,
               modifier=Modifier.width(60.dp))
            
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardName,
            color = Color.White,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}