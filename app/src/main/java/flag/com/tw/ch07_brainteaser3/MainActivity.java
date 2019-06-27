package flag.com.tw.ch07_brainteaser3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] queArr = {"什麼門關不上", "什麼東西沒人愛吃",
            "什麼瓜不能吃", "什麼布切不斷",
            "什麼老鼠最環保", "偷什麼不犯法"};
    String[] ansArr = {"球門", "吃虧",
            "傻瓜", "瀑布",
            "環保署", "偷笑"};
    Toast tos;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, queArr);
       ListView lv = (ListView) findViewById(R.id.lv);

       lv.setAdapter(adapter);//設定ListView使用的Adapter
       lv.setOnItemClickListener(this);//監聽選擇到那一項

       tos = Toast.makeText(this, " ", Toast.LENGTH_SHORT);
       tos.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 50);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, "答案" + ansArr[i], Toast.LENGTH_SHORT).show();
        /*tos.setText("答案" + ansArr[i]);

        if(i % 2 == 0) tos.setDuration(Toast.LENGTH_SHORT);
        else tos.setDuration(Toast.LENGTH_LONG);

        tos.show();*/

        Snackbar.make(findViewById(R.id.root), "答案" + ansArr[i], Snackbar.LENGTH_SHORT).show();
    }
}
