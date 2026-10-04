package com.microsoft.identity.common.java.flighting;

import lombok.NonNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EXPOSE_CCS_REQUEST_ID_IN_TOKENRESPONSE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class CommonFlight implements IFlightConfig {
    private static final /* synthetic */ CommonFlight[] $VALUES;
    public static final CommonFlight ACQUIRE_TOKEN_SILENT_TIMEOUT_MILLISECONDS;
    public static final CommonFlight ENABLE_PASSKEY_FEATURE;
    public static final CommonFlight EXPOSE_CCS_REQUEST_ID_IN_TOKENRESPONSE;
    public static final CommonFlight EXPOSE_CCS_REQUEST_SEQUENCE_IN_TOKENRESPONSE;
    public static final CommonFlight USE_NETWORK_CAPABILITY_FOR_NETWORK_CHECK;
    private Object defaultValue;
    private String key;

    static {
        CommonFlight commonFlight = new CommonFlight("USE_NETWORK_CAPABILITY_FOR_NETWORK_CHECK", 0, "UseNetworkCapabilityForNetworkCheck", Boolean.FALSE);
        USE_NETWORK_CAPABILITY_FOR_NETWORK_CHECK = commonFlight;
        Boolean bool = Boolean.TRUE;
        CommonFlight commonFlight2 = new CommonFlight("EXPOSE_CCS_REQUEST_ID_IN_TOKENRESPONSE", 1, "ExposeCcsRequestIdInTokenResponse", bool);
        EXPOSE_CCS_REQUEST_ID_IN_TOKENRESPONSE = commonFlight2;
        CommonFlight commonFlight3 = new CommonFlight("EXPOSE_CCS_REQUEST_SEQUENCE_IN_TOKENRESPONSE", 2, "ExposeCcsRequestSequenceInTokenResponse", bool);
        EXPOSE_CCS_REQUEST_SEQUENCE_IN_TOKENRESPONSE = commonFlight3;
        CommonFlight commonFlight4 = new CommonFlight("ACQUIRE_TOKEN_SILENT_TIMEOUT_MILLISECONDS", 3, "AcquireTokenSilentTimeoutMilliSeconds", 30000);
        ACQUIRE_TOKEN_SILENT_TIMEOUT_MILLISECONDS = commonFlight4;
        CommonFlight commonFlight5 = new CommonFlight("ENABLE_PASSKEY_FEATURE", 4, "EnablePasskeyFeature", bool);
        ENABLE_PASSKEY_FEATURE = commonFlight5;
        $VALUES = new CommonFlight[]{commonFlight, commonFlight2, commonFlight3, commonFlight4, commonFlight5};
    }

    private CommonFlight(@NonNull String str, @NonNull int i, String str2, Object obj) {
        if (str2 == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (obj == null) {
            throw new NullPointerException("defaultValue is marked non-null but is null");
        }
        this.key = str2;
        this.defaultValue = obj;
    }

    public static CommonFlight valueOf(String str) {
        return (CommonFlight) Enum.valueOf(CommonFlight.class, str);
    }

    public static CommonFlight[] values() {
        return (CommonFlight[]) $VALUES.clone();
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightConfig
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightConfig
    public String getKey() {
        return this.key;
    }
}
