package com.google.api.services.drive;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DriveRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public DriveRequestInitializer() {
    }

    @Override // com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer
    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> abstractGoogleJsonClientRequest) {
        super.initializeJsonRequest(abstractGoogleJsonClientRequest);
        initializeDriveRequest((DriveRequest) abstractGoogleJsonClientRequest);
    }

    public DriveRequestInitializer(String str) {
        super(str);
    }

    public DriveRequestInitializer(String str, String str2) {
        super(str, str2);
    }

    public void initializeDriveRequest(DriveRequest<?> driveRequest) {
    }
}
