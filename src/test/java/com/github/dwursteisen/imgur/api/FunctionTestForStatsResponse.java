/*
 * Copyright 2010 David Wursteisen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.github.dwursteisen.imgur.api;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.IOException;


public class FunctionTestForStatsResponse {

    private static final String API_KEY = "e67bb2d5ceb42e43f8f7fc38e7ca7376";
    private static final String IMGUR_STATS_URL = "http://api.imgur.com/2/stats.json";

    @Test
    public void functionTest() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();

        HttpPost request = new HttpPost(IMGUR_STATS_URL);
        request.getParams().setParameter("key", API_KEY);

        System.out.println("executing request " + request.getURI());

        // Create a response handler
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = httpclient.execute(request, responseHandler);
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
        System.out.println("----------------------------------------");

        // When HttpClient instance is no longer needed,
        // shut down the connection request to ensure
        // immediate deallocation of all system resources
        httpclient.getConnectionManager().shutdown();

    }

}
