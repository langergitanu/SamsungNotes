package androidx.compose.p109ui.graphics;

import kotlin.Metadata;
import kotlin.PublishedApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, m13886d2 = {"RadiansToDegrees", "", "degrees", "radians", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DegreesKt {
    private static final float RadiansToDegrees = 57.29578f;

    @PublishedApi
    public static final float degrees(float f) {
        return f * RadiansToDegrees;
    }
}
