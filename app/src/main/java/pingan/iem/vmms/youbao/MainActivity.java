package pingan.iem.vmms.youbao;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Bundle bundle ;
    Intent intent ;
    Button btn ;
    ComponentName component;
    //要调用另一个APP的activity所在的包名
    String packageName = "pingan.iem.vmms.fep";
    //要调用另一个APP的activity名字
    String activity = "pingan.iem.vmms.fep.MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn_jump);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                bundle = new Bundle();
                intent = new Intent();
                bundle.putString("commodityId", "this message is from project YOUBAO ");
                bundle.putString("commodityName","name");
                bundle.putString("commodityPrice","name");
                bundle.putString("venderSite","site");
                bundle.putString("venderNum","num");
                intent.putExtras(bundle);
//                intent.putExtra("pid", android.os.Process.myPid());
                component = new ComponentName(packageName, activity);
                intent.setComponent(component);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                startActivityForResult(intent, 1);



            }

        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    btn.setText(data.getStringExtra("result"));
                }
                break;
        }
    }
}
