package com.samsung.android.support.senl.p148nt.data.database.core.migration;

import androidx.room.migration.Migration;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion19;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion20;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion21;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion22;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion23;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion24;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion25;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion26;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion27;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion28;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion29;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion30;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion31;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion32;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion33;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion34;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion35;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion36;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion37;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion38;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion39;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion40;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.legacy.dbversion.AlterDBtoVersion41;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion42;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion43;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion44;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion45;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion46;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion47;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion48;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion49;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion50;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion51;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion52;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion53;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion54;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion55;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion56;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion57;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion58;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion59;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion60;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion61;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion62;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion63;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion64;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion65;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion66;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.version.MigrationToVersion67;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Migrations {
    public static final int DATA_CLEAR_APP_VERSION = 5;
    public static final int DB_CURRENT_VERSION = 67;
    public static final int RECOMMENDED_APP_VERSION = 6;
    public static final AtomicBoolean NEED_TO_BE_CLEARED_DATA = new AtomicBoolean(false);
    public static final Migration[] MIGRATIONS = {new AlterDBtoVersion19(), new AlterDBtoVersion20(), new AlterDBtoVersion21(), new AlterDBtoVersion22(), new AlterDBtoVersion23(), new AlterDBtoVersion24(), new AlterDBtoVersion25(), new AlterDBtoVersion26(), new AlterDBtoVersion27(), new AlterDBtoVersion28(), new AlterDBtoVersion29(), new AlterDBtoVersion30(), new AlterDBtoVersion31(), new AlterDBtoVersion32(), new AlterDBtoVersion33(), new AlterDBtoVersion34(), new AlterDBtoVersion35(), new AlterDBtoVersion36(), new AlterDBtoVersion37(), new AlterDBtoVersion38(), new AlterDBtoVersion39(), new AlterDBtoVersion40(), new AlterDBtoVersion41(), new MigrationToVersion42(), new MigrationToVersion43(), new MigrationToVersion44(), new MigrationToVersion45(), new MigrationToVersion46(), new MigrationToVersion47(), new MigrationToVersion48(), new MigrationToVersion49(), new MigrationToVersion50(), new MigrationToVersion51(), new MigrationToVersion52(), new MigrationToVersion53(), new MigrationToVersion54(), new MigrationToVersion55(), new MigrationToVersion56(), new MigrationToVersion57(), new MigrationToVersion58(), new MigrationToVersion59(), new MigrationToVersion60(), new MigrationToVersion61(), new MigrationToVersion62(), new MigrationToVersion63(), new MigrationToVersion64(), new MigrationToVersion65(), new MigrationToVersion66(), new MigrationToVersion67()};
}
