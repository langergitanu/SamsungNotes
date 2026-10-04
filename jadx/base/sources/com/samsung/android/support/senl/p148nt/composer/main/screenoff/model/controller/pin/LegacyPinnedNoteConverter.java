package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.controller.pin;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.ConverterWrapperFactory;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocConvertParams;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.SDocXConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.creator.SpenDocCreator;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\u0014J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J$\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J(\u0010\u001f\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002R\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/LegacyPinnedNoteConverter;", "", "<init>", "()V", "mSDocPathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mSDocXPathList", "mReleaseType", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/LegacyPinnedNoteConverter$ReleaseType;", MarkdownConverter.PREFIX_NAME, "context", "Landroid/content/Context;", "uuid", "path", "isConverted", "", "()Z", "setReleaseType", "", "releaseType", "release", "convertToSDoc", "convertToSDocX", "sDocPath", "createSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "createSpenWNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "sDocXPath", "saveToDB", "spenWNote", "createDocumentEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentEntity;", "savePath", "ReleaseType", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nLegacyPinnedNoteConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyPinnedNoteConverter.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/LegacyPinnedNoteConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n1#2:211\n*E\n"})
public final class LegacyPinnedNoteConverter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SOLogger.createTag("LegacyPinnedNoteConverter");

    @Nullable
    private static volatile LegacyPinnedNoteConverter mInstance;

    @NotNull
    private final ArrayList<String> mSDocPathList = new ArrayList<>();

    @NotNull
    private final ArrayList<String> mSDocXPathList = new ArrayList<>();

    @NotNull
    private ReleaseType mReleaseType = ReleaseType.NONE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/LegacyPinnedNoteConverter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/LegacyPinnedNoteConverter;", "getInstance", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nLegacyPinnedNoteConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyPinnedNoteConverter.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/LegacyPinnedNoteConverter$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n1#2:211\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LegacyPinnedNoteConverter getInstance() {
            LegacyPinnedNoteConverter legacyPinnedNoteConverter;
            LegacyPinnedNoteConverter legacyPinnedNoteConverter2 = LegacyPinnedNoteConverter.mInstance;
            if (legacyPinnedNoteConverter2 != null) {
                return legacyPinnedNoteConverter2;
            }
            synchronized (this) {
                legacyPinnedNoteConverter = LegacyPinnedNoteConverter.mInstance;
                if (legacyPinnedNoteConverter == null) {
                    legacyPinnedNoteConverter = new LegacyPinnedNoteConverter();
                    LegacyPinnedNoteConverter.mInstance = legacyPinnedNoteConverter;
                }
            }
            return legacyPinnedNoteConverter;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/controller/pin/LegacyPinnedNoteConverter$ReleaseType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "SAVE", "SAVE_CACHE", "SAVE_PUSHED", "DISCARD", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ReleaseType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ReleaseType[] $VALUES;
        public static final ReleaseType NONE = new ReleaseType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final ReleaseType SAVE = new ReleaseType("SAVE", 1);
        public static final ReleaseType SAVE_CACHE = new ReleaseType("SAVE_CACHE", 2);
        public static final ReleaseType SAVE_PUSHED = new ReleaseType("SAVE_PUSHED", 3);
        public static final ReleaseType DISCARD = new ReleaseType("DISCARD", 4);

        private static final /* synthetic */ ReleaseType[] $values() {
            return new ReleaseType[]{NONE, SAVE, SAVE_CACHE, SAVE_PUSHED, DISCARD};
        }

        static {
            ReleaseType[] releaseTypeArr$values = $values();
            $VALUES = releaseTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(releaseTypeArr$values);
        }

        private ReleaseType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ReleaseType> getEntries() {
            return $ENTRIES;
        }

        public static ReleaseType valueOf(String str) {
            return (ReleaseType) Enum.valueOf(ReleaseType.class, str);
        }

        public static ReleaseType[] values() {
            return (ReleaseType[]) $VALUES.clone();
        }
    }

    private final String convertToSDoc(Context context, String path) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "convertToSDoc#");
        IDocumentConverter<?> iDocumentConverterCreateDocumentConverter = new ConverterWrapperFactory(context).createDocumentConverter(1);
        Intrinsics.checkNotNull(iDocumentConverterCreateDocumentConverter, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.spenwrapper.converter.external.model.IDocumentConverter<com.samsung.android.support.senl.cm.base.spenwrapper.converter.external.model.ISDocConvertParams>");
        ISDocConvertParams iSDocConvertParamsMakeParams = iDocumentConverterCreateDocumentConverter.makeParams(path, null);
        ConverterResult converterResultConvert = iSDocConvertParamsMakeParams != null ? iDocumentConverterCreateDocumentConverter.convert(iSDocConvertParamsMakeParams) : null;
        if ((converterResultConvert != null ? converterResultConvert.getPathList() : null) != null) {
            List<String> pathList = converterResultConvert.getPathList();
            Intrinsics.checkNotNull(pathList);
            if (!pathList.isEmpty()) {
                List<String> pathList2 = converterResultConvert.getPathList();
                Intrinsics.checkNotNull(pathList2);
                return pathList2.get(0);
            }
        }
        return null;
    }

    private final String convertToSDocX(Context context, String uuid, String sDocPath) {
        SpenWNote spenWNoteCreateSpenWNote;
        if (sDocPath == null) {
            sDocPath = "";
        }
        if (sDocPath.length() != 0) {
            String strM14139M = StringsKt.m14139M(sDocPath, ".sdoc", ".sdocx");
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            String encode = Logger.getEncode(sDocPath);
            String encode2 = Logger.getEncode(strM14139M);
            StringBuilder sbM16m = AbstractC0000a.m16m("convertToSDocX# uuid/sDocPath/sDocXPath ", uuid, "/", encode, "/");
            sbM16m.append(encode2);
            sOLogger.SOLoggerD(str, sbM16m.toString());
            SpenSDoc spenSDocCreateSDoc = createSDoc(context, sDocPath);
            if (spenSDocCreateSDoc != null && (spenWNoteCreateSpenWNote = createSpenWNote(context, strM14139M)) != null) {
                SDocXConverterWrapper sDocXConverterWrapper = new SDocXConverterWrapper(context);
                sDocXConverterWrapper.convert(spenSDocCreateSDoc, spenWNoteCreateSpenWNote);
                spenWNoteCreateSpenWNote.getTitle().setText("");
                spenWNoteCreateSpenWNote.setBackgroundColor(context.getColor(C9086R.color.screenoff_main_background), true);
                try {
                    DocumentFileManager.getInstance().saveAsDirectory(spenWNoteCreateSpenWNote, strM14139M);
                } catch (Exception e) {
                    AbstractC0000a.m24u("convertToSDocX# getMessage ", e.getMessage(), SOLogger.INSTANCE, TAG);
                }
                boolean zSaveToDB = !TextUtils.isEmpty(uuid) ? saveToDB(context, spenWNoteCreateSpenWNote, uuid, strM14139M) : false;
                try {
                    if (!spenSDocCreateSDoc.isClosed()) {
                        spenSDocCreateSDoc.close(true);
                    }
                } catch (Exception e2) {
                    AbstractC8014b.m7208j("convertToSDocX# getMessage ", e2.getMessage(), SOLogger.INSTANCE, TAG);
                }
                try {
                    DocumentFileManager.getInstance().close(strM14139M, spenWNoteCreateSpenWNote, true);
                } catch (Exception e3) {
                    AbstractC0000a.m24u("convertToSDocX# getMessage ", e3.getMessage(), SOLogger.INSTANCE, TAG);
                }
                sDocXConverterWrapper.release();
                if (zSaveToDB) {
                    return strM14139M;
                }
                return null;
            }
        }
        return null;
    }

    private final NotesDocumentEntity createDocumentEntity(String uuid, String savePath) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "createDocumentEntity#");
        NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
        notesDocumentEntity.setUuid(uuid);
        notesDocumentEntity.setFilePath(savePath);
        notesDocumentEntity.setCategoryUuid(PredefinedCategory.SCREEN_OFF_MEMO.getUuid());
        return notesDocumentEntity;
    }

    private final SpenSDoc createSDoc(Context context, String sDocPath) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "createSDoc#");
        return new SpenDocCreator(context).createSDoc(sDocPath);
    }

    private final SpenWNote createSpenWNote(Context context, String sDocXPath) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "createSpenWNote#");
        int i = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = DocumentPageRatio.PAGE_RATIO.getHeight(i);
        try {
            SpenWNote spenWNoteOpen = DocumentFileManager.getInstance().open(context, sDocXPath, SpenWNote.PageMode.SINGLE, SpenWNote.Orientation.PORTRAIT, i, false);
            Intrinsics.checkNotNullExpressionValue(spenWNoteOpen, "open(...)");
            spenWNoteOpen.setPageDefaultWidth(i);
            spenWNoteOpen.setPageDefaultHeight(height * 100);
            return spenWNoteOpen;
        } catch (IOException e) {
            AbstractC0000a.m24u("createSpenWNote# getMessage ", e.getMessage(), SOLogger.INSTANCE, TAG);
            return null;
        }
    }

    private final boolean saveToDB(Context context, SpenWNote spenWNote, String uuid, String sDocXPath) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "saveToDB#");
        return DocumentWriteResolver.save(context, true, sDocXPath, createDocumentEntity(uuid, sDocXPath), spenWNote, (String) null, true, "LegacyPinnedNoteConverter");
    }

    @Nullable
    public final String convert(@NotNull Context context, @NotNull String uuid, @NotNull String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("convert# uuid/ path ", uuid, "/", Logger.getEncode(path)));
        String strConvertToSDoc = convertToSDoc(context, path);
        if (strConvertToSDoc == null || !StringsKt.m14167w(strConvertToSDoc, ".sdocx")) {
            this.mSDocPathList.add(strConvertToSDoc);
            strConvertToSDoc = convertToSDocX(context, uuid, strConvertToSDoc);
        }
        this.mSDocXPathList.add(strConvertToSDoc);
        return strConvertToSDoc;
    }

    public final boolean isConverted() {
        return !this.mSDocXPathList.isEmpty();
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.mSDocPathList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            String str = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            sb.append(Logger.getEncode(next));
            sb.append(SQLKeyword.COMMA);
            try {
                if (next != null) {
                    str = next;
                }
                FileUtils.deleteFile(new File(str));
            } catch (Exception e) {
                AbstractC8014b.m7208j("release# getMessage ", e.getMessage(), SOLogger.INSTANCE, TAG);
            }
        }
        SOLogger.INSTANCE.SOLoggerD(TAG, "release# lSDocPathList " + ((Object) sb));
        if (this.mReleaseType == ReleaseType.DISCARD) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it2 = this.mSDocXPathList.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                String next2 = it2.next();
                sb2.append(Logger.getEncode(next2));
                sb2.append(SQLKeyword.COMMA);
                try {
                    if (next2 == null) {
                        next2 = "";
                    }
                    FileUtils.deleteFile(new File(next2));
                } catch (Exception e2) {
                    AbstractC8014b.m7208j("release# getMessage ", e2.getMessage(), SOLogger.INSTANCE, TAG);
                }
            }
            SOLogger.INSTANCE.SOLoggerD(TAG, "release# lSDocXPathList " + ((Object) sb2));
        }
        this.mSDocPathList.clear();
        this.mSDocXPathList.clear();
    }

    public final void setReleaseType(@NotNull ReleaseType releaseType) {
        Intrinsics.checkNotNullParameter(releaseType, "releaseType");
        this.mReleaseType = releaseType;
        SOLogger.INSTANCE.SOLoggerD(TAG, "setReleaseType# " + releaseType);
    }
}
