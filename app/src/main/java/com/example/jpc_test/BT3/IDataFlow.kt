package com.example.jpc_test.BT3

interface IDataFlow {
    fun setEmail(email: String);
    fun getEmail() : String;

    fun setPassword(password: String);
    fun getPassword() : String;

    fun setConfirmPassword(pass : String)
    fun getConfirmPassword() : String;

    fun setNumber(num : String)
    fun getNumber() : String;

}