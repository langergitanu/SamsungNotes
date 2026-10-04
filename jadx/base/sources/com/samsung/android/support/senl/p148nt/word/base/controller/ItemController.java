package com.samsung.android.support.senl.p148nt.word.base.controller;

import android.graphics.RectF;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import com.samsung.android.support.senl.p148nt.word.word.utils.WordUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt___RangesKt;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 %*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002%&BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u001c\u001a\u00020\u0017H\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010$\u001a\u00020\u0019R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00028\u00008\u0004X\u0085\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\f\u001a\u00020\r8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00128\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00128\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00128\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController;", "OfficeElement", "", "mBodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "mObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "mView", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "mSpenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "mElement", "isObjectSpan", "", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;Ljava/lang/Object;Z)V", "Ljava/lang/Object;", "left", "", "top", "width", "height", "processItem", "", "objectRectF", "Landroid/graphics/RectF;", "getObjectRectF", "()Landroid/graphics/RectF;", "calculateSize", "getNewName", "", "elementId", "", "getXWPFRun", "Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController$XWPFRunData;", "rectF", "convertRectF", "Companion", "XWPFRunData", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nItemController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemController.kt\ncom/samsung/android/support/senl/nt/word/base/controller/ItemController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
public abstract class ItemController<OfficeElement> {

    @NotNull
    public static final String IMAGE_EXTENSION = ".png";

    @NotNull
    public static final String IMAGE_PREFIX = "image";

    @JvmField
    protected double height;

    @JvmField
    protected final boolean isObjectSpan;

    @JvmField
    protected double left;

    @JvmField
    @Nullable
    protected final SpenBodyTextContext mBodyTextContext;

    @JvmField
    protected final OfficeElement mElement;

    @JvmField
    @Nullable
    protected final SpenObjectBase mObject;

    @JvmField
    @NotNull
    protected final SpenWPage mSpenWPage;

    @JvmField
    @NotNull
    protected final OfficeView<?, ?> mView;

    @JvmField
    protected double top;

    @JvmField
    protected double width;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/controller/ItemController$XWPFRunData;", "", "ctDrawing", "Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTDrawing;", "run", "Lorg/apache/poi/xwpf/usermodel/XWPFRun;", "<init>", "(Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTDrawing;Lorg/apache/poi/xwpf/usermodel/XWPFRun;)V", "getCtDrawing", "()Lorg/openxmlformats/schemas/wordprocessingml/x2006/main/CTDrawing;", "getRun", "()Lorg/apache/poi/xwpf/usermodel/XWPFRun;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class XWPFRunData {

        @Nullable
        private final CTDrawing ctDrawing;

        @NotNull
        private final XWPFRun run;

        public XWPFRunData(@Nullable CTDrawing cTDrawing, @NotNull XWPFRun run) {
            Intrinsics.checkNotNullParameter(run, "run");
            this.ctDrawing = cTDrawing;
            this.run = run;
        }

        public static /* synthetic */ XWPFRunData copy$default(XWPFRunData xWPFRunData, CTDrawing cTDrawing, XWPFRun xWPFRun, int i, Object obj) {
            if ((i & 1) != 0) {
                cTDrawing = xWPFRunData.ctDrawing;
            }
            if ((i & 2) != 0) {
                xWPFRun = xWPFRunData.run;
            }
            return xWPFRunData.copy(cTDrawing, xWPFRun);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CTDrawing getCtDrawing() {
            return this.ctDrawing;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final XWPFRun getRun() {
            return this.run;
        }

        @NotNull
        public final XWPFRunData copy(@Nullable CTDrawing ctDrawing, @NotNull XWPFRun run) {
            Intrinsics.checkNotNullParameter(run, "run");
            return new XWPFRunData(ctDrawing, run);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof XWPFRunData)) {
                return false;
            }
            XWPFRunData xWPFRunData = (XWPFRunData) other;
            return Intrinsics.areEqual(this.ctDrawing, xWPFRunData.ctDrawing) && Intrinsics.areEqual(this.run, xWPFRunData.run);
        }

        @Nullable
        public final CTDrawing getCtDrawing() {
            return this.ctDrawing;
        }

        @NotNull
        public final XWPFRun getRun() {
            return this.run;
        }

        public int hashCode() {
            CTDrawing cTDrawing = this.ctDrawing;
            return this.run.hashCode() + ((cTDrawing == null ? 0 : cTDrawing.hashCode()) * 31);
        }

        @NotNull
        public String toString() {
            return "XWPFRunData(ctDrawing=" + this.ctDrawing + ", run=" + this.run + ")";
        }
    }

