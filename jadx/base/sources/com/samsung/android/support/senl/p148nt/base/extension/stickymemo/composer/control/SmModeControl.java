package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control;

import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.mode.SmMode;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002 !B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl;", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "sipController", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;", "objectManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;", "writingControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;", "<init>", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Lcom/samsung/android/sdk/composer/SpenTextWritingView;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/sip/SipController;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmObjectManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmWritingControl;)V", "getNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "curMode", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/mode/SmMode;", "editModeChangeListener", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl$EditModeChangeListener;", "getEditModeChangeListener", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl$EditModeChangeListener;", "setEditModeChangeListener", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl$EditModeChangeListener;)V", "setTextMode", "", "setHwMode", "setReadMode", "isEditMode", "", "isWritingMode", "isTextMode", "EditModeChangeListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmModeControl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmModeControl");

    @NotNull
    private SmMode curMode;

    @Nullable
    private EditModeChangeListener editModeChangeListener;

    @NotNull
    private final SpenWNote note;

    @NotNull
    private final SmObjectManager objectManager;

    @NotNull
    private final SipController sipController;

    @NotNull
    private final SpenTextWritingView spenView;

    @NotNull
    private final SmWritingControl writingControl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return SmModeControl.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmModeControl$EditModeChangeListener;", "", "onEditModeChanged", "", "mode", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/mode/SmMode;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface EditModeChangeListener {
        void onEditModeChanged(@NotNull SmMode mode);
    }

    public SmModeControl(@NotNull SpenWNote note, @NotNull SpenTextWritingView spenView, @NotNull SipController sipController, @NotNull SmObjectManager objectManager, @NotNull SmWritingControl writingControl) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(sipController, "sipController");
        Intrinsics.checkNotNullParameter(objectManager, "objectManager");
        Intrinsics.checkNotNullParameter(writingControl, "writingControl");
        this.note = note;
        this.spenView = spenView;
        this.sipController = sipController;
        this.objectManager = objectManager;
        this.writingControl = writingControl;
        this.curMode = SmMode.MODE_HW;
    }

    @Nullable
    public final EditModeChangeListener getEditModeChangeListener() {
        return this.editModeChangeListener;
    }

    @NotNull
    public final SpenWNote getNote() {
        return this.note;
    }

    public final boolean isEditMode() {
        return this.curMode != SmMode.MODE_READONLY;
    }

    public final boolean isTextMode() {
        return this.curMode == SmMode.MODE_TEXT;
    }

    public final boolean isWritingMode() {
        return this.curMode == SmMode.MODE_HW;
    }

    public final void setEditModeChangeListener(@Nullable EditModeChangeListener editModeChangeListener) {
        this.editModeChangeListener = editModeChangeListener;
    }

    public final void setHwMode() {
        SmLogger.m8661d(TAG, "setHwMode");
        if (this.curMode == SmMode.MODE_TEXT) {
            this.note.commitHistory();
        }
        this.writingControl.setToolTypeAction(2, 2);
        this.writingControl.setToolTypeAction(6, 8);
        SmMode smMode = SmMode.MODE_HW;
        this.curMode = smMode;
        smMode.setMode(this.spenView);
        this.note.selectObject((SpenObjectBase) null);
        this.sipController.hide(this.spenView);
        EditModeChangeListener editModeChangeListener = this.editModeChangeListener;
        if (editModeChangeListener != null) {
            editModeChangeListener.onEditModeChanged(this.curMode);
        }
    }

    public final void setReadMode() {
        this.objectManager.clearSelection();
        this.sipController.hide(this.spenView);
        SmMode smMode = SmMode.MODE_READONLY;
        this.curMode = smMode;
        smMode.setMode(this.spenView);
        EditModeChangeListener editModeChangeListener = this.editModeChangeListener;
        if (editModeChangeListener != null) {
            editModeChangeListener.onEditModeChanged(this.curMode);
        }
    }

    public final void setTextMode() {
        SmLogger.m8661d(TAG, "setTextMode");
        if (this.curMode == SmMode.MODE_HW) {
            this.note.commitHistory();
        }
        this.writingControl.setToolTypeAction(2, 1);
        this.writingControl.setToolTypeAction(6, 0);
        SmMode smMode = SmMode.MODE_TEXT;
        this.curMode = smMode;
        smMode.setMode(this.spenView);
        SpenWNote spenWNote = this.note;
        spenWNote.selectObject(spenWNote.getBodyText());
        this.sipController.show(this.spenView);
        EditModeChangeListener editModeChangeListener = this.editModeChangeListener;
        if (editModeChangeListener != null) {
            editModeChangeListener.onEditModeChanged(this.curMode);
        }
    }
}
