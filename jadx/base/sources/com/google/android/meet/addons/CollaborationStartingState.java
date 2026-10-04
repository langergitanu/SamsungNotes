package com.google.android.meet.addons;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
@PublicApi
public abstract class CollaborationStartingState {
    public static final int MAX_ADDITIONAL_DATA_CHARS = 4096;
    public static final int MAX_URL_CHARS = 512;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract CollaborationStartingState autoBuild();

        @NonNull
        public final CollaborationStartingState build() {
            CollaborationStartingState collaborationStartingStateAutoBuild = autoBuild();
            String strAdditionalData = collaborationStartingStateAutoBuild.additionalData();
            Uri uriMainStageUrl = collaborationStartingStateAutoBuild.mainStageUrl();
            Uri uriSidePanelUrl = collaborationStartingStateAutoBuild.sidePanelUrl();
            Preconditions.checkArgument(strAdditionalData == null || strAdditionalData.length() <= 4096, "The additional data exceeds the maximum allowed length %s.", 4096);
            Preconditions.checkArgument(uriMainStageUrl == null || uriMainStageUrl.getPath() == null || ((String) Preconditions.checkNotNull(uriMainStageUrl.getPath())).length() <= 512, "The main stage URL path exceeds the maximum allowed length %s.", 512);
            Preconditions.checkArgument(uriSidePanelUrl == null || uriSidePanelUrl.getPath() == null || ((String) Preconditions.checkNotNull(uriSidePanelUrl.getPath())).length() <= 512, "The side panel URL path exceeds the maximum allowed length %s.", 512);
            return collaborationStartingStateAutoBuild;
        }

        @NonNull
        public abstract Builder setAdditionalData(@NonNull String str);

        @NonNull
        public abstract Builder setMainStageUrl(@NonNull Uri uri);

        @NonNull
        public abstract Builder setSidePanelUrl(@NonNull Uri uri);
    }

    @NonNull
    public static Builder builder() {
        return new zzx();
    }

    @Nullable
    public abstract String additionalData();

    @Nullable
    public abstract Uri mainStageUrl();

    @Nullable
    public abstract Uri sidePanelUrl();
}
