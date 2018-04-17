
package com.wuhan.search.service.impl;

import com.wuhan.search.lucene.LuceneDao;
import com.wuhan.search.service.LuceneService;
import com.wuhan.sp.api.vo.search.IndexObject;
import com.wuhan.sp.common.msg.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Service
public class LuceneServiceImpl implements LuceneService {

    @Autowired
    private LuceneDao luceneDao;


    @Override
    public void save(IndexObject indexObject) {
        luceneDao.create(indexObject);
    }


    @Override
    public void update(IndexObject indexObject) {
        luceneDao.update(indexObject);
    }

    @Override
    public void delete(IndexObject indexObject) {
        luceneDao.delete(indexObject);
    }

    @Override
    public void deleteAll() {
        luceneDao.deleteAll();
    }

    @Override
    public TableResultResponse page(Integer pageNumber, Integer pageSize, String keyword) {
        return luceneDao.page(pageNumber,pageSize,keyword);
    }
}
