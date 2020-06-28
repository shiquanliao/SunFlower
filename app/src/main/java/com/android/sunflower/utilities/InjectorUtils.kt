package com.android.sunflower.utilities

import android.content.Context
import com.android.sunflower.data.AppDatabase
import com.android.sunflower.data.PlantRepository

object InjectorUtils {
    public fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).plantDao()
        )
    }


}