package com.samsung.android.support.senl.p148nt.model.assist.lvm;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.AiWaterMarkUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ImageMaker extends Operator {
    private final Context mContext;
    private Contract mContract;
    private int mDocumentWidth = 0;
    protected String mImageStyle;
    protected float mScribbleWeightValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getDocumentWidth();
    }

    public ImageMaker(@NonNull Context context) {
        this.mContext = context;
    }

    private int getDocumentWidth() {
        if (this.mDocumentWidth <= 0) {
            this.mDocumentWidth = this.mContract.getDocumentWidth();
        }
        return this.mDocumentWidth;
    }

    public abstract String getTAG();

    @Override // com.samsung.android.support.senl.p148nt.model.assist.lvm.Operator
    @Nullable
    public Bitmap postProcessing(@Nullable Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int documentWidth = getDocumentWidth();
        int width = bitmap.getWidth();
        String tag = getTAG();
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "postProcessing, idx: ", " start, content byte size: ");
        sbM778t.append(bitmap.getAllocationByteCount());
        sbM778t.append(", documentWidth: ");
        sbM778t.append(documentWidth);
        sbM778t.append(", contentWidth: ");
        sbM778t.append(width);
        Logger.m8697d(tag, sbM778t.toString());
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        AiWaterMarkUtil.drawVisibleWaterMarkToImage(this.mContext, C11397R.drawable.ai_drawing_watermark_logo, CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? C11397R.string.ai_drawing_water_mark_msg_chn : C11397R.string.ai_drawing_water_mark_msg, bitmapCopy, Math.min(documentWidth, width));
        Logger.m8697d(getTAG(), "postProcessing, idx: " + i + " end");
        return bitmapCopy;
    }

    public void setContract(@NonNull Contract contract) {
        this.mContract = contract;
    }

    public void setImageStyle(@NonNull String str) {
        this.mImageStyle = str;
    }

    public void setScribbleWeightValue(float f) {
        this.mScribbleWeightValue = f;
    }
}
