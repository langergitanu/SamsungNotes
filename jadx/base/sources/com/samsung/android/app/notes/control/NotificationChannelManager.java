package com.samsung.android.app.notes.control;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.app.notes.sync.migration.MigrationService;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.NotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.service.ServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.util.NotificationUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NotificationChannelManager {
    private static final String PREF_CLEAR_NOTIFICATION_KEY = "clear_notification_history";
    private static final int PREF_CLEAR_NOTIFICATION_VER = 1;
    private static List<String> sChannelIds;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Channel {
        VOICE(NotificationConstants.VOICE_NOTIFICATION_CHANNEL_ID, C9086R.string.voice_notification_channel_name),
        MDE(NotificationConstants.MDE_NOTIFICATION_CHANNEL_ID, C8003R.string.shared_notebooks),
        DOCUMENT(NotificationConstants.DOCUMENT_NOTIFICATION_CHANNEL_ID, C8003R.string.base_string_save_to_note),
        TEXT_MINING(NotificationConstants.RESTORE_TEXT_NOTIFICATION_CHANNEL_ID, C11397R.string.composer_text_recognition_dialog_title),
        IMPORT(NotificationConstants.IMPORT_NOTIFICATION_CHANNEL_ID, C7943R.string.sync_tipcard_impoort_downloading_title),
        POPUP_NOTE(NotificationConstants.POPUP_NOTE_NOTIFICATION_CHANNEL_ID, C8003R.string.aircommand_create_note),
        SCREEN_OFF_MEMO(NotificationConstants.SCREEN_OFF_NOTIFICATION_CHANNEL_ID, C8003R.string.screenoff_screen_off_memo),
        SMART_SWITCH(NotificationConstants.MIGRATION_NOTIFICATION_CHANNEL_ID, C7943R.string.migration_restore_data),
        COLLECTOR(NotificationConstants.COLLECT_NOTIFICATION_CHANNEL_ID, C8003R.string.composer_text_recognition_dialog_title),
        COEDIT(NotificationConstants.COEDIT_NOTIFICATION_CHANNEL_ID, C8003R.string.co_edit_title),
        TRANSLATION(NotificationConstants.TRANSLATION_NOTIFICATION_CHANNEL_ID, C8003R.string.ai_action_add_to_note);

        private final String mChannelId;
        private final int mChannelNameResId;

        Channel(String str, int i) {
            this.mChannelId = str;
            this.mChannelNameResId = i;
        }

        public static List<String> getIDs() {
            ArrayList arrayList = new ArrayList();
            for (Channel channel : values()) {
                arrayList.add(channel.mChannelId);
            }
            return arrayList;
        }

        public Channel[] getValues() {
            return values();
        }
    }

    public static void cleanNotificationChannels(Context context) {
        if (ServiceManager.INSTANCE.getInstance().canWorkOnBackground()) {
            SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
            if (sharedPreferencesCompat.getInt(PREF_CLEAR_NOTIFICATION_KEY, 0) == 1) {
                return;
            }
            ArrayList arrayList = new ArrayList(getChannelIds());
            arrayList.remove(NotificationConstants.VOICE_NOTIFICATION_CHANNEL_ID);
            arrayList.remove(NotificationConstants.MDE_NOTIFICATION_CHANNEL_ID);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                NotificationUtils.deleteNotificationChannel(context, (String) it.next());
            }
            sharedPreferencesCompat.putInt(PREF_CLEAR_NOTIFICATION_KEY, 1);
        }
    }

    private static synchronized List<String> getChannelIds() {
        try {
            if (sChannelIds == null) {
                sChannelIds = Channel.getIDs();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sChannelIds;
    }

    public static void updateNotificationChannels(@NonNull Context context) {
        String channelName;
        NotificationUtils.deleteNotUsedNotificationChannels(context, getChannelIds());
        for (Channel channel : Channel.values()) {
            if (channel.mChannelNameResId == C8003R.string.sync_notification_channel_name_sync) {
                int i = C8003R.string.notes;
                if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
                    i = C8003R.string.notes_jp;
                }
                channelName = context.getResources().getString(channel.mChannelNameResId, context.getString(i));
            } else {
                channelName = Channel.SMART_SWITCH.mChannelId.equals(channel.mChannelId) ? MigrationService.getChannelName(context) : context.getResources().getString(channel.mChannelNameResId);
            }
            NotificationUtils.updateNotificationChannel(context, channel.mChannelId, channelName);
        }
    }
}
