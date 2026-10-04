package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenCapturePage;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenDocumentInitializer;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.AbsObjectConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.HandWritingConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IConvertParams;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.INoteComposer;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IResourceGetter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.ISpenNoteDocManager;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.TextBoxConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.WebConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.notecomposer.MultiPageNoteComposer;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J.\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0006H\u0002J&\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J \u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/SPDToSDocXConverter;", "", "<init>", "()V", "mConverters", "", "", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/AbsObjectConverter;", "mComposer", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/notecomposer/MultiPageNoteComposer;", "mVoiceMemoPathMap", "Landroid/util/ArrayMap;", "", "mVoiceMemoTable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mSpenCapturePage", "Lcom/samsung/android/sdk/pen/engine/SpenCapturePage;", "mTempFoldePath", "release", "", MarkdownConverter.PREFIX_NAME, "context", "Landroid/content/Context;", "spenNoteDocManager", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/ISpenNoteDocManager;", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "resourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IResourceGetter;", "isImageCard", "", CoeditServiceConstants.Element.NAME_OBJECT, "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "isMagicPenStroke", "isBoxObject", "objectType", "convertImageBackgroundModeTile", "spenPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "backgroundPath", "convertVoiceTag", "runConverter", "type", "base", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IConvertParams;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSPDToSDocXConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SPDToSDocXConverter.kt\ncom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/SPDToSDocXConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,274:1\n1#2:275\n*E\n"})
public final class SPDToSDocXConverter {

    @NotNull
    private static final String KEY_VOICE_BOOKMARK_IDENTIFIER = "NOTES_APP_BOOKMARK_VOICE_IDENTIFIER";

    @NotNull
    private static final String TAG = "SPDToSDocXConverter";
    private static final int TYPE_IMAGE_CARD = 39;

    @NotNull
    private static final String VOICE_MEMO_FILE_PREFIX = "/";
    private static final int VOICE_MEMO_TYPE = 23;

    @Nullable
    private MultiPageNoteComposer mComposer;

    @Nullable
    private Map<Integer, AbsObjectConverter<?>> mConverters;

    @Nullable
    private SpenCapturePage mSpenCapturePage;

    @Nullable
    private String mTempFoldePath;

    @Nullable
    private ArrayMap<String, String> mVoiceMemoPathMap;

    @Nullable
    private ArrayList<String> mVoiceMemoTable;

    public SPDToSDocXConverter() {
        HashMap map = new HashMap();
        this.mConverters = map;
        Map<Integer, AbsObjectConverter<?>> map2 = this.mConverters;
        if (map2 != null) {
            map2.put(7, new TextBoxConverter());
        }
        Map<Integer, AbsObjectConverter<?>> map3 = this.mConverters;
        if (map3 != null) {
            map3.put(4, new TextBoxConverter());
        }
        Map<Integer, AbsObjectConverter<?>> map4 = this.mConverters;
        if (map4 != null) {
            map4.put(1, new HandWritingConverter());
        }
        Map<Integer, AbsObjectConverter<?>> map5 = this.mConverters;
        if (map5 != null) {
            map5.put(3, new WebConverter());
        }
    }

