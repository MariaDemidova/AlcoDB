package demidova.alcodb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import demidova.alcodb.db.dao.AlcoDao
import demidova.alcodb.db.entity.AlcoEntity

@Database(entities = [AlcoEntity::class], version = 1, exportSchema = false)
abstract class AlcoDataBase : RoomDatabase() {
    abstract val alcoDao: AlcoDao

    companion object {
        @Volatile
        private var INSTANCE: AlcoDataBase? = null

        fun getInstance(context: Context): AlcoDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AlcoDataBase::class.java,

                        "cocktail_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}