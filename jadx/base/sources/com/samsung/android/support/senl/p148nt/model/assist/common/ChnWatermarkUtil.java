package com.samsung.android.support.senl.p148nt.model.assist.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt___StringsKt;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005J*\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010%\u001a\u00020\u0005H\u0002J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J0\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0005H\u0002J8\u00101\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002J\u0016\u00105\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020+07H\u0002J\u0010\u00108\u001a\u00020+2\u0006\u00109\u001a\u00020\u0005H\u0002J@\u0010:\u001a\u00020\"*\u00020;2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010@\u001a\u00020\u0005H\u0002J\f\u0010A\u001a\u00020\u0005*\u00020+H\u0002J\f\u0010B\u001a\u00020+*\u00020\u0005H\u0002J\t\u0010C\u001a\u00020\u0005H\u0082 J\t\u0010D\u001a\u00020\u0005H\u0082 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/assist/common/ChnWatermarkUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SEF_KEY_PE_GENERATED_IMAGE_INFO_CHN", "SEF_PE_GENERATED_IMAGE_TYPE", "", "MAX_SIZE_FOR_IMG_MD5", "KEY_AIGC", "KEY_LABEL", "KEY_CONTENT_PRODUCER", "KEY_PRODUCE_ID", "KEY_RESERVED_CODE_1", "KEY_CONTENT_PROPAGATOR", "KEY_PROPAGATE_ID", "KEY_RESERVED_CODE_2", "VALUE_LABEL", "VALUE_CONTENT_PRODUCER", "VALUE_VERSION", "VALUE_MODEL_CODE", "VALUE_APP_CODE", "ASCII_PREFIX", "SIGNATURE_ALGORITHM", "ALG_ID", "TYPE_CNT_SEL_PNG", "TYPE_CNT_SEL_JPEG", "TYPE_CNT_SEL_DEFAULT", "privateKey", "Ljava/security/PrivateKey;", "publicKey", "Ljava/security/PublicKey;", "addInvisibleWatermark", "", "destFile", "Ljava/io/File;", "contentSel", "genInvisibleWatermarkContent", "Lorg/json/JSONObject;", IdentityApiContract.Parameter.MODEL_CODE, "appCode", "fileContent", "", "getProduceId", "getReservedCode1", "label", "contentProducer", "produceId", "getReservedCode2", "reservedCode1", "contentPropagator", "propagateID", "getDataSignature", Constants.JTAG_DATA_LIST, "", "getBitmapByteArray", DBSchema.DocumentThumbnail.IMAGE_PATH, "addSignatureEntry", "Lorg/json/JSONArray;", "signType", FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, "contentStart", "contentLength", "getCurrentTimeFormatted", "toHexString", "hexToByteArray", "getPublicKey", "getPrivateKey", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nChnWatermarkUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChnWatermarkUtil.kt\ncom/samsung/android/support/senl/nt/model/assist/common/ChnWatermarkUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,263:1\n1869#2,2:264\n1563#2:266\n1634#2,3:267\n*S KotlinDebug\n*F\n+ 1 ChnWatermarkUtil.kt\ncom/samsung/android/support/senl/nt/model/assist/common/ChnWatermarkUtil\n*L\n190#1:264,2\n258#1:266\n258#1:267,3\n*E\n"})
public final class ChnWatermarkUtil {

    @NotNull
    private static final String ALG_ID = "1.2.840.10045.4.3.2";

    @NotNull
    private static final String ASCII_PREFIX = "ASCII\u0000\u0000\u0000";

    @NotNull
    private static final String KEY_AIGC = "AIGC";

    @NotNull
    private static final String KEY_CONTENT_PRODUCER = "ContentProducer";

    @NotNull
    private static final String KEY_CONTENT_PROPAGATOR = "ContentPropagator";

    @NotNull
    private static final String KEY_LABEL = "Label";

    @NotNull
    private static final String KEY_PRODUCE_ID = "ProduceID";

    @NotNull
    private static final String KEY_PROPAGATE_ID = "PropagateID";

    @NotNull
    private static final String KEY_RESERVED_CODE_1 = "ReservedCode1";

    @NotNull
    private static final String KEY_RESERVED_CODE_2 = "ReservedCode2";
    private static final int MAX_SIZE_FOR_IMG_MD5 = 10000;

    @NotNull
    private static final String SEF_KEY_PE_GENERATED_IMAGE_INFO_CHN = "PEg_Info";
    private static final int SEF_PE_GENERATED_IMAGE_TYPE = 3473;

    @NotNull
    private static final String SIGNATURE_ALGORITHM = "SHA256withECDSA";

    @NotNull
    private static final String TYPE_CNT_SEL_DEFAULT = "DFT";

    @NotNull
    private static final String TYPE_CNT_SEL_JPEG = "JPEG";

    @NotNull
    private static final String TYPE_CNT_SEL_PNG = "PNG";

    @NotNull
    private static final String VALUE_APP_CODE = "0401";

