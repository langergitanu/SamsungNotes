package com.samsung.android.support.senl.p148nt.model.collector.recognition.data;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TextInfo {
    public static final int CONTENT_TYPE_HANDWRITING = 1;
    public static final int CONTENT_TYPE_TEXT = 0;
    public static final int LINK_TYPE_NONE = -1;
    public Rect lastCharRect;
    public Rect leftCharRect;
    public ArrayList<Integer> linkObjects;
    public String linkStr;
    public String originalStr;
    public String pageUuid;
    public int pageWidth;
    public ArrayList<Integer> recognizedObjects;
    public RectF rect;
    public String repObjectUuid;
    public String str;
    public int strokeColor;
    public Rect strokeRect;
    public int contentType = 0;
    public int linkType = -1;

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("originalStr: [");
        sb.append(this.originalStr);
        sb.append("], str: [");
        return AbstractC0622a.m1170p(this.str, "]", sb);
    }
}
