package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.util.Consumer;
import androidx.core.view.SemBlurCompat;
import androidx.core.view.SeslTouchDelegateFactory;
import androidx.core.view.SeslTouchTargetDelegate;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.reflect.feature.SeslFloatingFeatureReflector;
import androidx.reflect.widget.SeslAdapterViewReflector;
import androidx.reflect.widget.SeslTextViewReflector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    private final Context mContext;
    private View mCustomTitleView;

    @Nullable
    private Consumer<ViewGroup> mDefaultButtonPanelJob;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private ImageView mIconView;
    private int mLastOrientation;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    private boolean mSingleChoiceChecked;
    int mSingleChoiceItemLayout;
    private CompoundButton.OnCheckedChangeListener mSingleChoiceListener;
    private CharSequence mSingleChoiceOptionLabel;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private int mViewSpacingTop;
    private final Window mWindow;
    private boolean mIsBlurEnabled = false;
    private boolean mIsDefaultBlurEnabled = true;
    private boolean mViewSpacingSpecified = false;
    private int mIconId = 0;
    int mCheckedItem = -1;
    private int mButtonPanelLayoutHint = 0;
    private final View.OnClickListener mButtonHandler = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.mButtonPositive || (message3 = alertController.mButtonPositiveMessage) == null) ? (view != alertController.mButtonNegative || (message2 = alertController.mButtonNegativeMessage) == null) ? (view != alertController.mButtonNeutral || (message = alertController.mButtonNeutralMessage) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.mHandler.obtainMessage(1, alertController2.mDialog).sendToTarget();
        }
    };

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C04263 implements NestedScrollView.OnScrollChangeListener {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public C04263(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i4, int i5) {
            AlertController.manageScrollIndicators(nestedScrollView, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC04274 implements Runnable {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public RunnableC04274(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(AlertController.this.mScrollView, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC04296 implements Runnable {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public RunnableC04296(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(AlertController.this.mListView, this.val$top, this.val$bottom);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CompoundButton.OnCheckedChangeListener mSingleChoiceListener;
        public CharSequence mSingleChoiceOptionLabel;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public int mViewSpacingTop;
        public int mIconId = 0;
        public int mIconAttrId = 0;
        public boolean mViewSpacingSpecified = false;
        public int mCheckedItem = -1;
        public boolean mRecycleOnMeasure = true;
        public boolean isSingleChoiceOption = false;
        public boolean mSingleChoiceChecked = false;
        public boolean mCancelable = true;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void createListView(AlertController alertController) {
            AlertParams alertParams;
            final AlertController alertController2;
            ListAdapter checkedItemAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            if (!this.mIsMultiChoice) {
                alertParams = this;
                alertController2 = alertController;
                int i = alertParams.mIsSingleChoice ? alertController2.mSingleChoiceItemLayout : alertController2.mListItemLayout;
                if (alertParams.mCursor != null) {
                    checkedItemAdapter = new SimpleCursorAdapter(alertParams.mContext, i, alertParams.mCursor, new String[]{alertParams.mLabelColumn}, new int[]{R.id.text1});
                } else {
                    checkedItemAdapter = alertParams.mAdapter;
                    if (checkedItemAdapter == null) {
                        checkedItemAdapter = new CheckedItemAdapter(alertParams.mContext, i, R.id.text1, alertParams.mItems);
                    }
                }
            } else if (this.mCursor == null) {
                alertParams = this;
                checkedItemAdapter = new ArrayAdapter<CharSequence>(this.mContext, alertController.mMultiChoiceItemLayout, R.id.text1, this.mItems) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i2, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i2, view, viewGroup);
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null && zArr[i2]) {
                            recycleListView.setItemChecked(i2, true);
                        }
                        return view2;
                    }
                };
                recycleListView = recycleListView;
                alertController2 = alertController;
            } else {
                alertParams = this;
                alertController2 = alertController;
                checkedItemAdapter = new CursorAdapter(alertParams.mContext, alertParams.mCursor, false) { // from class: androidx.appcompat.app.AlertController.AlertParams.2
                    private final int mIsCheckedIndex;
                    private final int mLabelIndex;

                    {
                        Cursor cursor = getCursor();
                        this.mLabelIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                        this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                    }

                    @Override // android.widget.CursorAdapter
                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.mLabelIndex));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.mIsCheckedIndex) == 1);
                    }

                    @Override // android.widget.CursorAdapter
                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return AlertParams.this.mInflater.inflate(alertController2.mMultiChoiceItemLayout, viewGroup, false);
                    }
                };
            }
            OnPrepareListViewListener onPrepareListViewListener = alertParams.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView);
            }
            alertController2.mAdapter = checkedItemAdapter;
            alertController2.mCheckedItem = alertParams.mCheckedItem;
            if (alertParams.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        AlertParams.this.mOnClickListener.onClick(alertController2.mDialog, i2);
                        if (AlertParams.this.mIsSingleChoice) {
                            return;
                        }
                        alertController2.mDialog.dismiss();
                    }
                });
            } else if (alertParams.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null) {
                            zArr[i2] = recycleListView.isItemChecked(i2);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController2.mDialog, i2, recycleListView.isItemChecked(i2));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = alertParams.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (alertParams.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            } else if (alertParams.mIsMultiChoice) {
                recycleListView.setChoiceMode(2);
            }
            alertController2.mListView = recycleListView;
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i = this.mIconId;
                if (i != 0) {
                    alertController.setIcon(i);
                }
                int i2 = this.mIconAttrId;
                if (i2 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i2));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            CharSequence charSequence3 = this.mSingleChoiceOptionLabel;
            if (charSequence3 != null && this.mMessage != null) {
                alertController.setSingleChoiceOption(charSequence3, this.mSingleChoiceChecked, this.mSingleChoiceListener);
            }
            CharSequence charSequence4 = this.mPositiveButtonText;
            if (charSequence4 != null || this.mPositiveButtonIcon != null) {
                alertController.setButton(-1, charSequence4, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
            }
            CharSequence charSequence5 = this.mNegativeButtonText;
            if (charSequence5 != null || this.mNegativeButtonIcon != null) {
                alertController.setButton(-2, charSequence5, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }
            CharSequence charSequence6 = this.mNeutralButtonText;
            if (charSequence6 != null || this.mNeutralButtonIcon != null) {
                alertController.setButton(-3, charSequence6, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                createListView(alertController);
            }
            View view2 = this.mView;
            if (view2 != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                } else {
                    alertController.setView(view2);
                    return;
                }
            }
            int i4 = this.mViewLayoutResId;
            if (i4 != 0) {
                alertController.setView(i4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
            } else {
                if (i != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0419R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0419R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0419R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(appCompatDialog);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, C0419R.styleable.AlertDialog, C0419R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = typedArrayObtainStyledAttributes.getResourceId(C0419R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = typedArrayObtainStyledAttributes.getBoolean(C0419R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0419R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    private void adjustButtonsPadding() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_dialog_button_text_size);
        if (this.mButtonPositive.getVisibility() != 8) {
            this.mButtonPositive.setTextSize(0, dimensionPixelSize);
            checkMaxFontScale(this.mButtonPositive, dimensionPixelSize);
        }
        if (this.mButtonNegative.getVisibility() != 8) {
            this.mButtonNegative.setTextSize(0, dimensionPixelSize);
            checkMaxFontScale(this.mButtonNegative, dimensionPixelSize);
        }
        if (this.mButtonNeutral.getVisibility() != 8) {
            this.mButtonNeutral.setTextSize(0, dimensionPixelSize);
            checkMaxFontScale(this.mButtonNeutral, dimensionPixelSize);
        }
    }

    private void adjustParentPanelPadding(View view) {
        view.setPadding(0, 0, 0, 0);
    }

    private void adjustTopPanelPadding(View view) {
        View viewFindViewById = view.findViewById(C0419R.id.title_template);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_dialog_padding_horizontal);
        viewFindViewById.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }

    public static boolean canTextInput(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (canTextInput(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private void checkMaxFontScale(TextView textView, int i) {
        float f = this.mContext.getResources().getConfiguration().fontScale;
        if (f > 1.3f) {
            textView.setTextSize(0, (i / f) * 1.3f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$seslExpandTouchTarget$0(LinearLayout linearLayout) {
        ArrayList arrayList = new ArrayList();
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            if ((childAt instanceof Button) && childAt.getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        if (linearLayout.getLayoutDirection() == 1 && linearLayout.getOrientation() == 0) {
            Collections.reverse(arrayList);
        }
        SeslTouchTargetDelegate.Builder builderMake = SeslTouchDelegateFactory.make(linearLayout, arrayList);
        if (builderMake != null) {
            builderMake.apply();
        }
    }

    public static void manageScrollIndicators(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private boolean requestFocusForContent(View view) {
        if (view != null && view.requestFocus()) {
            return true;
        }
        ListView listView = this.mListView;
        if (listView == null) {
            return false;
        }
        listView.setSelection(0);
        return true;
    }

    private void requestFocusForDefaultButton() {
        if (this.mButtonPositive.getVisibility() == 0) {
            this.mButtonPositive.requestFocus();
        } else if (this.mButtonNegative.getVisibility() == 0) {
            this.mButtonNegative.requestFocus();
        } else if (this.mButtonNeutral.getVisibility() == 0) {
            this.mButtonNeutral.requestFocus();
        }
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int selectContentView() {
        int i = this.mButtonPanelSideLayout;
        return i == 0 ? this.mAlertDialogLayout : this.mButtonPanelLayoutHint == 1 ? i : this.mAlertDialogLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seslExpandTouchTarget(@Nullable ViewGroup viewGroup) {
        LinearLayout linearLayout;
        if (viewGroup == null || (linearLayout = (LinearLayout) viewGroup.findViewById(C0419R.id.buttonBarLayout)) == null) {
            return;
        }
        linearLayout.post(new RunnableC0452b(linearLayout, 2));
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private void setScrollIndicators(ViewGroup viewGroup, View view, int i, int i2) {
        View viewFindViewById = this.mWindow.findViewById(C0419R.id.scrollIndicatorUp);
        View viewFindViewById2 = this.mWindow.findViewById(C0419R.id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(view, i, i2);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        int i;
        ViewGroup viewGroup2;
        ContentResolver contentResolver = this.mContext.getContentResolver();
        boolean z = contentResolver != null && Settings.System.getInt(contentResolver, "show_button_background", 0) == 1;
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        int color = typedValue.resourceId > 0 ? this.mContext.getResources().getColor(typedValue.resourceId) : -1;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.mButtonPositive = button;
        button.setOnClickListener(this.mButtonHandler);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 26) {
            if (typedValue.resourceId > 0) {
                SeslTextViewReflector.semSetButtonShapeEnabled(this.mButtonPositive, z, color);
            } else {
                SeslTextViewReflector.semSetButtonShapeEnabled(this.mButtonPositive, z);
            }
        } else if (z) {
            this.mButtonPositive.setBackgroundResource(C0419R.drawable.sesl_dialog_btn_show_button_shapes_background);
        }
        if (TextUtils.isEmpty(this.mButtonPositiveText) && this.mButtonPositiveIcon == null) {
            this.mButtonPositive.setVisibility(8);
            i = 0;
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            Drawable drawable = this.mButtonPositiveIcon;
            if (drawable != null) {
                int i4 = this.mButtonIconDimen;
                drawable.setBounds(0, 0, i4, i4);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonPositive.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.mButtonNegative = button2;
        button2.setOnClickListener(this.mButtonHandler);
        if (i2 > 26) {
            if (typedValue.resourceId > 0) {
                SeslTextViewReflector.semSetButtonShapeEnabled(this.mButtonNegative, z, color);
            } else {
                SeslTextViewReflector.semSetButtonShapeEnabled(this.mButtonNegative, z);
            }
        } else if (z) {
            this.mButtonNegative.setBackgroundResource(C0419R.drawable.sesl_dialog_btn_show_button_shapes_background);
        }
        if (TextUtils.isEmpty(this.mButtonNegativeText) && this.mButtonNegativeIcon == null) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            Drawable drawable2 = this.mButtonNegativeIcon;
            if (drawable2 != null) {
                int i5 = this.mButtonIconDimen;
                drawable2.setBounds(0, 0, i5, i5);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
            }
            this.mButtonNegative.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.mButtonNeutral = button3;
        button3.setOnClickListener(this.mButtonHandler);
        if (i2 > 26) {
            if (typedValue.resourceId > 0) {
                SeslTextViewReflector.semSetButtonShapeEnabled(this.mButtonNeutral, z, color);
            } else {
                SeslTextViewReflector.semSetButtonShapeEnabled(this.mButtonNeutral, z);
            }
        } else if (z) {
            this.mButtonNeutral.setBackgroundResource(C0419R.drawable.sesl_dialog_btn_show_button_shapes_background);
        }
        if (TextUtils.isEmpty(this.mButtonNeutralText) && this.mButtonNeutralIcon == null) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            Drawable drawable3 = this.mButtonNeutralIcon;
            if (drawable3 != null) {
                int i6 = this.mButtonIconDimen;
                drawable3.setBounds(0, 0, i6, i6);
                this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
            }
            this.mButtonNeutral.setVisibility(0);
            i |= 4;
        }
        if (shouldCenterSingleButton(this.mContext)) {
            if (i == 1) {
                centerButton(this.mButtonPositive);
            } else if (i == 2) {
                centerButton(this.mButtonNegative);
            } else if (i == 4) {
                centerButton(this.mButtonNeutral);
            }
        }
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
        boolean z2 = this.mButtonNeutral.getVisibility() == 0;
        boolean z3 = this.mButtonPositive.getVisibility() == 0;
        boolean z4 = this.mButtonNegative.getVisibility() == 0;
        View viewFindViewById = this.mWindow.findViewById(C0419R.id.sem_divider2);
        if (viewFindViewById != null && ((z2 && z3) || (z2 && z4))) {
            viewFindViewById.setVisibility(0);
        }
        View viewFindViewById2 = this.mWindow.findViewById(C0419R.id.sem_divider1);
        if (viewFindViewById2 != null && z3 && z4) {
            viewFindViewById2.setVisibility(0);
        }
        if (this.mDefaultButtonPanelJob == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(C0419R.id.buttonBarLayout)) == null) {
            return;
        }
        this.mDefaultButtonPanelJob.accept(viewGroup2);
    }

    private void setupContent(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.mWindow.findViewById(C0419R.id.scrollView);
        this.mScrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.mMessageView = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.mMessage;
        if (charSequence == null) {
            textView.setVisibility(8);
            this.mScrollView.removeView(this.mMessageView);
            if (this.mListView == null) {
                viewGroup.setVisibility(8);
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) this.mScrollView.getParent();
            int iIndexOfChild = viewGroup2.indexOfChild(this.mScrollView);
            viewGroup2.removeViewAt(iIndexOfChild);
            viewGroup2.addView(this.mListView, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        textView.setText(charSequence);
        checkMaxFontScale(this.mMessageView, this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_dialog_body_text_size));
        CheckBox checkBox = (CheckBox) viewGroup.findViewById(C0419R.id.single_choice_option);
        if (checkBox != null) {
            CharSequence charSequence2 = this.mSingleChoiceOptionLabel;
            if (charSequence2 == null) {
                checkBox.setVisibility(8);
                return;
            }
            checkBox.setText(charSequence2);
            checkBox.setChecked(this.mSingleChoiceChecked);
            checkBox.setVisibility(0);
            checkBox.setOnCheckedChangeListener(this.mSingleChoiceListener);
        }
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        View viewInflate = this.mView;
        if (viewInflate == null) {
            viewInflate = this.mViewLayoutResId != 0 ? LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !canTextInput(viewInflate)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(C0419R.id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.mViewSpacingSpecified) {
            frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
        }
        if (this.mListView != null) {
            if (viewGroup.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            } else {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupPaddings() {
        View viewFindViewById = this.mWindow.findViewById(C0419R.id.parentPanel);
        View viewFindViewById2 = this.mWindow.findViewById(C0419R.id.middlePanel);
        View viewFindViewById3 = viewFindViewById.findViewById(C0419R.id.title_template);
        View viewFindViewById4 = viewFindViewById.findViewById(C0419R.id.scrollView);
        View viewFindViewById5 = viewFindViewById.findViewById(C0419R.id.topPanel);
        View viewFindViewById6 = viewFindViewById.findViewById(C0419R.id.buttonBarLayout);
        View viewFindViewById7 = viewFindViewById.findViewById(C0419R.id.customPanel);
        View viewFindViewById8 = viewFindViewById.findViewById(C0419R.id.contentPanel);
        boolean z = (viewFindViewById7 == null || viewFindViewById7.getVisibility() == 8) ? false : true;
        boolean z2 = (viewFindViewById5 == null || viewFindViewById5.getVisibility() == 8) ? false : true;
        boolean z3 = (viewFindViewById8 == null || viewFindViewById8.getVisibility() == 8) ? false : true;
        View view = this.mCustomTitleView;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        Resources resources = this.mContext.getResources();
        if (viewFindViewById2 != null) {
            if ((!z || z2 || z3) && !z4) {
                viewFindViewById2.setPadding(0, resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_title_padding_top), 0, 0);
            } else {
                viewFindViewById2.setPadding(0, 0, 0, 0);
            }
        }
        if (viewFindViewById3 != null) {
            int dimensionPixelSize = resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_padding_horizontal);
            if (z && z2 && !z3) {
                viewFindViewById3.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            } else {
                viewFindViewById3.setPadding(dimensionPixelSize, 0, dimensionPixelSize, resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_title_padding_bottom));
            }
        }
        if (viewFindViewById4 != null) {
            viewFindViewById4.setPadding(resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_body_text_scroll_padding_start), 0, resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_body_text_scroll_padding_end), resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_body_text_padding_bottom));
        }
        if (viewFindViewById6 != null) {
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_button_bar_padding_horizontal);
            viewFindViewById6.setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, resources.getDimensionPixelSize(C0419R.dimen.sesl_dialog_button_bar_padding_bottom));
        }
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            this.mWindow.findViewById(C0419R.id.title_template).setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.mTitle) || !this.mShowTitle) {
            this.mWindow.findViewById(C0419R.id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.mWindow.findViewById(C0419R.id.alertTitle);
        this.mTitleView = textView;
        textView.setText(this.mTitle);
        checkMaxFontScale(this.mTitleView, this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_dialog_title_text_size));
        int i = this.mIconId;
        if (i != 0) {
            this.mIconView.setImageResource(i);
            return;
        }
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
        } else {
            this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
            this.mIconView.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        ListAdapter listAdapter;
        NestedScrollView nestedScrollView;
        final View viewFindViewById = this.mWindow.findViewById(C0419R.id.parentPanel);
        View viewFindViewById2 = this.mWindow.findViewById(C0419R.id.middlePanel);
        viewFindViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.appcompat.app.AlertController.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                view.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlertController.this.mContext.getResources().getConfiguration().orientation != AlertController.this.mLastOrientation) {
                            AlertController.this.setupPaddings();
                            viewFindViewById.requestLayout();
                        }
                        AlertController alertController = AlertController.this;
                        alertController.mLastOrientation = alertController.mContext.getResources().getConfiguration().orientation;
                    }
                });
            }
        });
        View viewFindViewById3 = viewFindViewById.findViewById(C0419R.id.topPanel);
        View viewFindViewById4 = viewFindViewById.findViewById(C0419R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById.findViewById(C0419R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById.findViewById(C0419R.id.customPanel);
        setupCustomContent(viewGroup);
        View viewFindViewById6 = viewGroup.findViewById(C0419R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(C0419R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(C0419R.id.buttonPanel);
        ViewGroup viewGroupResolvePanel = resolvePanel(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupResolvePanel2 = resolvePanel(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupResolvePanel3 = resolvePanel(viewFindViewById8, viewFindViewById5);
        this.mDefaultButtonPanelJob = viewGroupResolvePanel3 == viewFindViewById5 ? new Consumer() { // from class: androidx.appcompat.app.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f937a.seslExpandTouchTarget((ViewGroup) obj);
            }
        } : null;
        setupContent(viewGroupResolvePanel2);
        setupButtons(viewGroupResolvePanel3);
        setupTitle(viewGroupResolvePanel);
        boolean z = true;
        boolean z2 = viewGroup.getVisibility() != 8;
        boolean z3 = (viewGroupResolvePanel == null || viewGroupResolvePanel.getVisibility() == 8) ? 0 : 1;
        boolean z4 = (viewGroupResolvePanel3 == null || viewGroupResolvePanel3.getVisibility() == 8) ? false : true;
        boolean z5 = (viewFindViewById3 == null || viewFindViewById3.getVisibility() == 8) ? false : true;
        boolean z6 = (viewFindViewById4 == null || viewFindViewById4.getVisibility() == 8) ? false : true;
        View view = this.mCustomTitleView;
        boolean z7 = (view == null || view.getVisibility() == 8) ? false : true;
        if ((z2 && !z5 && !z6) || z7) {
            adjustParentPanelPadding(viewFindViewById2);
        }
        if (z2 && z5 && !z6) {
            adjustTopPanelPadding(viewFindViewById);
        }
        adjustButtonsPadding();
        if (!viewFindViewById.isInTouchMode()) {
            if (!z2) {
                viewGroup = viewGroupResolvePanel2;
            }
            if (!requestFocusForContent(viewGroup)) {
                requestFocusForDefaultButton();
            }
        }
        if (z3 != 0 && (nestedScrollView = this.mScrollView) != null) {
            nestedScrollView.setClipToPadding(true);
        }
        ListView listView = this.mListView;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z3, z4);
        }
        if (!z2) {
            View view2 = this.mListView;
            if (view2 == null) {
                view2 = this.mScrollView;
            }
            if (view2 != null) {
                setScrollIndicators(viewGroupResolvePanel2, view2, (z4 ? 2 : 0) | z3, 3);
            }
        }
        ListView listView2 = this.mListView;
        if (listView2 != null && (listAdapter = this.mAdapter) != null) {
            listView2.setAdapter(listAdapter);
            SeslAdapterViewReflector.semSetBottomColor(listView2, 0);
            int i = this.mCheckedItem;
            if (i > -1) {
                listView2.setItemChecked(i, true);
                listView2.setSelectionFromTop(i, this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_select_dialog_padding_top));
            }
        }
        if (Build.VERSION.SDK_INT >= 36) {
            String string = SeslFloatingFeatureReflector.getString("SEC_FLOATING_FEATURE_GRAPHICS_SUPPORT_3D_SURFACE_TRANSITION_FLAG", "FALSE");
            boolean zIsLightTheme = SeslMisc.isLightTheme(this.mContext);
            boolean z8 = Settings.System.getString(this.mContext.getContentResolver(), "current_sec_active_themepackage") != null;
            boolean z9 = z2 ? this.mIsBlurEnabled : this.mIsDefaultBlurEnabled;
            Drawable drawable = this.mContext.getResources().getDrawable(C0419R.drawable.sesl_dialog_inset_background, this.mContext.getTheme());
            View decorView = this.mWindow.getDecorView();
            if (decorView != null && decorView.getBackground() != null && drawable.getConstantState() != null && !drawable.getConstantState().equals(decorView.getBackground().getConstantState())) {
                z = false;
            }
            if ("FALSE".equalsIgnoreCase(string) || !z9 || z8 || !z) {
                return;
            }
            if (viewFindViewById2 != null && viewFindViewById2.getBackground() == null && !zIsLightTheme) {
                viewFindViewById2.setBackground(this.mContext.getDrawable(C0419R.drawable.sesl_dialog_middle_panel_background));
            }
            SemBlurCompat.setBlurEffectPreset(viewFindViewById, 0, zIsLightTheme ? new SemBlurCompat.CurveParameter(300, 0.75f, 25.0f, 15.0f, 235.0f, 214.6f, 252.8f) : new SemBlurCompat.CurveParameter(300, 0.7f, -15.0f, 0.0f, 235.0f, 36.7f, 87.7f), Integer.valueOf(this.mContext.getColor(C0419R.color.sesl_dialog_blur_background_color)), Float.valueOf(this.mContext.getResources().getDimensionPixelSize(C0419R.dimen.sesl_dialog_background_corner_radius)), (Integer) 0);
        }
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0419R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public Button getButton(int i) {
        if (i == -3) {
            return this.mButtonNeutral;
        }
        if (i == -2) {
            return this.mButtonNegative;
        }
        if (i != -1) {
            return null;
        }
        return this.mButtonPositive;
    }

    public int getIconAttributeResId(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        this.mDialog.setContentView(selectContentView());
        setupView();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && Build.VERSION.SDK_INT > 29 && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && Build.VERSION.SDK_INT > 29 && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public void seslSetBackgroundBlurEnabled(boolean z) {
        this.mIsBlurEnabled = z;
        this.mIsDefaultBlurEnabled = z;
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message;
            this.mButtonNeutralIcon = drawable;
        } else if (i == -2) {
            this.mButtonNegativeText = charSequence;
            this.mButtonNegativeMessage = message;
            this.mButtonNegativeIcon = drawable;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.mButtonPositiveText = charSequence;
            this.mButtonPositiveMessage = message;
            this.mButtonPositiveIcon = drawable;
        }
    }

    public void setButtonPanelLayoutHint(int i) {
        this.mButtonPanelLayoutHint = i;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int i) {
        this.mIcon = null;
        this.mIconId = i;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setSingleChoiceOption(CharSequence charSequence, boolean z, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mSingleChoiceOptionLabel = charSequence;
        this.mSingleChoiceChecked = z;
        this.mSingleChoiceListener = onCheckedChangeListener;
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
        this.mWindow.setTitle(charSequence);
    }

    public void setView(int i) {
        this.mView = null;
        this.mViewLayoutResId = i;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.mIconView.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setView(View view, int i, int i2, int i4, int i5) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i;
        this.mViewSpacingTop = i2;
        this.mViewSpacingRight = i4;
        this.mViewSpacingBottom = i5;
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$5 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C04285 implements AbsListView.OnScrollListener {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        public C04285(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i4) {
            AlertController.manageScrollIndicators(absListView, this.val$top, this.val$bottom);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }
}
