package com.example.retrofitapitester

import com.musict.dummyapitestingactivity.ProductResponce
import com.musict.dummyapitestingactivity.ProductsItem
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/products")
    fun getAllProduct(): Call<ProductResponce<Any?>>

    @GET("products/{id}")
    fun getdetails(
        @Path("id") id:Int
    ) : Call<ProductsItem>

    @GET("/products/search")
    fun getSearchProduct(
        @Query("q") searchText:String
    ): Call<ProductResponce<ProductsItem>>

    @FormUrlEncoded
    @POST("auth/login")
    fun getLoginDetalils(@Field("username")username : String,@Field("password")password : String) :Call<LoginResponse>

}