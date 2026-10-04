package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DropContent {
    static final String CLIP_LABEL = "notes_clip_label";
    public static final int CLIP_LABEL_CID_INDEX = 1;
    public static final int CLIP_LABEL_CONTENT_TYPE_INDEX = 2;
    public static final int CLIP_LABEL_POS_INDEX = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OBJECT = 1;
    public static final int TYPE_OBJECT_SPAN = 3;
    public static final int TYPE_TEXT = 2;
    public int[] selection;
    public String plainText = "";
    public String htmlText = "";
    public ArrayList<Uri> uriList = new ArrayList<>();
    public ArrayList<SpenObjectBase> contentList = new ArrayList<>();
    public int contentType = 0;

    public static String[] parseClipLabel(String str, int i) {
        if (!TextUtils.isEmpty(str) && str.contains(CLIP_LABEL)) {
            String[] strArrSplit = str.split("/");
            if (strArrSplit.length == 4) {
                if (strArrSplit[1].equals(String.valueOf(i))) {
                    return strArrSplit;
                }
            }
        }
        return null;
    }

    public String createClipLabel(int i, int i2, @NotNull PointF pointF) {
        int[] iArr = {0, 0};
        int i4 = this.contentType;
        if (i4 == 2 || i4 == 3) {
            iArr = this.selection;
        }
        StartPosition startPosition = new StartPosition(i2, pointF, iArr);
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "notes_clip_label/", "/");
        sbM778t.append(this.contentType);
        sbM778t.append("/");
        sbM778t.append(startPosition.convertToString());
        return sbM778t.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StartPosition {
        public static final String SEPERATOR = ",";
        private final int mPageIndex;
        private final int mSelectionEnd;
        private final int mSelectionStart;
        private final float mStartX;
        private final float mStartY;

        public StartPosition(int i, @NotNull PointF pointF, @Size(2) int[] iArr) {
            this.mPageIndex = i;
            this.mStartX = pointF.x;
            this.mStartY = pointF.y;
            this.mSelectionStart = iArr[0];
            this.mSelectionEnd = iArr[1];
        }

        public String convertToString() {
            return this.mPageIndex + "," + this.mStartX + "," + this.mStartY + "," + this.mSelectionStart + "," + this.mSelectionEnd;
        }

        public int getPageIndex() {
            return this.mPageIndex;
        }

        public int getSelectionEnd() {
            return this.mSelectionEnd;
        }

        public int getSelectionStart() {
            return this.mSelectionStart;
        }

        public float getStartX() {
            return this.mStartX;
        }

        public float getStartY() {
            return this.mStartY;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("StartPosition{mPageIndex=");
            sb.append(this.mPageIndex);
            sb.append(", mStartX=");
            sb.append(this.mStartX);
            sb.append(", mStartY=");
            sb.append(this.mStartY);
            sb.append(", mSelectionStart=");
            sb.append(this.mSelectionStart);
            sb.append(", mSelectionEnd=");
            return AbstractC0000a.m13j(sb, this.mSelectionEnd, '}');
        }

        public StartPosition(String str) {
            String[] strArrSplit = str.split(",");
            this.mPageIndex = Integer.parseInt(strArrSplit[0]);
            this.mStartX = Float.parseFloat(strArrSplit[1]);
            this.mStartY = Float.parseFloat(strArrSplit[2]);
            this.mSelectionStart = Integer.parseInt(strArrSplit[3]);
            this.mSelectionEnd = Integer.parseInt(strArrSplit[4]);
        }
    }
}
