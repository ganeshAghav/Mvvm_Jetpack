package com.example.mvvm.repository
import com.example.mvvm.api.MvvmApi
import com.example.mvvm.models.Employee
import com.example.mvvm.models.EmployeeDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MvvmRepository @Inject constructor(private val mvvmApi: MvvmApi) {

    private val _employeeObject= MutableStateFlow<List<Employee>>(emptyList())
    val employeeObject: StateFlow<List<Employee>>
        get()=_employeeObject

    suspend fun getEmployeeDetails(){
        val response=mvvmApi.getEmployeeDetails()

        if(response.isSuccessful && response.body()!=null){

            _employeeObject.emit(response.body()!!.employees)
        }
    }
}