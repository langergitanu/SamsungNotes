package com.samsung.android.support.senl.p148nt.base.composer.content;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0016\u0010\u0010\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0016\u0010\u0011\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/content/ObjectTypeHelper;", "", "<init>", "()V", "isStrokeType", "", "type", "", "isTextType", "isMathPlotType", "isMathType", "isTableType", "hasPureStrokeTypeOnly", "objectBases", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "hasStrokeAndMathPlotType", "hasMathType", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ObjectTypeHelper {

    @NotNull
    public static final ObjectTypeHelper INSTANCE = new ObjectTypeHelper();

    private ObjectTypeHelper() {
    }

    public final boolean hasMathType(@Nullable List<? extends SpenObjectBase> objectBases) {
        List<? extends SpenObjectBase> list = objectBases;
        if (list != null && !list.isEmpty()) {
            Iterator<? extends SpenObjectBase> it = objectBases.iterator();
            while (it.hasNext()) {
                if (isMathType(it.next().getType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean hasPureStrokeTypeOnly(@Nullable List<? extends SpenObjectBase> objectBases) {
        List<? extends SpenObjectBase> list = objectBases;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<? extends SpenObjectBase> it = objectBases.iterator();
        while (it.hasNext()) {
            if (it.next().getType() != 1) {
                return false;
            }
        }
        return true;
    }

    public final boolean hasStrokeAndMathPlotType(@Nullable List<? extends SpenObjectBase> objectBases) {
        List<? extends SpenObjectBase> list = objectBases;
        if (list != null && !list.isEmpty()) {
            for (SpenObjectBase spenObjectBase : objectBases) {
                if (isStrokeType(spenObjectBase.getType()) || isMathPlotType(spenObjectBase.getType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isMathPlotType(int type) {
        return type == 21 || type == 20;
    }

    public final boolean isMathType(int type) {
        return type == 21;
    }

    public final boolean isStrokeType(int type) {
        return type == 1 || type == 7 || type == 8 || type == 4;
    }

    public final boolean isTableType(int type) {
        return type == 22;
    }

    public final boolean isTextType(int type) {
        return type == 2 || type == 7;
    }
}
