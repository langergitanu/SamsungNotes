package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.PointF;
import android.view.DragEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.composer.text.SpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.composer.common.ImageExtension;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectTypeHelper;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragAutoScroll;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcher;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragInfo;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragNDropConstant;
import com.samsung.android.support.senl.p148nt.base.composer.drag.InternalDropLogic;
import com.samsung.android.support.senl.p148nt.base.composer.focus.FocusManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuPaste;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmModeControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmObjectManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0003DEFB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010+\u001a\u00020,H\u0016J\b\u00102\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0002J\b\u00104\u001a\u00020/H\u0002J\u0018\u00105\u001a\u00020(2\u0006\u00100\u001a\u0002012\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010;\u001a\u00020\u001aH\u0002J\u0010\u0010<\u001a\u00020/2\u0006\u0010+\u001a\u00020,H\u0002J\u0012\u0010=\u001a\u00020/2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0006\u0010@\u001a\u00020/J\u0012\u0010A\u001a\u00020/2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00060\"R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnDragListenerImpl;", "Landroid/view/View$OnDragListener;", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher$DragEventListener;", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "contextMenuPaste", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuPaste;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuPaste;)V", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "modeController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "sipController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "focusManager", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;", "fTarget", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/graphics/PointF;", "getOffset", "()Landroid/graphics/PointF;", "setOffset", "(Landroid/graphics/PointF;)V", "dragInfo", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragInfo;", "autoScroll", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnDragListenerImpl$AutoScroll;", "internalDropLogic", "Lcom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic;", "hapticDetachSound", "Lcom/samsung/android/support/senl/cm/base/framework/media/AudioManagerCompat$SoundManager;", "release", "", "getEventX", "", "event", "Landroid/view/DragEvent;", "getEventY", "onDrag", "", "view", "Landroid/view/View;", "isDisabled", "setDragPosition", "isCursorDragMode", "onDragStarted", "getClipType", "", "description", "Landroid/content/ClipDescription;", "onDragLocation", "getCurrentPan", "onDrop", "canDrop", "clipData", "Landroid/content/ClipData;", "isEditableState", "pasteClip", "onDragEnded", "clearInfo", "Companion", "AutoScroll", "DropLogicFunc", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OnDragListenerImpl implements View.OnDragListener, DragEventDispatcher.DragEventListener {

    @NotNull
    private static final String TAG = SmLogger.createTag("OnDragListenerImpl");

    @NotNull
    private final AutoScroll autoScroll;

    @NotNull
    private final SmContextMenuPaste contextMenuPaste;

    @NotNull
    private final DragInfo dragInfo;

    @Nullable
    private FocusManager.FTarget fTarget;

    @Nullable
    private FocusManager focusManager;

    @Nullable
    private AudioManagerCompat.SoundManager hapticDetachSound;

    @NotNull
    private final InternalDropLogic internalDropLogic;

    @NotNull
    private SmModeControl modeController;

    @NotNull
    private SpenWNote note;

    @NotNull
    private SmObjectManager objectManager;

    @Nullable
    private PointF offset;

    @NotNull
    private SipController sipController;

    @NotNull
    private final SpenTextWritingView spenView;

    @NotNull
    private SmTextManager textManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnDragListenerImpl$AutoScroll;", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragAutoScroll;", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnDragListenerImpl;Lcom/samsung/android/sdk/composer/SpenTextWritingView;)V", "canScroll", "", "setPan", "", "pan", "Landroid/graphics/PointF;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class AutoScroll extends DragAutoScroll {

        @NotNull
        private final SpenTextWritingView spenView;
        final /* synthetic */ OnDragListenerImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoScroll(@NotNull OnDragListenerImpl onDragListenerImpl, SpenTextWritingView spenView) {
            super(OnDragListenerImpl.TAG);
            Intrinsics.checkNotNullParameter(spenView, "spenView");
            this.this$0 = onDragListenerImpl;
            this.spenView = spenView;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.drag.DragAutoScroll
        public boolean canScroll() {
            if (!this.this$0.isCursorDragMode()) {
                return true;
            }
            String text = this.this$0.note.getBodyText().getText();
            if (text != null && text.length() > 0) {
                return true;
            }
            SmLogger.m8662e(getTag(), "autoScroll# bodyText is empty");
            return false;
        }

        @Override // com.samsung.android.support.senl.p148nt.base.composer.drag.DragAutoScroll
        public void setPan(@NotNull PointF pan) {
            Intrinsics.checkNotNullParameter(pan, "pan");
            this.spenView.getMSpenNoteZoomScroller().setPan(pan);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnDragListenerImpl$DropLogicFunc;", "Lcom/samsung/android/support/senl/nt/base/composer/drag/InternalDropLogic$InjectedFunction;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnDragListenerImpl;)V", "isCursorDragMode", "", "getCursorIndex", "", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "position", "Landroid/graphics/PointF;", "setTargetTextBoxFocus", "", "targetObject", "targetObjectCursor", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class DropLogicFunc extends InternalDropLogic.InjectedFunction {
        public DropLogicFunc() {
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.InternalDropLogic.InjectedFunction
        public int getCursorIndex(@NotNull SpenObjectShape objectShape, @NotNull PointF position) {
            Intrinsics.checkNotNullParameter(objectShape, "objectShape");
            Intrinsics.checkNotNullParameter(position, "position");
            return OnDragListenerImpl.this.textManager.getCursorIndex(position);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.InternalDropLogic.InjectedFunction
        public boolean isCursorDragMode() {
            return OnDragListenerImpl.this.isCursorDragMode();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.InternalDropLogic.InjectedFunction
        public void setTargetTextBoxFocus(@NotNull SpenObjectShape targetObject, int targetObjectCursor) {
            Intrinsics.checkNotNullParameter(targetObject, "targetObject");
            OnDragListenerImpl.this.objectManager.selectObject(targetObject);
            targetObject.setCursorPosition(targetObjectCursor);
            OnDragListenerImpl.this.objectManager.setFocus(true);
        }
    }

    public OnDragListenerImpl(@NotNull SpenTextWritingView spenView, @NotNull SmControlManager smControlManager, @NotNull SmContextMenuPaste contextMenuPaste) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        Intrinsics.checkNotNullParameter(contextMenuPaste, "contextMenuPaste");
        this.spenView = spenView;
        this.contextMenuPaste = contextMenuPaste;
        this.textManager = smControlManager.getTextManager();
        this.objectManager = smControlManager.getObjectManager();
        this.modeController = smControlManager.getModeControl();
        this.sipController = smControlManager.getSipController();
        this.focusManager = smControlManager.getFocusManager();
        this.fTarget = smControlManager.getFTarget();
        this.note = this.objectManager.getNote();
        String str = TAG;
        DragInfo dragInfo = new DragInfo(str);
        this.dragInfo = dragInfo;
        this.autoScroll = new AutoScroll(this, spenView);
        this.internalDropLogic = new InternalDropLogic(str, this.note, dragInfo, new DropLogicFunc(), 1.4142857f);
        this.hapticDetachSound = AudioManagerCompat.INSTANCE.getInstance().createHapticDetachSound(spenView.getContext());
    }

    private final boolean canDrop(ClipData clipData) {
        if (clipData == null || clipData.getDescription() == null) {
            SmLogger.m8662e(TAG, "");
            return false;
        }
        if (this.dragInfo.getClipType() == 0) {
            this.dragInfo.setClipType(getClipType(clipData.getDescription()));
        }
        if (this.dragInfo.getClipType() == -1) {
            SmLogger.m8666i(TAG, "canDrop# ClipType is unsupported.");
            Context context = this.spenView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            DragNDropConstant.showDropFailMessage(context);
            return false;
        }
        DragInfo dragInfo = this.dragInfo;
        ClipDescription description = clipData.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, "getDescription(...)");
        if (dragInfo.isIgnoredLabel(description)) {
            SmLogger.m8666i(TAG, "canDrop# isIgnoredLabel.");
            return false;
        }
        if (isEditableState()) {
            return true;
        }
        SmLogger.m8666i(TAG, "canDrop# isEditableState is false");
        return true;
    }

    private final void clearInfo() {
        this.internalDropLogic.clear();
        this.dragInfo.clear();
    }

    private final int getClipType(ClipDescription description) {
        if (description == null) {
            SmLogger.m8662e(TAG, "getClipType, description is null");
            return -1;
        }
        CharSequence label = description.getLabel();
        this.dragInfo.parseLabel(label != null ? label.toString() : null, this.spenView.hashCode());
        if (this.dragInfo.getIsInternalLabel()) {
            return 2;
        }
        int mimeTypeCount = description.getMimeTypeCount();
        SmLogger.m8661d(TAG, "getClipType, mimeTypeCount: " + mimeTypeCount);
        for (int i = 0; i < mimeTypeCount; i++) {
            String mimeType = description.getMimeType(i);
            Intrinsics.checkNotNullExpressionValue(mimeType, "getMimeType(...)");
            SmLogger.m8661d(TAG, "getClipType, index: " + i + ", mimeType: " + mimeType);
            if (this.dragInfo.getHasNoteDataLabel() && ImageExtension.INSTANCE.isImageMimeType(mimeType)) {
                return 1;
            }
            if (StringsKt.m14162r(mimeType, "text/")) {
                return 2;
            }
        }
        return -1;
    }

    private final PointF getCurrentPan() {
        PointF pan = this.spenView.getMSpenNoteZoomScroller().getPan();
        Intrinsics.checkNotNull(pan);
        return pan;
    }

    private final float getEventX(DragEvent event) {
        float f;
        float x = event.getX();
        PointF pointF = this.offset;
        if (pointF == null) {
            f = 0.0f;
        } else {
            Intrinsics.checkNotNull(pointF);
            f = pointF.x;
        }
        return x + f;
    }

    private final float getEventY(DragEvent event) {
        float f;
        float y2 = event.getY();
        PointF pointF = this.offset;
        if (pointF == null) {
            f = 0.0f;
        } else {
            Intrinsics.checkNotNull(pointF);
            f = pointF.y;
        }
        return y2 + f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCursorDragMode() {
        return this.dragInfo.getClipType() == 2;
    }

    private final boolean isDisabled() {
        return false;
    }

    private final void onDragEnded() {
        clearInfo();
    }

    private final boolean onDragLocation(DragEvent event) {
        FocusManager.FTarget fTarget;
        DragInfo dragInfo = this.dragInfo;
        ClipDescription clipDescription = event.getClipDescription();
        Intrinsics.checkNotNullExpressionValue(clipDescription, "getClipDescription(...)");
        if (dragInfo.isIgnoredLabel(clipDescription)) {
            return false;
        }
        if (!this.modeController.isEditMode()) {
            Logger.m8697d(TAG, "onDragLocation# current mode is not edit mode");
            return false;
        }
        FocusManager focusManager = this.focusManager;
        if (focusManager != null && ((fTarget = this.fTarget) == null || !fTarget.hasFocus())) {
            Logger.m8697d(TAG, "onDragLocation# no focus");
            if (focusManager.hasFocus(this.fTarget)) {
                this.sipController.blockToShow(true, "take focus while drag");
                FocusManager.FTarget fTarget2 = this.fTarget;
                if (fTarget2 != null) {
                    fTarget2.requestFocus();
                }
                this.sipController.blockToShow(false, "take focus while drag");
            }
        }
        if (this.dragInfo.getStartPosition() == null) {
            DragInfo dragInfo2 = this.dragInfo;
            dragInfo2.setStartPosition(dragInfo2.getDragPosition());
        }
        DragInfo dragInfo3 = this.dragInfo;
        dragInfo3.setTargetObject(this.internalDropLogic.getPositionObject(dragInfo3.getDragPosition()));
        if (this.modeController.isWritingMode()) {
            this.autoScroll.autoScroll(getEventX(event), getEventY(event), getCurrentPan());
            return true;
        }
        if (!isCursorDragMode()) {
            return false;
        }
        SpenObjectBase targetObject = this.dragInfo.getTargetObject();
        ObjectTypeHelper objectTypeHelper = ObjectTypeHelper.INSTANCE;
        Intrinsics.checkNotNull(targetObject);
        if (!objectTypeHelper.isTextType(targetObject.getType())) {
            targetObject = this.note.getBodyText();
        }
        this.note.selectObject(targetObject);
        DragInfo dragInfo4 = this.dragInfo;
        SpenNoteTextManager mNoteTextManager = this.spenView.getMNoteTextManager();
        Intrinsics.checkNotNull(targetObject, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
        SpenObjectShape spenObjectShape = (SpenObjectShape) targetObject;
        dragInfo4.setTargetObjectCursor(mNoteTextManager.getCurosrIndex(spenObjectShape, this.dragInfo.getDragPosition()));
        spenObjectShape.setCursorPosition(this.dragInfo.getTargetObjectCursor());
        this.spenView.getControlObjectManager().setFocus(true);
        this.spenView.getMNoteTextManager().setCursorBlink(true);
        this.autoScroll.autoScroll(getEventX(event), getEventY(event), getCurrentPan());
        return true;
    }

    private final void onDragStarted(View view, DragEvent event) {
        ClipDescription clipDescription = event.getClipDescription();
        if (this.dragInfo.getClipType() == 0) {
            this.dragInfo.setClipType(getClipType(clipDescription));
        }
        if (this.dragInfo.getClipType() == -1) {
            SmLogger.m8661d(TAG, "onDragStarted# data is unsupported");
            return;
        }
        DragInfo dragInfo = this.dragInfo;
        Intrinsics.checkNotNull(clipDescription);
        if (dragInfo.isIgnoredLabel(clipDescription)) {
            return;
        }
        if (this.dragInfo.getIsInternalLabel()) {
            AudioManagerCompat.SoundManager soundManager = this.hapticDetachSound;
            if (soundManager != null) {
                soundManager.play();
            }
            ViewCompat.INSTANCE.getInstance().performHapticFeedback(view, 108);
            ArrayList<SpenObjectBase> selectedObjectList = this.objectManager.getSelectedObjectList();
            if (selectedObjectList != null) {
                this.internalDropLogic.setBackupObjList((List<SpenObjectBase>) new ArrayList(selectedObjectList));
            }
        }
        this.autoScroll.onDragStarted(view);
        this.dragInfo.setStartPosition(null);
    }

    private final boolean onDrop(DragEvent event) {
        if (!isCursorDragMode()) {
            PointF dragPosition = this.dragInfo.getDragPosition();
            float f = dragPosition.x;
            if (f >= 0.0f) {
                float f4 = dragPosition.y;
                if (f4 >= 0.0f) {
                    if (this.objectManager.getPageIndexByXY(f, f4) < 0) {
                        SmLogger.m8662e(TAG, "onDrop# drop position is wrong : " + this.dragInfo.getDragPosition());
                        return true;
                    }
                }
            }
            SmLogger.m8662e(TAG, "onDrop# drop position is wrong : " + this.dragInfo.getDragPosition());
            return true;
        }
        ClipData clipData = event.getClipData();
        if (!canDrop(clipData)) {
            return true;
        }
        SmLogger.m8666i(TAG, "onDrop# clipType: " + this.dragInfo.getClipType());
        boolean zPasteClip = false;
        if (this.dragInfo.getClipType() == 2 || this.dragInfo.getIsInternalLabel()) {
            if (this.dragInfo.getIsInternalLabel() && !this.internalDropLogic.internalDnD()) {
                return false;
            }
            zPasteClip = pasteClip(clipData);
        } else if (this.dragInfo.getClipType() == 1) {
            zPasteClip = pasteClip(clipData);
        }
        if (zPasteClip) {
            this.objectManager.clearSelectObject();
        } else {
            Context context = this.spenView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            DragNDropConstant.showDropFailMessage(context);
        }
        return true;
    }

    private final boolean pasteClip(ClipData clipData) {
        String str = TAG;
        SmLogger.m8666i(str, "pasteClip# " + clipData + ", dropPosition: " + this.dragInfo.getDragPosition());
        if (clipData == null || clipData.getItemCount() == 0) {
            SmLogger.m8662e(str, "pasteClip# clipData is null or itemCount is 0");
            return false;
        }
        this.contextMenuPaste.paste(clipData, (isCursorDragMode() && this.objectManager.isFocusedTextBox()) ? null : this.dragInfo.getDragPosition());
        return true;
    }

    private final void setDragPosition(DragEvent event) {
        PointF delta = this.spenView.getMSpenNoteZoomScroller().getDelta();
        Intrinsics.checkNotNull(delta);
        this.dragInfo.setDragPosition(event, 0.0f, 0.0f, delta, 1.0f, isCursorDragMode());
        String str = TAG;
        int action = event.getAction();
        float eventX = getEventX(event);
        float eventY = getEventY(event);
        float f = this.dragInfo.getDragPosition().x;
        float f4 = this.dragInfo.getDragPosition().y;
        StringBuilder sbM1628r = AbstractC2322a.m1628r("event# ", action, " = event(", eventX, "/");
        AbstractC11014a.m12337v(sbM1628r, eventY, ") drop(", f, "/");
        sbM1628r.append(f4);
        SmLogger.m8661d(str, sbM1628r.toString());
    }

    @Nullable
    public final PointF getOffset() {
        return this.offset;
    }

    public final boolean isEditableState() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragEventDispatcher.DragEventListener
    public boolean onDrag(@NotNull View view, @NotNull DragEvent event, @NotNull PointF offset) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.offset = offset;
        this.dragInfo.setOffset(offset);
        boolean zOnDrag = onDrag(view, event);
        this.dragInfo.setOffset(null);
        this.offset = null;
        return zOnDrag;
    }

    public final void release() {
        AudioManagerCompat.SoundManager soundManager = this.hapticDetachSound;
        if (soundManager != null) {
            soundManager.release();
        }
        this.hapticDetachSound = null;
    }

    public final void setOffset(@Nullable PointF pointF) {
        this.offset = pointF;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(@NotNull View view, @NotNull DragEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        setDragPosition(event);
        int action = event.getAction();
        if (action != 1) {
            if (action == 2) {
                return onDragLocation(event);
            }
            if (action == 3) {
                return onDrop(event);
            }
            if (action == 4) {
                onDragEnded();
                return true;
            }
            if (action != 5) {
                return false;
            }
        }
        if (isDisabled()) {
            return false;
        }
        onDragStarted(view, event);
        return this.dragInfo.getClipType() != -1;
    }
}
