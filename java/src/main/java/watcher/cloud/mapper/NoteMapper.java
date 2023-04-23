package watcher.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import watcher.cloud.dto.NoteQueryDto;
import watcher.cloud.entity.Note;
import watcher.cloud.vo.NoteListVo;

import java.util.List;

@Repository
public interface NoteMapper extends BaseMapper<Note> {

    List<NoteListVo> getList(@Param("queryDto")NoteQueryDto queryDto);

    NoteListVo detail(@Param("id") String id);
}
