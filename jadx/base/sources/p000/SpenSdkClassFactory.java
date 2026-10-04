package p000;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.sdk.wrapper.SpenSDocFileCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"LSpenSdkClassFactory;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "asSpenSDocFile", "Lcom/samsung/android/support/senl/nt/base/common/sdk/wrapper/SpenSDocFileCompat;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenSdkClassFactory {

    @NotNull
    private static final String TAG = "SpenSdkClassFactory";

    @NotNull
    private final Context mContext;

    public SpenSdkClassFactory(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    @NotNull
    public final SpenSDocFileCompat asSpenSDocFile() {
        return SpenSDocFileCompat.INSTANCE.m8642of(this.mContext);
    }
}
