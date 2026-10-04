package io.netty.handler.ssl;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class BouncyCastleAlpnSslUtils {
    private static final Class BC_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method BC_APPLICATION_PROTOCOL_SELECTOR_SELECT;
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method GET_PARAMETERS;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_PARAMETERS;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) BouncyCastleAlpnSslUtils.class);

    static {
        Method method;
        final Class<?> cls;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8 = null;
        try {
            final Class<?> cls2 = Class.forName("org.bouncycastle.jsse.BCSSLEngine");
            cls = Class.forName("org.bouncycastle.jsse.BCApplicationProtocolSelector");
            method2 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.1
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls.getMethod(Bixby2Constants.BIXBY_PARAM_SELECT, Object.class, List.class);
                }
            });
            SSLEngine sSLEngineCreateSSLEngine = SslUtils.getSSLContext("BCJSSE").createSSLEngine();
            method3 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.2
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls2.getMethod("getParameters", null);
                }
            });
            Object objInvoke = method3.invoke(sSLEngineCreateSSLEngine, null);
            final Class<?> cls3 = objInvoke.getClass();
            Method method9 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.3
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls2.getMethod("setParameters", cls3);
                }
            });
            method9.invoke(sSLEngineCreateSSLEngine, objInvoke);
            method5 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.4
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls3.getMethod("setApplicationProtocols", String[].class);
                }
            });
            method5.invoke(objInvoke, EmptyArrays.EMPTY_STRINGS);
            method4 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.5
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls2.getMethod("getApplicationProtocol", null);
                }
            });
            method4.invoke(sSLEngineCreateSSLEngine, null);
            method6 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.6
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls2.getMethod("getHandshakeApplicationProtocol", null);
                }
            });
            method6.invoke(sSLEngineCreateSSLEngine, null);
            method7 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.7
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls2.getMethod("setBCHandshakeApplicationProtocolSelector", cls);
                }
            });
            method = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.8
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls2.getMethod("getBCHandshakeApplicationProtocolSelector", null);
                }
            });
            method.invoke(sSLEngineCreateSSLEngine, null);
            method8 = method9;
        } catch (Throwable th) {
            logger.error("Unable to initialize BouncyCastleAlpnSslUtils.", th);
            method = null;
            cls = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
            method6 = null;
            method7 = null;
        }
        SET_PARAMETERS = method8;
        GET_PARAMETERS = method3;
        SET_APPLICATION_PROTOCOLS = method5;
        GET_APPLICATION_PROTOCOL = method4;
        GET_HANDSHAKE_APPLICATION_PROTOCOL = method6;
        SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method7;
        GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method;
        BC_APPLICATION_PROTOCOL_SELECTOR_SELECT = method2;
        BC_APPLICATION_PROTOCOL_SELECTOR = cls;
    }

    private BouncyCastleAlpnSslUtils() {
    }

    public static String getApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_APPLICATION_PROTOCOL.invoke(sSLEngine, null);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String getHandshakeApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(sSLEngine, null);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector(SSLEngine sSLEngine) {
        try {
            final Object objInvoke = GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, null);
            return new BiFunction<SSLEngine, List<String>, String>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.10
                @Override // java.util.function.BiFunction
                public String apply(SSLEngine sSLEngine2, List<String> list) {
                    try {
                        return (String) BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR_SELECT.invoke(objInvoke, sSLEngine2, list);
                    } catch (Exception e) {
                        throw new RuntimeException("Could not call getHandshakeApplicationProtocolSelector", e);
                    }
                }
            };
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void setApplicationProtocols(SSLEngine sSLEngine, List<String> list) {
        String[] strArr = (String[]) list.toArray(EmptyArrays.EMPTY_STRINGS);
        try {
            Object objInvoke = GET_PARAMETERS.invoke(sSLEngine, null);
            SET_APPLICATION_PROTOCOLS.invoke(objInvoke, strArr);
            SET_PARAMETERS.invoke(sSLEngine, objInvoke);
            if (PlatformDependent.javaVersion() >= 9) {
                JdkAlpnSslUtils.setApplicationProtocols(sSLEngine, list);
            }
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void setHandshakeApplicationProtocolSelector(SSLEngine sSLEngine, final BiFunction<SSLEngine, List<String>, String> biFunction) {
        try {
            SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, Proxy.newProxyInstance(BouncyCastleAlpnSslUtils.class.getClassLoader(), new Class[]{BC_APPLICATION_PROTOCOL_SELECTOR}, new InvocationHandler() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.9
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (!method.getName().equals(Bixby2Constants.BIXBY_PARAM_SELECT)) {
                        throw new UnsupportedOperationException(AbstractC0541b.m773o("Method '", method.getName(), "' not supported."));
                    }
                    try {
                        return biFunction.apply((SSLEngine) objArr[0], (List) objArr[1]);
                    } catch (ClassCastException e) {
                        throw new RuntimeException("BCApplicationProtocolSelector select method parameter of invalid type.", e);
                    }
                }
            }));
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }
}
