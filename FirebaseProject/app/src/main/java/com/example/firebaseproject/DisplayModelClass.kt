package com.example.firebaseproject

class DisplayModelClass {


    lateinit var  id : String
    lateinit var  name : String
    lateinit var  phoneNum : String
    lateinit var  fee : String


    constructor(id:String,firstName:String,mobileNumber: String,fees:String){

        this.id = id
        this.name = firstName
        this.phoneNum = mobileNumber
        this.fee = fees

    }


    constructor(){


    }
}