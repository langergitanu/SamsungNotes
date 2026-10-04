package com.sec.android.diagmonagent.dma.aperf.utils;

import android.text.TextUtils;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.dma.aperf.Operation;
import com.sec.android.diagmonagent.dma.aperf.SubOperation;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class aPerfUtil {
    public static final String DUMMY_SUB_OP_ID = "00000000-0000-0000-0000-000000000000";
    public static final String DUMMY_SUB_OP_NAME = "dummy";
    public static final int NOT_COMPLETED_OPERATION = -1;
    public static final int NOT_USED_SUBOPERATION = -1;
    public static final String TAG = "DIAGMON_SDK[" + DiagMonUtil.getSdkVersion() + "]";
    private static final long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(1);

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    public static Operation getTheOperation(ArrayList<Operation> arrayList, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Operation operation : arrayList) {
            if (str.equals(operation.getOpId())) {
                return operation;
            }
        }
        AppLog.m13144w("Operation id not found.");
        return null;
    }

    public static SubOperation getTheSubOperation(ArrayList<SubOperation> arrayList, String str) {
        if (arrayList == null) {
            return null;
        }
        for (SubOperation subOperation : arrayList) {
            if (str.equals(subOperation.getSubOpId())) {
                return subOperation;
            }
        }
        return null;
    }

    public static String localToUTC(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date date = new Date(j);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void scalingOperation(ArrayList<Operation> arrayList) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Operation> it = arrayList.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getStartOpTimeMills() + EXPIRATION_TIME < jCurrentTimeMillis) {
                AppLog.m13140d("Expired operation: " + next.getOpName() + "(" + next.getOpId() + ")");
                it.remove();
            }
        }
    }

    public static Operation whoHasTheSubOpId(ArrayList<Operation> arrayList, String str) {
        for (Operation operation : arrayList) {
            ArrayList<SubOperation> subOps = operation.getSubOps();
            if (subOps != null) {
                Iterator<SubOperation> it = subOps.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getSubOpId())) {
                        return operation;
                    }
                }
            }
        }
        return null;
    }
}
