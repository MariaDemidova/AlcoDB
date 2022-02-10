package demidova.alcodb.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import demidova.alcodb.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Alco(
    var drinksList :List<AlcoDataObject>
) : Parcelable {
}

@Parcelize
data class AlcoResponse(
    var drinks :Alco
) : Parcelable {
}