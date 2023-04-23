package watcher.cloud.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NoteAddDto implements Serializable {

    @NotNull("笔记标题不可为空")
    private String title;

    private String label;

    private Integer type;

    @NotNull("笔记内容不可为空")
    private String content;
}
