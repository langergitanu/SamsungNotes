package com.samsung.android.sdk.pen.view.contextmenu;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u001c\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u0015\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/contextmenu/SpenContextMenuInterface;", "", "showContextMenu", "", "contentRect", "Landroid/graphics/RectF;", "enableVibration", "", "hideContextMenu", "onCreateActionMode", "mode", "Landroid/view/ActionMode;", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "setContentRect", "rect", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenContextMenuInterface {
    void hideContextMenu();

    boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item);

    boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu);

    void onDestroyActionMode(@Nullable ActionMode mode);

    void onGetContentRect(@Nullable ActionMode mode, @Nullable View view, @Nullable Rect outRect);

    boolean onPrepareActionMode(@Nullable ActionMode mode, @Nullable Menu menu);

    void setContentRect(@Nullable RectF rect);

    void showContextMenu(@Nullable RectF contentRect, boolean enableVibration);
}
