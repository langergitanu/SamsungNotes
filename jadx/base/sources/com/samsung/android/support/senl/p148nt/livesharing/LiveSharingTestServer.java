package com.samsung.android.support.senl.p148nt.livesharing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSessionHandler;
import com.samsung.android.support.senl.p148nt.livesharing.TestConstant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class LiveSharingTestServer {
    private static final String TAG = "LS$LiveSharingTestServer";
    ClientBroadcastReceiver mClientBroadcastReceiver;
    Context mContext;
    Method mMethod;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.livesharing.LiveSharingTestServer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C113951 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$livesharing$TestConstant$ClientMethod */
        static final /* synthetic */ int[] f7574xb9c5b9a5;

        static {
            int[] iArr = new int[TestConstant.ClientMethod.values().length];
            f7574xb9c5b9a5 = iArr;
            try {
                iArr[TestConstant.ClientMethod.CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7574xb9c5b9a5[TestConstant.ClientMethod.DISCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7574xb9c5b9a5[TestConstant.ClientMethod.QUERY_MEETING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7574xb9c5b9a5[TestConstant.ClientMethod.START_CO_DOING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7574xb9c5b9a5[TestConstant.ClientMethod.END_CO_DOING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7574xb9c5b9a5[TestConstant.ClientMethod.SEND_DATA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7574xb9c5b9a5[TestConstant.ClientMethod.SEND_QUERY_CO_DOING_STATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ClientBroadcastReceiver extends BroadcastReceiver {
        ClientMethodDelegate mClientMethodDelegate;

        public ClientBroadcastReceiver(ClientMethodDelegate clientMethodDelegate) {
            this.mClientMethodDelegate = clientMethodDelegate;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            switch (C113951.f7574xb9c5b9a5[TestConstant.ClientMethod.valueOf(intent.getExtras().getString("method")).ordinal()]) {
                case 1:
                    this.mClientMethodDelegate.onConnect();
                    break;
                case 2:
                    this.mClientMethodDelegate.onDisconnect();
                    break;
                case 3:
                    this.mClientMethodDelegate.onQueryMeeting();
                    break;
                case 4:
                    this.mClientMethodDelegate.onStartCoDoing();
                    break;
                case 5:
                    this.mClientMethodDelegate.onEndCoDoing();
                    break;
                case 6:
                    this.mClientMethodDelegate.onSendData(new LiveSharingData(intent.getExtras().getByteArray("data")));
                    break;
                case 7:
                    this.mClientMethodDelegate.onQueryCoDoingState(new LiveSharingData(intent.getExtras().getByteArray("data")));
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ClientMethodDelegate {
        void onConnect();

        void onDisconnect();

        void onEndCoDoing();

        void onQueryCoDoingState(LiveSharingData liveSharingData);

        void onQueryMeeting();

        void onSendData(LiveSharingData liveSharingData);

        void onStartCoDoing();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* JADX INFO: loaded from: classes4.dex */
    public class Method {
        public Method() {
        }

        private Intent createIntent() {
            Intent intent = new Intent();
            intent.setAction(TestConstant.SERVER_ACTION);
            intent.setPackage("com.samsung.android.app.notes");
            return intent;
        }

        public boolean join() {
            try {
                LiveSharingTestServer.this.mContext.startActivity(LiveSharingIntent.createStartNoteIntent());
                return true;
            } catch (Exception e) {
                Log.i(LiveSharingTestServer.TAG, "join# " + e.getMessage());
                return false;
            }
        }

        public void sendEndConnection(AddonSessionHandler.EndReason endReason) {
            Intent intentCreateIntent = createIntent();
            intentCreateIntent.putExtra("method", TestConstant.ServerMethod.END_CONNECTION.name());
            intentCreateIntent.putExtra(TestConstant.KEY_END_REASON, endReason.name());
            LiveSharingTestServer.this.mContext.sendBroadcast(intentCreateIntent);
        }

        public void sendFailure() {
            Intent intentCreateIntent = createIntent();
            intentCreateIntent.putExtra("method", TestConstant.ServerMethod.FAILURE.name());
            LiveSharingTestServer.this.mContext.sendBroadcast(intentCreateIntent);
        }

        public void sendQueryCoDoingState() {
            Intent intentCreateIntent = createIntent();
            intentCreateIntent.putExtra("method", TestConstant.ServerMethod.QUERY_CO_DOING_STATE.name());
            LiveSharingTestServer.this.mContext.sendBroadcast(intentCreateIntent);
        }

        public void sendStateChanged(LiveSharingData liveSharingData) {
            Intent intentCreateIntent = createIntent();
            intentCreateIntent.putExtra("method", TestConstant.ServerMethod.STATE_CHANGED.name());
            intentCreateIntent.putExtra("data", liveSharingData.getCoDoingState().state());
            LiveSharingTestServer.this.mContext.sendBroadcast(intentCreateIntent);
        }

        public void sendSuccess(@Nullable AddonMeetingInfo.MeetingStatus meetingStatus) {
            Intent intentCreateIntent = createIntent();
            intentCreateIntent.putExtra("method", TestConstant.ServerMethod.SUCCESS.name());
            if (meetingStatus != null) {
                intentCreateIntent.putExtra(TestConstant.KEY_MEETING_STATE, meetingStatus.name());
            }
            LiveSharingTestServer.this.mContext.sendBroadcast(intentCreateIntent);
        }

        public boolean startNotes() {
            try {
                LiveSharingTestServer.this.mContext.startActivity(LiveSharingIntent.createStartNoteIntent());
                return true;
            } catch (Exception e) {
                Log.i(LiveSharingTestServer.TAG, "startNotes# " + e.getMessage());
                return false;
            }
        }
    }

    public LiveSharingTestServer(Context context, ClientMethodDelegate clientMethodDelegate) {
        this.mContext = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TestConstant.CLIENT_ACTION);
        ClientBroadcastReceiver clientBroadcastReceiver = new ClientBroadcastReceiver(clientMethodDelegate);
        this.mClientBroadcastReceiver = clientBroadcastReceiver;
        context.registerReceiver(clientBroadcastReceiver, intentFilter);
        this.mMethod = new Method();
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public void release() {
        this.mContext.unregisterReceiver(this.mClientBroadcastReceiver);
        this.mContext = null;
    }
}
