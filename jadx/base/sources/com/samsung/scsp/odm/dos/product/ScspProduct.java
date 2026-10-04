package com.samsung.scsp.odm.dos.product;

import android.util.Pair;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.C11253j;
import com.samsung.scsp.common.ContextFactory;
import com.samsung.scsp.common.Invoker;
import com.samsung.scsp.error.FaultBarrier;
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
import com.samsung.scsp.framework.core.util.StringUtil;
import com.samsung.scsp.odm.dos.BuildConfig;
import com.samsung.scsp.odm.dos.common.OdmDosDecorator;
import com.samsung.scsp.odm.dos.common.OdmDosDownloadFileJobImpl;
import com.samsung.scsp.odm.dos.product.ProductInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@SdkConfig(accountRequired = false, domain = SdkConfig.Domain.odm, name = BuildConfig.LIBRARY_PACKAGE_NAME, version = "1.2.0000")
public class ScspProduct extends OdmDosDecorator {
    private static final String COLOR = "color";
    private static final String MODEL_CODES = "modelCodes";
    private static final String MODEL_NAME = "modelName";
    private static final String MODEL_NAMES = "modelNames";
    private static final String MODEL_NAMES_AND_COLORS = "modelNamesAndColors";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ApiClass(ProductApiImpl.class)
    @Requests({ProductApiSpec.GET_PRODUCT, ProductApiSpec.GET_PRODUCT_V2, ProductApiSpec.GET_PRODUCT_V2_WITH_COLOR, ProductApiSpec.DOWNLOAD_PRODUCT_FILE})
    public static class ProductApiControlImpl extends AbstractApiControl {
        private ProductApiControlImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @ApiSpec(ProductApiSpec.class)
    public static class ProductApiImpl extends AbstractApi {
        private ProductApiImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProductApiSpec {
        public static final String API_BASE = "/pki/v1";
        public static final String API_V2_BASE = "/pki/v2";

        @Get(jobImpl = OdmDosDownloadFileJobImpl.class, value = "")
        public static final String DOWNLOAD_PRODUCT_FILE = "DOWNLOAD_PRODUCT_FILE";

        @Post(response = ProductInfo.class, value = "/pki/v1/products/fetch")
        public static final String GET_PRODUCT = "GET_PRODUCT";

        @Post(response = ProductInfoV2.class, value = "/pki/v2/products/fetch")
        public static final String GET_PRODUCT_V2 = "GET_PRODUCT_V2";

        @Post(response = ProductInfoV2WithColor.class, value = "/pki/v2/products/fetch-by-model-names-and-colors")
        public static final String GET_PRODUCT_V2_WITH_COLOR = "GET_PRODUCT_V2_WITH_COLOR";
    }

    public ScspProduct() {
        super(ProductApiControlImpl.class, new SdkFeature[0]);
    }

    public boolean download(ProductInfo.Item item, String str, Invoker invoker) throws ScspException {
        boolean zDownloadInternal = downloadInternal(ProductApiSpec.DOWNLOAD_PRODUCT_FILE, item.file.downloadApi, str, invoker);
        File file = new File(str);
        if (zDownloadInternal && file.length() == item.file.size) {
            return true;
        }
        FaultBarrier.run(new C11253j(file, 12));
        return false;
    }

    public File downloadImage(String str, int i, Invoker invoker) {
        File file = new File(ContextFactory.getApplicationContext().getFilesDir() + "/product/");
        if (!file.exists()) {
            file.mkdirs();
        }
        List<ProductInfo.Product> list = list(new String[]{str}, invoker).products;
        if (list != null && list.size() > 0) {
            Iterator<ProductInfo.Item> it = list.get(0).images.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ProductInfo.Item next = it.next();
                if (next.type.equals(Integer.toString(i))) {
                    File file2 = new File(file, StringUtil.replaceSpecialCharacters(str, "_") + "_" + i + "_" + next.file.revision + Extension.DOT + next.file.extension);
                    if ((!file2.exists() || file2.length() != next.file.size) && !download(next, file2.getAbsolutePath(), invoker)) {
                        break;
                    }
                    return file2;
                }
            }
        }
        return null;
    }

    public ProductInfo list(String[] strArr, Invoker invoker) {
        JsonArray jsonArray = new JsonArray();
        for (String str : strArr) {
            jsonArray.add(str);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(MODEL_CODES, jsonArray);
        return (ProductInfo) execute(ProductApiSpec.GET_PRODUCT, jsonObject, null, invoker, new Pair[0]);
    }

    public ProductInfoV2 listV2(String[] strArr, String[] strArr2) {
        JsonObject jsonObject = new JsonObject();
        if (strArr != null && strArr.length > 0) {
            JsonArray jsonArray = new JsonArray();
            for (String str : strArr) {
                jsonArray.add(str);
            }
            jsonObject.add(MODEL_CODES, jsonArray);
        }
        if (strArr2 != null && strArr2.length > 0) {
            JsonArray jsonArray2 = new JsonArray();
            for (String str2 : strArr2) {
                jsonArray2.add(str2);
            }
            jsonObject.add(MODEL_NAMES, jsonArray2);
        }
        return (ProductInfoV2) execute(ProductApiSpec.GET_PRODUCT_V2, jsonObject, null, new Pair[0]);
    }

    public ProductInfoV2WithColor listV2WithColor(List<ModelNameAndColor> list) {
        JsonObject jsonObject = new JsonObject();
        if (list != null && list.size() > 0) {
            JsonArray jsonArray = new JsonArray();
            for (ModelNameAndColor modelNameAndColor : list) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("modelName", modelNameAndColor.modelName);
                jsonObject2.addProperty("color", modelNameAndColor.color);
                jsonArray.add(jsonObject2);
            }
            jsonObject.add(MODEL_NAMES_AND_COLORS, jsonArray);
        }
        return (ProductInfoV2WithColor) execute(ProductApiSpec.GET_PRODUCT_V2_WITH_COLOR, jsonObject, null, new Pair[0]);
    }
}
