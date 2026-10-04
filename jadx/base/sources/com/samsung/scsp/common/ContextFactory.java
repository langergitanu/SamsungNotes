package com.samsung.scsp.common;

import android.content.Context;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ContextFactory {
    private static final ContextHolder contextHolder = new ContextHolder(0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContextHolder {
        private Supplier<Context> applicationContext;
        private Supplier<Context> baseContext;

        public /* synthetic */ ContextHolder(int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Context lambda$new$0() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Context lambda$new$1() {
            return null;
        }

        private ContextHolder() {
            this.baseContext = new C11623b(0);
            this.applicationContext = new C11623b(1);
        }
    }

    public static void attachApplicationContext(Context context) {
        ContextHolder contextHolder2 = contextHolder;
        contextHolder2.applicationContext = new C11622a(context, 1);
        contextHolder2.baseContext = new C11622a(context, 2);
    }

    public static void attachBaseContext(Context context) {
        contextHolder.baseContext = new C11622a(context, 0);
    }

    public static Context getApplicationContext() {
        return (Context) contextHolder.applicationContext.get();
    }

    public static Context getBaseContext() {
        return (Context) contextHolder.baseContext.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$attachApplicationContext$1(Context context) {
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$attachApplicationContext$2(Context context) {
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Context lambda$attachBaseContext$0(Context context) {
        return context;
    }
}
