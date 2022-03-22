package com.kathayat.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kathayat.login.databinding.ActivityCreateUserBinding

class CreateUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreateUserBinding
    lateinit var viewModel: NewUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        createUserObservable()
        binding.buttonCreate.setOnClickListener {
            createUser()
        }


    }

    private fun createUser() {
        val user = User("",binding.editTextName.text.toString(),binding.editTextEmail.text.toString(), "male","Active")

        viewModel.createUser(user)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(NewUserViewModel::class.java)

    }
    private fun createUserObservable() {
        viewModel.getCreateNewUserObserver().observe(this, Observer<UserResponse?> {
            if (it==null) {
                Toast.makeText(this,"No Result Found", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Successfully created user", Toast.LENGTH_SHORT).show()
                finish()
            }

        })
    }
}