package com.sbk.algo.shared.proxy;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.rebind.rpc.ProxyCreator;

/**
 * Created by sobik on 08/12/2014.
 */
public class AlgoProxyCreator extends ProxyCreator {
    public AlgoProxyCreator(JClassType serviceIntf) {
        super(serviceIntf);
    }

    @Override
    protected Class<? extends RemoteServiceProxy> getProxySupertype() {
        return AlgoRemoteServiceProxy.class;
    }
}
