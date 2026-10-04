package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.ExtractionCategory;
import com.samsung.android.sdk.scs.p142ai.language.ExtractionInputParams;
import com.samsung.android.sdk.scs.p142ai.language.Extractor;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.AiServicesManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterTravelReservationInfo;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSServiceRequester;", "streaming", "", "<init>", "(Z)V", "getStreaming", "()Z", "setStreaming", "requestToService", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "Lcom/samsung/android/sdk/scs/ai/language/Result;", "requestString", "", "options", "", "", "getByteArray", "", "uriStr", "getMimeType", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSRequesterTravelReservationInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSRequesterTravelReservationInfo.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterTravelReservationInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
public final class SCSRequesterTravelReservationInfo implements SCSServiceRequester {
    private boolean streaming;

    public SCSRequesterTravelReservationInfo(boolean z) {
        this.streaming = z;
    }

    private final byte[] getByteArray(String uriStr) {
        Uri uri;
        ContentResolver contentResolver;
        InputStream inputStreamOpenInputStream;
        try {
            uri = Uri.parse(uriStr);
            Context applicationContext = BaseUtils.getApplicationContext();
            contentResolver = applicationContext != null ? applicationContext.getContentResolver() : null;
        } catch (Exception unused) {
        }
        if (contentResolver != null && (inputStreamOpenInputStream = contentResolver.openInputStream(uri)) != null) {
            try {
                byte[] bArr = new byte[4096];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        }
        return null;
    }

    private final String getMimeType(String uriStr) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uriStr));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    public boolean getStreaming() {
        return this.streaming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.samsung.android.sdk.scs.base.tasks.Task<com.samsung.android.sdk.scs.ai.language.Result>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [T] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    @Nullable
    public Task<Result> requestToService(@Nullable String requestString, @Nullable Map<String, ? extends Object> options) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r02 = 0;
        Extract = 0;
        ?? Extract = 0;
        r02 = 0;
        r02 = 0;
        Map<String, String> extraPrompt = requestString != null ? SCSTools.INSTANCE.getExtraPrompt(requestString) : null;
        SCSTools.setRequestType(AppInfo.RequestType.CLOUD);
        AppInfo appInfoMakeAppInfo$default = SCSTools.makeAppInfo$default(SCSTools.getRequestType(), false, 2, null);
        if (appInfoMakeAppInfo$default != null && requestString != null) {
            String mimeType = getMimeType(requestString);
            if (mimeType == null) {
                return null;
            }
            Extractor extractor = AiServicesManager.INSTANCE.getInstance().getExtractor();
            byte[] byteArray = getByteArray(requestString);
            if (byteArray != null) {
                ExtractionInputParams extractionInputParams = new ExtractionInputParams("", byteArray, ExtractionCategory.NOTES_TICKET_INFO_EXTRACTION, mimeType);
                if (extraPrompt != null && extractor != null) {
                    Extract = extractor.extract(appInfoMakeAppInfo$default, extractionInputParams);
                }
                objectRef.element = Extract;
                r02 = Extract;
            }
        }
        return r02;
    }

    public void setStreaming(boolean z) {
        this.streaming = z;
    }
}
