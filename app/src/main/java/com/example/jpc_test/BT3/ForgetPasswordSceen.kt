package com.example.jpc_test.BT3

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
import androidx.compose.foundation.*

import androidx.compose.ui.text.*
import androidx.compose.ui.res.*
import coil.compose.*
import androidx.compose.ui.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jpc_test.BT1.DetailScreen
import com.example.jpc_test.BT1.HeaderAppBar
import com.example.jpc_test.R

@Composable
fun ForgetPasswordScreen(
    viewModel: DataFlow,
    onNextClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf(viewModel.email) }

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                // Logo UTH
                Image(
                    painter = painterResource(id = R.drawable.uth_logo), // thêm ảnh vào res/drawable
                    contentDescription = "UTH Logo",
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .padding(bottom = 12.dp)
                )

                // Tên app
                Text(
                    text = "SmartTasks",
                    color = Color(0xFF007BFF),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Tiêu đề
                Text(
                    text = "Forget Password?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Hướng dẫn
                Text(
                    text = "Enter your Email, we will send you a verification code.",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Ô nhập email
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        viewModel.email = it
                    },
                    placeholder = { Text("Your Email") },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email, // biểu tượng email
                            contentDescription = null
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Nút Next
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E90FF)),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Next", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}

@Preview
@Composable
fun ForgetPasswordScreenPreview() {
     ForgetPasswordScreen(
         viewModel = TODO(),
         onNextClick = TODO()
     )
}