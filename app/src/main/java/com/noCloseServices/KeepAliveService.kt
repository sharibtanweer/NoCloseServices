package com.noCloseServices

import android.app.Service
import android.content.Intent
import android.os.IBinder

class KeepAliveService : Service() {
    override fun onCreate() {
        super.onCreate()
        AlarmHelper.startAlarmChain(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        AlarmHelper.startAlarmChain(this)
        return START_STICKY
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        AlarmHelper.startAlarmChain(this)
        startService(Intent(this, KeepAliveService::class.java))
        super.onTaskRemoved(rootIntent)
    }

    override fun onBind(intent: Intent?): IBinder? = null
}