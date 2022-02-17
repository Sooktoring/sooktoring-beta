package com.example.sooktoring.Model

class userCareerModel (var uname : String? = null,                //이름
                       var uid : String? = null                   //uid
) { data class Context(
    var careerStartDate : String? = null,                            //경력 시작기간
    var careerEndDate : String? = null,                              //경력 끝난기간
    var careerContext : String? = null,                              //경력 내용
)}