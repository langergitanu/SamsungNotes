package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm;

import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.ExtractionCategory;
import com.samsung.android.sdk.scs.p142ai.language.Extractor;
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
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterJournalInfo;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSServiceRequester;", "streaming", "", "<init>", "(Z)V", "getStreaming", "()Z", "setStreaming", "requestToService", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "Lcom/samsung/android/sdk/scs/ai/language/Result;", "requestString", "", "options", "", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSRequesterJournalInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSRequesterJournalInfo.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterJournalInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,31:1\n1#2:32\n*E\n"})
public final class SCSRequesterJournalInfo implements SCSServiceRequester {
    private boolean streaming;

    public SCSRequesterJournalInfo(boolean z) {
        this.streaming = z;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    public boolean getStreaming() {
        return this.streaming;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    @Nullable
    public Task<Result> requestToService(@Nullable String requestString, @Nullable Map<String, ? extends Object> options) {
        Map<String, String> extraPrompt = requestString != null ? SCSTools.INSTANCE.getExtraPrompt(requestString) : null;
        SCSTools.setRequestType(AppInfo.RequestType.CLOUD);
        AppInfo appInfoMakeAppInfo$default = SCSTools.makeAppInfo$default(SCSTools.getRequestType(), false, 2, null);
        if (appInfoMakeAppInfo$default == null) {
            return null;
        }
        Extractor extractor = AiServicesManager.INSTANCE.getInstance().getExtractor();
        if (extraPrompt == null || extractor == null) {
            return null;
        }
        return extractor.extract(appInfoMakeAppInfo$default, requestString, ExtractionCategory.NOTES_DIARY_INFO_EXTRACTION);
    }

    public void setStreaming(boolean z) {
        this.streaming = z;
    }
}
