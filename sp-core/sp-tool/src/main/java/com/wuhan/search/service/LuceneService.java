
package com.wuhan.search.service;


import com.wuhan.sp.api.vo.search.IndexObject;
import com.wuhan.sp.common.msg.TableResultResponse;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public interface LuceneService {

    void save(IndexObject indexObject);

    void update(IndexObject indexObject);

    void delete(IndexObject indexObject);

    void deleteAll();

    TableResultResponse page(Integer pageNumber, Integer pageSize, String keyword);
}
