package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&J6\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0018\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0011\u001a\u00020\u000bH&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/ILLMRequester;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/IRequesterBase;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "getLimitedStringSize", "", "input", "", "type", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "requestText", "", TextConst.KEY_PARAM_REQUEST_TYPE, "content", "options", "", "", "close", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILLMRequester extends IRequesterBase, AutoCloseable {

    @NotNull
    public static final String AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED = "AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String OPTION_KEY_LANGUAGE_STR = "language";

    @NotNull
    public static final String OPTION_KEY_STYLE_STR = "style";

    @NotNull
    public static final String OPTION_KEY_SUMMARIZE_SUB_TASK_STR = "summarize_subtask";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/ILLMRequester$Companion;", "", "<init>", "()V", "OPTION_KEY_STYLE_STR", "", "OPTION_KEY_LANGUAGE_STR", "OPTION_KEY_SUMMARIZE_SUB_TASK_STR", "AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED = "AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED";

        @NotNull
        public static final String OPTION_KEY_LANGUAGE_STR = "language";

        @NotNull
        public static final String OPTION_KEY_STYLE_STR = "style";

        @NotNull
        public static final String OPTION_KEY_SUMMARIZE_SUB_TASK_STR = "summarize_subtask";

        private Companion() {
        }
    }

    @Override // java.lang.AutoCloseable
    void close();

    int getLimitedStringSize(@Nullable String input, @Nullable SCSRequesterType type);

    void requestText(@Nullable SCSRequesterType requestType, @Nullable String content);

    void requestText(@Nullable SCSRequesterType requestType, @Nullable Map<String, ? extends Object> options, @Nullable String content);
}
