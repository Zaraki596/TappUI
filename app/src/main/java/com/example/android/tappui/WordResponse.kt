package com.example.android.tappui

data class WordResponse(
	val data: WordObjectContainer? = null,
	val error: Boolean? = null,
	val message: String? = null,
	val statusCode: Int? = null
)
