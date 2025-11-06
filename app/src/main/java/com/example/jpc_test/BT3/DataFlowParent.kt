package com.example.jpc_test.BT3

open class DataFlowParent {
    open fun setConfirmPassword(pass : String){
        println("Confirm Password : $pass")
    }
    open fun getConfirmPassword(){
        return
    }

    open fun setNumber(num : String){
        println("Number : $num")
    }
    open fun getNumber(){
        return
    }
}