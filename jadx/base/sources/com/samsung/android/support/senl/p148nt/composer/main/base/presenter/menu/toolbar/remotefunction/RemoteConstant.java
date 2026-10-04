package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RemoteConstant {
    public static final String DIVIDE = ":";
    public static final int IDX_VERSION_MAJOR = 1;
    public static final int IDX_VERSION_MINOR = 2;
    public static final String KEY_ACTION = "key_action";
    public static final String KEY_CLASS = "key_class";
    public static final String KEY_MESSAGE = "key_message";
    public static final String KEY_METHOD = "key_method";
    public static final String KEY_PARAM_TYPE = "key_param_type";
    public static final String KEY_PARAM_VALUE = "key_param_value";
    public static final String KEY_TYPE = "key_type";
    public static final String NO_FUNCTION = "NO_FUNCTION";
    public static final String REMOTE_VERSION = "0.3.3";
    public static final String VERSION_DIVIDE = "\\.";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RemoteExecutor {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RemoteFunctionName {
        String value() default "NO_FUNCTION";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RemoteReceiverFunctionName {
        String value() default "NO_FUNCTION";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RemoteSenderType {
        int value() default 1;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Type {
        public static final int CLIENT = 2;
        public static final int LOCAL = 1;
        public static final int P2P = 6;
        public static final int SERVER = 4;
    }

    public static String getMajorVersion() {
        return getMajorVersion(REMOTE_VERSION);
    }

    public static String getMinorVersion() {
        return getMinorVersion(REMOTE_VERSION);
    }

    public static String getMajorVersion(String str) {
        return str.split(VERSION_DIVIDE)[1];
    }

    public static String getMinorVersion(String str) {
        return str.split(VERSION_DIVIDE)[2];
    }
}
