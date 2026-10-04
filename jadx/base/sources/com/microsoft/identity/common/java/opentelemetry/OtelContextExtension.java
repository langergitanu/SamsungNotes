package com.microsoft.identity.common.java.opentelemetry;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.context.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OtelContextExtension {
    private static final String TAG = "OtelContextExtension";

    public static Runnable wrap(Runnable runnable) {
        try {
            return Context.current().wrap(runnable);
        } catch (NoSuchMethodError e) {
            Logger.error(AbstractC0622a.m1170p(TAG, ":wrapRunnableWithCurrentTelemetryContext", new StringBuilder()), e.getMessage(), e);
            return runnable;
        }
    }
}
