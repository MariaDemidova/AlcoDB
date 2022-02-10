package demidova.alcodb.model

import android.os.Parcelable
import demidova.alcodb.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlcoDataObject(
    var idDrink: String? = "1",
                          var strDrinkThumb: String? = "1",
                          var strDrink: String? = "1",
                          var strInstructions: String? = "",
                          var strAlcoholic: String? = "",
                          var strCategory: String? = "",
                          var strGlass: String? = "",
                          var strImageSource: String? = "",
                          val img: Int = R.drawable.alco
) : Parcelable