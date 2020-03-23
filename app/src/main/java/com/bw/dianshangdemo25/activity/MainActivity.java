package com.bw.dianshangdemo25.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bw.dianshangdemo25.R;
import com.bw.dianshangdemo25.adapter.MyAdapter;
import com.bw.dianshangdemo25.base.BaseActivity;
import com.bw.dianshangdemo25.base.DataCall;
import com.bw.dianshangdemo25.bean.LearyBean;
import com.bw.dianshangdemo25.bean.Result;
import com.bw.dianshangdemo25.presenter.LearyPresenter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends BaseActivity implements DataCall<LearyBean> {
PullToRefreshListView pullToRefreshListView;
MyAdapter myAdapter;
LearyPresenter learyPresenter;
int page=1;


    @Override
    protected void initView() {
        learyPresenter=new LearyPresenter(this);
        pullToRefreshListView=findViewById(R.id.pulllllllllll);
        myAdapter=new MyAdapter();
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setAdapter(myAdapter);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
               page=1;
               learyPresenter.Result(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
            page++;
            learyPresenter.Result(page);
            }
        });
        learyPresenter.Result(page);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void serssec(Result<LearyBean> result) {
        pullToRefreshListView.onRefreshComplete();
        if (result.code==200){
            if (page==1){
                myAdapter.clear();
            }
            myAdapter.addAll(result.listdata);
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void feil() {
pullToRefreshListView.onRefreshComplete();
    }
}
