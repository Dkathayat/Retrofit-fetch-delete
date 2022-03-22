package com.kathayat.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kathayat.login.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var recylerViewAdapater: RecylerViewAdapater
    lateinit var viewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecylerView()
        initViewModel()
        searchUser()

        binding.createUserButton.setOnClickListener {
            startActivity(Intent(this@MainActivity,CreateUserActivity::class.java))
        }


    }

    private fun searchUser() {
        binding.searchButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.searchEditText.text.toString())) {
                viewModel.searchUser(binding.searchEditText.text.toString())
            }else { viewModel.getUserList() }
        }
    }

    private fun initRecylerView() {
        binding.recylerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recylerViewAdapater = RecylerViewAdapater()
            adapter = recylerViewAdapater


        }
    }

    fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getUserListObservable().observe(this, Observer<UserList> {

            if (it==null) {
                Toast.makeText(this,"No Result Found",Toast.LENGTH_SHORT).show()
            }else {
                recylerViewAdapater.userList = it.data.toMutableList()
                recylerViewAdapater.notifyDataSetChanged()
            }

        })
        viewModel.getUserList()
    }
}