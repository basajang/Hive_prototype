package com.waem.hivePrototype.util.requestHelper.Request.file;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
   * Progress callback helper class
   */
public class ProgressHelper {
/**
   * Wrapped OkHttpClient, a callback for downloading files
   * @param client OkHttpClient to be wrapped
   * @param progressListener progress callback interface
   * @return wrapped OkHttpClient, use the clone method to return
 */
public static OkHttpClient addProgressResponseListener(OkHttpClient client, final ProgressResponseListener progressListener){
         //cloning
    OkHttpClient clone = (OkHttpClient) client.clone();
         // Increase the interceptor
    clone.networkInterceptors().add(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
                         // interception
            Response originalResponse = chain.proceed(chain.request());
                         //Pack the response body and return
            return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
        }
    });
    return clone;
}
 
/**
   * The callback body is used to upload the file callback
   * @param requestBody request body RequestBody
   * @param progressRequestListener progress callback interface
   * @return post-packaged progress callback request body
 */
public static ProgressRequestBody addProgressRequestListener(RequestBody requestBody, ProgressRequestListener progressRequestListener){
         //Package request body
    return new ProgressRequestBody(requestBody,progressRequestListener);
}}