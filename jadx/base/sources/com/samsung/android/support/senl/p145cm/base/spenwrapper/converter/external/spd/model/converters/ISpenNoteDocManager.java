package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters;

import android.util.ArrayMap;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010!\u001a\u00020\"H&R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0012\u0010\u000f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u0012\u0010\u0019\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0012\u0010\u001f\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R \u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R&\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010(j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`)X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/ISpenNoteDocManager;", "", "createSpenNoteDoc", "Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "password", "", "width", "", "noteDoc", "getNoteDoc", "()Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "pageCount", "getPageCount", "()I", "getWidth", "height", "getHeight", "getPage", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "index", "backgroundImagePathPage", "getBackgroundImagePathPage", "()Ljava/lang/String;", "backgroundImageMode", "getBackgroundImageMode", "objectCountInPage", "getObjectCountInPage", "title", DynamicActionBarProvider.METHOD_GET_DATA, "closeSpenNoteDoc", "", "isValid", "()Z", "release", "", "voicePathMap", "Landroid/util/ArrayMap;", "getVoicePathMap", "()Landroid/util/ArrayMap;", "voiceMemoTable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVoiceMemoTable", "()Ljava/util/ArrayList;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISpenNoteDocManager {
    boolean closeSpenNoteDoc();

    @Nullable
    SpenNoteDoc createSpenNoteDoc(@Nullable String password, int width);

    int getBackgroundImageMode();

    @Nullable
    String getBackgroundImagePathPage();

    int getHeight();

    @Nullable
    SpenNoteDoc getNoteDoc();

    int getObjectCountInPage();

    @Nullable
    SpenPageDoc getPage(int index);

    int getPageCount();

    @Nullable
    String getTitle();

    @Nullable
    ArrayList<String> getVoiceMemoTable();

    @Nullable
    ArrayMap<String, String> getVoicePathMap();

    int getWidth();

    boolean isValid();

    void release();
}
