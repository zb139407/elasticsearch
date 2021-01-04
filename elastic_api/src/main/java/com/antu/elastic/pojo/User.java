package com.antu.elastic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Document(indexName = "antu_index", type = "_doc", replicas = 0)
public class User {
    private String name;
    private int age;
}
