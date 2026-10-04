package com.google.api.services.drive;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DriveScopes {
    public static final String DRIVE = "https://www.googleapis.com/auth/drive";
    public static final String DRIVE_APPDATA = "https://www.googleapis.com/auth/drive.appdata";
    public static final String DRIVE_APPS_READONLY = "https://www.googleapis.com/auth/drive.apps.readonly";
    public static final String DRIVE_FILE = "https://www.googleapis.com/auth/drive.file";
    public static final String DRIVE_METADATA = "https://www.googleapis.com/auth/drive.metadata";
    public static final String DRIVE_METADATA_READONLY = "https://www.googleapis.com/auth/drive.metadata.readonly";
    public static final String DRIVE_PHOTOS_READONLY = "https://www.googleapis.com/auth/drive.photos.readonly";
    public static final String DRIVE_READONLY = "https://www.googleapis.com/auth/drive.readonly";
    public static final String DRIVE_SCRIPTS = "https://www.googleapis.com/auth/drive.scripts";

    private DriveScopes() {
    }

    public static Set<String> all() {
        HashSet hashSet = new HashSet();
        hashSet.add("https://www.googleapis.com/auth/drive");
        hashSet.add("https://www.googleapis.com/auth/drive.appdata");
        hashSet.add(DRIVE_APPS_READONLY);
        hashSet.add("https://www.googleapis.com/auth/drive.file");
        hashSet.add(DRIVE_METADATA);
        hashSet.add(DRIVE_METADATA_READONLY);
        hashSet.add(DRIVE_PHOTOS_READONLY);
        hashSet.add(DRIVE_READONLY);
        hashSet.add(DRIVE_SCRIPTS);
        return Collections.unmodifiableSet(hashSet);
    }
}
