package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model;

import android.os.SystemClock;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentBase;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.DrawingConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.HandWritingConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IConvertParams;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.INoteComposer;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IResourceGetter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ISpenDocCreator;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.ImageConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.TextConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.TitleConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.VoiceConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.WebConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.creator.SpenDocCreator;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer.SinglePageNoteComposer;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u001eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\u0007j\u0014\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/SDocXConverter;", "", "mDocCreator", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/creator/SpenDocCreator;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/creator/SpenDocCreator;)V", "mConverters", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/AbsContentConverter;", "Lkotlin/collections/HashMap;", "release", "", MarkdownConverter.PREFIX_NAME, "spenSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "resourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "runConverter", "type", "base", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "hasContentTextOnly", "", "contentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ConvertParam", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SDocXConverter {

    @NotNull
    private static final String TAG = "SDocXConverter";
    private static final int TYPE_TITLE = -1;

    @Nullable
    private HashMap<Integer, AbsContentConverter<?>> mConverters;

    @Nullable
    private final SpenDocCreator mDocCreator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/SDocXConverter$ConvertParam;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "docCreator", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ISpenDocCreator;", "composer", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "resourceGetter", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ISpenDocCreator;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;)V", "getDocCreator", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ISpenDocCreator;", "getComposer", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "getResourceGetter", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IResourceGetter;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConvertParam implements IConvertParams {

        @NotNull
        private final INoteComposer composer;

        @NotNull
        private final ISpenDocCreator docCreator;

        @NotNull
        private final IResourceGetter resourceGetter;

        public ConvertParam(@NotNull ISpenDocCreator docCreator, @NotNull INoteComposer composer, @NotNull IResourceGetter resourceGetter) {
            Intrinsics.checkNotNullParameter(docCreator, "docCreator");
            Intrinsics.checkNotNullParameter(composer, "composer");
            Intrinsics.checkNotNullParameter(resourceGetter, "resourceGetter");
            this.docCreator = docCreator;
            this.composer = composer;
            this.resourceGetter = resourceGetter;
        }

        @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IConvertParams
        @NotNull
        public INoteComposer getComposer() {
            return this.composer;
        }

        @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IConvertParams
        @NotNull
        public ISpenDocCreator getDocCreator() {
            return this.docCreator;
        }

        @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.IConvertParams
        @NotNull
        public IResourceGetter getResourceGetter() {
            return this.resourceGetter;
        }
    }

    public SDocXConverter(@Nullable SpenDocCreator spenDocCreator) {
        this.mDocCreator = spenDocCreator;
        HashMap<Integer, AbsContentConverter<?>> map = new HashMap<>();
        this.mConverters = map;
        Intrinsics.checkNotNull(map);
        map.put(-1, new TitleConverter());
        HashMap<Integer, AbsContentConverter<?>> map2 = this.mConverters;
        Intrinsics.checkNotNull(map2);
        map2.put(1, new TextConverter());
        HashMap<Integer, AbsContentConverter<?>> map3 = this.mConverters;
        Intrinsics.checkNotNull(map3);
        map3.put(2, new ImageConverter());
        HashMap<Integer, AbsContentConverter<?>> map4 = this.mConverters;
        Intrinsics.checkNotNull(map4);
        map4.put(3, new HandWritingConverter());
        HashMap<Integer, AbsContentConverter<?>> map5 = this.mConverters;
        Intrinsics.checkNotNull(map5);
        map5.put(4, new DrawingConverter());
        HashMap<Integer, AbsContentConverter<?>> map6 = this.mConverters;
        Intrinsics.checkNotNull(map6);
        map6.put(5, new WebConverter());
        HashMap<Integer, AbsContentConverter<?>> map7 = this.mConverters;
        Intrinsics.checkNotNull(map7);
        map7.put(7, new VoiceConverter());
    }

    private final boolean hasContentTextOnly(ArrayList<SpenContentBase> contentList) {
        if (contentList != null && !contentList.isEmpty()) {
            Iterator<SpenContentBase> it = contentList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenContentBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (next.getType() != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void runConverter(int type, SpenContentBase base, IConvertParams params) {
        HashMap<Integer, AbsContentConverter<?>> map = this.mConverters;
        Intrinsics.checkNotNull(map);
        AbsContentConverter<?> absContentConverter = map.get(Integer.valueOf(type));
        if (absContentConverter != null) {
            absContentConverter.convert(base, params);
            return;
        }
        LoggerBase.INSTANCE.m7138w(TAG, "not supported content " + type);
    }

    public final synchronized void convert(@NotNull SpenSDoc spenSDoc, @NotNull SpenWNote wNote, @NotNull IResourceGetter resourceGetter) {
        try {
            Intrinsics.checkNotNullParameter(spenSDoc, "spenSDoc");
            Intrinsics.checkNotNullParameter(wNote, "wNote");
            Intrinsics.checkNotNullParameter(resourceGetter, "resourceGetter");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int contentCount = spenSDoc.getContentCount();
            if (!hasContentTextOnly(spenSDoc.getContentList())) {
                wNote.setBodyTextFontSizeDelta(0);
            }
            SpenDocCreator spenDocCreator = this.mDocCreator;
            SinglePageNoteComposer singlePageNoteComposer = new SinglePageNoteComposer(wNote, spenDocCreator != null ? spenDocCreator.createBodyTextContext() : null, resourceGetter);
            singlePageNoteComposer.setPageColor(resourceGetter.getColor(C7968R.color.base_background_color_white));
            SpenDocCreator spenDocCreator2 = this.mDocCreator;
            Intrinsics.checkNotNull(spenDocCreator2);
            ConvertParam convertParam = new ConvertParam(spenDocCreator2, singlePageNoteComposer, resourceGetter);
            runConverter(-1, spenSDoc.getTitle(), convertParam);
            for (int i = 0; i < contentCount; i++) {
                SpenContentBase content = spenSDoc.getContent(i);
                runConverter(content.getType(), content, convertParam);
            }
            singlePageNoteComposer.finish();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            LoggerBase.INSTANCE.m7137i(TAG, "entire converting time : " + (jElapsedRealtime2 - jElapsedRealtime));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void release() {
        HashMap<Integer, AbsContentConverter<?>> map = this.mConverters;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            for (AbsContentConverter<?> absContentConverter : map.values()) {
                Intrinsics.checkNotNullExpressionValue(absContentConverter, "next(...)");
                absContentConverter.release();
            }
            HashMap<Integer, AbsContentConverter<?>> map2 = this.mConverters;
            if (map2 != null) {
                map2.clear();
            }
            this.mConverters = null;
        }
    }
}
