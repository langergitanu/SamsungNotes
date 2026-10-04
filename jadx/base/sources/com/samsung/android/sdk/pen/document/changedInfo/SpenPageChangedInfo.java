package com.samsung.android.sdk.pen.document.changedInfo;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/changedInfo/SpenPageChangedInfo;", "", "<init>", "()V", "pageChangedType", "", "layerIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPageChangedInfo {
    public static final int CHANGE_TEMPLATE_TYPE = 5;
    public static final int CHANGE_TYPE_ACTION_LINK = 6;
    public static final int CHANGE_TYPE_BACKGROUND_COLOR = 2;
    public static final int CHANGE_TYPE_BACKGROUND_IMAGE = 7;
    public static final int CHANGE_TYPE_CURRENT_LAYER = 9;
    public static final int CHANGE_TYPE_MAX = 11;
    public static final int CHANGE_TYPE_MERGE_LAYERS = 10;
    public static final int CHANGE_TYPE_OFFSET = 1;
    public static final int CHANGE_TYPE_PDF = 3;
    public static final int CHANGE_TYPE_SIZE = 4;
    public static final int CHANGE_TYPE_THUMBNAIL = 8;
    public static final int CHANGE_TYPE_UNDEFINED = 0;

    @JvmField
    @Nullable
    public ArrayList<Integer> layerIdList;

    @JvmField
    public int pageChangedType;
}
