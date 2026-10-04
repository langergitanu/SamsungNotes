package com.samsung.android.sdk.pen.objectruntime.preload;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/objectruntime/preload/VideoIntentFragment;", "Landroid/app/Fragment;", "<init>", "()V", "mListener", "Lcom/samsung/android/sdk/pen/objectruntime/preload/VideoIntentFragment$OnVideoIntentFragmentListener;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "setVideoIntentFragmentListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "OnVideoIntentFragmentListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class VideoIntentFragment extends Fragment {

    @Nullable
    private static OnVideoIntentFragmentListener mBackupListener;

    @Nullable
    private OnVideoIntentFragmentListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/objectruntime/preload/VideoIntentFragment$OnVideoIntentFragmentListener;", "", "onResult", "", "data", "Landroid/content/Intent;", "onDestroy", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnVideoIntentFragmentListener {
        void onDestroy();

        void onResult(@Nullable Intent data);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (this.mListener != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setType("video/*");
            startActivityForResult(intent, 0);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            OnVideoIntentFragmentListener onVideoIntentFragmentListener = this.mListener;
            if (onVideoIntentFragmentListener != null) {
                onVideoIntentFragmentListener.onResult(data);
                return;
            }
            return;
        }
        OnVideoIntentFragmentListener onVideoIntentFragmentListener2 = this.mListener;
        if (onVideoIntentFragmentListener2 == null) {
            onVideoIntentFragmentListener2 = mBackupListener;
        }
        if (onVideoIntentFragmentListener2 != null) {
            onVideoIntentFragmentListener2.onResult(data);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OnVideoIntentFragmentListener onVideoIntentFragmentListener = this.mListener;
        if (onVideoIntentFragmentListener != null) {
            onVideoIntentFragmentListener.onDestroy();
        }
    }

    public final void setVideoIntentFragmentListener(@Nullable OnVideoIntentFragmentListener listener) {
        OnVideoIntentFragmentListener onVideoIntentFragmentListener;
        if (listener == null && (onVideoIntentFragmentListener = this.mListener) != null) {
            mBackupListener = onVideoIntentFragmentListener;
        }
        this.mListener = listener;
    }
}
