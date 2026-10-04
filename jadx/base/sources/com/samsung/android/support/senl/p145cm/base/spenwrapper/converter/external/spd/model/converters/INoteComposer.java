package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J$\u0010\u0015\u001a\u00020\u000f2\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0018H&J\"\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H&J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0007H&J\u0012\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u001cH&J\u0012\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u0014H&J\b\u0010.\u001a\u00020\u000fH&J\b\u0010/\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\"\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\tR\u0014\u0010(\u001a\u0004\u0018\u00010\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R&\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/INoteComposer;", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getWNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "width", "", "getWidth", "()I", "height", "getHeight", "pageWidth", "getPageWidth", "transferObject", "", "spenPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "appendObject", CoeditServiceConstants.Element.NAME_OBJECT, "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "appendObjects", "objects", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setBackgroundForPage", "colorBg", "imageBgPath", "", "imageMode", "appendPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "getPage", "index", "backgroundColorPage", "getBackgroundColorPage", "setTitle", "title", "removeObject", "spenObjectBase", "cachePath", "getCachePath", "()Ljava/lang/String;", "objectList", "getObjectList", "()Ljava/util/ArrayList;", "setBodyTextFontSizeDelta", "release", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface INoteComposer {
    void appendObject(@Nullable SpenObjectBase object);

    void appendObjects(@Nullable ArrayList<SpenObjectBase> objects);

    @Nullable
    SpenWPage appendPage(int width, int height);

    int getBackgroundColorPage();

    @Nullable
    String getCachePath();

    int getHeight();

    @Nullable
    ArrayList<SpenObjectBase> getObjectList();

    @Nullable
    SpenWPage getPage(int index);

    int getPageWidth();

    @NotNull
    SpenWNote getWNote();

    int getWidth();

    void release();

    void removeObject(@Nullable SpenObjectBase spenObjectBase);

    void setBackgroundForPage(int colorBg, @Nullable String imageBgPath, int imageMode);

    void setBodyTextFontSizeDelta();

    void setTitle(@Nullable String title);

    void transferObject(@Nullable SpenPageDoc spenPageDoc);
}
