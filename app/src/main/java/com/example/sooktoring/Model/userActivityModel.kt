package com.example.sooktoring.Model

class userActivityModel (var uname : String? = null,                //이름
                         var uid : String? = null                   //uid
) { data class Context(
    var exActStartDate : String? = null,                            //대외활동 시작기간
    var exActEndDate : String? = null,                              //대외활동 끝난기간
    var exActContext : String? = null,                              //대외활동 내용
)}
