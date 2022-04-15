package binar.ganda.latihanch5.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flags(
    @SerializedName("png")
    val png: String,
    @SerializedName("svg")
    val svg: String
) : Parcelable