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

    @ColumnInfo(name = "strIngredient1")
    var strIngredient1: String? = "",
    @ColumnInfo(name = "strIngredient2")
    var strIngredient2: String? = "",
    @ColumnInfo(name = "strIngredient3")
    var strIngredient3: String? = "",
    @ColumnInfo(name = "strIngredient4")
    var strIngredient4: String? = "",
    @ColumnInfo(name = "strIngredient5")
    var strIngredient5: String? = "",
    @ColumnInfo(name = "strIngredient6")
    var strIngredient6: String? = "",
    @ColumnInfo(name = "strIngredient7")
    var strIngredient7: String? = "",
    @ColumnInfo(name = "strIngredient8")
    var strIngredient8: String? = "",
    @ColumnInfo(name = "strIngredient9")
    var strIngredient9: String? = "",
    @ColumnInfo(name = "strIngredient10")
    var strIngredient10: String? = "",
    @ColumnInfo(name = "strIngredient11")
    var strIngredient11: String? = "",
    @ColumnInfo(name = "strIngredient12")
    var strIngredient12: String? = "",
    @ColumnInfo(name = "strIngredient13")
    var strIngredient13: String? = "",
    @ColumnInfo(name = "strIngredient14")
    var strIngredient14: String? = "",
    @ColumnInfo(name = "strIngredient15")
    var strIngredient15: String? = "",

    @ColumnInfo(name = "strMeasure1")
    var strMeasure1: String? = "",
    @ColumnInfo(name = "strMeasure2")
    var strMeasure2: String? = "",
    @ColumnInfo(name = "strMeasure3")
    var strMeasure3: String? = "",
    @ColumnInfo(name = "strMeasure4")
    var strMeasure4: String? = "",
    @ColumnInfo(name = "strMeasure5")
    var strMeasure5: String? = "",
    @ColumnInfo(name = "strMeasure6")
    var strMeasure6: String? = "",
    @ColumnInfo(name = "strMeasure7")
    var strMeasure7: String? = "",
    @ColumnInfo(name = "strMeasure8")
    var strMeasure8: String? = "",
    @ColumnInfo(name = "strMeasure9")
    var strMeasure9: String? = "",
    @ColumnInfo(name = "strMeasure10")
    var strMeasure10: String? = "",
    @ColumnInfo(name = "strMeasure11")
    var strMeasure11: String? = "",
    @ColumnInfo(name = "strMeasure12")
    var strMeasure12: String? = "",
    @ColumnInfo(name = "strMeasure13")
    var strMeasure13: String? = "",
    @ColumnInfo(name = "strMeasure14")
    var strMeasure14: String? = "",
    @ColumnInfo(name = "strMeasure15")
    var strMeasure15: String? = ""
)
