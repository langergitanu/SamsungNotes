package com.samsung.android.support.senl.p148nt.model.document;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.base.utils.PositionUtil;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DocumentObjectInserter {
    private static final float DEFAULT_DENSITY_DPI = 450.0f;
    private static final int IMAGE_MIN_SIZE = 74;
    private static final String TAG = ModelLogger.createTag("DocumentObjectInserter");
    private final List<SpenObjectImage> mObjects = new ArrayList();

    private void addNewLine(@NonNull SpenObjectTextBox spenObjectTextBox) {
        spenObjectTextBox.insertText("\n", spenObjectTextBox.getText().length(), false);
    }

    private void addObjects(@NonNull Context context, @NonNull SpenWNote spenWNote) {
        float f;
        int i;
        DataLogger.m12302d(TAG, "addObjects, size: " + this.mObjects.size());
        if (this.mObjects.isEmpty()) {
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            i = 1080;
            f = 2.8125f;
        } else {
            int iMin = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            f = displayMetrics.densityDpi;
            i = iMin;
        }
        float f4 = f / 160.0f;
        SpenWPage page = spenWNote.getPage(0);
        int width = page.getWidth();
        int height = page.getHeight();
        int i2 = width / PopOverActivityWrapper.DEFAULT_WIDTH;
        int i4 = i2 * 16;
        int i5 = i2 * 10;
        int i6 = width - (i2 * 32);
        if (spenWNote.getPageMode() != SpenWNote.PageMode.LIST) {
            for (SpenObjectImage spenObjectImage : this.mObjects) {
                PointF insertedPosition = PositionUtil.getInsertedPosition(context, spenWNote, 0);
                RectF imageRect = getImageRect(i, f4, i6, spenObjectImage.getImagePath());
                imageRect.offset(insertedPosition.x + i4, insertedPosition.y);
                spenObjectImage.setRect(imageRect, false);
                page.appendObject(spenObjectImage);
            }
            page.clearCanvasCacheData();
            return;
        }
        SpenWPage page2 = spenWNote.getPage(spenWNote.getPageCount() - 1);
        for (SpenObjectImage spenObjectImage2 : this.mObjects) {
            RectF imageRect2 = getImageRect(i, f4, i6, spenObjectImage2.getImagePath());
            imageRect2.offset(i4, i5);
            spenObjectImage2.setRect(imageRect2, false);
            page2.appendObject(spenObjectImage2);
            page2.clearCanvasCacheData();
            page2 = spenWNote.appendPage(width, height);
        }
    }

    private void createImageObject(@NonNull String str) {
        if (str.isEmpty()) {
            DataLogger.m12303e(TAG, "createImageObject, path is empty");
            return;
        }
        SpenObjectImage spenObjectImageMakeObjectImage = SpenObjectConstructor.makeObjectImage();
        spenObjectImageMakeObjectImage.setImage(str);
        this.mObjects.add(spenObjectImageMakeObjectImage);
    }

    private RectF getImageRect(int i, float f, int i2, @NonNull String str) {
        int height;
        int i4;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile == null) {
            DataLogger.m12309w(TAG, "decoding bitmap failed, apply min width");
            i4 = 74;
            height = 74;
        } else {
            int width = bitmapDecodeFile.getWidth();
            height = bitmapDecodeFile.getHeight();
            i4 = width;
        }
        RectF imageViewSize = SpenComposerUtil.getImageViewSize(i, f, i4, height, height == 0 ? 1.0f : i4 / height, i2, true);
        float f4 = i2;
        if (imageViewSize.width() <= f4) {
            return imageViewSize;
        }
        float fWidth = f4 / imageViewSize.width();
        return new RectF(imageViewSize.left, imageViewSize.top, (imageViewSize.width() * fWidth) + imageViewSize.left, (imageViewSize.height() * fWidth) + imageViewSize.top);
    }

    private String getMimeType(@NonNull Context context, @NonNull Uri uri, @Nullable List<String> list, int i) {
        String str = list != null ? list.get(i) : null;
        return !TextUtils.isEmpty(str) ? str : UriFileUtils.getMimeType(context, uri);
    }

    private void insertCheckList(@NonNull SpenWNote spenWNote, @NonNull List<Pair<String, Boolean>> list) {
        if (list.isEmpty()) {
            return;
        }
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        addNewLine(bodyText);
        for (Pair<String, Boolean> pair : list) {
            SpenBulletParagraph spenBulletParagraph = new SpenBulletParagraph(0, 1, 2);
            spenBulletParagraph.Checkout(pair.second.booleanValue());
            SpenObjectTextBox spenObjectTextBox = new SpenObjectTextBox();
            spenObjectTextBox.setText(pair.first);
            spenObjectTextBox.appendTextParagraph(spenBulletParagraph);
            bodyText.insertText(bodyText.getText().length(), spenObjectTextBox, 0, spenObjectTextBox.getText().length());
            addNewLine(bodyText);
        }
    }

    private void insertImages(Context context, List<String> list, List<Uri> list2, SpenWNote spenWNote) {
        if (list2 == null || list2.isEmpty()) {
            DataLogger.m12302d(TAG, "insertImages, empty uris");
            return;
        }
        int size = list2.size();
        DataLogger.m12302d(TAG, "insertImages, uri size: " + size);
        String str = spenWNote.getInternalTempDirectory() + File.separator;
        if (list == null || list.size() != size) {
            list = null;
        }
        for (int i = 0; i < size; i++) {
            Uri uri = list2.get(i);
            String mimeType = getMimeType(context, uri, list, i);
            if (mimeType == null || !mimeType.startsWith(Constants.MIME_IMAGE_START)) {
                DataLogger.m12309w(TAG, "insertImages, unsupported type: " + mimeType);
            } else {
                createImageObject(DownloadBitmap.saveImageFromUri(context, uri, mimeType, str, null));
            }
        }
        addObjects(context, spenWNote);
    }

    public void insert(@NonNull Context context, @Nullable List<String> list, @Nullable List<Uri> list2, @NonNull SpenWNote spenWNote) {
        insertImages(context, list, list2, spenWNote);
        insertCheckList(spenWNote, new ArrayList());
    }
}
