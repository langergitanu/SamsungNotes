package com.samsung.android.sdk.scs.p142ai.language.data;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/language/data/LlmCloudUsageItem;", "", "packageName", "", ClientCookie.DOMAIN_ATTR, "usedUsage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getDomain", "getUsedUsage", "()J", "toString", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LlmCloudUsageItem {

    @NotNull
    private final String domain;

    @NotNull
    private final String packageName;
    private final long usedUsage;

    public LlmCloudUsageItem(@NotNull String packageName, @NotNull String domain, long j) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.packageName = packageName;
        this.domain = domain;
        this.usedUsage = j;
    }

    @NotNull
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final long getUsedUsage() {
        return this.usedUsage;
    }

    @NotNull
    public String toString() {
        String str = this.packageName;
        String str2 = this.domain;
        return AbstractC2821a.m2224o(AbstractC0000a.m16m("packageName : ", str, " \ndomain : ", str2, "\nusedUsage : "), MarkdownDocument.NEW_LINE, this.usedUsage);
    }
}
