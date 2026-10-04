package com.samsung.android.support.senl.addons.executor;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u001c\u0010\u0005\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/executor/IExecuteIntentBuilder;", "", "setIntentFlags", "flags", "", "setDataHandler", "dataHandler", "Ljava/lang/Class;", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "build", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IExecuteIntentBuilder {

    @NotNull
    public static final String ARG_TOOL_FORCE_FINISH = "tool_force_finish";

    @NotNull
    public static final String ARG_TOOL_FORCE_FINISH_WITH_SAVING = "tool_force_finish_with_save";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/executor/IExecuteIntentBuilder$Companion;", "", "<init>", "()V", "ARG_TOOL_FORCE_FINISH", "", "ARG_TOOL_FORCE_FINISH_WITH_SAVING", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String ARG_TOOL_FORCE_FINISH = "tool_force_finish";

        @NotNull
        public static final String ARG_TOOL_FORCE_FINISH_WITH_SAVING = "tool_force_finish_with_save";

        private Companion() {
        }
    }

    @NotNull
    Intent build(@Nullable Context context);

    @NotNull
    IExecuteIntentBuilder setDataHandler(@Nullable Class<? extends IDataHandler> dataHandler);

    @NotNull
    IExecuteIntentBuilder setIntentFlags(int flags);
}
