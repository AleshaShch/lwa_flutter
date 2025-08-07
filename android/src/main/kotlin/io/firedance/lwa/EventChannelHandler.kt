package io.firedance.lwa

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import io.flutter.plugin.common.EventChannel

class EventChannelHandler : EventChannel.StreamHandler {
    private var receiver: BroadcastReceiver? = null
    private var eventSink: EventChannel.EventSink? = null

    fun handleIntent(context: Context, intent: Intent?) {
        if (this.receiver != null && intent != null)
            receiver!!.onReceive(context, intent)
    }

    override fun onCancel(p0: Any?) {
        receiver = null
    }

    override fun onListen(p0: Any?, events: EventChannel.EventSink?) {
        eventSink = events
    }

    fun onSuccess(data: String) {
        Log.d("EventChannelHandler", "onSuccess: $data")
        eventSink?.success(data)
    }

    fun onError(data: String) {
        Log.d("EventChannelHandler", "onError: $data")
        eventSink?.success(data)
    }
}