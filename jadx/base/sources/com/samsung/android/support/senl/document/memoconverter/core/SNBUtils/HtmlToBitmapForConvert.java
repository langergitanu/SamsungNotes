package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.VGraphics;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.parser.pull.VmlPullParser;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilBitmap;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HtmlToBitmapForConvert {
    private static final String TAG = "HtmlToBitmapForConvert";
    public static Bitmap mShapeBitmap;
    public static Bitmap mirror;

    public static Bitmap getShapeBitmap(Context context, String str, float f, String str2, String str3, float f4, float f5, float f6, float f7, int i) {
        InputStream inputStreamOpen;
        DocumentLogger.m7181i(TAG, "getShapeBitmap");
        if (context == null) {
            DocumentLogger.m7181i(TAG, "mContext is null");
            return null;
        }
        AssetManager assets = context.getAssets();
        DocumentLogger.m7181i(TAG, "get mVmlCode start");
        try {
            inputStreamOpen = assets.open(str);
        } catch (IOException unused) {
            inputStreamOpen = null;
        }
        try {
            int iAvailable = inputStreamOpen.available();
            if (iAvailable <= 0) {
                inputStreamOpen.close();
                return null;
            }
            byte[] bArr = new byte[iAvailable];
            if (inputStreamOpen.read(bArr) <= 0) {
                inputStreamOpen.close();
                return null;
            }
            inputStreamOpen.close();
            String str4 = new String(bArr, 0, iAvailable, "UTF-8");
            DocumentLogger.m7181i(TAG, "get mVmlCode done");
            VmlPullParser vmlPullParser = new VmlPullParser();
            vmlPullParser.setVmlData(str4);
            vmlPullParser.parse();
            ArrayList<VMetaDataInfo> metaDataInfos = vmlPullParser.getMetaDataInfos();
            VGraphics vGraphics = new VGraphics();
            vGraphics.setMetaDataInfos(metaDataInfos);
            vGraphics.setStrokeSize(f);
            vGraphics.setStrokeColor(str2);
            vGraphics.setFillColor(str3);
            DocumentLogger.m7181i(TAG, "stroke color : " + str2 + " / fill color : " + str3);
            if (str.equals("preload/shape/panel_shape_icon_01_01_normal.html") || str.equals("preload/shape/panel_shape_icon_01_02_normal.html") || str.equals("preload/shape/panel_shape_icon_01_03_normal.html")) {
                vGraphics.setIsLineObject(true);
                if (str.equals("preload/shape/panel_shape_icon_01_02_normal.html")) {
                    vGraphics.setIsArrowEd(true);
                } else if (str.equals("preload/shape/panel_shape_icon_01_03_normal.html")) {
                    vGraphics.setIsArrowSt(true);
                    vGraphics.setIsArrowEd(true);
                }
            } else {
                vGraphics.setIsLineObject(false);
            }
            if (vGraphics.getIsLineObject()) {
                mShapeBitmap = vGraphics.makeLineBitmap((int) f4, (int) f5, (int) f6, (int) f7);
            } else {
                vGraphics.makePictureDrawable(new RectF(f4, f5, f6, f7));
                PictureDrawable pictureDrawable = vGraphics.getPictureDrawable();
                if (pictureDrawable != null) {
                    mShapeBitmap = VUtilBitmap.toBitmap(pictureDrawable);
                }
            }
            if (i == 0) {
                return mShapeBitmap;
            }
            Bitmap bitmap = mShapeBitmap;
            if (bitmap == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = mShapeBitmap.getHeight();
            Matrix matrix = new Matrix();
            if (i == 1) {
                matrix.preScale(1.0f, -1.0f);
            } else if (i == 2) {
                matrix.preScale(-1.0f, 1.0f);
            } else if (i == 3) {
                matrix.preScale(-1.0f, -1.0f);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(mShapeBitmap, 0, 0, width, height, matrix, false);
            mirror = bitmapCreateBitmap;
            return bitmapCreateBitmap;
        } catch (IOException unused2) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (IOException unused3) {
                }
            }
            return null;
        }
    }
}
