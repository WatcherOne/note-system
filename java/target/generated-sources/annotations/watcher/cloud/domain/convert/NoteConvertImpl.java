package watcher.cloud.domain.convert;

import javax.annotation.Generated;
import watcher.cloud.dto.NoteAddDto;
import watcher.cloud.entity.Note;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T13:19:30+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_222-4-redhat (Oracle Corporation)"
)
public class NoteConvertImpl implements NoteConvert {

    @Override
    public Note convert(NoteAddDto bean) {
        if ( bean == null ) {
            return null;
        }

        Note note = new Note();

        note.setTitle( bean.getTitle() );
        note.setLabel( bean.getLabel() );
        note.setType( bean.getType() );
        note.setContent( bean.getContent() );

        return note;
    }
}
