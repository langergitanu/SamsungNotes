package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.URLSpan;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectShapeBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipDataBackupPath;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.composer.content.ObjectTypeHelper;
import com.samsung.android.support.senl.p148nt.base.composer.share.BaseShareUtil;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.SpenObjectTextFactory;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001;B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J.\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00162\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00190&j\b\u0012\u0004\u0012\u00020\u0019`'J\u0006\u0010(\u001a\u00020\u0003J\u0016\u0010)\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0003J&\u0010+\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003J(\u0010-\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002J\"\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0003H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u000203H\u0002J:\u00104\u001a\u0004\u0018\u00010/2\u0006\u0010\"\u001a\u00020#2\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u00102\u001a\u000203H\u0002J(\u00109\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002J\u0006\u0010:\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000f¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContentMaker;", "", "tag", "", "contract", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContentMaker$Contract;", "<init>", "(Ljava/lang/String;Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContentMaker$Contract;)V", "getTag", "()Ljava/lang/String;", "getContract", "()Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContentMaker$Contract;", "backupFileName", "getBackupFileName", "setBackupFileName", "(Ljava/lang/String;)V", "backupPath", "getBackupPath", "setBackupPath", "createDropContentWithContentList", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContent;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "sources", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "selectedText", "copyText", "", "obj", "dropContent", "str", "insertObject", "makeBackupNote", "context", "Landroid/content/Context;", "originalNote", "objectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "makeFileName", "makeFilePath", "baseFileName", "fillDropContent", "clipboardSDoc", "convertObjectToDropContent", "getContainerSpannableString", "Landroid/text/SpannableString;", "getWebSpannableString", "webUri", "isNotLast", "", "getImageSpannableString", "clipboardPath", "index", "", "contentBase", "convertTextToDropContent", "clear", "Contract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DropContentMaker {

    @NotNull
    private String backupFileName;

    @NotNull
    private String backupPath;

    @NotNull
    private final Contract contract;

    @NotNull
    private final String tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH&J&\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H&¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContentMaker$Contract;", "", "isFocusedTextBox", "", "copyObjectSpanText", "", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "dropContent", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DropContent;", "getSelectedObjectBitmap", "Landroid/graphics/Bitmap;", "createObjectSpanConverter", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$IObjectSpanConverter;", "context", "Landroid/content/Context;", "baseName", "", "saveAsImage", "imageObject", "pathDir", "fileName", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void copyObjectSpanText(@NotNull Contract contract, @NotNull SpenWNote note, @NotNull SpenObjectBase obj, @NotNull DropContent dropContent) {
                Intrinsics.checkNotNullParameter(note, "note");
                Intrinsics.checkNotNullParameter(obj, "obj");
                Intrinsics.checkNotNullParameter(dropContent, "dropContent");
            }
        }

        void copyObjectSpanText(@NotNull SpenWNote note, @NotNull SpenObjectBase obj, @NotNull DropContent dropContent);

        @Nullable
        ConvertSpenTextToSpannable.IObjectSpanConverter createObjectSpanConverter(@NotNull Context context, @NotNull String baseName, @NotNull DropContent dropContent);

        @Nullable
        Bitmap getSelectedObjectBitmap();

        boolean isFocusedTextBox();

        @NotNull
        String saveAsImage(@Nullable SpenObjectBase imageObject, @Nullable String pathDir, @Nullable String fileName);
    }

    public DropContentMaker(@NotNull String tag, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.tag = tag;
        this.contract = contract;
        this.backupFileName = "";
        this.backupPath = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void convertObjectToDropContent(Context context, DropContent dropContent, String baseFileName, String clipboardSDoc) {
        CharSequence charSequenceConcat;
        CharSequence charSequenceConcat2;
        SpannableString spannableStringValueOf;
        String str;
        CharSequence charSequenceConcat3;
        CharSequence charSequenceConcat4;
        SpannableString imageSpannableString;
        String title;
        DropContentMaker dropContentMaker = this;
        Context context2 = context;
        char c = 0;
        char c2 = 1;
        if (ObjectTypeHelper.INSTANCE.hasStrokeAndMathPlotType(dropContent.contentList)) {
            Logger.m8702i(dropContentMaker.tag, "convertObjectToDropContent# hasStrokeType is true.");
            SpannableString containerSpannableString = getContainerSpannableString(context, dropContent, baseFileName);
            if (containerSpannableString != null) {
                charSequenceConcat2 = TextUtils.concat("", containerSpannableString);
                Intrinsics.checkNotNullExpressionValue(charSequenceConcat2, "concat(...)");
                charSequenceConcat = TextUtils.concat("", HtmlUtils.toHtml(containerSpannableString));
                Intrinsics.checkNotNullExpressionValue(charSequenceConcat, "concat(...)");
            } else {
                charSequenceConcat = "";
                charSequenceConcat2 = charSequenceConcat;
            }
        }
        int size = dropContent.contentList.size();
        CharSequence charSequence = charSequenceConcat;
        CharSequence charSequence2 = charSequenceConcat2;
        int i = 0;
        DropContentMaker dropContentMaker2 = dropContentMaker;
        while (i < size) {
            SpenObjectBase spenObjectBase = dropContent.contentList.get(i);
            int type = spenObjectBase.getType();
            char c4 = c;
            char c5 = c2;
            Logger.m8702i(dropContentMaker2.tag, "convertObjectToDropContent# type : " + type);
            boolean z = i < size + (-1) ? c5 : c4;
            if (type != 2) {
                if (type == 3) {
                    String clipboardFileName = ClipboardCacheManager.getClipboardFileName(context2, baseFileName, "");
                    Intrinsics.checkNotNull(clipboardFileName);
                    Intrinsics.checkNotNull(spenObjectBase);
                    imageSpannableString = dropContentMaker2.getImageSpannableString(context2, clipboardFileName, i, spenObjectBase, dropContent, z);
                    spannableStringValueOf = imageSpannableString;
                } else {
                    if (type == 10) {
                        String str2 = dropContentMaker2.tag;
                        Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectVoice");
                        SpenObjectVoice spenObjectVoice = (SpenObjectVoice) spenObjectBase;
                        Uri audioClipDataContentUri = BaseShareUtil.getAudioClipDataContentUri(str2, context2, baseFileName, spenObjectVoice);
                        if (audioClipDataContentUri != null) {
                            dropContent.uriList.add(audioClipDataContentUri);
                            title = spenObjectVoice.getTitle();
                        } else {
                            spannableStringValueOf = null;
                        }
                    } else if (type == 17) {
                        Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLink");
                        title = ((SpenObjectLink) spenObjectBase).getTitle();
                    } else if (type != 13) {
                        if (type != 14) {
                            AbstractC4539a.m3212v(type, "convertObjectToDropContent# The type is not support. ", dropContentMaker2.tag);
                        }
                        String clipboardFileName2 = ClipboardCacheManager.getClipboardFileName(context2, baseFileName, "");
                        Intrinsics.checkNotNull(clipboardFileName2);
                        Intrinsics.checkNotNull(spenObjectBase);
                        imageSpannableString = dropContentMaker2.getImageSpannableString(context2, clipboardFileName2, i, spenObjectBase, dropContent, z);
                        spannableStringValueOf = imageSpannableString;
                    } else {
                        Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectWeb");
                        String uri = ((SpenObjectWeb) spenObjectBase).getUri();
                        Intrinsics.checkNotNull(uri);
                        imageSpannableString = dropContentMaker2.getWebSpannableString(uri, z);
                        spannableStringValueOf = imageSpannableString;
                    }
                    str = title;
                    spannableStringValueOf = null;
                    if (spannableStringValueOf == null) {
                        CharSequence[] charSequenceArr = new CharSequence[2];
                        charSequenceArr[c4] = charSequence2;
                        charSequenceArr[c5] = spannableStringValueOf;
                        charSequenceConcat3 = TextUtils.concat(charSequenceArr);
                        Intrinsics.checkNotNullExpressionValue(charSequenceConcat3, "concat(...)");
                        String html = HtmlUtils.toHtml(spannableStringValueOf);
                        CharSequence[] charSequenceArr2 = new CharSequence[2];
                        charSequenceArr2[c4] = charSequence;
                        charSequenceArr2[c5] = html;
                        charSequenceConcat4 = TextUtils.concat(charSequenceArr2);
                        Intrinsics.checkNotNullExpressionValue(charSequenceConcat4, "concat(...)");
                    } else if (!TextUtils.isEmpty(str)) {
                        String str3 = z != 0 ? "\n" : "";
                        CharSequence[] charSequenceArr3 = new CharSequence[3];
                        charSequenceArr3[c4] = charSequence2;
                        charSequenceArr3[c5] = str;
                        charSequenceArr3[2] = str3;
                        charSequenceConcat3 = TextUtils.concat(charSequenceArr3);
                        Intrinsics.checkNotNullExpressionValue(charSequenceConcat3, "concat(...)");
                        String str4 = z != 0 ? "<br>\n" : "";
                        CharSequence[] charSequenceArr4 = new CharSequence[3];
                        charSequenceArr4[c4] = charSequence;
                        charSequenceArr4[c5] = str;
                        charSequenceArr4[2] = str4;
                        charSequenceConcat4 = TextUtils.concat(charSequenceArr4);
                        Intrinsics.checkNotNullExpressionValue(charSequenceConcat4, "concat(...)");
                    }
                    charSequence2 = charSequenceConcat3;
                    charSequence = charSequenceConcat4;
                }
                i++;
                dropContentMaker2 = this;
                context2 = context;
                c = c4;
                c2 = c5;
            } else {
                HandleTextBox handleTextBox = new HandleTextBox();
                Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectTextBox");
                spannableStringValueOf = SpannableString.valueOf(handleTextBox.handleText(new HandleTextBox.InputBuilder((SpenObjectTextBox) spenObjectBase).done()));
            }
            str = null;
            if (spannableStringValueOf == null) {
            }
            charSequence2 = charSequenceConcat3;
            charSequence = charSequenceConcat4;
            i++;
            dropContentMaker2 = this;
            context2 = context;
            c = c4;
            c2 = c5;
        }
        dropContent.plainText = charSequence2.toString();
        dropContent.htmlText = StringsKt.m14139M(((Object) charSequence) + ClipDataBackupPath.getClipDataBackupPath(clipboardSDoc), "<img src=", "<img style=\"max-width: 100%;\" src=");
    }

    private final void convertTextToDropContent(Context context, DropContent dropContent, String baseFileName, String clipboardSDoc) {
        SpenObjectBase spenObjectBase = dropContent.contentList.get(0);
        Intrinsics.checkNotNull(spenObjectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
        CharSequence charSequenceHandleText = new HandleTextBox().handleText(new HandleTextBox.InputBuilder((SpenObjectShape) spenObjectBase).setConverter(this.contract.createObjectSpanConverter(context, baseFileName, dropContent)).done());
        dropContent.plainText = charSequenceHandleText.toString();
        dropContent.htmlText = StringsKt.m14139M(HtmlUtils.toHtml(SpannableString.valueOf(charSequenceHandleText)) + ClipDataBackupPath.getClipDataBackupPath(clipboardSDoc), "<img src=", "<img style=\"max-width: 100%;\" src=");
    }

    private final void copyText(SpenObjectBase obj, DropContent dropContent) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
        SpenObjectShape spenObjectShape = (SpenObjectShape) obj;
        if (TextUtils.isEmpty(spenObjectShape.getText())) {
            Logger.m8698e(this.tag, "copyText# getText() is empty");
            return;
        }
        int[] cursor = TextUtil.getCursor(spenObjectShape);
        Intrinsics.checkNotNullExpressionValue(cursor, "getCursor(...)");
        dropContent.contentList.add(SpenObjectTextFactory.INSTANCE.copyText(spenObjectShape, cursor[0], cursor[1] - 1));
        dropContent.selection = cursor;
        dropContent.contentType = 2;
    }

    private final SpannableString getContainerSpannableString(Context context, DropContent dropContent, String baseFileName) {
        Bitmap selectedObjectBitmap = this.contract.getSelectedObjectBitmap();
        if (selectedObjectBitmap == null) {
            return null;
        }
        String clipboardFileName = ClipboardCacheManager.getClipboardFileName(context, baseFileName, baseFileName + ".jpg");
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        Intrinsics.checkNotNull(clipboardFileName);
        imageUtils.saveBitmapToFileCache(selectedObjectBitmap, clipboardFileName, Bitmap.CompressFormat.JPEG, 95);
        selectedObjectBitmap.recycle();
        if (!AbstractC2322a.m1607A(clipboardFileName)) {
            return null;
        }
        Uri uri = ClipDataContentProvider.INSTANCE.getUri(clipboardFileName);
        dropContent.uriList.add(uri);
        return BaseShareUtil.makeImageSpan(this.tag, context, uri, false);
    }

    private final SpannableString getImageSpannableString(Context context, String clipboardPath, int index, SpenObjectBase contentBase, DropContent dropContent, boolean isNotLast) {
        String strSaveAsImage = this.contract.saveAsImage(contentBase, clipboardPath, String.valueOf(index + 1));
        if (TextUtils.isEmpty(strSaveAsImage)) {
            Logger.m8697d(this.tag, "convertObjectToTextHtml# ImageContent, newPath is null");
            return null;
        }
        if (!AbstractC2322a.m1607A(strSaveAsImage)) {
            return null;
        }
        Uri uri = ClipDataContentProvider.INSTANCE.getUri(strSaveAsImage);
        dropContent.uriList.add(uri);
        return BaseShareUtil.makeImageSpan(this.tag, context, uri, isNotLast);
    }

    private final SpannableString getWebSpannableString(String webUri, boolean isNotLast) {
        if (TextUtils.isEmpty(webUri)) {
            Logger.m8697d(this.tag, "convertObjectToTextHtml# WebCardContent, path is null");
            return null;
        }
        SpannableString spannableString = new SpannableString(AbstractC0541b.m756B(webUri, isNotLast ? MarkdownDocument.NEW_LINE : ""));
        spannableString.setSpan(new URLSpan(webUri), 0, webUri.length(), 33);
        return spannableString;
    }

    private final void insertObject(SpenObjectBase obj, DropContent dropContent) {
        dropContent.contentList.add(obj);
        if (obj instanceof SpenObjectShapeBase) {
            dropContent.contentList.addAll(((SpenObjectShapeBase) obj).getFollowers());
        }
        dropContent.contentType = 1;
    }

    public final void clear() {
        this.backupFileName = "";
        this.backupPath = "";
    }

    @NotNull
    public final DropContent createDropContentWithContentList(@NotNull SpenWNote note, @Nullable List<? extends SpenObjectBase> sources) {
        Intrinsics.checkNotNullParameter(note, "note");
        return createDropContentWithContentList(note, sources, null);
    }

    public final void fillDropContent(@NotNull Context context, @NotNull DropContent dropContent, @NotNull String baseFileName, @NotNull String clipboardSDoc) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dropContent, "dropContent");
        Intrinsics.checkNotNullParameter(baseFileName, "baseFileName");
        Intrinsics.checkNotNullParameter(clipboardSDoc, "clipboardSDoc");
        AbstractC4539a.m3212v(dropContent.contentType, "fillDropContent# ", this.tag);
        if (dropContent.contentType == 1) {
            convertObjectToDropContent(context, dropContent, baseFileName, clipboardSDoc);
        } else {
            convertTextToDropContent(context, dropContent, baseFileName, clipboardSDoc);
        }
    }

    @NotNull
    public final String getBackupFileName() {
        return this.backupFileName;
    }

    @NotNull
    public final String getBackupPath() {
        return this.backupPath;
    }

    @NotNull
    public final Contract getContract() {
        return this.contract;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public final void makeBackupNote(@NotNull Context context, @NotNull SpenWNote originalNote, @NotNull ArrayList<SpenObjectBase> objectList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originalNote, "originalNote");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        String strMakeFileName = makeFileName();
        this.backupFileName = strMakeFileName;
        String strMakeFilePath = makeFilePath(context, strMakeFileName);
        this.backupPath = strMakeFilePath;
        originalNote.backupObjectList(objectList, strMakeFilePath);
    }

    @NotNull
    public final String makeFileName() {
        return AbstractC0541b.m772n(ClipboardCacheManager.CLIPBOARD_CONTENT_PREFIX, ClipboardCacheManager.getDateString());
    }

    @NotNull
    public final String makeFilePath(@NotNull Context context, @NotNull String baseFileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseFileName, "baseFileName");
        return AbstractC2821a.m2221l(ClipboardCacheManager.getClipboardPath(context).getAbsolutePath(), "/", baseFileName, ".sdocx");
    }

    public final void setBackupFileName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backupFileName = str;
    }

    public final void setBackupPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backupPath = str;
    }

    @NotNull
    public final DropContent createDropContentWithContentList(@NotNull SpenWNote note, @Nullable List<? extends SpenObjectBase> sources, @Nullable String selectedText) {
        ArrayList<Pair<Integer, Integer>> selectedCellPositions;
        Pair pair;
        Intrinsics.checkNotNullParameter(note, "note");
        DropContent dropContent = new DropContent();
        List<? extends SpenObjectBase> list = sources;
        if (list != null && !list.isEmpty()) {
            for (SpenObjectBase spenObjectBase : sources) {
                if (spenObjectBase != null) {
                    ObjectTypeHelper objectTypeHelper = ObjectTypeHelper.INSTANCE;
                    if (objectTypeHelper.isTableType(spenObjectBase.getType())) {
                        SpenObjectTable spenObjectTable = spenObjectBase instanceof SpenObjectTable ? (SpenObjectTable) spenObjectBase : null;
                        if (spenObjectTable != null && (selectedCellPositions = spenObjectTable.getSelectedCellPositions()) != null && (pair = (Pair) CollectionsKt.firstOrNull((List) selectedCellPositions)) != null) {
                            copyText(spenObjectTable.getContentObject(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue()), dropContent);
                        }
                    } else if (objectTypeHelper.isTextType(spenObjectBase.getType()) && this.contract.isFocusedTextBox()) {
                        copyText(spenObjectBase, dropContent);
                    } else if (spenObjectBase.belongsToSpan()) {
                        this.contract.copyObjectSpanText(note, spenObjectBase, dropContent);
                    } else {
                        insertObject(spenObjectBase, dropContent);
                    }
                }
            }
        } else if (!TextUtils.isEmpty(selectedText)) {
            Intrinsics.checkNotNull(selectedText);
            copyText(selectedText, dropContent);
        }
        return dropContent;
    }

    private final void copyText(String str, DropContent dropContent) {
        SpenObjectTextBox spenObjectTextBoxMakeObjectTextBox = SpenObjectConstructor.makeObjectTextBox(str);
        int[] iArr = {0, str.length()};
        dropContent.contentList.add(spenObjectTextBoxMakeObjectTextBox);
        dropContent.selection = iArr;
        dropContent.contentType = 2;
    }
}
