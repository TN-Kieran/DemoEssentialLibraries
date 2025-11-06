package com.example.jpc_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.jpc_test.BT1.HeaderAppBar
import com.example.jpc_test.BT3.ConfirmScreen
import com.example.jpc_test.BT3.CreateNewPasswordScreen
import com.example.jpc_test.BT3.DataFlow
import com.example.jpc_test.BT3.ForgetPasswordScreen
import com.example.jpc_test.BT3.VerifyCodeScreen
import com.example.jpc_test.BT4.ProfileScreen
import com.example.jpc_test.BT4.UserViewModel
import com.example.jpc_test.BT4.WelcomeScreen
import com.example.jpc_test.thuyettrinh.CatApiService
import com.example.jpc_test.thuyettrinh.CatImage
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class MainActivity : ComponentActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var catImages by remember { mutableStateOf<List<CatImage>>(emptyList()) }
            var errorMessage by remember { mutableStateOf<String?>(null) }

            LaunchedEffect(Unit) {
                val api = CatApiService()
                withContext(Dispatchers.IO) {
                    try {
                        catImages = api.searchImages(10)
                    } catch (e: Exception) {
                        errorMessage = e.toString()
                    }
                }
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                if (errorMessage != null) {
                    Text("Lỗi: $errorMessage")
                } else if (catImages.isEmpty()) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text("Đang tải ảnh mèo...")
                    }
                } else {
                    CatGallery(catImages)
                }
            }
        }
    }
}


@Composable
fun ServerResponse(contents: String, modifier: Modifier = Modifier) {
    Text(
        text = contents,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun CatGallery(cats: List<CatImage>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(cats) { cat ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                AsyncImage(
                    model = cat.url,
                    contentDescription = "Secret Cat Agent",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                )
            }
        }
    }
}
















@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    val viewModel: DataFlow = viewModel()

    NavHost(
        navController = navController,
        startDestination = "forget_password" // Đặt màn hình bắt đầu là "onboarding"
    ) {
        composable("forget_password") {
            ForgetPasswordScreen(
                viewModel = viewModel,
                onNextClick = { navController.navigate("verify_code") }
            )
        }

        composable("verify_code") {
            VerifyCodeScreen(
                viewModel = viewModel,
                onNextClick = { navController.navigate("create_new_password") },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("create_new_password") {
            CreateNewPasswordScreen(
                viewModel = viewModel,
                onNextClick = { navController.navigate("confirm") },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("confirm") {
            ConfirmScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onSubmitClick = {navController.navigate("forget_password")}
            )
        }
    }
}
