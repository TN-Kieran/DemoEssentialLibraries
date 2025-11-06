package com.example.jpc_test.BT2

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
import androidx.compose.runtime.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
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
import com.example.jpc_test.BT1.DetailScreen
import com.example.jpc_test.BT1.HeaderAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryScreen() {
    // Tạo instance OOP
    val manager = remember { LibraryManager() }

    // State quản lý Compose
    var studentName by remember { mutableStateOf(manager.getStudentName()) }
    var books by remember { mutableStateOf(manager.getAllBooks()) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Hệ thống\nQuản lý Thư viện",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(50.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Home, contentDescription = "Quản lý")
                    Icon(Icons.Default.List, contentDescription = "DS Sách", tint = Color.Gray)
                    Icon(Icons.Default.Person, contentDescription = "Sinh viên", tint = Color.Gray)
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(20.dp))

            // Khối sinh viên
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = studentName,
                    onValueChange = { studentName = it },
                    label = { Text("Sinh viên") },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(8.dp))

                Button(onClick = {
                    manager.updateStudentName(studentName)
                }) {
                    Text("Thay đổi")
                }
            }

            Spacer(Modifier.height(20.dp))

            // Danh sách sách
            Text("Danh sách sách", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(10.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFEAEAEA))
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    books.forEach { book ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White)
                                .clickable {
                                    manager.getSelectedBooks()
                                    books = manager.getAllBooks()
                                }
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = book.isSelected,
                                onCheckedChange = {
                                    manager.getSelectedBooks()
                                    books = manager.getAllBooks()
                                }
                            )
                            Text(book.title, fontSize = 16.sp)
                        }
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            // Nút thêm
            Button(onClick = {
                val selected = manager.getSelectedBooks()
                println("Sách đã chọn: ${selected.joinToString { it.title }}")
            }) {
                Text("Thêm")
            }

            Spacer(Modifier.height(40.dp))

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LibraryScreenPreview() {
    LibraryScreen()
}