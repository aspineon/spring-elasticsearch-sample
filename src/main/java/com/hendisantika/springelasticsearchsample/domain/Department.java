package com.hendisantika.springelasticsearchsample.domain;

import lombok.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/12/19
 * Time: 06.22
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;
}
