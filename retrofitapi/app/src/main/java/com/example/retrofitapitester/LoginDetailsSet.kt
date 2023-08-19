package com.example.retrofitapitester

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.retrofitapitester.databinding.ActivityLoginDetailsSetBinding


class LoginDetailsSet : AppCompatActivity() {
    lateinit var ldbinding: ActivityLoginDetailsSetBinding
    private val PERMISSIONS_REQUEST_CODE = 123
    private val PERMISSIONS_REQUEST_CODEE = 123


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ldbinding = ActivityLoginDetailsSetBinding.inflate(layoutInflater)
        setContentView(ldbinding.root)

        initview()
        logout()
    }

    private fun logout() {

        ldbinding.btnLogout.setOnClickListener {

            val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()


            var intent = Intent(this, LoginActivityy::class.java)
            startActivity(intent)
            finish()


        }


    }

    private fun initview() {


//        val token = intent.getStringExtra("token")
//        val id = intent.getStringExtra("id")
//        val email = intent.getStringExtra("email")
//        val gender = intent.getStringExtra("gender")
//        val fname = intent.getStringExtra("fname")
//        val lname = intent.getStringExtra("lname")
//        val username = intent.getStringExtra("username")


        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        var image = sharedPreferences.getString("image", " ")

        Glide.with(this).load("$image").placeholder(R.drawable.error_show).into(ldbinding.imageView)
        ldbinding.userName.text = sharedPreferences.getString("username", " ")
        ldbinding.gmail.text = sharedPreferences.getString("gmail", " ")
        ldbinding.gender.text = sharedPreferences.getString("gender", " ")
        ldbinding.fName.text = sharedPreferences.getString("fName", " ")
        ldbinding.lName.text = sharedPreferences.getString("lName", " ")
        ldbinding.token.text = sharedPreferences.getString("token", " ")


//        ldbinding.token.text = "Token Name:-$token"
//        ldbinding.id.text = "id is:-$id"
//        ldbinding.gmail.text = "gmail is:-$email"
//        ldbinding.gender.text = "gender is:-$gender"
//        ldbinding.fName.text = "First Name:-$fname"
//        ldbinding.lName.text = "Last Name:-$lname"
//        ldbinding.userName.text = "UserName:-$username"


//
//
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.)
//            == PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(this, "Permission is already granted", Toast.LENGTH_SHORT).show()
//            // Permission is already granted
//        } else {
//            // Permission is not granted
//            Toast.makeText(this, "Permission is not granted", Toast.LENGTH_SHORT).show()
//
//        }
//
//
//
//        ActivityCompat.requestPermissions(this,
//            arrayOf(Manifest.permission.CAMERA), 100)
//
//
//
//


        ldbinding.btnStorage.setOnClickListener {
            performAction()
        }


        ldbinding.btnCamera.setOnClickListener {
            performActionCam()
        }

    }


    private fun performAction() {
        if (checkPermissions()) {
        } else {
            requestPermissions()
        }
    }


    private fun checkPermissions(): Boolean {
        val permissions = arrayOf(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
        )
        val permissionState = ContextCompat.checkSelfPermission(this, permissions.toString())

        return permissionState == PackageManager.PERMISSION_GRANTED
    }


    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            PERMISSIONS_REQUEST_CODE
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    this,
                    " Permission granted, perform the action that requires the permission",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Permission denied, show a message to the user or take appropriate action",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    ////////////////////////////////////////


    private fun performActionCam() {
        if (checkPermissionsCam()) {
        } else {
            requestPermissionsCam()
        }
    }


    private fun checkPermissionsCam(): Boolean {
        val permissions = arrayOf(
            android.Manifest.permission.CAMERA
        )
        val permissionState = ContextCompat.checkSelfPermission(this, permissions.toString())

        return permissionState == PackageManager.PERMISSION_GRANTED
    }


    private fun requestPermissionsCam() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(

                android.Manifest.permission.CAMERA
            ),
            PERMISSIONS_REQUEST_CODEE
        )
    }





}