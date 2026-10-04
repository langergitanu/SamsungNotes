package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.text.TextUtils;
import android.view.View;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAViewState;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setViewSelected", "", "view", "Landroid/view/View;", "selected", "", "setBtnEnabled", "enabled", "setBtnFocusable", "focusable", "hideTooltip", VPathDataCmd.RCurveTo, "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAViewState {

    @NotNull
    public static final BAViewState INSTANCE = new BAViewState();

    @NotNull
    private static final String TAG = Logger.createTag("BAViewState");

    private BAViewState() {
    }

    public final void hideTooltip(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        CharSequence contentDescription = v.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            return;
        }
        v.setContentDescription(null);
        v.setContentDescription(contentDescription);
    }

    public final void setBtnEnabled(@NotNull View view, boolean enabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m7100d(TAG, "setBtnEnabled() - view/enabled = " + view + "/" + enabled);
        view.setEnabled(enabled);
    }

    public final void setBtnFocusable(@NotNull View view, boolean focusable) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m7100d(TAG, "setBtnFocusable() - view/focusable = " + view + "/" + focusable);
        view.setFocusable(focusable);
    }

    public final void setViewSelected(@NotNull View view, boolean selected) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m7100d(TAG, "setBtnSelected() - view/selected = " + view + "/" + selected);
        view.setSelected(selected);
    }
}
