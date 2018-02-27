package aroutertest.zj.com.zjaop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import aroutertest.zj.com.zjaop.aspectj.CheckLogin;

@Route(path = "/app/mainactivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance().build("/home/mainactivity").navigation();

//              // 2. 跳转并携带参数
//              ARouter.getInstance().build("/test/1")
//                        .withLong("key1", 666L)
//                        .withString("key3", "888")
//                        .withObject("key4", new Test("Jack", "Rose"))
//                        .navigation();

            }

        });
    }

    @CheckLogin()
    public void percheck(View view) {
        System.out.println("Hello, I am 权限检查");
    }

    @CheckLogin()
    public void logincheck(View view) {
        System.out.println("Hello, I am 登录检查");
    }

}
