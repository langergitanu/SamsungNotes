package androidx.core.widget;

import android.os.Parcel;
import androidx.core.widget.RemoteViewsCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: androidx.core.widget.RemoteViewsCompatService$RemoteViewsCompatServiceData$Companion$create$2 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public /* synthetic */ class C2484xa6c0a158 extends FunctionReferenceImpl implements Function2<Parcel, Integer, Unit> {
    public C2484xa6c0a158(Object obj) {
        super(2, obj, RemoteViewsCompat.RemoteCollectionItems.class, "writeToParcel", "writeToParcel$core_remoteviews_release(Landroid/os/Parcel;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Parcel parcel, Integer num) {
        invoke(parcel, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Parcel p0, int i) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((RemoteViewsCompat.RemoteCollectionItems) this.receiver).writeToParcel$core_remoteviews_release(p0, i);
    }
}
