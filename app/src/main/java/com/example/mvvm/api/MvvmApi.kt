package com.example.mvvm.api
import com.example.mvvm.models.EmployeeDetails
import retrofit2.Response
import retrofit2.http.GET

interface MvvmApi {

    @GET("/v3/b/654380cf54105e766fca60f2?meta=false")
    suspend fun getEmployeeDetails() : Response<EmployeeDetails>
}