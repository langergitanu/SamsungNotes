package com.google.android.play.core.missingsplits;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class MissingSplitsManagerFactory {

    /* JADX INFO: renamed from: a */
    private static final AtomicReference<Boolean> f3002a = new AtomicReference<>(null);

    @NonNull
    public static MissingSplitsManager create(@NonNull Context context) {
        return new C5246b(context, Runtime.getRuntime(), new C5245a(context, context.getPackageManager()), f3002a);
    }
}
