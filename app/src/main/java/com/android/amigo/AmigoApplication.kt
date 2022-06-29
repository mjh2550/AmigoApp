package com.android.amigo

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AmigoApplication : Application() {
    init{
        instance = this
    }
    companion object {
        var instance: AmigoApplication? = null
        fun context() : Context {
            return instance!!.applicationContext
        }
    }

    fun getMetaDataString(metaDataKey: String?): String? {
            return try {
                val mContext = AmigoApplication.context()
                val applicationInfo = mContext?.packageManager?.getApplicationInfo(mContext.packageName,PackageManager.GET_META_DATA)
                val bundle = applicationInfo?.metaData
                if(bundle==null){
                    ""
                }else{
                    bundle.getString(metaDataKey)
                }
            }catch (e:PackageManager.NameNotFoundException){
                Log.e("Error","${e.message}")
                ""
            }
        }

}