package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.SeslConfigurationCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class SuggestiveDialog {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder extends AlertDialog.Builder {
        public Builder(@NonNull Context context) {
            this(context, 0);
        }

        public static Context resolveSuggestiveDialogTheme(Context context) {
            ContextWrapper contextWrapper = new ContextWrapper(context);
            contextWrapper.setTheme(SeslConfigurationCompat.isNightModeActive(context.getResources().getConfiguration()) ? C0419R.style.Theme_AppCompat_Suggestive : C0419R.style.Theme_AppCompat_Suggestive_Light);
            return contextWrapper;
        }

        public Builder(@NonNull Context context, int i) {
            super(resolveSuggestiveDialogTheme(context), i);
        }
    }
}
