package com.android.amigo

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import java.lang.reflect.Type

@HiltAndroidApp
class AmigoApplication() : Application() {

    /**
     * Manifest Metadata 값 (String)
     * @author mjh
     * @param metaDataKey
     * @param context (applicationContext)
     */
    fun getMetaDataString(metaDataKey: String?,context: Context): String? {
        return try {
            val applicationInfo = context.packageManager.getApplicationInfo(context.packageName,PackageManager.GET_META_DATA)
            val bundle = applicationInfo?.metaData
            if (bundle.isEmpty){
                return ""
            }else{
                bundle?.getString(metaDataKey)
            }
        }catch (e:PackageManager.NameNotFoundException){
            Log.e("Error","${e.message}")
            ""
        }
    }

    /**
     * Manifest Metadata 값 (Integer)
     * @author mjh
     * @param metaDataKey
     * @param context (applicationContext)
     */
    fun getMetaDataInteger(metaDataKey: String?,context: Context): Int? {
        return try {
            val applicationInfo = context.packageManager.getApplicationInfo(context.packageName,PackageManager.GET_META_DATA)
            val bundle = applicationInfo?.metaData
            if (bundle.isEmpty){
                return -1
            }else{
                bundle?.getInt(metaDataKey)
            }
        }catch (e:PackageManager.NameNotFoundException){
            Log.e("Error","${e.message}")
            -1
        }
    }
}