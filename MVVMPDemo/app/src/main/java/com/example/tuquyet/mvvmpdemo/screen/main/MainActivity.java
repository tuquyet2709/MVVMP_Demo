package com.example.tuquyet.mvvmpdemo.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tuquyet.mvvmpdemo.R;
import com.example.tuquyet.mvvmpdemo.data.source.TaskRepository;
import com.example.tuquyet.mvvmpdemo.data.source.local.TaskLocalDataSource;
import com.example.tuquyet.mvvmpdemo.databinding.ActivityMainBinding;
import com.example.tuquyet.mvvmpdemo.screen.BaseActivity;
import com.example.tuquyet.mvvmpdemo.screen.ViewModel.MainViewModel;

public class MainActivity extends BaseActivity {
    private MainViewModel mViewModel;
    private MainContract.Presenter mPresenter;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout
            .activity_main);
        mViewModel = new MainViewModel(this);
        binding.setViewModel(mViewModel);
        mPresenter = new MainPresenter(mViewModel, new TaskRepository(new TaskLocalDataSource
            (this)));

    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getAllTask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_add)
            mViewModel.onAddTaskClick();
        return super.onOptionsItemSelected(item);
    }

}
