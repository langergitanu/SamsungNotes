package com.samsung.android.sdk.pen.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/debug/SpenMemoryLoggerReceiver;", "Landroid/content/BroadcastReceiver;", "memoryLogger", "Lcom/samsung/android/sdk/pen/debug/ISpenGraphicMemoryLogger;", "<init>", "(Lcom/samsung/android/sdk/pen/debug/ISpenGraphicMemoryLogger;)V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMemoryLoggerReceiver extends BroadcastReceiver {

    @NotNull
    private final ISpenGraphicMemoryLogger memoryLogger;

    public SpenMemoryLoggerReceiver(@NotNull ISpenGraphicMemoryLogger memoryLogger) {
        Intrinsics.checkNotNullParameter(memoryLogger, "memoryLogger");
        this.memoryLogger = memoryLogger;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "com.samsung.android.sdk.composer.TRIGGER_MEMORY_LOGGING")) {
            Log.i("SpenMemoryLoggerReceiver", "SpenMemoryLoggerReceiver Broadcast Received. Triggering memory logger.");
            this.memoryLogger.printGraphicMemoryUsage();
        }
    }
}
