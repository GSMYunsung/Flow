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

    }

    private fun ageFlow(): Flow<Int> = ageList.asFlow()
        .transform { age ->
            Log.d("TAG", "${Thread.currentThread().name}")

            if (age == 30) {
                emit(age + 1)
            } else {
                emit(age)
            }

        }.flowOn(Dispatchers.IO)

    private fun simpleFlow(): Flow<String> = flow {
        userList.forEach { user ->
            Log.d("TAG", "${Thread.currentThread().name}")
            emit(user)
            delay(500)
        }
    }
}