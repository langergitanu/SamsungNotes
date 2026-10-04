package com.samsung.android.sdk.pen.document.changedInfo;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedInfo;", "", "<init>", "()V", "type", "", "property", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "beforeRect", "Landroid/graphics/RectF;", "afterRect", "objectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "beforeRectList", "afterRectList", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenObjectChangedInfo {
    public static final int CHANGED_BASE = 0;
    public static final int CHANGED_MAX = 5;
    public static final int CHANGED_OBJECT_LIST = 4;
    public static final int CHANGED_TEXT = 1;
    public static final int PROPERTY_FOCUS = 15;
    public static final int PROPERTY_MAX = 16;
    public static final int PROPERTY_RECT = 8;
    public static final int PROPERTY_UNDEFINED = 0;

    @JvmField
    @Nullable
    public RectF afterRect;

    @JvmField
    @Nullable
    public ArrayList<RectF> afterRectList;

    @JvmField
    @Nullable
    public RectF beforeRect;

    @JvmField
    @Nullable
    public ArrayList<RectF> beforeRectList;

    @JvmField
    @Nullable
    public SpenObjectBase objectBase;

    @JvmField
    @Nullable
    public ArrayList<SpenObjectBase> objectList;

    @JvmField
    public int property;

    @JvmField
    public int type;
}
