package p025F0;

import android.content.Context;
import androidx.room.Room;
import androidx.room.migration.Migration;
import com.samsung.android.app.notes.sync.microsoft.graph.data.GraphDatabase;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: F0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0087b {

    /* JADX INFO: renamed from: a */
    public static volatile GraphDatabase f292a;

    /* JADX INFO: renamed from: b */
    public static AtomicBoolean f293b;

    /* JADX INFO: renamed from: a */
    public static GraphDatabase m228a(Context context, boolean z) {
        MSLogger.m8635i("GraphDatabaseManager", "getDatabase, inMemory : " + z);
        Migration[] migrationArr = AbstractC0089d.f295a;
        return z ? (GraphDatabase) Room.inMemoryDatabaseBuilder(context.getApplicationContext(), GraphDatabase.class).allowMainThreadQueries().fallbackToDestructiveMigration().addMigrations(migrationArr).build() : (GraphDatabase) Room.databaseBuilder(context.getApplicationContext(), GraphDatabase.class, "graph.db").allowMainThreadQueries().fallbackToDestructiveMigration().addCallback(new C0086a()).addMigrations(migrationArr).build();
    }
}
