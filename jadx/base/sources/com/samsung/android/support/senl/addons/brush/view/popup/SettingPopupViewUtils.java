package com.samsung.android.support.senl.addons.brush.view.popup;

import android.graphics.Rect;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/SettingPopupViewUtils;", "", "<init>", "()V", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingPopupViewUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createBrushTag("SettingPopupViewUtils");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ6\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ&\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/popup/SettingPopupViewUtils$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "resetPopupParams", "", ActionHandler.PARAMS, "Landroid/widget/RelativeLayout$LayoutParams;", "setPopupParams", "baseID", "", "align", "betweenSpace", "isStart", "", TypedValues.Cycle.S_WAVE_OFFSET, "getMenuViewParams", "width", "isRTL", "rect", "Landroid/graphics/Rect;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RelativeLayout.LayoutParams getMenuViewParams(int width, boolean isRTL, @NotNull Rect rect, int align) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rect.width(), rect.height());
            layoutParams.width = rect.width();
            layoutParams.height = rect.height();
            layoutParams.removeRule(10);
            layoutParams.removeRule(12);
            layoutParams.removeRule(20);
            layoutParams.removeRule(21);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(0);
            if (align == 1) {
                layoutParams.addRule(10);
                layoutParams.addRule(21);
                layoutParams.setMarginEnd(!isRTL ? width - rect.right : rect.left);
                layoutParams.topMargin = rect.top;
                return layoutParams;
            }
            if (align == 2 || align == 3) {
                layoutParams.addRule(10);
                layoutParams.addRule(20);
                layoutParams.setMarginStart(!isRTL ? rect.left : width - rect.right);
                layoutParams.topMargin = rect.top;
                return layoutParams;
            }
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            layoutParams.setMarginStart(!isRTL ? rect.left : width - rect.right);
            layoutParams.bottomMargin = width - rect.bottom;
            return layoutParams;
        }

        public final void resetPopupParams(@NotNull RelativeLayout.LayoutParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            params.removeRule(2);
            params.removeRule(3);
            params.removeRule(16);
            params.removeRule(17);
            params.removeRule(18);
            params.removeRule(19);
            params.removeRule(6);
            params.removeRule(8);
            params.setMarginStart(0);
            params.setMarginEnd(0);
            params.rightMargin = 0;
            params.leftMargin = 0;
            params.topMargin = 0;
            params.bottomMargin = 0;
        }

        public final void setPopupParams(@NotNull RelativeLayout.LayoutParams params, int baseID, int align, int betweenSpace, boolean isStart, int offset) {
            Intrinsics.checkNotNullParameter(params, "params");
            String str = SettingPopupViewUtils.TAG;
            StringBuilder sb = new StringBuilder(" setPopupParams() params=");
            sb.append(params);
            sb.append(" baseID=");
            sb.append(baseID);
            sb.append(" align=");
            AbstractC2821a.m2235z(sb, align, betweenSpace, " betweenSpace=", " isStart=");
            sb.append(isStart);
            sb.append(" offset=");
            sb.append(offset);
            Logger.m7100d(str, sb.toString());
            if (align == 0) {
                params.bottomMargin = betweenSpace;
                params.addRule(2, baseID);
                if (isStart) {
                    params.addRule(18, baseID);
                    params.setMarginStart(offset);
                    return;
                } else {
                    params.addRule(19, baseID);
                    params.setMarginEnd(offset);
                    return;
                }
            }
            if (align == 1) {
                params.setMarginEnd(betweenSpace);
                params.addRule(16, baseID);
                if (isStart) {
                    params.addRule(8, baseID);
                    params.bottomMargin = offset;
                    return;
                } else {
                    params.addRule(6, baseID);
                    params.topMargin = offset;
                    return;
                }
            }
            if (align == 2) {
                params.setMarginStart(betweenSpace);
                params.addRule(17, baseID);
                if (isStart) {
                    params.addRule(6, baseID);
                    params.topMargin = offset;
                    return;
                } else {
                    params.addRule(8, baseID);
                    params.bottomMargin = offset;
                    return;
                }
            }
            if (align != 3) {
                return;
            }
            params.topMargin = betweenSpace;
            params.addRule(3, baseID);
            if (isStart) {
                params.addRule(18, baseID);
                params.setMarginStart(offset);
            } else {
                params.addRule(19, baseID);
                params.setMarginEnd(offset);
            }
        }

        private Companion() {
        }
    }
}
