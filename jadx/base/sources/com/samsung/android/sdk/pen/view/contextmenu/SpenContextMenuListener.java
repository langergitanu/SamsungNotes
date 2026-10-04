package com.samsung.android.sdk.pen.view.contextmenu;

import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuListener;", "", "<init>", "()V", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onCreateContextMenu", "", "Landroid/view/ContextMenu;", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenContextMenuListener {
    public boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item) {
        return false;
    }

    public boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
        return false;
    }

    public void onCreateContextMenu(@Nullable ContextMenu menu) {
    }
}
