package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00138DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00138DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfigHelper;", "", "context", "Landroid/content/Context;", "orientation", "", "<init>", "(Landroid/content/Context;I)V", "(I)V", "mOrientation", "mDirection", "value", "getOrientation", "()I", "setOrientation", "direction", "getDirection", "setDirection", "isRTL", "", "()Z", "isLTR", "isHorizontal", "isVertical", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenLayoutConfigHelper {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int mDirection;
    private int mOrientation;

    public SpenLayoutConfigHelper(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOrientation = i;
        this.mDirection = AbstractC0541b.m759a(context);
    }

    /* JADX INFO: renamed from: getDirection, reason: from getter */
    public final int getMDirection() {
        return this.mDirection;
    }

    /* JADX INFO: renamed from: getOrientation, reason: from getter */
    public int getMOrientation() {
        return this.mOrientation;
    }

    public final boolean isHorizontal() {
        return this.mOrientation == 0;
    }

    public final boolean isLTR() {
        return this.mDirection == 0;
    }

    public final boolean isRTL() {
        return this.mDirection == 1;
    }

    public final boolean isVertical() {
        return this.mOrientation == 1;
    }

    public final void setDirection(int i) {
        this.mDirection = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public SpenLayoutConfigHelper(int i) {
        this.mOrientation = i;
        this.mDirection = 0;
    }
}
