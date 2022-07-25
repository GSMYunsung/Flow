package com.yunsung.flow.flow_terminal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import com.yunsung.flow.userList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TerminalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch(Dispatchers.IO) {
            val sum = ageList.asFlow()
                .map { age -> "$age " }
                .reduce { a, b -> a + b }

            Log.d("TAG", sum)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            val sum = simpleFlow()
                .toSet()
                .first()

            Log.d("TAG", sum)
        }
    }

    private fun simpleFlow(): Flow<String> = flow {
        userList.forEach { user ->
            emit(user)
            delay(500)
        }
    }
}