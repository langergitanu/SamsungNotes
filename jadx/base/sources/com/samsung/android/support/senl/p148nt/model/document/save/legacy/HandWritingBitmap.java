package com.samsung.android.support.senl.p148nt.model.document.save.legacy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HandWritingBitmap {
    private static final float GRID_VIEW_HW_MIN_RATIO = 0.56f;
    private static final String TAG = DataLogger.createTag("HandWritingBitmap");
    private final Context mAppContext;
    private final Resources mResources;
    private Bitmap mFirstBitmap = null;
    private Bitmap mSecondBitmap = null;
    private boolean mNeedBackground = false;

    public HandWritingBitmap(@NonNull Context context) {
        this.mAppContext = context;
        this.mResources = context.getResources();
    }

    private Bitmap adjustThumbnail(RectF rectF, Bitmap bitmap, int i) {
        int height;
        int height2 = ((int) rectF.top) - (bitmap.getHeight() * i);
        if (height2 >= bitmap.getHeight()) {
            bitmap.recycle();
            String str = TAG;
            DataLogger.m12307i(str, "adjustThumbnail, jump to next thumbnail, next i: " + (((height2 / bitmap.getHeight()) - 1) + i));
            return null;
        }
        int i2 = ((int) (rectF.bottom - rectF.top)) + height2;
        if (i2 >= bitmap.getHeight() || i2 <= height2) {
            i2 = 0;
        }
        if (height2 > 0) {
            height = i2 > 0 ? i2 - height2 : bitmap.getHeight() - height2;
        } else if (i2 > 0) {
            height = i2;
            height2 = 0;
        } else {
            height = 0;
            height2 = 0;
        }
        String str2 = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(height2, i2, "adjustThumbnail, top: ", ", bottom: ", ", cropHeight: ");
        sbM1173s.append(height);
        sbM1173s.append(", mNeedBackground: ");
        AbstractC11014a.m12340y(sbM1173s, this.mNeedBackground, str2);
        if (height <= 0) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, height2, bitmap.getWidth(), height);
        if (!bitmap.equals(bitmapCreateBitmap)) {
            bitmap.recycle();
        }
        if (this.mFirstBitmap != null || i2 != 0 || bitmapCreateBitmap.getHeight() >= bitmapCreateBitmap.getWidth()) {
            return bitmapCreateBitmap;
        }
        this.mFirstBitmap = bitmapCreateBitmap;
        return null;
    }

    private Bitmap createBitmapFromThumbnailPath(String str) {
        if (!str.endsWith(".spi")) {
            if (!str.endsWith(".jpg")) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        this.mNeedBackground = true;
        try {
            return ImageUtils.decodeSpi(str);
        } catch (Throwable th) {
            DataLogger.m12303e(TAG, "createBitmapFromThumbnailPath, decodeSpi : " + th.getMessage());
            return null;
        }
    }

    public static Bitmap createResultBitmap(@NonNull Context context, SpenContentHandWriting spenContentHandWriting, List<String> list) {
        return new HandWritingBitmap(context).getResultBitmap(spenContentHandWriting, list);
    }

    private boolean drawBitmap(Bitmap bitmap, RectF rectF) {
        if (rectF != null) {
            DataLogger.m12307i(TAG, "drawBitmap, objectRect: " + rectF.toShortString());
            return false;
        }
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            return false;
        }
        this.mFirstBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
        DataLogger.m12307i(TAG, "drawBitmap, newBitmap width: " + this.mFirstBitmap.getWidth() + ", height: " + this.mFirstBitmap.getHeight());
        Canvas canvas = new Canvas(this.mFirstBitmap);
        canvas.drawColor(this.mResources.getColor(C8875R.color.composer_main_background, null));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return true;
    }

    private void eraseBackgroundColor(Bitmap bitmap, int i) {
        if (i == this.mResources.getColor(C8875R.color.background_color_black, null)) {
            i = Color.parseColor("#333333");
        }
        bitmap.eraseColor(i);
    }

    private Bitmap getDoublePageBitmap(int i) {
        Bitmap bitmapCreateBitmap = this.mFirstBitmap;
        int width = (this.mFirstBitmap.getWidth() * this.mSecondBitmap.getHeight()) / this.mSecondBitmap.getWidth();
        Bitmap.Config config = this.mFirstBitmap.getConfig();
        if (config != null) {
            bitmapCreateBitmap = Bitmap.createBitmap(this.mFirstBitmap.getWidth(), this.mFirstBitmap.getHeight() + width, config);
            if (this.mNeedBackground) {
                eraseBackgroundColor(bitmapCreateBitmap, i);
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(this.mFirstBitmap, new Rect(0, 0, this.mFirstBitmap.getWidth(), this.mFirstBitmap.getHeight()), new Rect(0, 0, this.mFirstBitmap.getWidth(), this.mFirstBitmap.getHeight()), (Paint) null);
            canvas.drawBitmap(this.mSecondBitmap, new Rect(0, 0, this.mSecondBitmap.getWidth(), this.mSecondBitmap.getHeight()), new Rect(0, this.mFirstBitmap.getHeight(), this.mFirstBitmap.getWidth(), this.mFirstBitmap.getHeight() + width), (Paint) null);
        }
        this.mFirstBitmap.recycle();
        this.mSecondBitmap.recycle();
        return bitmapCreateBitmap;
    }

    private float getObjectRectTop(int i, String str) {
        SpenNoteDoc spenNoteDocMakeSpenNoteDoc = null;
        try {
            try {
                spenNoteDocMakeSpenNoteDoc = DocumentConstructor.makeSpenNoteDoc(this.mAppContext, str, i, 0);
                float f = spenNoteDocMakeSpenNoteDoc.getPage(0).getDrawnRectOfAllObject().top;
                try {
                    spenNoteDocMakeSpenNoteDoc.close(true);
                    return f;
                } catch (IOException e) {
                    AbstractC11014a.m12332q(e, new StringBuilder("fail to close doc : "), TAG);
                    return f;
                }
            } catch (Exception e2) {
                DataLogger.m12303e(TAG, "getObjectRectTop, fail to setup doc, e: " + e2.getMessage());
                if (spenNoteDocMakeSpenNoteDoc != null) {
                    try {
                        spenNoteDocMakeSpenNoteDoc.close(true);
                    } catch (IOException e3) {
                        AbstractC11014a.m12332q(e3, new StringBuilder("fail to close doc : "), TAG);
                    }
                }
                return 0.0f;
            }
        } catch (Throwable th) {
            if (spenNoteDocMakeSpenNoteDoc != null) {
                try {
                    spenNoteDocMakeSpenNoteDoc.close(true);
                } catch (IOException e5) {
                    AbstractC11014a.m12332q(e5, new StringBuilder("fail to close doc : "), TAG);
                }
            }
            throw th;
        }
    }

    private Bitmap getSinglePageBitmap(int i) {
        Bitmap bitmap = this.mFirstBitmap;
        if (!this.mNeedBackground) {
            return bitmap;
        }
        int width = ((float) bitmap.getHeight()) / ((float) this.mFirstBitmap.getWidth()) < GRID_VIEW_HW_MIN_RATIO ? (int) (this.mFirstBitmap.getWidth() * GRID_VIEW_HW_MIN_RATIO) : this.mFirstBitmap.getHeight();
        Bitmap.Config config = this.mFirstBitmap.getConfig();
        if (config == null) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.mFirstBitmap.getWidth(), width, config);
        eraseBackgroundColor(bitmapCreateBitmap, i);
        new Canvas(bitmapCreateBitmap).drawBitmap(this.mFirstBitmap, 0.0f, 0.0f, (Paint) null);
        this.mFirstBitmap.recycle();
        return bitmapCreateBitmap;
    }

    private void setThumbnailBitmap(SpenContentHandWriting spenContentHandWriting, List<String> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                Bitmap bitmapCreateBitmapFromThumbnailPath = createBitmapFromThumbnailPath(str);
                if (bitmapCreateBitmapFromThumbnailPath != null) {
                    RectF objectRect = spenContentHandWriting.getObjectRect();
                    if (drawBitmap(bitmapCreateBitmapFromThumbnailPath, objectRect)) {
                        break;
                    }
                    if (i == 0 && objectRect.top == 0.0f) {
                        objectRect.top = getObjectRectTop((int) objectRect.width(), spenContentHandWriting.getAttachedFile());
                    }
                    bitmapCreateBitmapFromThumbnailPath = adjustThumbnail(objectRect, bitmapCreateBitmapFromThumbnailPath, i);
                    if (bitmapCreateBitmapFromThumbnailPath == null) {
                        continue;
                    }
                }
                if (this.mFirstBitmap != null) {
                    this.mSecondBitmap = bitmapCreateBitmapFromThumbnailPath;
                    break;
                }
                this.mFirstBitmap = bitmapCreateBitmapFromThumbnailPath;
            } else {
                sb.append("getThumbnailBitmap, thumbnail path is empty, continue, i: ");
                sb.append(i);
                sb.append('\n');
            }
            i++;
        }
        DataLogger.m12307i(TAG, sb.toString());
    }

    @VisibleForTesting
    public Bitmap getResultBitmap(SpenContentHandWriting spenContentHandWriting, List<String> list) {
        setThumbnailBitmap(spenContentHandWriting, list);
        if (this.mFirstBitmap == null) {
            return null;
        }
        return this.mSecondBitmap == null ? getSinglePageBitmap(spenContentHandWriting.getBackgroundColor()) : getDoublePageBitmap(spenContentHandWriting.getBackgroundColor());
    }
}
