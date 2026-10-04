package com.samsung.android.support.senl.p148nt.data.database.core.document.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {DBSchema.CategoryTreeClosure.ANCESTOR}, entity = NotesCategoryTreeEntity.class, onDelete = 5, onUpdate = 5, parentColumns = {"UUID"}), @ForeignKey(childColumns = {DBSchema.CategoryTreeClosure.DESCENDANT}, entity = NotesCategoryTreeEntity.class, onDelete = 5, onUpdate = 5, parentColumns = {"UUID"})}, primaryKeys = {DBSchema.CategoryTreeClosure.ANCESTOR, DBSchema.CategoryTreeClosure.DESCENDANT}, tableName = DBSchema.CategoryTreeClosure.TABLE_NAME)
public class NotesCategoryTreeClosureEntity {

    @ColumnInfo(defaultValue = "0", name = DBSchema.CategoryTreeClosure.DEPTH)
    private int depth;

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.CategoryTreeClosure.ANCESTOR)
    private String ancestor = "";

    @NonNull
    @ColumnInfo(defaultValue = "", name = DBSchema.CategoryTreeClosure.DESCENDANT)
    private String descendant = "";

    @NonNull
    public String getAncestor() {
        return this.ancestor;
    }

    public int getDepth() {
        return this.depth;
    }

    @NonNull
    public String getDescendant() {
        return this.descendant;
    }

    public void setAncestor(String str) {
        this.ancestor = str;
    }

    public void setDepth(int i) {
        this.depth = i;
    }

    public void setDescendant(String str) {
        this.descendant = str;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("NotesCategoryTreeClosureEntity{ancestor='");
        sb.append(this.ancestor);
        sb.append("', descendant='");
        sb.append(this.descendant);
        sb.append("', depth=");
        return AbstractC0000a.m13j(sb, this.depth, '}');
    }
}
