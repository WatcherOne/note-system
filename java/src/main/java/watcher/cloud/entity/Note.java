package watcher.cloud.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 下面注解是 lombok 提供的简化功能
 * @Data - 生成 getter,setter,toString等函数
 * @NoArgsConstructor  - 生成无参构造函数
 * @AllArgsConstructor - 生成有参构造函数
 * @Accessors(chain = true)  - 表示实体类可以链式调用 .set<> 方法
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("note")
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("title")
    private String title;

    @TableField("label")
    private String label;

    @TableField("type")
    private Integer type;

    @TableField("content")
    private String content;

    @TableField("create_by")
    private String createBy;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
