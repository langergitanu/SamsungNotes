package androidx.compose.p109ui.platform.coreshims;

import android.os.Bundle;
import android.view.ViewStructure;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ViewStructureCompat {
    private final Object mWrappedObj;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }

        @DoNotInline
        public static void setClassName(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        @DoNotInline
        public static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        @DoNotInline
        public static void setDimens(ViewStructure viewStructure, int i, int i2, int i4, int i5, int i6, int i7) {
            viewStructure.setDimens(i, i2, i4, i5, i6, i7);
        }

        public static void setId(ViewStructure viewStructure, int i, String str, String str2, String str3) {
            viewStructure.setId(i, str, str2, str3);
        }

        @DoNotInline
        public static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }

        @DoNotInline
        public static void setTextStyle(ViewStructure viewStructure, float f, int i, int i2, int i4) {
            viewStructure.setTextStyle(f, i, i2, i4);
        }
    }

    private ViewStructureCompat(@NonNull ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    @NonNull
    @RequiresApi(23)
    public static ViewStructureCompat toViewStructureCompat(@NonNull ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    @Nullable
    public Bundle getExtras() {
        return Api23Impl.getExtras((ViewStructure) this.mWrappedObj);
    }

    public void setClassName(@NonNull String str) {
        Api23Impl.setClassName((ViewStructure) this.mWrappedObj, str);
    }

    public void setContentDescription(@NonNull CharSequence charSequence) {
        Api23Impl.setContentDescription((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setDimens(int i, int i2, int i4, int i5, int i6, int i7) {
        Api23Impl.setDimens((ViewStructure) this.mWrappedObj, i, i2, i4, i5, i6, i7);
    }

    public void setId(int i, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Api23Impl.setId((ViewStructure) this.mWrappedObj, i, str, str2, str3);
    }

    public void setText(@NonNull CharSequence charSequence) {
        Api23Impl.setText((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setTextStyle(float f, int i, int i2, int i4) {
        Api23Impl.setTextStyle((ViewStructure) this.mWrappedObj, f, i, i2, i4);
    }

    @NonNull
    @RequiresApi(23)
    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }
}
