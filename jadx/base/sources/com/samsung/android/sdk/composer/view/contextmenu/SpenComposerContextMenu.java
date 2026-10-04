package com.samsung.android.sdk.composer.view.contextmenu;

import android.graphics.RectF;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.samsung.android.sdk.composer.listener.SpenIContextMenuListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenu;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/view/contextmenu/SpenComposerContextMenu;", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenu;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mListenerManager", "Lcom/samsung/android/sdk/composer/listener/SpenIContextMenuListener;", "setListerManager", "", "listerManager", "setContextMenuDelegate", "delegate", "Lcom/samsung/android/sdk/composer/view/contextmenu/SpenContextMenuDelegate;", "close", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenComposerContextMenu extends SpenContextMenu {

    @Nullable
    private SpenIContextMenuListener mListenerManager;

    public SpenComposerContextMenu(@Nullable View view) {
        super(view);
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenu
    public void close() {
        super.close();
        this.mListenerManager = null;
    }

    public final void setContextMenuDelegate(@NotNull SpenContextMenuDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        delegate.setListener(new SpenContextMenuDelegateListener() { // from class: com.samsung.android.sdk.composer.view.contextmenu.SpenComposerContextMenu.setContextMenuDelegate.1
            @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
            public void onHideContextMenu() {
                SpenIContextMenuListener spenIContextMenuListener = SpenComposerContextMenu.this.mListenerManager;
                if (spenIContextMenuListener != null) {
                    spenIContextMenuListener.onHideContextMenu();
                }
            }

            @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
            public boolean onShowContextMenu(RectF contentRect, boolean enableVibration) {
                SpenIContextMenuListener spenIContextMenuListener = SpenComposerContextMenu.this.mListenerManager;
                if (spenIContextMenuListener != null) {
                    return spenIContextMenuListener.onShowContextMenu(contentRect, enableVibration);
                }
                return false;
            }

            @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuDelegateListener
            public void onUpdateContentRect(RectF rect) {
                SpenIContextMenuListener spenIContextMenuListener = SpenComposerContextMenu.this.mListenerManager;
                if (spenIContextMenuListener != null) {
                    spenIContextMenuListener.onUpdateContentRect(rect);
                }
            }
        });
        setContextMenuDelegateListener(delegate);
    }

    public final void setListerManager(@Nullable SpenIContextMenuListener listerManager) {
        this.mListenerManager = listerManager;
        setContextMenuListener(new SpenContextMenuListener() { // from class: com.samsung.android.sdk.composer.view.contextmenu.SpenComposerContextMenu.setListerManager.1
            @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                SpenIContextMenuListener spenIContextMenuListener = SpenComposerContextMenu.this.mListenerManager;
                if (spenIContextMenuListener != null) {
                    return spenIContextMenuListener.onActionItemClicked(mode, item);
                }
                return false;
            }

            @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                SpenIContextMenuListener spenIContextMenuListener = SpenComposerContextMenu.this.mListenerManager;
                if (spenIContextMenuListener != null) {
                    return spenIContextMenuListener.onCreateActionMode(mode, menu);
                }
                return false;
            }

            @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
            public void onCreateContextMenu(ContextMenu menu) {
                SpenIContextMenuListener spenIContextMenuListener = SpenComposerContextMenu.this.mListenerManager;
                if (spenIContextMenuListener != null) {
                    spenIContextMenuListener.onCreateContextMenu(menu);
                }
            }
        });
    }
}
