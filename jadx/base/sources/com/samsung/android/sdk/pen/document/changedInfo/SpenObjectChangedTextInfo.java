package com.samsung.android.sdk.pen.document.changedInfo;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedTextInfo;", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedInfo;", "<init>", "()V", "textChangedType", "", "before", "index", "count", "textChangedProperties", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectChangedTextInfo extends SpenObjectChangedInfo {
    public static final int CHANGED_ALL = 5;
    public static final int CHANGED_BOUND = 4;
    public static final int CHANGED_MAX = 7;
    public static final int CHANGED_OBJECT_SPAN = 6;
    public static final int CHANGED_PARA = 3;
    public static final int CHANGED_SPAN = 2;
    public static final int CHANGED_TEXT = 1;
    public static final int CHANGED_UNDEFIND = 0;

    @JvmField
    public int before;

    @JvmField
    public int count;

    @JvmField
    public int index;

    @JvmField
    public int textChangedProperties;

    @JvmField
    public int textChangedType;
}
