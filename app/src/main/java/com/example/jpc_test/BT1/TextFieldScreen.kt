package com.example.jpc_test.BT1

import android.os.Bundle
import android.preference.PreferenceActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.*
import androidx.compose.foundation.layout.*

import androidx.compose.ui.text.*
import androidx.compose.ui.res.*
import coil.compose.*
import androidx.compose.ui.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController

//---BT----//
import com.example.jpc_test.BT1.WelcomeScreen
import com.example.jpc_test.BT1.UIComponentsScreen
import com.example.jpc_test.BT1.HeaderAppBar
import com.example.jpc_test.BT1.ImagesScreen
import com.example.jpc_test.BT1.TextDetailScreen

@Composable
fun TextFieldScreen(navController : NavController) {
    Scaffold(
        topBar = {
            HeaderAppBar(
                onBackClick = { navController.popBackStack() },
                title = "TextField"
            )
        }
    ) { innerPadding ->

        var text by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Thông tin nhập") },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = if (text.isEmpty()) "Tự động cập nhật dữ liệu theo textfield" else text,
                color = Color(0xFFD32F2F),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}