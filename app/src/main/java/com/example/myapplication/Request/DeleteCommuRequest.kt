package com.example.myapplication.Request

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class DeleteCommuRequest(
    number: Int,
    userID: String?,
    path: String?,
    listener: Response.Listener<String>
) :
    StringRequest(Method.POST, URL, listener, null) { //HTTP 메서드(Method.POST), 서버 URL(URL), 서버로부터 결과를 받을 때 호출할 콜백(listener), 서버 연동 실패 시 호출할 콜백(null)
    private val map: MutableMap<String, String> //Map:불변 / MutableMap:가변 ->key 값을 통해 value값을 얻는 것  / <String, String>은 Key와 Value

    init {
        map = HashMap() //HashMap은 코틀린에서 key , value 형태로 데이터를 저장
        map.put("number", number.toString())
        map.put("userID",userID.toString()) //userID를 "userID"에 담는다는 의미
        map.put("path", path.toString())
        println("Request안")
        println(number)
    }

    @Throws(AuthFailureError::class)
    override fun getParams(): Map<String, String>? {
        return map
    }
    companion object {
        private const val URL = "http://218.159.194.63/DeleteCommunity.php"
    }
}