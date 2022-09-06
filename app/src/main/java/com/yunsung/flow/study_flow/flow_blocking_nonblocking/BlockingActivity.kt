package com.yunsung.flow.study_flow.flow_blocking_nonblocking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yunsung.flow.R
import com.yunsung.flow.userList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BlockingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        //비동기적 처리를 함과 안함의 차이

        //print user

        printUser()
        Log.d("TAG","print user completed")

        //suspend fun to print user list
        CoroutineScope(Dispatchers.IO).launch {
            printUserList()
        }
        Log.d("TAG","print user completed from suspend function")


    }

    private fun printUser(){
        userList.forEach { user -> Log.d("TAG",user) }
    }

    private fun printUserList(){
        userList.forEach { user-> Log.d("TAG",user) }
    }
}