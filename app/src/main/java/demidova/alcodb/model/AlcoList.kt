package demidova.alcodb.model

import com.google.gson.annotations.SerializedName

data class AlcoList(

    @SerializedName("drinks")
    var drinks: List<AlcoDataObject>
)
