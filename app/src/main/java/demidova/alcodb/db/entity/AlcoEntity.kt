package demidova.alcodb.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "cocktail_table")
data class AlcoEntity(
    @PrimaryKey(autoGenerate = false)
    var idDrink: String = "",
    @ColumnInfo(name = "thumb")
    var strDrinkThumb: String = "",
    @ColumnInfo(name = "nameCocktail")
    var strDrink: String = "",
    @ColumnInfo(name = "instructions")
    var strInstructions: String = "",
)
