package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslHoverPopupWindowReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
public class SeslSwitchPreferenceScreen extends SwitchPreferenceCompat {
    private View.OnKeyListener mSwitchKeyListener;

    public SeslSwitchPreferenceScreen(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSwitchKeyListener = new View.OnKeyListener() { // from class: androidx.preference.SeslSwitchPreferenceScreen.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i4, KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if (keyCode != 21) {
                    if (keyCode == 22 && !SeslSwitchPreferenceScreen.this.isChecked()) {
                        if (SeslSwitchPreferenceScreen.this.callChangeListener(Boolean.TRUE)) {
                            SeslSwitchPreferenceScreen.this.setChecked(true);
                        }
                        return true;
                    }
                } else if (SeslSwitchPreferenceScreen.this.isChecked()) {
                    if (SeslSwitchPreferenceScreen.this.callChangeListener(Boolean.FALSE)) {
                        SeslSwitchPreferenceScreen.this.setChecked(false);
                    }
                    return true;
                }
                return false;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3711R.styleable.Preference, i, i2);
        String string = typedArrayObtainStyledAttributes.getString(C3711R.styleable.Preference_android_fragment);
        if (string == null || string.equals("")) {
            Log.w("SwitchPreferenceScreen", "SwitchPreferenceScreen should getfragment property. Fragment property does not exsit in SwitchPreferenceScreen");
        }
        setLayoutResource(C3711R.layout.sesl_preference_switch_screen);
        setWidgetLayoutResource(C3711R.layout.sesl_switch_preference_screen_widget_divider);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.mSwitchKeyListener);
        TextView textView = (TextView) preferenceViewHolder.findViewById(android.R.id.title);
        View viewFindViewById = preferenceViewHolder.findViewById(android.R.id.switch_widget);
        View viewFindViewById2 = preferenceViewHolder.findViewById(C3711R.id.switch_widget);
        if (textView == null || viewFindViewById == null || viewFindViewById2 == null) {
            return;
        }
        SeslViewReflector.semSetHoverPopupType(viewFindViewById, SeslHoverPopupWindowReflector.getField_TYPE_NONE());
        viewFindViewById.setContentDescription(textView.getText().toString());
        viewFindViewById2.setContentDescription(textView.getText().toString());
    }

    public SeslSwitchPreferenceScreen(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SeslSwitchPreferenceScreen(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3711R.attr.switchPreferenceStyle);
    }

    public SeslSwitchPreferenceScreen(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    public void callClickListener() {
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
    }
}
