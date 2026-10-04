package com.samsung.android.support.senl.p148nt.model.utils;

import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FeatureUtils {
    public static final boolean ENABLE_REDUCE_IMAGE_SIZE = false;
    public static final boolean FEATURE_PDF_OCR_SEARCH = false;
    public static final boolean SUPPORT_A4_LANDSCAPE = true;
    private static final String TAG = ModelLogger.createTag("FeatureUtils");
    public static boolean ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING = true;
    private static Boolean sSupportedSolveMath = null;

    public static boolean isSolveMathSupported() {
        if (sSupportedSolveMath == null) {
            sSupportedSolveMath = Boolean.TRUE;
            if (DeviceInfo.isVSTModel()) {
                sSupportedSolveMath = Boolean.FALSE;
            }
            if (DeviceUtils.isPhoneModel() && !DeviceUtils.isSupportedHandWritingRecognition(BaseUtils.getApplicationContext())) {
                sSupportedSolveMath = Boolean.FALSE;
            }
            DataLogger.m12307i(TAG, "isSolveMathSupported sSupportedSolveMath " + sSupportedSolveMath);
        }
        return (!sSupportedSolveMath.booleanValue() || LocaleUtils.isRTLMode() || DeviceUtils.isPowerManageMode(BaseUtils.getApplicationContext())) ? false : true;
    }
}
