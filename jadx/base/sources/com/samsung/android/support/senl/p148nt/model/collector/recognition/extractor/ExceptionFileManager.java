package com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ExceptionFileManager {
    private static final int MAX_RETRY_COUNT = 3;
    private static final String PREF_FILE_NAME = "RequestedFileNameManager";
    private static final String PREF_KEY_EXCEPTED_LIST = "RequestedFileNamePref_Key_Excepted_FileNames";
    private static final String PREF_KEY_WORKING_LIST = "RequestedFileNamePref_Key_FileNames";
    private static final String TAG = CollectLogger.createTag("ExceptionFileManager");

    public static synchronized void addFileInExceptList(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, 0);
        if (sharedPreferences != null) {
            HashSet hashSet = new HashSet(sharedPreferences.getStringSet(PREF_KEY_EXCEPTED_LIST, new HashSet()));
            hashSet.add(str);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putStringSet(PREF_KEY_EXCEPTED_LIST, hashSet);
            editorEdit.apply();
        }
    }

    public static synchronized void addFileInWorkingList(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, 0);
        if (sharedPreferences != null) {
            HashSet hashSet = new HashSet(sharedPreferences.getStringSet(PREF_KEY_WORKING_LIST, new HashSet()));
            hashSet.add(str);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putStringSet(PREF_KEY_WORKING_LIST, hashSet);
            editorEdit.apply();
        }
    }

    public static synchronized Set<String> getExceptedNotes(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getStringSet(PREF_KEY_EXCEPTED_LIST, new HashSet());
        }
        return new HashSet();
    }

    public static synchronized boolean isExistInExceptList(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            Set<String> stringSet = sharedPreferences.getStringSet(PREF_KEY_EXCEPTED_LIST, null);
            if (stringSet != null && stringSet.contains(str)) {
                DataLogger.m12309w(TAG, "Permanently excepted, uuid:" + str);
                return true;
            }
            Set<String> stringSet2 = sharedPreferences.getStringSet(PREF_KEY_WORKING_LIST, null);
            if (stringSet2 != null && stringSet2.contains(str)) {
                int i = sharedPreferences.getInt(str, 0) + 1;
                if (i >= 3) {
                    addFileInExceptList(context, str);
                    removeFileInWorkingList(context, str);
                    DataLogger.m12309w(TAG, "register permanently excepted list : " + i + ", uuid: " + str);
                    return true;
                }
                editorEdit.putInt(str, i);
                DataLogger.m12309w(TAG, "update failed count : " + i + ", uuid: " + str);
            }
            editorEdit.apply();
        }
        return false;
    }

    public static synchronized void removeFileInWorkingList(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, 0);
        if (sharedPreferences != null) {
            HashSet hashSet = new HashSet(sharedPreferences.getStringSet(PREF_KEY_WORKING_LIST, new HashSet()));
            hashSet.remove(str);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(str);
            editorEdit.putStringSet(PREF_KEY_WORKING_LIST, hashSet);
            editorEdit.apply();
            DataLogger.m12302d(TAG, "remove failed list, uuid: " + str);
        }
    }
}
