package com.sec.android.diagmonagent.dma.aperf.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.dma.aperf.Operation;
import com.sec.android.diagmonagent.dma.aperf.SubOperation;
import com.sec.android.diagmonagent.dma.aperf.Tag;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class aPerfValidation {
    public static final int LIMIT_OPERATION = 20;
    public static final int LIMIT_SUBOPERATION = 10;
    private static final int MAX_LEN_OPERATION_NAME = 100;
    private static final int MAX_LEN_SUBOPERATION_NAME = 30;
    private static final int MAX_LEN_TAGS = 3;
    private static final int MAX_LEN_TAG_KEY = 30;
    private static final int MAX_LEN_TAG_VALUE = 30;
    private static final int SEP_VER_12_1 = 120100;

    public static boolean checkStartOpPreCondition(Context context, ArrayList<Operation> arrayList, String str) {
        if (!isAvailableDMA(context)) {
            return true;
        }
        if (str.length() > 100) {
            AppLog.m13144w("The maximum number of OperationName is limited by 100 characters.");
            return true;
        }
        if (arrayList.size() < 20) {
            return false;
        }
        AppLog.m13144w("The maximum number of Operation are limited by 20 operations");
        return true;
    }

    public static boolean checkStartSubOpPreCondition(ArrayList<Operation> arrayList, String str, String str2) {
        if (arrayList == null) {
            AppLog.m13144w("No Operation, you have to made Operation");
            return true;
        }
        if (str2.length() > 30) {
            AppLog.m13144w("The maximum number of subOperationName is limited by 30 characters.");
            return true;
        }
        Operation theOperation = aPerfUtil.getTheOperation(arrayList, str);
        if (theOperation == null) {
            AppLog.m13144w("It Couldn't find Operation that you made.");
            return true;
        }
        ArrayList<SubOperation> subOps = theOperation.getSubOps();
        if (subOps == null || subOps.size() < 10) {
            return false;
        }
        AppLog.m13144w("The maximum number of subOperation is limited by 10 subOperations.");
        return true;
    }

    public static boolean checkStopOpPreCondition(String str, ArrayList<Tag> arrayList) {
        if (TextUtils.isEmpty(str)) {
            AppLog.m13144w("Your operationId is empty.");
            return true;
        }
        if (arrayList == null || !isValidTags(arrayList)) {
            return false;
        }
        AppLog.m13144w("The Tags that you made aren't available.");
        return true;
    }

    public static boolean checkStopSubOpPreCondition(ArrayList<Operation> arrayList, String str) {
        if (arrayList == null) {
            AppLog.m13144w("No Operation, you have to made Operation");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        AppLog.m13144w("subOperation ID is empty.");
        return true;
    }

    private static boolean isAvailableDMA(Context context) {
        if (DiagMonUtil.checkDMA(context) == 2 && morePalette()) {
            return true;
        }
        AppLog.m13144w("It can't be supported on this device.");
        return false;
    }

    public static boolean isValidTags(ArrayList<Tag> arrayList) {
        if (arrayList.size() > 3) {
            AppLog.m13144w("The operation can't have tags over 3");
            return true;
        }
        for (Tag tag : arrayList) {
            if (tag.getKey().length() > 30) {
                AppLog.m13144w("The maximum of Key length is limited by 30 characters.");
                AppLog.m13144w("Key : " + tag.getKey());
                return true;
            }
            if (tag.getValue().length() > 30) {
                AppLog.m13144w("The maximum of Value length is limited by 30 characters.");
                AppLog.m13144w("Value : " + tag.getValue());
                return true;
            }
        }
        return false;
    }

    private static boolean morePalette() {
        return Build.VERSION.SEM_PLATFORM_INT >= SEP_VER_12_1;
    }
}
