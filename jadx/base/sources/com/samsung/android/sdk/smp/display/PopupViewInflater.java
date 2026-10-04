package com.samsung.android.sdk.smp.display;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.samsung.android.sdk.smp.C7794R;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PopupViewInflater {
    private static final int CENTER_ALIGN = 2;
    private static final int LEFT_ALIGN = 3;
    private static final int RIGHT_ALIGN = 1;
    private static final String TAG = "PopupViewInflater";
    private static final int VERTICAL_ALIGN = 4;
    private final BackgroundBlurHandler mBackgroundHandler;
    private final OnClickButtonListener mButtonListener;
    private final String mMid;
    private FrameLayout mPopupLayout;
    private View mPopupMarginBottom;
    private View mPopupMarginTop;
    private final OnResultHandler mResultHandler;
    private final int mType;
    private final WindowManager mWindowManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BackgroundBlurHandler {
        void bgOff();

        void bgOn();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickButtonListener {
        void onClickButton(ArrayList<Bundle> arrayList);

        void onClickCloseButton();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnResultHandler {
        void displayFail(FeedbackEvent feedbackEvent, String str);

        void displayFailButRetry();

        void displaySuccess(Bundle bundle);
    }

    public PopupViewInflater(int i, String str, WindowManager windowManager, OnClickButtonListener onClickButtonListener, OnResultHandler onResultHandler, BackgroundBlurHandler backgroundBlurHandler) {
        this.mType = i;
        this.mMid = str;
        this.mWindowManager = windowManager;
        this.mButtonListener = onClickButtonListener;
        this.mResultHandler = onResultHandler;
        this.mBackgroundHandler = backgroundBlurHandler;
    }

    private int getPopupHorizontalMarginByType(int i) {
        if (i == 1) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mWindowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return (displayMetrics.heightPixels * 15) / 100;
        }
        if (i != 3 || 2 == Resources.getSystem().getConfiguration().orientation) {
            return 0;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getMetrics(displayMetrics2);
        return (displayMetrics2.heightPixels * 15) / 100;
    }

    private void initBottomLayout(View view, Bundle bundle) throws InternalException.InvalidArgumentException {
        if (bundle.getBoolean(MarketingConstants.DisplayConst.POP_BOTTOM_VISIBLE)) {
            String string = bundle.getString(MarketingConstants.DisplayConst.POP_BUTTON1_TEXT);
            ArrayList<Bundle> linkList = DisplayManager.getLinkList(bundle, MarketingConstants.DisplayConst.POP_BUTTON1_LINK);
            String string2 = bundle.getString(MarketingConstants.DisplayConst.POP_BUTTON2_TEXT);
            ArrayList<Bundle> linkList2 = DisplayManager.getLinkList(bundle, MarketingConstants.DisplayConst.POP_BUTTON2_LINK);
            int i = bundle.getInt(MarketingConstants.DisplayConst.POP_BUTTON_ALIGN, 1);
            if (TextUtils.isEmpty(string) || linkList.size() <= 0 || (!TextUtils.isEmpty(string2) && linkList2.size() <= 0)) {
                SmpLog.m6494e(TAG, "fail to display. invalid links");
                throw new InternalException.InvalidArgumentException();
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C7794R.id.ppmt_pop_bottom1);
            if (i != 4 || TextUtils.isEmpty(string2)) {
                if (TextUtils.isEmpty(string2)) {
                    i = 2;
                }
                initBottomLayout(linearLayout, bundle, string, linkList, string2, linkList2, i);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C7794R.id.ppmt_pop_bottom2);
                initBottomLayout(linearLayout, bundle, string, linkList, null, null, i);
                initBottomLayout(linearLayout2, bundle, string2, linkList2, null, null, i);
            }
        }
    }

    private void initializeBodyText(View view, Bundle bundle) throws InternalException.InvalidArgumentException {
        CharSequence charSequence = bundle.getCharSequence(MarketingConstants.DisplayConst.POP_BODY_TEXT);
        if (TextUtils.isEmpty(charSequence)) {
            SmpLog.m6495e(TAG, this.mMid, "fail to display. body text not found");
            throw new InternalException.InvalidArgumentException();
        }
        int i = bundle.getInt(MarketingConstants.DisplayConst.POP_COLOR_BODY_TEXT, -570425344);
        TextView textView = DeviceInfoUtil.isArabicStyleLanguage() ? (TextView) view.findViewById(C7794R.id.ppmt_pop_body_message_for_rtl) : (TextView) view.findViewById(C7794R.id.ppmt_pop_body_message);
        textView.setText(charSequence);
        textView.setTextColor(i);
    }

    private void initializeMainImage(View view, Bundle bundle) throws InternalException.InvalidArgumentException {
        String string = bundle.getString(MarketingConstants.DisplayConst.POP_MAIN_IMAGE);
        if (TextUtils.isEmpty(string)) {
            SmpLog.m6495e(TAG, this.mMid, "fail to display. main image not found");
            throw new InternalException.InvalidArgumentException();
        }
        ((ImageView) view.findViewById(C7794R.id.ppmt_pop_main_image)).setImageBitmap(DisplayManager.decodeFile(string));
    }

    private void initializeWebView(View view, final Bundle bundle) throws InternalException.InvalidArgumentException {
        this.mBackgroundHandler.bgOff();
        this.mPopupLayout.setVisibility(8);
        String string = bundle.getString("web");
        if (TextUtils.isEmpty(string)) {
            SmpLog.m6495e(TAG, this.mMid, "fail to display. url not found");
            throw new InternalException.InvalidArgumentException();
        }
        WebView webView = (WebView) view.findViewById(C7794R.id.ppmt_pop_webview);
        webView.setWebViewClient(new WebViewClient() { // from class: com.samsung.android.sdk.smp.display.PopupViewInflater.2
            private boolean mErrorReceived = false;

            /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private void handleError(int i, CharSequence charSequence) {
                SmpLog.m6502w(PopupViewInflater.TAG, PopupViewInflater.this.mMid, "fail to display. error code:" + i + " " + ((Object) charSequence));
                if (this.mErrorReceived) {
                    return;
                }
                if (i != -14 && i != -3) {
                    switch (i) {
                        case -12:
                        case -11:
                        case -10:
                        case -9:
                            break;
                        default:
                            PopupViewInflater.this.mResultHandler.displayFailButRetry();
                            break;
                    }
                } else {
                    PopupViewInflater.this.mResultHandler.displayFail(FeedbackEvent.CONSUME_FAIL, FeedbackDetailConstants.PREFIX_CLIENT_ERROR + i);
                }
                this.mErrorReceived = true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                if (this.mErrorReceived) {
                    return;
                }
                PopupViewInflater.this.mBackgroundHandler.bgOn();
                PopupViewInflater.this.mPopupLayout.setVisibility(0);
                PopupViewInflater.this.mResultHandler.displaySuccess(bundle);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, int i, String str, String str2) {
                super.onReceivedError(webView2, i, str, str2);
                handleError(i, str);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                handleError(webResourceError.getErrorCode(), webResourceError.getDescription());
            }
        });
        webView.loadUrl(string);
        webView.getSettings().setJavaScriptEnabled(true);
    }

    public void inflateView(View view, Bundle bundle) throws InternalException.InvalidArgumentException {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C7794R.id.ppmt_pop_layout);
        this.mPopupLayout = frameLayout;
        frameLayout.setBackgroundColor(bundle.getInt(MarketingConstants.DisplayConst.POP_COLOR_BG, MarketingConstants.PopupConst.DEFAULT_COLOR_BACKGROUND));
        int popupHorizontalMarginByType = getPopupHorizontalMarginByType(this.mType);
        this.mPopupMarginTop = view.findViewById(C7794R.id.ppmt_pop_layout_margin_top);
        this.mPopupMarginBottom = view.findViewById(C7794R.id.ppmt_pop_layout_margin_bottom);
        this.mPopupMarginTop.setLayoutParams(new TableRow.LayoutParams(-1, popupHorizontalMarginByType));
        this.mPopupMarginBottom.setLayoutParams(new TableRow.LayoutParams(-1, popupHorizontalMarginByType));
        ImageButton imageButton = (ImageButton) view.findViewById(C7794R.id.ppmt_pop_close_btn);
        if (bundle.getBoolean(MarketingConstants.DisplayConst.POP_CLOSE_BUTTON_VISIBLE)) {
            if (DeviceInfoUtil.isArabicStyleLanguage()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageButton.getLayoutParams();
                layoutParams.gravity = 51;
                imageButton.setLayoutParams(layoutParams);
            }
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.smp.display.PopupViewInflater.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PopupViewInflater.this.mButtonListener.onClickCloseButton();
                }
            });
        } else {
            imageButton.setVisibility(8);
        }
        initBottomLayout(view, bundle);
        int i = this.mType;
        if (4 == i) {
            initializeWebView(view, bundle);
            return;
        }
        if (i == 1) {
            initializeBodyText(view, bundle);
        } else if (i == 2) {
            initializeMainImage(view, bundle);
        } else if (i == 3) {
            initializeBodyText(view, bundle);
            initializeMainImage(view, bundle);
        }
        this.mBackgroundHandler.bgOn();
        this.mResultHandler.displaySuccess(bundle);
    }

    public void onConfigurationChnaged() {
        int popupHorizontalMarginByType = getPopupHorizontalMarginByType(this.mType);
        this.mPopupMarginTop.setLayoutParams(new TableRow.LayoutParams(-1, popupHorizontalMarginByType));
        this.mPopupMarginBottom.setLayoutParams(new TableRow.LayoutParams(-1, popupHorizontalMarginByType));
    }

    private void initBottomLayout(LinearLayout linearLayout, Bundle bundle, String str, final ArrayList<Bundle> arrayList, String str2, final ArrayList<Bundle> arrayList2, int i) {
        TextView textView;
        LinearLayout linearLayout2;
        TextView textView2;
        LinearLayout linearLayout3;
        int i2 = bundle.getInt(MarketingConstants.DisplayConst.POP_COLOR_BOTTOM, MarketingConstants.PopupConst.DEFAULT_COLOR_BOTTOM);
        int i4 = bundle.getInt(MarketingConstants.DisplayConst.POP_COLOR_LINE, MarketingConstants.PopupConst.DEFAULT_COLOR_LINE);
        int i5 = bundle.getInt(MarketingConstants.DisplayConst.POP_COLOR_BUTTON_TEXT, -570425344);
        linearLayout.setVisibility(0);
        linearLayout.setBackgroundColor(i2);
        linearLayout.findViewById(C7794R.id.ppmt_pop_line).setBackgroundColor(i4);
        if (DeviceInfoUtil.isArabicStyleLanguage()) {
            textView = (TextView) linearLayout.findViewById(C7794R.id.ppmt_pop_button2_text);
            linearLayout2 = (LinearLayout) linearLayout.findViewById(C7794R.id.ppmt_pop_button2);
        } else {
            textView = (TextView) linearLayout.findViewById(C7794R.id.ppmt_pop_button1_text);
            linearLayout2 = (LinearLayout) linearLayout.findViewById(C7794R.id.ppmt_pop_button1);
        }
        textView.setText(str);
        textView.setTextColor(i5);
        linearLayout2.setVisibility(0);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.smp.display.PopupViewInflater.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopupViewInflater.this.mButtonListener.onClickButton(arrayList);
            }
        });
        if (i == 2 || i == 4) {
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (DeviceInfoUtil.isArabicStyleLanguage()) {
            textView2 = (TextView) linearLayout.findViewById(C7794R.id.ppmt_pop_button1_text);
            linearLayout3 = (LinearLayout) linearLayout.findViewById(C7794R.id.ppmt_pop_button1);
        } else {
            textView2 = (TextView) linearLayout.findViewById(C7794R.id.ppmt_pop_button2_text);
            linearLayout3 = (LinearLayout) linearLayout.findViewById(C7794R.id.ppmt_pop_button2);
        }
        textView2.setText(bundle.getString(MarketingConstants.DisplayConst.POP_BUTTON2_TEXT));
        textView2.setTextColor(i5);
        linearLayout3.setVisibility(0);
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.smp.display.PopupViewInflater.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopupViewInflater.this.mButtonListener.onClickButton(arrayList2);
            }
        });
        LinearLayout linearLayout4 = (LinearLayout) linearLayout.findViewById(C7794R.id.ppmt_pop_button_layout);
        if (i == 1) {
            linearLayout4.setGravity(5);
            linearLayout.findViewById(C7794R.id.ppmt_pop_button_margin1).setVisibility(0);
            linearLayout.findViewById(C7794R.id.ppmt_pop_button_margin2).setVisibility(0);
            linearLayout.findViewById(C7794R.id.ppmt_pop_button_margin3).setVisibility(0);
            return;
        }
        if (i == 2) {
            linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
            View viewFindViewById = linearLayout.findViewById(C7794R.id.ppmt_pop_line_for_centeralign);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setBackgroundColor(i4);
            return;
        }
        if (i != 3) {
            return;
        }
        linearLayout4.setGravity(3);
        linearLayout.findViewById(C7794R.id.ppmt_pop_button_margin1).setVisibility(0);
        linearLayout.findViewById(C7794R.id.ppmt_pop_button_margin2).setVisibility(0);
        linearLayout.findViewById(C7794R.id.ppmt_pop_button_margin3).setVisibility(0);
    }
}
