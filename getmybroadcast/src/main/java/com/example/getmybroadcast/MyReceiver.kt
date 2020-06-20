package com.example.getmybroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AlertDialog

class MyReceiver : BroadcastReceiver() {
    /**android 8.0(26) 這邊不會動，官方禁止靜態註冊，只能用動態註冊*/
    override fun onReceive(context: Context, intent: Intent) {
        if (MainActivity.MY_MESSAGE_GLOBAL == intent?.action) {
            AlertDialog.Builder(context)
                .setMessage("收到訊息了")
                .setPositiveButton("確定") { _, _ -> }
                .show()
        }else{
            AlertDialog.Builder(context)
                .setMessage("收錯消息了啦")
                .setPositiveButton("確定") { _, _ -> }
                .show()
        }
    }
}
