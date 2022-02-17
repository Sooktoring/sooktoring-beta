package com.example.sooktoring.Model

import java.text.DateFormat
import java.util.*


class userModel( var uname : String? = null,                //이름
                 var imageUrl : String? = null,             //프로필 이미지 Url
                 var uid : String? = null,                  //uid
                 var userId : String? = null,               //UserId(email)
                 var timestmap : String? = null,
                 var urank : String? = null,                //등급
                 var firstMajor : String? = null,           //본전공
                 var secondMajor : String? = null,          //복수전공
                 var minor : String? = null,                //부전공
                 var admin : String? = null,                //입학연도
                 var career : String? = null,               //직무
                 var careerTag : String? = null             //직무분야
)
