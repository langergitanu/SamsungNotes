package com.samsung.android.sdk.pen.view.contextmenu;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ$\u0010\u0017\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\u00060\nR\u00020\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate;", "", "mContextMenu", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuInterface;", "<init>", "(Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuInterface;)V", "getMContextMenu", "()Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuInterface;", "setMContextMenu", "mCallbackV23", "Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate$TextActionModeCallback;", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "TextActionModeCallback", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ActionModeCallbackDelegate {

    @NotNull
    private static final String TAG = "ActionModeCallbackDelegate";

    @JvmField
    @NotNull
    public TextActionModeCallback mCallbackV23 = new TextActionModeCallback(this, this);

    @Nullable
    private SpenContextMenuInterface mContextMenu;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0016\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate$TextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "mDelegate", "Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate;", "<init>", "(Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate;Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate;)V", "getMDelegate", "()Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate;", "setMDelegate", "(Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeCallbackDelegate;)V", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @TargetApi(23)
    public final class TextActionModeCallback extends ActionMode.Callback2 {

        @NotNull
        private ActionModeCallbackDelegate mDelegate;
        final /* synthetic */ ActionModeCallbackDelegate this$0;

        public TextActionModeCallback(@NotNull ActionModeCallbackDelegate actionModeCallbackDelegate, ActionModeCallbackDelegate mDelegate) {
            Intrinsics.checkNotNullParameter(mDelegate, "mDelegate");
            this.this$0 = actionModeCallbackDelegate;
            this.mDelegate = mDelegate;
        }

        @NotNull
        public final ActionModeCallbackDelegate getMDelegate() {
            return this.mDelegate;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item) {
            return this.mDelegate.onActionItemClicked(mode, item);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            return this.mDelegate.onCreateActionMode(mode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(@Nullable ActionMode mode) {
            this.mDelegate.onDestroyActionMode(mode);
        }

        @Override // android.view.ActionMode.Callback2
        public void onGetContentRect(@Nullable ActionMode mode, @Nullable View view, @Nullable Rect outRect) {
            super.onGetContentRect(mode, view, outRect);
            this.mDelegate.onGetContentRect(mode, view, outRect);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            return this.mDelegate.onPrepareActionMode(mode, menu);
        }

        public final void setMDelegate(@NotNull ActionModeCallbackDelegate actionModeCallbackDelegate) {
            Intrinsics.checkNotNullParameter(actionModeCallbackDelegate, "<set-?>");
            this.mDelegate = actionModeCallbackDelegate;
        }
    }

    public ActionModeCallbackDelegate(@Nullable SpenContextMenuInterface spenContextMenuInterface) {
        this.mContextMenu = spenContextMenuInterface;
    }

    @Nullable
    public final SpenContextMenuInterface getMContextMenu() {
        return this.mContextMenu;
    }

    public final boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item) {
        SpenContextMenuInterface spenContextMenuInterface = this.mContextMenu;
        if (spenContextMenuInterface != null) {
            return spenContextMenuInterface.onActionItemClicked(mode, item);
        }
        return false;
    }

    public final boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
        if (mode != null) {
            mode.setTitle((CharSequence) null);
        }
        if (mode != null) {
            mode.setSubtitle((CharSequence) null);
        }
        if (mode != null) {
            mode.setTitleOptionalHint(true);
        }
        SpenContextMenuInterface spenContextMenuInterface = this.mContextMenu;
        if (spenContextMenuInterface != null) {
            return spenContextMenuInterface.onCreateActionMode(mode, menu);
        }
        return false;
    }

    public final void onDestroyActionMode(@Nullable ActionMode mode) {
        SpenContextMenuInterface spenContextMenuInterface = this.mContextMenu;
        if (spenContextMenuInterface != null) {
            spenContextMenuInterface.onDestroyActionMode(mode);
        }
    }

    public final void onGetContentRect(@Nullable ActionMode mode, @Nullable View view, @Nullable Rect outRect) {
        SpenContextMenuInterface spenContextMenuInterface = this.mContextMenu;
        if (spenContextMenuInterface != null) {
            spenContextMenuInterface.onGetContentRect(mode, view, outRect);
        }
    }

    public final boolean onPrepareActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
        SpenContextMenuInterface spenContextMenuInterface = this.mContextMenu;
        if (spenContextMenuInterface != null) {
            return spenContextMenuInterface.onPrepareActionMode(mode, menu);
        }
        return false;
    }

    public final void setMContextMenu(@Nullable SpenContextMenuInterface spenContextMenuInterface) {
        this.mContextMenu = spenContextMenuInterface;
    }
}
