package com.samsung.android.support.senl.p145cm.base.framework.sem.support;

import android.content.Context;
import com.samsung.android.chimera.genie.SemMemRequest;
import com.samsung.android.chimera.genie.SemSmartMemoryManager;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/support/GenieMemoryManager;", "", "context", "Landroid/content/Context;", TextConst.KEY_PARAM_REQUEST_TYPE, "", "<init>", "(Landroid/content/Context;I)V", "mMemoryManager", "Lcom/samsung/android/chimera/genie/SemSmartMemoryManager;", "mRequest", "Lcom/samsung/android/chimera/genie/SemMemRequest;", "mContext", "prepare", "", "request", "release", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGenieMemoryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenieMemoryManager.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/support/GenieMemoryManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class GenieMemoryManager {
    public static final int NOTES = 1;

    @NotNull
    private static final String TAG = "GenieMemoryManager";
    public static final int VOICE_RECORDER = 2;

    @Nullable
    private final Context mContext;

    @Nullable
    private SemSmartMemoryManager mMemoryManager;

    @Nullable
    private SemMemRequest mRequest;

    public GenieMemoryManager(@Nullable Context context, int i) {
        this.mContext = context;
        try {
            if (this.mMemoryManager == null && context != null) {
                this.mMemoryManager = SemSmartMemoryManager.getInstance(context);
            }
            if (this.mRequest == null) {
                this.mRequest = new SemMemRequest(1, 2621440);
            }
        } catch (NoClassDefFoundError e) {
            AbstractC0000a.m23t("NoClassDefFoundError : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        }
    }

    public final void prepare() {
        SemSmartMemoryManager semSmartMemoryManager = this.mMemoryManager;
        if (semSmartMemoryManager != null) {
            semSmartMemoryManager.prepare();
        }
    }

    public final void release() {
        SemSmartMemoryManager semSmartMemoryManager = this.mMemoryManager;
        if (semSmartMemoryManager != null) {
            semSmartMemoryManager.release();
        }
    }

    public final void request() {
        SemSmartMemoryManager semSmartMemoryManager;
        SemMemRequest semMemRequest = this.mRequest;
        if (semMemRequest == null || (semSmartMemoryManager = this.mMemoryManager) == null) {
            return;
        }
        semSmartMemoryManager.request(semMemRequest);
    }

    public /* synthetic */ GenieMemoryManager(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 1 : i);
    }
}
