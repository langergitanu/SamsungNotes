package com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor;

import android.content.Context;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.LMemoConverter;
import com.samsung.android.support.senl.document.memoconverter.NMemoConverter;
import com.samsung.android.support.senl.document.memoconverter.SNBConverter;
import com.samsung.android.support.senl.document.memoconverter.SPDConverter;
import com.samsung.android.support.senl.document.memoconverter.ScrapBookConverter;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0007J,\u0010\u0018\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0007J4\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0007J9\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010 H\u0007¢\u0006\u0002\u0010!JE\u0010\u001b\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010 2\u0006\u0010\u0014\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\"J,\u0010#\u001a\u00020$2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010&\u001a\u00020'2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010*\u001a\u00020+2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020\u0011H\u0007J&\u0010-\u001a\u00020.2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u00101\u001a\u0002022\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/constructor/DocumentConstructor;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "makeSpenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "context", "Landroid/content/Context;", "filePath", "password", DBSchema.Document.PAGE_MODE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$PageMode;", "orientation", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote$Orientation;", "pageFixedAxisSize", "", "isCoeditMode", "", "mode", "discardUnsavedData", "skipCorruptedFileInfo", "isCoEditMode", "makeSpenNoteDoc", "Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "width", "makeSpenSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "fileFullPath", "confirmResult", "passwordList", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;I)Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "makeSpenPaintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "height", "makeSPDConverter", "Lcom/samsung/android/support/senl/document/memoconverter/SPDConverter;", "makeSNBConverter", "Lcom/samsung/android/support/senl/document/memoconverter/SNBConverter;", "makeScrapBookConverter", "Lcom/samsung/android/support/senl/document/memoconverter/ScrapBookConverter;", "maxTextureSize", "makeNMemoConverter", "Lcom/samsung/android/support/senl/document/memoconverter/NMemoConverter;", "dbFileName", "attachedFileName", "makeLMemoConverter", "Lcom/samsung/android/support/senl/document/memoconverter/LMemoConverter;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocumentConstructor {

    @NotNull
    public static final DocumentConstructor INSTANCE = new DocumentConstructor();

    @NotNull
    private static final String TAG = LoggerBase.INSTANCE.createTag("DocumentConstructor");

    private DocumentConstructor() {
    }

    @JvmStatic
    @NotNull
    public static final LMemoConverter makeLMemoConverter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new LMemoConverter(context);
    }

    @JvmStatic
    @NotNull
    public static final NMemoConverter makeNMemoConverter(@Nullable Context context, @Nullable String dbFileName, @Nullable String attachedFileName) {
        return new NMemoConverter(context, dbFileName, attachedFileName);
    }

    @JvmStatic
    @NotNull
    public static final SNBConverter makeSNBConverter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SNBConverter(context);
    }

    @JvmStatic
    @NotNull
    public static final SPDConverter makeSPDConverter(@Nullable Context context) {
        return new SPDConverter(context);
    }

    @JvmStatic
    @NotNull
    public static final ScrapBookConverter makeScrapBookConverter(@Nullable Context context, int maxTextureSize) {
        return new ScrapBookConverter(context, maxTextureSize);
    }

    @JvmStatic
    @NotNull
    public static final SpenNoteDoc makeSpenNoteDoc(@Nullable Context context, @Nullable String filePath, int width, int mode) {
        return new SpenNoteDoc(context, filePath, width, mode);
    }

    @JvmStatic
    @NotNull
    public static final SpenPaintingDoc makeSpenPaintingDoc(@Nullable Context context, int width, int height, @Nullable String filePath) {
        return new SpenPaintingDoc(context, width, height, filePath);
    }

    @JvmStatic
    @NotNull
    public static final SpenSDoc makeSpenSDoc(@NotNull Context context, @NotNull String fileFullPath, @Nullable String confirmResult, @Nullable String[] passwordList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileFullPath, "fileFullPath");
        return new SpenSDoc(context, fileFullPath, confirmResult, passwordList);
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote makeSpenWNote(@NotNull Context context, @NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        SpenWNote spenWNote = new SpenWNote(context, filePath, password);
        SpenDocumentHelper.updateDefaultHeight(spenWNote);
        return spenWNote;
    }

    @JvmStatic
    @NotNull
    public static final SpenNoteDoc makeSpenNoteDoc(@NotNull Context context, @Nullable String filePath, @Nullable String password, int width, int mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SpenNoteDoc(context, filePath, password, width, mode);
    }

    @JvmStatic
    @NotNull
    public static final SpenSDoc makeSpenSDoc(@Nullable Context context, @Nullable String fileFullPath, @Nullable String confirmResult, @Nullable String[] passwordList, int mode) {
        return new SpenSDoc(context, fileFullPath, confirmResult, passwordList, mode);
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote makeSpenWNote(@NotNull Context context, @NotNull SpenWNote.PageMode pageMode, @NotNull SpenWNote.Orientation orientation, int pageFixedAxisSize, boolean isCoeditMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pageMode, "pageMode");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        LoggerBase.INSTANCE.printNativeHeapMemory(TAG, "makeSPenWNote#");
        SpenWNote spenWNote = new SpenWNote(context, null, pageMode, orientation, pageFixedAxisSize, isCoeditMode);
        SpenDocumentHelper.updateDefaultHeight(spenWNote);
        return spenWNote;
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote makeSpenWNote(@NotNull Context context, @NotNull String filePath, int pageFixedAxisSize, int mode, boolean discardUnsavedData, boolean isCoeditMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return makeSpenWNote(context, filePath, pageFixedAxisSize, mode, discardUnsavedData, false, isCoeditMode);
    }

    @JvmStatic
    @NotNull
    public static final SpenWNote makeSpenWNote(@NotNull Context context, @NotNull String filePath, int pageFixedAxisSize, int mode, boolean discardUnsavedData, boolean skipCorruptedFileInfo, boolean isCoEditMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        LoggerBase.INSTANCE.printNativeHeapMemory(TAG, "makeSPenWNote#");
        SpenWNote spenWNote = new SpenWNote(context, filePath, pageFixedAxisSize, mode, discardUnsavedData, skipCorruptedFileInfo, isCoEditMode);
        SpenDocumentHelper.updateDefaultHeight(spenWNote);
        return spenWNote;
    }
}
