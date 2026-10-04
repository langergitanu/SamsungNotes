package com.samsung.android.sdk.bixby2.labs;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.WindowInspector;
import com.google.gson.Gson;
import com.samsung.android.sdk.bixby2.LogUtil;
import com.samsung.android.sdk.bixby2.labs.data.ErrorInfo;
import com.samsung.android.sdk.bixby2.labs.data.RootViewNode;
import com.samsung.android.sdk.bixby2.labs.data.ViewNodeInfoKt;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/bixby2/labs/ScreenLayoutHandler;", "", "()V", "ACTION_GET_SCREEN_LAYOUT", "", "KEY_SCREEN_LAYOUT_INFO", SearchConstants.TargetContents.TAG, "getAccessibilityNodeInfo", "", "Lcom/samsung/android/sdk/bixby2/labs/data/RootViewNode;", "getScreenLayout", "extras", "Landroid/os/Bundle;", "bixbyappsdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScreenLayoutHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenLayoutHandler.kt\ncom/samsung/android/sdk/bixby2/labs/ScreenLayoutHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1#2:61\n1855#3,2:62\n*S KotlinDebug\n*F\n+ 1 ScreenLayoutHandler.kt\ncom/samsung/android/sdk/bixby2/labs/ScreenLayoutHandler\n*L\n34#1:62,2\n*E\n"})
public final class ScreenLayoutHandler {

    @NotNull
    public static final String ACTION_GET_SCREEN_LAYOUT = "bixby_getScreenLayout";

    @NotNull
    public static final ScreenLayoutHandler INSTANCE = new ScreenLayoutHandler();

    @NotNull
    public static final String KEY_SCREEN_LAYOUT_INFO = "screenLayoutInfo";

    @NotNull
    private static final String TAG = "ScreenLayoutHandler";

    private ScreenLayoutHandler() {
    }

    private final List<RootViewNode> getAccessibilityNodeInfo() {
        Object objM22215constructorimpl;
        LogUtil.m5747i(TAG, String.valueOf(Thread.currentThread()));
        ArrayList arrayList = new ArrayList();
        List<View> globalWindowViews = WindowInspector.getGlobalWindowViews();
        LogUtil.m5744c(TAG, "rootView size = " + globalWindowViews.size());
        Intrinsics.checkNotNullExpressionValue(globalWindowViews, "also(...)");
        for (View view : globalWindowViews) {
            ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
            String string = ((WindowManager.LayoutParams) layoutParams).getTitle().toString();
            ViewGroup.LayoutParams layoutParams2 = view.getRootView().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
            int i = ((WindowManager.LayoutParams) layoutParams2).type;
            LogUtil.m5744c(TAG, "rootView = " + string + ", windowType = " + i);
            try {
                Result.Companion companion = Result.INSTANCE;
                AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = view.getRootView().createAccessibilityNodeInfo();
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setQueryFromAppProcessEnabled(view, true);
                Intrinsics.checkNotNull(accessibilityNodeInfoCreateAccessibilityNodeInfo);
                objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(arrayList.add(new RootViewNode(string, ViewNodeInfoKt.toViewNodeInfo(accessibilityNodeInfoCreateAccessibilityNodeInfo), Integer.valueOf(i), null, 8, null))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
            if (thM22218exceptionOrNullimpl != null) {
                arrayList.add(new RootViewNode(string, null, Integer.valueOf(i), new ErrorInfo(thM22218exceptionOrNullimpl.getClass().getSimpleName(), ExceptionsKt.stackTraceToString(thM22218exceptionOrNullimpl)), 2, null));
            }
        }
        LogUtil.m5744c(TAG, "ViewNodeInfo size : " + arrayList.size());
        return arrayList;
    }

    @NotNull
    public final String getScreenLayout(@NotNull Bundle extras) {
        Object objM22215constructorimpl;
        Intrinsics.checkNotNullParameter(extras, "extras");
        LogUtil.m5744c(TAG, "getScreenLayout");
        try {
            Result.Companion companion = Result.INSTANCE;
            String json = new Gson().toJson(getAccessibilityNodeInfo());
            LogUtil.m5744c(TAG, "Screen Layout : " + json);
            objM22215constructorimpl = Result.m22215constructorimpl(json);
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
