package com.aiyonghui.widget.ElasticRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lgd(1973140289@qq.com)
 * Date: 2017-03-26
 * Function:
 */
class MockData {
    static final List<String> DATA = new ArrayList<>(10);

    static {
        for (int i = 0; i < 20; i++) {
            DATA.add(String.valueOf((char) ('A' + i)));
        }
    }
}
