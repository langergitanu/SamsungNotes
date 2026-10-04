package com.samsung.android.support.senl.p148nt.base.common.p151ai.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/common/Feature;", "", "<init>", "()V", "IS_SUPPORT_AI_FUNCTION_DEFAULT", "", "getIS_SUPPORT_AI_FUNCTION_DEFAULT", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "IS_SUPPORT_AUTO_TRANSCRIBE", "getIS_SUPPORT_AUTO_TRANSCRIBE", "()Z", "ENABLE_RESULT_CACHING", "ENABLE_STT_DB", "SUPPORT_ON_DEVICE_SUMMARY", "ENABLE_DYNAMIC_TEMPLATE", "ENABLE_SYNC_AI_GEN_NOTES", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Feature {
    public static final boolean ENABLE_DYNAMIC_TEMPLATE = false;
    public static final boolean ENABLE_RESULT_CACHING = true;
    public static final boolean ENABLE_STT_DB = true;
    public static final boolean ENABLE_SYNC_AI_GEN_NOTES = false;

    @Nullable
    private static final Boolean IS_SUPPORT_AI_FUNCTION_DEFAULT = null;
    public static final boolean SUPPORT_ON_DEVICE_SUMMARY = false;

    @NotNull
    public static final Feature INSTANCE = new Feature();
    private static final boolean IS_SUPPORT_AUTO_TRANSCRIBE = true;

    private Feature() {
    }

    @Nullable
    public final Boolean getIS_SUPPORT_AI_FUNCTION_DEFAULT() {
        return IS_SUPPORT_AI_FUNCTION_DEFAULT;
    }

    public final boolean getIS_SUPPORT_AUTO_TRANSCRIBE() {
        return IS_SUPPORT_AUTO_TRANSCRIBE;
    }
}
