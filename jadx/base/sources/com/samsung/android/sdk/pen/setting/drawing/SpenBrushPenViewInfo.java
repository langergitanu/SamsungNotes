package com.samsung.android.sdk.pen.setting.drawing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005J\u001e\u0010 \u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010!\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenViewInfo;", "", "penName", "", "penStringId", "", "<init>", "(Ljava/lang/String;I)V", "getPenName", "()Ljava/lang/String;", "getPenStringId", "()I", "value", "penResourceId", "getPenResourceId", "penMaskResourceId", "getPenMaskResourceId", "penMaskStrokeResourceId", "getPenMaskStrokeResourceId", "", "upperWeight", "getUpperWeight", "()F", "maskWeight", "getMaskWeight", "bottomWeight", "getBottomWeight", "setResourceId", "", "penResource", "maskResource", "maskStrokeResource", "setWeight", "weightSum", "getWeightSum", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenViewInfo {
    private float bottomWeight;
    private float maskWeight;
    private int penMaskResourceId;
    private int penMaskStrokeResourceId;

    @NotNull
    private final String penName;
    private int penResourceId;
    private final int penStringId;
    private float upperWeight;

    public SpenBrushPenViewInfo(@NotNull String penName, int i) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        this.penName = penName;
        this.penStringId = i;
        setResourceId(0, 0, 0);
        setWeight(0.0f, 0.0f, 0.0f);
    }

    public final float getBottomWeight() {
        return this.bottomWeight;
    }

    public final float getMaskWeight() {
        return this.maskWeight;
    }

    public final int getPenMaskResourceId() {
        return this.penMaskResourceId;
    }

    public final int getPenMaskStrokeResourceId() {
        return this.penMaskStrokeResourceId;
    }

    @NotNull
    public final String getPenName() {
        return this.penName;
    }

    public final int getPenResourceId() {
        return this.penResourceId;
    }

    public final int getPenStringId() {
        return this.penStringId;
    }

    public final float getUpperWeight() {
        return this.upperWeight;
    }

    public final float getWeightSum() {
        return this.upperWeight + this.maskWeight + this.bottomWeight;
    }

    public final void setResourceId(int penResource, int maskResource, int maskStrokeResource) {
        this.penResourceId = penResource;
        this.penMaskResourceId = maskResource;
        this.penMaskStrokeResourceId = maskStrokeResource;
    }

    public final void setWeight(float upperWeight, float maskWeight, float bottomWeight) {
        this.upperWeight = upperWeight;
        this.maskWeight = maskWeight;
        this.bottomWeight = bottomWeight;
    }
}
