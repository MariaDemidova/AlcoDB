package demidova.alcodb.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import demidova.alcodb.db.entity.AlcoEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface AlcoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(alco: AlcoEntity)

    @Query("SELECT * FROM cocktail_table")
    fun getAllAlco(): Single<List<AlcoEntity>>

    @Query("SELECT * FROM cocktail_table WHERE idDrink = :id")
    fun getCocktailById(id: String?):Single<AlcoEntity>
}