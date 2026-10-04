package com.samsung.android.sdk.smp.common.exception;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IErrors {
    public static final String ERROR_CODE_SMP_0001 = "SMP_0001";
    public static final String ERROR_CODE_SMP_0002 = "SMP_0002";
    public static final String ERROR_CODE_SMP_0003 = "SMP_0003";
    public static final String ERROR_CODE_SMP_0102 = "SMP_0102";
    public static final String ERROR_CODE_SMP_0103 = "SMP_0103";
    public static final String ERROR_CODE_SMP_0201 = "SMP_0201";
    public static final String ERROR_CODE_SMP_0202 = "SMP_0202";
    public static final String ERROR_CODE_SMP_0203 = "SMP_0203";
    public static final String ERROR_CODE_SMP_0204 = "SMP_0204";
    public static final String ERROR_CODE_SMP_0301 = "SMP_0301";
    public static final String ERROR_CODE_SMP_0401 = "SMP_0401";
    public static final String ERROR_CODE_SMP_0501 = "SMP_0501";
    public static final String ERROR_CODE_SMP_0502 = "SMP_0502";
    public static final String ERROR_CODE_SMP_0601 = "SMP_0601";
    public static final String ERROR_CODE_SMP_5001 = "SMP_5001";
    public static final String ERROR_CODE_SMP_5002 = "SMP_5002";
    public static final String ERROR_CODE_SMP_5003 = "SMP_5003";
    public static final String ERROR_CODE_SMP_5004 = "SMP_5004";
    public static final String ERROR_MESSAGE_SMP_0002 = "Google play service is missing on this device";
    public static final String ERROR_MESSAGE_SMP_0003 = "FCM error. FCM token is empty";
    public static final String ERROR_MESSAGE_SMP_0102 = "Fail to create smp id. Device Id is not available";
    public static final String ERROR_MESSAGE_SMP_0103 = "Fail to init. device and sim country code are empty";
    public static final String ERROR_MESSAGE_SMP_0201 = "Appid is not set. Should request after Smp.init is called";
    public static final String ERROR_MESSAGE_SMP_0202 = "Guid is not set. Should request after Smp.setGuid is called";
    public static final String ERROR_MESSAGE_SMP_0203 = "Network on main thread error. Should request in worker thread";
    public static final String ERROR_MESSAGE_SMP_0204 = "The device does not support opt-in/out";
    public static final String ERROR_MESSAGE_SMP_0301 = "Network is not available";
    public static final String ERROR_MESSAGE_SMP_0401 = "Internal error";
    public static final String ERROR_MESSAGE_SMP_0501 = "Internal server error";
    public static final String ERROR_MESSAGE_SMP_0502 = "Invalid server response";
    public static final String ERROR_MESSAGE_SMP_0601 = "Provider restriction error";
    public static final String ERROR_MESSAGE_SMP_5001 = "Spp AppId is not set. Should set SmpInitOptions.Option.SPP_APPID";
    public static final String ERROR_MESSAGE_SMP_5002 = "SPP is not installed";
    public static final String ERROR_MESSAGE_SMP_5003 = "SPP error. SPP Token is empty";
    public static final String ERROR_MESSAGE_SMP_5004 = "Error while starting SPP";
}
