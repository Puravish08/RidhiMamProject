package com.example.retrofitapitester

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitapitester.databinding.SignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.musict.dummyapitestingactivity.MainActivity

class SigninActivity : AppCompatActivity() {

    lateinit var binding : SignInBinding
    private lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()

        firebase()

    }

    @SuppressLint("SuspiciousIndentation")
    private fun firebase() {

        auth = Firebase.auth

        binding.btnLoginn.setOnClickListener {



            var email = binding.email.text.toString().trim()
            var password = binding.password.text.toString().trim()




                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "Authentication Success ", Toast.LENGTH_SHORT).show()
                    }
                    val user = auth.currentUser
                    updateUI()

                }.addOnFailureListener {

                    Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
//                    updateUI(null)
                }


        }



        binding.txtresister.setOnClickListener {
            val  intent = Intent(this, LoginActivityy::class.java)
            startActivity(intent)

        }


    }

    private fun updateUI() {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            updateUI()
        }
    }


    private fun initView() {











    }
}