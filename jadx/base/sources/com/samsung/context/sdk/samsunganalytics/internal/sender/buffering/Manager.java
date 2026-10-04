package com.samsung.context.sdk.samsunganalytics.internal.sender.buffering;

import android.content.Context;
import com.samsung.context.sdk.samsunganalytics.Configuration;
import com.samsung.context.sdk.samsunganalytics.DBOpenHelper;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Constants;
import com.samsung.context.sdk.samsunganalytics.internal.policy.PolicyUtils;
import com.samsung.context.sdk.samsunganalytics.internal.sender.LogType;
import com.samsung.context.sdk.samsunganalytics.internal.sender.SimpleLog;
import com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.database.DbManager;
import com.samsung.context.sdk.samsunganalytics.internal.sender.buffering.queue.QueueManager;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Manager {
    private static Manager instance;
    private DbManager dbManager;
    private QueueManager queueManager;
    private boolean useDatabase;

    private Manager(Context context, boolean z) {
        if (z) {
            this.dbManager = new DbManager(context);
        }
        this.queueManager = new QueueManager();
        this.useDatabase = z;
    }

    public static Manager getInstance(Context context, Configuration configuration) {
        if (instance == null) {
            synchronized (Manager.class) {
                try {
                    if (instance == null) {
                        if (PolicyUtils.getSenderType() == 0 && Preferences.getPreferences(context).getString(Constants.KEY_LOG_TYPE, "").equals(Constants.VALUE_LOG_TYPE_MIX)) {
                            DBOpenHelper dbOpenHelper = configuration.getDbOpenHelper();
                            if (dbOpenHelper != null) {
                                instance = new Manager(dbOpenHelper);
                            } else {
                                instance = new Manager(context, true);
                            }
                        } else {
                            instance = new Manager(context, false);
                        }
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private void mergeQueueToDb() {
        if (this.queueManager.getAll().isEmpty()) {
            return;
        }
        Iterator<SimpleLog> it = this.queueManager.getAll().iterator();
        while (it.hasNext()) {
            this.dbManager.insert(it.next());
        }
        this.queueManager.getAll().clear();
    }

    public void delete() {
        if (this.useDatabase) {
            this.dbManager.delete(Utils.getDaysAgo(5));
        }
    }

    public void disableDatabaseBuffering() {
        this.useDatabase = false;
    }

    public void enableDatabaseBuffering(Context context) {
        enableDatabaseBuffering(new DbManager(context));
    }

    public Queue<SimpleLog> get() {
        return get(0);
    }

    public long getDataSize() {
        return this.useDatabase ? this.dbManager.getDataSize() : this.queueManager.getDataSize();
    }

    public void insert(SimpleLog simpleLog) {
        if (this.useDatabase) {
            this.dbManager.insert(simpleLog);
        } else {
            this.queueManager.insert(simpleLog);
        }
    }

    public boolean isEmpty() {
        return this.useDatabase ? this.dbManager.isEmpty() : this.queueManager.isEmpty();
    }

    public boolean isEnabledDatabaseBuffering() {
        return this.useDatabase;
    }

    public void remove(String str) {
        if (this.useDatabase) {
            this.dbManager.delete(str);
        }
    }

    public void enableDatabaseBuffering(DbManager dbManager) {
        this.useDatabase = true;
        this.dbManager = dbManager;
        mergeQueueToDb();
    }

    public Queue<SimpleLog> get(int i) {
        Queue<SimpleLog> all;
        if (this.useDatabase) {
            delete();
            all = i <= 0 ? this.dbManager.selectAll() : this.dbManager.selectSome(i);
        } else {
            all = this.queueManager.getAll();
        }
        if (!all.isEmpty()) {
            StringBuilder sb = new StringBuilder("get log from ");
            sb.append(this.useDatabase ? "Database " : "Queue ");
            sb.append("(");
            sb.append(all.size());
            sb.append(")");
            Debug.LogENG(sb.toString());
        }
        return all;
    }

    public void remove(List<String> list) {
        if (!list.isEmpty() && this.useDatabase) {
            this.dbManager.delete(list);
        }
    }

    public void insert(long j, String str, LogType logType) {
        insert(new SimpleLog(j, str, logType));
    }

    private Manager(DBOpenHelper dBOpenHelper) {
        this.dbManager = new DbManager(dBOpenHelper);
        this.queueManager = new QueueManager();
        this.useDatabase = true;
    }
}
