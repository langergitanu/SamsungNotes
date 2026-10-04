package com.samsung.android.support.senl.p148nt.model.base.utils.math;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Size;
import android.util.TypedValue;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRenderer;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRendererSettings;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/base/utils/math/MathHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "render", "Landroid/graphics/Bitmap;", "latexContent", "fontPath", "fontSize", "", "fontColor", "fontOutlineColor", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMathHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MathHelper.kt\ncom/samsung/android/support/senl/nt/model/base/utils/math/MathHelper\n+ 2 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,62:1\n84#2,6:63\n*S KotlinDebug\n*F\n+ 1 MathHelper.kt\ncom/samsung/android/support/senl/nt/model/base/utils/math/MathHelper\n*L\n56#1:63,6\n*E\n"})
public final class MathHelper {

    @NotNull
    public static final MathHelper INSTANCE = new MathHelper();
    private static final String TAG = ModelLogger.createTag("MathHelper");

    private MathHelper() {
    }

    @Nullable
    public final Bitmap render(@NotNull String latexContent, @NotNull String fontPath) {
        Intrinsics.checkNotNullParameter(latexContent, "latexContent");
        Intrinsics.checkNotNullParameter(fontPath, "fontPath");
        return render(latexContent, fontPath, 8, -16777216, -1);
    }

    @Nullable
    public final Bitmap render(@NotNull String latexContent, @NotNull String fontPath, int fontSize, int fontColor, int fontOutlineColor) {
        Intrinsics.checkNotNullParameter(latexContent, "latexContent");
        Intrinsics.checkNotNullParameter(fontPath, "fontPath");
        String str = TAG;
        DataLogger.m12302d(str, "render# latexContent " + DataLogger.getEncode(latexContent));
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        float fApplyDimension = TypedValue.applyDimension(1, fontSize, applicationContext.getResources().getDisplayMetrics());
        SpenHmeRendererSettings spenHmeRendererSettings = new SpenHmeRendererSettings();
        spenHmeRendererSettings.setTextColor(fontColor);
        spenHmeRendererSettings.setBgColor(0);
        float fConvertDpToPixel = ResourceUtils.convertDpToPixel(applicationContext, 1.0f);
        spenHmeRendererSettings.setOutline(true, fontOutlineColor, fConvertDpToPixel);
        SpenHmeRenderer spenHmeRenderer = new SpenHmeRenderer(fontPath, fApplyDimension, 160.0f, spenHmeRendererSettings);
        Size sizeLayout = spenHmeRenderer.layout(latexContent);
        DataLogger.m12302d(str, "render# size = " + sizeLayout + " by unitSize = " + fApplyDimension);
        if (sizeLayout.getWidth() == 0 || sizeLayout.getHeight() == 0) {
            return null;
        }
        int i = (int) (4 * fConvertDpToPixel);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizeLayout.getWidth() + i, sizeLayout.getHeight() + i, Bitmap.Config.ARGB_8888);
        float f = fConvertDpToPixel * 2;
        spenHmeRenderer.render(bitmapCreateBitmap, new PointF(f, f), 1.0f);
        spenHmeRenderer.close();
        return bitmapCreateBitmap;
    }
}
