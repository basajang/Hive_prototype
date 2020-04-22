package com.waem.hivePrototype.util.requestHelper.Request.file;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

public abstract class UIProgressResponseListener implements ProgressResponseListener {
    private static final int RESPONSE_UPDATE = 0x02;

    // Handle the Handler subclass of the UI layer
    private static class UIHandler extends Handler {
        //weak reference
        private final WeakReference<UIProgressResponseListener> mUIProgressResponseListenerWeakReference;

        public UIHandler(Looper looper, UIProgressResponseListener uiProgressResponseListener) {
            super(looper);
            mUIProgressResponseListenerWeakReference = new WeakReference<UIProgressResponseListener>(uiProgressResponseListener);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case RESPONSE_UPDATE:
                    UIProgressResponseListener uiProgressResponseListener = mUIProgressResponseListenerWeakReference.get();
                    if (uiProgressResponseListener != null) {
                        // Get the progress entity class
                        ProgressModel progressModel = (ProgressModel) msg.obj;
                        // Callback abstract method
                        uiProgressResponseListener.onUIResponseProgress(progressModel.getCurrentBytes(), progressModel.getContentLength(), progressModel.isDone());
                    }
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    }

    //Main thread Handler
    private final Handler mHandler = new UIHandler(Looper.getMainLooper(), this);

    @Override
    public void onResponseProgress(long bytesRead, long contentLength, boolean done) {
        // Send progress message through Handler
        Message message = Message.obtain();
        message.obj = new ProgressModel(bytesRead, contentLength, done);
        message.what = RESPONSE_UPDATE;
        mHandler.sendMessage(message);
    }

    /**
     * UI layer callback abstract method
     *
     * @param bytesRead     current read response body byte length
     * @param contentLength total byte length
     * @param done          Whether the reading is completed
     */
    public abstract void onUIResponseProgress(long bytesRead, long contentLength, boolean done);
}