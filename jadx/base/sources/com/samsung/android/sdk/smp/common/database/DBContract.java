package com.samsung.android.sdk.smp.common.database;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DBContract {
    protected static final String CREATE_TABLE_ACK = "CREATE TABLE IF NOT EXISTS ack (_id INTEGER PRIMARY KEY AUTOINCREMENT,rid TEXT NOT NULL UNIQUE,ts INTEGER NOT NULL,type TEXT NOT NULL,fail INTEGER NOT NULL,errorcode TEXT,errormsg TEXT );";
    protected static final String CREATE_TABLE_APP_FILTER = "CREATE TABLE IF NOT EXISTS appfilter (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT );";
    protected static final String CREATE_TABLE_APP_START = "CREATE TABLE IF NOT EXISTS start (_id INTEGER PRIMARY KEY AUTOINCREMENT,start TEXT NOT NULL,fail INTEGER NOT NULL );";
    protected static final String CREATE_TABLE_EXTERNAL_FEEDBACK = "CREATE TABLE IF NOT EXISTS externalfeedback (_id INTEGER PRIMARY KEY AUTOINCREMENT,path TEXT NOT NULL UNIQUE,fail INTEGER NOT NULL,timestamp INTEGER NOT NULL );";
    protected static final String CREATE_TABLE_FEEDBACK = "CREATE TABLE IF NOT EXISTS feedback (_id INTEGER PRIMARY KEY AUTOINCREMENT,mid TEXT NOT NULL UNIQUE CONSTRAINT fk_cardtable_mid REFERENCES card(mid) ON DELETE CASCADE,lfbid INTEGER NOT NULL,lts INTEGER NOT NULL,feedbacks TEXT NOT NULL,state TEXT NOT NULL,appupdateadded INTEGER,rebootadded INTEGER,debugaction TEXT );";
    protected static final String CREATE_TABLE_MARKETING = "CREATE TABLE IF NOT EXISTS card (_id INTEGER PRIMARY KEY AUTOINCREMENT, mid TEXT NOT NULL UNIQUE,msgtype TEXT,data TEXT,state TEXT NOT NULL,extra TEXT,mrt INTEGER NOT NULL,mdt INTEGER,mct INTEGER,expdt INTEGER,landingredirected INTEGER,fail INTEGER NOT NULL );";
    protected static final String CREATE_TABLE_REFERRER = "CREATE TABLE IF NOT EXISTS appreferrer (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT NOT NULL UNIQUE,value TEXT );";
    protected static final String CREATE_TABLE_SESSION = "CREATE TABLE IF NOT EXISTS session (_id INTEGER PRIMARY KEY AUTOINCREMENT,session TEXT NOT NULL,count INTEGER NOT NULL,fail INTEGER NOT NULL );";
    protected static final String CREATE_TRIGGER_DELETE_FEEDBACK = "CREATE TRIGGER IF NOT EXISTS trigger_delete_fb BEFORE DELETE ON card FOR EACH ROW BEGIN  DELETE FROM feedback WHERE feedback.mid= OLD.mid; END";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AckColumns {
        public static final String ERROR_CODE = "errorcode";
        public static final String ERROR_MSG = "errormsg";
        public static final String FAIL_COUNT = "fail";
        public static final String PUSH_TYPE = "type";
        public static final String RID = "rid";
        public static final String TIMESTAMP = "ts";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AppFilterColumns {
        public static final String KEY = "key";
        public static final String VALUE = "value";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AppReferrerColumns {
        public static final String KEY = "key";
        public static final String VALUE = "value";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AppStartColumns {
        public static final String APP_START = "start";
        public static final String FAIL_COUNT = "fail";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ExternalFeedbackColumns {
        public static final String FAIL_COUNT = "fail";
        public static final String PATH = "path";
        public static final String TIMESTAMP = "timestamp";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FeedbackColumns {
        public static final String DEBUG_ACTION = "debugaction";
        public static final String FEEDBACKS = "feedbacks";
        public static final String IS_APP_UPDATE_FEEDBACK_ADDED = "appupdateadded";
        public static final String IS_REBOOT_FEEDBACK_ADDED = "rebootadded";
        public static final String LAST_FBID = "lfbid";
        public static final String LAST_TIMESTAMP = "lts";
        public static final String MID = "mid";
        public static final String STATE = "state";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MarketingColumns {
        public static final String CLICKED_TIME = "mct";
        public static final String DISPLAYED_TIME = "mdt";
        public static final String EXPECTED_DISPLAY_TIME = "expdt";
        public static final String EXTRA_DATA = "extra";
        public static final String FAIL_COUNT = "fail";
        public static final String IS_LANDING_REDIRECTED = "landingredirected";
        public static final String MID = "mid";
        public static final String MSG_TYPE = "msgtype";
        public static final String RECEIVED_TIME = "mrt";
        public static final String STATE = "state";
        public static final String USER_DATA = "data";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SessionColumns {
        public static final String FAIL_COUNT = "fail";
        public static final String SESSION = "session";
        public static final String SESSION_COUNT = "count";
        public static final String _ID = "_id";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Tables {
        public static final String ACK = "ack";
        public static final String APP_FILTER = "appfilter";
        public static final String APP_REFERRER = "appreferrer";
        public static final String APP_START = "start";
        public static final String EXTERNAL_FEEDBACK = "externalfeedback";
        public static final String FEEDBACK = "feedback";
        public static final String MARKETING = "card";
        public static final String SESSION = "session";
    }
}
