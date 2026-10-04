package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AutoTitleCreator<ObjectType extends SpenObjectBase> {
    private final SpenWNoteObjectHelper<ObjectType> mObjectHelper = new SpenWNoteObjectHelper<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CreationPriority {
        PDF(new PdfTitleCreator()),
        WEB(new WebCardTitleCreator()),
        AUDIO(new AudioTitleCreator()),
        RECORDING(new RecordingTitleCreator()),
        DRAWING(new DrawingTitleCreator()),
        MATH(new FormulaTitleCreator()),
        TABLE(new TableTitleCreator()),
        IMAGE(new ImageTitleCreator()),
        LINK(new LinkTitleCreator());

        private final AutoTitleCreator<? extends SpenObjectBase> mCreator;

        CreationPriority(@NonNull AutoTitleCreator autoTitleCreator) {
            this.mCreator = autoTitleCreator;
        }

        public static CreationPriority find(@NonNull String str) {
            for (CreationPriority creationPriority : values()) {
                if (creationPriority.toString().equals(str)) {
                    return creationPriority;
                }
            }
            return null;
        }

        public String create(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
            return this.mCreator.apply(resources, spenWNote);
        }
    }

    public abstract String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote);

    public ObjectType findFirstBodyObject(@NonNull SpenWNote spenWNote, int i) {
        return (ObjectType) getObjectHelper().findFirstBodyObject(spenWNote, i);
    }

    @Nullable
    public ObjectType findFirstObject(@NonNull SpenWNote spenWNote, int i, int i2) {
        return (ObjectType) getObjectHelper().findFirstObject(spenWNote, i, i2);
    }

    public SpenWNoteObjectHelper<ObjectType> getObjectHelper() {
        return this.mObjectHelper;
    }

    public boolean hasObject(@NonNull SpenWNote spenWNote, int i) {
        return getObjectHelper().hasObject(spenWNote, i);
    }

    public boolean needToCreateTitle(@NonNull SpenWNote spenWNote) {
        return needToCreateTitle(spenWNote.getTitle().getText(), spenWNote.getBodyText().getText(), getObjectHelper().hasObject(spenWNote, 1));
    }

    public boolean needToCreateTitle(@Nullable String str, @Nullable String str2, boolean z) {
        return !z && TextUtils.isEmpty(str) && SpenWNoteObjectHelper.isEmptyBodyText(str2);
    }
}
