package com.samsung.android.sdk.pen.document.changedInfo;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/changedInfo/SpenLayerChangedInfo;", "", "<init>", "()V", "layerChangedType", "", "layerId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenLayerChangedInfo {
    public static final int CHANGED_ALPHA_LOCK = 6;
    public static final int CHANGED_BITMAP = 5;
    public static final int CHANGED_LOCK_STATE = 3;
    public static final int CHANGED_MAX = 7;
    public static final int CHANGED_THUMBNAIL = 4;
    public static final int CHANGED_TRANSPARENCY = 1;
    public static final int CHANGED_UNDEFINED = 0;
    public static final int CHANGED_VISIBILITY = 2;

    @JvmField
    public int layerChangedType;

    @JvmField
    public int layerId = -1;
}
