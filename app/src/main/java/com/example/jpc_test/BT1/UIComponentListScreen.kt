package com.example.jpc_test.BT1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpc_test.ui.theme.JPC_TestTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jpc_test.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UIComponentsScreen(navController : NavController) {
    Scaffold(
        topBar = {
            HeaderAppBar(
                onBackClick = { navController.popBackStack() },
                title = "UI Components List"
            )
        }
    ){innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(50.dp)
            ) {

                Column (
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Display",fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    ComposeButton(
                        title = "Text",
                        text = "Displays text",
                        color =  Color(0xFF95CFFF),
                        onClickButton = {navController.navigate("textDetailScreen")}
                    )
                    ComposeButton(
                        title = "Image",
                        text = "Displays an image",
                        color =  Color(0xFF95CFFF),
                        onClickButton = {navController.navigate("imagesScreen")}
                    )
                }

                Column (
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Input",fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    ComposeButton(
                        title = "TextField",
                        text = "Input field for text",
                        color =  Color(0xFF95CFFF),
                        onClickButton = {navController.navigate("textFieldScreen")}
                    )
                    ComposeButton(
                        title = "PasswordField",
                        text = "Input field for passwords",
                        color =  Color(0xFF95CFFF),
                        onClickButton = {}
                    )
                }

                Column (
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Layout",fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    ComposeButton(
                        title = "Column",
                        text = "Arranges elements vertically",
                        color =  Color(0xFF95CFFF),
                        onClickButton = {}
                    )
                    ComposeButton(
                        title = "Row",
                        text = "Arranges elements horizontally",
                        color =  Color(0xFF95CFFF),
                        onClickButton = {navController.navigate("rowLayoutScreen")}
                    )
                    ComposeButton(
                        title = "Tự tìm hiểu",
                        text = "Tìm ra tất cả các thành phần UI Cơ bản",
                        color =  Color(0xFFFF9595),
                        onClickButton = {}
                    )
                }

            }

        }
    }
}

