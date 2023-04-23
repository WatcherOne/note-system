package watcher.cloud.domain.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import watcher.cloud.dto.NoteAddDto;
import watcher.cloud.entity.Note;

@Mapper
public interface NoteConvert {

    NoteConvert INSTANCE = Mappers.getMapper(NoteConvert.class);

    Note convert(NoteAddDto bean);
}
