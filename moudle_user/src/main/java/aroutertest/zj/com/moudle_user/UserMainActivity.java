package aroutertest.zj.com.moudle_user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/user/usermainactivity")
public class UserMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        findViewById(R.id.tv_center).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/home/mainactivity").navigation();
            }

        });

    }
}
