package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm;

import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.CorrectionSubTask;
import com.samsung.android.sdk.scs.p142ai.language.Corrector;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.AiServicesManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0018\u0010\r\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterSpellingCorrection;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSServiceRequester;", "streaming", "", "<init>", "(Z)V", "getStreaming", "()Z", "requestToService", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "Lcom/samsung/android/sdk/scs/ai/language/Result;", "requestString", "", "options", "", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSRequesterSpellingCorrection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSRequesterSpellingCorrection.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterSpellingCorrection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,31:1\n1#2:32\n*E\n"})
public final class SCSRequesterSpellingCorrection implements SCSServiceRequester {
    private final boolean streaming;

    public SCSRequesterSpellingCorrection(boolean z) {
        this.streaming = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    public boolean getStreaming() {
        return this.streaming;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    @Nullable
    public Task<Result> requestToService(@Nullable String requestString, @Nullable Map<String, ? extends Object> options) {
        if (requestString != null) {
            SCSTools.INSTANCE.getExtraPrompt(requestString);
        }
        SCSTools.setRequestType(AppInfo.RequestType.CLOUD);
        AppInfo appInfoMakeAppInfo = SCSTools.makeAppInfo(SCSTools.getRequestType(), getStreaming());
        if (appInfoMakeAppInfo == null) {
            return null;
        }
        Corrector corrector = AiServicesManager.INSTANCE.getInstance().getCorrector();
        if (requestString == null || corrector == null) {
            return null;
        }
        return corrector.correct(appInfoMakeAppInfo, requestString, CorrectionSubTask.TYPO);
    }
}
