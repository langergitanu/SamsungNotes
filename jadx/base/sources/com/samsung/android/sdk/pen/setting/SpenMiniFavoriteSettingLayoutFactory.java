package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniFavoriteSettingLayoutFactory;", "", "<init>", "()V", "createPopupLayoutHelper", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPopupLayoutInterface;", "orientation", "", "createFooterGroup", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "createContentLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMiniFavoriteSettingLayoutFactory {

    @NotNull
    public static final SpenMiniFavoriteSettingLayoutFactory INSTANCE = new SpenMiniFavoriteSettingLayoutFactory();

    private SpenMiniFavoriteSettingLayoutFactory() {
    }

    @JvmStatic
    @NotNull
    public static final FrameLayout.LayoutParams createContentLayoutParams(int orientation) {
        return orientation == 0 ? new FrameLayout.LayoutParams(-2, -1) : new FrameLayout.LayoutParams(-2, -2);
    }

    @JvmStatic
    @NotNull
    public static final FrameLayout createFooterGroup(@Nullable Context context, int orientation) {
        View viewInflate = View.inflate(context, orientation == 0 ? C7932R.layout.setting_mini_favorite_footer_land_group : C7932R.layout.setting_mini_favorite_footer_group, null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        return (FrameLayout) viewInflate;
    }

    @JvmStatic
    @NotNull
    public static final SpenMiniPopupLayoutInterface createPopupLayoutHelper(int orientation) {
        return orientation == 0 ? new SpenMiniPopupHorizontalHelper(C7932R.layout.setting_mini_favorite_popup_land_layout) : new SpenMiniPopupVerticalHelper(C7932R.layout.setting_mini_favorite_popup_layout);
    }
}
