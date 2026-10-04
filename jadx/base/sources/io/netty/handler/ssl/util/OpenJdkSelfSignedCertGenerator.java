package io.netty.handler.ssl.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.AccessController;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Date;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class OpenJdkSelfSignedCertGenerator {
    private static final Constructor<X509CertImpl> CERT_IMPL_CONSTRUCTOR;
    private static final Method CERT_IMPL_GET_METHOD;
    private static final Method CERT_IMPL_SIGN_METHOD;
    private static final Method CERT_INFO_SET_METHOD;
    private static final Constructor<?> ISSUER_NAME_CONSTRUCTOR;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) OpenJdkSelfSignedCertGenerator.class);

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Method method;
        Constructor<X509CertImpl> constructor;
        Constructor<X509CertImpl> constructor2;
        Object obj;
        Method method2;
        Object objDoPrivileged;
        Object objDoPrivileged2;
        Object objDoPrivileged3;
        Object objDoPrivileged4;
        Object objDoPrivileged5;
        Method method3 = null;
        try {
            objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return X509CertInfo.class.getMethod(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, String.class, Object.class);
                    } catch (Throwable th) {
                        return th;
                    }
                }
            });
        } catch (Throwable th) {
            th = th;
            method = null;
            constructor = null;
        }
        if (!(objDoPrivileged instanceof Method)) {
            throw ((Throwable) objDoPrivileged);
        }
        method = (Method) objDoPrivileged;
        try {
            objDoPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator.2
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.security.x509.CertificateIssuerName", false, PlatformDependent.getClassLoader(OpenJdkSelfSignedCertGenerator.class)).getConstructor(X500Name.class);
                    } catch (Throwable th2) {
                        return th2;
                    }
                }
            });
        } catch (Throwable th2) {
            th = th2;
            constructor = null;
            constructor2 = constructor;
            obj = constructor2;
            logger.debug("OpenJdkSelfSignedCertGenerator not supported", th);
            method2 = obj;
            CERT_INFO_SET_METHOD = method;
            ISSUER_NAME_CONSTRUCTOR = constructor;
            CERT_IMPL_CONSTRUCTOR = constructor2;
            CERT_IMPL_GET_METHOD = method2;
            CERT_IMPL_SIGN_METHOD = method3;
        }
        if (!(objDoPrivileged2 instanceof Constructor)) {
            throw ((Throwable) objDoPrivileged2);
        }
        constructor = (Constructor) objDoPrivileged2;
        try {
            objDoPrivileged3 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return X509CertImpl.class.getConstructor(X509CertInfo.class);
                    } catch (Throwable th3) {
                        return th3;
                    }
                }
            });
        } catch (Throwable th3) {
            th = th3;
            constructor2 = null;
            obj = constructor2;
            logger.debug("OpenJdkSelfSignedCertGenerator not supported", th);
            method2 = obj;
            CERT_INFO_SET_METHOD = method;
            ISSUER_NAME_CONSTRUCTOR = constructor;
            CERT_IMPL_CONSTRUCTOR = constructor2;
            CERT_IMPL_GET_METHOD = method2;
            CERT_IMPL_SIGN_METHOD = method3;
        }
        if (!(objDoPrivileged3 instanceof Constructor)) {
            throw ((Throwable) objDoPrivileged3);
        }
        constructor2 = (Constructor) objDoPrivileged3;
        try {
            objDoPrivileged4 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator.4
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return X509CertImpl.class.getMethod("get", String.class);
                    } catch (Throwable th4) {
                        return th4;
                    }
                }
            });
        } catch (Throwable th4) {
            th = th4;
            obj = null;
        }
        if (!(objDoPrivileged4 instanceof Method)) {
            throw ((Throwable) objDoPrivileged4);
        }
        Method method4 = (Method) objDoPrivileged4;
        try {
            objDoPrivileged5 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.util.OpenJdkSelfSignedCertGenerator.5
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return X509CertImpl.class.getMethod("sign", PrivateKey.class, String.class);
                    } catch (Throwable th5) {
                        return th5;
                    }
                }
            });
        } catch (Throwable th5) {
            th = th5;
            obj = method4;
            logger.debug("OpenJdkSelfSignedCertGenerator not supported", th);
            method2 = obj;
        }
        if (!(objDoPrivileged5 instanceof Method)) {
            throw ((Throwable) objDoPrivileged5);
        }
        method3 = (Method) objDoPrivileged5;
        method2 = method4;
        CERT_INFO_SET_METHOD = method;
        ISSUER_NAME_CONSTRUCTOR = constructor;
        CERT_IMPL_CONSTRUCTOR = constructor2;
        CERT_IMPL_GET_METHOD = method2;
        CERT_IMPL_SIGN_METHOD = method3;
    }

    private OpenJdkSelfSignedCertGenerator() {
    }

    @SuppressJava6Requirement(reason = "Usage guarded by dependency check")
    public static String[] generate(String str, KeyPair keyPair, SecureRandom secureRandom, Date date, Date date2, String str2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method method = CERT_INFO_SET_METHOD;
        if (method == null || ISSUER_NAME_CONSTRUCTOR == null || CERT_IMPL_CONSTRUCTOR == null || CERT_IMPL_GET_METHOD == null || CERT_IMPL_SIGN_METHOD == null) {
            throw new UnsupportedOperationException("OpenJdkSelfSignedCertGenerator not supported on the used JDK version");
        }
        PrivateKey privateKey = keyPair.getPrivate();
        X509CertInfo x509CertInfo = new X509CertInfo();
        X500Name x500Name = new X500Name(AbstractC0541b.m772n("CN=", str));
        method.invoke(x509CertInfo, "version", new CertificateVersion(2));
        method.invoke(x509CertInfo, "serialNumber", new CertificateSerialNumber(new BigInteger(64, secureRandom)));
        try {
            method.invoke(x509CertInfo, "subject", new CertificateSubjectName(x500Name));
        } catch (InvocationTargetException e) {
            if (!(e.getCause() instanceof CertificateException)) {
                throw e;
            }
            CERT_INFO_SET_METHOD.invoke(x509CertInfo, "subject", x500Name);
        }
        try {
            CERT_INFO_SET_METHOD.invoke(x509CertInfo, OpenIdProviderConfiguration.SerializedNames.ISSUER, ISSUER_NAME_CONSTRUCTOR.newInstance(x500Name));
        } catch (InvocationTargetException e2) {
            if (!(e2.getCause() instanceof CertificateException)) {
                throw e2;
            }
            CERT_INFO_SET_METHOD.invoke(x509CertInfo, OpenIdProviderConfiguration.SerializedNames.ISSUER, x500Name);
        }
        Method method2 = CERT_INFO_SET_METHOD;
        method2.invoke(x509CertInfo, "validity", new CertificateValidity(date, date2));
        method2.invoke(x509CertInfo, "key", new CertificateX509Key(keyPair.getPublic()));
        method2.invoke(x509CertInfo, "algorithmID", new CertificateAlgorithmId(AlgorithmId.get("1.2.840.113549.1.1.11")));
        Constructor<X509CertImpl> constructor = CERT_IMPL_CONSTRUCTOR;
        X509CertImpl x509CertImplNewInstance = constructor.newInstance(x509CertInfo);
        Method method3 = CERT_IMPL_SIGN_METHOD;
        method3.invoke(x509CertImplNewInstance, privateKey, str2.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256withRSA");
        method2.invoke(x509CertInfo, "algorithmID.algorithm", CERT_IMPL_GET_METHOD.invoke(x509CertImplNewInstance, "x509.algorithm"));
        X509CertImpl x509CertImplNewInstance2 = constructor.newInstance(x509CertInfo);
        method3.invoke(x509CertImplNewInstance2, privateKey, str2.equalsIgnoreCase("EC") ? "SHA256withECDSA" : "SHA256withRSA");
        x509CertImplNewInstance2.verify(keyPair.getPublic());
        return SelfSignedCertificate.newSelfSignedCertificate(str, privateKey, x509CertImplNewInstance2);
    }
}
