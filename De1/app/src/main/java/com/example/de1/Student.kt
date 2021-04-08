package com.example.de1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(
    val id: Int,
    val img: String,
    val name: String,
    val address: String,
    val myClass: String
): Parcelable