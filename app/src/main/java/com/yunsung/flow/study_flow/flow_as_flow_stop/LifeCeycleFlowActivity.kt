package com.yunsung.flow.study_flow.flow_as_flow_stop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.userList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class LifeCeycleFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        CoroutineScope(Dispatchers.IO).launch {
            launch {

//                   withTimeoutOrNull(5000){
//                       simpleFlow().collect{ user ->
//                           Log.d("TAG", user)
//                       }
//                   }

            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            simpleFlow().collect{ user ->
                Log.d("TAG", user)
            }
        }

    }
}

private fun simpleFlow() : Flow<String> = flow {
    userList.forEach { user-> emit(user)
        delay(500)
    }
}