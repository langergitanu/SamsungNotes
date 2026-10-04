package com.samsung.android.sdk.pen.util;

import android.view.View;
import com.samsung.android.spen.libwrapper.ViewWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/SpenHoverUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setPopupPosOffset", "", "view", "Landroid/view/View;", "x", "", "y", "setHoverPopupType", "type", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHoverUtil {

    @NotNull
    public static final SpenHoverUtil INSTANCE = new SpenHoverUtil();

    @NotNull
    private static final String TAG = "SpenUtilHover";

    private SpenHoverUtil() {
    }

    public final void setHoverPopupType(@NotNull View view, int type) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            ViewWrapper.create(view.getContext(), view).setHoverPopupType(type);
        } catch (PlatformException e) {
            e.printStackTrace();
        }
    }

    public final void setPopupPosOffset(@NotNull View view, int x, int y2) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            ViewWrapper.create(view.getContext(), view).getHoverPopupWindow().setOffset(x, y2);
        } catch (PlatformException e) {
            e.printStackTrace();
        }
    }
}
