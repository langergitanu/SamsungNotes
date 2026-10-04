package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u00019J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H&J\u001c\u0010\"\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010%H&J&\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u0007H&J8\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010!2\u0010\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010.H&J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000fH&J$\u00102\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000f2\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0007H&J\u0012\u00104\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u000105H&J\u0010\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u000fH&J\b\u00108\u001a\u00020\u001fH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0012\u0010\u0016\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006:"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer;", "", "lastTaskObjectType", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;", "getLastTaskObjectType", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;", "lastTaskStyle", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ObjectTaskStyle;", "getLastTaskStyle", "()Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/ObjectTaskStyle;", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "width", "", "getWidth", "()I", "height", "getHeight", "objectMaxWidth", "getObjectMaxWidth", "objectMaxHeight", "getObjectMaxHeight", "oldObjectMaxWidth", "", "getOldObjectMaxWidth", "()F", "dPI", "getDPI", "appendObject", "", CoeditServiceConstants.Element.NAME_OBJECT, "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "appendTaskObject", "task", "file", "", "taskStyle", "appendObjects", "page", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "rect", "Landroid/graphics/RectF;", "bgImage", "bgColor", "", "isAddedTask", "", "taskId", "addTaskInfo", "type", "appendBodyText", "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "setPageColor", "color", "finish", "ComposingObjectType", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface INoteComposer {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/INoteComposer$ComposingObjectType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "OBJECT", "STROKES", "TEXT", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ComposingObjectType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ComposingObjectType[] $VALUES;
        public static final ComposingObjectType NONE = new ComposingObjectType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final ComposingObjectType OBJECT = new ComposingObjectType("OBJECT", 1);
        public static final ComposingObjectType STROKES = new ComposingObjectType("STROKES", 2);
        public static final ComposingObjectType TEXT = new ComposingObjectType("TEXT", 3);

        private static final /* synthetic */ ComposingObjectType[] $values() {
            return new ComposingObjectType[]{NONE, OBJECT, STROKES, TEXT};
        }

        static {
            ComposingObjectType[] composingObjectTypeArr$values = $values();
            $VALUES = composingObjectTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(composingObjectTypeArr$values);
        }

        private ComposingObjectType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ComposingObjectType> getEntries() {
            return $ENTRIES;
        }

        public static ComposingObjectType valueOf(String str) {
            return (ComposingObjectType) Enum.valueOf(ComposingObjectType.class, str);
        }

        public static ComposingObjectType[] values() {
            return (ComposingObjectType[]) $VALUES.clone();
        }
    }

    void addTaskInfo(int taskId, @Nullable ComposingObjectType type, @Nullable ObjectTaskStyle taskStyle);

    void appendBodyText(@Nullable SpenObjectTextBox object);

    void appendObject(@Nullable SpenObjectBase object);

    void appendObject(@Nullable SpenObjectBase object, @Nullable String file);

    void appendObject(@Nullable SpenObjectBase object, @Nullable String file, @Nullable ObjectTaskStyle taskStyle);

    void appendObjects(@Nullable SpenPageDoc page, @Nullable RectF rect, @Nullable SpenObjectBase bgImage, @Nullable List<? extends SpenObjectBase> bgColor);

    void appendTaskObject(@Nullable SpenObjectBase object, @Nullable ObjectTaskStyle task);

    void finish();

    float getDPI();

    int getHeight();

    @Nullable
    ComposingObjectType getLastTaskObjectType();

    @Nullable
    ObjectTaskStyle getLastTaskStyle();

    @NotNull
    SpenWNote getNote();

    int getObjectMaxHeight();

    int getObjectMaxWidth();

    float getOldObjectMaxWidth();

    int getWidth();

    boolean isAddedTask(int taskId);

    void setPageColor(int color);
}
