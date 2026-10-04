package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Size;
import android.util.TypedValue;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRenderer;
import com.samsung.android.sdk.pen.recogengine.hme.SpenHmeRendererSettings;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FormulaRenderer {
    private static final int FONT_SIZE_SP = 16;
    private static final float RENDER_SCALE = 1.0f;
    private static final String TAG = Logger.createTag("FormulaRenderer", AiConstants.PREFIX_TAG);

    public static Bitmap render(String str, String str2) {
        return render(str, str2, 16, BaseUtils.getApplicationContext().getColor(C9086R.color.solve_math_result_text_color));
    }

    private static Bitmap render(String str, String str2, int i, int i2) {
        String str3 = TAG;
        Logger.m10999d(str3, "render# latexContent " + Logger.getEncode(str));
        Context applicationContext = BaseUtils.getApplicationContext();
        float fApplyDimension = TypedValue.applyDimension(2, (float) i, applicationContext.getResources().getDisplayMetrics());
        int color = applicationContext.getColor(C9086R.color.solve_math_result_text_outline_color);
        SpenHmeRendererSettings spenHmeRendererSettings = new SpenHmeRendererSettings();
        spenHmeRendererSettings.setTextColor(i2);
        spenHmeRendererSettings.setBgColor(0);
        spenHmeRendererSettings.setOutline(true, color, 1.0f);
        SpenHmeRenderer spenHmeRenderer = new SpenHmeRenderer(str2, fApplyDimension, 160.0f, spenHmeRendererSettings);
        Size sizeLayout = spenHmeRenderer.layout(str);
        Logger.m10999d(str3, "render# size = " + sizeLayout + " by unitSize = " + fApplyDimension);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(sizeLayout.getWidth(), sizeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        spenHmeRenderer.render(bitmapCreateBitmap, new PointF(), 1.0f);
        spenHmeRenderer.close();
        return bitmapCreateBitmap;
    }
}
