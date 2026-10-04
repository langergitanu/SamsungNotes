package com.samsung.android.sdk.pen.setting.util;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilOutlineProvider;", "", "<init>", "()V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilOutlineProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilOutlineProvider$Companion;", "", "<init>", "()V", "getCircleOutlineProvider", "Landroid/view/ViewOutlineProvider;", "getRoundRectOutlineProvider", "radius", "", "leftTopRadius", "rightTopRadius", "rightBottomRadius", "leftBottomRadius", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ViewOutlineProvider getCircleOutlineProvider() {
            return new ViewOutlineProvider() { // from class: com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOutlineProvider$Companion$getCircleOutlineProvider$1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(outline, "outline");
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            };
        }

        @NotNull
        public final ViewOutlineProvider getRoundRectOutlineProvider(float radius) {
            return getRoundRectOutlineProvider(radius, radius, radius, radius);
        }

        private Companion() {
        }

        @NotNull
        public final ViewOutlineProvider getRoundRectOutlineProvider(final float leftTopRadius, final float rightTopRadius, final float rightBottomRadius, final float leftBottomRadius) {
            return new ViewOutlineProvider() { // from class: com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOutlineProvider$Companion$getRoundRectOutlineProvider$1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(outline, "outline");
                    Path path = new Path();
                    RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
                    float f = leftTopRadius;
                    float f4 = rightTopRadius;
                    float f5 = rightBottomRadius;
                    float f6 = leftBottomRadius;
                    path.addRoundRect(rectF, new float[]{f, f, f4, f4, f5, f5, f6, f6}, Path.Direction.CW);
                    path.close();
                    if (Build.VERSION.SDK_INT >= 30) {
                        outline.setPath(path);
                    } else {
                        outline.setConvexPath(path);
                    }
                }
            };
        }
    }
}
