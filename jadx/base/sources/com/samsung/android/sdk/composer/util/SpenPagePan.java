package com.samsung.android.sdk.composer.util;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import com.samsung.android.sdk.composer.document.SpenWNoteHelper;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/util/SpenPagePan;", "", "<init>", "()V", "pageIndex", "", "pan", "Landroid/graphics/PointF;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPagePan {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public int pageIndex;

    @JvmField
    @NotNull
    public PointF pan = new PointF();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/util/SpenPagePan$Companion;", "", "<init>", "()V", "convertContentPanToPagePan", "Lcom/samsung/android/sdk/composer/util/SpenPagePan;", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "helper", "Lcom/samsung/android/sdk/composer/document/SpenWNoteHelper;", "contentRect", "Landroid/graphics/RectF;", "convertPagePanToContentPan", "Landroid/graphics/PointF;", "pagePan", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final SpenPagePan convertContentPanToPagePan(@Nullable SpenWNote doc, @Nullable SpenWNoteHelper helper, @NotNull RectF contentRect) {
            Intrinsics.checkNotNullParameter(contentRect, "contentRect");
            if (doc != null && helper != null && !contentRect.isEmpty()) {
                SpenPagePan spenPagePan = new SpenPagePan();
                PointF pointF = new PointF(contentRect.left, contentRect.top);
                int pageIndexByXY = helper.getPageIndexByXY(pointF.x, pointF.y);
                spenPagePan.pageIndex = pageIndexByXY;
                if (pageIndexByXY < 0 || pageIndexByXY >= doc.getPageCount()) {
                    ArrayList<Integer> pageIndexListByRect = helper.getPageIndexListByRect(contentRect);
                    if (pageIndexListByRect != null && !pageIndexListByRect.isEmpty()) {
                        spenPagePan.pageIndex = pageIndexListByRect.get(0).intValue();
                    }
                }
                Point offset = doc.getPage(spenPagePan.pageIndex).getOffset();
                PointF pointF2 = new PointF(contentRect.left, contentRect.top);
                spenPagePan.pan = pointF2;
                pointF2.offset(-offset.x, -offset.y);
                return spenPagePan;
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final PointF convertPagePanToContentPan(@Nullable SpenWNote doc, @NotNull SpenPagePan pagePan) {
            int i;
            Intrinsics.checkNotNullParameter(pagePan, "pagePan");
            if (doc == null || (i = pagePan.pageIndex) < 0 || i >= doc.getPageCount()) {
                return null;
            }
            Point offset = doc.getPage(pagePan.pageIndex).getOffset();
            pagePan.pan.offset(offset.x, offset.y);
            return pagePan.pan;
        }

        private Companion() {
        }

        @Nullable
        public final SpenPagePan convertContentPanToPagePan(@Nullable SpenWNote doc, @NotNull RectF contentRect) {
            Intrinsics.checkNotNullParameter(contentRect, "contentRect");
            if (doc != null && !contentRect.isEmpty()) {
                SpenPagePan spenPagePan = new SpenPagePan();
                SpenWNoteHelper spenWNoteHelper = new SpenWNoteHelper();
                spenWNoteHelper.setDocument(doc);
                PointF pointF = new PointF(contentRect.left, contentRect.top);
                int pageIndexByXY = spenWNoteHelper.getPageIndexByXY(pointF.x, pointF.y);
                spenPagePan.pageIndex = pageIndexByXY;
                if (pageIndexByXY < 0 || pageIndexByXY >= doc.getPageCount()) {
                    ArrayList<Integer> pageIndexListByRect = spenWNoteHelper.getPageIndexListByRect(contentRect);
                    if (pageIndexListByRect != null && !pageIndexListByRect.isEmpty()) {
                        spenPagePan.pageIndex = pageIndexListByRect.get(0).intValue();
                    }
                }
                spenWNoteHelper.close();
                Point offset = doc.getPage(spenPagePan.pageIndex).getOffset();
                spenPagePan.pan.offset(-offset.x, -offset.y);
                spenPagePan.pan.offset(-offset.x, -offset.y);
                return spenPagePan;
            }
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final SpenPagePan convertContentPanToPagePan(@Nullable SpenWNote spenWNote, @Nullable SpenWNoteHelper spenWNoteHelper, @NotNull RectF rectF) {
        return INSTANCE.convertContentPanToPagePan(spenWNote, spenWNoteHelper, rectF);
    }

    @JvmStatic
    @Nullable
    public static final PointF convertPagePanToContentPan(@Nullable SpenWNote spenWNote, @NotNull SpenPagePan spenPagePan) {
        return INSTANCE.convertPagePanToContentPan(spenWNote, spenPagePan);
    }
}
