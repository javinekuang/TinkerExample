package javine.com.tinkerexample;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn_load;
    boolean isFirst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv_content);
        btn_load = (Button) findViewById(R.id.btn_load);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText();
            }
        });
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPatch();
            }
        });
    }

    private void loadPatch() {
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
    }

    private void changeText() {
        String str = "From Tinker at :"+System.currentTimeMillis();
        textView.setText(str);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);
        if (!isFirst){
            isFirst = true;
            Toast.makeText(this,"This String from new Patch!",Toast.LENGTH_SHORT).show();
        }
    }
}
