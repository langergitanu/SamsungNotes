package com.samsung.scsp.odm.dos.resource;

import android.util.Pair;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.samsung.scsp.framework.core.ScspException;
import com.samsung.scsp.framework.core.api.AbstractApi;
import com.samsung.scsp.framework.core.api.AbstractApiControl;
import com.samsung.scsp.framework.core.api.ApiClass;
import com.samsung.scsp.framework.core.api.ApiSpec;
import com.samsung.scsp.framework.core.api.Get;
import com.samsung.scsp.framework.core.api.Post;
import com.samsung.scsp.framework.core.api.Requests;
import com.samsung.scsp.framework.core.decorator.SdkConfig;
import com.samsung.scsp.framework.core.decorator.SdkFeature;
import com.samsung.scsp.odm.dos.BuildConfig;
import com.samsung.scsp.odm.dos.common.OdmDosApiContract;
import com.samsung.scsp.odm.dos.common.OdmDosDecorator;
import com.samsung.scsp.odm.dos.common.OdmDosDownloadFileJobImpl;
import com.samsung.scsp.odm.dos.common.OdmDosTargetHeader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@SdkConfig(accountRequired = false, domain = SdkConfig.Domain.odm, drsSupported = true, name = BuildConfig.LIBRARY_PACKAGE_NAME, version = "1.2.0000")
public class ScspResource extends OdmDosDecorator {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ApiClass(ResourceApiImpl.class)
    @Requests({ResourceApiSpec.GET_RESOURCE, ResourceApiSpec.GET_TARGET_DEVICE_RESOURCE, "DOWNLOAD_FILE", ResourceApiSpec.SEARCH})
    public static class ResourceApiControlImpl extends AbstractApiControl {
        private ResourceApiControlImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ApiSpec(ResourceApiSpec.class)
    public static class ResourceApiImpl extends AbstractApi {
        public ResourceApiImpl() {
            attachHeaderFunction(ResourceApiSpec.GET_TARGET_DEVICE_RESOURCE, OdmDosTargetHeader.targetHeaderFunction);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResourceApiSpec {
        public static final String API_BASE = "/resource/v1/resource-lists/{contentKey}";

        @Get(jobImpl = OdmDosDownloadFileJobImpl.class, value = "")
        public static final String DOWNLOAD_FILE = "DOWNLOAD_FILE";

        @Get(response = ResourceInfo.class, value = API_BASE)
        public static final String GET_RESOURCE = "GET_RESOURCE";

        @Get(response = ResourceInfo.class, value = API_BASE)
        public static final String GET_TARGET_DEVICE_RESOURCE = "GET_TARGET_DEVICE_RESOURCE";

        @Post(response = ResourceInfo.class, value = "/resource/v1/resource-lists/{contentKey}/search")
        public static final String SEARCH = "SEARCH";
    }

    public ScspResource() {
        super(ResourceApiControlImpl.class, new SdkFeature[0]);
    }

    private void throwIfEmpty(Map<String, List<String>> map, String str) throws ScspException {
        if (map.isEmpty()) {
            throw new ScspException(ScspException.Code.BAD_IMPLEMENTATION, str);
        }
    }

    private JsonArray toJsonArray(Map<String, List<String>> map) {
        JsonArray jsonArray = new JsonArray();
        for (String str : map.keySet()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("key", str);
            List<String> list = map.get(str);
            JsonArray jsonArray2 = new JsonArray();
            if (list != null && !list.isEmpty()) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    jsonArray2.add(it.next());
                }
            }
            jsonObject.add("values", jsonArray2);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public boolean download(String str, String str2) {
        return downloadInternal("DOWNLOAD_FILE", str, str2, null);
    }

    public ResourceInfo list(String str, String str2) {
        return (ResourceInfo) listInternal(ResourceApiSpec.GET_RESOURCE, str, str2, null);
    }

    public ResourceInfo listForTargetDevice(String str, String str2, OdmDosTargetHeader odmDosTargetHeader) {
        return (ResourceInfo) listForTargetDeviceInternal(ResourceApiSpec.GET_TARGET_DEVICE_RESOURCE, str, str2, odmDosTargetHeader, null);
    }

    public ResourceInfo search(String str, Map<String, List<String>> map) throws ScspException {
        throwIfEmpty(map, "tag is null or empty.");
        ScspException.throwIfEmpty(str, "contentKey is null or empty.");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(OdmDosApiContract.Parameter.TAG_FILTERS, toJsonArray(map));
        return (ResourceInfo) execute(ResourceApiSpec.SEARCH, jsonObject, null, new Pair(OdmDosApiContract.Parameter.CONTENT_KEY, str));
    }
}
