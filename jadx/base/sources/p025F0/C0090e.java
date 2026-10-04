package p025F0;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* JADX INFO: renamed from: F0.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0090e extends SharedSQLiteStatement {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f296a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0090e(RoomDatabase roomDatabase, int i) {
        super(roomDatabase);
        this.f296a = i;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f296a) {
            case 0:
                return "INSERT OR REPLACE INTO graph_sync(docUUID, commandType, requestedServerTimestamp, msAccountId, msDocumentId) VALUES(?, ?, ?, ?, ?) ";
            case 1:
                return "DELETE FROM graph_sync WHERE docUuid =? AND commandType =?";
            default:
                return "DELETE FROM graph_sync";
        }
    }
}
