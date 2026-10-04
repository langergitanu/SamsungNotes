package com.samsung.android.support.senl.p148nt.data.database.core.schema;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/schema/ExtraDbSchema;", "", "<init>", "()V", "UUID_STRING", "", "equals", "", "other", "hashCode", "", "toString", "DeletedNote", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class ExtraDbSchema {

    @NotNull
    public static final ExtraDbSchema INSTANCE = new ExtraDbSchema();

    @NotNull
    public static final String UUID_STRING = "UUID";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/database/core/schema/ExtraDbSchema$DeletedNote;", "", "<init>", "()V", "TABLE_NAME", "", "ID", "UUID", "FILEPATH", "DELETED_BY", "equals", "", "other", "hashCode", "", "toString", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class DeletedNote {

        @NotNull
        public static final String DELETED_BY = "deletedBy";

        @NotNull
        public static final String FILEPATH = "filePath";

        @NotNull
        public static final String ID = "_id";

        @NotNull
        public static final DeletedNote INSTANCE = new DeletedNote();

        @NotNull
        public static final String TABLE_NAME = "deleted_notes";

        @NotNull
        public static final String UUID = "UUID";

        private DeletedNote() {
        }

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof DeletedNote);
        }

        public int hashCode() {
            return 1146173782;
        }

        @NotNull
        public String toString() {
            return "DeletedNote";
        }
    }

    private ExtraDbSchema() {
    }

    public boolean equals(@Nullable Object other) {
        return this == other || (other instanceof ExtraDbSchema);
    }

    public int hashCode() {
        return 98814009;
    }

    @NotNull
    public String toString() {
        return "ExtraDbSchema";
    }
}
