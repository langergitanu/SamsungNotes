package kotlinx.parcelize;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, m13886d2 = {"parcelableCreator", "Landroid/os/Parcelable$Creator;", "T", "Landroid/os/Parcelable;", "parcelize-runtime"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ParcelableCreatorKt {
    public static final /* synthetic */ <T extends Parcelable> Parcelable.Creator<T> parcelableCreator() throws IllegalAccessException {
        Intrinsics.reifiedOperationMarker(4, "T");
        Object obj = Parcelable.class.getDeclaredField("CREATOR").get(null);
        Parcelable.Creator<T> creator = obj instanceof Parcelable.Creator ? (Parcelable.Creator) obj : null;
        if (creator != null) {
            return creator;
        }
        StringBuilder sb = new StringBuilder("Could not access CREATOR field in class ");
        Intrinsics.reifiedOperationMarker(4, "T");
        sb.append(Reflection.getOrCreateKotlinClass(Parcelable.class).getSimpleName());
        throw new IllegalArgumentException(sb.toString());
    }
}
