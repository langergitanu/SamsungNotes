package com.samsung.android.app.sdk.deepsky.donation;

import android.content.ComponentName;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/donation/WidgetContribution;", "", WidgetConstant.WIDGET_SAMSUNG_EXTRA_KEY, "Landroid/content/ComponentName;", "score", "", XmlErrorCodes.DURATION, "", "startTime", "willProvideReason", "", "(Landroid/content/ComponentName;IJJZ)V", "getComponentName", "()Landroid/content/ComponentName;", "getDuration", "()J", "getScore", "()I", "getStartTime", "getWillProvideReason", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class WidgetContribution {

    @NotNull
    private final ComponentName componentName;
    private final long duration;
    private final int score;
    private final long startTime;
    private final boolean willProvideReason;

    public WidgetContribution(@NotNull ComponentName componentName, int i, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        this.componentName = componentName;
        this.score = i;
        this.duration = j;
        this.startTime = j2;
        this.willProvideReason = z;
    }

    public static /* synthetic */ WidgetContribution copy$default(WidgetContribution widgetContribution, ComponentName componentName, int i, long j, long j2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            componentName = widgetContribution.componentName;
        }
        if ((i2 & 2) != 0) {
            i = widgetContribution.score;
        }
        if ((i2 & 4) != 0) {
            j = widgetContribution.duration;
        }
        if ((i2 & 8) != 0) {
            j2 = widgetContribution.startTime;
        }
        if ((i2 & 16) != 0) {
            z = widgetContribution.willProvideReason;
        }
        boolean z2 = z;
        long j3 = j2;
        return widgetContribution.copy(componentName, i, j, j3, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getWillProvideReason() {
        return this.willProvideReason;
    }

    @NotNull
    public final WidgetContribution copy(@NotNull ComponentName componentName, int score, long duration, long startTime, boolean willProvideReason) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        return new WidgetContribution(componentName, score, duration, startTime, willProvideReason);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetContribution)) {
            return false;
        }
        WidgetContribution widgetContribution = (WidgetContribution) other;
        return Intrinsics.areEqual(this.componentName, widgetContribution.componentName) && this.score == widgetContribution.score && this.duration == widgetContribution.duration && this.startTime == widgetContribution.startTime && this.willProvideReason == widgetContribution.willProvideReason;
    }

    @NotNull
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getScore() {
        return this.score;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final boolean getWillProvideReason() {
        return this.willProvideReason;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int iM1311d = AbstractC1974b.m1311d(this.startTime, AbstractC1974b.m1311d(this.duration, AbstractC0622a.m1157c(this.score, this.componentName.hashCode() * 31, 31), 31), 31);
        boolean z = this.willProvideReason;
        ?? r12 = z;
        if (z) {
            r12 = 1;
        }
        return iM1311d + r12;
    }

    @NotNull
    public String toString() {
        ComponentName componentName = this.componentName;
        int i = this.score;
        long j = this.duration;
        long j2 = this.startTime;
        boolean z = this.willProvideReason;
        StringBuilder sb = new StringBuilder("WidgetContribution(componentName=");
        sb.append(componentName);
        sb.append(", score=");
        sb.append(i);
        sb.append(", duration=");
        sb.append(j);
        AbstractC1038a.m1223x(sb, ", startTime=", j2, ", willProvideReason=");
        return AbstractC0000a.m14k(sb, z, ")");
    }
}
