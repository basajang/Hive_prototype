package com.waem.hivePrototype.util.requestHelper.Request.file;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Request body callback implementation class for UI layer callbacks
 */
public abstract class UIProgressRequestListener implements ProgressRequestListener {
    private static final int REQUEST_UPDATE = 0x01;

    // Handle the Handler subclass of the UI layer
    private static class UIHandler extends Handler {
        //weak reference
        private final WeakReference<UIProgressRequestListener> mUIProgressRequestListenerWeakReference;

        public UIHandler(Looper looper, UIProgressRequestListener uiProgressRequestListener) {
            super(looper);
            mUIProgressRequestListenerWeakReference = new WeakReference<UIProgressRequestListener>(uiProgressRequestListener);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REQUEST_UPDATE:
                    UIProgressRequestListener uiProgressRequestListener = mUIProgressRequestListenerWeakReference.get();
                    if (uiProgressRequestListener != null) {
                        //Get the progress entity class
                        ProgressModel progressModel = (ProgressModel) msg.obj;
                        //Callback abstract method
                        uiProgressRequestListener.onUIRequestProgress(progressModel.getCurrentBytes(), progressModel.getContentLength(), progressModel.isDone());
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
    public void onRequestProgress(long bytesRead, long contentLength, boolean done) {
        // Send progress message through Handler
        Message message = Message.obtain();
        message.obj = new ProgressModel(bytesRead, contentLength, done);
        message.what = REQUEST_UPDATE;
        mHandler.sendMessage(message);
    }

    /**
     * UI layer callback abstract method
     *
     * @param bytesWrite    The length of the current write byte
     * @param contentLength total byte length
     * @param done          Whether the writing is completed
     */
    public abstract void onUIRequestProgress(long bytesWrite, long contentLength, boolean done);
}