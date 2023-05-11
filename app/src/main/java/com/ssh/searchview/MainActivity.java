package com.ssh.searchview;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 타이틀 바 맨 우측에 나타나는 버튼
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_toolbar, menu);

        // 검색 버튼 클릭했을 때 searchview 길이 꽉 차게 늘려주기
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // 검색 버튼 클릭했을 때 searchview에 힌트 추가
        searchView.setQueryHint("프로그램, 영화, 배우 검색...");

        // 검색 리스너 추가
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // 검색어 입력시 이벤트 제어
            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(getApplicationContext(), "입력중입니다.", Toast.LENGTH_SHORT).show();
                return false;
            }

            //검색어 완료시 이벤트 제어 ---> 간단하게 Toast 메시지 출력으로
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(getApplicationContext(), "검색을 완료했습니다.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // 원래 액션바에 달려있는 옵션 메뉴인 ... 세개에 관한 설정
        MenuItem item_like = menu.add(0, 0, 0, "히든 메뉴");
        item_like.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                // Todo : 원하는 제어를 하면 됩니다.
                return true;
            }
        });

        return true;
    }

    //타이틀바 우측에서 두번째, 검색 버튼
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            // Todo : 검색했을 때 쿼리 구현
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}