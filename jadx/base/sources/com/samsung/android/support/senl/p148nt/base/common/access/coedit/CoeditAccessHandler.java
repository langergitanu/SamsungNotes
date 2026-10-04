package com.samsung.android.support.senl.p148nt.base.common.access.coedit;

import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/access/coedit/CoeditAccessHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "COEDIT_SERVICE_CLASS", "Ljava/lang/Class;", "getCoeditServiceClass", "setCoeditServiceClass", "", "coeditServiceClass", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoeditAccessHandler {

    @Nullable
    private static Class<?> COEDIT_SERVICE_CLASS = null;

    @NotNull
    public static final CoeditAccessHandler INSTANCE = new CoeditAccessHandler();

    @NotNull
    private static final String TAG = "CoeditAccessHandler";

    private CoeditAccessHandler() {
    }

    @JvmStatic
    @Nullable
    public static final Class<?> getCoeditServiceClass() {
        return COEDIT_SERVICE_CLASS;
    }

    @JvmStatic
    public static final void setCoeditServiceClass(@Nullable Class<?> coeditServiceClass) {
        if (COEDIT_SERVICE_CLASS == null) {
            COEDIT_SERVICE_CLASS = coeditServiceClass;
        }
    }
}
