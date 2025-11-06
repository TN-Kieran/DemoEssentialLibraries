package com.example.jpc_test.BT1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RowLayoutScreen(navController : NavController) {
    Scaffold(
        topBar = {
            HeaderAppBar(
                onBackClick = { navController.popBackStack() },
                title = "Row Layout"
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(4) { rowIndex ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).background(color = Color(
                        0xFFE8E8E8
                    )
                    )
                ) {
                    for (colIndex in 0 until 3) {
                        val color =
                            if (colIndex == 1) Color(0xFF2A73FF) else Color(0xFF9CC9FF)

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(2f)
                                .padding(2.dp)
                                .background(
                                    color = color,
                                    shape = RoundedCornerShape(12.dp)
                                )
                        )
                    }
                }
            }
        }
    }
}
