package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public interface ParticipantMetadataHandler {
    public static final long MAX_INDIVIDUAL_PARTICIPANT_METADATA_SIZE_BYTES = 200;

    void onParticipantMetadataUpdated(@NonNull Set<Byte[]> set);
}
