package com.samsung.android.sdk.pen.document;

import android.graphics.PointF;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillEffectBase;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0016\u0018\u0000 R2\u00020\u0001:\u0002QRB\u0011\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0001H\u0016J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001f\u001a\u00020\u0019J\u0010\u0010 \u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010!J\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020+2\u0006\u0010'\u001a\u00020\u0003J\u0016\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)J%\u0010/\u001a\u00020\u00192\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001012\u0006\u00102\u001a\u00020\u0003H\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020+2\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0003H\u0002J\u0011\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0082 J\u0019\u00109\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020:H\u0082 J\u0019\u0010;\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020:H\u0082 J\u0011\u0010<\u001a\u00020$2\u0006\u00108\u001a\u00020\u0003H\u0082 J\u0019\u0010=\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0082 J\u001b\u0010>\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0082 J\u0011\u0010?\u001a\u00020$2\u0006\u00108\u001a\u00020\u0003H\u0082 J\u001b\u0010@\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010!H\u0082 J\u0019\u0010A\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020!H\u0082 J\u0011\u0010B\u001a\u00020$2\u0006\u00108\u001a\u00020\u0003H\u0082 J.\u0010C\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001012\u0006\u00102\u001a\u00020\u0003H\u0082 ¢\u0006\u0002\u0010DJ\u0011\u0010E\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0082 J\u0019\u0010F\u001a\u00020&2\u0006\u00108\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0082 J!\u0010G\u001a\u00020&2\u0006\u00108\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0082 J\u0011\u0010H\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0082 J\u0019\u0010I\u001a\u00020+2\u0006\u00108\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0082 J!\u0010J\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u0003H\u0082 J!\u0010L\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)H\u0082 J\u0019\u0010M\u001a\u00020$2\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0082 J\u0011\u0010N\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0082 J\u0019\u0010O\u001a\u00020+2\u0006\u00108\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0082 J!\u0010P\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\f2\u0006\u00108\u001a\u00020\u0003H\u0082 R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "type", "", "<init>", "(I)V", "penName", "", "getPenName", "()Ljava/lang/String;", "followers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFollowers", "()Ljava/util/ArrayList;", "mode", "connectionMode", "getConnectionMode", "()I", "setConnectionMode", "magneticConnectionPointCount", "getMagneticConnectionPointCount", "connectedInfoCount", "getConnectedInfoCount", "copy", "", "source", "setLineColorEffect", "effect", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenLineColorEffect;", "getLineColorEffect", "resetLineColorEffect", "setLineStyleEffect", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenLineStyleEffect;", "getLineStyleEffect", "resetLineStyleEffect", "", "getMagneticConnectionPoint", "Landroid/graphics/PointF;", "index", "degree", "", "getMagneticConnectionInfo", "Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase$ConnectedInfo;", "getNearestMagneticConnectionPointIndex", "x", "y", "setMagneticConnectionPoint", "points", "", "pointCount", "([Landroid/graphics/PointF;I)V", "getConnectedInfo", "throwUncheckedException", "errno", "ObjectShapeBase_getFillEffectType", "handle", "ObjectShapeBase_setFillEffect", "Lcom/samsung/android/sdk/pen/document/shapeeffect/SpenFillEffectBase;", "ObjectShapeBase_getFillEffect", "ObjectShapeBase_resetFillEffect", "ObjectShapeBase_setLineColorEffect", "ObjectShapeBase_getLineColorEffect", "ObjectShapeBase_resetLineColorEffect", "ObjectShapeBase_setLineStyleEffect", "ObjectShapeBase_getLineStyleEffect", "ObjectShapeBase_resetLineStyleEffect", "ObjectShapeBase_setMagneticConnectionPoint", "(I[Landroid/graphics/PointF;I)Z", "ObjectShapeBase_getMagneticConnectionPointCount", "ObjectShapeBase_getMagneticConnectionPoint", "ObjectShapeBase_getMagneticConnectionPoint2", "ObjectShapeBase_getConnectedInfoCount", "ObjectShapeBase_getConnectedInfo", "ObjectShapeBase_copy", "sourceHandle", "ObjectShapeBase_getNearestMagneticConnectionPointIndex", "ObjectShapeBase_setConnectionMode", "ObjectShapeBase_getConnectionMode", "ObjectShapeBase_getMagneticConnectionInfo", "ObjectShapeBase_getFollowers", "ConnectedInfo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectShapeBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectShapeBase.kt\ncom/samsung/android/sdk/pen/document/SpenObjectShapeBase\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,521:1\n1#2:522\n*E\n"})
public class SpenObjectShapeBase extends SpenObjectBase {
    public static final int CONNECTION_MODE_LOOSELY_COUPLED = 1;
    public static final int CONNECTION_MODE_TIGHTLY_COUPLED = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final float OBJECT_SHAPE_BASE_MAX_LINE_WIDTH = 3.519f;
    public static final float OBJECT_SHAPE_BASE_MIN_LINE_WIDTH = 0.494f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u0087 J\t\u0010\u0012\u001a\u00020\u0005H\u0087 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\r¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase$Companion;", "", "<init>", "()V", "OBJECT_SHAPE_BASE_MIN_LINE_WIDTH", "", "OBJECT_SHAPE_BASE_MAX_LINE_WIDTH", "CONNECTION_MODE_TIGHTLY_COUPLED", "", "CONNECTION_MODE_LOOSELY_COUPLED", "minLineWidth", "getMinLineWidth$annotations", "getMinLineWidth", "()F", "maxLineWidth", "getMaxLineWidth$annotations", "getMaxLineWidth", "ObjectShapeBase_getMinLineWidth", "ObjectShapeBase_getMaxLineWidth", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getMaxLineWidth$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getMinLineWidth$annotations() {
        }

        @JvmStatic
        public final float ObjectShapeBase_getMaxLineWidth() {
            return SpenObjectShapeBase.ObjectShapeBase_getMaxLineWidth();
        }

        @JvmStatic
        public final float ObjectShapeBase_getMinLineWidth() {
            return SpenObjectShapeBase.ObjectShapeBase_getMinLineWidth();
        }

        public final float getMaxLineWidth() {
            return ObjectShapeBase_getMaxLineWidth();
        }

        public final float getMinLineWidth() {
            return ObjectShapeBase_getMinLineWidth();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase$ConnectedInfo;", "", "<init>", "()V", "point", "Landroid/graphics/PointF;", "objectList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectShapeBase;", "Lkotlin/collections/ArrayList;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ConnectedInfo {

        @JvmField
        @Nullable
        public ArrayList<SpenObjectShapeBase> objectList;

        @JvmField
        @Nullable
        public PointF point;
    }

    public SpenObjectShapeBase(int i) {
        super(i);
    }

    private final native boolean ObjectShapeBase_copy(int handle, SpenObjectBase source, int sourceHandle);

    private final native ConnectedInfo ObjectShapeBase_getConnectedInfo(int handle, int index);

    private final native int ObjectShapeBase_getConnectedInfoCount(int handle);

    private final native int ObjectShapeBase_getConnectionMode(int handle);

    private final native boolean ObjectShapeBase_getFillEffect(int handle, SpenFillEffectBase effect);

    private final native int ObjectShapeBase_getFillEffectType(int handle);

    private final native ArrayList<SpenObjectBase> ObjectShapeBase_getFollowers(int handle);

    private final native boolean ObjectShapeBase_getLineColorEffect(int handle, SpenLineColorEffect effect);

    private final native boolean ObjectShapeBase_getLineStyleEffect(int handle, SpenLineStyleEffect effect);

    private final native ConnectedInfo ObjectShapeBase_getMagneticConnectionInfo(int handle, int index);

    private final native PointF ObjectShapeBase_getMagneticConnectionPoint(int handle, int index);

    private final native PointF ObjectShapeBase_getMagneticConnectionPoint2(int handle, int index, float degree);

    private final native int ObjectShapeBase_getMagneticConnectionPointCount(int handle);

    @JvmStatic
    public static final native float ObjectShapeBase_getMaxLineWidth();

    @JvmStatic
    public static final native float ObjectShapeBase_getMinLineWidth();

    private final native int ObjectShapeBase_getNearestMagneticConnectionPointIndex(int handle, float x, float y2);

    private final native boolean ObjectShapeBase_resetFillEffect(int handle);

    private final native boolean ObjectShapeBase_resetLineColorEffect(int handle);

    private final native boolean ObjectShapeBase_resetLineStyleEffect(int handle);

    private final native boolean ObjectShapeBase_setConnectionMode(int handle, int mode);

    private final native boolean ObjectShapeBase_setFillEffect(int handle, SpenFillEffectBase effect);

    private final native boolean ObjectShapeBase_setLineColorEffect(int handle, SpenLineColorEffect effect);

    private final native boolean ObjectShapeBase_setLineStyleEffect(int handle, SpenLineStyleEffect effect);

    private final native boolean ObjectShapeBase_setMagneticConnectionPoint(int handle, PointF[] points, int pointCount);

    private final ConnectedInfo getConnectedInfo(int index) {
        return ObjectShapeBase_getConnectedInfo(getMHandle(), index);
    }

    public static final float getMaxLineWidth() {
        return INSTANCE.getMaxLineWidth();
    }

    public static final float getMinLineWidth() {
        return INSTANCE.getMinLineWidth();
    }

    private final void setMagneticConnectionPoint(PointF[] points, int pointCount) {
        if (ObjectShapeBase_setMagneticConnectionPoint(getMHandle(), points, pointCount)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectShapeBase(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(@NotNull SpenObjectBase source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (ObjectShapeBase_copy(getMHandle(), source, source.getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final int getConnectedInfoCount() {
        return ObjectShapeBase_getConnectedInfoCount(getMHandle());
    }

    public final int getConnectionMode() {
        return ObjectShapeBase_getConnectionMode(getMHandle());
    }

    @NotNull
    public final ArrayList<SpenObjectBase> getFollowers() {
        return ObjectShapeBase_getFollowers(getMHandle());
    }

    public final void getLineColorEffect(@Nullable SpenLineColorEffect effect) {
        if (ObjectShapeBase_getLineColorEffect(getMHandle(), effect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void getLineStyleEffect(@Nullable SpenLineStyleEffect effect) {
        if (effect == null) {
            throw new IllegalArgumentException("effect is null");
        }
        if (ObjectShapeBase_getLineStyleEffect(getMHandle(), effect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final ConnectedInfo getMagneticConnectionInfo(int index) {
        return ObjectShapeBase_getMagneticConnectionInfo(getMHandle(), index);
    }

    @NotNull
    public final PointF getMagneticConnectionPoint(int index) {
        return ObjectShapeBase_getMagneticConnectionPoint(getMHandle(), index);
    }

    public final int getMagneticConnectionPointCount() {
        return ObjectShapeBase_getMagneticConnectionPointCount(getMHandle());
    }

    public final int getNearestMagneticConnectionPointIndex(float x, float y2) {
        return ObjectShapeBase_getNearestMagneticConnectionPointIndex(getMHandle(), x, y2);
    }

    @Nullable
    public String getPenName() {
        return "";
    }

    public final void resetLineColorEffect() {
        ObjectShapeBase_resetLineColorEffect(getMHandle());
    }

    public final boolean resetLineStyleEffect() {
        return ObjectShapeBase_resetLineStyleEffect(getMHandle());
    }

    public final void setConnectionMode(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("");
        }
        if (ObjectShapeBase_setConnectionMode(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLineColorEffect(@NotNull SpenLineColorEffect effect) {
        Intrinsics.checkNotNullParameter(effect, "effect");
        if (ObjectShapeBase_setLineColorEffect(getMHandle(), effect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLineStyleEffect(@Nullable SpenLineStyleEffect effect) {
        if (ObjectShapeBase_setLineStyleEffect(getMHandle(), effect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @NotNull
    public final PointF getMagneticConnectionPoint(int index, float degree) {
        return ObjectShapeBase_getMagneticConnectionPoint2(getMHandle(), index, degree);
    }
}
