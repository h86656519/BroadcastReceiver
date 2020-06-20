package com.example.broadcastreceiver

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val MY_MESSAGE_LOCAL = "com.broadcastreceiver.sendmessage_local"
        const val MY_MESSAGE_GLOBAL = "com.broadcastreceiver.sendmessage_global"
        const val MY_MESSAGE_GLOBAL_WRONG = "wrong"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnLocal = findViewById<Button>(R.id.btn_local)
        var btnGlobal = findViewById<Button>(R.id.btn_global)

        btnLocal.setOnClickListener(this)
        btnGlobal.setOnClickListener(this)

        //registerReceiver(mBroadcast, IntentFilter(MY_MESSAGE_LOCAL))//動態註冊
    }

//    private val mBroadcast = object : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            if (MY_MESSAGE_LOCAL == intent?.action) {
//                AlertDialog.Builder(this@MainActivity)
//                    .setMessage("收到訊息了")
//                    .setPositiveButton("確定") { _, _ -> }
//                    .show()
//            }
//        }
//
//    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_local -> {
                val intent = Intent()
                intent.action = Companion.MY_MESSAGE_LOCAL
                sendBroadcast(intent)
            }
            R.id.btn_global -> {
                val intent = Intent()
                intent.action = Companion.MY_MESSAGE_GLOBAL
                sendBroadcast(intent)
                println("發送了~~")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //   unregisterReceiver(mBroadcast)
    }

}
