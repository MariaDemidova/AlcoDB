package demidova.alcodb.cache

import demidova.alcodb.db.entity.AlcoEntity
import demidova.alcodb.model.AlcoDataObject

interface AlcoCache {
    fun cacheAlcoList(alcoEntity: AlcoEntity)
}