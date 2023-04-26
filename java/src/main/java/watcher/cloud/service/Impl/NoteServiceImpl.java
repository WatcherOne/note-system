package watcher.cloud.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watcher.cloud.domain.convert.NoteConvert;
import watcher.cloud.dto.NoteAddDto;
import watcher.cloud.dto.NoteQueryDto;
import watcher.cloud.dto.NoteUpdateDto;
import watcher.cloud.entity.Note;
import watcher.cloud.mapper.NoteMapper;
import watcher.cloud.service.NoteService;
import watcher.cloud.vo.NoteListVo;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<NoteListVo> getList(NoteQueryDto queryDto) {
        return noteMapper.getList(queryDto);
    }

    @Override
    public int add(NoteAddDto addDto) {
        Note note = NoteConvert.INSTANCE.convert(addDto);
        note.setCreateBy("watcher");
        note.setCreateTime(LocalDateTime.now());
        return noteMapper.insert(note);
    }

    @Override
    public int edit(NoteUpdateDto updateDto) {
        Note note = this.getById(updateDto.getId());
        NoteConvert.INSTANCE.convert(updateDto, note);
        note.setUpdateBy("watcher");
        note.setUpdateTime(LocalDateTime.now());
        return noteMapper.updateById(note);
    }

    @Override
    public NoteListVo detail(String id) {
        return noteMapper.detail(id);
    }
}
