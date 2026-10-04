package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.contextmenu.SmContextMenuManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/listener/ContextMenuListenerImpl;", "Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "smContextMenuManager", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;)V", "getSmContextMenuManager", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/contextmenu/SmContextMenuManager;", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onCreateContextMenu", "", "Landroid/view/ContextMenu;", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContextMenuListenerImpl extends SpenContextMenuListener {

    @NotNull
    private final SmContextMenuManager smContextMenuManager;

    public ContextMenuListenerImpl(@NotNull SmContextMenuManager smContextMenuManager) {
        Intrinsics.checkNotNullParameter(smContextMenuManager, "smContextMenuManager");
        this.smContextMenuManager = smContextMenuManager;
    }

    @NotNull
    public final SmContextMenuManager getSmContextMenuManager() {
        return this.smContextMenuManager;
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
    public boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item) {
        SmContextMenuManager smContextMenuManager = this.smContextMenuManager;
        Intrinsics.checkNotNull(item);
        smContextMenuManager.executeMenuItem(item);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
    public boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
        SmContextMenuManager smContextMenuManager = this.smContextMenuManager;
        Intrinsics.checkNotNull(menu);
        smContextMenuManager.createContextMenu(menu, true);
        return this.smContextMenuManager.canShowContextMenu(menu);
    }

    @Override // com.samsung.android.sdk.pen.view.contextmenu.SpenContextMenuListener
    public void onCreateContextMenu(@Nullable ContextMenu menu) {
        SmContextMenuManager smContextMenuManager = this.smContextMenuManager;
        Intrinsics.checkNotNull(menu);
        smContextMenuManager.createContextMenu(menu, false);
    }
}
