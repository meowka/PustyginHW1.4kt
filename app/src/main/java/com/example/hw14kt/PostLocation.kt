package com.example.hw14kt

class PostLocation(
    val date: String,
    val title: String,
    val content: String,
    var like: Int,
    val comment: Int,
    val share: Int,
    val address: String,
    val location: Pair<Double, Double>
) {
}