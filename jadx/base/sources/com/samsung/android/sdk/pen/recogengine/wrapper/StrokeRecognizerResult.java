package com.samsung.android.sdk.pen.recogengine.wrapper;

import android.graphics.RectF;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 '2\u00020\u0001:\u0001'B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u0002\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\bJ\u001e\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005H\u0007J\u0006\u0010&\u001a\u00020\u0017R\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerResult;", "", "<init>", "()V", "textString", "", "resultIndices", "", "", "spenObjects", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "value", "getTextString", "()Ljava/lang/String;", "Landroid/graphics/RectF;", "rect", "getRect", "()Landroid/graphics/RectF;", "mStrokeObjects", "", "mStrokeIndices", "init", "", "strokeObjects", "getStrokeObjects", "()Ljava/util/List;", "strokeIndices", "getStrokeIndices", "strokeCount", "getStrokeCount", "()I", "getResultString", "tag", "totalStrokeCount", "merge", "result", "separator", "sortStrokeIndices", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStrokeRecognizerResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrokeRecognizerResult.kt\ncom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerResult\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n37#2,2:119\n1#3:121\n*S KotlinDebug\n*F\n+ 1 StrokeRecognizerResult.kt\ncom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerResult\n*L\n52#1:119,2\n*E\n"})
public final class StrokeRecognizerResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private List<Integer> mStrokeIndices;

    @NotNull
    private List<SpenObjectStroke> mStrokeObjects;

    @NotNull
    private RectF rect;

    @NotNull
    private String textString;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerResult$Companion;", "", "<init>", "()V", "mergeResults", "Lcom/samsung/android/sdk/pen/recogengine/wrapper/StrokeRecognizerResult;", "r1", "r2", "getCombinedRectOf", "Landroid/graphics/RectF;", "strokes", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RectF getCombinedRectOf(@Nullable List<SpenObjectStroke> strokes) {
            RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
            List<SpenObjectStroke> list = strokes;
            if (list != null && !list.isEmpty()) {
                for (SpenObjectStroke spenObjectStroke : strokes) {
                    if (spenObjectStroke != null) {
                        rectF.union(spenObjectStroke.getRect());
                    }
                }
            }
            return rectF;
        }

        @NotNull
        public final StrokeRecognizerResult mergeResults(@NotNull StrokeRecognizerResult r12, @NotNull StrokeRecognizerResult r2) {
            Intrinsics.checkNotNullParameter(r12, "r1");
            Intrinsics.checkNotNullParameter(r2, "r2");
            StrokeRecognizerResult strokeRecognizerResult = new StrokeRecognizerResult();
            StrokeRecognizerResult.merge$default(strokeRecognizerResult, r12, null, 2, null);
            StrokeRecognizerResult.merge$default(strokeRecognizerResult, r2, null, 2, null);
            return strokeRecognizerResult;
        }

        private Companion() {
        }
    }

    public StrokeRecognizerResult() {
        this.textString = "";
        this.rect = new RectF();
        this.textString = "";
        this.rect = new RectF();
        this.mStrokeObjects = new ArrayList();
        this.mStrokeIndices = new ArrayList();
    }

    public static /* synthetic */ void merge$default(StrokeRecognizerResult strokeRecognizerResult, StrokeRecognizerResult strokeRecognizerResult2, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "\n";
        }
        strokeRecognizerResult.merge(strokeRecognizerResult2, str);
    }

    @NotNull
    public final RectF getRect() {
        return this.rect;
    }

    @Nullable
    public final String getResultString(@Nullable String tag, int totalStrokeCount) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strM12323h = AbstractC11014a.m12323h(new Object[]{tag, Integer.valueOf(this.mStrokeIndices.size()), Integer.valueOf(totalStrokeCount)}, 3, Locale.getDefault(), "%s(%d/%d) : ", "format(locale, format, *args)");
        if (this.textString.length() > 0) {
            strM12323h = AbstractC2821a.m2221l(strM12323h, "\"", this.textString, "\" ");
        }
        String strM12323h2 = AbstractC11014a.m12323h(new Object[]{Float.valueOf(this.rect.width()), Float.valueOf(this.rect.left), Float.valueOf(this.rect.right), Float.valueOf(this.rect.height()), Float.valueOf(this.rect.top), Float.valueOf(this.rect.bottom)}, 6, Locale.getDefault(), "W=%.0f(%.0f~%.0f), H=%.0f(%.0f~%.0f)", "format(locale, format, *args)");
        StringBuilder sb = new StringBuilder();
        sb.append(strM12323h);
        sb.append(strM12323h2);
        Intrinsics.checkNotNullExpressionValue(Arrays.toString(this.mStrokeIndices.toArray(new Integer[0])), "toString(this)");
        return null;
    }

    public final int getStrokeCount() {
        return this.mStrokeIndices.size();
    }

    @NotNull
    public final List<Integer> getStrokeIndices() {
        return this.mStrokeIndices;
    }

    @NotNull
    public final List<SpenObjectStroke> getStrokeObjects() {
        return this.mStrokeObjects;
    }

    @NotNull
    public final String getTextString() {
        return this.textString;
    }

    public final void init() {
    }

    @JvmOverloads
    public final void merge(@Nullable StrokeRecognizerResult strokeRecognizerResult) {
        merge$default(this, strokeRecognizerResult, null, 2, null);
    }

    public final void sortStrokeIndices() {
        HashMap map = new HashMap();
        int size = this.mStrokeIndices.size();
        for (int i = 0; i < size; i++) {
            map.put(this.mStrokeIndices.get(i), this.mStrokeObjects.get(i));
        }
        CollectionsKt.sort(this.mStrokeIndices);
        this.mStrokeObjects.clear();
        Iterator<Integer> it = this.mStrokeIndices.iterator();
        while (it.hasNext()) {
            SpenObjectStroke spenObjectStroke = (SpenObjectStroke) map.get(Integer.valueOf(it.next().intValue()));
            if (spenObjectStroke != null) {
                this.mStrokeObjects.add(spenObjectStroke);
            }
        }
    }

    @JvmOverloads
    public final void merge(@Nullable StrokeRecognizerResult result, @Nullable String separator) {
        if (result == null) {
            return;
        }
        if (this.textString.length() > 0 && result.textString.length() > 0) {
            if (separator != null && separator.length() != 0) {
                this.textString = AbstractC0541b.m756B(this.textString, separator);
            }
            this.textString = AbstractC0541b.m756B(this.textString, result.textString);
        }
        if (this.rect.isEmpty()) {
            this.rect = result.rect;
        } else {
            this.rect.union(result.rect);
        }
        this.mStrokeObjects.addAll(result.mStrokeObjects);
        this.mStrokeIndices.addAll(result.mStrokeIndices);
    }

    public StrokeRecognizerResult(@NotNull String textString, @NotNull List<Integer> resultIndices, @NotNull List<SpenObjectStroke> spenObjects) {
        Intrinsics.checkNotNullParameter(textString, "textString");
        Intrinsics.checkNotNullParameter(resultIndices, "resultIndices");
        Intrinsics.checkNotNullParameter(spenObjects, "spenObjects");
        this.textString = "";
        this.rect = new RectF();
        this.textString = textString;
        this.mStrokeIndices = new ArrayList(resultIndices);
        ArrayList arrayList = new ArrayList(spenObjects);
        this.mStrokeObjects = arrayList;
        this.rect = INSTANCE.getCombinedRectOf(arrayList);
    }
}
