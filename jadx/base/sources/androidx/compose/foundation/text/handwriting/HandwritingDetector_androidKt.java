package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.p109ui.Modifier;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, m13886d2 = {"handwritingDetector", "Landroidx/compose/ui/Modifier;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lkotlin/Function0;", "", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class HandwritingDetector_androidKt {
    @NotNull
    public static final Modifier handwritingDetector(@NotNull Modifier modifier, @NotNull Function0<Unit> function0) {
        return StylusHandwriting_androidKt.isStylusHandwritingSupported() ? PaddingKt.m15855paddingVpY3zN4(modifier.then(new HandwritingDetectorElement(function0)), StylusHandwritingKt.getHandwritingBoundsHorizontalOffset(), StylusHandwritingKt.getHandwritingBoundsVerticalOffset()) : modifier;
    }
}
