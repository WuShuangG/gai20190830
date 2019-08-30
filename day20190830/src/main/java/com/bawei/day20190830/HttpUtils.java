package com.bawei.day20190830;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * author: 盖磊
 * data: 2019/8/30 19:19:44
 * function:
 */
public class HttpUtils {
    private static HttpUtils httpUtils = null;
    private HttpUtils(){}
    public static  HttpUtils getInstance(){
        if (httpUtils == null){
            synchronized (HttpUtils.class){
                if (httpUtils == null){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }


    public interface CallBackT{
        void onSuccess(Object obj);
        void onError(String msg);
    }

    public void getData(String path, final CallBackT callBackT){
        RequestQueue requestQueue = Volley.newRequestQueue(App.ofContext);
        StringRequest request = new StringRequest(Request.Method.GET, path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (callBackT != null){
                    callBackT.onSuccess(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callBackT != null){
                    callBackT.onError(error.getMessage());
                }
            }
        });
        requestQueue.add(request);
    }

}
