package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/common/PageSizeUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getPageSize", "Landroid/graphics/PointF;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "pageIndex", "", "page", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getPageBound", "Landroid/graphics/RectF;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PageSizeUtil {

    @NotNull
    public static final PageSizeUtil INSTANCE = new PageSizeUtil();

    @NotNull
    private static final String TAG = "PageSizeUtil";

    private PageSizeUtil() {
    }

    @JvmStatic
    @NotNull
    public static final RectF getPageBound(@NotNull SpenWNote note, int pageIndex) {
        Intrinsics.checkNotNullParameter(note, "note");
        return getPageBound(note.getPage(pageIndex));
    }

    @JvmStatic
    @NotNull
    public static final PointF getPageSize(@NotNull SpenWNote note, int pageIndex) {
        Intrinsics.checkNotNullParameter(note, "note");
        return getPageSize(note.getPage(pageIndex));
    }

    @JvmStatic
    @NotNull
    public static final RectF getPageBound(@NotNull SpenWPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        RectF rectF = new RectF();
        try {
            Point offset = page.getOffset();
            RectF rectF2 = new RectF(0.0f, 0.0f, page.getWidth(), page.getHeight());
            try {
                rectF2.offset(offset.x, offset.y);
                return rectF2;
            } catch (IndexOutOfBoundsException e) {
                e = e;
                rectF = rectF2;
                AbstractC8014b.m7198D("getPageBound, e: ", e.getMessage(), TAG);
                return rectF;
            } catch (NullPointerException e2) {
                e = e2;
                rectF = rectF2;
                AbstractC8014b.m7198D("getPageBound, e: ", e.getMessage(), TAG);
                return rectF;
            }
        } catch (IndexOutOfBoundsException e3) {
            e = e3;
        } catch (NullPointerException e5) {
            e = e5;
        }
    }

    @JvmStatic
    @NotNull
    public static final PointF getPageSize(@NotNull SpenWPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        RectF pageBound = getPageBound(page);
        return new PointF(pageBound.width(), pageBound.height());
    }
}
