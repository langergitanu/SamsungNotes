package com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface Post {

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post$As */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InterfaceC11260As extends Base {
        /* JADX INFO: renamed from: as */
        InterfaceC11260As mo12418as(@NonNull String str);

        /* JADX INFO: renamed from: as */
        InterfaceC11260As mo12419as(@NonNull String str, @NonNull String str2);

        NotesSQLBuilder asEnd(@NonNull String str);

        NotesSQLBuilder asEnd(@NonNull String str, @NonNull String str2);

        String build();

        NotesSQLBuilder delimiter();

        /* JADX INFO: renamed from: on */
        InterfaceC11261On mo12421on(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Base {
        NotesSQLBuilder append(@NonNull String str);

        NotesSQLBuilder replace(@NonNull String str);

        NotesSQLBuilder replace(@NonNull String str, @NonNull String str2, @NonNull String str3);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface From extends InterfaceC11260As {
        String build();

        NotesSQLBuilder groupBy(@NonNull String str);

        Join innerJoin(@NonNull String str);

        Join leftJoin(@NonNull String str);

        NotesSQLBuilder orderBy(@NonNull String str);

        NotesSQLBuilder orderBy(@NonNull String str, @SQLKeyword.SortingOrder String str2);

        Where where(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Join extends InterfaceC11260As {
        /* JADX INFO: renamed from: on */
        InterfaceC11261On mo12421on(@NonNull String str);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.data.database.core.query.sqlbuilder.Post$On */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InterfaceC11261On extends From {
        InterfaceC11261On and(@Nullable String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Select extends InterfaceC11260As {
        When caseWhen();

        When caseWhen(@NonNull String str);

        From from(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Then extends Base {
        Then and(@Nullable String str);

        NotesSQLBuilder elseEnd(@NonNull String str);

        /* JADX INFO: renamed from: or */
        Then mo12423or(@Nullable String str);

        When when(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface When extends Base {
        When exists(@NonNull String str);

        /* JADX INFO: renamed from: in */
        NotesSQLBuilder mo12420in(@NonNull String str);

        Then then();

        Then then(@NonNull String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Where extends Base {
        NotesSQLBuilder and(@Nullable String str);

        String build();

        NotesSQLBuilder groupBy(@NonNull String str);

        /* JADX INFO: renamed from: in */
        NotesSQLBuilder mo12420in(@NonNull String str);

        NotesSQLBuilder notIn(@NonNull String str);

        /* JADX INFO: renamed from: or */
        NotesSQLBuilder mo12423or(@Nullable String str);

        NotesSQLBuilder orderBy(@NonNull String str);
    }
}
