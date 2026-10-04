package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0014J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120'2\u0006\u0010(\u001a\u00020\nH\u0002¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\u00020\u00122\n\u0010+\u001a\u00060,j\u0002`-2\u0006\u0010.\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/widget/VerticalTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDegree", "", "mAllTextBounds", "Landroid/graphics/Rect;", "mLineTextBounds", "mPath", "Landroid/graphics/Path;", "mSplitText", "", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "measureWidth", "measureSpec", "measureHeight", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawSingleLineText", "drawMultiLineText", "setSplitText", "", "text", "width", "height", "makeWordList", "", "strArr", "", "size", "([Ljava/lang/String;I)Ljava/util/List;", "splitSubText", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "temp", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nVerticalTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VerticalTextView.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/view/widget/VerticalTextView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,258:1\n739#2,9:259\n37#3:268\n36#3,3:269\n*S KotlinDebug\n*F\n+ 1 VerticalTextView.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/view/widget/VerticalTextView\n*L\n193#1:259,9\n193#1:268\n193#1:269,3\n*E\n"})
public final class VerticalTextView extends TextView {
    private static final int ROTATION_0 = 0;
    private static final int ROTATION_180 = 180;
    private static final int ROTATION_270 = 270;
    private static final int ROTATION_90 = 90;

    @NotNull
    private final Rect mAllTextBounds;
    private int mDegree;

    @NotNull
    private final Rect mLineTextBounds;

    @NotNull
    private final Path mPath;

    @NotNull
    private final List<String> mSplitText;

    @NotNull
    private static final String TAG = SOLogger.createTag("VerticalTextView");

    public VerticalTextView(@Nullable Context context) {
        super(context);
        this.mDegree = 90;
        this.mAllTextBounds = new Rect();
        this.mLineTextBounds = new Rect();
        this.mPath = new Path();
        this.mSplitText = new ArrayList();
    }

    private final void drawMultiLineText(Canvas canvas) {
        canvas.save();
        getPaint().setColor(getCurrentTextColor());
        int size = this.mSplitText.size();
        int width = getWidth() / size;
        int height = getHeight() / size;
        int paddingStart = 0;
        int iHeight = 0;
        int width2 = 0;
        int paddingTop = 0;
        for (int i = 0; i < size; i++) {
            this.mPath.reset();
            getPaint().getTextBounds(this.mSplitText.get(i), 0, this.mSplitText.get(i).length(), this.mLineTextBounds);
            int i2 = this.mDegree;
            if (i2 != 0) {
                if (i2 == 90) {
                    paddingStart = (width * i) + (width >> 1) + (this.mLineTextBounds.height() >> 1);
                    iHeight = getHeight();
                    paddingTop = getPaddingTop();
                } else if (i2 == 180) {
                    paddingStart = getWidth();
                    iHeight = ((getHeight() - (height * i)) - (height >> 1)) - (this.mLineTextBounds.height() >> 1);
                    width2 = getPaddingStart();
                } else if (i2 != 270) {
                    this.mPath.moveTo(paddingStart, iHeight);
                    this.mPath.lineTo(width2, paddingTop);
                    canvas.drawTextOnPath(this.mSplitText.get(i), this.mPath, 0.0f, 0.0f, getPaint());
                } else {
                    paddingStart = ((getWidth() - (width * i)) - (width >> 1)) - (this.mLineTextBounds.height() >> 1);
                    iHeight = getPaddingBottom();
                    paddingTop = getHeight();
                }
                width2 = paddingStart;
                this.mPath.moveTo(paddingStart, iHeight);
                this.mPath.lineTo(width2, paddingTop);
                canvas.drawTextOnPath(this.mSplitText.get(i), this.mPath, 0.0f, 0.0f, getPaint());
            } else {
                paddingStart = getPaddingStart();
                iHeight = (height * i) + (height >> 1) + (this.mLineTextBounds.height() >> 1);
                width2 = getWidth();
            }
            paddingTop = iHeight;
            this.mPath.moveTo(paddingStart, iHeight);
            this.mPath.lineTo(width2, paddingTop);
            canvas.drawTextOnPath(this.mSplitText.get(i), this.mPath, 0.0f, 0.0f, getPaint());
        }
        canvas.restore();
    }