    @NotNull
    private static final String VALUE_CONTENT_PRODUCER = "001191110000625911349W00000";

    @NotNull
    private static final String VALUE_LABEL = "1";

    @NotNull
    private static final String VALUE_MODEL_CODE = "0203";

    @NotNull
    private static final String VALUE_VERSION = "03";

    @NotNull
    private static PrivateKey privateKey;

    @NotNull
    private static PublicKey publicKey;

    @NotNull
    public static final ChnWatermarkUtil INSTANCE = new ChnWatermarkUtil();

    @NotNull
    private static final String TAG = "ChnWatermarkUtil";

    static {
        try {
            System.loadLibrary("WatermarkKey");
        } catch (UnsatisfiedLinkError e) {
            Logger.m8698e(TAG, "Could not load libWatermarkKey.so " + e + " ");
        }
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ChnWatermarkUtil chnWatermarkUtil = INSTANCE;
        PrivateKey privateKeyGeneratePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(chnWatermarkUtil.hexToByteArray(chnWatermarkUtil.getPrivateKey())));
        Intrinsics.checkNotNullExpressionValue(privateKeyGeneratePrivate, "generatePrivate(...)");
        privateKey = privateKeyGeneratePrivate;
        PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(new X509EncodedKeySpec(chnWatermarkUtil.hexToByteArray(chnWatermarkUtil.getPublicKey())));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
        publicKey = publicKeyGeneratePublic;
    }

    private ChnWatermarkUtil() {
    }

    private final void addSignatureEntry(JSONArray jSONArray, String str, String str2, String str3, String str4, String str5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PackageRelationship.TYPE_ATTRIBUTE_NAME, "DS");
        jSONObject.put("AlgID", ALG_ID);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PackageRelationship.TYPE_ATTRIBUTE_NAME, str);
        if (Intrinsics.areEqual(str, "Cnt") && str3 != null) {
            jSONObject2.put("CntSel", str3);
        }
        if (str4 != null) {
            jSONObject2.put("Start", str4);
        }
        if (str5 != null) {
            jSONObject2.put("Length", str5);
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("TBSData", jSONObject2);
        jSONObject.put("Signature", str2);
        jSONObject.put(PerfConstants.CodeMarkerParameters.TIME, INSTANCE.getCurrentTimeFormatted());
        jSONArray.put(jSONObject);
    }

    public static /* synthetic */ void addSignatureEntry$default(ChnWatermarkUtil chnWatermarkUtil, JSONArray jSONArray, String str, String str2, String str3, String str4, String str5, int i, Object obj) throws JSONException {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        chnWatermarkUtil.addSignatureEntry(jSONArray, str, str2, str3, str4, str5);
    }

    private final JSONObject genInvisibleWatermarkContent(String modelCode, String appCode, byte[] fileContent, String contentSel) throws JSONException {
        String produceId = getProduceId(modelCode, appCode);
        JSONObject reservedCode1 = getReservedCode1("1", VALUE_CONTENT_PRODUCER, produceId, fileContent, contentSel);
        String string = reservedCode1.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        JSONObject reservedCode2 = getReservedCode2("1", VALUE_CONTENT_PRODUCER, produceId, string, VALUE_CONTENT_PRODUCER, produceId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Label", "1");
        jSONObject.put(KEY_CONTENT_PRODUCER, VALUE_CONTENT_PRODUCER);
        jSONObject.put(KEY_PRODUCE_ID, produceId);
        jSONObject.put(KEY_RESERVED_CODE_1, reservedCode1);
        jSONObject.put(KEY_CONTENT_PROPAGATOR, VALUE_CONTENT_PRODUCER);
        jSONObject.put(KEY_PROPAGATE_ID, produceId);
        jSONObject.put(KEY_RESERVED_CODE_2, reservedCode2);
        return jSONObject;
    }

    public static /* synthetic */ JSONObject genInvisibleWatermarkContent$default(ChnWatermarkUtil chnWatermarkUtil, String str, String str2, byte[] bArr, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = TYPE_CNT_SEL_DEFAULT;
        }
        return chnWatermarkUtil.genInvisibleWatermarkContent(str, str2, bArr, str3);
    }

    private final byte[] getBitmapByteArray(String imagePath) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(imagePath);
        if (bitmapDecodeFile == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            Intrinsics.checkNotNullExpressionValue(byteArray, "use(...)");
            return byteArray;
        } finally {
        }
    }

    private final String getCurrentTimeFormatted() {
        String str = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String getDataSignature(List<byte[]> dataList) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateKey);
            Iterator<T> it = dataList.iterator();
            while (it.hasNext()) {
                signature.update((byte[]) it.next());
            }
            byte[] bArrSign = signature.sign();
            Intrinsics.checkNotNull(bArrSign);
            return toHexString(bArrSign);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private final native String getPrivateKey();

    private final String getProduceId(String modelCode, String appCode) {
        return VALUE_VERSION + System.currentTimeMillis() + modelCode + appCode;
    }

    private final native String getPublicKey();

    private final JSONObject getReservedCode1(String label, String contentProducer, String produceId, byte[] fileContent, String contentSel) throws JSONException {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = label.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = contentProducer.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] bytes3 = produceId.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        String dataSignature = getDataSignature(CollectionsKt.listOf((Object[]) new byte[][]{bytes, bytes2, bytes3}));
        String dataSignature2 = getDataSignature(CollectionsKt.listOf(fileContent));
        JSONArray jSONArray = new JSONArray();
        ChnWatermarkUtil chnWatermarkUtil = INSTANCE;
        addSignatureEntry$default(chnWatermarkUtil, jSONArray, "Md", dataSignature, null, null, null, 28, null);
        addSignatureEntry$default(chnWatermarkUtil, jSONArray, "Cnt", dataSignature2, contentSel, null, null, 24, null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PackageRelationship.TYPE_ATTRIBUTE_NAME, "PubKey");
        jSONObject.put("AlgID", ALG_ID);
        jSONObject.put("KeyValue", chnWatermarkUtil.getPublicKey());
        jSONArray.put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PackageRelationship.TYPE_ATTRIBUTE_NAME, "TC260PG");
        jSONObject2.put("Version", "1");
        jSONObject2.put("PubSD", jSONArray);
        JSONObject jSONObjectPut = new JSONObject().put("SecurityData", jSONObject2);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    private final JSONObject getReservedCode2(String label, String contentProducer, String produceId, String reservedCode1, String contentPropagator, String propagateID) throws JSONException {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = label.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = contentProducer.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] bytes3 = produceId.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        byte[] bytes4 = reservedCode1.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
        byte[] bytes5 = contentPropagator.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes5, "getBytes(...)");
        byte[] bytes6 = propagateID.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes6, "getBytes(...)");
        String dataSignature = getDataSignature(CollectionsKt.listOf((Object[]) new byte[][]{bytes, bytes2, bytes3, bytes4, bytes5, bytes6}));
        JSONArray jSONArray = new JSONArray();
        ChnWatermarkUtil chnWatermarkUtil = INSTANCE;
        addSignatureEntry$default(chnWatermarkUtil, jSONArray, "Md", dataSignature, null, null, null, 28, null);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PackageRelationship.TYPE_ATTRIBUTE_NAME, "PubKey");
        jSONObject.put("AlgID", ALG_ID);
        jSONObject.put("KeyValue", chnWatermarkUtil.getPublicKey());
        jSONArray.put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PackageRelationship.TYPE_ATTRIBUTE_NAME, "TC260PG");
        jSONObject2.put("Version", "1");
        jSONObject2.put("PubSD", jSONArray);
        JSONObject jSONObjectPut = new JSONObject().put("SecurityData", jSONObject2);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    private final byte[] hexToByteArray(String str) {
        if (str.length() % 2 != 0) {
            return new byte[0];
        }
        List listChunked = StringsKt___StringsKt.chunked(str, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listChunked));
        Iterator it = listChunked.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), CharsKt.checkRadix(16))));
        }
        return CollectionsKt___CollectionsKt.toByteArray(arrayList);
    }

    private final String toHexString(byte[] bArr) {
        return ArraysKt___ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new C0348a(12), 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHexString$lambda$13(byte b) {
        return AbstractC2322a.m1624n("%02x", new Object[]{Byte.valueOf(b)}, 1, "format(...)");
    }

    public final void addInvisibleWatermark(@NotNull File destFile, @NotNull String contentSel) throws JSONException {
        Intrinsics.checkNotNullParameter(destFile, "destFile");
        Intrinsics.checkNotNullParameter(contentSel, "contentSel");
        ImageContentExtractorUtils imageContentExtractorUtils = ImageContentExtractorUtils.INSTANCE;
        String path = destFile.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        byte[] bArrExtractContentData = imageContentExtractorUtils.extractContentData(path);
        if (bArrExtractContentData == null) {
            String path2 = destFile.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            bArrExtractContentData = getBitmapByteArray(path2);
        }
        JSONObject jSONObjectGenInvisibleWatermarkContent = genInvisibleWatermarkContent(VALUE_MODEL_CODE, VALUE_APP_CODE, bArrExtractContentData, contentSel);
        if (Intrinsics.areEqual(contentSel, TYPE_CNT_SEL_JPEG)) {
            JpegXmpUtils jpegXmpUtils = JpegXmpUtils.INSTANCE;
            String path3 = destFile.getPath();
            Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
            String string = jSONObjectGenInvisibleWatermarkContent.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            jpegXmpUtils.writeXmpToJpegFile(path3, string);
            return;
        }
        PngXmpUtil pngXmpUtil = PngXmpUtil.INSTANCE;
        String path4 = destFile.getPath();
        Intrinsics.checkNotNullExpressionValue(path4, "getPath(...)");
        String string2 = jSONObjectGenInvisibleWatermarkContent.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        pngXmpUtil.writeXmpToPngFile(path4, string2);
    }
}
