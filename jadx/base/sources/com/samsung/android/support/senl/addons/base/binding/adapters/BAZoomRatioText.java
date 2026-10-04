package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.samsung.android.support.senl.addons.C7944R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAZoomRatioText;", "", "<init>", "()V", "DELAY_TIME", "", "mZoomTextHandler", "Landroid/os/Handler;", "mMapView", "Ljava/util/HashMap;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "setZoomRatioText", "", "view", "Landroid/widget/TextView;", "value", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAZoomRatioText {
    private static final int DELAY_TIME = 1000;

    @NotNull
    public static final BAZoomRatioText INSTANCE = new BAZoomRatioText();

    @Nullable
    private static HashMap<View, Handler> mMapView;

    @Nullable
    private static Handler mZoomTextHandler;

    private BAZoomRatioText() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setZoomRatioText$lambda$1(TextView textView) {
        textView.animate().alpha(0.0f).setDuration(textView.getResources().getInteger(C7944R.integer.base_editor_sub_menu_anim_duration)).withEndAction(new RunnableC7949a(textView, 1)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setZoomRatioText$lambda$1$lambda$0(TextView textView) {
        textView.setVisibility(8);
        textView.setAlpha(1.0f);
        HashMap<View, Handler> map = mMapView;
        Intrinsics.checkNotNull(map);
        map.remove(textView);
    }

    public void setZoomRatioText(@NotNull TextView view, int value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setText(view.getResources().getString(C7944R.string.base_zoom_percent, Integer.valueOf(value), '%'));
        if (mMapView == null) {
            mMapView = new HashMap<>();
        }
        HashMap<View, Handler> map = mMapView;
        Intrinsics.checkNotNull(map);
        if (!map.containsKey(view)) {
            HashMap<View, Handler> map2 = mMapView;
            Intrinsics.checkNotNull(map2);
            map2.put(view, new Handler(Looper.getMainLooper()));
        }
        HashMap<View, Handler> map3 = mMapView;
        Intrinsics.checkNotNull(map3);
        Handler handler = map3.get(view);
        mZoomTextHandler = handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = mZoomTextHandler;
        if (handler2 != null) {
            handler2.postDelayed(new RunnableC7949a(view, 0), 1000L);
        }
    }
}
