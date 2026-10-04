package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0003 !\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J4\u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0006\u0010\u001f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl;", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$HistoryEventListener;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "handler", "Landroid/os/Handler;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;Landroid/os/Handler;)V", "updateRedoUndoState", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl$UpdateRedoUndoState;", "notifyOnUndoRedo", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl$NotifyOnUndoRedo;", "onCommit", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "onUndoable", "undoable", "", "onRedoable", "redoable", Constants.ARG_UPDATE, "onUndo", "onRedo", "onPreSubmit", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", TextConst.KEY_START_INDEX, "", "before", "count", "release", "UpdateRedoUndoState", "NotifyOnUndoRedo", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HistoryEventListenerImpl implements SpenWNote.HistoryEventListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("HistoryEventListenerImpl");

    @NotNull
    private final Handler handler;

    @NotNull
    private NotifyOnUndoRedo notifyOnUndoRedo;

    @NotNull
    private final SmControlManager smControlManager;

    @NotNull
    private UpdateRedoUndoState updateRedoUndoState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return HistoryEventListenerImpl.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl$NotifyOnUndoRedo;", "Ljava/lang/Runnable;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl;)V", "run", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class NotifyOnUndoRedo implements Runnable {
        public NotifyOnUndoRedo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToolShareControl toolShareControl = HistoryEventListenerImpl.this.smControlManager.getToolShareControl();
            if (toolShareControl != null) {
                toolShareControl.notifyOnUndoRedo();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl$UpdateRedoUndoState;", "Ljava/lang/Runnable;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl;)V", "isUndoable", "", "()Z", "setUndoable", "(Z)V", "isRedoable", "setRedoable", "run", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class UpdateRedoUndoState implements Runnable {
        private boolean isRedoable;
        private boolean isUndoable;

        public UpdateRedoUndoState() {
        }

        /* JADX INFO: renamed from: isRedoable, reason: from getter */
        public final boolean getIsRedoable() {
            return this.isRedoable;
        }

        /* JADX INFO: renamed from: isUndoable, reason: from getter */
        public final boolean getIsUndoable() {
            return this.isUndoable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToolShareControl toolShareControl = HistoryEventListenerImpl.this.smControlManager.getToolShareControl();
            if (toolShareControl != null) {
                ToolShareControl.updateRedoUndoState$default(toolShareControl, this.isRedoable, this.isUndoable, false, 4, null);
            }
        }

        public final void setRedoable(boolean z) {
            this.isRedoable = z;
        }

        public final void setUndoable(boolean z) {
            this.isUndoable = z;
        }
    }

    public HistoryEventListenerImpl(@NotNull SmControlManager smControlManager, @NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.smControlManager = smControlManager;
        this.handler = handler;
        this.updateRedoUndoState = new UpdateRedoUndoState();
        this.notifyOnUndoRedo = new NotifyOnUndoRedo();
    }

    private final void update() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            this.updateRedoUndoState.run();
        } else {
            this.handler.post(this.updateRedoUndoState);
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
    public void onCommit(@Nullable SpenWNote note) {
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
    public void onPreSubmit(@Nullable SpenWNote note, @Nullable SpenObjectBase obj, int startIndex, int before, int count) {
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
    public void onRedo(@Nullable SpenWNote note) {
        this.handler.post(this.notifyOnUndoRedo);
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
    public void onRedoable(@Nullable SpenWNote note, boolean redoable) {
        UpdateRedoUndoState updateRedoUndoState = this.updateRedoUndoState;
        Intrinsics.checkNotNull(note);
        updateRedoUndoState.setUndoable(note.isUndoable());
        this.updateRedoUndoState.setRedoable(redoable);
        update();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
    public void onUndo(@Nullable SpenWNote note) {
        this.handler.post(this.notifyOnUndoRedo);
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.HistoryEventListener
    public void onUndoable(@Nullable SpenWNote note, boolean undoable) {
        this.updateRedoUndoState.setUndoable(undoable);
        UpdateRedoUndoState updateRedoUndoState = this.updateRedoUndoState;
        Intrinsics.checkNotNull(note);
        updateRedoUndoState.setRedoable(note.isRedoable());
        update();
    }

    public final void release() {
        this.handler.removeCallbacksAndMessages(null);
    }
}
