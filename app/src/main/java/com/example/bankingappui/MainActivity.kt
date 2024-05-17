package com.example.bankingappui

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingappui.ui.theme.BankingAppUITheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppUITheme {
                // A surface container using the 'background' color from the theme
                //jo bg ka color h vo set hojaega isse
                SetBarColor(color = MaterialTheme.colors.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                        HomeScreen()
                            //called homescreen here
                }
            }
        }
    }

    @Composable
    private fun SetBarColor(color: androidx.compose.ui.graphics.Color)
    {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen()
{
    //we use scaffold here which helps in putting componenets in proper places like bottom navigation
    Scaffold(
        bottomBar = {
           BottomNavigationBar()
        }
    ) {
        //putted everything in a column for designing
        padding->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            WalletSection()
            CardSection()
            Spacer(modifier = Modifier.height(16.dp))
            //spacer puts a space between activities
            FinanceSection()
            CurrenciesSection()
        }

    }
}