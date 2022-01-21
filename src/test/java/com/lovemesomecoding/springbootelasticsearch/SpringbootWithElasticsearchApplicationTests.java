package com.lovemesomecoding.springbootelasticsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lovemesomecoding.es.user.User;
import com.lovemesomecoding.es.utils.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SpringbootWithElasticsearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void searchWithTerm() {

        String firstName = "Edwin";

        log.info("firstName={}", firstName);

        int pageNumber = 0;
        int pageSize = 10;

        SearchRequest searchRequest = new SearchRequest("sb_with_es_user");
        searchRequest.allowPartialSearchResults(true);
        searchRequest.indicesOptions(IndicesOptions.lenientExpandOpen());

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(pageNumber * pageSize);
        searchSourceBuilder.size(pageSize);
        searchSourceBuilder.timeout(new org.elasticsearch.core.TimeValue(60, TimeUnit.SECONDS));

        /**
         * fetch only a few fields
         */
        // searchSourceBuilder.fetchSource(new String[]{ "id", "firstName", "lastName", "cards" }, new String[]{""});

        /**
         * Query
         */

        /**
         * Filter<br>
         * term query looks for exact match. Use keyword
         */

        searchSourceBuilder.query(QueryBuilders.termQuery("firstName.keyword", firstName));

        searchRequest.source(searchSourceBuilder);

        searchRequest.preference("firstName");

        if (searchSourceBuilder.sorts() != null && searchSourceBuilder.sorts().size() > 0) {
            log.info("\n{\n\"query\":{}, \"sort\":{}\n}", searchSourceBuilder.query().toString(), searchSourceBuilder.sorts().toString());
        } else {
            log.info("\n{\n\"query\":{}\n}", searchSourceBuilder.query().toString());
        }

        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

            log.info("isTimedOut={}, totalShards={}, totalHits={}", searchResponse.isTimedOut(), searchResponse.getTotalShards(), searchResponse.getHits().getTotalHits().value);

            List<User> users = getResponseResult(searchResponse.getHits());

            log.info(ObjectUtils.toJson(users));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private List<User> getResponseResult(SearchHits searchHits) {

        Iterator<SearchHit> it = searchHits.iterator();

        List<User> searchResults = new ArrayList<>();

        while (it.hasNext()) {
            SearchHit searchHit = it.next();
            // log.info("sourceAsString={}", searchHit.getSourceAsString());
            try {

                User obj = ObjectUtils.getObjectMapper().readValue(searchHit.getSourceAsString(), new TypeReference<User>() {});
                // log.info("obj={}", ObjectUtils.toJson(obj));

                searchResults.add(obj);
            } catch (IOException e) {
                log.warn("IOException, msg={}", e.getLocalizedMessage());
            }
        }

        return searchResults;

    }
}
