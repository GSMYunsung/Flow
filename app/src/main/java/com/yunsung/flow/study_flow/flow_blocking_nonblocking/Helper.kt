package com.yunsung.flow

import kotlinx.coroutines.flow.flowOf

val userList = listOf("User1","User2","User3","User4","User5")

val ageList = listOf(10,20,30,40,50)

// flow를 변수로 선언하는 방법
val flowUserList = flowOf("User6","User7","User8","User9","User10")