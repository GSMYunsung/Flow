package com.yunsung.flow.flow_emit_collect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yunsung.flow.R
import com.yunsung.flow.userList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class EmitCollectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        CoroutineScope(Dispatchers.IO).launch {
            simpleFlow().collect { user -> Log.d("TAG", "Flow1 $user") }

            launch {  simpleFlow().collect { user -> Log.d("TAG", "Flow2 $user") } }

            launch {  simpleFlow().collect { user -> Log.d("TAG", "Flow3 $user") } }
        }
    }

    private fun simpleFlow() : Flow<String> = flow {
        userList.forEach { user-> emit(user)
            delay(500)
        }
    }

}