package demidova.alcodb.cache

import demidova.alcodb.db.entity.AlcoEntity

interface AlcoCache {
    fun cacheAlcoList(alcoEntity: AlcoEntity)
}