    public ItemController(@Nullable SpenBodyTextContext spenBodyTextContext, @Nullable SpenObjectBase spenObjectBase, @NotNull OfficeView<?, ?> mView, @NotNull SpenWPage mSpenWPage, OfficeElement officeelement, boolean z) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        Intrinsics.checkNotNullParameter(mSpenWPage, "mSpenWPage");
        this.mBodyTextContext = spenBodyTextContext;
        this.mObject = spenObjectBase;
        this.mView = mView;
        this.mSpenWPage = mSpenWPage;
        this.mElement = officeelement;
        this.isObjectSpan = z;
    }

    public final void calculateSize() {
        RectF objectRectF = getObjectRectF();
        float f = objectRectF.left;
        OfficeView<?, ?> officeView = this.mView;
        boolean z = officeView instanceof WordView;
        double d = (z ? 0 : officeView.mDocParams.marginLeft) + f;
        this.left = d;
        float f4 = objectRectF.top;
        double d2 = (z ? 0 : officeView.mDocParams.marginTop) + f4;
        this.top = d2;
        double d3 = objectRectF.right - f;
        this.width = d3;
        double d4 = objectRectF.bottom - f4;
        this.height = d4;
        double d5 = d2 + d4;
        OfficeParams officeParams = officeView.mDocParams;
        double d6 = officeParams.height;
        if (d5 > d6) {
            double d7 = d6 - d2;
            this.height = d7;
            this.width = d3 * ((double) ((float) (d7 / d4)));
        }
        double d8 = this.width;
        double d9 = d + d8;
        double d10 = officeParams.width;
        if (d9 > d10) {
            double d11 = d10 - d;
            this.width = d11;
            this.height *= (double) ((float) (d11 / d8));
        }
        this.width = RangesKt___RangesKt.coerceAtLeast(0.0d, this.width);
        this.height = RangesKt___RangesKt.coerceAtLeast(0.0d, this.height);
    }

    @NotNull
    public final RectF convertRectF() {
        SpenObjectBase spenObjectBase = this.mObject;
        RectF rect = spenObjectBase != null ? spenObjectBase.getRect() : null;
        OfficeView<?, ?> officeView = this.mView;
        if (!officeView.isContinuousPage) {
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            SpenWPage spenWPage = this.mSpenWPage;
            OfficeParams officeParams = officeView.mDocParams;
            int i = officeParams.width;
            int i2 = officeParams.height;
            Intrinsics.checkNotNull(rect);
            return convertUtils.convertRectF(spenWPage, i, i2, rect);
        }
        ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
        int i4 = officeView.prevHeight;
        int width = this.mSpenWPage.getWidth();
        OfficeView<?, ?> officeView2 = this.mView;
        int i5 = officeView2.cropHeight;
        OfficeParams officeParams2 = officeView2.mDocParams;
        int i6 = officeParams2.width;
        int i7 = officeParams2.height;
        Intrinsics.checkNotNull(rect);
        return convertUtils2.convertRectContinuousPage(i4, width, i5, i6, i7, rect, this.mSpenWPage.hasPDF());
    }

    @NotNull
    public final String getNewName(int elementId) {
        return AbstractC0541b.m767i(elementId, "image", ".png");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RectF getObjectRectF() {
        RectF rect;
        SpenObjectBase spenObjectBase;
        RectF objectDrawnRect;
        RectF rectF;
        SpenObjectBase spenObjectBase2;
        SpenObjectBase spenObjectBase3 = this.mObject;
        if (spenObjectBase3 == null || !ConvertUtils.INSTANCE.isStrokeType(spenObjectBase3.getType())) {
            SpenObjectBase spenObjectBase4 = this.mObject;
            if (Intrinsics.areEqual(spenObjectBase4 != null ? Float.valueOf(spenObjectBase4.getRotation()) : null, 0.0f)) {
                if (this.mBodyTextContext == null || (spenObjectBase = this.mObject) == null || !spenObjectBase.belongsToSpan()) {
                    SpenObjectBase spenObjectBase5 = this.mObject;
                    rect = spenObjectBase5 != null ? spenObjectBase5.getRect() : null;
                    Intrinsics.checkNotNull(rect);
                    rectF = rect;
                } else {
                    SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
                    Intrinsics.checkNotNull(spenBodyTextContext);
                    objectDrawnRect = spenBodyTextContext.getObjectDrawnRect(this.mObject);
                    rectF = objectDrawnRect;
                }
            } else if (this.mBodyTextContext == null || (spenObjectBase2 = this.mObject) == null || !spenObjectBase2.belongsToSpan()) {
                SpenObjectBase spenObjectBase6 = this.mObject;
                rect = spenObjectBase6 != null ? spenObjectBase6.getDrawnRect() : null;
                Intrinsics.checkNotNull(rect);
                rectF = rect;
            } else {
                SpenBodyTextContext spenBodyTextContext2 = this.mBodyTextContext;
                Intrinsics.checkNotNull(spenBodyTextContext2);
                objectDrawnRect = spenBodyTextContext2.getObjectRect(this.mObject);
                rectF = objectDrawnRect;
            }
        }
        OfficeView<?, ?> officeView = this.mView;
        if (!officeView.isContinuousPage) {
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            SpenWPage spenWPage = this.mSpenWPage;
            OfficeParams officeParams = officeView.mDocParams;
            return convertUtils.convertRectF(spenWPage, officeParams.width, officeParams.height, rectF);
        }
        ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
        int i = officeView.prevHeight;
        int width = this.mSpenWPage.getWidth();
        OfficeView<?, ?> officeView2 = this.mView;
        int i2 = officeView2.cropHeight;
        OfficeParams officeParams2 = officeView2.mDocParams;
        return convertUtils2.convertRectContinuousPage(i, width, i2, officeParams2.width, officeParams2.height, rectF, this.mSpenWPage.hasPDF());
    }

    @NotNull
    public final XWPFRunData getXWPFRun(@NotNull RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        XWPFRun inlineImageRun = this.isObjectSpan ? WordView.INSTANCE.getInlineImageRun(CollectionsKt.indexOf((List<? extends SpenObjectBase>) this.mView.objectSpanOfPage, this.mObject)) : null;
        if (inlineImageRun == null) {
            OfficeElement officeelement = this.mElement;
            Intrinsics.checkNotNull(officeelement, "null cannot be cast to non-null type org.apache.poi.xwpf.usermodel.XWPFParagraph");
            inlineImageRun = ((XWPFParagraph) officeelement).getRuns().get(0);
        }
        XWPFRun xWPFRun = inlineImageRun;
        OfficeView.INSTANCE.increaseElementId();
        Intrinsics.checkNotNull(xWPFRun);
        return new XWPFRunData(WordUtils.addImageToRun(xWPFRun, ((double) rectF.left) - 42.0d, rectF.top, rectF.width(), rectF.height(), false, true, this.isObjectSpan, OfficeView.mElementId, 0), xWPFRun);
    }

    public abstract void processItem();
}
