package com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WordDocumentEntityContainer extends DocumentEntityContainer {
    public static final Parcelable.Creator<WordDocumentEntityContainer> CREATOR = new Parcelable.Creator<WordDocumentEntityContainer>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WordDocumentEntityContainer createFromParcel(Parcel parcel) {
            return new WordDocumentEntityContainer(parcel, 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WordDocumentEntityContainer[] newArray(int i) {
            return new WordDocumentEntityContainer[i];
        }
    };

    public /* synthetic */ WordDocumentEntityContainer(Parcel parcel, int i) {
        this(parcel);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.DocumentEntityContainer
    public void updateOriginalEntityWithLatest() {
        setOriginalEntity(getEntity().mo22193clone());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getOriginalEntity(), i);
        parcel.writeParcelable(getEntity(), i);
    }

    public WordDocumentEntityContainer(@NonNull NotesDocumentEntity notesDocumentEntity) {
        super(notesDocumentEntity, notesDocumentEntity.mo22193clone());
    }

    private WordDocumentEntityContainer(Parcel parcel) {
        super((NotesDocumentEntity) parcel.readParcelable(NotesDocumentEntity.class.getClassLoader()), (NotesDocumentEntity) parcel.readParcelable(NotesDocumentEntity.class.getClassLoader()));
    }
}
