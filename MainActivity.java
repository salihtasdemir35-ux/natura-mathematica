package com.naturamathematica.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Natura Mathematica: uygulamanın tamamı assets/index.html içindedir.
 * Bu etkinlik onu tam ekran bir WebView içinde, internetsiz olarak açar.
 */
public class MainActivity extends Activity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(this);
        web.setBackgroundColor(Color.WHITE);
        setContentView(web);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);          // simülasyonlar JavaScript ile çalışır
        s.setDomStorageEnabled(true);          // ilerleme, puan ve favoriler (localStorage)
        s.setAllowFileAccess(true);            // assets klasöründeki dosyayı açmak için
        s.setMediaPlaybackRequiresUserGesture(true);
        s.setTextZoom(100);                    // yazı boyutu uygulamanın kendi A−/A+ düğmeleriyle değişir
        s.setUseWideViewPort(true);
        s.setLoadWithOverviewMode(true);
        s.setBuiltInZoomControls(false);

        web.setWebChromeClient(new WebChromeClient()); // onay pencereleri (confirm) için
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri u = request.getUrl();
                if ("file".equals(u.getScheme())) return false; // uygulama içi gezinme
                try { startActivity(new Intent(Intent.ACTION_VIEW, u)); } catch (Exception ignored) { }
                return true; // dış bağlantılar tarayıcıda açılır
            }
        });

        if (savedInstanceState != null) {
            web.restoreState(savedInstanceState);
        } else {
            web.loadUrl("file:///android_asset/index.html");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        web.saveState(outState);
    }

    @Override
    public void onBackPressed() {
        // Geri tuşu önce uygulamadaki bir önceki sayfaya (kategori, simülasyon...) döner.
        if (web.canGoBack()) web.goBack();
        else super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        web.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        web.onResume();
    }

    @Override
    protected void onDestroy() {
        if (web != null) web.destroy();
        super.onDestroy();
    }
}
