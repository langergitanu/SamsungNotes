package com.samsung.android.support.senl.p148nt.base.composer.action.copy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectShapeBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipDataBackupPath;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectTypeHelper;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0003H\u0002J2\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'J \u0010(\u001a\u00020)2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'H\u0002J \u0010*\u001a\u00020)2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'H\u0002J0\u0010+\u001a\u00020)2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020)2\u0006\u0010 \u001a\u00020!2\u0006\u00100\u001a\u00020\u0003H\u0002J\u001c\u00101\u001a\u00020)2\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0303H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/action/copy/ObjectCopy;", "", "tag", "", "contract", "Lcom/samsung/android/support/senl/nt/base/composer/action/copy/ObjectCopy$Contract;", "<init>", "(Ljava/lang/String;Lcom/samsung/android/support/senl/nt/base/composer/action/copy/ObjectCopy$Contract;)V", "backupFileName", "backupPath", "getBackupPath", "()Ljava/lang/String;", "setBackupPath", "(Ljava/lang/String;)V", "mimeType", "", "getMimeType", "()[Ljava/lang/String;", "setMimeType", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "plainText", "getPlainText", "setPlainText", "htmlText", "getHtmlText", "setHtmlText", ExternalDataConstants.Column.THUMBNAIL_URI, "Landroid/net/Uri;", "makeBackupFileName", "copyObject", "Lcom/samsung/android/support/senl/nt/base/composer/action/copy/CopyResult;", "context", "Landroid/content/Context;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "selectedList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "addShapeFollowers", "", "convertTableObject", "convertObjectToHtml", "convertStringToHtml", "spannableString", "Landroid/text/SpannableString;", "convertImageToHtml", DBSchema.DocumentThumbnail.IMAGE_PATH, "convertTableToHtml", "rows", "", "Contract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ObjectCopy {

    @NotNull
    private String backupFileName;

    @Nullable
    private String backupPath;

    @NotNull
    private final Contract contract;

    @NotNull
    private String htmlText;

    @NotNull
    private String[] mimeType;

    @NotNull
    private String plainText;

    @NotNull
    private final String tag;

    @Nullable
    private Uri thumbnailUri;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/action/copy/ObjectCopy$Contract;", "", "addPdfImageObject", "", "context", "Landroid/content/Context;", "baseName", "", "selectedList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "getSelectedObjectBitmap", "Landroid/graphics/Bitmap;", "saveAsImage", "obj", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void addPdfImageObject(@NotNull Contract contract, @NotNull Context context, @NotNull String baseName, @NotNull ArrayList<SpenObjectBase> selectedList) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(baseName, "baseName");
                Intrinsics.checkNotNullParameter(selectedList, "selectedList");
            }

            @Nullable
            public static String saveAsImage(@NotNull Contract contract, @NotNull SpenObjectBase obj, @NotNull String baseName) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                Intrinsics.checkNotNullParameter(baseName, "baseName");
                return "";
            }
        }

        void addPdfImageObject(@NotNull Context context, @NotNull String baseName, @NotNull ArrayList<SpenObjectBase> selectedList);

        @Nullable
        Bitmap getSelectedObjectBitmap();

        @Nullable
        String saveAsImage(@NotNull SpenObjectBase obj, @NotNull String baseName);
    }

    public ObjectCopy(@NotNull String tag, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.tag = tag;
        this.contract = contract;
        this.backupFileName = "";
        this.mimeType = new String[]{Constants.MIME_HTML};
        this.plainText = "";
        this.htmlText = "";
    }

    private final void addShapeFollowers(ArrayList<SpenObjectBase> selectedList) {
        int size = selectedList.size();
        for (int i = 0; i < size; i++) {
            SpenObjectBase spenObjectBase = selectedList.get(i);
            Intrinsics.checkNotNullExpressionValue(spenObjectBase, "get(...)");
            SpenObjectBase spenObjectBase2 = spenObjectBase;
            if (spenObjectBase2 instanceof SpenObjectShapeBase) {
                selectedList.addAll(((SpenObjectShapeBase) spenObjectBase2).getFollowers());
            }
        }
    }

    private final void convertImageToHtml(Context context, String imagePath) {
        Uri uri = ClipDataContentProvider.INSTANCE.getUri(imagePath);
        Intrinsics.checkNotNull(uri);
        ImageSpan imageSpan = new ImageSpan(context, uri);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan, 0, 1, 33);
        String html = HtmlUtils.toHtml(spannableString);
        String str = this.plainText;
        String string = spannableString.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.plainText = AbstractC0541b.m756B(str, StringsKt.trim((CharSequence) string).toString());
        this.htmlText = AbstractC0541b.m756B(this.htmlText, html);
        if (this.thumbnailUri == null) {
            this.thumbnailUri = uri;
        }
    }

    private final void convertObjectToHtml(Context context, SpenWNote note, ArrayList<SpenObjectBase> selectedList) {
        int type;
        String strM2221l = AbstractC2821a.m2221l(ClipboardCacheManager.getClipboardPath(context).getAbsolutePath(), "/", this.backupFileName, ".sdocx");
        this.backupPath = strM2221l;
        note.backupObjectList(selectedList, strM2221l);
        if (ObjectTypeHelper.INSTANCE.hasStrokeAndMathPlotType(selectedList)) {
            Logger.m8702i(this.tag, "convertObjectToHtml# hasStrokeType is true.");
            Bitmap selectedObjectBitmap = this.contract.getSelectedObjectBitmap();
            if (selectedObjectBitmap != null) {
                String clipboardFileName = ClipboardCacheManager.getClipboardFileName(context, this.backupFileName, "0.jpg");
                ImageUtils imageUtils = ImageUtils.INSTANCE;
                Intrinsics.checkNotNull(clipboardFileName);
                imageUtils.saveBitmapToFileCache(selectedObjectBitmap, clipboardFileName, Bitmap.CompressFormat.JPEG, 95);
                convertImageToHtml(context, clipboardFileName);
            }
        } else {
            Iterator<SpenObjectBase> it = selectedList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenObjectBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                SpenObjectBase spenObjectBase = next;
                int type2 = spenObjectBase.getType();
                if (type2 != 2) {
                    if (type2 != 3) {
                        if (type2 == 10) {
                            convertStringToHtml(new SpannableString(((SpenObjectVoice) spenObjectBase).getTitle()));
                        } else if (type2 == 17) {
                            convertStringToHtml(new SpannableString(((SpenObjectLink) spenObjectBase).getTitle()));
                        } else if (type2 != 19) {
                            if (type2 == 22) {
                                SpenObjectTable spenObjectTable = spenObjectBase instanceof SpenObjectTable ? (SpenObjectTable) spenObjectBase : null;
                                if (spenObjectTable == null) {
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                int rowsCount = spenObjectTable.getRowsCount();
                                for (int i = 0; i < rowsCount; i++) {
                                    ArrayList arrayList2 = new ArrayList();
                                    int columnsCount = spenObjectTable.getColumnsCount();
                                    for (int i2 = 0; i2 < columnsCount; i2++) {
                                        String text = spenObjectTable.getContentObject(i, i2).getText();
                                        if (text == null) {
                                            text = "";
                                        }
                                        arrayList2.add(new SpannableString(text));
                                    }
                                    arrayList.add(arrayList2);
                                }
                                convertTableToHtml(arrayList);
                            } else if (type2 == 13) {
                                convertStringToHtml(new SpannableString(((SpenObjectWeb) spenObjectBase).getUri()));
                            } else if (type2 != 14) {
                                continue;
                            }
                        }
                    }
                    String strSaveAsImage = this.contract.saveAsImage(spenObjectBase, this.backupFileName);
                    if (strSaveAsImage == null) {
                        break;
                    } else {
                        convertImageToHtml(context, strSaveAsImage);
                    }
                } else {
                    String text2 = ((SpenObjectTextBox) spenObjectBase).getText();
                    if (TextUtils.isEmpty(text2)) {
                        break;
                    } else {
                        convertStringToHtml(new SpannableString(text2));
                    }
                }
            }
        }
        if (selectedList.size() == 1 && this.thumbnailUri != null && ((type = selectedList.get(0).getType()) == 3 || type == 14)) {
            this.mimeType = new String[]{UriFileUtils.getMimeType(context, this.thumbnailUri), Constants.MIME_HTML};
        }
        this.htmlText = AbstractC0541b.m756B(this.htmlText, ClipDataBackupPath.getClipDataBackupPath(this.backupPath));
    }

    private final void convertStringToHtml(SpannableString spannableString) {
        String html = HtmlUtils.toHtml(spannableString);
        this.plainText = this.plainText + ((Object) spannableString);
        this.htmlText = AbstractC0541b.m756B(this.htmlText, html);
    }

    private final void convertTableObject(ArrayList<SpenObjectBase> selectedList) {
        int size = selectedList.size();
        if (size != 1) {
            return;
        }
        SpenObjectBase spenObjectBase = selectedList.get(0);
        Intrinsics.checkNotNullExpressionValue(spenObjectBase, "get(...)");
        SpenObjectBase spenObjectBase2 = spenObjectBase;
        if (spenObjectBase2 instanceof SpenObjectTable) {
            RectF rect = spenObjectBase2.getRect();
            SpenObjectTable spenObjectTable = (SpenObjectTable) spenObjectBase2;
            ArrayList<Pair<Integer, Integer>> selectedCellPositions = spenObjectTable.getSelectedCellPositions();
            if (selectedCellPositions == null || selectedCellPositions.isEmpty()) {
                return;
            }
            if (spenObjectTable.getColumnsCount() * spenObjectTable.getRowsCount() != selectedCellPositions.size()) {
                SpenObjectTable spenObjectTable2 = new SpenObjectTable();
                spenObjectTable2.copy(spenObjectBase2);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                Iterator<Pair<Integer, Integer>> it = selectedCellPositions.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Pair<Integer, Integer> next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    Pair<Integer, Integer> pair = next;
                    linkedHashSet.add(pair.getFirst());
                    linkedHashSet2.add(pair.getSecond());
                }
                rect.height();
                for (int rowsCount = spenObjectTable.getRowsCount() - 1; -1 < rowsCount; rowsCount--) {
                    if (!linkedHashSet.contains(Integer.valueOf(rowsCount))) {
                        spenObjectTable.getRowHeight(rowsCount);
                        spenObjectTable2.deleteRow(rowsCount);
                    }
                }
                rect.width();
                for (int columnsCount = spenObjectTable.getColumnsCount() - 1; -1 < columnsCount; columnsCount--) {
                    if (!linkedHashSet2.contains(Integer.valueOf(columnsCount))) {
                        spenObjectTable.getColumnWidth(columnsCount);
                        spenObjectTable2.deleteColumn(columnsCount);
                    }
                }
                selectedList.remove(spenObjectBase2);
                selectedList.add(spenObjectTable2);
            }
        }
        for (int i = 0; i < size; i++) {
            SpenObjectBase spenObjectBase3 = selectedList.get(i);
            Intrinsics.checkNotNullExpressionValue(spenObjectBase3, "get(...)");
            SpenObjectBase spenObjectBase4 = spenObjectBase3;
            if (spenObjectBase4 instanceof SpenObjectShapeBase) {
                selectedList.addAll(((SpenObjectShapeBase) spenObjectBase4).getFollowers());
            }
        }
    }

    private final void convertTableToHtml(List<? extends List<? extends SpannableString>> rows) {
        StringBuilder sb = new StringBuilder("<table border='1'>");
        for (List<? extends SpannableString> list : rows) {
            sb.append("<tr>");
            for (SpannableString spannableString : list) {
                this.plainText = this.plainText + ((Object) spannableString) + "\n";
                sb.append("<td>");
                sb.append(HtmlUtils.toHtml(spannableString));
                sb.append("</td>");
            }
            this.plainText = AbstractC0541b.m756B(this.plainText, "\n");
            sb.append("</tr>");
        }
        sb.append("</table>");
        this.htmlText = this.htmlText + ((Object) sb);
    }

    private final String makeBackupFileName() {
        return AbstractC0541b.m772n(ClipboardCacheManager.CLIPBOARD_HW_OBJECT_PREFIX, ClipboardCacheManager.getDateString());
    }

    @NotNull
    public final CopyResult copyObject(@NotNull Context context, @NotNull SpenWNote note, @Nullable ArrayList<SpenObjectBase> selectedList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(note, "note");
        this.backupFileName = makeBackupFileName();
        if (selectedList != null) {
            addShapeFollowers(selectedList);
            convertTableObject(selectedList);
        } else {
            selectedList = new ArrayList<>(1);
        }
        this.contract.addPdfImageObject(context, this.backupFileName, selectedList);
        convertObjectToHtml(context, note, selectedList);
        return new CopyResult(this.mimeType, this.thumbnailUri, this.plainText, this.htmlText);
    }

    @Nullable
    public final String getBackupPath() {
        return this.backupPath;
    }

    @NotNull
    public final String getHtmlText() {
        return this.htmlText;
    }

    @NotNull
    public final String[] getMimeType() {
        return this.mimeType;
    }

    @NotNull
    public final String getPlainText() {
        return this.plainText;
    }

    public final void setBackupPath(@Nullable String str) {
        this.backupPath = str;
    }

    public final void setHtmlText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.htmlText = str;
    }

    public final void setMimeType(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mimeType = strArr;
    }

    public final void setPlainText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.plainText = str;
    }
}