    private final String convertImageBackgroundModeTile(Context context, SpenPageDoc spenPageDoc, String backgroundPath) {
        if (context == null) {
            LoggerBase.INSTANCE.m7132d(TAG, "convertImageBackgroundModeTile : context null");
            return null;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(backgroundPath);
        if (bitmapDecodeFile != null) {
            int height = bitmapDecodeFile.getHeight();
            bitmapDecodeFile.recycle();
            if (spenPageDoc != null && height >= spenPageDoc.getHeight()) {
                return backgroundPath;
            }
        }
        int iM14131E = StringsKt.m14131E("/", 0, 6, backgroundPath);
        StringBuilder sb = new StringBuilder();
        if (this.mTempFoldePath == null) {
            String strSubstring = backgroundPath.substring(0, iM14131E);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
            sb.append("_temp");
            String string = sb.toString();
            this.mTempFoldePath = string;
            File file = string != null ? new File(string) : null;
            if ((file != null && file.exists()) || (file != null && file.mkdir())) {
                String strSubstring2 = backgroundPath.substring(iM14131E);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                sb.append(strSubstring2);
            }
        } else {
            String strSubstring3 = backgroundPath.substring(0, iM14131E);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
            sb.append(strSubstring3);
            sb.append("_temp");
            String strSubstring4 = backgroundPath.substring(iM14131E);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
            sb.append(strSubstring4);
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        if (!new File(string2).exists()) {
            if (spenPageDoc != null) {
                spenPageDoc.removeAllObject();
            }
            if (this.mSpenCapturePage == null) {
                this.mSpenCapturePage = SpenObjectConstructor.makeSpenCapturePage(context);
            }
            SpenCapturePage spenCapturePage = this.mSpenCapturePage;
            if (spenCapturePage != null) {
                spenCapturePage.setPageDoc(spenPageDoc);
            }
            SpenCapturePage spenCapturePage2 = this.mSpenCapturePage;
            if (spenCapturePage2 != null && !spenCapturePage2.capturePage(string2)) {
                LoggerBase.INSTANCE.m7132d(TAG, "convertImageBackgroundModeTile : capture page fail");
                return backgroundPath;
            }
        }
        return string2;
    }

    private final void convertVoiceTag(SpenObjectBase object) {
        String extraDataString = object.getExtraDataString("filePath");
        if (TextUtils.isEmpty(extraDataString)) {
            LoggerBase.INSTANCE.m7138w(TAG, "convert voice tag failed : filePath is empty");
            return;
        }
        if (this.mVoiceMemoPathMap == null || this.mVoiceMemoTable == null) {
            LoggerBase.INSTANCE.m7138w(TAG, "convert voice tag failed : list voiceMemoPathMap or voiceMemoTable is null");
            return;
        }
        object.setResizeOption(2);
        String strSubstring = extraDataString.substring(StringsKt.m14131E("/", 0, 6, extraDataString) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        ArrayList<String> arrayList = this.mVoiceMemoTable;
        if (arrayList == null || !arrayList.contains(strSubstring)) {
            return;
        }
        ArrayMap<String, String> arrayMap = this.mVoiceMemoPathMap;
        object.attachFile(arrayMap != null ? arrayMap.get(strSubstring) : null);
        object.setExtraDataString(KEY_VOICE_BOOKMARK_IDENTIFIER, strSubstring);
    }

    private final boolean isBoxObject(int objectType) {
        return objectType == 2 || objectType == 7 || objectType == 4;
    }

    private final boolean isImageCard(SpenObjectBase object) {
        return object.getType() == 3 && object.getExtraDataInt(PackageRelationship.TYPE_ATTRIBUTE_NAME) == 39;
    }

    private final boolean isMagicPenStroke(SpenObjectBase object) {
        if (object.getType() != 1) {
            return false;
        }
        SpenObjectStroke spenObjectStroke = object instanceof SpenObjectStroke ? (SpenObjectStroke) object : null;
        return Intrinsics.areEqual(SpenPenManager.SPEN_MAGIC_PEN, spenObjectStroke != null ? spenObjectStroke.getPenName() : null);
    }

    private final void runConverter(int type, SpenObjectBase base, IConvertParams params) {
        Map<Integer, AbsObjectConverter<?>> map = this.mConverters;
        AbsObjectConverter<?> absObjectConverter = map != null ? map.get(Integer.valueOf(type)) : null;
        if (absObjectConverter != null) {
            absObjectConverter.convert(base, params);
            return;
        }
        LoggerBase.INSTANCE.m7138w(TAG, "not supported object : " + type);
    }

    public final synchronized void convert(@Nullable Context context, @Nullable ISpenNoteDocManager spenNoteDocManager, @Nullable SpenWNote wNote, @Nullable final IResourceGetter resourceGetter) {
        ISpenNoteDocManager iSpenNoteDocManager = spenNoteDocManager;
        synchronized (this) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int pageCount = iSpenNoteDocManager != null ? iSpenNoteDocManager.getPageCount() : 0;
                int width = iSpenNoteDocManager != null ? iSpenNoteDocManager.getWidth() : 0;
                int height = iSpenNoteDocManager != null ? iSpenNoteDocManager.getHeight() : 0;
                this.mComposer = new MultiPageNoteComposer(wNote, Integer.valueOf(width), Integer.valueOf(height));
                IConvertParams iConvertParams = new IConvertParams() { // from class: com.samsung.android.support.senl.cm.base.spenwrapper.converter.external.spd.model.SPDToSDocXConverter$convert$params$1
                    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IConvertParams
                    public INoteComposer getNoteComposer() {
                        return this.this$0.mComposer;
                    }

                    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.IConvertParams
                    /* JADX INFO: renamed from: getResourceGetter, reason: from getter */
                    public IResourceGetter get$resourceGetter() {
                        return resourceGetter;
                    }
                };
                MultiPageNoteComposer multiPageNoteComposer = this.mComposer;
                if (multiPageNoteComposer != null) {
                    multiPageNoteComposer.setBodyTextFontSizeDelta();
                }
                MultiPageNoteComposer multiPageNoteComposer2 = this.mComposer;
                if (multiPageNoteComposer2 != null) {
                    multiPageNoteComposer2.setTitle(iSpenNoteDocManager != null ? iSpenNoteDocManager.getTitle() : null);
                }
                this.mVoiceMemoPathMap = iSpenNoteDocManager != null ? iSpenNoteDocManager.getVoicePathMap() : null;
                this.mVoiceMemoTable = iSpenNoteDocManager != null ? iSpenNoteDocManager.getVoiceMemoTable() : null;
                Integer numValueOf = resourceGetter != null ? Integer.valueOf(resourceGetter.getColor(C7968R.color.base_background_color_white)) : null;
                int i = 0;
                String str = null;
                int i2 = 0;
                while (i < pageCount) {
                    SpenPageDoc page = iSpenNoteDocManager != null ? iSpenNoteDocManager.getPage(i) : null;
                    if (page != null) {
                        width = page.getWidth();
                        height = page.getHeight();
                    }
                    MultiPageNoteComposer multiPageNoteComposer3 = this.mComposer;
                    if (multiPageNoteComposer3 != null) {
                        multiPageNoteComposer3.appendPage(width, height);
                    }
                    if ((iSpenNoteDocManager != null ? iSpenNoteDocManager.getObjectCountInPage() : 0) > 0) {
                        MultiPageNoteComposer multiPageNoteComposer4 = this.mComposer;
                        if (multiPageNoteComposer4 != null) {
                            multiPageNoteComposer4.transferObject(page);
                        }
                        MultiPageNoteComposer multiPageNoteComposer5 = this.mComposer;
                        ArrayList<SpenObjectBase> objectList = multiPageNoteComposer5 != null ? multiPageNoteComposer5.getObjectList() : null;
                        if (objectList != null) {
                            Iterator<SpenObjectBase> it = objectList.iterator();
                            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                            while (it.hasNext()) {
                                SpenObjectBase next = it.next();
                                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                SpenObjectBase spenObjectBase = next;
                                int type = spenObjectBase.getType();
                                if (type == 4 && spenObjectBase.getExtraDataInt(PackageRelationship.TYPE_ATTRIBUTE_NAME) == 23) {
                                    convertVoiceTag(spenObjectBase);
                                    runConverter(type, spenObjectBase, iConvertParams);
                                } else if (isImageCard(spenObjectBase) || isMagicPenStroke(spenObjectBase) || isBoxObject(type)) {
                                    runConverter(type, spenObjectBase, iConvertParams);
                                }
                            }
                        }
                    }
                    String backgroundImagePathPage = spenNoteDocManager != null ? spenNoteDocManager.getBackgroundImagePathPage() : null;
                    int backgroundImageMode = spenNoteDocManager != null ? spenNoteDocManager.getBackgroundImageMode() : 0;
                    if (backgroundImagePathPage != null && backgroundImageMode == 3) {
                        backgroundImagePathPage = convertImageBackgroundModeTile(context, page, backgroundImagePathPage);
                        backgroundImageMode = 2;
                    }
                    str = backgroundImagePathPage;
                    i2 = backgroundImageMode;
                    if (numValueOf != null) {
                        int iIntValue = numValueOf.intValue();
                        MultiPageNoteComposer multiPageNoteComposer6 = this.mComposer;
                        if (multiPageNoteComposer6 != null) {
                            multiPageNoteComposer6.setBackgroundForPage(iIntValue, str, i2);
                        }
                    }
                    i++;
                    iSpenNoteDocManager = spenNoteDocManager;
                }
                if (wNote != null) {
                    new SpenDocumentInitializer().setPageVerticalPadding(wNote);
                }
                MultiPageNoteComposer multiPageNoteComposer7 = this.mComposer;
                if (multiPageNoteComposer7 != null) {
                    multiPageNoteComposer7.appendPage(width, height);
                }
                if (numValueOf != null) {
                    int iIntValue2 = numValueOf.intValue();
                    MultiPageNoteComposer multiPageNoteComposer8 = this.mComposer;
                    if (multiPageNoteComposer8 != null) {
                        multiPageNoteComposer8.setBackgroundForPage(iIntValue2, str, i2);
                    }
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                LoggerBase.INSTANCE.m7137i(TAG, "entire converting time : " + (jElapsedRealtime2 - jElapsedRealtime));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void release() {
        Map<Integer, AbsObjectConverter<?>> map = this.mConverters;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            Iterator<AbsObjectConverter<?>> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            Map<Integer, AbsObjectConverter<?>> map2 = this.mConverters;
            if (map2 != null) {
                map2.clear();
            }
            this.mConverters = null;
        }
        MultiPageNoteComposer multiPageNoteComposer = this.mComposer;
        if (multiPageNoteComposer != null) {
            multiPageNoteComposer.release();
        }
        this.mComposer = null;
        this.mVoiceMemoTable = null;
        this.mVoiceMemoPathMap = null;
        SpenCapturePage spenCapturePage = this.mSpenCapturePage;
        if (spenCapturePage != null) {
            spenCapturePage.setPageDoc(null);
        }
        SpenCapturePage spenCapturePage2 = this.mSpenCapturePage;
        if (spenCapturePage2 != null) {
            spenCapturePage2.close();
        }
        String str = this.mTempFoldePath;
        if (str != null) {
            File file = str != null ? new File(str) : null;
            if (file == null || !file.exists()) {
                return;
            }
            try {
                FileUtil.deleteFile(file);
            } catch (IOException unused) {
                LoggerBase.INSTANCE.m7132d(TAG, "fail to delete temp folder");
            }
        }
    }
}
