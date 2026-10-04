package com.samsung.android.sdk.composer.listener;

import android.graphics.RectF;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\tH&J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/listener/SpenIContextMenuListener;", "", "onCreateActionMode", "", "mode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onCreateContextMenu", "", "Landroid/view/ContextMenu;", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onShowContextMenu", "contentRect", "Landroid/graphics/RectF;", "enableVibration", "onHideContextMenu", "onUpdateContentRect", "rect", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenIContextMenuListener {
    boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item);

    boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu);

    void onCreateContextMenu(@Nullable ContextMenu menu);

    void onHideContextMenu();

    boolean onShowContextMenu(@Nullable RectF contentRect, boolean enableVibration);

    void onUpdateContentRect(@Nullable RectF rect);
}
