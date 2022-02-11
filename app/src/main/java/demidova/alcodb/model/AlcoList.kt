package demidova.alcodb.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import demidova.alcodb.R
import kotlinx.parcelize.Parcelize


data class AlcoList(

    @SerializedName("drinks")
    var drinks :List<AlcoDataObject>
)
