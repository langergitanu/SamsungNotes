package com.samsung.android.support.senl.p148nt.stt.base.model;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000eR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReaderCache;", "", "<init>", "()V", "textDataFromFileReaders", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReader;", "Lkotlin/collections/HashMap;", "get", "spenVoiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "getWithoutFileData", "put", "", "getKey", "clear", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenVoiceTextDataReaderCache {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static SpenVoiceTextDataReaderCache mInstance;

    @NotNull
    private final HashMap<String, SpenVoiceTextDataReader> textDataFromFileReaders = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReaderCache$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReaderCache;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/stt/base/model/SpenVoiceTextDataReaderCache;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SpenVoiceTextDataReaderCache getInstance() {
            if (SpenVoiceTextDataReaderCache.mInstance == null) {
                SpenVoiceTextDataReaderCache.mInstance = new SpenVoiceTextDataReaderCache();
            }
            SpenVoiceTextDataReaderCache spenVoiceTextDataReaderCache = SpenVoiceTextDataReaderCache.mInstance;
            Intrinsics.checkNotNull(spenVoiceTextDataReaderCache);
            return spenVoiceTextDataReaderCache;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    @NotNull
    public static final SpenVoiceTextDataReaderCache getInstance() {
        return INSTANCE.getInstance();
    }

    public final void clear() {
        this.textDataFromFileReaders.clear();
    }

    @NotNull
    public final SpenVoiceTextDataReader get(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        String key = getKey(spenVoiceData);
        SpenVoiceTextDataReader spenVoiceTextDataReader = this.textDataFromFileReaders.get(key);
        if (spenVoiceTextDataReader == null) {
            spenVoiceTextDataReader = new SpenVoiceTextDataReader(spenVoiceData.getAttachedFile());
            this.textDataFromFileReaders.put(key, spenVoiceTextDataReader);
            SpenVoiceTextDataReader spenVoiceTextDataReader2 = this.textDataFromFileReaders.get(key);
            if (spenVoiceTextDataReader2 != null) {
                spenVoiceTextDataReader2.loadDataFromFile(spenVoiceData);
            }
        }
        return spenVoiceTextDataReader;
    }

    @NotNull
    public final String getKey(@NotNull SpenVoiceData spenVoiceData) {
        String name;
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        String attachedFile = spenVoiceData.getAttachedFile();
        if (attachedFile != null) {
            name = new File(attachedFile).getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        } else {
            name = "";
        }
        return AbstractC0541b.m756B(spenVoiceData.getName(), name);
    }

    @NotNull
    public final SpenVoiceTextDataReader getWithoutFileData(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        String key = getKey(spenVoiceData);
        this.textDataFromFileReaders.put(key, new SpenVoiceTextDataReader(spenVoiceData.getAttachedFile()));
        SpenVoiceTextDataReader spenVoiceTextDataReader = this.textDataFromFileReaders.get(key);
        Intrinsics.checkNotNull(spenVoiceTextDataReader);
        return spenVoiceTextDataReader;
    }

    public final void put(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        String key = getKey(spenVoiceData);
        this.textDataFromFileReaders.put(key, new SpenVoiceTextDataReader(spenVoiceData.getAttachedFile()));
        SpenVoiceTextDataReader spenVoiceTextDataReader = this.textDataFromFileReaders.get(key);
        if (spenVoiceTextDataReader != null) {
            spenVoiceTextDataReader.loadDataFromFile(spenVoiceData);
        }
    }
}
