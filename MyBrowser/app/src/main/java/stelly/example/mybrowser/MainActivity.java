package stelly.example.mybrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private String webSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWebview();

    }

    private void initWebview(){
        webView=(WebView)findViewById(R.id.my_browser_web_view);

        webSite=getIntent().getStringExtra("website");

        //自定义Client
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

        });

        Log.i("+++++++",webSite+"");

        webView.loadUrl(webSite);

    }



}
