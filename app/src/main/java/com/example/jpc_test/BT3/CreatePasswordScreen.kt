package com.example.jpc_test.BT3

import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpc_test.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNewPasswordScreen(
    viewModel: DataFlow,
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {}
) {
    // Lấy giá trị trực tiếp từ thuộc tính của viewModel
    var password by remember { mutableStateOf(viewModel.password) }
    var confirmPassword by remember { mutableStateOf(viewModel.confirmPassword) }

    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 4.dp, bottom = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .clickable { onBackClick() }
                                .padding(6.dp),
                            tint = Color(0xFF1E90FF)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
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
                    painter = painterResource(id = R.drawable.uth_logo),
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
                    text = "Create new password",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Mô tả
                Text(
                    text = "Your new password must be different from previously used password",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Ô nhập Password
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        // Gán giá trị trực tiếp cho thuộc tính của viewModel
                        viewModel.password = it
                    },
                    placeholder = { Text("Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Lock Icon"
                        )
                    },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth() // Bỏ chiều cao cố định
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Ô nhập Confirm Password
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = {
                        confirmPassword = it
                        // Gán giá trị trực tiếp cho thuộc tính của viewModel
                        viewModel.confirmPassword = it
                    },
                    placeholder = { Text("Confirm Password") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Lock Icon"
                        )
                    },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth() // Bỏ chiều cao cố định
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Nút Next
                Button(
                    onClick = { onNextClick() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E90FF)),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Next", fontSize = 16.sp, color = Color.White)
                }

                Column {
                    if (viewModel.password.isNotEmpty() && viewModel.email.isNotEmpty()) {
                        Text("Email: ${viewModel.email}")
                        Text("Password: ${viewModel.password}")
                        // Sửa để hiển thị đúng confirmPassword
                        Text("Confirm Password: ${viewModel.confirmPassword}")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateNewPasswordScreenPreview() {
    CreateNewPasswordScreen(
        viewModel = TODO(),
        onBackClick = TODO(),
        onNextClick = TODO()
    )
}
