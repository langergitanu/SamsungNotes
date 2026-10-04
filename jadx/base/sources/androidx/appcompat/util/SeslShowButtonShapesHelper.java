package androidx.appcompat.util;

import android.content.ContentResolver;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslShowButtonShapesHelper {
    private Drawable mBackgroundOff;
    private Drawable mBackgroundOn;
    private ContentResolver mContentResolver;
    private View mView;

    public SeslShowButtonShapesHelper(@NonNull View view, @Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this.mView = view;
        this.mContentResolver = view.getContext().getContentResolver();
        this.mBackgroundOn = drawable;
        this.mBackgroundOff = drawable2;
    }

    public void setBackgroundOff(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mBackgroundOn;
        if (drawable2 == null || drawable2 != drawable) {
            this.mBackgroundOff = drawable;
            return;
        }
        Log.w("SeslSBBHelper", drawable + "is same drawable with mBackgroundOn");
    }

    public void setBackgroundOn(@Nullable Drawable drawable) {
        this.mBackgroundOn = drawable;
    }

    public void updateButtonBackground() {
        ViewCompat.setBackground(this.mView, Settings.System.getInt(this.mContentResolver, "show_button_background", 0) == 1 ? this.mBackgroundOn : this.mBackgroundOff);
    }

    public void updateOverflowButtonBackground(Drawable drawable) {
        this.mBackgroundOn = drawable;
        updateButtonBackground();
    }
}
