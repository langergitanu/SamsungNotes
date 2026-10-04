package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notedoc;

import android.content.Context;
import android.util.ArrayMap;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenNoteFile;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020$J\u0012\u0010,\u001a\u0004\u0018\u00010\u00122\u0006\u0010-\u001a\u00020\"H\u0016J\b\u00107\u001a\u00020$H\u0016J\b\u0010:\u001a\u00020;H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R:\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017RF\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0016\u0010.\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010'R\u0014\u00103\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010'R\u0016\u00105\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00100R\u0014\u00108\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notedoc/SpenNoteDocManager;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/ISpenNoteDocManager;", "context", "Landroid/content/Context;", "mFilePath", "", "mResourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IResourceGetter;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IResourceGetter;)V", "mContextRef", "Ljava/lang/ref/WeakReference;", "value", "Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "noteDoc", "getNoteDoc", "()Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "mPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "Landroid/util/ArrayMap;", "", "voiceCreateTimeMap", "getVoiceCreateTimeMap", "()Landroid/util/ArrayMap;", "voicePathMap", "getVoicePathMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "voiceMemoTable", "getVoiceMemoTable", "()Ljava/util/ArrayList;", "createSpenNoteDoc", "password", "noteWidth", "", "extractVoice", "", "pageCount", "getPageCount", "()I", "width", "getWidth", "height", "getHeight", "getPage", "index", "backgroundImagePathPage", "getBackgroundImagePathPage", "()Ljava/lang/String;", "backgroundImageMode", "getBackgroundImageMode", "objectCountInPage", "getObjectCountInPage", "title", DynamicActionBarProvider.METHOD_GET_DATA, "closeSpenNoteDoc", "isValid", "()Z", "release", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenNoteDocManager implements ISpenNoteDocManager {

    @NotNull
    private static final String TAG = "SpenNoteDocManager";

    @NotNull
    private static final String VOICE_MEMO_KEY = "VoiceMemo";

    @NotNull
    private final WeakReference<Context> mContextRef;

    @Nullable
    private final String mFilePath;

    @Nullable
    private SpenPageDoc mPageDoc;

    @NotNull
    private final IResourceGetter mResourceGetter;

    @Nullable
    private SpenNoteDoc noteDoc;

    @Nullable
    private ArrayMap<String, Long> voiceCreateTimeMap;

    @Nullable
    private ArrayList<String> voiceMemoTable;

    @Nullable
    private ArrayMap<String, String> voicePathMap;

    public SpenNoteDocManager(@Nullable Context context, @Nullable String str, @NotNull IResourceGetter mResourceGetter) {
        Intrinsics.checkNotNullParameter(mResourceGetter, "mResourceGetter");
        this.mFilePath = str;
        this.mResourceGetter = mResourceGetter;
        this.mContextRef = new WeakReference<>(context);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public boolean closeSpenNoteDoc() {
        try {
            SpenNoteDoc noteDoc = getNoteDoc();
            if (noteDoc != null) {
                SpenNoteDoc.close$default(noteDoc, true, false, 2, null);
            }
            return true;
        } catch (Exception e) {
            AbstractC0000a.m23t(" close spen note doc failed : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    @Nullable
    public SpenNoteDoc createSpenNoteDoc(@Nullable String password, int noteWidth) {
        Context context = this.mContextRef.get();
        if (context == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "create spen note doc failed : null context");
            return null;
        }
        String str = this.mFilePath;
        if (str == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "create spen note doc failed : null file path");
            return null;
        }
        try {
            if (password == null) {
                this.noteDoc = DocumentConstructor.makeSpenNoteDoc(context, str, noteWidth, 0);
            } else {
                this.noteDoc = DocumentConstructor.makeSpenNoteDoc(context, str, password, noteWidth, 0);
            }
        } catch (SpenUnsupportedTypeException e) {
            AbstractC0000a.m23t("create spen note doc failed : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        } catch (SpenUnsupportedVersionException e2) {
            AbstractC0000a.m23t("create spen note doc failed : ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
        } catch (IOException e3) {
            AbstractC0000a.m23t("create spen note doc failed : ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        return getNoteDoc();
    }

    public final boolean extractVoice() {
        String str;
        if (getNoteDoc() == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "extractVoice: noteDoc is null");
            return false;
        }
        SpenNoteDoc noteDoc = getNoteDoc();
        String[] extraDataStringArray = noteDoc != null ? noteDoc.getExtraDataStringArray(VOICE_MEMO_KEY) : null;
        if (extraDataStringArray == null || extraDataStringArray.length == 0 || (str = extraDataStringArray[0]) == null || str.length() == 0) {
            LoggerBase.INSTANCE.m7138w(TAG, "extractVoice : voiceMemoKeyList is null");
            return false;
        }
        if (getVoiceMemoTable() != null) {
            ArrayList<String> voiceMemoTable = getVoiceMemoTable();
            Intrinsics.checkNotNull(voiceMemoTable);
            voiceMemoTable.clear();
        } else {
            this.voiceMemoTable = new ArrayList<>();
        }
        if (getVoicePathMap() != null) {
            ArrayMap<String, String> voicePathMap = getVoicePathMap();
            Intrinsics.checkNotNull(voicePathMap);
            voicePathMap.clear();
        } else {
            this.voicePathMap = new ArrayMap<>();
        }
        ArrayMap<String, Long> arrayMap = this.voiceCreateTimeMap;
        if (arrayMap != null) {
            Intrinsics.checkNotNull(arrayMap);
            arrayMap.clear();
        } else {
            this.voiceCreateTimeMap = new ArrayMap<>();
        }
        File cacheDir = this.mResourceGetter.getCacheDir();
        if (cacheDir == null) {
            return false;
        }
        String strM12320e = AbstractC11014a.m12320e(cacheDir, File.separator);
        Iterator it = ArrayIteratorKt.iterator(extraDataStringArray);
        while (it.hasNext()) {
            String str2 = (String) it.next();
            SpenNoteDoc noteDoc2 = getNoteDoc();
            String strValueOf = String.valueOf(noteDoc2 != null ? noteDoc2.getAttachedFile(str2) : null);
            String strSubstring = strValueOf.substring(StringsKt.m14130D(strValueOf, '.'));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strM757C = AbstractC0541b.m757C(strM12320e, str2, strSubstring);
            File file = new File(strM757C);
            File file2 = new File(strValueOf);
            try {
                FileUtil.copyFile(file2, file);
                ArrayMap<String, Long> arrayMap2 = this.voiceCreateTimeMap;
                Intrinsics.checkNotNull(arrayMap2);
                arrayMap2.put(str2 + strSubstring, Long.valueOf(file2.lastModified()));
                ArrayList<String> voiceMemoTable2 = getVoiceMemoTable();
                if (voiceMemoTable2 != null) {
                    voiceMemoTable2.add(str2 + strSubstring);
                }
                ArrayMap<String, String> voicePathMap2 = getVoicePathMap();
                Intrinsics.checkNotNull(voicePathMap2);
                voicePathMap2.put(str2 + strSubstring, strM757C);
            } catch (IOException e) {
                LoggerBase.INSTANCE.m7134e(TAG, "initVoiceMemo fail copy voice file", e);
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public int getBackgroundImageMode() {
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            return spenPageDoc.getBackgroundImageMode();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    @Nullable
    public String getBackgroundImagePathPage() {
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            return spenPageDoc.getBackgroundImagePath();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public int getHeight() {
        SpenNoteDoc noteDoc = getNoteDoc();
        if (noteDoc != null) {
            return noteDoc.getHeight();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    @Nullable
    public SpenNoteDoc getNoteDoc() {
        return this.noteDoc;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public int getObjectCountInPage() {
        SpenPageDoc spenPageDoc = this.mPageDoc;
        if (spenPageDoc != null) {
            return spenPageDoc.getObjectCount(true);
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    @Nullable
    public SpenPageDoc getPage(int index) {
        SpenNoteDoc noteDoc = getNoteDoc();
        SpenPageDoc page = noteDoc != null ? noteDoc.getPage(index) : null;
        this.mPageDoc = page;
        return page;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public int getPageCount() {
        SpenNoteDoc noteDoc = getNoteDoc();
        if (noteDoc != null) {
            return noteDoc.getPageCount();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    @Nullable
    public String getTitle() {
        String str = this.mFilePath;
        if (str == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "get title failed: file path is null");
            return null;
        }
        int iM14130D = StringsKt.m14130D(str, '/');
        int iM14130D2 = StringsKt.m14130D(this.mFilePath, '.');
        if (iM14130D < 0 || iM14130D2 < 0) {
            return null;
        }
        String strSubstring = this.mFilePath.substring(iM14130D + 1, iM14130D2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return StringsKt.m14139M(strSubstring, ":", "_");
    }

    @Nullable
    public final ArrayMap<String, Long> getVoiceCreateTimeMap() {
        return this.voiceCreateTimeMap;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    @Nullable
    public ArrayList<String> getVoiceMemoTable() {
        return this.voiceMemoTable;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    @Nullable
    public ArrayMap<String, String> getVoicePathMap() {
        return this.voicePathMap;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public int getWidth() {
        SpenNoteDoc noteDoc = getNoteDoc();
        if (noteDoc != null) {
            return noteDoc.getWidth();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public boolean isValid() {
        String str = this.mFilePath;
        if (str != null) {
            return SpenNoteFile.isValid(str);
        }
        LoggerBase.INSTANCE.m7138w(TAG, "check valid spd failed : file path is null");
        return false;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager
    public void release() {
        this.noteDoc = null;
        this.mPageDoc = null;
        if (getVoiceMemoTable() != null && getVoicePathMap() != null) {
            ArrayList<String> voiceMemoTable = getVoiceMemoTable();
            Intrinsics.checkNotNull(voiceMemoTable);
            Iterator<String> it = voiceMemoTable.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                String next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                ArrayMap<String, String> voicePathMap = getVoicePathMap();
                Intrinsics.checkNotNull(voicePathMap);
                String str = voicePathMap.get(next);
                if (str != null) {
                    File file = new File(str);
                    if (file.exists() && !file.delete()) {
                        LoggerBase.INSTANCE.m7133e(TAG, "can't delete voice file");
                    }
                }
            }
        }
        this.voiceMemoTable = null;
        this.voicePathMap = null;
        this.voiceCreateTimeMap = null;
    }
}
