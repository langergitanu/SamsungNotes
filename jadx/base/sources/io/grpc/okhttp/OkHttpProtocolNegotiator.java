package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.internal.GrpcUtil;
import io.grpc.okhttp.internal.OptionalMethod;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.Util;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpProtocolNegotiator {
    protected final Platform platform;
    private static final Logger logger = Logger.getLogger(OkHttpProtocolNegotiator.class.getName());
    private static final Platform DEFAULT_PLATFORM = Platform.get();
    private static OkHttpProtocolNegotiator NEGOTIATOR = createNegotiator(OkHttpProtocolNegotiator.class.getClassLoader());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class AndroidNegotiator extends OkHttpProtocolNegotiator {
        private static final OptionalMethod<Socket> GET_ALPN_SELECTED_PROTOCOL;
        private static final Method GET_APPLICATION_PROTOCOL;
        private static final Method GET_APPLICATION_PROTOCOLS;
        private static final OptionalMethod<Socket> GET_NPN_SELECTED_PROTOCOL;
        private static final OptionalMethod<Socket> SET_ALPN_PROTOCOLS;
        private static final Method SET_APPLICATION_PROTOCOLS;
        private static final OptionalMethod<Socket> SET_HOSTNAME;
        private static final OptionalMethod<Socket> SET_NPN_PROTOCOLS;
        private static final Method SET_SERVER_NAMES;
        private static final OptionalMethod<Socket> SET_USE_SESSION_TICKETS;
        private static final Constructor<?> SNI_HOST_NAME;
        private static final Method SSL_SOCKETS_IS_SUPPORTED_SOCKET;
        private static final Method SSL_SOCKETS_SET_USE_SESSION_TICKET;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Class cls = Boolean.TYPE;
            Constructor<?> constructor = null;
            SET_USE_SESSION_TICKETS = new OptionalMethod<>(null, "setUseSessionTickets", cls);
            SET_HOSTNAME = new OptionalMethod<>(null, "setHostname", String.class);
            GET_ALPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            SET_ALPN_PROTOCOLS = new OptionalMethod<>(null, "setAlpnProtocols", byte[].class);
            GET_NPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);
            SET_NPN_PROTOCOLS = new OptionalMethod<>(null, "setNpnProtocols", byte[].class);
            try {
                method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
            } catch (ClassNotFoundException e) {
                e = e;
                method = null;
                method2 = null;
            } catch (NoSuchMethodException e2) {
                e = e2;
                method = null;
                method2 = null;
            }
            try {
                method2 = SSLParameters.class.getMethod("getApplicationProtocols", null);
            } catch (ClassNotFoundException e3) {
                e = e3;
                method2 = null;
                method3 = method2;
                method4 = method3;
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                SET_APPLICATION_PROTOCOLS = method;
                GET_APPLICATION_PROTOCOLS = method2;
                GET_APPLICATION_PROTOCOL = method3;
                SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                try {
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                } catch (ClassNotFoundException e5) {
                    e = e5;
                    OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                } catch (NoSuchMethodException e6) {
                    e = e6;
                    OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
                }
                SET_SERVER_NAMES = method6;
                SNI_HOST_NAME = constructor;
            } catch (NoSuchMethodException e7) {
                e = e7;
                method2 = null;
                method3 = method2;
                method4 = method3;
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                SET_APPLICATION_PROTOCOLS = method;
                GET_APPLICATION_PROTOCOLS = method2;
                GET_APPLICATION_PROTOCOL = method3;
                SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                SET_SERVER_NAMES = method6;
                SNI_HOST_NAME = constructor;
            }
            try {
                method3 = SSLSocket.class.getMethod("getApplicationProtocol", null);
                try {
                    Class<?> cls2 = Class.forName("android.net.ssl.SSLSockets");
                    method4 = cls2.getMethod("isSupportedSocket", SSLSocket.class);
                    try {
                        method5 = cls2.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                    } catch (ClassNotFoundException e8) {
                        e = e8;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                    } catch (NoSuchMethodException e9) {
                        e = e9;
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                        method5 = null;
                    }
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    method4 = null;
                } catch (NoSuchMethodException e11) {
                    e = e11;
                    method4 = null;
                }
            } catch (ClassNotFoundException e12) {
                e = e12;
                method3 = null;
                method4 = method3;
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                SET_APPLICATION_PROTOCOLS = method;
                GET_APPLICATION_PROTOCOLS = method2;
                GET_APPLICATION_PROTOCOL = method3;
                SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                SET_SERVER_NAMES = method6;
                SNI_HOST_NAME = constructor;
            } catch (NoSuchMethodException e13) {
                e = e13;
                method3 = null;
                method4 = method3;
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                SET_APPLICATION_PROTOCOLS = method;
                GET_APPLICATION_PROTOCOLS = method2;
                GET_APPLICATION_PROTOCOL = method3;
                SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
                SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                SET_SERVER_NAMES = method6;
                SNI_HOST_NAME = constructor;
            }
            SET_APPLICATION_PROTOCOLS = method;
            GET_APPLICATION_PROTOCOLS = method2;
            GET_APPLICATION_PROTOCOL = method3;
            SSL_SOCKETS_IS_SUPPORTED_SOCKET = method4;
            SSL_SOCKETS_SET_USE_SESSION_TICKET = method5;
            try {
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e14) {
                e = e14;
                method6 = null;
            } catch (NoSuchMethodException e15) {
                e = e15;
                method6 = null;
            }
            SET_SERVER_NAMES = method6;
            SNI_HOST_NAME = constructor;
        }

        public AndroidNegotiator(Platform platform) {
            super(platform);
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
            Constructor<?> constructor;
            boolean z;
            Method method;
            String[] strArrProtocolIds = OkHttpProtocolNegotiator.protocolIds(list);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            if (str != null) {
                try {
                    try {
                        if (OkHttpProtocolNegotiator.isValidHostName(str)) {
                            Method method2 = SSL_SOCKETS_IS_SUPPORTED_SOCKET;
                            if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                                SET_USE_SESSION_TICKETS.invokeOptionalWithoutCheckedException(sSLSocket, Boolean.TRUE);
                            } else {
                                SSL_SOCKETS_SET_USE_SESSION_TICKET.invoke(null, sSLSocket, Boolean.TRUE);
                            }
                            Method method3 = SET_SERVER_NAMES;
                            if (method3 == null || (constructor = SNI_HOST_NAME) == null) {
                                SET_HOSTNAME.invokeOptionalWithoutCheckedException(sSLSocket, str);
                            } else {
                                method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                            }
                        }
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException(e3);
                }
            }
            Method method4 = GET_APPLICATION_PROTOCOL;
            if (method4 != null) {
                try {
                    method4.invoke(sSLSocket, null);
                    SET_APPLICATION_PROTOCOLS.invoke(sSLParameters, strArrProtocolIds);
                    z = true;
                } catch (InvocationTargetException e5) {
                    if (!(e5.getTargetException() instanceof UnsupportedOperationException)) {
                        throw e5;
                    }
                    OkHttpProtocolNegotiator.logger.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
                    z = false;
                }
            } else {
                z = false;
            }
            sSLSocket.setSSLParameters(sSLParameters);
            if (z && (method = GET_APPLICATION_PROTOCOLS) != null && Arrays.equals(strArrProtocolIds, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
                return;
            }
            Object[] objArr = {Platform.concatLengthPrefixed(list)};
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.ALPN_AND_NPN) {
                SET_ALPN_PROTOCOLS.invokeWithoutCheckedException(sSLSocket, objArr);
            }
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.NONE) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            }
            SET_NPN_PROTOCOLS.invokeWithoutCheckedException(sSLSocket, objArr);
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            Method method = GET_APPLICATION_PROTOCOL;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, null);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    if (!(e2.getTargetException() instanceof UnsupportedOperationException)) {
                        throw new RuntimeException(e2);
                    }
                    OkHttpProtocolNegotiator.logger.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                }
            }
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) GET_ALPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, Util.UTF_8);
                    }
                } catch (Exception e3) {
                    OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e3);
                }
            }
            if (this.platform.getTlsExtensionType() != Platform.TlsExtensionType.NONE) {
                try {
                    byte[] bArr2 = (byte[]) GET_NPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                    if (bArr2 != null) {
                        return new String(bArr2, Util.UTF_8);
                    }
                } catch (Exception e5) {
                    OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e5);
                }
            }
            return null;
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String negotiate(SSLSocket sSLSocket, String str, List<Protocol> list) {
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            return selectedProtocol == null ? super.negotiate(sSLSocket, str, list) : selectedProtocol;
        }
    }

    @VisibleForTesting
    public OkHttpProtocolNegotiator(Platform platform) {
        this.platform = (Platform) Preconditions.checkNotNull(platform, "platform");
    }

    @VisibleForTesting
    public static OkHttpProtocolNegotiator createNegotiator(ClassLoader classLoader) {
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e2) {
                logger.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e2);
                return new OkHttpProtocolNegotiator(DEFAULT_PLATFORM);
            }
        }
        return new AndroidNegotiator(DEFAULT_PLATFORM);
    }

    public static OkHttpProtocolNegotiator get() {
        return NEGOTIATOR;
    }

    @VisibleForTesting
    public static boolean isValidHostName(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            GrpcUtil.checkAuthority(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] protocolIds(List<Protocol> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Protocol> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        this.platform.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return this.platform.getSelectedProtocol(sSLSocket);
    }

    public String negotiate(SSLSocket sSLSocket, String str, @Nullable List<Protocol> list) {
        if (list != null) {
            configureTlsExtensions(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            if (selectedProtocol != null) {
                return selectedProtocol;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            this.platform.afterHandshake(sSLSocket);
        }
    }
}
