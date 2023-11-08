package com.example.mvvm.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.models.Employee
import com.example.mvvm.repository.MvvmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeModel @Inject constructor(private val repository: MvvmRepository) :ViewModel() {

    val employeeList:StateFlow<List<Employee>>
        get() = repository.employeeObject

    init {
        viewModelScope.launch {
            repository.getEmployeeDetails()
        }
    }

}