    private final void drawSingleLineText(Canvas canvas) {
        int width;
        int height;
        int width2;
        int iWidth;
        int height2;
        int iHeight;
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        canvas.save();
        getPaint().setColor(getCurrentTextColor());
        this.mPath.reset();
        String country = Locale.getDefault().getCountry();
        int i4 = this.mDegree;
        if (i4 == 0) {
            width = (getWidth() - this.mAllTextBounds.width()) >> 1;
            int iHeight2 = (this.mAllTextBounds.height() + getHeight()) >> 1;
            if (Intrinsics.areEqual(country, "IN") || Intrinsics.areEqual(country, "SG")) {
                resources = getContext().getResources();
                i = C9086R.dimen.screenoff_region_custom_toast_vertical_text_padding_bottom;
            } else {
                resources = getContext().getResources();
                i = C9086R.dimen.screenoff_custom_toast_vertical_text_padding_bottom;
            }
            height = iHeight2 - resources.getDimensionPixelSize(i);
            width2 = (this.mAllTextBounds.width() + getWidth()) >> 1;
            int iHeight3 = (this.mAllTextBounds.height() + getHeight()) >> 1;
            if (Intrinsics.areEqual(country, "IN") || Intrinsics.areEqual(country, "SG")) {
                resources2 = getContext().getResources();
                i2 = C9086R.dimen.screenoff_region_custom_toast_vertical_text_padding_bottom;
            } else {
                resources2 = getContext().getResources();
                i2 = C9086R.dimen.screenoff_custom_toast_vertical_text_padding_bottom;
            }
            iWidth = iHeight3 - resources2.getDimensionPixelSize(i2);
        } else {
            if (i4 == 90) {
                width = (this.mAllTextBounds.height() + getWidth()) >> 1;
                height = (this.mAllTextBounds.width() + getHeight()) >> 1;
                width2 = (this.mAllTextBounds.height() + getWidth()) >> 1;
                height2 = getHeight();
                iHeight = this.mAllTextBounds.width();
            } else if (i4 == 180) {
                width = (this.mAllTextBounds.width() + getWidth()) >> 1;
                height = (getHeight() - this.mAllTextBounds.height()) >> 1;
                width2 = (getWidth() - this.mAllTextBounds.width()) >> 1;
                height2 = getHeight();
                iHeight = this.mAllTextBounds.height();
            } else if (i4 == 270) {
                width = (getWidth() - this.mAllTextBounds.height()) >> 1;
                height = (getHeight() - this.mAllTextBounds.width()) >> 1;
                width2 = (getWidth() - this.mAllTextBounds.height()) >> 1;
                iWidth = (this.mAllTextBounds.width() + getHeight()) >> 1;
            } else {
                width = 0;
                height = 0;
                width2 = 0;
                iWidth = 0;
            }
            iWidth = (height2 - iHeight) >> 1;
        }
        this.mPath.moveTo(width, height);
        this.mPath.lineTo(width2, iWidth);
        canvas.drawTextOnPath(getText().toString(), this.mPath, 0.0f, 0.0f, getPaint());
        canvas.restore();
    }

