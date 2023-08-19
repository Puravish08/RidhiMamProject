package com.example.retrofitapitester

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapitester.databinding.ActivityLoginActivityyBinding
import com.example.retrofitapitester.databinding.DialogProgressbarBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.musict.dummyapitestingactivity.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class LoginActivityy : AppCompatActivity() {


    private var apiInterface: ApiInterface? = null
    private lateinit var binding: ActivityLoginActivityyBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginActivityyBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        initView()
        firebase()

    }

    @SuppressLint("SuspiciousIndentation")
    private fun firebase() {


        // Initialize Firebase Auth
        auth = Firebase.auth



//        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
//        if (sharedPreferences.getBoolean("isLogin", false) == true) {
//            binding.txtlogin.setOnClickListener {
//
//                var intent = Intent(this, SigninActivity::class.java)
//                startActivity(intent)
//
//            }


        binding.btnregister.setOnClickListener {


            var email = binding.email.text.toString().trim()
            var password = binding.password.text.toString().trim()



                if (email.isEmpty()) {

                    Toast.makeText(this, "Email is empty.", Toast.LENGTH_SHORT).show()

                } else if (password.isEmpty()) {

                    Toast.makeText(this, "Password is empty.", Toast.LENGTH_SHORT).show()

                } else {

                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "Authentication Success ", Toast.LENGTH_SHORT).show()
                    }
                            val user = auth.currentUser
                            updateUI(user)

                }.addOnFailureListener {

                    Toast.makeText(baseContext,"Wrong  Enter", Toast.LENGTH_SHORT).show()
//                            updateUI(null)

                }



                    val  intent = Intent(this, SigninActivity::class.java)
                    startActivity(intent)

                }

            binding.loginbutton.setOnClickListener {


                var s = Intent(this@LoginActivityy, SigninActivity::class.java)
                startActivity(s)

            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {

       val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)


    }


//    private fun initView() {
//
//        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
//        if (sharedPreferences.getBoolean("isLogin", false) == true) {
//
//            var i = Intent(this, LoginDetailsSet::class.java)
//            startActivity(i)
//            finish()
//
//        }










//        val editor = sharedPreferences.edit()
//
//        editor.putString("username", "kminchelle")
//        editor.putString("password", "0lelplR")
//        editor.putBoolean("rememberMe", true)
//
//        editor.commit()

//
//        val username = sharedPreferences.getString("username", "")
//        val password = sharedPreferences.getString("password", "")
//        val rememberMe = sharedPreferences.getBoolean("rememberMe", false)
//
//// Populate the EditText fields with retrieved data
//
//// Populate the EditText fields with retrieved data
//        binding.email.setText(username)
//
//        binding.password.setText(password)
//
//        binding.chkremember.isChecked = rememberMe


//
//        val username: String = binding.name.getText().toString()
//        val passworduser: String = binding.password.getText().toString()
//
//
//
//        val name = sharedPreferences.getString("username", "kminchelle")
//        val password = sharedPreferences.getString("passowrd", "0lelplR")


//
//        binding.chkremember.setOnClickListener {
//
//
//           val name = sharedPreferences.getString("username", "kminchelle")
//           val password = sharedPreferences.getString("passowrd", "0lelplR")
//
//
//            binding.name.setText(name)
//            binding.password.setText(password)
//
//
//        }



//        binding.btndetaliset.setOnClickListener {
//
//
////            if (binding.chkremember.isChecked){
////
////                sharedPreferences.edit().putString("username", name).apply()
////                sharedPreferences.edit().putString("password", password).apply()
////                sharedPreferences.edit().putBoolean("isLogin",binding.chkremember.isChecked).apply()
////            }
////            else
////            {
////
////                sharedPreferences.edit().putString("username", "")
////                sharedPreferences.edit().putString("password", "")
////                sharedPreferences.edit().putBoolean("isLogin", false)
////
////                Toast.makeText(this, "Login Fail Please Try Again.", Toast.LENGTH_SHORT).show()
////            }
//
//
//            var dialog = Dialog(this)
//
//            var dialogProgressbarBinding = DialogProgressbarBinding.inflate(layoutInflater)
//            dialog.setContentView(dialogProgressbarBinding.root)
//            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            dialog.window?.setLayout(
//
//
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
//            dialog.show()
//
//
//            val userName = binding.email.text.toString()
//            val password = binding.password.text.toString()
//
//
//
//            if (userName.isEmpty()) {
//                Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show()
//            } else if (password.isEmpty()) {
//                Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show()
//            } else {
//                apiInterface = Apiclient.getClient()?.create(ApiInterface::class.java)
//                apiInterface?.getLoginDetalils(userName, password)
//                    ?.enqueue(object : Callback<LoginResponse> {
//
//                        override fun onResponse(
//                            call: Call<LoginResponse>,
//                            response: Response<LoginResponse>
//                        ) {
//
//                            if (response.isSuccessful) {
//                                val token = response.body()?.token
//                                val id = response.body()?.id
//                                val email = response.body()?.email
//                                val gender = response.body()?.gender
//                                val fname = response.body()?.firstName
//                                val lname = response.body()?.lastName
//                                val username = response.body()?.username
//                                val image = response.body()?.image
//
//
//                                val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
//
//                                myEdit.putBoolean("isLogin", true)
//                                myEdit.putString("username", userName)
//                                myEdit.putString("fname", fname)
//                                myEdit.putString("lname", lname)
//                                myEdit.putString("gender", gender)
//                                myEdit.putString("image", image)
//                                myEdit.putString("email", email)
//                                myEdit.commit()
//
//
//                                val intent = Intent(this@LoginActivityy, MainActivity::class.java)
//                                startActivity(intent)
//                                dialog.dismiss()
//                                finish()
//
//
//                                var i = Intent(this@LoginActivityy, LoginDetailsSet::class.java)
//
//                                intent.putExtra("token", token)
//                                intent.putExtra("id", id)
//                                intent.putExtra("email", email)
//                                intent.putExtra("gender", gender)
//                                intent.putExtra("fname", fname)
//                                intent.putExtra("lname", lname)
//                                intent.putExtra("username", username)
//                                intent.putExtra("image", image)
//
//                                Toast.makeText(this@LoginActivityy, "Login Successfully", Toast.LENGTH_SHORT).show()
//
//                                startActivity(i)
//                                dialog.dismiss()
//                                finish()
//
////                                myEdit.commit()
//
//                            } else {
//                                Toast.makeText(
//                                    this@LoginActivityy,
//                                    "invalid Email and Password",
//                                    Toast.LENGTH_SHORT
//                                )
//                                    .show()
//                            }
//
//                        }
//
//                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//
//                        }
//                    })
//            }
//
//
//
//
//
//
//
//        }
//    }
}