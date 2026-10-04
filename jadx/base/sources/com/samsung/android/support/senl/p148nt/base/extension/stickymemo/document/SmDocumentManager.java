package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.document;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenNoteFile;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentInitializer;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J/\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010'J'\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u001dJ\u0012\u0010+\u001a\u00020\u001d2\b\b\u0002\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020-H\u0002J\r\u0010/\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020-J\u0006\u00102\u001a\u00020-J\u0006\u00103\u001a\u00020\u001dJ\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u000206H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/document/SmDocumentManager;", "", "<init>", "()V", "doc", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getDoc", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setDoc", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "loadPath", "", "getLoadPath", "()Ljava/lang/String;", "setLoadPath", "(Ljava/lang/String;)V", "savePath", "getSavePath", "setSavePath", "lastFormatVer", "", "getLastFormatVer", "()I", "setLastFormatVer", "(I)V", "lastMinFormatVer", "getLastMinFormatVer", "setLastMinFormatVer", "loadDoc", "", "context", "Landroid/content/Context;", "path", "noteWidth", "fontSize", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Float;)V", "initDoc", "makeEmptyDoc", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Float;)Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "initBodyText", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;Ljava/lang/Float;)V", "save", "release", "removeCache", "", "isValidDoc", "getBackgroundColor", "()Ljava/lang/Integer;", "isDataChanged", "isEmptyDoc", "loggingContentType", "loggingTextInfo", ExternalDataConstants.Column.BODY_TEXT, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmDocumentManager {

    @NotNull
    private static final String STICKY_MEMO_FOLDER_NAME = "stickymemo";

    @Nullable
    private SpenWNote doc;
    private int lastFormatVer;
    private int lastMinFormatVer;

    @Nullable
    private String loadPath;

    @Nullable
    private String savePath;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("SmDocumentManager");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/document/SmDocumentManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "STICKY_MEMO_FOLDER_NAME", "getDefWidth", "", "context", "Landroid/content/Context;", "getDefHeight", "getMinHeight", "getCacheFolder", "Ljava/io/File;", "make", "", "makeSavePath", "folderName", "makeFileName", "getDefaultBackgroundColor", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSmDocumentManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmDocumentManager.kt\ncom/samsung/android/support/senl/nt/base/extension/stickymemo/document/SmDocumentManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,291:1\n1#2:292\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String makeSavePath$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.makeSavePath(context, str);
        }

        @JvmStatic
        @Nullable
        public final File getCacheFolder(@NotNull Context context, boolean make) {
            Intrinsics.checkNotNullParameter(context, "context");
            File cacheDir = context.getCacheDir();
            File file = cacheDir != null ? new File(AbstractC0541b.m757C(cacheDir.getPath(), File.separator, SmDocumentManager.STICKY_MEMO_FOLDER_NAME)) : null;
            if (file == null) {
                SmLogger.m8662e(SmDocumentManager.TAG, "getCacheFolder# folder is null");
                return null;
            }
            if (!file.exists() && make) {
                file.mkdir();
            }
            return file;
        }

        public final int getDefHeight(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getDefWidth(context) + context.getResources().getDimensionPixelSize(C8875R.dimen.top_menu_top_margin);
        }

        @JvmStatic
        public final int getDefWidth(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return DeviceUtils.isFoldableModel() ? context.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_fold_width) : DeviceUtils.isTabletModel() ? context.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_tablet_width) : context.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_phone_width);
        }

        @JvmStatic
        public final int getDefaultBackgroundColor(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getColor(C8875R.color.sticky_memo_bg_color1, null);
        }

        public final int getMinHeight(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return (DeviceUtils.isFoldableModel() ? context.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_fold_min_height) : DeviceUtils.isTabletModel() ? context.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_tablet_min_height) : context.getResources().getDimensionPixelSize(C8875R.dimen.sticky_memo_phone_min_height)) + context.getResources().getDimensionPixelSize(C8875R.dimen.top_menu_top_margin);
        }

        @JvmStatic
        @NotNull
        public final String makeFileName() {
            return AbstractC0541b.m773o("stickymemo_", new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())), ".sdocx");
        }

        @JvmStatic
        @JvmOverloads
        @Nullable
        public final String makeSavePath(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return makeSavePath$default(this, context, null, 2, null);
        }

        private Companion() {
        }

        @JvmStatic
        @JvmOverloads
        @Nullable
        public final String makeSavePath(@NotNull Context context, @Nullable String folderName) {
            Intrinsics.checkNotNullParameter(context, "context");
            File cacheFolder = getCacheFolder(context, true);
            if (cacheFolder == null) {
                SmLogger.m8662e(SmDocumentManager.TAG, "makeSavePath# cacheRoot is null");
                return null;
            }
            if (folderName != null) {
                cacheFolder = new File(AbstractC0541b.m757C(cacheFolder.getPath(), File.separator, folderName));
            }
            if (cacheFolder.exists()) {
                return AbstractC0541b.m757C(cacheFolder.getPath(), File.separator, makeFileName());
            }
            if (cacheFolder.mkdir()) {
                return AbstractC0541b.m757C(cacheFolder.getPath(), File.separator, makeFileName());
            }
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final File getCacheFolder(@NotNull Context context, boolean z) {
        return INSTANCE.getCacheFolder(context, z);
    }

    @JvmStatic
    public static final int getDefWidth(@NotNull Context context) {
        return INSTANCE.getDefWidth(context);
    }

    @JvmStatic
    public static final int getDefaultBackgroundColor(@NotNull Context context) {
        return INSTANCE.getDefaultBackgroundColor(context);
    }

    private final void initBodyText(Context context, SpenWNote doc, Float fontSize) {
        doc.getBodyText().setTextAlignment(0);
        doc.getBodyText().setTextColor(context.getResources().getColor(C8875R.color.composer_def_font_color, null));
        doc.getBodyText().setFontSize(fontSize != null ? fontSize.floatValue() : 15.0f);
        doc.getBodyText().setAutoFitOption(2);
    }

    private final void initDoc(SpenWNote doc) {
        doc.setPageDefaultHeight((int) (doc.getPageDefaultWidth() * 1.4142857f));
        new SpenDocumentInitializer().setPageVerticalPadding(doc);
    }

    private final boolean isValidDoc() {
        SpenWNote spenWNote = this.doc;
        return (spenWNote == null || spenWNote.isClosed()) ? false : true;
    }

    public static /* synthetic */ void loadDoc$default(SmDocumentManager smDocumentManager, Context context, String str, String str2, int i, Float f, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            f = null;
        }
        smDocumentManager.loadDoc(context, str, str2, i, f);
    }

    private final void loggingTextInfo(SpenObjectTextBox bodyText) {
        String text = bodyText.getText();
        Intrinsics.checkNotNull(text);
        boolean z = false;
        ArrayList<SpenTextSpanBase> arrayListFindTextSpan = bodyText.findTextSpan(0, text.length(), 1179882);
        if (arrayListFindTextSpan != null && arrayListFindTextSpan.size() > 2) {
            z = true;
        }
        NotesSamsungAnalytics.Companion companion = NotesSamsungAnalytics.INSTANCE;
        companion.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, StickyMemoSAConstants.EVENT_TEXT_TYPE, z ? "2" : "1");
        StickyMemoSAConstants stickyMemoSAConstants = StickyMemoSAConstants.INSTANCE;
        String text2 = bodyText.getText();
        Intrinsics.checkNotNull(text2);
        companion.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, StickyMemoSAConstants.EVENT_NUMBER_OF_LETTERS, stickyMemoSAConstants.getDetailLetterCount(text2.length()));
    }

    private final SpenWNote makeEmptyDoc(Context context, String path, int noteWidth, Float fontSize) {
        SpenWNote spenWNote = new SpenWNote(context, path, SpenWNote.PageMode.SINGLE, SpenWNote.Orientation.PORTRAIT, noteWidth, false);
        new SpenDocumentInitializer().setPageVerticalPadding(spenWNote);
        int i = (int) (noteWidth * 1.4142857f);
        spenWNote.setPageDefaultHeight(i);
        spenWNote.appendPage(noteWidth, i * 2, false);
        spenWNote.setBackgroundColor(INSTANCE.getDefaultBackgroundColor(context), false);
        spenWNote.setBodyTextFontSizeDelta(0);
        initBodyText(context, spenWNote, fontSize);
        spenWNote.clearHistory();
        return spenWNote;
    }

    @JvmStatic
    @NotNull
    public static final String makeFileName() {
        return INSTANCE.makeFileName();
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final String makeSavePath(@NotNull Context context) {
        return INSTANCE.makeSavePath(context);
    }

    public static /* synthetic */ void release$default(SmDocumentManager smDocumentManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        smDocumentManager.release(z);
    }

    @Nullable
    public final Integer getBackgroundColor() {
        SpenWPage page;
        SpenWNote spenWNote = this.doc;
        if (spenWNote == null || (page = spenWNote.getPage(0)) == null) {
            return null;
        }
        return Integer.valueOf(page.getBackgroundColor());
    }

    @Nullable
    public final SpenWNote getDoc() {
        return this.doc;
    }

    public final int getLastFormatVer() {
        return this.lastFormatVer;
    }

    public final int getLastMinFormatVer() {
        return this.lastMinFormatVer;
    }

    @Nullable
    public final String getLoadPath() {
        return this.loadPath;
    }

    @Nullable
    public final String getSavePath() {
        return this.savePath;
    }

    public final boolean isDataChanged() {
        SpenWNote spenWNote = this.doc;
        return (spenWNote == null || !spenWNote.isChanged() || spenWNote.isChangedOnlyThumbnail()) ? false : true;
    }

    public final boolean isEmptyDoc() {
        SpenWNote spenWNote = this.doc;
        if (spenWNote != null) {
            String text = spenWNote.getBodyText().getText();
            if (!TextUtils.isEmpty(text)) {
                Intrinsics.checkNotNull(text);
                if (!new Regex("\\s*").matches(text)) {
                    return false;
                }
            }
            Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenWPage next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (next.getObjectCount(true) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void loadDoc(@NotNull Context context, @NotNull String path, @NotNull String savePath, int noteWidth, @Nullable Float fontSize) {
        SpenWNote spenWNoteMakeEmptyDoc;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        SmLogger smLogger = SmLogger.INSTANCE;
        String strValueOf = String.valueOf(hashCode());
        String str = TAG;
        smLogger.startTime(strValueOf, str, AbstractC0541b.m767i(hashCode(), "(", ")loadDoc# start"));
        this.lastFormatVer = 0;
        this.lastMinFormatVer = 0;
        this.savePath = savePath;
        if (path.length() == 0) {
            String strMakeSavePath$default = Companion.makeSavePath$default(INSTANCE, context, null, 2, null);
            this.loadPath = strMakeSavePath$default;
            Intrinsics.checkNotNull(strMakeSavePath$default);
            this.doc = makeEmptyDoc(context, strMakeSavePath$default, noteWidth, fontSize);
        } else {
            this.loadPath = path;
            File file = new File(path);
            if (file.exists()) {
                String path2 = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                spenWNoteMakeEmptyDoc = DocumentConstructor.makeSpenWNote(context, path2, noteWidth, 1000, false, false);
                initDoc(spenWNoteMakeEmptyDoc);
            } else {
                spenWNoteMakeEmptyDoc = makeEmptyDoc(context, path, noteWidth, fontSize);
            }
            this.doc = spenWNoteMakeEmptyDoc;
        }
        smLogger.endTime(String.valueOf(hashCode()), str, AbstractC0541b.m767i(hashCode(), "(", ")loadDoc# end"));
    }

    public final void loggingContentType() {
        SpenWNote spenWNote = this.doc;
        if (spenWNote != null) {
            SmLogger smLogger = SmLogger.INSTANCE;
            String strValueOf = String.valueOf(hashCode());
            String str = TAG;
            smLogger.startTime(strValueOf, str, "getContentType# start");
            String text = spenWNote.getBodyText().getText();
            boolean z = text != null && StringsKt.trim((CharSequence) text).toString().length() > 0;
            boolean z2 = spenWNote.getPage(0).getObjectCount(true) > 0;
            NotesSamsungAnalytics.INSTANCE.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE, "403", (z && z2) ? "3" : z ? "1" : z2 ? "2" : "0");
            if (z) {
                loggingTextInfo(spenWNote.getBodyText());
            }
            smLogger.endTime(String.valueOf(hashCode()), str, "getContentType# end");
        }
    }

    @JvmOverloads
    public final void release() {
        release$default(this, false, 1, null);
    }

    public final void save() throws IOException {
        if (isValidDoc()) {
            SmLogger.m8661d(TAG, "save#");
            SpenWNote spenWNote = this.doc;
            Intrinsics.checkNotNull(spenWNote);
            spenWNote.saveAsFile(this.savePath);
            this.lastFormatVer = SpenWNoteFile.getMinFormatVersion(this.savePath);
            this.lastMinFormatVer = SpenWNoteFile.getFormatVersion(this.savePath);
            this.lastFormatVer = SpenNoteFile.getFormatVersion(this.savePath);
        }
    }

    public final void setDoc(@Nullable SpenWNote spenWNote) {
        this.doc = spenWNote;
    }

    public final void setLastFormatVer(int i) {
        this.lastFormatVer = i;
    }

    public final void setLastMinFormatVer(int i) {
        this.lastMinFormatVer = i;
    }

    public final void setLoadPath(@Nullable String str) {
        this.loadPath = str;
    }

    public final void setSavePath(@Nullable String str) {
        this.savePath = str;
    }

    @JvmStatic
    @JvmOverloads
    @Nullable
    public static final String makeSavePath(@NotNull Context context, @Nullable String str) {
        return INSTANCE.makeSavePath(context, str);
    }

    @JvmOverloads
    public final void release(boolean removeCache) {
        if (isValidDoc()) {
            SmLogger.m8661d(TAG, "(" + hashCode() + ")release# " + removeCache);
            SpenWNote spenWNote = this.doc;
            Intrinsics.checkNotNull(spenWNote);
            spenWNote.close(removeCache);
        }
    }
}
