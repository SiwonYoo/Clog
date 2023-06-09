package com.example.myapplication.Request

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

//프로필 이미지 불러오는
class ProfileImage_Request (id: String?, listener: Response.Listener<String>):
    StringRequest(Method.POST, URL, listener, null) {
    private val map: MutableMap<String, String>

    init {
        map = HashMap()
        map.put("id",id.toString())
    }

    @Throws(AuthFailureError::class)
    override fun getParams(): Map<String, String>? {
        return map
    }

    companion object {
        // 서버 URL 설정 ( PHP 파일 연동 )
        private const val URL = "http://218.159.194.63/ProfileImage_.php"
    }
}