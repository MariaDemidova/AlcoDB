package demidova.alcodb.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import demidova.alcodb.db.AlcoDataBase
import demidova.alcodb.db.dao.AlcoDao
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    fun db(context: Context): AlcoDataBase {
        return AlcoDataBase.getInstance(context)
    }

    @Provides
    @Singleton
    fun alcoDAO(dataBase: AlcoDataBase): AlcoDao {
        return dataBase.alcoDao
    }
}