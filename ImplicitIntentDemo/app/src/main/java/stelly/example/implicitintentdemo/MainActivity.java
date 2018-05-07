package stelly.example.implicitintentdemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

//    private TextView defaultBrowser;

    private EditText editText;

    private String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.open_web_site_by_mybrowser_tv);
//        textView=(TextView)findViewById(R.id.open_web_site_by_default_browser_tv);

        editText=(EditText)findViewById(R.id.activity_main_website_et);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Uri content_url ;//= Uri.parse("此处填链接");

                if (editText.getText().toString().isEmpty()){
                    website ="http://www.baidu.com";
                    content_url = Uri.parse(website);
                }else {
                    website=editText.getText().toString().trim();
                    content_url = Uri.parse(website);
                }

//                Intent intent ;//= new Intent("android.intent.action.VIEW");
//                intent = new Intent(Intent.ACTION_VIEW, content_url);
//                intent.addCategory(Intent.CATEGORY_DEFAULT);
//
//                intent.putExtra("url",website);
//
//                intent.setData(content_url);
//                //startActivity(intent);
//                PackageManager pm = getPackageManager();
//                List<ResolveInfo> resolveList = pm.queryIntentActivities(intent, PackageManager.MATCH_ALL);
//                Log.i("MainActivity", "resolveList size:"+resolveList.size());
//                if(resolveList.size() > 0) {
//                    String title = "choose application";
//                    Intent intentChooser = Intent.createChooser(intent, title);
//                    startActivity(intentChooser);
//                }else {
//                    Toast.makeText(MainActivity.this, "no match activity to start!", Toast.LENGTH_SHORT).show();
//                }


                Intent intent = new Intent(Intent.ACTION_VIEW, content_url);

                intent.putExtra("website", website);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);

            }
        });

    }
}
