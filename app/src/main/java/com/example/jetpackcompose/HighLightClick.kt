package com.example.jetpackcompose

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class HighLightClick(val url: String)