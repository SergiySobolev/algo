package com.sbk.core.client.proxy;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.user.rebind.rpc.ProxyCreator;
import com.google.gwt.user.rebind.rpc.ServiceInterfaceProxyGenerator;

/**
 * Created by sobik on 08/12/2014.
 */
public class AlgoServiceInterfaceProxyGenerator extends ServiceInterfaceProxyGenerator {
    @Override
    protected ProxyCreator createProxyCreator(JClassType remoteService) {
        return new AlgoProxyCreator(remoteService);
    }
}
