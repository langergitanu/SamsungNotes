package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\t¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ObjectTaskStyle;", "", "contentBase", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "(Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;)V", "mType", "", "getMType", "()I", "setMType", "(I)V", "mTaskId", "getMTaskId", "setMTaskId", "mInfo", "getMInfo", "setMInfo", "mTaskNumber", "getMTaskNumber", "setMTaskNumber", "horizontalSpace", "getHorizontalSpace", "setTaskType", "", "type", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ObjectTaskStyle {
    private static final int OBJECT_PADDING_DDP = 10;
    public static final int TASK_BULLET = 3;
    public static final int TASK_DONE = 2;
    public static final int TASK_NONE = 0;
    public static final int TASK_NUMBER = 4;
    public static final int TASK_NUMBER_MANUAL = 101;
    public static final int TASK_TODO = 1;
    private int mInfo;
    private int mTaskId;
    private int mTaskNumber;
    private int mType;

    public ObjectTaskStyle(@NotNull SpenContentBase contentBase) {
        Intrinsics.checkNotNullParameter(contentBase, "contentBase");
        this.mType = contentBase.getTaskStyle();
        this.mTaskId = contentBase.getTaskId();
        this.mTaskNumber = contentBase.getTaskNumber();
        if (this.mType == 4) {
            this.mInfo = contentBase.getTaskNumber();
        }
    }

    public final int getHorizontalSpace() {
        int i = this.mType;
        if (i == 0) {
            return 0;
        }
        if (i != 1 && i != 2 && i != 3) {
            if (i != 4) {
                return 0;
            }
            if (this.mTaskNumber > 9) {
                return 55;
            }
        }
        return 52;
    }

    public final int getMInfo() {
        return this.mInfo;
    }

    public final int getMTaskId() {
        return this.mTaskId;
    }

    public final int getMTaskNumber() {
        return this.mTaskNumber;
    }

    public final int getMType() {
        return this.mType;
    }

    public final void setMInfo(int i) {
        this.mInfo = i;
    }

    public final void setMTaskId(int i) {
        this.mTaskId = i;
    }

    public final void setMTaskNumber(int i) {
        this.mTaskNumber = i;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final void setTaskType(int type) {
        this.mType = type;
    }
}
