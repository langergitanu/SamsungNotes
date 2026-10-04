package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.utils;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SolveMathUtil {
    private static final int EXCEPTIONAL_CASE_LEFT_RIGHT_MARGIN_DP = 0;
    private static final int EXTERNAL_COMPONENT_LEFT_RIGHT_MARGIN_DP = 12;
    private static final int EXTERNAL_COMPONENT_UP_DOWN_MARGIN_DP = 8;
    private static final String TAG = "SolveMathUtil";

    public static int convertDpToPixel(Context context, int i) {
        return (int) ResourceUtils.convertDpToPixel(context, i);
    }

    public static int getExceptionalCaseLeftRightMargin() {
        return 0;
    }

    public static int getExternalComponentLeftRightMargin(Context context) {
        return (int) ResourceUtils.convertDpToPixel(context, 12.0f);
    }

    public static int getExternalComponentUpDownMargin(Context context) {
        return (int) ResourceUtils.convertDpToPixel(context, 8.0f);
    }
}
