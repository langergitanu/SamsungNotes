package com.samsung.android.sdk.pen.recogengine.hwrdata;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrExtraData;", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrData;", "<init>", "()V", "mExtraDataType", "Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrExtraDataType;", "getMExtraDataType", "()Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrExtraDataType;", "setMExtraDataType", "(Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrExtraDataType;)V", "type", "extraDataType", "getExtraDataType", "setExtraDataType", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrExtraData extends SpenHwrData {

    @NotNull
    private static final String TAG = "SpenHwrExtraData";

    @NotNull
    private SpenHwrExtraDataType mExtraDataType = SpenHwrExtraDataType.EXTRA_DATA_TYPE_NONE;

    public SpenHwrExtraData() {
        this.mType = SpenHwrDataType.HWR_DATA_TYPE_EXTRA;
    }

    @NotNull
    /* JADX INFO: renamed from: getExtraDataType, reason: from getter */
    public final SpenHwrExtraDataType getMExtraDataType() {
        return this.mExtraDataType;
    }

    @NotNull
    public final SpenHwrExtraDataType getMExtraDataType() {
        return this.mExtraDataType;
    }

    public final void setExtraDataType(@NotNull SpenHwrExtraDataType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{type.toString()}, 1, "SpenHwrExtraData::setExtraDataType : %s", "format(format, *args)", TAG);
        this.mExtraDataType = type;
    }

    public final void setMExtraDataType(@NotNull SpenHwrExtraDataType spenHwrExtraDataType) {
        Intrinsics.checkNotNullParameter(spenHwrExtraDataType, "<set-?>");
        this.mExtraDataType = spenHwrExtraDataType;
    }
}