    private final List<String> makeWordList(String[] strArr, int size) {
        ArrayList arrayList = new ArrayList();
        int iMeasureText = size - ((((int) getPaint().measureText(" ")) + 1) * 2);
        for (String str : strArr) {
            Rect rect = new Rect();
            getPaint().getTextBounds(str, 0, str.length(), rect);
            if (rect.width() < iMeasureText) {
                arrayList.add(str);
            } else {
                int length = str.length();
                int i = 0;
                for (int i2 = 1; i2 < length; i2++) {
                    getPaint().getTextBounds(str, i, i2, rect);
                    if (rect.width() >= iMeasureText) {
                        int i4 = i2 - 1;
                        String strSubstring = str.substring(i, i4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        arrayList.add(strSubstring);
                        i = i4;
                    }
                }
                String strSubstring2 = str.substring(i);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                arrayList.add(strSubstring2);
            }
        }
        AbstractC8014b.m7206h("makeWordList. size: ", arrayList.size(), SOLogger.INSTANCE, TAG);
        return arrayList;
    }

    private final int measureHeight(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == 1073741824) {
            return size;
        }
        int paddingEnd = getPaddingEnd() + getPaddingStart() + this.mAllTextBounds.width();
        if (mode != Integer.MIN_VALUE) {
            return paddingEnd;
        }
        int size2 = this.mSplitText.size();
        if (size2 > 1) {
            paddingEnd *= size2;
        }
        return Math.min(paddingEnd, size);
    }

    private final int measureWidth(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == 1073741824) {
            return size;
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop() + ((int) (getPaint().descent() - getPaint().ascent())) + 1;
        if (mode != Integer.MIN_VALUE) {
            return paddingBottom;
        }
        int size2 = this.mSplitText.size();
        if (size2 > 1) {
            paddingBottom *= size2;
        }
        return Math.min(paddingBottom, size);
    }

    private final boolean setSplitText(String text, int width, int height) {
        List listEmptyList;
        getPaint().getTextBounds(text, 0, text.length(), this.mAllTextBounds);
        this.mSplitText.clear();
        int iMin = Math.min(this.mAllTextBounds.width() / text.length(), this.mAllTextBounds.height());
        if (width < iMin || height < iMin) {
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "setSplit text fail. ", "x", SQLKeyword.COMMA);
            sbM1173s.append(iMin);
            sOLogger.SOLoggerE(str, sbM1173s.toString());
            return false;
        }
        int i = this.mDegree;
        if (i == 90 || i == 270) {
            width = height;
        } else if (i != 0 && i != 180) {
            width = 0;
        }
        StringBuilder sb = new StringBuilder();
        List listM13999t = AbstractC12991c.m13999t(0, " ", text);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        List<String> listMakeWordList = makeWordList((String[]) listEmptyList.toArray(new String[0]), width);
        int i2 = 0;
        while (i2 < listMakeWordList.size()) {
            if (i2 > 0) {
                sb.append(' ');
            }
            sb.append(listMakeWordList.get(i2));
            Rect rect = new Rect();
            getPaint().getTextBounds(sb.toString(), 0, sb.length(), rect);
            if (rect.width() > width) {
                this.mSplitText.add(splitSubText(sb, listMakeWordList.get(i2)));
                i2--;
                sb.setLength(0);
            }
            i2++;
        }
        List<String> list = this.mSplitText;
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        list.add(string);
        sb.setLength(0);
        AbstractC8014b.m7206h("setSplitText. line: ", this.mSplitText.size(), SOLogger.INSTANCE, TAG);
        return true;
    }

    private final String splitSubText(StringBuilder stringBuilder, String temp) {
        int length = stringBuilder.length() - temp.length();
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (StringsKt.m14162r(string, " ")) {
            length--;
        }
        String string2 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        String strSubstring = string2.substring(0, length);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int size = this.mSplitText.size();
        if (size > 1) {
            drawMultiLineText(canvas);
        } else if (size == 1) {
            drawSingleLineText(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!setSplitText(getText().toString(), View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec))) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int i = this.mDegree;
        if (i == 0 || i == 180) {
            setMeasuredDimension(measureHeight(widthMeasureSpec), measureWidth(heightMeasureSpec));
        } else if (i == 90 || i == 270) {
            setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
        }
    }

    public VerticalTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDegree = 90;
        this.mAllTextBounds = new Rect();
        this.mLineTextBounds = new Rect();
        this.mPath = new Path();
        this.mSplitText = new ArrayList();
        requestLayout();
        invalidate();
    }
}
