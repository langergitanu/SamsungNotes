package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.llm;

import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.sdk.scs.p142ai.language.SummarizeLevel;
import com.samsung.android.sdk.scs.p142ai.language.SummarizeSubTask;
import com.samsung.android.sdk.scs.p142ai.language.Summarizer;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.SummaryStyle;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.AiServicesManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0018\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0015H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterSummary;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSServiceRequester;", "streaming", "", "<init>", "(Z)V", "getStreaming", "()Z", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "requestToService", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "Lcom/samsung/android/sdk/scs/ai/language/Result;", "requestString", "", "options", "", "", "setCallback", "", "getSummaryLines", "", "input", "style", "Lcom/samsung/android/support/senl/nt/base/common/ai/common/SummaryStyle;", "getSummaryLinesOnDevice", "continuousNumber", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSRequesterSummary.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSRequesterSummary.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/llm/SCSRequesterSummary\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
public final class SCSRequesterSummary implements SCSServiceRequester {

    @NotNull
    private static final String KEY_SUMMARY_APP_NAME = "app_name";

    @NotNull
    private static final String KEY_SUMMARY_LINES = "count_of_summary_lines";

    @NotNull
    private static final String KEY_SUMMARY_TYPE = "document_type";

    @NotNull
    private static final String KEY_TARGET_LANGUAGE = "target_language";

    @NotNull
    public static final String OPTION_KEY_CONTINUOUS_NUMBER = "continuous_number";

    @NotNull
    public static final String OPTION_KEY_LOCALE_STR = "locale";

    @NotNull
    public static final String OPTION_KEY_ON_DEVICE = "on_device";

    @NotNull
    private static final String TAG = "SCSRequesterSummary";

    @NotNull
    private static final String VALUE_LONG_NOTE = "long_note";

    @NotNull
    private static final String VALUE_SHORT_NOTE = "short_note";

    @NotNull
    private static final String VALUE_SUMMARY_APP_NAME_VOICE_RECORDER = "voice_recorder";

    @Nullable
    private SCSTextResultListener.Callback callback;
    private final boolean streaming;

    public SCSRequesterSummary(boolean z) {
        this.streaming = z;
    }

    private final int getSummaryLines(String input, SummaryStyle style) {
        int length = input.length();
        if (length <= 250) {
            return style == SummaryStyle.LONG ? 2 : 1;
        }
        if (length <= 350) {
            return style == SummaryStyle.LONG ? 3 : 2;
        }
        if (length <= 450) {
            return 3;
        }
        if (length <= 550) {
            return 5;
        }
        return length <= 1500 ? style == SummaryStyle.LONG ? 6 : 5 : style == SummaryStyle.LONG ? 7 : 6;
    }

    private final int getSummaryLinesOnDevice(String input, int continuousNumber) {
        int length = input.length();
        if (continuousNumber > 1) {
            return continuousNumber <= 2 ? 2 : 1;
        }
        if (length <= 250) {
            return 1;
        }
        return length <= 500 ? 2 : 3;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    public boolean getStreaming() {
        return this.streaming;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester
    @Nullable
    public Task<Result> requestToService(@Nullable String requestString, @Nullable Map<String, ? extends Object> options) {
        AppInfo appInfoMakeAppInfo;
        Integer numValueOf;
        Object obj;
        Map<String, String> extraPrompt = requestString != null ? SCSTools.INSTANCE.getExtraPrompt(requestString) : null;
        Object obj2 = options != null ? options.get(OPTION_KEY_ON_DEVICE) : null;
        AppInfo.RequestType requestType = AppInfo.RequestType.ONDEVICE;
        if (obj2 == requestType) {
            SCSTools.setRequestType(requestType);
            appInfoMakeAppInfo = SCSTools.makeOndeviceAppInfo();
        } else {
            SCSTools.setRequestType(AppInfo.RequestType.CLOUD);
            appInfoMakeAppInfo = SCSTools.makeAppInfo(SCSTools.getRequestType(), getStreaming());
        }
        AppInfo appInfo = appInfoMakeAppInfo;
        if (appInfo == null) {
            return null;
        }
        Summarizer summarizer = AiServicesManager.INSTANCE.getInstance().getSummarizer();
        SummarizeSubTask summarizeSubTask = SummarizeSubTask.ARTICLE;
        if (options != null && (obj = options.get("summarize_subtask")) != null) {
            summarizeSubTask = (SummarizeSubTask) obj;
        }
        SummarizeSubTask summarizeSubTask2 = summarizeSubTask;
        if (AppInfo.RequestType.CLOUD == appInfo.getRequestType()) {
            SummarizeLevel summarizeLevel = SummarizeLevel.MORE_BRIEFLY;
            if (options != null) {
                SummaryStyle summaryStyle = (SummaryStyle) options.get("style");
                Integer numValueOf2 = requestString != null ? Integer.valueOf(getSummaryLines(requestString, summaryStyle)) : null;
                if (extraPrompt != null) {
                    extraPrompt.put(KEY_SUMMARY_TYPE, SummaryStyle.LONG == summaryStyle ? VALUE_LONG_NOTE : VALUE_SHORT_NOTE);
                }
                if (CscFeature.INSTANCE.getInstance().isChinaAiFeature() && extraPrompt != null) {
                    extraPrompt.put(KEY_SUMMARY_LINES, String.valueOf(numValueOf2));
                }
                if (summarizeSubTask2 == SummarizeSubTask.DIALOGUE) {
                    if (extraPrompt != null) {
                        extraPrompt.put("app_name", VALUE_SUMMARY_APP_NAME_VOICE_RECORDER);
                    }
                    if (extraPrompt != null) {
                        extraPrompt.put(KEY_SUMMARY_LINES, "3");
                    }
                }
            }
            if (extraPrompt == null || summarizer == null) {
                return null;
            }
            return summarizer.summarize(appInfo, requestString.toString(), summarizeLevel, summarizeSubTask2, extraPrompt);
        }
        SummarizeLevel summarizeLevel2 = SummarizeLevel.MORE_BRIEFLY;
        if (options != null) {
            Object obj3 = options.get("locale");
            Object obj4 = options.get(OPTION_KEY_CONTINUOUS_NUMBER);
            if (requestString != null) {
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                numValueOf = Integer.valueOf(getSummaryLinesOnDevice(requestString, ((Integer) obj4).intValue()));
            } else {
                numValueOf = null;
            }
            if (extraPrompt != null) {
                extraPrompt.put(KEY_SUMMARY_TYPE, VALUE_SHORT_NOTE);
            }
            if (extraPrompt != null) {
                extraPrompt.put(KEY_SUMMARY_LINES, String.valueOf(numValueOf));
            }
            if (extraPrompt != null) {
                extraPrompt.put(KEY_TARGET_LANGUAGE, String.valueOf(obj3));
            }
            if (extraPrompt != null && summarizer != null) {
                return summarizer.summarize(appInfo, requestString.toString(), summarizeLevel2, summarizeSubTask2, extraPrompt);
            }
        }
        return null;
    }

    public final void setCallback(@Nullable SCSTextResultListener.Callback callback) {
        this.callback = callback;
    }
}
