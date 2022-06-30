package com.yunsung.flow.flow_as_flow_stop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yunsung.flow.R
import com.yunsung.flow.flowUserList
import com.yunsung.flow.userList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class AsFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)
        CoroutineScope(Dispatchers.IO).launch {
            launch { flowUserList.collect { user-> Log.d("TAG",user) } }
            launch { userList.asFlow().collect { user-> Log.d("TAG",user) } }
        }
    }
}

private fun simpleFlow() : Flow<String> = flow {
    userList.forEach { user-> emit(user)
        delay(500)
    }
}