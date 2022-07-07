package com.yunsung.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch(Dispatchers.IO) {
            ageList.asFlow()
                .filter { age -> age % 3 == 1}
                .map { age ->
                   "Age : $age"
                }
                .collect{
                    age-> Log.d("TAG" , age.toString())
                }
        }

        }
    }

    private fun simpleFlow() : Flow<String> = flow {
        userList.forEach { user-> emit(user)
            delay(500)
        }
}