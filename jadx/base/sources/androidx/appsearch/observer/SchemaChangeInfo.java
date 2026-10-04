package androidx.appsearch.observer;

import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class SchemaChangeInfo {
    private final Set<String> mChangedSchemaNames;
    private final String mDatabaseName;
    private final String mPackageName;

    public SchemaChangeInfo(String str, String str2, Set<String> set) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        this.mChangedSchemaNames = Collections.unmodifiableSet((Set) Preconditions.checkNotNull(set));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchemaChangeInfo)) {
            return false;
        }
        SchemaChangeInfo schemaChangeInfo = (SchemaChangeInfo) obj;
        return this.mPackageName.equals(schemaChangeInfo.mPackageName) && this.mDatabaseName.equals(schemaChangeInfo.mDatabaseName) && this.mChangedSchemaNames.equals(schemaChangeInfo.mChangedSchemaNames);
    }

    public Set<String> getChangedSchemaNames() {
        return this.mChangedSchemaNames;
    }

    public String getDatabaseName() {
        return this.mDatabaseName;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.mPackageName, this.mDatabaseName, this.mChangedSchemaNames);
    }

    public String toString() {
        return "SchemaChangeInfo{packageName='" + this.mPackageName + "', databaseName='" + this.mDatabaseName + "', changedSchemaNames='" + this.mChangedSchemaNames + "'}";
    }
}
