package com.example.sooktoring.Model

import androidx.constraintlayout.motion.widget.DesignTool
import java.time.Period
import java.util.*

data class userModel(
    var imageUrl : String? = null,
    var uid : String? = null,
    var userId : String? = null,
    var timestamp: Long? = null,
    var career: String? = null,
    var rank: String? = null) { data class timestamp (var uid: String? = null,
                        var userId: String? = null,
                        var eduContent: String? = null,
                        var eduStartYYMM: Date? = null,
                        var eduEndYYMM: Date? = null,
                        var timestamp: Long? = null) {

    data class extraActivity (designTool: DesignTool
        }
            var uid: String? = null,
            var userId: String? = null,
            var extActContent: String? = null,
            var extActStartYYMM: Date? = null,
            var extActEndYYMM: Date? = null,
            var timestamp: Long? = null) {

            data class userCareer (
                var uid: String? = null,
                var userId: String? = null,
                var careerContent: String? = null,
                var careerStartYYMM: Date? = null,
                var careerEndYYMM: Date? = null,
                var timestamp: Long? = null
                )
        }
    }
}
