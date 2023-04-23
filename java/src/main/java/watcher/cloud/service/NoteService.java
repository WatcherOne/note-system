package watcher.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import watcher.cloud.dto.NoteAddDto;
import watcher.cloud.dto.NoteQueryDto;
import watcher.cloud.entity.Note;
import watcher.cloud.vo.NoteListVo;

import java.util.List;

public interface NoteService extends IService<Note> {

    /**
     * 获得note列表
     * @return
     * @param queryDto
     */
    List<NoteListVo> getList(NoteQueryDto queryDto);

    /**
     * 新增note
     * @param addDto
     * @return
     */
    int add(NoteAddDto addDto);

    /**
     * 获得note详细
     * @param id
     * @return
     */
    NoteListVo detail(String id);
}
