package com.bw.dianshangdemo25.model;

import com.bw.dianshangdemo25.bean.LearyBean;
import com.bw.dianshangdemo25.bean.Result;
import com.bw.dianshangdemo25.util.NetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.22<p>
 * <p>更改时间：2020.3.22<p>
 */
public class LearyModel {
    public static Result<LearyBean> getnews(int page){
        final String string = NetUtil.getInstance().doGet("http://blog.zhaoliang5156.cn/api/news/lawyer.json");
        final Gson gson = new Gson();
        final Type type = new TypeToken<Result<LearyBean>>() {}.getType();
        Result<LearyBean> data = gson.fromJson(string, type);
        return data;
    }
}
