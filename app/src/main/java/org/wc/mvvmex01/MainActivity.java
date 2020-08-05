package org.wc.mvvmex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //문서
        //getApplicationContext 넣는 이유는 모든 액티비티에서 사용해야하기 때문에
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db-cos")
                .fallbackToDestructiveMigration() //스키마의 변경이 필요하다면
                .allowMainThreadQueries() // 메인쓰레드에서 DB에 IO를가능하게 해줌 (원랜 새로 만들어야함)
                .build();
        //이거 시작될때 db-cos라는 이름으로 만들어지고 Room을 사용한다는것을 알고 UserDao를 메모리에 띄어줌
        userDao = db.userDao();

        //앱을 만들다보면 내부데이터를 쓸때가 많음
        User user = new User("PERFUME","CITRUS");
        userDao.insertAll(user);
        Log.d(TAG, "onCreate: 데이터가 잘 저장 되었습니다.");

        List<User> users = userDao.findAll();
        Log.d(TAG, "onCreate: "+users);

        User findUser = userDao.findById(1);
        Log.d(TAG, "onCreate: "+findUser);
        //비회원 또는
    }
}