package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcher;
import com.samsung.android.support.senl.p148nt.base.composer.focus.FocusManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u000bJ\b\u0010*\u001a\u0004\u0018\u00010\u0011J\b\u0010+\u001a\u0004\u0018\u00010\u0017J\u0006\u0010,\u001a\u00020\u001dJ\u0006\u0010-\u001a\u00020#R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ControlFactory;", "", "<init>", "()V", "sipController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "getSipController", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "setSipController", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;)V", "toolShareControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "getToolShareControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "setToolShareControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;)V", "dragEventDispatcher", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;", "getDragEventDispatcher", "()Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;", "setDragEventDispatcher", "(Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;)V", "focusManager", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;", "getFocusManager", "()Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;", "setFocusManager", "(Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;)V", "progressControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;", "getProgressControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;", "setProgressControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmProgressControl;)V", "quickSaveControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "getQuickSaveControl", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;", "setQuickSaveControl", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmQuickSaveControl;)V", "createSipController", "createToolShareControl", "createDragEventDispatcher", "createFocusManager", "createProgressControl", "createQuickSaveControl", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ControlFactory {

    @Nullable
    private DragEventDispatcher dragEventDispatcher;

    @Nullable
    private FocusManager focusManager;

    @Nullable
    private SmProgressControl progressControl;

    @Nullable
    private SmQuickSaveControl quickSaveControl;

    @Nullable
    private SipController sipController;

    @Nullable
    private ToolShareControl toolShareControl;

    @Nullable
    /* JADX INFO: renamed from: createDragEventDispatcher, reason: from getter */
    public final DragEventDispatcher getDragEventDispatcher() {
        return this.dragEventDispatcher;
    }

    @Nullable
    /* JADX INFO: renamed from: createFocusManager, reason: from getter */
    public final FocusManager getFocusManager() {
        return this.focusManager;
    }

    @NotNull
    public final SmProgressControl createProgressControl() {
        if (this.progressControl == null) {
            this.progressControl = new SmProgressControl();
        }
        SmProgressControl smProgressControl = this.progressControl;
        Intrinsics.checkNotNull(smProgressControl);
        return smProgressControl;
    }

    @NotNull
    public final SmQuickSaveControl createQuickSaveControl() {
        if (this.quickSaveControl == null) {
            this.quickSaveControl = new SmQuickSaveControl();
        }
        SmQuickSaveControl smQuickSaveControl = this.quickSaveControl;
        Intrinsics.checkNotNull(smQuickSaveControl);
        return smQuickSaveControl;
    }

    @NotNull
    public final SipController createSipController() {
        if (this.sipController == null) {
            this.sipController = new SipController();
        }
        SipController sipController = this.sipController;
        Intrinsics.checkNotNull(sipController);
        return sipController;
    }

    @NotNull
    public final ToolShareControl createToolShareControl() {
        if (this.toolShareControl == null) {
            this.toolShareControl = new ToolShareControl();
        }
        ToolShareControl toolShareControl = this.toolShareControl;
        Intrinsics.checkNotNull(toolShareControl);
        return toolShareControl;
    }

    @Nullable
    public final DragEventDispatcher getDragEventDispatcher() {
        return this.dragEventDispatcher;
    }

    @Nullable
    public final FocusManager getFocusManager() {
        return this.focusManager;
    }

    @Nullable
    public final SmProgressControl getProgressControl() {
        return this.progressControl;
    }

    @Nullable
    public final SmQuickSaveControl getQuickSaveControl() {
        return this.quickSaveControl;
    }

    @Nullable
    public final SipController getSipController() {
        return this.sipController;
    }

    @Nullable
    public final ToolShareControl getToolShareControl() {
        return this.toolShareControl;
    }

    public final void setDragEventDispatcher(@Nullable DragEventDispatcher dragEventDispatcher) {
        this.dragEventDispatcher = dragEventDispatcher;
    }

    public final void setFocusManager(@Nullable FocusManager focusManager) {
        this.focusManager = focusManager;
    }

    public final void setProgressControl(@Nullable SmProgressControl smProgressControl) {
        this.progressControl = smProgressControl;
    }

    public final void setQuickSaveControl(@Nullable SmQuickSaveControl smQuickSaveControl) {
        this.quickSaveControl = smQuickSaveControl;
    }

    public final void setSipController(@Nullable SipController sipController) {
        this.sipController = sipController;
    }

    public final void setToolShareControl(@Nullable ToolShareControl toolShareControl) {
        this.toolShareControl = toolShareControl;
    }
}
