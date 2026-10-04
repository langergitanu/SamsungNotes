package com.samsung.scsp.odm.dos.configuration;

import android.util.Pair;
import com.google.gson.JsonObject;
import com.samsung.scsp.common.Invoker;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.AbstractApi;
import com.samsung.scsp.framework.core.api.AbstractApiControl;
import com.samsung.scsp.framework.core.api.ApiClass;
import com.samsung.scsp.framework.core.api.ApiSpec;
import com.samsung.scsp.framework.core.api.Get;
import com.samsung.scsp.framework.core.api.Post;
import com.samsung.scsp.framework.core.api.Property;
import com.samsung.scsp.framework.core.api.Requests;
import com.samsung.scsp.framework.core.decorator.SdkConfig;
import com.samsung.scsp.framework.core.decorator.SdkFeature;
import com.samsung.scsp.odm.dos.BuildConfig;
import com.samsung.scsp.odm.dos.common.OdmDosApiContract;
import com.samsung.scsp.odm.dos.common.OdmDosDecorator;
import com.samsung.scsp.odm.dos.common.OdmDosDownloadFileJobImpl;
import com.samsung.scsp.odm.dos.common.OdmDosTargetHeader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@SdkConfig(accountRequired = false, domain = SdkConfig.Domain.odm, drsSupported = true, name = BuildConfig.LIBRARY_PACKAGE_NAME, version = "1.2.0000")
public class ScpmConfiguration extends OdmDosDecorator {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ApiClass(ConfigurationApiImpl.class)
    @Requests({ConfigurationApiSpec.GET_CHANGES, ConfigurationApiSpec.GET_CHANGES_OF_TARGET_DEVICE, "DOWNLOAD_FILE"})
    public static class ConfigurationApiControlImpl extends AbstractApiControl {
        private ConfigurationApiControlImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ApiSpec(ConfigurationApiSpec.class)
    public static class ConfigurationApiImpl extends AbstractApi {
        public ConfigurationApiImpl() {
            attachHeaderFunction(ConfigurationApiSpec.GET_CHANGES_OF_TARGET_DEVICE, OdmDosTargetHeader.targetHeaderFunction);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ConfigurationApiSpec {
        public static final String API_BASE = "/configuration/v2";

        @Get(jobImpl = OdmDosDownloadFileJobImpl.class, value = "")
        public static final String DOWNLOAD_FILE = "DOWNLOAD_FILE";
        public static final String FETCH_CHANGES = "/configuration/v2/agent/apps/configurations/fetch-changes";

        @Post(properties = {Property.Localed}, response = ConfigurationInfo.class, value = FETCH_CHANGES)
        public static final String GET_CHANGES = "GET_CHANGES";

        @Post(properties = {Property.Localed}, response = ConfigurationInfo.class, value = FETCH_CHANGES)
        public static final String GET_CHANGES_OF_TARGET_DEVICE = "GET_CHANGES_OF_TARGET_DEVICE";
    }

    public ScpmConfiguration() {
        super(ConfigurationApiControlImpl.class, new SdkFeature[0]);
    }

    public boolean download(String str, String str2, Invoker invoker) {
        return downloadInternal("DOWNLOAD_FILE", str, str2, invoker);
    }

    public ConfigurationInfo list(JsonObject jsonObject, Invoker invoker) {
        return (ConfigurationInfo) execute(ConfigurationApiSpec.GET_CHANGES, jsonObject, null, invoker, new Pair[0]);
    }

    public ConfigurationInfo listForTargetDevice(JsonObject jsonObject, OdmDosTargetHeader odmDosTargetHeader, Invoker invoker) throws ScspException {
        OdmDosTargetHeader.verify(odmDosTargetHeader);
        return (ConfigurationInfo) execute(ConfigurationApiSpec.GET_CHANGES_OF_TARGET_DEVICE, jsonObject, null, invoker, new Pair(OdmDosApiContract.Parameter.TARGET_DEVICE, odmDosTargetHeader));
    }
}
