package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.p */
/* JADX INFO: loaded from: classes5.dex */
public final class C5271p {

    /* JADX INFO: renamed from: a */
    @Nullable
    private static ThreadPoolExecutor f3055a;

    /* JADX INFO: renamed from: a */
    public static Context m4096a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    /* JADX INFO: renamed from: a */
    public static String m4097a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public static Executor m4098a() {
        if (f3055a == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC5257b());
            f3055a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f3055a;
    }
}
