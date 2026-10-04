package org.apache.commons.collections;

import org.apache.commons.collections.functors.ConstantFactory;
import org.apache.commons.collections.functors.ExceptionFactory;
import org.apache.commons.collections.functors.InstantiateFactory;
import org.apache.commons.collections.functors.PrototypeFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FactoryUtils {
    public static Factory constantFactory(Object obj) {
        return ConstantFactory.getInstance(obj);
    }

    public static Factory exceptionFactory() {
        return ExceptionFactory.INSTANCE;
    }

    public static Factory instantiateFactory(Class cls) {
        return InstantiateFactory.getInstance(cls, null, null);
    }

    public static Factory nullFactory() {
        return ConstantFactory.NULL_INSTANCE;
    }

    public static Factory prototypeFactory(Object obj) {
        return PrototypeFactory.getInstance(obj);
    }

    public static Factory instantiateFactory(Class cls, Class[] clsArr, Object[] objArr) {
        return InstantiateFactory.getInstance(cls, clsArr, objArr);
    }
}
