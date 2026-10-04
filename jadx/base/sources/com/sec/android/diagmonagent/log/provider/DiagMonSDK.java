package com.sec.android.diagmonagent.log.provider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.sec.android.diagmonagent.common.logger.AppLog;
import com.sec.android.diagmonagent.common.util.CommonUtils;
import com.sec.android.diagmonagent.common.util.executor.SingleThreadExecutor;
import com.sec.android.diagmonagent.dma.aperf.Operation;
import com.sec.android.diagmonagent.dma.aperf.SubOperation;
import com.sec.android.diagmonagent.dma.aperf.Tag;
import com.sec.android.diagmonagent.dma.aperf.utils.aPerfUtil;
import com.sec.android.diagmonagent.dma.aperf.utils.aPerfValidation;
import com.sec.android.diagmonagent.log.provider.threadExecutor.ANRExecutor;
import com.sec.android.diagmonagent.log.provider.threadExecutor.AppPerfReportExecutor;
import com.sec.android.diagmonagent.log.provider.threadExecutor.EventReportExecutor;
import com.sec.android.diagmonagent.log.provider.threadExecutor.ServiceRegistrationExecutor;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DiagMonSDK {
    private static final String DMA_PKG_NAME = "com.sec.android.diagmonagent";
    private static final int MIN_SDK = 24;
    public static final String NETWORK_ANY = "network_any";
    private static final int NO_TAGS = 0;
    private static boolean isEnableUncaughtExceptionLogging;
    private static DiagMonConfig mConfig;
    private static Thread.UncaughtExceptionHandler originUncaughtExceptionHandler;
    private static Bundle srObj;
    private static CONFIGURATION_TYPE configurationType = CONFIGURATION_TYPE.NONE;
    private static ArrayList<Operation> ops = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CONFIGURATION_TYPE {
        NONE,
        DEFAULT,
        CUSTOM
    }

    public static boolean customEventReport(Context context, EventBuilder eventBuilder) {
        String str = DiagMonUtil.TAG;
        Log.i(str, "Request CustomEventReport");
        DiagMonConfig diagMonConfig = mConfig;
        if (diagMonConfig == null) {
            Log.w(str, "You first have to create DiagMonConfiguration");
            Log.w(str, "CustomEventReport is aborted");
            return false;
        }
        AppLog.initLogger(diagMonConfig.getContext(), mConfig.getServiceId());
        if (getConfigurationType() == CONFIGURATION_TYPE.DEFAULT) {
            AppLog.m13144w("You can't use customEventReport with enableDefaultConfiguration");
            return false;
        }
        sendEventReport(eventBuilder);
        return true;
    }

    public static void disableANRLogging() {
        if (mConfig == null) {
            Log.w(DiagMonUtil.TAG, "ANR Logging can't be disabled because Configuration is null");
        } else if (DiagMonUtil.underPalette()) {
            Log.w(DiagMonUtil.TAG, "This API isn't supported on this device");
        } else {
            AppLog.initLogger(mConfig.getContext(), mConfig.getServiceId());
            SingleThreadExecutor.getInstance().execute(new ANRExecutor(mConfig.getContext(), mConfig.getServiceId(), false));
        }
    }

    public static void disableUncaughtExceptionLogging() {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = originUncaughtExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                isEnableUncaughtExceptionLogging = false;
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
        } catch (NullPointerException e) {
            AppLog.m13141e(e.getMessage());
        } catch (Exception e2) {
            AppLog.m13141e(e2.getMessage());
        }
    }

    public static void enableANRLogging() {
        if (mConfig == null) {
            Log.w(DiagMonUtil.TAG, "ANR Logging can't be enabled because Configuration is null");
        } else if (DiagMonUtil.underPalette()) {
            Log.w(DiagMonUtil.TAG, "This API isn't supported on this device");
        } else {
            AppLog.initLogger(mConfig.getContext(), mConfig.getServiceId());
            SingleThreadExecutor.getInstance().execute(new ANRExecutor(mConfig.getContext(), mConfig.getServiceId(), true));
        }
    }

    public static void enableUncaughtExceptionLogging(Context context) {
        try {
            DiagMonConfig diagMonConfig = mConfig;
            if (diagMonConfig == null) {
                Log.w(DiagMonUtil.TAG, "UncaughtExceptionLogging can't be enabled because Configuration is null");
                return;
            }
            AppLog.initLogger(diagMonConfig.getContext(), mConfig.getServiceId());
            if (getConfigurationType() == CONFIGURATION_TYPE.NONE) {
                AppLog.m13144w("You first have to call configuration method");
                return;
            }
            if (isEnableUncaughtExceptionLogging) {
                AppLog.m13144w("UncaughtExceptionLogging is already enabled");
                return;
            }
            isEnableUncaughtExceptionLogging = true;
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            originUncaughtExceptionHandler = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(new DiagMonLogger(context, defaultUncaughtExceptionHandler, mConfig));
        } catch (Exception e) {
            AppLog.m13141e("failed to enableUncaughtExceptionLogging" + e);
        }
    }

    private static Operation generateNewOperation(String str) {
        return new Operation(str);
    }

    private static SubOperation generateNewSubOperation(String str, String str2, String str3) {
        return new SubOperation(str, str2, str3);
    }

    private static CONFIGURATION_TYPE getConfigurationType() {
        return configurationType;
    }

    private static int getDMAVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.sec.android.diagmonagent", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            AppLog.m13141e("DMA Client is not exist");
            return 0;
        }
    }

    public static String getDeviceId(Context context, String str) {
        DiagMonConfig diagMonConfig = mConfig;
        if (diagMonConfig == null) {
            return "";
        }
        AppLog.initLogger(diagMonConfig.getContext(), mConfig.getServiceId());
        try {
            if (DiagMonUtil.checkDMA(context) != 2) {
                AppLog.m13144w("It is not supported because DiagMonAgent is an old version");
                return "";
            }
            Bundle bundle = new Bundle();
            bundle.putString("serviceId", str);
            Bundle bundleCall = context.getContentResolver().call(DiagMonUtil.URI, "request_deviceid", "request_deviceid", bundle);
            if (bundleCall.getString("result") == null) {
                AppLog.m13142i("Can't find deviceId from DMA");
                return "";
            }
            DiagMonUtil.printResultfromDMA(bundleCall);
            return bundleCall.getString("result");
        } catch (Exception e) {
            AppLog.m13141e(e.getMessage());
            return "";
        }
    }

    private static Bundle makeSRObj(DiagMonConfig diagMonConfig) {
        Bundle bundle = new Bundle();
        bundle.putString("serviceId", diagMonConfig.getServiceId());
        bundle.putString("serviceVersion", CommonUtils.getPackageVersion(diagMonConfig.getContext()));
        bundle.putString(BundleContract.SERVICE_AGREE, diagMonConfig.getAgreeAsString());
        bundle.putString("deviceId", diagMonConfig.getDeviceId());
        bundle.putString(BundleContract.TRACKING_ID, diagMonConfig.getTrackingId());
        bundle.putString("sdkVersion", DiagMonUtil.getSdkVersion());
        bundle.putString(BundleContract.SDK_TYPE, "S");
        bundle.putString(BundleContract.PKG_NAME, diagMonConfig.getContext().getPackageName());
        bundle.putBoolean(BundleContract.NETWORK_MODE, diagMonConfig.getServiceNetworkMode());
        AppLog.m13142i("generated SR object");
        return bundle;
    }

    private static void registerService() {
        try {
            synchronized (DiagMonSDK.class) {
                srObj = makeSRObj(mConfig);
                SingleThreadExecutor.getInstance().execute(new ServiceRegistrationExecutor(mConfig, srObj));
            }
        } catch (Exception e) {
            AppLog.m13141e("failed to setConfiguration" + e);
        }
    }

    public static void sendCustomAgreementWithdrawal(Context context, String str) {
        DiagMonConfig diagMonConfig = mConfig;
        if (diagMonConfig == null) {
            Log.w(DiagMonUtil.TAG, "Congifuration shouldn't be null to send withdrawal");
            return;
        }
        AppLog.initLogger(diagMonConfig.getContext(), mConfig.getServiceId());
        try {
            if (DiagMonUtil.checkDMA(context) != 2) {
                AppLog.m13144w("It is not supported because DiagMonAgent is an old version");
                return;
            }
            Log.i(DiagMonUtil.TAG, "Request agreement withdrawal to DiagmonAgent");
            Intent intent = new Intent();
            intent.setAction(DiagMonUtil.ACTION_CUSTOM_AGREEMENT_WITHDRAWAL);
            intent.setPackage("com.sec.android.diagmonagent");
            intent.putExtra("serviceId", str);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            AppLog.m13141e(e.getMessage());
        }
    }

    private static void sendEventReport(EventBuilder eventBuilder) {
        SingleThreadExecutor.getInstance().execute(new EventReportExecutor(mConfig, srObj, eventBuilder));
    }

    public static void sendUncaughtExceptionEvent(EventBuilder eventBuilder) {
        registerService();
        sendEventReport(eventBuilder);
    }

    public static void setConfiguration(DiagMonConfig diagMonConfig) {
        if (diagMonConfig == null) {
            Log.w(DiagMonUtil.TAG, "DiagMonConfiguration is null");
            return;
        }
        if (getDMAVersion(diagMonConfig.getContext()) == 0) {
            Log.w(DiagMonUtil.TAG, "It is not supported : NO_DMA");
            return;
        }
        AppLog.initLogger(diagMonConfig.getContext(), diagMonConfig.getServiceId());
        if (getConfigurationType() == CONFIGURATION_TYPE.DEFAULT) {
            AppLog.m13144w("You can't use setConfiguration with enableDefaultConfiguration");
            return;
        }
        mConfig = diagMonConfig;
        setConfigurationType(CONFIGURATION_TYPE.CUSTOM);
        registerService();
    }

    private static void setConfigurationType(CONFIGURATION_TYPE configuration_type) {
        configurationType = configuration_type;
        AppLog.m13140d("setConfiguration type : " + configurationType);
    }

    public static void setDefaultConfiguration(Context context, String str) {
        AppLog.initLogger(context, str);
        if (getConfigurationType() == CONFIGURATION_TYPE.CUSTOM) {
            AppLog.m13144w("setDefaultConfiguration can't be used because CustomLogging is using");
            return;
        }
        if (mConfig != null) {
            AppLog.m13144w("setDefaultConfiguration is already set");
        } else {
            if (getDMAVersion(context) == 0) {
                Log.w(DiagMonUtil.TAG, "It is not supported : NO_DMA");
                return;
            }
            mConfig = new DiagMonConfig(context).setServiceId(str).setAgree(DiagMonUtil.AGREE_TYPE_DIAGNOSTIC);
            setConfigurationType(CONFIGURATION_TYPE.DEFAULT);
            registerService();
        }
    }

    public static synchronized String startOperation(String str) {
        if (mConfig == null) {
            AppLog.m13144w("You can't use this API because you don't have any Configuration");
            return "";
        }
        ArrayList<Operation> arrayList = ops;
        if (arrayList == null) {
            ops = new ArrayList<>();
        } else {
            aPerfUtil.scalingOperation(arrayList);
        }
        if (aPerfValidation.checkStartOpPreCondition(mConfig.getContext(), ops, str)) {
            AppLog.m13144w("Not ready to generate Operation");
            return "";
        }
        Operation operationGenerateNewOperation = generateNewOperation(str);
        ops.add(operationGenerateNewOperation);
        AppLog.m13140d("Start operation: " + operationGenerateNewOperation.getOpName() + "(" + operationGenerateNewOperation.getOpId() + ")");
        return operationGenerateNewOperation.getOpId();
    }

    public static synchronized String startSubOperation(String str, String str2) {
        if (aPerfValidation.checkStartSubOpPreCondition(ops, str, str2)) {
            return "";
        }
        SubOperation subOperationGenerateNewSubOperation = generateNewSubOperation(str, str2, aPerfUtil.generateUUID());
        Operation theOperation = aPerfUtil.getTheOperation(ops, str);
        if (theOperation == null) {
            AppLog.m13144w("It Couldn't find operation that you made.");
            return "";
        }
        theOperation.addSubOperation(subOperationGenerateNewSubOperation);
        AppLog.m13140d("Start subOperation: " + subOperationGenerateNewSubOperation.getSubOpName() + "(" + subOperationGenerateNewSubOperation.getSubOpId() + ") / operation: " + theOperation.getOpName() + "(" + theOperation.getOpId() + ")");
        return subOperationGenerateNewSubOperation.getSubOpId();
    }

    public static synchronized boolean stopOperation(String str) {
        return stopOperation(str, 0L, 0L, new Tag[0]);
    }

    public static synchronized boolean stopSubOperation(String str) {
        return stopSubOperation(str, 0L, 0L);
    }

    public boolean isEnableUncaughtExceptionLogging() {
        return isEnableUncaughtExceptionLogging;
    }

    public static synchronized boolean stopOperation(String str, long j, long j2, Tag... tagArr) {
        AppLog.m13140d("Try stop operation: " + str);
        if (mConfig == null) {
            AppLog.m13144w("You can't use this API because you don't have any Configuration");
            return false;
        }
        ArrayList<Operation> arrayList = ops;
        if (arrayList == null) {
            AppLog.m13144w("It doesn't have any operations, please check it again.");
        } else {
            aPerfUtil.scalingOperation(arrayList);
        }
        ArrayList<Tag> arrayList2 = tagArr.length > 0 ? new ArrayList<>(Arrays.asList(tagArr)) : null;
        if (aPerfValidation.checkStopOpPreCondition(str, arrayList2)) {
            AppLog.m13144w("It's not able to use stopOperation API.");
            return false;
        }
        Operation theOperation = aPerfUtil.getTheOperation(ops, str);
        if (theOperation == null) {
            AppLog.m13144w("It Couldn't find operation that you made.");
            return false;
        }
        if (theOperation.getOpDataSize() == 0) {
            theOperation.setOpDataSize(j);
        }
        if (theOperation.getOpItemCount() == 0) {
            theOperation.setOpItemCount(j2);
        }
        theOperation.calculateStopOpTime();
        if (theOperation.getSubOps() != null) {
            if (theOperation.getSubOps().size() > 0) {
                AppLog.m13144w("There are unfinished sub operations. Remove the operation.");
                ops.remove(theOperation);
                return false;
            }
            SubOperation subOperation = new SubOperation(str, aPerfUtil.DUMMY_SUB_OP_NAME, aPerfUtil.DUMMY_SUB_OP_ID);
            subOperation.setSubOpCountSize(theOperation.getOpItemCount(), theOperation.getOpDataSize());
            subOperation.setSubOpElapsedTime(theOperation.getSubOpTotalElapsedTime());
            ArrayList<SubOperation> arrayList3 = new ArrayList<>();
            arrayList3.add(subOperation);
            theOperation.setSubOps(arrayList3);
        }
        AppLog.m13140d("Stop operation: " + theOperation.getOpName() + "(" + theOperation.getOpId() + ")");
        if (arrayList2 != null) {
            theOperation.addTags(arrayList2);
        }
        ops.remove(theOperation);
        SingleThreadExecutor.getInstance().execute(new AppPerfReportExecutor(mConfig, theOperation));
        return true;
    }

    public static synchronized boolean stopSubOperation(String str, long j, long j2) {
        AppLog.m13140d("Try stop subOperation: " + str);
        if (aPerfValidation.checkStopSubOpPreCondition(ops, str)) {
            return false;
        }
        Operation operationWhoHasTheSubOpId = aPerfUtil.whoHasTheSubOpId(ops, str);
        if (operationWhoHasTheSubOpId == null) {
            AppLog.m13144w("It couldn't find The operation that has subOperation ID.");
            return false;
        }
        SubOperation theSubOperation = aPerfUtil.getTheSubOperation(operationWhoHasTheSubOpId.getSubOps(), str);
        if (theSubOperation == null) {
            AppLog.m13144w("It Couldn't find subOperation that you made.");
            return false;
        }
        theSubOperation.setSubOpCountSize(j2, j);
        theSubOperation.calculateOpElapsedTime();
        AppLog.m13140d("Stop subOperation: " + theSubOperation.getSubOpName() + "(" + theSubOperation.getSubOpId() + ")");
        operationWhoHasTheSubOpId.setOpItemCount(operationWhoHasTheSubOpId.getOpItemCount() + theSubOperation.getSubOpItemCount());
        operationWhoHasTheSubOpId.setOpDataSize(operationWhoHasTheSubOpId.getOpDataSize() + theSubOperation.getSubOpDataSize());
        operationWhoHasTheSubOpId.setSubOpTotalElapsedTime(operationWhoHasTheSubOpId.getSubOpTotalElapsedTime() + theSubOperation.getSubOpElapsedTime());
        operationWhoHasTheSubOpId.setSubOpTotalCount(operationWhoHasTheSubOpId.getSubOpTotalCount() + 1);
        operationWhoHasTheSubOpId.getSubOps().remove(theSubOperation);
        return true;
    }
}
