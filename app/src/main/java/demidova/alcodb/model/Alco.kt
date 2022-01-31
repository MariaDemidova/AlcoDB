package demidova.alcodb.model

import android.os.Parcelable
import demidova.alcodb.R
@Parcelize
data class Alco(val name: String, val img: Int = R.drawable.alco) : Parcelable {
}