package com.samsung.android.support.senl.p148nt.base.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.samsung.android.sdk.composer.document.capture.SpenNoteCapturePage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\"\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0010\u0010\u001c\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u001a\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010$\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/NoteCaptureControl;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mCapturePage", "Lcom/samsung/android/sdk/composer/document/capture/SpenNoteCapturePage;", "setWNote", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setContents", "wpage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", ExternalDataConstants.Column.BODY_TEXT, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "pageIndex", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setBackgroundColorEnabled", "enabled", "", "captureRect", "Landroid/graphics/Bitmap;", "rect", "Landroid/graphics/RectF;", "capturePage", "ratio", "", "", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "captureHandwritingRect", "handwritingRect", "captureHandwritingPage", "close", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NoteCaptureControl {

    @NotNull
    private final SpenNoteCapturePage mCapturePage;

    public NoteCaptureControl(@Nullable Context context) {
        this.mCapturePage = new SpenNoteCapturePage(context);
    }

    @Nullable
    public final Bitmap captureHandwritingPage(float ratio) {
        Bitmap bitmapCaptureHandwritingPage;
        synchronized (NoteCaptureControl.class) {
            bitmapCaptureHandwritingPage = this.mCapturePage.captureHandwritingPage(ratio);
        }
        return bitmapCaptureHandwritingPage;
    }

    @Nullable
    public final Bitmap captureHandwritingRect(@Nullable RectF handwritingRect, float ratio) {
        Bitmap bitmapCaptureHandwritingRect;
        synchronized (NoteCaptureControl.class) {
            SpenNoteCapturePage spenNoteCapturePage = this.mCapturePage;
            Intrinsics.checkNotNull(handwritingRect);
            bitmapCaptureHandwritingRect = spenNoteCapturePage.captureHandwritingRect(handwritingRect, ratio);
        }
        return bitmapCaptureHandwritingRect;
    }

    @Nullable
    public final Bitmap capturePage(float ratio) {
        Bitmap bitmapCapturePage;
        synchronized (NoteCaptureControl.class) {
            bitmapCapturePage = this.mCapturePage.capturePage(ratio);
        }
        return bitmapCapturePage;
    }

    @Nullable
    public final Bitmap captureRect(@Nullable RectF rect) {
        Bitmap bitmapCaptureRect;
        synchronized (NoteCaptureControl.class) {
            SpenNoteCapturePage spenNoteCapturePage = this.mCapturePage;
            Intrinsics.checkNotNull(rect);
            bitmapCaptureRect = spenNoteCapturePage.captureRect(rect);
        }
        return bitmapCaptureRect;
    }

    public final void close() {
        synchronized (NoteCaptureControl.class) {
            this.mCapturePage.close();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setBackgroundColorEnabled(boolean enabled) {
        this.mCapturePage.setBackgroundColorEnabled(enabled);
    }

    public final void setColorTheme(int theme) {
        this.mCapturePage.setColorTheme(theme);
    }

    public final void setContents(@Nullable SpenWPage wpage, @Nullable SpenObjectTextBox bodyText, int pageIndex) {
        synchronized (NoteCaptureControl.class) {
            this.mCapturePage.setContents(wpage, bodyText, pageIndex);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void setWNote(@Nullable SpenWNote wNote) {
        this.mCapturePage.setWNote(wNote);
    }

    public final boolean capturePage(@Nullable String filename) {
        boolean zCapturePage;
        synchronized (NoteCaptureControl.class) {
            SpenNoteCapturePage spenNoteCapturePage = this.mCapturePage;
            Intrinsics.checkNotNull(filename);
            zCapturePage = spenNoteCapturePage.capturePage(filename);
        }
        return zCapturePage;
    }

    @Nullable
    public final String captureRect(@Nullable RectF rect, @Nullable String filename) {
        String strCaptureRect;
        synchronized (NoteCaptureControl.class) {
            SpenNoteCapturePage spenNoteCapturePage = this.mCapturePage;
            Intrinsics.checkNotNull(rect);
            Intrinsics.checkNotNull(filename);
            strCaptureRect = spenNoteCapturePage.captureRect(rect, filename);
        }
        return strCaptureRect;
    }
}
