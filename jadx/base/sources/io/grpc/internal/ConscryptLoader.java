package io.grpc.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class ConscryptLoader {
    private static final Method IS_CONSCRYPT_METHOD;
    private static final Method NEW_PROVIDER_METHOD;

    static {
        Method method;
        Method method2 = null;
        try {
            int i = Conscrypt.f10188a;
            Method method3 = Conscrypt.class.getMethod("newProvider", null);
            method = Conscrypt.class.getMethod("isConscrypt", Provider.class);
            method2 = method3;
        } catch (ClassNotFoundException unused) {
            method = null;
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
        NEW_PROVIDER_METHOD = method2;
        IS_CONSCRYPT_METHOD = method;
    }

    public static boolean isConscrypt(Provider provider) {
        if (!isPresent()) {
            return false;
        }
        try {
            return ((Boolean) IS_CONSCRYPT_METHOD.invoke(null, provider)).booleanValue();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public static boolean isPresent() {
        return NEW_PROVIDER_METHOD != null;
    }

    public static Provider newProvider() {
        if (isPresent()) {
            return (Provider) NEW_PROVIDER_METHOD.invoke(null, null);
        }
        int i = Conscrypt.f10188a;
        throw new AssertionError("Unexpected failure referencing Conscrypt class");
    }
}
