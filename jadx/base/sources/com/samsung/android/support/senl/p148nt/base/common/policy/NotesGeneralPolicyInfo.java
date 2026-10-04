package com.samsung.android.support.senl.p148nt.base.common.policy;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/policy/NotesGeneralPolicyInfo;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "GENERAL_POLICY_NOTE_APP_VERSION_KEY", NotesGeneralPolicyInfo.GENERAL_POLICY_NOTE_APP_VERSION_KEY, "parseGeneralPolicyFile", "", "obj", "Lorg/json/JSONObject;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NotesGeneralPolicyInfo {

    @NotNull
    private static final String GENERAL_POLICY_NOTE_APP_VERSION_KEY = "noteAppVersion";

    @NotNull
    public static final NotesGeneralPolicyInfo INSTANCE = new NotesGeneralPolicyInfo();

    @NotNull
    private static final String TAG = "NotesGeneralPolicyInfo";

    @Nullable
    private static String noteAppVersion;

    private NotesGeneralPolicyInfo() {
    }

    @JvmStatic
    public static final void parseGeneralPolicyFile(@NotNull JSONObject obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        noteAppVersion = obj.getString(GENERAL_POLICY_NOTE_APP_VERSION_KEY);
        Debugger.INSTANCE.m8627i(TAG, "parseGeneralPolicyFile() : noteAppVersion = " + noteAppVersion);
    }
}
