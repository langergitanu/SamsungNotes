package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcher;
import com.samsung.android.support.senl.p148nt.base.composer.focus.FocusManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTaskController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.ClipboardController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 [2\u00020\u0001:\u0001[B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010R\u001a\u00020\u0011J\u0006\u0010S\u001a\u00020\u0013J\b\u0010T\u001a\u0004\u0018\u00010\u0017J\u0006\u0010U\u001a\u00020VJ\u0006\u0010W\u001a\u00020\u000fJ\u000e\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020ZR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006\\"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "handler", "Landroid/os/Handler;", "controlFactory", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ControlFactory;", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Lcom/samsung/android/sdk/composer/SpenTextWritingView;Landroid/os/Handler;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ControlFactory;)V", "getSpenView", "()Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "isReleased", "", "sipController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "clipboardController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/ClipboardController;", "progressControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;", "toolShareControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "quickSaveControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "getQuickSaveControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "setQuickSaveControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;)V", "dragEventDispatcher", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;", "getDragEventDispatcher", "()Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;", "setDragEventDispatcher", "(Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;)V", "focusManager", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;", "getFocusManager", "()Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;", "setFocusManager", "(Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;)V", "taskController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController;", "getTaskController", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/action/SmTaskController;", "textManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "getTextManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;", "setTextManager", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/text/SmTextManager;)V", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "getObjectManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "setObjectManager", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;)V", "writingControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;", "getWritingControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;", "setWritingControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;)V", "modeControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "getModeControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "setModeControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;)V", "dragNDropControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/DragNDropControl;", "getDragNDropControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/DragNDropControl;", "setDragNDropControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/DragNDropControl;)V", "fTarget", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;", "getFTarget", "()Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;", "setFTarget", "(Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;)V", "getSipController", "getClipboardController", "getToolShareControl", "release", "", "onBackPressed", "onConfiguration", "newConfig", "Landroid/content/res/Configuration;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmControlManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmControlManager");

    @Nullable
    private ClipboardController clipboardController;

    @Nullable
    private DragEventDispatcher dragEventDispatcher;

    @NotNull
    private DragNDropControl dragNDropControl;

    @Nullable
    private FocusManager.FTarget fTarget;

    @Nullable
    private FocusManager focusManager;
    private boolean isReleased;

    @NotNull
    private SmModeControl modeControl;

    @NotNull
    private SmObjectManager objectManager;

    @NotNull
    private final SmProgressControl progressControl;

    @NotNull
    private SmQuickSaveControl quickSaveControl;

    @Nullable
    private SipController sipController;

    @NotNull
    private final SpenTextWritingView spenView;

    @NotNull
    private final SmTaskController taskController;

    @NotNull
    private SmTextManager textManager;

    @Nullable
    private ToolShareControl toolShareControl;

    @NotNull
    private SmWritingControl writingControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmControlManager.TAG;
        }

        private Companion() {
        }
    }

    public SmControlManager(@NotNull SpenWNote note, @NotNull SpenTextWritingView spenView, @NotNull Handler handler, @NotNull ControlFactory controlFactory) {
        FocusManager.FTarget mainTarget;
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(controlFactory, "controlFactory");
        this.spenView = spenView;
        SipController sipControllerCreateSipController = controlFactory.createSipController();
        sipControllerCreateSipController.setHandler(handler);
        sipControllerCreateSipController.setSpenView(spenView);
        this.sipController = sipControllerCreateSipController;
        ClipboardController clipboardController = new ClipboardController(spenView.getRootView());
        clipboardController.setClipboardDefaultFilter("init");
        this.clipboardController = clipboardController;
        SmProgressControl smProgressControlCreateProgressControl = controlFactory.createProgressControl();
        this.progressControl = smProgressControlCreateProgressControl;
        this.quickSaveControl = controlFactory.createQuickSaveControl();
        this.dragEventDispatcher = controlFactory.getDragEventDispatcher();
        this.focusManager = controlFactory.getFocusManager();
        this.taskController = new SmTaskController(smProgressControlCreateProgressControl);
        SmTextManager smTextManager = new SmTextManager();
        smTextManager.init(note, spenView.getMNoteTextManager(), Color.parseColor("#252525"));
        this.textManager = smTextManager;
        this.objectManager = new SmObjectManager(note, this.textManager, spenView.getNoteObjectInserter(), spenView.getControlObjectManager());
        this.writingControl = new SmWritingControl(spenView);
        SipController sipController = this.sipController;
        Intrinsics.checkNotNull(sipController);
        this.modeControl = new SmModeControl(note, spenView, sipController, this.objectManager, this.writingControl);
        this.dragNDropControl = new DragNDropControl(spenView, this.objectManager);
        ToolShareControl toolShareControlCreateToolShareControl = controlFactory.createToolShareControl();
        toolShareControlCreateToolShareControl.setSpenView$ntBase_release(spenView);
        toolShareControlCreateToolShareControl.setWritingControl$ntBase_release(this.writingControl);
        toolShareControlCreateToolShareControl.setTextManager$ntBase_release(this.textManager);
        toolShareControlCreateToolShareControl.setModeControl$ntBase_release(this.modeControl);
        toolShareControlCreateToolShareControl.setObjectManager$ntBase_release(this.objectManager);
        toolShareControlCreateToolShareControl.setSipController$ntBase_release(this.sipController);
        toolShareControlCreateToolShareControl.updateIsSpenOnlyMode();
        this.toolShareControl = toolShareControlCreateToolShareControl;
        FocusManager.FTarget fTarget = new FocusManager.FTarget() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.SmControlManager.2
            @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
            public boolean hasFocus() {
                return SmControlManager.this.getSpenView().hasFocus();
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
            public void onGetFocus() {
                SmControlManager.this.getTextManager().setCursorBlink(true);
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
            public void onLoseFocus() {
                SmLogger.m8661d(SmControlManager.INSTANCE.getTAG(), "onLoseFocus");
                SipController sipController2 = SmControlManager.this.sipController;
                if (sipController2 != null) {
                    sipController2.blockToHide(true, "onLoseFocus");
                }
                SmControlManager.this.getTextManager().setCursorBlink(false);
                SipController sipController3 = SmControlManager.this.sipController;
                if (sipController3 != null) {
                    sipController3.blockToHide(false, "onLoseFocus");
                }
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
            public void requestFocus() {
                SmControlManager.this.getSpenView().requestFocus();
            }
        };
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            focusManager.addTarget(fTarget);
        }
        FocusManager focusManager2 = this.focusManager;
        if (focusManager2 != null && (mainTarget = focusManager2.getMainTarget()) != null) {
            mainTarget.onLoseFocus();
        }
        FocusManager focusManager3 = this.focusManager;
        if (focusManager3 != null) {
            focusManager3.updateFocusTarget(fTarget);
        }
        this.fTarget = fTarget;
    }

    @NotNull
    public final ClipboardController getClipboardController() {
        ClipboardController clipboardController = this.clipboardController;
        Intrinsics.checkNotNull(clipboardController);
        return clipboardController;
    }

    @Nullable
    public final DragEventDispatcher getDragEventDispatcher() {
        return this.dragEventDispatcher;
    }

    @NotNull
    public final DragNDropControl getDragNDropControl() {
        return this.dragNDropControl;
    }

    @Nullable
    public final FocusManager.FTarget getFTarget() {
        return this.fTarget;
    }

    @Nullable
    public final FocusManager getFocusManager() {
        return this.focusManager;
    }

    @NotNull
    public final SmModeControl getModeControl() {
        return this.modeControl;
    }

    @NotNull
    public final SmObjectManager getObjectManager() {
        return this.objectManager;
    }

    @NotNull
    public final SmQuickSaveControl getQuickSaveControl() {
        return this.quickSaveControl;
    }

    @NotNull
    public final SipController getSipController() {
        SipController sipController = this.sipController;
        Intrinsics.checkNotNull(sipController);
        return sipController;
    }

    @NotNull
    public final SpenTextWritingView getSpenView() {
        return this.spenView;
    }

    @NotNull
    public final SmTaskController getTaskController() {
        return this.taskController;
    }

    @NotNull
    public final SmTextManager getTextManager() {
        return this.textManager;
    }

    @Nullable
    public final ToolShareControl getToolShareControl() {
        return this.toolShareControl;
    }

    @NotNull
    public final SmWritingControl getWritingControl() {
        return this.writingControl;
    }

    public final boolean onBackPressed() {
        if (this.fTarget != null) {
            FocusManager focusManager = this.focusManager;
            if (!Intrinsics.areEqual(focusManager != null ? focusManager.getCurFocusTarget() : null, this.fTarget)) {
                SmLogger.m8661d(TAG, "onBackPressed# no focus");
                return false;
            }
        }
        if (!this.progressControl.isShowing() && !this.taskController.isWorking()) {
            if (!this.objectManager.isSelectedObject()) {
                return false;
            }
            if (this.objectManager.isFocusedTextBox()) {
                if (!this.textManager.isSelected()) {
                    return false;
                }
                this.textManager.clearSelection();
                return true;
            }
            this.objectManager.clearSelectObject();
        }
        return true;
    }

    public final void onConfiguration(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        if (this.isReleased) {
            return;
        }
        SmWritingControl smWritingControl = this.writingControl;
        Context context = this.spenView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        smWritingControl.updateDeviceState(context, newConfig);
    }

    public final void release() {
        FocusManager focusManager;
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        ToolShareControl toolShareControl = this.toolShareControl;
        if (toolShareControl != null) {
            toolShareControl.release();
        }
        FocusManager.FTarget fTarget = this.fTarget;
        if (fTarget != null && (focusManager = this.focusManager) != null) {
            focusManager.removeTarget(fTarget);
        }
        this.fTarget = null;
        this.taskController.release();
        SipController sipController = this.sipController;
        if (sipController != null) {
            sipController.release();
        }
        this.sipController = null;
    }

    public final void setDragEventDispatcher(@Nullable DragEventDispatcher dragEventDispatcher) {
        this.dragEventDispatcher = dragEventDispatcher;
    }

    public final void setDragNDropControl(@NotNull DragNDropControl dragNDropControl) {
        Intrinsics.checkNotNullParameter(dragNDropControl, "<set-?>");
        this.dragNDropControl = dragNDropControl;
    }

    public final void setFTarget(@Nullable FocusManager.FTarget fTarget) {
        this.fTarget = fTarget;
    }

    public final void setFocusManager(@Nullable FocusManager focusManager) {
        this.focusManager = focusManager;
    }

    public final void setModeControl(@NotNull SmModeControl smModeControl) {
        Intrinsics.checkNotNullParameter(smModeControl, "<set-?>");
        this.modeControl = smModeControl;
    }

    public final void setObjectManager(@NotNull SmObjectManager smObjectManager) {
        Intrinsics.checkNotNullParameter(smObjectManager, "<set-?>");
        this.objectManager = smObjectManager;
    }

    public final void setQuickSaveControl(@NotNull SmQuickSaveControl smQuickSaveControl) {
        Intrinsics.checkNotNullParameter(smQuickSaveControl, "<set-?>");
        this.quickSaveControl = smQuickSaveControl;
    }

    public final void setTextManager(@NotNull SmTextManager smTextManager) {
        Intrinsics.checkNotNullParameter(smTextManager, "<set-?>");
        this.textManager = smTextManager;
    }

    public final void setWritingControl(@NotNull SmWritingControl smWritingControl) {
        Intrinsics.checkNotNullParameter(smWritingControl, "<set-?>");
        this.writingControl = smWritingControl;
    }
}
