package com.hasancbngl.herocomposeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasancbngl.herocomposeapp.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM hero_remote_keys_table WHERE id=:id")
    suspend fun getRemoteKey(id: Int) : HeroRemoteKey?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKey>)

    @Query("DELETE FROM hero_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}