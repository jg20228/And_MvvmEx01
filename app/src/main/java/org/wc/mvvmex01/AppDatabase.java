package org.wc.mvvmex01;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//여기는 엄격해서 바뀔때마다 버전을 올려가면서 해야함. ex)스키마
@Database(entities = {User.class},version =2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

}
