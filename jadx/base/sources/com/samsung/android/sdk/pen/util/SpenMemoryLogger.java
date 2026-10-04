package com.samsung.android.sdk.pen.util;

import android.os.Debug;
import android.util.Log;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenMemoryLogger;", "", "<init>", "()V", "printPssFromNative", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMemoryLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenMemoryLogger$Companion;", "", "<init>", "()V", "printPss", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void printPss() {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            long totalPss = ((long) memoryInfo.getTotalPss()) / 1024;
            long j = ((long) memoryInfo.dalvikPss) / 1024;
            long j2 = ((long) memoryInfo.nativePss) / 1024;
            long j3 = ((long) memoryInfo.otherPss) / 1024;
            StringBuilder sbM1323p = AbstractC1974b.m1323p(totalPss, "[SpenMemoryLogger] totalPss=", ", dalvikPss=");
            sbM1323p.append(j);
            AbstractC1038a.m1223x(sbM1323p, ", nativePss=", j2, ", otherPss=");
            sbM1323p.append(j3);
            Log.i("SpenMemoryLogger", sbM1323p.toString());
        }

        private Companion() {
        }
    }

    private final void printPssFromNative() {
        INSTANCE.printPss();
    }
}
