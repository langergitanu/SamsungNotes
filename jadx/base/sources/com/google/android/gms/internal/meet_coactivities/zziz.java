package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zziz implements MeetingStatusListener {
    private final ImmutableSet zza;

    public zziz(ImmutableSet immutableSet) {
        this.zza = immutableSet;
    }

    @Override // com.google.android.meet.addons.MeetingStatusListener
    public final void onMeetingStatusChange(MeetingStatus meetingStatus) {
        UnmodifiableIterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((MeetingStatusListener) it.next()).onMeetingStatusChange(meetingStatus);
        }
    }
}
