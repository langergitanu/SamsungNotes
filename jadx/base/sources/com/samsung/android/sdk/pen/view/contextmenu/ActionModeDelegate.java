package com.samsung.android.sdk.pen.view.contextmenu;

import android.view.ActionMode;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/contextmenu/ActionModeDelegate;", "", "mActionMode", "Landroid/view/ActionMode;", "<init>", "(Landroid/view/ActionMode;)V", "finish", "", "invalidate", "invalidateContentRect", "hide", "value", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ActionModeDelegate {

    @Nullable
    private ActionMode mActionMode;

    public ActionModeDelegate(@Nullable ActionMode actionMode) {
        this.mActionMode = actionMode;
    }

    public final void finish() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.mActionMode = null;
    }

    public final void hide(int value) {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.hide(value);
        }
    }

    public final void invalidate() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.invalidate();
        }
    }

    public final void invalidateContentRect() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.invalidateContentRect();
        }
    }
}
