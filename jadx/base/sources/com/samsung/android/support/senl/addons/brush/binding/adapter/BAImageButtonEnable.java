package com.samsung.android.support.senl.addons.brush.binding.adapter;

import android.view.View;
import android.widget.ImageView;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/adapter/BAImageButtonEnable;", "", "<init>", "()V", "setButtonEnable", "", "view", "Landroid/view/View;", "enable", "", "withEnTint", "setDesktopModeEnable", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAImageButtonEnable {

    @NotNull
    public static final BAImageButtonEnable INSTANCE = new BAImageButtonEnable();

    private BAImageButtonEnable() {
    }

    public final void setButtonEnable(@Nullable View view, boolean enable, boolean withEnTint) {
        if (view instanceof ImageView) {
            int color = enable ? withEnTint ? ((ImageView) view).getResources().getColor(C7944R.color.brush_btn_enable, null) : 0 : ((ImageView) view).getResources().getColor(C7944R.color.brush_btn_disable, null);
            ImageView imageView = (ImageView) view;
            imageView.setColorFilter(color);
            imageView.setEnabled(enable);
        }
    }

    public final void setDesktopModeEnable(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVisibility(DesktopModeCompat.INSTANCE.getInstance().isDexMode(view.getContext()) ? 0 : 4);
    }
}
