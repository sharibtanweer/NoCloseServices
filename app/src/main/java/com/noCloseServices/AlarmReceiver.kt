package com.noCloseServices

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlarmReceiver : BroadcastReceiver() {

    private val receiverScope = CoroutineScope(Dispatchers.Main + Job())

    override fun onReceive(context: Context, intent: Intent?) {
        receiverScope.launch {
            sendPing()
        }
        AlarmHelper.startAlarmChain(context)
    }

    private suspend fun sendPing() {
        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        try {
            val response = withContext(Dispatchers.IO) {
                apiService.getPing()
            }
            Log.e("UPDATE PING STATUS", "Ping Success: $response")
        } catch (e: Exception) {
            Log.e("UPDATE PING STATUS", "Ping failed", e)
        }
    }

}