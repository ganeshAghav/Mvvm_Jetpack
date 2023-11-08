package com.example.mvvm.screens

import android.content.ClipData.Item
import android.provider.CalendarContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm.viewmodels.EmployeeModel


@Composable
fun employeeList(){
    val employeeViewMode: EmployeeModel= viewModel()
    val employeeDetails = employeeViewMode.employeeList.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround,
        ){
        items(employeeDetails.value){
            employeeDetails(empAge =it.age.toString() , empEmail =it.email , empName = it.name)
        }
    }
}

@Composable
fun employeeDetails(empAge:String,empEmail:String, empName:String){

    Card (
        modifier =Modifier.padding(5.dp,5.dp),
        shape = CardDefaults.shape,
        colors= CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
    ){

        Row(modifier = Modifier.padding(10.dp,10.dp)) {
            Text(text = empAge,
                fontSize = 18.sp,
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium
            )

            Column (
                modifier = Modifier.padding(25.dp,0.dp)
            ){
                Text(text = empName,
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = empEmail,
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}