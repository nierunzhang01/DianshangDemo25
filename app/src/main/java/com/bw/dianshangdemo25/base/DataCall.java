package com.bw.dianshangdemo25.base;

import com.bw.dianshangdemo25.bean.Result;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.22<p>
 * <p>更改时间：2020.3.22<p>
 */
public interface DataCall<T> {
    void serssec(Result<T> result);
    void feil();
}
