package com.samsung.android.support.senl.p148nt.base.common.sdk.util;

import android.content.Context;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/sdk/util/SpenSdkInitializer;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mContextHashCode", "", "MAX_CACHE_SIZE", "WNOTE_OBJECT_TEXT_LIMIT", "WNOTE_BODY_TEXT_LIMIT", "initialized", "", "context", "Landroid/content/Context;", "initialize", "updateSDK", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenSdkInitializer {

    @NotNull
    public static final SpenSdkInitializer INSTANCE = new SpenSdkInitializer();
    public static final int MAX_CACHE_SIZE = 200;

    @NotNull
    private static final String TAG = "SpenSdkInitializer";
    public static final int WNOTE_BODY_TEXT_LIMIT = 350000;
    public static final int WNOTE_OBJECT_TEXT_LIMIT = 5000;
    private static int mContextHashCode;

    private SpenSdkInitializer() {
    }

    @JvmStatic
    public static final synchronized boolean initialize(@Nullable Context context) {
        Logger.m8697d(TAG, "Initialize# context: " + context);
        if (context == null) {
            return false;
        }
        if (context.hashCode() == mContextHashCode) {
            return true;
        }
        try {
            new Spen().initialize(context, 200);
            mContextHashCode = context.hashCode();
            SpenWNote.Companion companion = SpenWNote.INSTANCE;
            companion.setDefaultTextLimit(5000);
            companion.setDefaultBodyTextLimit(350000);
            Logger.m8702i(TAG, "Initialize# done mContextHashCode: " + mContextHashCode);
            return true;
        } catch (SsdkUnsupportedException e) {
            Logger.m8699e(TAG, "Initialize# ", e);
            return false;
        } catch (RuntimeException e2) {
            Logger.m8699e(TAG, "Initialize# ", e2);
            return false;
        }
    }

    @JvmStatic
    public static final boolean initialized(@Nullable Context context) {
        Logger.m8697d(TAG, "initialized check# context: " + context);
        return context != null && context.hashCode() == mContextHashCode;
    }

    @JvmStatic
    public static final synchronized void updateSDK(@Nullable Context context) {
        if (context == null) {
            return;
        }
        try {
            Spen.Companion companion = Spen.INSTANCE;
            RequestToSCloudManager.Companion companion2 = RequestToSCloudManager.INSTANCE;
            companion.updateSDK(context, companion2.getInstance().isWiFiAvailable(), companion2.getInstance().isDataNetworkAvailable());
        } catch (RuntimeException e) {
            Logger.m8699e(TAG, "updateSDK# ", e);
        }
    }
}
