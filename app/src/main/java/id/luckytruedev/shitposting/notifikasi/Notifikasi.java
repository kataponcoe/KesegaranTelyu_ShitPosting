package id.luckytruedev.shitposting.notifikasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import id.luckytruedev.shitposting.R;

/**
 * Created by Poncoe on 26/12/16.
 */

public class Notifikasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifikasi);

        String openURL = getIntent().getStringExtra("openURL");


        Button onBackButton = (Button)(findViewById(R.id.back));
        onBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        WebView webView = (WebView)(findViewById(R.id.webview));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        if (openURL == null) {
            webView.loadUrl("https://luckytruedev.com");
        } else {
            webView.loadUrl(openURL);
        }


    }
}