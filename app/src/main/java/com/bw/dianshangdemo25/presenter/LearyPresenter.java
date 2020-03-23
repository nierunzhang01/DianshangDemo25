package com.bw.dianshangdemo25.presenter;

import com.bw.dianshangdemo25.base.BasePresenter;
import com.bw.dianshangdemo25.base.DataCall;
import com.bw.dianshangdemo25.bean.Result;
import com.bw.dianshangdemo25.model.LearyModel;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.22<p>
 * <p>更改时间：2020.3.22<p>
 */
public class LearyPresenter extends BasePresenter {
    public LearyPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getModel(Object[] args) {
        return LearyModel.getnews((int)args[0]);
    }
}
