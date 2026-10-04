package io.grpc.okhttp;

import io.grpc.okhttp.internal.framed.Settings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpSettingsUtil {
    public static final int ENABLE_PUSH = 2;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_HEADER_LIST_SIZE = 6;

    public static int get(Settings settings, int i) {
        return settings.get(i);
    }

    public static boolean isSet(Settings settings, int i) {
        return settings.isSet(i);
    }

    public static void set(Settings settings, int i, int i2) {
        settings.set(i, 0, i2);
    }
}
