package com.example.falconHunt.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Planet(
    val name: String,
    val distance: Int
) : Parcelable