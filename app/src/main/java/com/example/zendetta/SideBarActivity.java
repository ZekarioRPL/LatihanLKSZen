package com.example.zendetta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.zendetta.Fragment.HistoryFragment;
import com.example.zendetta.Fragment.SceduleFragment;
import com.example.zendetta.Fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SideBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_bar);

        replaceFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.Navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.schedule:
                    replaceFragment(new SceduleFragment());
                    break;
                case R.id.history:
                    replaceFragment(new HistoryFragment());
                    break;
                case R.id.user:
                    replaceFragment(new UserFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FragmentLayout, fragment);
        fragmentTransaction.commit();
    }
}