package com.dicoding.kostracker

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kost(
    val name: String,
    val facility: String,
    val photo: Int,
    val price: String,
    val address: String
) : Parcelable
