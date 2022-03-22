package com.kathayat.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    lateinit var recylerListData: MutableLiveData<UserList>


    init {
        recylerListData = MutableLiveData()
    }
    fun getUserListObservable(): MutableLiveData<UserList> {
        return recylerListData
    }
    fun getUserList() {
        val retroInstance = RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.getUserList()
        call.enqueue(object : Callback<UserList?> {
            override fun onResponse(call: Call<UserList?>, response: Response<UserList?>) {
                if (response.isSuccessful){
                    recylerListData.postValue(response.body())
                } else {

                }
            }

            override fun onFailure(call: Call<UserList?>, t: Throwable) {
                recylerListData.postValue(null)
            }
        })
    }
    fun searchUser(searchText:String) {
        val retroInstance = RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.searchUsers(searchText)
        call.enqueue(object : Callback<UserList?> {
            override fun onResponse(call: Call<UserList?>, response: Response<UserList?>) {
                if (response.isSuccessful){
                    recylerListData.postValue(response.body())
                } else {

                }
            }

            override fun onFailure(call: Call<UserList?>, t: Throwable) {
                recylerListData.postValue(null)

            }
        })
    }

}