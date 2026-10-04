package com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSQLBuilder implements SQLKeyword, Post.Select, Post.InterfaceC11261On, Post.Where, Post.Join, Post.When, Post.Then {
    private final StringBuilder mBuilder;
    private boolean mNoSpacePartialMatching;

    public NotesSQLBuilder() {
        this.mNoSpacePartialMatching = true;
        this.mBuilder = new StringBuilder();
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Base
    public NotesSQLBuilder append(@NonNull String str) {
        this.mBuilder.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post.InterfaceC11260As
    /* JADX INFO: renamed from: as */
    public Post.InterfaceC11260As mo12418as(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.f7402AS);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post.InterfaceC11260As
    public NotesSQLBuilder asEnd(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.f7402AS);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post.InterfaceC11260As, com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.From, com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Where
    public String build() {
        return this.mBuilder.toString().replaceAll(" +", " ").trim();
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Select
    public Post.When caseWhen() {
        this.mBuilder.append(SQLKeyword.CASE_WHEN);
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post.InterfaceC11260As
    public NotesSQLBuilder delimiter() {
        this.mBuilder.append(SQLKeyword.DELIMITER);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Then
    public NotesSQLBuilder elseEnd(@NonNull String str) {
        AbstractC1974b.m1332y(this.mBuilder, SQLKeyword.ELSE, str, SQLKeyword.END);
        return this;
    }

    public NotesSQLBuilder else_() {
        this.mBuilder.append(SQLKeyword.ELSE);
        return this;
    }

    public NotesSQLBuilder end() {
        this.mBuilder.append(SQLKeyword.END);
        return this;
    }

    public NotesSQLBuilder escape(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.ESCAPE);
        sb.append(str);
        return this;
    }

    public NotesSQLBuilder except(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.EXCEPT);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Select
    public Post.From from(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.FROM);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.From, com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Where
    public NotesSQLBuilder groupBy(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.GROUP_BY);
        sb.append(str);
        return this;
    }

    public NotesSQLBuilder having(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.HAVING);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Where, com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.When
    /* JADX INFO: renamed from: in */
    public NotesSQLBuilder mo12420in(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.f7403IN);
        sb.append(PropertyUtils.MAPPED_DELIM);
        sb.append(str);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.From
    public Post.Join innerJoin(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.INNER_JOIN);
        sb.append(str);
        return this;
    }

    public boolean isEmpty() {
        return this.mBuilder.toString().isEmpty();
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.From
    public Post.Join leftJoin(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.LEFT_JOIN);
        sb.append(str);
        return this;
    }

    public NotesSQLBuilder like(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.LIKE);
        sb.append(str);
        return this;
    }

    public NotesSQLBuilder limit(int i) {
        if (i > 0) {
            StringBuilder sb = this.mBuilder;
            sb.append(SQLKeyword.LIMIT);
            sb.append(i);
        }
        return this;
    }

    public NotesSQLBuilder nextOrder(@NonNull String str, @SQLKeyword.SortingOrder String str2) {
        AbstractC1974b.m1332y(this.mBuilder, SQLKeyword.COMMA, str, str2);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Where
    public NotesSQLBuilder notIn(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.NOT_IN);
        sb.append(PropertyUtils.MAPPED_DELIM);
        sb.append(str);
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post.InterfaceC11260As, com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Join
    /* JADX INFO: renamed from: on */
    public Post.InterfaceC11261On mo12421on(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.f7404ON);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.From, com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Where
    public NotesSQLBuilder orderBy(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = this.mBuilder;
            sb.append(SQLKeyword.ORDER_BY);
            sb.append(str);
        }
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Base
    public NotesSQLBuilder replace(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (!this.mNoSpacePartialMatching) {
            this.mBuilder.append(str);
            return this;
        }
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.REPLACE);
        sb.append(PropertyUtils.MAPPED_DELIM);
        sb.append(str);
        sb.append(SQLKeyword.COMMA);
        AbstractC2821a.m2207B(sb, str2, SQLKeyword.COMMA, str3, ") ");
        return this;
    }

    public Post.Select select(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.SELECT);
        sb.append(str);
        return this;
    }

    public Post.Select selectDistinct(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.SELECT_DISTINCT);
        sb.append(str);
        return this;
    }

    public NotesSQLBuilder setNoSpacePartialMatching(boolean z) {
        this.mNoSpacePartialMatching = z;
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.When
    public Post.Then then() {
        this.mBuilder.append(SQLKeyword.THEN);
        return this;
    }

    public NotesSQLBuilder union() {
        this.mBuilder.append(SQLKeyword.UNION);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Then
    public Post.When when(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.WHEN);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.From
    public Post.Where where(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = this.mBuilder;
            sb.append(SQLKeyword.WHERE);
            sb.append(str);
        }
        return this;
    }

    public NotesSQLBuilder withDelimiter(boolean z) {
        return z ? delimiter() : this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post.InterfaceC11260As
    /* JADX INFO: renamed from: as */
    public Post.InterfaceC11260As mo12419as(@NonNull String str, @NonNull String str2) {
        AbstractC2821a.m2207B(this.mBuilder, str, SQLKeyword.f7402AS, str2, " , ");
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.Post.InterfaceC11260As
    public NotesSQLBuilder asEnd(@NonNull String str, @NonNull String str2) {
        AbstractC1974b.m1332y(this.mBuilder, str, SQLKeyword.f7402AS, str2);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Select
    public Post.When caseWhen(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.CASE_WHEN);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.When
    public NotesSQLBuilder exists(@NonNull String str) {
        AbstractC2821a.m2207B(this.mBuilder, SQLKeyword.EXISTS, "(", str, ")");
        return this;
    }

    /* JADX INFO: renamed from: or */
    public NotesSQLBuilder m12422or() {
        this.mBuilder.append(SQLKeyword.f7405OR);
        return this;
    }

    public Post.Select select() {
        this.mBuilder.append(SQLKeyword.SELECT);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.When
    public Post.Then then(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.THEN);
        sb.append(str);
        return this;
    }

    public NotesSQLBuilder union(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.UNION);
        sb.append(str);
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Then
    public NotesSQLBuilder and(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = this.mBuilder;
            sb.append(SQLKeyword.AND);
            sb.append(str);
        }
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Then
    /* JADX INFO: renamed from: or */
    public NotesSQLBuilder mo12423or(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = this.mBuilder;
            sb.append(SQLKeyword.f7405OR);
            sb.append(str);
        }
        return this;
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.From
    public NotesSQLBuilder orderBy(@NonNull String str, @SQLKeyword.SortingOrder String str2) {
        AbstractC1974b.m1332y(this.mBuilder, SQLKeyword.ORDER_BY, str, str2);
        return this;
    }

    public NotesSQLBuilder(int i) {
        this.mNoSpacePartialMatching = true;
        this.mBuilder = new StringBuilder(i);
    }

    @Override // com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post.Base
    public NotesSQLBuilder replace(@NonNull String str) {
        StringBuilder sb = this.mBuilder;
        sb.append(SQLKeyword.REPLACE);
        sb.append(str);
        return this;
    }
}
