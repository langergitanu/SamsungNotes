package com.samsung.android.sdk.pass.support.p141v1;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.pass.support.IFingerprintManagerProxy;
import com.samsung.android.sdk.pass.support.SdkSupporter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class FingerprintManagerProxyFactory {

    /* JADX INFO: renamed from: com.samsung.android.sdk.pass.support.v1.FingerprintManagerProxyFactory$a */
    public static class C7437a implements InvocationHandler {

        /* JADX INFO: renamed from: a */
        private Object f4936a;

        /* JADX INFO: renamed from: b */
        private Map f4937b = new HashMap();

        public C7437a(Object obj) {
            this.f4936a = obj;
            Method[] methods = IFingerprintManagerProxy.class.getMethods();
            for (Method method : obj.getClass().getMethods()) {
                String name = method.getName();
                if (m5827a(methods, method)) {
                    this.f4937b.put(name, method);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private static boolean m5827a(Method[] methodArr, Method method) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Method method2 : methodArr) {
                if (method2.getName().equals(name)) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes == null || parameterTypes2 == null) {
                        return true;
                    }
                    if (parameterTypes.length == parameterTypes2.length) {
                        int length = parameterTypes.length;
                        boolean z = false;
                        for (int i = 0; i < length; i++) {
                            if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                z = true;
                            }
                        }
                        if (!z) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Method method2 = (Method) this.f4937b.get(method.getName());
            if (method2 != null) {
                return method2.invoke(this.f4936a, objArr);
            }
            return null;
        }
    }

    public static IFingerprintManagerProxy create(Context context) {
        Object objInvoke;
        try {
            objInvoke = Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("getInstance", Context.class).invoke(null, context);
        } catch (Exception e) {
            Log.e("FingerprintManagerProxy", "Cannot create FingerprintManagerProxy : " + e);
            objInvoke = null;
        }
        if (objInvoke == null) {
            return null;
        }
        return (IFingerprintManagerProxy) Proxy.newProxyInstance(FingerprintManagerProxyFactory.class.getClassLoader(), new Class[]{IFingerprintManagerProxy.class}, new C7437a(objInvoke));
    }
}
