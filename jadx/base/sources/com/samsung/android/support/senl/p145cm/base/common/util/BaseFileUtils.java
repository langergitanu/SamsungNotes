package com.samsung.android.support.senl.p145cm.base.common.util;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/BaseFileUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "exists", "", "filePath", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBaseFileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFileUtils.kt\ncom/samsung/android/support/senl/cm/base/common/util/BaseFileUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class BaseFileUtils {

    @NotNull
    public static final BaseFileUtils INSTANCE = new BaseFileUtils();

    @NotNull
    private static final String TAG = "BaseFileUtils";

    private BaseFileUtils() {
    }

    @JvmStatic
    public static final boolean exists(@Nullable String filePath) {
        File file;
        if (filePath != null) {
            try {
                file = new File(filePath);
            } catch (Exception e) {
                AbstractC0000a.m23t("exists : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return false;
            }
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            return false;
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "exists : " + companion.getEncode(filePath));
        return true;
    }
}
