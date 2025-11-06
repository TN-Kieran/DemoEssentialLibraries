package com.example.jpc_test.BT1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ComposeButton(
    title: String,
    text: String,
    color: Color,
    onClickButton: () -> Unit,
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        //contentPadding = PaddingValues(0.dp),
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth(),
        onClick = onClickButton
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(title,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(text,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }

    }
}