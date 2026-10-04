package com.samsung.android.sdk.pen.document;

import android.graphics.PointF;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.SpenError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b-\u0018\u0000 S2\u00020\u0001:\u0001SB\t\b\u0010¢\u0006\u0004\b\u0002\u0010\u0003B%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\tB-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0002\u0010\fJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0007J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0005J\u0016\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'J\u0018\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0007J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0005J\u0016\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'J\u000e\u0010/\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0005J \u00100\u001a\u00020#2\u0006\u0010-\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0005J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u0005H\u0002J\u0011\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0005H\u0082 J-\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082 J5\u00109\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0082 J\u0019\u0010:\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010;\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0082 J\u0011\u0010<\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u0005H\u0082 J\u0019\u0010=\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0082 J!\u0010>\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H\u0082 J\u0019\u0010?\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0082 J!\u0010@\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0082 J\u0011\u0010A\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0082 J!\u0010B\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0007H\u0082 J\u0019\u0010C\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0082 J!\u0010D\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0082 J\u0019\u0010E\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0082 J1\u0010F\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00012\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0007H\u0082 J1\u0010I\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00012\u0006\u0010G\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u000bH\u0082 J1\u0010K\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00012\u0006\u0010G\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0082 J\u0019\u0010L\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0082 J!\u0010M\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010N\u001a\u00020\u0005H\u0082 J\u001b\u0010O\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0082 J\u0011\u0010P\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0005H\u0082 J\u001b\u0010Q\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0082 J\u0011\u0010R\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0005H\u0082 R(\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u0019¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectLine;", "Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase;", "<init>", "()V", "type", "", "startPoint", "Landroid/graphics/PointF;", "endPoint", "(ILandroid/graphics/PointF;Landroid/graphics/PointF;)V", "isTemplateObject", "", "(ILandroid/graphics/PointF;Landroid/graphics/PointF;Z)V", "penName", "", "getPenName", "()Ljava/lang/String;", "setPenName", "(Ljava/lang/String;)V", "penStyle", "advancedPenSetting", "getAdvancedPenSetting", "setAdvancedPenSetting", "lineType", "getLineType", "()I", "setLineType", "(I)V", "path", "Lcom/samsung/android/sdk/pen/document/SpenPath;", "getPath", "()Lcom/samsung/android/sdk/pen/document/SpenPath;", "controlPointCount", "getControlPointCount", "copy", "", "source", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "degree", "", "moveControlPoint", "index", "point", "getControlPoint", "setConnectorPosition", "connector", "getConnectorPosition", "getConnectedObject", "connect", "targetShape", "indexOfTargetMagneticConnectionPoint", "disconnect", "throwUncheckedException", "errno", "ObjectLine_init1", "handle", "ObjectLine_init2", "ObjectLine_init3", "ObjectLine_setLineType", "ObjectLine_getLineType", "ObjectLine_getPath", "ObjectLine_getPathWithRotation", "ObjectLine_moveControlPoint", "ObjectLine_getControlPoint", "ObjectLine_getControlPointWithRotation", "ObjectLine_getControlPointCount", "ObjectLine_setConnectorPosition", "ObjectLine_getConnectorPosition", "ObjectLine_getConnectorPositionWithRotation", "ObjectLine_getConnectedObject", "ObjectLine_connect1", "targetShapeHandle", "targetPoint", "ObjectLine_connect2", "magnetEnabled", "ObjectLine_connect3", "ObjectLine_disconnect", "ObjectLine_copy", "sourceHandle", "ObjectLine_setPenName", "ObjectLine_getPenName", "ObjectLine_setAdvancedPenSetting", "ObjectLine_getAdvancedPenSetting", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenObjectLine extends SpenObjectShapeBase {
    public static final int CONNECTOR_BEGIN = 0;
    public static final int CONNECTOR_END = 1;
    private static final int LINE_TYPE_MAX = 3;
    public static final int TYPE_CURVE = 2;
    public static final int TYPE_ELBOW = 1;
    public static final int TYPE_STRAIGHT = 0;

    public SpenObjectLine() {
        super(8);
    }

    private final native boolean ObjectLine_connect1(int handle, int connector, SpenObjectShapeBase targetShape, int targetShapeHandle, PointF targetPoint);

    private final native boolean ObjectLine_connect2(int handle, int connector, SpenObjectShapeBase targetShape, int targetShapeHandle, boolean magnetEnabled);

    private final native boolean ObjectLine_connect3(int handle, int connector, SpenObjectShapeBase targetShape, int targetShapeHandle, int indexOfTargetMagneticConnectionPoint);

    private final native boolean ObjectLine_copy(int handle, SpenObjectBase source, int sourceHandle);

    private final native boolean ObjectLine_disconnect(int handle, int connector);

    private final native String ObjectLine_getAdvancedPenSetting(int handle);

    private final native SpenObjectShapeBase ObjectLine_getConnectedObject(int handle, int connector);

    private final native PointF ObjectLine_getConnectorPosition(int handle, int connector);

    private final native PointF ObjectLine_getConnectorPositionWithRotation(int handle, int connector, float degree);

    private final native PointF ObjectLine_getControlPoint(int handle, int index);

    private final native int ObjectLine_getControlPointCount(int handle);

    private final native PointF ObjectLine_getControlPointWithRotation(int handle, int index, float degree);

    private final native int ObjectLine_getLineType(int handle);

    private final native SpenPath ObjectLine_getPath(int handle);

    private final native SpenPath ObjectLine_getPathWithRotation(int handle, float degree);

    private final native String ObjectLine_getPenName(int handle);

    private final native boolean ObjectLine_init1(int handle);

    private final native boolean ObjectLine_init2(int handle, int type, PointF startPoint, PointF endPoint);

    private final native boolean ObjectLine_init3(int handle, int type, PointF startPoint, PointF endPoint, boolean isTemplateObject);

    private final native boolean ObjectLine_moveControlPoint(int handle, int index, PointF point);

    private final native boolean ObjectLine_setAdvancedPenSetting(int handle, String penStyle);

    private final native boolean ObjectLine_setConnectorPosition(int handle, int connector, PointF point);

    private final native boolean ObjectLine_setLineType(int handle, int type);

    private final native boolean ObjectLine_setPenName(int handle, String penName);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectLine(" + this + ") is already closed");
    }

    public final void connect(int connector, @Nullable SpenObjectShapeBase targetShape, int indexOfTargetMagneticConnectionPoint) {
        if (connector != 0 && connector != 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(connector, "connector(", ") is invalid."));
        }
        if (targetShape == null) {
            throw new IllegalArgumentException("targetShape is null.");
        }
        if (indexOfTargetMagneticConnectionPoint < 0 || indexOfTargetMagneticConnectionPoint >= targetShape.getMagneticConnectionPointCount()) {
            throw new IndexOutOfBoundsException(AbstractC0541b.m767i(indexOfTargetMagneticConnectionPoint, "indexOfTargetMagneticConnectionPoint(", ") is invalid."));
        }
        if (ObjectLine_connect3(getMHandle(), connector, targetShape, targetShape.getMHandle(), indexOfTargetMagneticConnectionPoint)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShapeBase, com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(@NotNull SpenObjectBase source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (ObjectLine_copy(getMHandle(), source, source.getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void disconnect(int connector) {
        if (connector != 0 && connector != 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(connector, "connector(", ") is invalid."));
        }
        if (ObjectLine_disconnect(getMHandle(), connector)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final String getAdvancedPenSetting() {
        return ObjectLine_getAdvancedPenSetting(getMHandle());
    }

    @NotNull
    public final SpenObjectShapeBase getConnectedObject(int connector) {
        if (connector == 0 || connector == 1) {
            return ObjectLine_getConnectedObject(getMHandle(), connector);
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(connector, "connector(", ") is invalid."));
    }

    @NotNull
    public final PointF getConnectorPosition(int connector) {
        if (connector == 0 || connector == 1) {
            return ObjectLine_getConnectorPosition(getMHandle(), connector);
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(connector, "connector(", ") is invalid."));
    }

    @NotNull
    public final PointF getControlPoint(int index) {
        if (index < 0 || index >= getControlPointCount()) {
            throw new IndexOutOfBoundsException(AbstractC0622a.m1164j(index, ObjectLine_getControlPointCount(getMHandle()), "index(", ") is out of range. (control point count = ", ")"));
        }
        return ObjectLine_getControlPoint(getMHandle(), index);
    }

    public final int getControlPointCount() {
        return ObjectLine_getControlPointCount(getMHandle());
    }

    public final int getLineType() {
        return ObjectLine_getLineType(getMHandle());
    }

    @NotNull
    public final SpenPath getPath() {
        return ObjectLine_getPath(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShapeBase
    @Nullable
    public String getPenName() {
        return ObjectLine_getPenName(getMHandle());
    }

    public final void moveControlPoint(int index, @Nullable PointF point) {
        if (index < 0 || index >= getControlPointCount()) {
            throw new IndexOutOfBoundsException(AbstractC0622a.m1164j(index, ObjectLine_getControlPointCount(getMHandle()), "index(", ") is out of range. (control point count = ", ")"));
        }
        if (point == null) {
            throw new IllegalArgumentException("point is null.");
        }
        if (ObjectLine_moveControlPoint(getMHandle(), index, point)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAdvancedPenSetting(@Nullable String str) {
        if (ObjectLine_setAdvancedPenSetting(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setConnectorPosition(int connector, @Nullable PointF point) {
        if (connector != 0 && connector != 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(connector, "connector(", ") is invalid."));
        }
        if (point == null) {
            throw new IllegalArgumentException("point is null.");
        }
        if (ObjectLine_setConnectorPosition(getMHandle(), connector, point)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLineType(int i) {
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "type(", ") is unknown type."));
        }
        if (ObjectLine_setLineType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public void setPenName(@Nullable String str) {
        if (ObjectLine_setPenName(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectLine(int i, @Nullable PointF pointF, @Nullable PointF pointF2) {
        super(8);
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException("Unknown type");
        }
        if (pointF == null || pointF2 == null) {
            throw new IllegalArgumentException("startPoint or endPoint is null.");
        }
        if (ObjectLine_init2(getMHandle(), i, pointF, pointF2)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final SpenPath getPath(float degree) {
        return ObjectLine_getPathWithRotation(getMHandle(), degree);
    }

    public SpenObjectLine(int i, @Nullable PointF pointF, @Nullable PointF pointF2, boolean z) {
        super(8);
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException("Unknown type");
        }
        if (pointF != null && pointF2 != null) {
            if (ObjectLine_init3(getMHandle(), i, pointF, pointF2, z)) {
                return;
            }
            throwUncheckedException(SpenError.getError());
            return;
        }
        throw new IllegalArgumentException("startPoint or endPoint is null.");
    }

    @NotNull
    public final PointF getConnectorPosition(int connector, float degree) {
        if (connector != 0 && connector != 1) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(connector, "connector(", ") is invalid."));
        }
        return ObjectLine_getConnectorPositionWithRotation(getMHandle(), connector, degree);
    }

    @NotNull
    public final PointF getControlPoint(int index, float degree) {
        if (index >= 0 && index < getControlPointCount()) {
            return ObjectLine_getControlPointWithRotation(getMHandle(), index, degree);
        }
        throw new IndexOutOfBoundsException(AbstractC0622a.m1164j(index, ObjectLine_getControlPointCount(getMHandle()), "index(", ") is out of range. (control point count = ", ")"));
    }
}
