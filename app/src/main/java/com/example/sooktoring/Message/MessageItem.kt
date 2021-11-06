package com.example.sooktoring.Message

class MessageItem {
    //Getter & Setter
    var name: String? = null
    var message: String? = null
    var time: String? = null
    var pofileUrl: String? = null

    constructor(name: String?, message: String?, time: String?, pofileUrl: String?) {
        this.name = name
        this.message = message
        this.time = time
        this.pofileUrl = pofileUrl
    }

    //firebase DB에 객체로 값을 읽어올 때..
    //파라미터가 비어있는 생성자가 핑요함.
    constructor() {}
}