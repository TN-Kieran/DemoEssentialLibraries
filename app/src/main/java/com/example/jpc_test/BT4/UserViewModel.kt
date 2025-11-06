package com.example.jpc_test.BT4

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

data class UserData(
    val name: String = "",
    val email: String = "",
    val photoUrl: String? = null,
    val birthDate: String = ""
)

class UserViewModel : ViewModel() {
    var user by mutableStateOf(UserData())
        private set

    fun updateUser(name: String, email: String, photoUrl: String?) {
        user = user.copy(name = name, email = email, photoUrl = photoUrl)
    }

    fun updateBirthDate(date: String) {
        user = user.copy(birthDate = date)
    }
}
