package com.waem.hivePrototype.util.requestHelper.Request;

import com.waem.hivePrototype.util.requestHelper.Request.file.ProgressRequestListener;
import com.waem.hivePrototype.util.requestHelper.Request.file.UIProgressRequestListener;

public class AddUploadListener {

    private UIProgressRequestListener uiProgressRequestListener;
    private UploadRequestTesk uploadRequest;

    public AddUploadListener(UploadRequestTesk uploadRequest) {
        this.uploadRequest = uploadRequest;
    }

    public AddCallback AddUploadListener(ProgressRequestListener uiProgressRequestListener) {
        uploadRequest.setUiProgressRequestListener(uiProgressRequestListener);
        return new AddCallback(uploadRequest);

    }
}
