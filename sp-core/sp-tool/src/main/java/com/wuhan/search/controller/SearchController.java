
package com.wuhan.search.controller;

import com.wuhan.search.service.LuceneService;
import com.wuhan.sp.api.vo.search.IndexObject;
import com.wuhan.sp.common.msg.ObjectRestResponse;
import com.wuhan.sp.common.msg.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private LuceneService luceneService;

    @RequestMapping(value = "/w/{word}", method = RequestMethod.GET)
    public TableResultResponse<IndexObject> search(@PathVariable String word, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize) {
        return luceneService.page(pageNumber, pageSize, word);
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ObjectRestResponse createIndexObject(@RequestBody IndexObject indexObject) {
        luceneService.save(indexObject);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/index", method = RequestMethod.DELETE)
    public ObjectRestResponse removeIndexObject(@RequestBody IndexObject indexObject) {
        luceneService.delete(indexObject);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/index", method = RequestMethod.PATCH)
    public ObjectRestResponse batchCreateIndexObject(@RequestBody List<IndexObject> indexObjects) {
        for (IndexObject object : indexObjects) {
            luceneService.save(object);
        }
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/index", method = RequestMethod.PUT)
    public ObjectRestResponse updateIndexObject(@RequestBody IndexObject indexObject) {
        luceneService.update(indexObject);
        return new ObjectRestResponse();
    }

}
