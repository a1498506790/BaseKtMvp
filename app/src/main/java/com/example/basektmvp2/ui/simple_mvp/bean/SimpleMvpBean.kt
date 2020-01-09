package com.example.basektmvp2.ui.simple_mvp.bean

data class SimpleMvpBean(
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)