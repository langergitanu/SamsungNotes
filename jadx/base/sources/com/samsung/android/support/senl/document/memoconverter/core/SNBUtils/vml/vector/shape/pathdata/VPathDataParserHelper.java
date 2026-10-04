package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata;

import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPathDataParserHelper {

    /* JADX INFO: renamed from: n */
    private final int f5910n;
    public int pos;

    /* JADX INFO: renamed from: s */
    private final CharSequence f5911s;

    public VPathDataParserHelper(CharSequence charSequence, int i) {
        this.f5911s = charSequence;
        this.pos = i;
        this.f5910n = charSequence.length();
    }

    public static float getValueFromString(String str, float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        float sy;
        float height;
        if (str == null || str.length() <= 0) {
            return 0.0f;
        }
        if (str.startsWith(Log.TAG_SEPARATOR)) {
            int i = Integer.parseInt(str.substring(1, str.length()));
            if (fArr2 != null) {
                return fArr2[i];
            }
            return 0.0f;
        }
        if (str.startsWith(ContentUtils.HASH_SYMBOL)) {
            int i2 = Integer.parseInt(str.substring(1, str.length()));
            if (fArr != null) {
                return fArr[i2];
            }
            return 0.0f;
        }
        if (str.startsWith("width")) {
            return vAttributeCore.getCoordSize().getWidth();
        }
        if (str.startsWith("height")) {
            return vAttributeCore.getCoordSize().getHeight();
        }
        if (str.startsWith("xcenter")) {
            sy = vAttributeCore.getCoordOrigin().getSx();
            height = vAttributeCore.getCoordSize().getWidth();
        } else {
            if (!str.startsWith("ycenter")) {
                return VUtilString.parseFloat(str);
            }
            sy = vAttributeCore.getCoordOrigin().getSy();
            height = vAttributeCore.getCoordSize().getHeight();
        }
        return (height / 2.0f) + sy;
    }

    public ArrayList<Float> getFloatList(float[] fArr, float[] fArr2, VAttributeCore vAttributeCore, VAttributeShape vAttributeShape) {
        ArrayList<Float> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            char c = read();
            if (c == 0) {
                break;
            }
            if (c == ',') {
                if (sb.length() == 0) {
                    sb.append('0');
                }
                arrayList.add(Float.valueOf(getValueFromString(sb.toString(), fArr, fArr2, vAttributeCore, vAttributeShape)));
                sb = new StringBuilder();
            } else if (c == '@') {
                if (sb.length() > 0) {
                    arrayList.add(Float.valueOf(getValueFromString(sb.toString(), fArr, fArr2, vAttributeCore, vAttributeShape)));
                    sb = new StringBuilder();
                }
                sb.append(c);
            } else {
                sb.append(c);
            }
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        arrayList.add(Float.valueOf(getValueFromString(sb.toString(), fArr, fArr2, vAttributeCore, vAttributeShape)));
        return arrayList;
    }

    public ArrayList<Float> getIntegerList() {
        ArrayList<Float> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            char c = read();
            if (c == 0) {
                break;
            }
            if (c == ',') {
                if (sb.length() == 0) {
                    sb.append('0');
                }
                arrayList.add(Float.valueOf(VUtilString.parseFloat(sb.toString())));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        arrayList.add(Float.valueOf(VUtilString.parseFloat(sb.toString())));
        return arrayList;
    }

    public char read() {
        int i = this.pos;
        int i2 = this.f5910n;
        if (i < i2) {
            this.pos = i + 1;
        }
        int i4 = this.pos;
        if (i4 == i2) {
            return (char) 0;
        }
        return this.f5911s.charAt(i4);
    }
}
