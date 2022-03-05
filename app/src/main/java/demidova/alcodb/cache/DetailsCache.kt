package demidova.alcodb.cache

import demidova.alcodb.db.entity.AlcoEntity

interface DetailsCache {
    fun cacheDrtails(entity: AlcoEntity)
}