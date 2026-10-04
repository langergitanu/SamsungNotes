package com.samsung.android.support.senl.p148nt.base.composer.action.copy;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.TextCopy;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipDataBackupPath;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.SpenObjectTextFactory;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001f !B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ.\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/action/copy/TextCopy;", "", "tag", "", "contract", "Lcom/samsung/android/support/senl/nt/base/composer/action/copy/TextCopy$Contract;", "<init>", "(Ljava/lang/String;Lcom/samsung/android/support/senl/nt/base/composer/action/copy/TextCopy$Contract;)V", "getTag", "()Ljava/lang/String;", "getContract", "()Lcom/samsung/android/support/senl/nt/base/composer/action/copy/TextCopy$Contract;", "backupFileName", "backupPath", "getBackupPath", "setBackupPath", "(Ljava/lang/String;)V", "copiedTextObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "copyText", "Lcom/samsung/android/support/senl/nt/base/composer/action/copy/CopyResult;", "context", "Landroid/content/Context;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", ExternalDataConstants.Column.TEXT_BOX, "startPos", "", "endPos", "backupToNote", "", "Companion", "Contract", "IObjectSpanConverter", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextCopy {
    public static final int CLIP_DATA_MAXIMUM_STRING_LENGTH = 40000;

    @Nullable
    private String backupFileName;

    @Nullable
    private String backupPath;

    @NotNull
    private final Contract contract;

    @Nullable
    private SpenObjectShape copiedTextObject;

    @NotNull
    private final String tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/action/copy/TextCopy$Contract;", "", "makeObjectSpanConverter", "Lcom/samsung/android/support/senl/nt/base/composer/action/copy/TextCopy$IObjectSpanConverter;", "context", "Landroid/content/Context;", "backupFileName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            @NotNull
            public static IObjectSpanConverter makeObjectSpanConverter(@NotNull Contract contract, @NotNull Context context, @NotNull String backupFileName) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(backupFileName, "backupFileName");
                return new IObjectSpanConverter() { // from class: com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy$Contract$makeObjectSpanConverter$1
                    @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.IObjectSpanConverter, com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
                    public void convert(List<SpenObjectSpan> list, SpannableStringBuilder spannableStringBuilder) {
                        TextCopy.IObjectSpanConverter.DefaultImpls.convert(this, list, spannableStringBuilder);
                    }

                    @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.IObjectSpanConverter
                    public String[] getMimeType() {
                        return TextCopy.IObjectSpanConverter.DefaultImpls.getMimeType(this);
                    }

                    @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.IObjectSpanConverter
                    public Uri getThumbnailUri() {
                        return TextCopy.IObjectSpanConverter.DefaultImpls.getThumbnailUri(this);
                    }
                };
            }
        }

        @NotNull
        IObjectSpanConverter makeObjectSpanConverter(@NotNull Context context, @NotNull String backupFileName);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/action/copy/TextCopy$IObjectSpanConverter;", "Lcom/samsung/android/support/senl/nt/base/common/util/ConvertSpenTextToSpannable$IObjectSpanConverter;", "getMimeType", "", "", "()[Ljava/lang/String;", "getThumbnailUri", "Landroid/net/Uri;", MarkdownConverter.PREFIX_NAME, "", "objectSpanList", "", "Lcom/samsung/android/sdk/pen/document/textspan/SpenObjectSpan;", "result", "Landroid/text/SpannableStringBuilder;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IObjectSpanConverter extends ConvertSpenTextToSpannable.IObjectSpanConverter {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void convert(@NotNull IObjectSpanConverter iObjectSpanConverter, @NotNull List<SpenObjectSpan> objectSpanList, @NotNull SpannableStringBuilder result) {
                Intrinsics.checkNotNullParameter(objectSpanList, "objectSpanList");
                Intrinsics.checkNotNullParameter(result, "result");
            }

            @Nullable
            public static String[] getMimeType(@NotNull IObjectSpanConverter iObjectSpanConverter) {
                return new String[]{Constants.MIME_HTML};
            }

            @Nullable
            public static Uri getThumbnailUri(@NotNull IObjectSpanConverter iObjectSpanConverter) {
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
        void convert(@NotNull List<SpenObjectSpan> objectSpanList, @NotNull SpannableStringBuilder result);

        @Nullable
        String[] getMimeType();

        @Nullable
        Uri getThumbnailUri();
    }

    public TextCopy(@NotNull String tag, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.tag = tag;
        this.contract = contract;
    }

    public final void backupToNote(@NotNull Context context, @NotNull SpenWNote note, @NotNull SpenObjectShape textBox, int startPos, int endPos) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        ClipboardCacheManager.trimCache(context);
        String dateString = ClipboardCacheManager.getDateString();
        Intrinsics.checkNotNullExpressionValue(dateString, "getDateString(...)");
        this.backupFileName = ClipboardCacheManager.CLIPBOARD_BODY_TEXT_PREFIX + dateString;
        this.backupPath = AbstractC2821a.m2221l(ClipboardCacheManager.getClipboardPath(context).getAbsolutePath(), "/", this.backupFileName, ".sdocx");
        this.copiedTextObject = SpenObjectTextFactory.INSTANCE.copyText(textBox, startPos, endPos - 1);
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>(1);
        SpenObjectShape spenObjectShape = this.copiedTextObject;
        Intrinsics.checkNotNull(spenObjectShape);
        arrayList.add(spenObjectShape);
        note.backupObjectList(arrayList, this.backupPath);
    }

    @Nullable
    public final CopyResult copyText(@NotNull Context context, @NotNull SpenWNote note, @NotNull SpenObjectShape textBox, int startPos, int endPos) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(textBox, "textBox");
        String text = textBox.getText();
        int length = text != null ? text.length() : 0;
        String str = this.tag;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(length, startPos, "copyText# ", ", start : ", ", end : ");
        sbM1173s.append(endPos);
        Logger.m8702i(str, sbM1173s.toString());
        if (endPos < startPos || startPos > length || endPos > length || startPos < 0 || endPos < 0 || startPos == endPos) {
            Logger.m8698e(this.tag, "copyText: IndexOutOfBounds");
            return null;
        }
        backupToNote(context, note, textBox, startPos, endPos);
        Contract contract = this.contract;
        String str2 = this.backupFileName;
        Intrinsics.checkNotNull(str2);
        IObjectSpanConverter iObjectSpanConverterMakeObjectSpanConverter = contract.makeObjectSpanConverter(context, str2);
        CharSequence charSequenceHandleText = new HandleTextBox().handleText(new HandleTextBox.InputBuilder(this.copiedTextObject).setConverter(iObjectSpanConverterMakeObjectSpanConverter).done());
        try {
            String string = charSequenceHandleText.toString();
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = string.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (bytes.length > 40000) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bytes, 0, 40000);
                Intrinsics.checkNotNull(bArrCopyOfRange);
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                charSequenceHandleText = charSequenceHandleText.subSequence(0, new String(bArrCopyOfRange, UTF_8).length());
            }
        } catch (Exception e) {
            Logger.m8698e(this.tag, "copyText# get the byte size : " + e);
        }
        return new CopyResult(iObjectSpanConverterMakeObjectSpanConverter.getMimeType(), iObjectSpanConverterMakeObjectSpanConverter.getThumbnailUri(), iObjectSpanConverterMakeObjectSpanConverter.getThumbnailUri() == null ? charSequenceHandleText.toString() : StringsKt.trim((CharSequence) charSequenceHandleText.toString()).toString(), AbstractC0541b.m756B(HtmlUtils.toHtml(SpannableString.valueOf(charSequenceHandleText)), ClipDataBackupPath.getClipDataBackupPath(this.backupPath)));
    }

    @Nullable
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

    public final void setBackupPath(@Nullable String str) {
        this.backupPath = str;
    }
}
