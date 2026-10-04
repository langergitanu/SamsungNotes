package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectTypeHelper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectTypeUtil {
    public static boolean hasMathType(List<SpenObjectBase> list) {
        return ObjectTypeHelper.INSTANCE.hasMathType(list);
    }

    public static boolean hasPureStrokeTypeOnly(List<SpenObjectBase> list) {
        return ObjectTypeHelper.INSTANCE.hasPureStrokeTypeOnly(list);
    }

    public static boolean hasStrokeAndMathPlotType(List<SpenObjectBase> list) {
        return ObjectTypeHelper.INSTANCE.hasStrokeAndMathPlotType(list);
    }

    public static boolean isMathType(int i) {
        return ObjectTypeHelper.INSTANCE.isMathType(i);
    }

    public static boolean isStrokeType(int i) {
        return ObjectTypeHelper.INSTANCE.isStrokeType(i);
    }

    public static boolean isTableType(int i) {
        return ObjectTypeHelper.INSTANCE.isTableType(i);
    }

    public static boolean isTextType(int i) {
        return ObjectTypeHelper.INSTANCE.isTextType(i);
    }
}
