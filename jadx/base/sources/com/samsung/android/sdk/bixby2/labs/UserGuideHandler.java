package com.samsung.android.sdk.bixby2.labs;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.samsung.android.sdk.bixby2.LogUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.TextStreamsKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/bixby2/labs/UserGuideHandler;", "", "()V", "ACTION_GET_USER_GUIDE", "", "DEFAULT_FILE_NAME", "KEY_METADATA_FILE_NAME", "KEY_USER_GUIDE_DATA", SearchConstants.TargetContents.TAG, "getUserGuide", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "getUserGuideFileName", "bixbyappsdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nUserGuideHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserGuideHandler.kt\ncom/samsung/android/sdk/bixby2/labs/UserGuideHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,30:1\n1#2:31\n*E\n"})
public final class UserGuideHandler {

    @NotNull
    public static final String ACTION_GET_USER_GUIDE = "bixby_getUserGuide";

    @NotNull
    private static final String DEFAULT_FILE_NAME = "interactive_user_guide.json";

    @NotNull
    public static final UserGuideHandler INSTANCE = new UserGuideHandler();

    @NotNull
    private static final String KEY_METADATA_FILE_NAME = "com.samsung.android.sdk.bixby2.userGuideFileName";

    @NotNull
    public static final String KEY_USER_GUIDE_DATA = "userGuideData";

    @NotNull
    private static final String TAG = "UserGuideHandler";

    private UserGuideHandler() {
    }

    private final String getUserGuideFileName(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
        String string = applicationInfo.metaData.getString(KEY_METADATA_FILE_NAME, DEFAULT_FILE_NAME);
        LogUtil.m5747i(TAG, "UserGuide fileName : " + string);
        Intrinsics.checkNotNullExpressionValue(string, "also(...)");
        return string;
    }

    @NotNull
    public final String getUserGuide(@NotNull Context context, @NotNull Bundle extras) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extras, "extras");
        LogUtil.m5747i(TAG, "getUserGuide");
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream inputStreamOpen = context.getAssets().open(getUserGuideFileName(context));
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            objM22215constructorimpl = Result.m22215constructorimpl(TextStreamsKt.readText(new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null) {
            LogUtil.m5746e(TAG, "exception - " + thM22218exceptionOrNullimpl);
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = "";
        }
        return (String) objM22215constructorimpl;
    }
}
