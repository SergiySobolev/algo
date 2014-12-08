package com.sbk.algo.shared.proxy;

import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;
import com.google.gwt.user.client.rpc.impl.Serializer;

/**
 * Created by sobik on 08/12/2014.
 */
public class AlgoRemoteServiceProxy extends RemoteServiceProxy {
    protected AlgoRemoteServiceProxy(String moduleBaseURL, String remoteServiceRelativePath, String serializationPolicyName, Serializer serializer) {
        super(moduleBaseURL, remoteServiceRelativePath, serializationPolicyName, serializer);
    }

    @Override
    protected <T> RequestCallback doCreateRequestCallback(RequestCallbackAdapter.ResponseReader responseReader,
                                                          String methodName, RpcStatsContext statsContext,
                                                          AsyncCallback<T> callback) {
        return super.doCreateRequestCallback(responseReader, methodName, statsContext, callback);
    }
}
