package com.yunsung.flow.study_flow.flow_flowon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FlowOnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

         lifecycleScope.launch {
                ageFlow().onCompletion {  Log.d("TAG","${Thread.currentThread().name}Flow has completed") }
                    .collect{ value ->
                    Log.d("TAG","${Thread.currentThread().name} $value")
            }

        }

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
}