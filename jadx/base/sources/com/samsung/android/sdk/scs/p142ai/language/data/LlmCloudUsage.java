package com.samsung.android.sdk.scs.p142ai.language.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/language/data/LlmCloudUsage;", "", "remainingUsage", "", "usageList", "", "Lcom/samsung/android/sdk/scs/ai/language/data/LlmCloudUsageItem;", "<init>", "(JLjava/util/List;)V", "getRemainingUsage", "()J", "getUsageList", "()Ljava/util/List;", "toString", "", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LlmCloudUsage {
    private final long remainingUsage;

    @NotNull
    private final List<LlmCloudUsageItem> usageList;

    public LlmCloudUsage(long j, @NotNull List<LlmCloudUsageItem> usageList) {
        Intrinsics.checkNotNullParameter(usageList, "usageList");
        this.remainingUsage = j;
        this.usageList = usageList;
    }

    public final long getRemainingUsage() {
        return this.remainingUsage;
    }

    @NotNull
    public final List<LlmCloudUsageItem> getUsageList() {
        return this.usageList;
    }

    @NotNull
    public String toString() {
        return "remaining Usage :  " + this.remainingUsage + " / UsageList : " + this.usageList;
    }
}
