

package com.wuhan.config;


import com.wuhan.search.lucene.LuceneDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Configuration
public class LuceneConfiguration {
    @Value("${search.lucence.path}")
    private String lucencePath;

    @Bean
    public LuceneDao luceneUtil() throws IOException {
        LuceneDao luceneDao = new LuceneDao();
        luceneDao.setIndexDer(lucencePath);
        return luceneDao;
    }

}
