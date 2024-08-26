package com.nkdev.isp.repo;

import com.nkdev.isp.model.ApplicationModel;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends ElasticsearchRepository<ApplicationModel, Long> {

}
