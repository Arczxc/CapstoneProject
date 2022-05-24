package com.example.capstoneproject.ui.presentation.MainScreen.Screen.ProductData

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val group: Int,
    val image: Int,
    val productName: String,
    val productDescription: String,
    val price: String,
    val rating: String
): Parcelable

val size = (36..42).toList()