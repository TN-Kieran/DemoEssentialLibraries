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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jpc_test.R

@Composable
fun ImagesScreen(navController : NavController){
    Scaffold(
        topBar = {
            HeaderAppBar(
                onBackClick = { navController.popBackStack() },
                title = "Images"
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
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .shadow(elevation = 5.dp, shape = MaterialTheme.shapes.large),
                shape = MaterialTheme.shapes.large
            ) {
                Image(
                    painter = painterResource(id = com.example.jpc_test.R.drawable.school),
                    contentDescription = "Local image",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = "https://giaothongvantaihochcm.edu.vn/wp-content/uploads/2025/01/Logo-GTVT.png",
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .shadow(elevation = 5.dp, shape = MaterialTheme.shapes.large).height(200.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shool2),
                    contentDescription = "Local image",
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = "In app",
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

        }
    }
}