package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.os.Handler;
import android.view.View;
import com.samsung.android.sdk.composer.SpenTextWritingView;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcher;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.shortcut.SmShortcutManager;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SmListenerManager;", "", "spenView", "Lcom/samsung/android/sdk/composer/SpenTextWritingView;", "handler", "Landroid/os/Handler;", "smControlManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;", "smContextMenuManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;", "shortcutManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;", "<init>", "(Lcom/samsung/android/sdk/composer/SpenTextWritingView;Landroid/os/Handler;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/SmControlManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/shortcut/SmShortcutManager;)V", "sipListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SoftInputListenerImpl;", "onFocusChangeListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnFocusChangeListenerImpl;", "cursorChangedListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/CursorChangedListenerImpl;", "spenTextManagerActionListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenTextManagerActionListenerImpl;", "contextMenuListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/ContextMenuListenerImpl;", "actionListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/ActionListenerImpl;", "toastActionListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/ToastActionListenerImpl;", "dragListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnDragListenerImpl;", "spenControlObjectListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenControlObjectListenerImpl;", "onKeyListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/OnKeyListenerImpl;", "preTouchListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/SpenPreTouchListenerImpl;", "textEventListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/TextEventListenerImpl;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "historyEventListenerImpl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/HistoryEventListenerImpl;", "release", "", "getFocusChangeListener", "getSpenTextManagerActionListener", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmListenerManager {

    @NotNull
    private final ActionListenerImpl actionListenerImpl;

    @NotNull
    private final ContextMenuListenerImpl contextMenuListenerImpl;

    @NotNull
    private final CursorChangedListenerImpl cursorChangedListenerImpl;

    @NotNull
    private final OnDragListenerImpl dragListenerImpl;

    @NotNull
    private final HistoryEventListenerImpl historyEventListenerImpl;

    @NotNull
    private SpenWNote note;

    @NotNull
    private final OnFocusChangeListenerImpl onFocusChangeListenerImpl;

    @NotNull
    private final OnKeyListenerImpl onKeyListenerImpl;

    @NotNull
    private final SpenPreTouchListenerImpl preTouchListenerImpl;

    @NotNull
    private final SoftInputListenerImpl sipListenerImpl;

    @NotNull
    private final SpenControlObjectListenerImpl spenControlObjectListenerImpl;

    @NotNull
    private final SpenTextManagerActionListenerImpl spenTextManagerActionListenerImpl;

    @NotNull
    private final SpenTextWritingView spenView;

    @NotNull
    private final TextEventListenerImpl textEventListenerImpl;

    @NotNull
    private final ToastActionListenerImpl toastActionListenerImpl;

    public SmListenerManager(@NotNull SpenTextWritingView spenView, @NotNull Handler handler, @NotNull SmControlManager smControlManager, @NotNull SmContextMenuManager smContextMenuManager, @NotNull SmShortcutManager shortcutManager) {
        Intrinsics.checkNotNullParameter(spenView, "spenView");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(smControlManager, "smControlManager");
        Intrinsics.checkNotNullParameter(smContextMenuManager, "smContextMenuManager");
        Intrinsics.checkNotNullParameter(shortcutManager, "shortcutManager");
        this.spenView = spenView;
        SoftInputListenerImpl softInputListenerImpl = new SoftInputListenerImpl(spenView, handler, smControlManager, shortcutManager);
        this.sipListenerImpl = softInputListenerImpl;
        OnFocusChangeListenerImpl onFocusChangeListenerImpl = new OnFocusChangeListenerImpl(smControlManager);
        this.onFocusChangeListenerImpl = onFocusChangeListenerImpl;
        CursorChangedListenerImpl cursorChangedListenerImpl = new CursorChangedListenerImpl(smControlManager);
        this.cursorChangedListenerImpl = cursorChangedListenerImpl;
        SpenTextManagerActionListenerImpl spenTextManagerActionListenerImpl = new SpenTextManagerActionListenerImpl(smControlManager.getTextManager(), smControlManager.getDragNDropControl());
        this.spenTextManagerActionListenerImpl = spenTextManagerActionListenerImpl;
        ContextMenuListenerImpl contextMenuListenerImpl = new ContextMenuListenerImpl(smContextMenuManager);
        this.contextMenuListenerImpl = contextMenuListenerImpl;
        ActionListenerImpl actionListenerImpl = new ActionListenerImpl(smContextMenuManager);
        this.actionListenerImpl = actionListenerImpl;
        ToastActionListenerImpl toastActionListenerImpl = new ToastActionListenerImpl();
        this.toastActionListenerImpl = toastActionListenerImpl;
        OnDragListenerImpl onDragListenerImpl = new OnDragListenerImpl(spenView, smControlManager, smContextMenuManager.getPasteMenu());
        this.dragListenerImpl = onDragListenerImpl;
        SpenControlObjectListenerImpl spenControlObjectListenerImpl = new SpenControlObjectListenerImpl(smControlManager);
        this.spenControlObjectListenerImpl = spenControlObjectListenerImpl;
        OnKeyListenerImpl onKeyListenerImpl = new OnKeyListenerImpl(shortcutManager);
        this.onKeyListenerImpl = onKeyListenerImpl;
        SpenPreTouchListenerImpl spenPreTouchListenerImpl = new SpenPreTouchListenerImpl(smControlManager.getQuickSaveControl(), smControlManager.getToolShareControl());
        this.preTouchListenerImpl = spenPreTouchListenerImpl;
        TextEventListenerImpl textEventListenerImpl = new TextEventListenerImpl(smControlManager.getTextManager());
        this.textEventListenerImpl = textEventListenerImpl;
        HistoryEventListenerImpl historyEventListenerImpl = new HistoryEventListenerImpl(smControlManager, handler);
        this.historyEventListenerImpl = historyEventListenerImpl;
        spenView.getTextManager().setSoftInputListener(softInputListenerImpl);
        spenView.getTextManager().setCursorChangedListener(cursorChangedListenerImpl);
        spenView.getTextManager().setActionListener(spenTextManagerActionListenerImpl);
        spenView.getTextManager().setTextLimitListener(textEventListenerImpl);
        spenView.setOnFocusChangeListener(onFocusChangeListenerImpl);
        spenView.getListenerManager().setContextMenuListener(contextMenuListenerImpl);
        spenView.getListenerManager().setComposerActionListener(actionListenerImpl);
        spenView.getListenerManager().setPreTouchListener(spenPreTouchListenerImpl);
        spenView.getNoteWritingViewManager().setToastActionListener(toastActionListenerImpl);
        spenView.getControlObjectManager().setObjectListener(spenControlObjectListenerImpl);
        spenView.setOnKeyListener(onKeyListenerImpl);
        if (smControlManager.getDragEventDispatcher() == null) {
            spenView.setOnDragListener(onDragListenerImpl);
        } else {
            DragEventDispatcher dragEventDispatcher = smControlManager.getDragEventDispatcher();
            if (dragEventDispatcher != null) {
                View viewFindViewById = spenView.getRootView().findViewById(C8875R.id.sticky_memo_root);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                dragEventDispatcher.setTarget(viewFindViewById, spenView, onDragListenerImpl);
            }
        }
        SpenWNote note = smControlManager.getObjectManager().getNote();
        this.note = note;
        note.registerHistoryEventListener(historyEventListenerImpl);
    }

    @NotNull
    /* JADX INFO: renamed from: getFocusChangeListener, reason: from getter */
    public final OnFocusChangeListenerImpl getOnFocusChangeListenerImpl() {
        return this.onFocusChangeListenerImpl;
    }

    @NotNull
    /* JADX INFO: renamed from: getSpenTextManagerActionListener, reason: from getter */
    public final SpenTextManagerActionListenerImpl getSpenTextManagerActionListenerImpl() {
        return this.spenTextManagerActionListenerImpl;
    }

    public final void release() {
        this.cursorChangedListenerImpl.release();
        this.preTouchListenerImpl.release();
        this.spenView.setOnDragListener(null);
        this.spenView.getNoteWritingViewManager().setToastActionListener(null);
        this.spenView.getListenerManager().setComposerActionListener(null);
        this.spenView.getListenerManager().setContextMenuListener(null);
        this.spenView.getListenerManager().setPreTouchListener(null);
        this.spenView.getTextManager().setSoftInputListener(null);
        this.spenView.getTextManager().setCursorChangedListener(null);
        this.spenView.getTextManager().setActionListener(null);
        this.spenView.getTextManager().setTextLimitListener(null);
        this.spenView.setOnFocusChangeListener(null);
        this.spenView.getControlObjectManager().setObjectListener(null);
        this.spenView.setOnKeyListener(null);
        this.onFocusChangeListenerImpl.release();
        this.spenTextManagerActionListenerImpl.release();
        this.historyEventListenerImpl.release();
        this.note.deregisterHistoryEventListener(this.historyEventListenerImpl);
    }
}
