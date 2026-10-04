package com.samsung.android.imagetranslation.data;

import android.graphics.Bitmap;
import com.samsung.android.imagetranslation.LttEngineListener;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RenderParam {
    private String destLanguage;
    private String imageFormat;
    private Bitmap inPaintedBitmap;
    private Bitmap inputBitmap;
    private LttEngineListener lttEngineListener;
    private LttOcrResult lttOcrResult;
    private List<String> trlResult;

    public String getDestLanguage() {
        return this.destLanguage;
    }

    public String getImageFormat() {
        return this.imageFormat;
    }

    public Bitmap getInPaintedBitmap() {
        return this.inPaintedBitmap;
    }

    public Bitmap getInputBitmap() {
        return this.inputBitmap;
    }

    public LttEngineListener getLttEngineListener() {
        return this.lttEngineListener;
    }

    public LttOcrResult getLttOcrResult() {
        return this.lttOcrResult;
    }

    public List<String> getTrlResult() {
        return this.trlResult;
    }

    public void setDestLanguage(String str) {
        this.destLanguage = str;
    }

    public void setImageFormat(String str) {
        this.imageFormat = str;
    }

    public void setInPaintedBitmap(Bitmap bitmap) {
        this.inPaintedBitmap = bitmap;
    }

    public void setInputBitmap(Bitmap bitmap) {
        this.inputBitmap = bitmap;
    }

    public void setLttEngineListener(LttEngineListener lttEngineListener) {
        this.lttEngineListener = lttEngineListener;
    }

    public void setLttOcrResult(LttOcrResult lttOcrResult) {
        this.lttOcrResult = lttOcrResult;
    }

    public void setTrlResult(List<String> list) {
        this.trlResult = list;
    }
}
