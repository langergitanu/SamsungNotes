package org.apache.poi.sun.misc;

import java.io.Console;
import java.io.FileDescriptor;
import java.net.HttpCookie;
import java.nio.ByteOrder;
import java.security.ProtectionDomain;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SharedSecrets {
    private static JavaAWTAccess javaAWTAccess;
    private static JavaIOAccess javaIOAccess;
    private static JavaIOFileDescriptorAccess javaIOFileDescriptorAccess;
    private static JavaLangAccess javaLangAccess;
    private static JavaNetAccess javaNetAccess;
    private static JavaNetHttpCookieAccess javaNetHttpCookieAccess;
    private static JavaNioAccess javaNioAccess;
    private static JavaSecurityAccess javaSecurityAccess;
    private static JavaSecurityProtectionDomainAccess javaSecurityProtectionDomainAccess;
    private static JavaUtilJarAccess javaUtilJarAccess;
    private static JavaUtilZipFileAccess javaUtilZipFileAccess;
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static JavaAWTAccess getJavaAWTAccess() {
        JavaAWTAccess javaAWTAccess2 = javaAWTAccess;
        if (javaAWTAccess2 == null) {
            return null;
        }
        return javaAWTAccess2;
    }

    public static JavaIOAccess getJavaIOAccess() {
        if (javaIOAccess == null) {
            unsafe.ensureClassInitialized(Console.class);
        }
        return javaIOAccess;
    }

    public static JavaIOFileDescriptorAccess getJavaIOFileDescriptorAccess() {
        if (javaIOFileDescriptorAccess == null) {
            unsafe.ensureClassInitialized(FileDescriptor.class);
        }
        return javaIOFileDescriptorAccess;
    }

    public static JavaLangAccess getJavaLangAccess() {
        return javaLangAccess;
    }

    public static JavaNetAccess getJavaNetAccess() {
        return javaNetAccess;
    }

    public static JavaNetHttpCookieAccess getJavaNetHttpCookieAccess() {
        if (javaNetHttpCookieAccess == null) {
            unsafe.ensureClassInitialized(HttpCookie.class);
        }
        return javaNetHttpCookieAccess;
    }

    public static JavaNioAccess getJavaNioAccess() {
        if (javaNioAccess == null) {
            unsafe.ensureClassInitialized(ByteOrder.class);
        }
        return javaNioAccess;
    }

    public static JavaSecurityAccess getJavaSecurityAccess() {
        return javaSecurityAccess;
    }

    public static JavaSecurityProtectionDomainAccess getJavaSecurityProtectionDomainAccess() {
        if (javaSecurityProtectionDomainAccess == null) {
            unsafe.ensureClassInitialized(ProtectionDomain.class);
        }
        return javaSecurityProtectionDomainAccess;
    }

    public static JavaUtilZipFileAccess getJavaUtilZipFileAccess() {
        if (javaUtilZipFileAccess == null) {
            unsafe.ensureClassInitialized(ZipFile.class);
        }
        return javaUtilZipFileAccess;
    }

    public static JavaUtilJarAccess javaUtilJarAccess() {
        if (javaUtilJarAccess == null) {
            unsafe.ensureClassInitialized(JarFile.class);
        }
        return javaUtilJarAccess;
    }

    public static void setJavaAWTAccess(JavaAWTAccess javaAWTAccess2) {
        javaAWTAccess = javaAWTAccess2;
    }

    public static void setJavaIOAccess(JavaIOAccess javaIOAccess2) {
        javaIOAccess = javaIOAccess2;
    }

    public static void setJavaIOFileDescriptorAccess(JavaIOFileDescriptorAccess javaIOFileDescriptorAccess2) {
        javaIOFileDescriptorAccess = javaIOFileDescriptorAccess2;
    }

    public static void setJavaLangAccess(JavaLangAccess javaLangAccess2) {
        javaLangAccess = javaLangAccess2;
    }

    public static void setJavaNetAccess(JavaNetAccess javaNetAccess2) {
        javaNetAccess = javaNetAccess2;
    }

    public static void setJavaNetHttpCookieAccess(JavaNetHttpCookieAccess javaNetHttpCookieAccess2) {
        javaNetHttpCookieAccess = javaNetHttpCookieAccess2;
    }

    public static void setJavaNioAccess(JavaNioAccess javaNioAccess2) {
        javaNioAccess = javaNioAccess2;
    }

    public static void setJavaSecurityAccess(JavaSecurityAccess javaSecurityAccess2) {
        javaSecurityAccess = javaSecurityAccess2;
    }

    public static void setJavaSecurityProtectionDomainAccess(JavaSecurityProtectionDomainAccess javaSecurityProtectionDomainAccess2) {
        javaSecurityProtectionDomainAccess = javaSecurityProtectionDomainAccess2;
    }

    public static void setJavaUtilJarAccess(JavaUtilJarAccess javaUtilJarAccess2) {
        javaUtilJarAccess = javaUtilJarAccess2;
    }

    public static void setJavaUtilZipFileAccess(JavaUtilZipFileAccess javaUtilZipFileAccess2) {
        javaUtilZipFileAccess = javaUtilZipFileAccess2;
    }
}
