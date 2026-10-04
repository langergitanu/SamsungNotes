package com.samsung.android.sdk.pen.recogengine.preload.hmeocr;

import android.graphics.Point;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010)\u001a\u00020*2\u0006\u0010)\u001a\u00020+R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RL\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR0\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b\u001c\u0010$R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010,\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b-\u0010(¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrResult;", "", "<init>", "()V", "mResultList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrResultItem;", "Lkotlin/collections/ArrayList;", "mRect", "", "Landroid/graphics/Point;", "[Landroid/graphics/Point;", "uID", "", "getUID", "()J", "setUID", "(J)V", "clear", "", "add", "data", Constants.JTAG_DATA_LIST, "resultList", "getResultList", "()Ljava/util/ArrayList;", "setResultList", "(Ljava/util/ArrayList;)V", "setRect", "rect", "", "len", "", "blockRect", "getRect", "()[Landroid/graphics/Point;", "([Landroid/graphics/Point;)V", "rectInfo", "", "getRectInfo", "()Ljava/lang/String;", WiggleAnimationConfig.KEY_SCALE, "", "", "text", "getText", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenHmeOcrResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenHmeOcrResult.kt\ncom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrResult\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,100:1\n107#2:101\n79#2,22:102\n*S KotlinDebug\n*F\n+ 1 SpenHmeOcrResult.kt\ncom/samsung/android/sdk/pen/recogengine/preload/hmeocr/SpenHmeOcrResult\n*L\n93#1:101\n93#1:102,22\n*E\n"})
public final class SpenHmeOcrResult {

    @NotNull
    private static final String TAG = "SpenHmeOcrResult";

    @NotNull
    private Point[] mRect;

    @Nullable
    private ArrayList<SpenHmeOcrResultItem> mResultList = new ArrayList<>();
    private long uID;

    public SpenHmeOcrResult() {
        Point[] pointArr = new Point[4];
        for (int i = 0; i < 4; i++) {
            pointArr[i] = new Point();
        }
        this.mRect = pointArr;
    }

    public final void add(@NotNull SpenHmeOcrResultItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<SpenHmeOcrResultItem> arrayList = this.mResultList;
        if (arrayList != null) {
            arrayList.add(data);
        }
    }

    public final void clear() {
        ArrayList<SpenHmeOcrResultItem> arrayList = this.mResultList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: getRect, reason: from getter */
    public final Point[] getMRect() {
        return this.mRect;
    }

    @NotNull
    public final String getRectInfo() {
        StringBuilder sb = new StringBuilder();
        for (Point point : this.mRect) {
            sb.append("(");
            sb.append(point.x);
            sb.append(SQLKeyword.COMMA);
            sb.append(point.y);
            sb.append(") ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Nullable
    public final ArrayList<SpenHmeOcrResultItem> getResultList() {
        return this.mResultList;
    }

    @NotNull
    public final String getText() {
        StringBuilder sb = new StringBuilder();
        ArrayList<SpenHmeOcrResultItem> arrayList = this.mResultList;
        if (arrayList != null) {
            Iterator<SpenHmeOcrResultItem> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenHmeOcrResultItem next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                sb.append(next.getLatexValue());
                sb.append("\n");
            }
        }
        String str = new String(sb);
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public final long getUID() {
        return this.uID;
    }

    public final boolean scale(float scale) {
        for (Point point : this.mRect) {
            point.x = (int) (point.x * scale);
            point.y = (int) (point.y * scale);
        }
        ArrayList<SpenHmeOcrResultItem> arrayList = this.mResultList;
        if (arrayList == null) {
            return true;
        }
        Iterator<SpenHmeOcrResultItem> it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenHmeOcrResultItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (!next.scale(scale)) {
                return false;
            }
        }
        return true;
    }

    public final void setRect(@NotNull int[] rect, int len) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (len < 8) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(AbstractC0000a.m11h(len, "SpenHmeOcrResult::setRect rect(int array)'s length is "), Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            Log.e(TAG, str);
            return;
        }
        Log.d(TAG, "SpenHmeOcrResult::setRect len : " + len + ", length : " + rect.length);
        Point[] pointArr = {new Point(rect[0], rect[1]), new Point(rect[2], rect[3]), new Point(rect[4], rect[5]), new Point(rect[6], rect[7])};
        this.mRect = pointArr;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{Integer.valueOf(pointArr[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)}, 8, "SpenHmeOcrResult::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]", "format(format, *args)", TAG);
    }

    public final void setResultList(@Nullable ArrayList<SpenHmeOcrResultItem> arrayList) {
        ArrayList<SpenHmeOcrResultItem> arrayList2;
        if (arrayList == null || (arrayList2 = this.mResultList) == null) {
            return;
        }
        arrayList2.addAll(arrayList);
    }

    public final void setUID(long j) {
        this.uID = j;
    }

    public final void setRect(@NotNull Point[] blockRect) {
        Intrinsics.checkNotNullParameter(blockRect, "blockRect");
        this.mRect = blockRect;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4760u(new Object[]{Integer.valueOf(blockRect[0].x), Integer.valueOf(this.mRect[0].y), Integer.valueOf(this.mRect[1].x), Integer.valueOf(this.mRect[1].y), Integer.valueOf(this.mRect[2].x), Integer.valueOf(this.mRect[2].y), Integer.valueOf(this.mRect[3].x), Integer.valueOf(this.mRect[3].y)}, 8, "SpenHmeOcrResult::setRect [LT(%d, %d), RT(%d, %d), RB(%d, %d), LB(%d, %d)]: %s", "format(format, *args)", TAG);
    }
}
