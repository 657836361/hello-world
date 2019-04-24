package com.guanpei.junit.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable// entity --orm--- db_table
{

    private static final long serialVersionUID = -6859508100413563965L;
    /**
     * 主键
     */
    private Long deptno;
    /**
     * 部门名称
     */
    private String dname;
    /**
     * 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
     */
    private String db_source;

}
