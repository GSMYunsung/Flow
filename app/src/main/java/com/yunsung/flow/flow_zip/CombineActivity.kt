package com.yunsung.flow.flow_zip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import com.yunsung.flow.userList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CombineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch{
            val users = userList.asFlow()
            val ages = ageList.asFlow().onEach { delay(400) }
            val startTime = System.currentTimeMillis()

            users.combine(ages){ users, age ->
                "Name : $users - Age : $age"
            }.collect{
                Log.d("TAG", "$it at ${System.currentTimeMillis() - startTime} ms from start")
            }
        }

    }
}