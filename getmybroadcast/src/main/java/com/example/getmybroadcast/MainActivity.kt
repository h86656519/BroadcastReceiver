package com.example.getmybroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    /***/
    companion object {
        const val MY_MESSAGE_GLOBAL = "com.broadcastreceiver.sendmessage_global"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(mBroadcast, IntentFilter(MY_MESSAGE_GLOBAL))
   //    println("動態註冊")
    }

    private val mBroadcast = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            println("接收到了~~")
            if (MY_MESSAGE_GLOBAL == intent?.action) {
                AlertDialog.Builder(this@MainActivity)
                    .setMessage("收到訊息了")
                    .setPositiveButton("確定") { _, _ -> }
                    .show()
            }else{
                AlertDialog.Builder(this@MainActivity)
                    .setMessage("收錯消息了啦")
                    .setPositiveButton("確定") { _, _ -> }
                    .show()
            }
        }

    }
}
