package com.yunsung.flow.flow_zip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import com.yunsung.flow.userList
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class ZipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch {

            val userList = userList.asFlow()

            val ages = ageList.asFlow()

            userList.zip(ages){ user, age ->
                "User : $user - Age : $age"
            }.collect{
                Log.d("TAG" , it)
            }

        }

    }
}