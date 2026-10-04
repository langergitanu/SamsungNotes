package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.content.ClipDescription;
import android.graphics.PointF;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.DragEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00101\u001a\u00020\u0007J6\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\u0017J\u0018\u0010<\u001a\u0002032\b\u0010=\u001a\u0004\u0018\u00010\u00032\u0006\u0010>\u001a\u00020\u000eJ\u0006\u0010?\u001a\u00020\u0017J\u000e\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u000203R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001c\u0010.\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\f¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragInfo;", "", "tag", "", "<init>", "(Ljava/lang/String;)V", "dragPosition", "Landroid/graphics/PointF;", "startPosition", "getStartPosition", "()Landroid/graphics/PointF;", "setStartPosition", "(Landroid/graphics/PointF;)V", "clipType", "", "getClipType", "()I", "setClipType", "(I)V", "dropContentType", "getDropContentType", "setDropContentType", "isInternalLabel", "", "()Z", "setInternalLabel", "(Z)V", "hasNoteDataLabel", "getHasNoteDataLabel", "setHasNoteDataLabel", "labelInfo", "", "getLabelInfo", "()[Ljava/lang/String;", "setLabelInfo", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "targetObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getTargetObject", "()Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "setTargetObject", "(Lcom/samsung/android/sdk/pen/document/SpenObjectBase;)V", "targetObjectCursor", "getTargetObjectCursor", "setTargetObjectCursor", TypedValues.Cycle.S_WAVE_OFFSET, "getOffset", "setOffset", "getDragPosition", "setDragPosition", "", "event", "Landroid/view/DragEvent;", "shadowSizeWith", "", "shadowSizeHeight", "delta", WiggleAnimationConfig.KEY_SCALE, "isCursorDragMode", "parseLabel", "label", "keyHashCode", "isDropContentObjectSpan", "isIgnoredLabel", "description", "Landroid/content/ClipDescription;", "clear", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DragInfo {
    private int clipType;

    @Nullable
    private PointF dragPosition;
    private int dropContentType;
    private boolean hasNoteDataLabel;
    private boolean isInternalLabel;

    @Nullable
    private String[] labelInfo;

    @Nullable
    private PointF offset;

    @Nullable
    private PointF startPosition;

    @NotNull
    private final String tag;

    @Nullable
    private SpenObjectBase targetObject;
    private int targetObjectCursor;

    public DragInfo(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
    }

    public final void clear() {
        this.clipType = 0;
        this.isInternalLabel = false;
        this.hasNoteDataLabel = false;
        this.dropContentType = 0;
        this.labelInfo = null;
    }

    public final int getClipType() {
        return this.clipType;
    }

    @NotNull
    public final PointF getDragPosition() {
        PointF pointF = this.dragPosition;
        if (pointF == null) {
            return new PointF();
        }
        Intrinsics.checkNotNull(pointF);
        return pointF;
    }

    public final int getDropContentType() {
        return this.dropContentType;
    }

    public final boolean getHasNoteDataLabel() {
        return this.hasNoteDataLabel;
    }

    @Nullable
    public final String[] getLabelInfo() {
        return this.labelInfo;
    }

    @Nullable
    public final PointF getOffset() {
        return this.offset;
    }

    @Nullable
    public final PointF getStartPosition() {
        return this.startPosition;
    }

    @Nullable
    public final SpenObjectBase getTargetObject() {
        return this.targetObject;
    }

    public final int getTargetObjectCursor() {
        return this.targetObjectCursor;
    }

    public final boolean isDropContentObjectSpan() {
        return this.dropContentType == 3;
    }

    public final boolean isIgnoredLabel(@NotNull ClipDescription description) {
        Intrinsics.checkNotNullParameter(description, "description");
        CharSequence label = description.getLabel();
        String string = label != null ? label.toString() : null;
        if (!TextUtils.isEmpty(string) && Intrinsics.areEqual(string, "Page_Thumbnail")) {
            Logger.m8698e(this.tag, "isIgnoredLabel# clip data is PageDragList.");
            return true;
        }
        PersistableBundle extras = description.getExtras();
        if (extras == null || !extras.getBoolean(DragNDropConstant.DRAG_START_FROM_APPS_EDGE)) {
            if (TextUtils.isEmpty(string) || !Intrinsics.areEqual(string, DragNDropConstant.DRAG_START_FROM_APPS_EDGE)) {
                return false;
            }
            AbstractC4539a.m3214x("isIgnoredLabel# clip data is apps edge. Label:", string, this.tag);
            return true;
        }
        Logger.m8698e(this.tag, "isIgnoredLabel# clip data is apps edge. Extras:" + extras);
        return true;
    }

    /* JADX INFO: renamed from: isInternalLabel, reason: from getter */
    public final boolean getIsInternalLabel() {
        return this.isInternalLabel;
    }

    public final void parseLabel(@Nullable String label, int keyHashCode) {
        this.isInternalLabel = false;
        this.dropContentType = 0;
        String[] clipLabel = DropContent.parseClipLabel(label, keyHashCode);
        this.labelInfo = clipLabel;
        if (clipLabel != null) {
            this.isInternalLabel = true;
            this.hasNoteDataLabel = true;
            Intrinsics.checkNotNull(clipLabel);
            this.dropContentType = Integer.parseInt(clipLabel[2]);
        } else if (label != null && StringsKt.m14162r(label, "notes_clip_label")) {
            this.hasNoteDataLabel = true;
        }
        Logger.m8697d(this.tag, "parseLabel# label: " + label + ", mIsInternalLabel: " + this.isInternalLabel);
    }

    public final void setClipType(int i) {
        this.clipType = i;
    }

    public final void setDragPosition(@NotNull DragEvent event, float shadowSizeWith, float shadowSizeHeight, @NotNull PointF delta, float scale, boolean isCursorDragMode) {
        float f;
        float f4;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(delta, "delta");
        PointF pointF = this.offset;
        if (pointF != null) {
            f = pointF.x;
            f4 = pointF.y;
        } else {
            f = 0.0f;
            f4 = 0.0f;
        }
        PointF pointF2 = new PointF(event.getX() + f, event.getY() + f4);
        float f5 = pointF2.x - (shadowSizeWith / 2.0f);
        pointF2.x = f5;
        float f6 = pointF2.y - (shadowSizeHeight / 2.0f);
        pointF2.y = f6;
        float f7 = (f5 - delta.x) / scale;
        pointF2.x = f7;
        pointF2.y = (f6 - delta.y) / scale;
        if (isCursorDragMode) {
            pointF2.x = (float) Math.max(f7, 0.0d);
            pointF2.y = (float) Math.max(pointF2.y, 0.0d);
        }
        this.dragPosition = pointF2;
    }

    public final void setDropContentType(int i) {
        this.dropContentType = i;
    }

    public final void setHasNoteDataLabel(boolean z) {
        this.hasNoteDataLabel = z;
    }

    public final void setInternalLabel(boolean z) {
        this.isInternalLabel = z;
    }

    public final void setLabelInfo(@Nullable String[] strArr) {
        this.labelInfo = strArr;
    }

    public final void setOffset(@Nullable PointF pointF) {
        this.offset = pointF;
    }

    public final void setStartPosition(@Nullable PointF pointF) {
        this.startPosition = pointF;
    }

    public final void setTargetObject(@Nullable SpenObjectBase spenObjectBase) {
        this.targetObject = spenObjectBase;
    }

    public final void setTargetObjectCursor(int i) {
        this.targetObjectCursor = i;
    }
}
