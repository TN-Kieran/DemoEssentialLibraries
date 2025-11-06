package com.example.jpc_test.BT1

import android.os.Bundle
import android.preference.PreferenceActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextDetailScreen(navController : NavController){
    Scaffold(
        topBar = {
            HeaderAppBar(
                onBackClick = { navController.popBackStack() },
                title = "Text Detail"
            )
        }
    ){innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 2.dp,
                    )
                    .padding(20.dp),

                ){
                val styledText = buildAnnotatedString {
                    append("The ")

                    withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                        append("quick")
                    }

                    append("  ")

                    withStyle(style = SpanStyle(color = Color(0xFFB87333), fontWeight = FontWeight.Bold)) {
                        append("Brown\n")
                    }

                    append("fox ")

                    withStyle(style = SpanStyle(letterSpacing = 4.sp)) {
                        append("jumps ")
                    }

                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                        append("over\n")
                    }

                    withStyle(style = SpanStyle(
                        textDecoration = TextDecoration.Underline
                    )) {
                        append("the")
                    }

                    append(" ")

                    withStyle(style = SpanStyle(
                        fontStyle = FontStyle.Italic,
                    )) {
                        append("lazy ")
                    }

                    append("dog.")
                }
                Text(
                    text = styledText,
                    fontSize = 22.sp,
                    color = Color.Black
                )
            }
        }

    }
}