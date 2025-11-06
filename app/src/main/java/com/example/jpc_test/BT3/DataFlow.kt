package com.example.jpc_test.BT3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DataFlow : ViewModel() {
    var email: String by mutableStateOf("")
    var number: String by mutableStateOf("123456")
    var password: String by mutableStateOf("")
    var confirmPassword: String by mutableStateOf("")



}
