package com.kathayat.login

import retrofit2.Call
import retrofit2.http.*

interface RetroService {

    @GET("users")
    @Headers("Accept:application/json\",\"Content-Type:application/json")
    fun getUserList(): Call<UserList>

    @GET("users")
    @Headers("Accept:application/json\",\"Content-Type:application/json")
    fun searchUsers(@Query("name") searchText:String):Call<UserList>

    @GET("users{user_id}")
    @Headers("Accept:application/json\",\"Content-Type:application/json")
    fun getUser(@Path("user_id") user_id:String):Call<UserList>

    @POST("users")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer 8639a5b110bd95c040314b3e4cb4dde948e8c72d708999860e307fa860c16dd4")
    fun createUser(@Body params: User): Call<UserResponse>

    @PATCH("users/{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer 8639a5b110bd95c040314b3e4cb4dde948e8c72d708999860e307fa860c16dd4")
    fun updateUser(@Path("user_id") user_id:String,@Body params: User): Call<UserResponse>

    @DELETE("users/{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer 8639a5b110bd95c040314b3e4cb4dde948e8c72d708999860e307fa860c16dd4")
    fun deleteUser(@Path("user_id") user_id:String): Call<UserResponse>

}