package watcher.cloud.domain.convert;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import watcher.cloud.dto.NoteAddDto;
import watcher.cloud.dto.NoteUpdateDto;
import watcher.cloud.entity.Note;

@Mapper
public interface NoteConvert {

    NoteConvert INSTANCE = Mappers.getMapper(NoteConvert.class);

    Note convert(NoteAddDto bean);

    void convert(NoteUpdateDto bean, @MappingTarget Note target);
}
