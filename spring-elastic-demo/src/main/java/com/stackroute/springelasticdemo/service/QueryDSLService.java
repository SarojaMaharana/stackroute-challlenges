package com.stackroute.springelasticdemo.service;

import com.stackroute.springelasticdemo.model.Customer;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryDSLService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public SearchHits<Customer> searchMultiField(String fName, int age) {
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("fName", fName)).must(QueryBuilders.matchQuery("age", age));
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
//        List<Customer> customerList = (List<Customer>) elasticsearchRestTemplate.queryForObject(nativeSearchQuery, Customer.class);
        return elasticsearchRestTemplate.search(nativeSearchQuery, Customer.class);
    }
}
