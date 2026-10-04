package com.samsung.scsp.odm.dos.common;

import android.util.Pair;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.odm.dos.common.OdmDosApiContract;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OdmDosTargetHeader {
    public static Function<ApiContext, Pair<String, String>[]> targetHeaderFunction = new C11419a(4);
    public final String appId;
    public final String appVersion;
    public final String countryCode;
    public final String csc;
    public final String deviceType;
    public final String modelCode;
    public final String modelName;
    public final String osType;
    public final String osVersion;
    public final String platformVersion;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        private final String appId;
        private final String appVersion;
        private String countryCode;
        private String csc;
        private String deviceType;
        private String modelCode;
        private String modelName;
        private String osType;
        private String osVersion;
        private String platformVersion;

        public Builder(String str, String str2) {
            this.appId = str;
            this.appVersion = str2;
        }

        public OdmDosTargetHeader build() {
            return new OdmDosTargetHeader(this);
        }

        public Builder countryCode(String str) {
            this.countryCode = str;
            return this;
        }

        public Builder csc(String str) {
            this.csc = str;
            return this;
        }

        public Builder deviceType(String str) {
            this.deviceType = str;
            return this;
        }

        public Builder modelCode(String str) {
            this.modelCode = str;
            return this;
        }

        public Builder modelName(String str) {
            this.modelName = str;
            return this;
        }

        public Builder osType(String str) {
            this.osType = str;
            return this;
        }

        public Builder osVersion(String str) {
            this.osVersion = str;
            return this;
        }

        public Builder platformVersion(String str) {
            this.platformVersion = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Header {
        public static final String X_SC_TARGET_APP_ID = "x-sc-target-app-id";
        public static final String X_SC_TARGET_APP_VERSION = "x-sc-target-app-version";
        public static final String X_SC_TARGET_DEVICE_CC = "x-sc-target-device-cc";
        public static final String X_SC_TARGET_DEVICE_CSC = "x-sc-target-device-csc";
        public static final String X_SC_TARGET_DEVICE_MODEL = "x-sc-target-device-model";
        public static final String X_SC_TARGET_DEVICE_MODEL_CODE = "x-sc-target-device-model-code";
        public static final String X_SC_TARGET_DEVICE_PLATFORM_VERSION = "x-sc-target-device-platform-version";
        public static final String X_SC_TARGET_DEVICE_TYPE = "x-sc-target-device-type";
        public static final String X_SC_TARGET_OS_TYPE = "x-sc-target-os-type";
        public static final String X_SC_TARGET_OS_VERSION = "x-sc-target-os-version";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair[] lambda$static$0(ApiContext apiContext) {
        OdmDosTargetHeader odmDosTargetHeader = (OdmDosTargetHeader) apiContext.parameters.get(OdmDosApiContract.Parameter.TARGET_DEVICE);
        return new Pair[]{new Pair(Header.X_SC_TARGET_DEVICE_TYPE, odmDosTargetHeader.deviceType), new Pair(Header.X_SC_TARGET_DEVICE_MODEL, odmDosTargetHeader.modelName), new Pair(Header.X_SC_TARGET_DEVICE_MODEL_CODE, odmDosTargetHeader.modelCode), new Pair(Header.X_SC_TARGET_DEVICE_PLATFORM_VERSION, odmDosTargetHeader.platformVersion), new Pair(Header.X_SC_TARGET_DEVICE_CC, odmDosTargetHeader.countryCode), new Pair(Header.X_SC_TARGET_DEVICE_CSC, odmDosTargetHeader.csc), new Pair(Header.X_SC_TARGET_OS_TYPE, odmDosTargetHeader.osType), new Pair(Header.X_SC_TARGET_OS_VERSION, odmDosTargetHeader.osVersion), new Pair(Header.X_SC_TARGET_APP_ID, odmDosTargetHeader.appId), new Pair(Header.X_SC_TARGET_APP_VERSION, odmDosTargetHeader.appVersion)};
    }

    public static void verify(OdmDosTargetHeader odmDosTargetHeader) throws ScspException {
        ScspException.throwIfNull(odmDosTargetHeader, "requester to be patched is null.");
        ScspException.throwIfEmpty(odmDosTargetHeader.deviceType, "deviceType is null or empty.");
        ScspException.throwIfEmpty(odmDosTargetHeader.modelName, "modelName is null or empty.");
        ScspException.throwIfEmpty(odmDosTargetHeader.modelCode, "modelCode is null or empty.");
        ScspException.throwIfEmpty(odmDosTargetHeader.platformVersion, "platformVersion is null or empty.");
        ScspException.throwIfEmpty(odmDosTargetHeader.countryCode, "countryCode is null or empty.");
        ScspException.throwIfEmpty(odmDosTargetHeader.csc, "csc is null or empty.");
        ScspException.throwIfEmpty(odmDosTargetHeader.osType, "osType is null or empty.");
        ScspException.throwIfEmpty(odmDosTargetHeader.osVersion, "osVersion is null or empty.");
    }

    private OdmDosTargetHeader(Builder builder) {
        this.appId = builder.appId;
        this.appVersion = builder.appVersion;
        this.deviceType = builder.deviceType;
        this.modelName = builder.modelName;
        this.modelCode = builder.modelCode;
        this.platformVersion = builder.platformVersion;
        this.countryCode = builder.countryCode;
        this.csc = builder.csc;
        this.osType = builder.osType;
        this.osVersion = builder.osVersion;
    }
}
